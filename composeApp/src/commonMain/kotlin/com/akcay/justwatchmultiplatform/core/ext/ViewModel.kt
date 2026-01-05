package com.akcay.justwatchmultiplatform.core.ext

import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.produceState
import androidx.compose.runtime.remember
import androidx.lifecycle.ViewModel
import com.akcay.justwatchmultiplatform.core.ApiResult
import com.akcay.justwatchmultiplatform.core.ErrorResponse
import com.akcay.justwatchmultiplatform.core.onFailure
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow
import org.jetbrains.compose.resources.StringResource

private const val MESSAGE_KEY = "message"
private const val PROGRESS_KEY = "progress"

val ViewModel.errorMessage: Flow<Message?>
    get() {
        return getMessageChannel().receiveAsFlow()
    }

val ViewModel.progress: State<Boolean>
    @Composable get() {
        val channel = remember { getProgressChannel() }
        return produceState(false, channel) {
            var counter = 0

            for (event in channel) {
                if (event) {
                    counter++
                    value = true
                } else {
                    if (counter > 0) counter--
                    if (counter == 0) value = false
                }
            }
        }
    }

data class Message(val headline: StringResource?, val message: StringResource?)

fun ViewModel.showMessage(headline: StringResource? = null, message: StringResource) {
    getMessageChannel().trySend(Message(headline, message))
}

fun ViewModel.showProgress(visible: Boolean) {
    getProgressChannel().trySend(visible)
}

suspend inline fun <T> ViewModel.execute(
    crossinline executor: suspend () -> ApiResult<T, ErrorResponse>
): ApiResult<T, ErrorResponse> {
    showProgress(true)
    val result = executor()
    showProgress(false)
    return result
}

private fun ViewModel.getMessageChannel(): ClosableChannel<Message> {
    return getCloseable(MESSAGE_KEY)
        ?: ClosableChannel(Channel<Message>(Channel.UNLIMITED)).also {
            addCloseable(MESSAGE_KEY, it)
        }
}

private fun ViewModel.getProgressChannel(): ClosableChannel<Boolean> {
    return getCloseable(PROGRESS_KEY)
        ?: ClosableChannel(Channel<Boolean>(Channel.UNLIMITED)).also {
            addCloseable(PROGRESS_KEY, it)
        }
}

private class ClosableChannel<T>(private val channel: Channel<T>) : Channel<T> by channel, AutoCloseable {
    override fun close() {
        channel.close()
        channel.cancel()
    }
}
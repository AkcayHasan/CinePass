package com.akcay.justwatchmultiplatform.core.ext

import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.receiveAsFlow

class EventDelegate<E> {
    private val channel = Channel<E>(Channel.BUFFERED)
    val events: Flow<E> = channel.receiveAsFlow()

    suspend fun send(event: E) {
        channel.send(event)
    }

    fun trySend(event: E) {
        channel.trySend(event)
    }
}
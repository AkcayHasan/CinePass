package com.akcay.cinepass.screens.genre

class GenreUiState

data class GenreModel(
    val title: String,
    val icon: String,
)

val genreList = listOf(
    GenreModel("Action", "⚡️"),
    GenreModel("Sci-Fi", "🗺️️"),
    GenreModel("Horror", "🎃️"),
    GenreModel("Thriller", "⚡️"),
    GenreModel("Comedy", "⚡️"),
    GenreModel("Romance", "⚡️"),
    GenreModel("Drama", "⚡️"),
    GenreModel("Mystery", "⚡️"),
    GenreModel("Biography", "⚡️"),
    GenreModel("History", "⚡️"),
    GenreModel("Animation", "⚡️"),
)
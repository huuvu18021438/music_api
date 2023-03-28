package com.github.music_api.model

import org.springframework.data.annotation.Id

data class Song(
        @Id
        val id: Int,
        val name: String,
        val genre: String,
        val author: String,
        val releaseYear: Int,
        val singer: String,
        val vote: Int,
        val lyric: String,
)

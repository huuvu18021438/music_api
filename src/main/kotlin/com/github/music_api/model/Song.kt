package com.github.music_api.model

import io.r2dbc.postgresql.codec.Json
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table


enum class MusicGenre {
    Pop, Rock, EDM, Country, Dance
}

@Table("songs")
data class Song(
    @Id
    var id: Int?,
    val name: String,
    val genre: MusicGenre,
    val author: String,
    val releaseYear: Int,
    val singer: String,
    val vote: Int,
    val lyric: String?,
    val imageUri: String?,
    val albumId: Int,
    val fileId: Int,
    val metaData: Map<String, String>?,
)

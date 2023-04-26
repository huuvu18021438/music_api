package com.github.music_api.model

import lombok.Builder
import lombok.Value
import org.springframework.data.annotation.Id
import org.springframework.data.annotation.Immutable
import org.springframework.data.relational.core.mapping.Column
import org.springframework.data.relational.core.mapping.Table


enum class MusicGenre {
    Pop, Rock, EDM, Country, Dance
}

@Table(name = "songs")
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
    @Column("image")
    val imageUri: String?,
    val albumId: Int,
    val fileId: Int,
    val metaData: Map<String, Any>,
)

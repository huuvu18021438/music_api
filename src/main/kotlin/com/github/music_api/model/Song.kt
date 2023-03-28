package com.github.music_api.model

import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

//create genre enums
@Table("songs")
data class Song(
    @Id
    val id: Int,
    val name: String,
    val genre: String,
    val author: String,
    val releaseYear: Int,
    val singer: String,
    val vote: Int,
    val lyric: String?,
//        val audit: AuditMetadata
)

package com.github.music_api.model

import lombok.*
import org.springframework.data.annotation.Id
import org.springframework.data.relational.core.mapping.Table

@Table(name = "playlists")
@Data @NoArgsConstructor
@RequiredArgsConstructor
data class Playlist(
        @Id
        var id: Int,
        val name: String,
        val username: String,
        val metaData: Map<String, Any>,
        @Transient
        val setSongs: MutableList<Song> = mutableListOf()
)

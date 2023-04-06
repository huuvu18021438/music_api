package com.github.music_api.repository

import com.github.music_api.model.Song
import org.springframework.data.r2dbc.repository.Query
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository
import reactor.core.publisher.Flux

@Repository
interface SongRepository : R2dbcRepository<Song, Int> {
    @Query("SELECT * FROM songs WHERE name LIKE '%:query%'")
    fun searchSongs(query: String): Flux<Song>
}

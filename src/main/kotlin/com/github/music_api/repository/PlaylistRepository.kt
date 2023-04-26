package com.github.music_api.repository

import com.github.music_api.model.Playlist
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository

@Repository
interface PlaylistRepository : R2dbcRepository<Playlist, Int> {
}
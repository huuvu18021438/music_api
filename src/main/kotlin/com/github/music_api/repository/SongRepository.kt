package com.github.music_api.repository

import com.github.music_api.model.Song
import org.springframework.data.r2dbc.repository.R2dbcRepository
import org.springframework.stereotype.Repository

@Repository
interface SongRepository : R2dbcRepository<Song, Int>

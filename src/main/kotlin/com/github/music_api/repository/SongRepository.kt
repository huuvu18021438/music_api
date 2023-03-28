package com.github.music_api.repository

import com.github.music_api.model.Song
import org.springframework.data.repository.reactive.ReactiveCrudRepository

interface SongRepository: ReactiveCrudRepository<Song, Int>
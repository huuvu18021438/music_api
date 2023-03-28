package com.github.music_api.service

import com.github.music_api.model.Song
import com.github.music_api.repository.SongRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux

@Service
class SongService(private  val songRepository: SongRepository) {
    fun getAll(): Flux<Song> = songRepository.findAll()
}
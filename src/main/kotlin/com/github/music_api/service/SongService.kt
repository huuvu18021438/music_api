package com.github.music_api.service

import com.github.music_api.model.Song
import com.github.music_api.repository.SongRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class SongService(private val songRepository: SongRepository) {
    fun getAll(): Flux<Song> = songRepository.findAll()

    fun findBy(id: Int): Mono<Song> = songRepository.findById(id)

    fun post(song: Song): Mono<Song> {
        return songRepository.save(song)
    }

    fun delete(id: Int) = songRepository.deleteById(id)
}

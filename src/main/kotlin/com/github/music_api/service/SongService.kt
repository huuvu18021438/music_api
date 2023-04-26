package com.github.music_api.service

import com.github.music_api.model.Song
import com.github.music_api.repository.SongRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono
import java.util.*

@Service
class SongService(private val songRepository: SongRepository) {
    fun searchSongs(name: String): Flux<Song> = songRepository.searchSongs(name)

//    @PreAuthorize("authenticated")
    fun getAll(): Flux<Song> = songRepository.findAll()

//    @PreAuthorize("hasRole('ADMIN')")
    fun findBy(id: Int): Mono<Song> = songRepository.findById(id)

//    @PreAuthorize("hasRole('ADMIN')")
    fun post(song: Song): Mono<Song> = songRepository.save(song)

//    @PreAuthorize("hasRole('ADMIN')")
    fun update(id: Int, song: Song): Mono<Song> {
        return songRepository.findById(id).map { s: Song -> Optional.of(s) }.defaultIfEmpty(Optional.empty())
                .flatMap { optionalSong ->
                    if (optionalSong.isPresent) {
                        song.id = id
                        return@flatMap songRepository.save(song)
                    }
                    Mono.empty()
                }
    }

//    @PreAuthorize("hasRole('ADMIN')")
    fun delete(id: Int) = songRepository.deleteById(id)
}

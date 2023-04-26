package com.github.music_api.service

import com.github.music_api.model.Playlist
import com.github.music_api.repository.PlaylistRepository
import org.springframework.stereotype.Service
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Service
class PlaylistService(private val playlistRepository: PlaylistRepository) {
    fun findAll(): Flux<Playlist> = playlistRepository.findAll()

    fun post(playlist: Playlist): Mono<Playlist> = playlistRepository.save(playlist)

    fun findBindId(id: Int): Mono<Playlist> = playlistRepository.findById(id)
}
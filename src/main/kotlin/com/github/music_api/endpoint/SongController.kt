package com.github.music_api.endpoint

import com.github.music_api.service.SongService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController

@RestController
class SongController(private val songService: SongService) {
    @GetMapping("/")
    fun getAllSongs() = songService.getAll()
}
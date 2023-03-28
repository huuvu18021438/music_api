package com.github.music_api.endpoint

import com.github.music_api.service.SongService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/songs")
class SongController(private val songService: SongService) {
    @GetMapping("/")
    fun getAllSongs() = songService.getAll()

    @GetMapping("/{id}")
    fun findBy(@PathVariable id: Int) = songService.findBy(id)
}


package com.github.music_api.endpoint

import com.github.music_api.model.Song
import com.github.music_api.service.SongService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/songs")
class SongController(private val songService: SongService) {
    @GetMapping
    fun getSongs() = songService.getAll()

    @GetMapping("/search")
    fun search(@RequestParam("query") query: String): ResponseEntity<Flux<Song>> {
        return ResponseEntity.ok(songService.searchSongs(query))
    }

    @GetMapping("/{id}")
    fun find(@PathVariable id: Int) = songService.findBy(id)

    @PostMapping("/add")
    fun create(@RequestBody song: Song): Mono<Song>  = songService.post(song)

    @PatchMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody song: Song): Mono<Song> = TODO()

    @DeleteMapping("/remove/{id}")
    fun delete(@PathVariable id: Int) = songService.delete(id)
}

// https://spring.io/guides/gs/rest-service/
// https://learn.microsoft.com/en-us/azure/architecture/best-practices/api-design

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
    fun search(@RequestParam("name") name: String): ResponseEntity<Flux<Song>> {
        return ResponseEntity.ok(songService.searchSongs(name))
    }

    @GetMapping("/{id}")
    fun find(@PathVariable id: Int) = songService.findBy(id)

    @PostMapping("/add")
    fun create(@RequestBody song: Song): Mono<Song>  = songService.post(song)

    @PatchMapping("/{id}")
    fun update(@PathVariable id: Int, @RequestBody song: Song): Mono<Song> = songService.update(id, song)

    @DeleteMapping("/remove/{id}")
    fun delete(@PathVariable id: Int) = songService.delete(id)
}

// https://spring.io/guides/gs/rest-service/
// https://learn.microsoft.com/en-us/azure/architecture/best-practices/api-design

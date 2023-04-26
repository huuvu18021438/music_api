package com.github.music_api.endpoint

import com.github.music_api.model.Playlist
import com.github.music_api.model.Song
import com.github.music_api.service.PlaylistService
import com.github.music_api.service.SongService
import org.springframework.http.ResponseEntity
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.bind.annotation.*
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@RestController
@RequestMapping("/songs")
class SongController(private val playlistService: PlaylistService, private val songService: SongService) {
    @GetMapping
    fun getSongs() = songService.getAll()

    @GetMapping("/admin/search")
    fun search(@RequestParam("name") name: String): ResponseEntity<Flux<Song>> {
        return ResponseEntity.ok(songService.searchSongs(name))
    }

    @GetMapping("/admin/{id}")
    fun find(@PathVariable id: Int) = songService.findBy(id)

    @PostMapping("/admin/add")
    fun create(@RequestBody song: Song): Mono<Song>  = songService.post(song)

    @PatchMapping("/admin/{id}")
    fun update(@PathVariable id: Int, @RequestBody song: Song): Mono<Song> = songService.update(id, song)

    @DeleteMapping("/admin/remove/{id}")
    fun delete(@PathVariable id: Int) = songService.delete(id)

    @GetMapping("/playlists")
    fun getPlayLists(): Flux<Playlist> = playlistService.findAll()

    @PostMapping("/addPlaylist")
    @Transactional
    fun addPlayList(@RequestBody playlist: Playlist): Mono<Playlist> = playlistService.post(playlist)

    @PutMapping("/{id}/song")
    @Transactional
    fun addSongToPlaylistId(@PathVariable id: Int, @RequestBody song: Song): Mono<Playlist> {
        return playlistService.findBindId(id)
                .switchIfEmpty(Mono.error(NoSuchElementException("No element")))
                .flatMap { playlist: Playlist ->
                    songService.post(song)
                            .flatMap { entity: Song ->
                                playlist.setSongs.add(entity)
                                return@flatMap playlistService.post(playlist)
                            }
                }
                .flatMap {
                    playlistService.findBindId(it.id)
                }
    }
}
// https://spring.io/guides/gs/rest-service/
// https://learn.microsoft.com/en-us/azure/architecture/best-practices/api-design

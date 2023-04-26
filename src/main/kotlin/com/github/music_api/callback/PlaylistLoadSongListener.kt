package com.github.music_api.callback

import com.github.music_api.model.Playlist
import com.github.music_api.repository.SongRepository
import org.reactivestreams.Publisher
import org.springframework.context.annotation.Lazy
import org.springframework.data.r2dbc.mapping.event.AfterConvertCallback
import org.springframework.data.relational.core.sql.SqlIdentifier
import org.springframework.stereotype.Component

@Component
class PlaylistLoadSongListener(@Lazy private val songRepository: SongRepository): AfterConvertCallback<Playlist> {
    override fun onAfterConvert(playlist: Playlist, table: SqlIdentifier): Publisher<Playlist> {
        return songRepository.findSongsOfPlaylistId(playlist.id)
                .map {
                    if (it != null) playlist.setSongs.add(it)
                    return@map playlist
                }.takeLast(1).single(playlist)

    }

}
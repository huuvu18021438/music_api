package com.github.music_api.callback

import com.github.music_api.model.Playlist
import org.reactivestreams.Publisher
import org.springframework.data.r2dbc.mapping.OutboundRow
import org.springframework.data.r2dbc.mapping.event.AfterSaveCallback
import org.springframework.data.relational.core.sql.SqlIdentifier
import org.springframework.r2dbc.core.DatabaseClient
import org.springframework.stereotype.Component
import org.springframework.transaction.annotation.Propagation
import org.springframework.transaction.annotation.Transactional
import reactor.core.publisher.Flux
import reactor.core.publisher.Mono

@Component
@Transactional(propagation = Propagation.MANDATORY)
class PlaylistSaveSongListener(private val client: DatabaseClient): AfterSaveCallback<Playlist> {
    private final val SQL_DELETE: String = "DELETE FROM songs_playlists WHERE playlist_id = :id"
    private final val SQL_INSERT: String = "INSERT INTO songs_playlists (song_id, playlist_id) VALUES ($1, $2)"
    override fun onAfterSave(playlist: Playlist, outboundRow: OutboundRow, table: SqlIdentifier): Publisher<Playlist> {
        return client.sql(SQL_DELETE).bind("id", playlist.id)
                .fetch().rowsUpdated()
                .flatMap {
                    if (playlist.setSongs.isEmpty()) {
                        return@flatMap Mono.just(playlist)
                    } else {
                        return@flatMap client.inConnection {
                            val stmt = it.createStatement(SQL_INSERT)
                            playlist.setSongs.forEach { song ->
                                stmt.bind(0, playlist.id)
                                        .bind(1, song.id!!)
                                        .add()
                            }
                            return@inConnection Flux.from(stmt.execute()).last().map { playlist }
                        }
                    }
                }
    }

}
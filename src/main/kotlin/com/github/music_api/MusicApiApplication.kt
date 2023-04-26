package com.github.music_api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.data.r2dbc.repository.config.EnableR2dbcRepositories

@SpringBootApplication
@EnableR2dbcRepositories
class MusicApiApplication

fun main(args: Array<String>) {
	runApplication<MusicApiApplication>(*args)
}

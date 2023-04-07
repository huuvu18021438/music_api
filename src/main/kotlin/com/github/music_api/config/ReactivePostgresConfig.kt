package com.github.music_api.config

import com.fasterxml.jackson.databind.ObjectMapper
import io.r2dbc.spi.ConnectionFactory
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration
import org.springframework.core.convert.converter.Converter
import org.springframework.data.r2dbc.config.AbstractR2dbcConfiguration
import org.springframework.data.r2dbc.convert.R2dbcCustomConversions

@Configuration
class ReactivePostgresConfig(private val objectMapper: ObjectMapper) : AbstractR2dbcConfiguration() {
    override fun connectionFactory(): ConnectionFactory {
        TODO("Not yet implemented")
    }

    @Bean
    override fun r2dbcCustomConversions(): R2dbcCustomConversions {
        val converters: MutableList<Converter<*, *>?> = ArrayList()
        converters.add(JsonToMapConverter(objectMapper))
        converters.add(MapToJsonConverter(objectMapper))
        return R2dbcCustomConversions(storeConversions, converters)
    }
}
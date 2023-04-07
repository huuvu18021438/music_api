package com.github.music_api.config

import com.fasterxml.jackson.core.type.TypeReference
import com.fasterxml.jackson.databind.ObjectMapper
import io.r2dbc.postgresql.codec.Json
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.ReadingConverter
import java.io.IOException

@ReadingConverter
class JsonToMapConverter(private val objectMapper: ObjectMapper) : Converter<Json, Map<String, Any>> {
    override fun convert(json: Json): Map<String, Any> {
        try {
            return objectMapper.readValue(json.asString(), object: TypeReference<Map<String, String>>(){})
        } catch (e: IOException) {
            println("Problem while parsing JSON: {}")
        }
        return HashMap()
    }
}
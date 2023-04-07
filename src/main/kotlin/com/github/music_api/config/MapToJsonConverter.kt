package com.github.music_api.config

import com.fasterxml.jackson.core.JsonProcessingException
import com.fasterxml.jackson.databind.ObjectMapper
import io.r2dbc.postgresql.codec.Json
import org.springframework.core.convert.converter.Converter
import org.springframework.data.convert.WritingConverter


@WritingConverter
class MapToJsonConverter(private val objectMapper: ObjectMapper) : Converter<Map<String, Any>, Json> {
    override fun convert(source: Map<String, Any>): Json {
        try {
            return objectMapper.let { Json.of(it.writeValueAsString(source)) }
        } catch (e: JsonProcessingException) {
            println(e)
        }
        return Json.of("")
    }
}
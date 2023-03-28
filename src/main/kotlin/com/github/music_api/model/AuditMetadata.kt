package com.github.music_api.model

import java.time.LocalDateTime

data class AuditMetadata(
    val createAt: LocalDateTime,
    val updateAt: LocalDateTime,
    val createBy: String,
    val updateBy: String
)

// TODO: embedded

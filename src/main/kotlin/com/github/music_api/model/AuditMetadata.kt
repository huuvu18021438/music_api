package com.github.music_api.model

import java.time.LocalDate

data class AuditMetadata(
        val createAt: LocalDate,
        val updateAt: LocalDate,
        val createBy: String,
        val updateBy: String
)

// TODO: embedded

package dev.joao.request.credit.system.exceptions

import java.time.LocalDateTime

data class ExceptionDatails(
    val title: String,
    val timestamp:LocalDateTime,
    val status: Int,
    val exception: String,
    val details: MutableMap<String, String?>
)

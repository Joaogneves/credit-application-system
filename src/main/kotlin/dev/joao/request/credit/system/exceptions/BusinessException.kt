package dev.joao.request.credit.system.exceptions

data class BusinessException(override val message: String?) : RuntimeException(message)

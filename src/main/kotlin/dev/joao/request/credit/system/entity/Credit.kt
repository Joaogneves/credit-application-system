package dev.joao.request.credit.system.entity

import dev.joao.request.credit.system.enums.Status
import java.math.BigDecimal
import java.time.LocalDate
import java.util.UUID

data class Credit(
        val creditCode: UUID = UUID.randomUUID(),
        val creditValue: BigDecimal = BigDecimal.ZERO,
        val dayFirstInstallment: LocalDate,
        val numberOfInstallment: Int = 0,
        var status: Status = Status.IN_PROGRESS,
        val customer: Customer? = null,
        var id: Long? = null
)
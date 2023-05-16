package dev.joao.request.credit.system.dto

import dev.joao.request.credit.system.entity.Credit
import dev.joao.request.credit.system.entity.Customer
import jakarta.validation.constraints.*
import java.math.BigDecimal
import java.time.LocalDate

class CreditDTO(
    @field:NotNull(message = "Invalid Input") val creditValue: BigDecimal,
    @field:Future val dayFirstInstallment: LocalDate,
    @field:Positive @field:Max(value = 48) @field:Min(value = 1) val numberOfInstallments: Int,
    @field:NotNull(message = "Invalid Input") val customerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue =  this.creditValue,
        dayFirstInstallment = this.dayFirstInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )

}

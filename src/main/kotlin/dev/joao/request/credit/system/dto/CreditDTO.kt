package dev.joao.request.credit.system.dto

import dev.joao.request.credit.system.entity.Credit
import dev.joao.request.credit.system.entity.Customer
import java.math.BigDecimal
import java.time.LocalDate

class CreditDTO(
    val creditValue: BigDecimal,
    val dayFirstInstallment: LocalDate,
    val numberOfInstallments: Int,
    val customerId: Long
) {
    fun toEntity(): Credit = Credit(
        creditValue =  this.creditValue,
        dayFirstInstallment = this.dayFirstInstallment,
        numberOfInstallments = this.numberOfInstallments,
        customer = Customer(id = this.customerId)
    )

}

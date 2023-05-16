package dev.joao.request.credit.system.services.Impl

import dev.joao.request.credit.system.entity.Credit
import dev.joao.request.credit.system.exceptions.BusinessException
import dev.joao.request.credit.system.repositories.CreditRepository
import dev.joao.request.credit.system.services.ICreditService
import org.springframework.stereotype.Service
import java.time.LocalDate
import java.util.*

@Service
class CreditService(
    private val creditRepository: CreditRepository,
    private val customerService: CustomerService
): ICreditService {
    override fun save(credit: Credit): Credit {
        this.validDayFirstInstallment(credit.dayFirstInstallment)
        credit.apply {
            customer = customerService.findById(credit.customer?.id!!)
        }
        return this.creditRepository.save(credit)
    }

    override fun findAllByCustomer(customerId: Long): List<Credit> {
        return this.creditRepository.findAllByCustomer(customerId)
    }

    override fun findByCreditCode(customerId: Long, creditCode: UUID): Credit {
        val credit: Credit = (this.creditRepository.findByCreditCode(creditCode)
            ?: throw BusinessException("CreditCode $creditCode not found"))
        return if (credit.customer?.id == customerId) credit else throw IllegalArgumentException("Contact admin")
    }

    private fun validDayFirstInstallment(dayFirst: LocalDate):Boolean {
        if (dayFirst.isBefore(LocalDate.now().plusMonths(3))) {
            return true
        } else throw BusinessException("Invalid date")
    }

}
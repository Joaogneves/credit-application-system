package dev.joao.request.credit.system.services.Impl

import dev.joao.request.credit.system.entity.Customer
import dev.joao.request.credit.system.exceptions.BusinessException
import dev.joao.request.credit.system.repositories.CustomerRepository
import dev.joao.request.credit.system.services.ICustomerService
import org.springframework.stereotype.Service

@Service
class CustomerService(
        private val rep: CustomerRepository
) : ICustomerService {
    override fun save(customer: Customer): Customer {
        return this.rep.save(customer)
    }

    override fun findById(id: Long): Customer {
        return this.rep.findById(id).orElseThrow {
            throw BusinessException("Id $id not found")
        }
    }

    override fun delete(id: Long) {
        val customer: Customer = this.findById(id)
        this.rep.delete(customer)
        this.rep.deleteById(id)
    }
}
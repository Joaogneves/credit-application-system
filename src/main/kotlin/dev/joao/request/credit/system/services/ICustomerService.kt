package dev.joao.request.credit.system.services

import dev.joao.request.credit.system.entity.Customer

interface ICustomerService {
    fun save(customer: Customer): Customer
    fun findById(id: Long): Customer
    fun delete(id: Long)
}
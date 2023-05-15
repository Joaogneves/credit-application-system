package dev.joao.request.credit.system.controllers

import dev.joao.request.credit.system.dto.CustomerDTO
import dev.joao.request.credit.system.dto.CustomerUpdateDTO
import dev.joao.request.credit.system.dto.CustomerView
import dev.joao.request.credit.system.entity.Customer
import dev.joao.request.credit.system.services.Impl.CustomerService
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/customers")
class CustomerResource(
    private val service: CustomerService
) {
    @PostMapping
    fun saveCustomer(@RequestBody customerDTO: CustomerDTO): ResponseEntity<String> {
        val savedCustomer = this.service.save(customerDTO.toEntity())
        return ResponseEntity.status(HttpStatus.CREATED).body("Customer ${savedCustomer.email} saved!")
    }

    @GetMapping("/{id}")
    fun findById(@PathVariable id: Long): ResponseEntity<CustomerView> {
        val customer: Customer = this.service.findById(id)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customer))
    }

    @DeleteMapping("/{id}")
    fun deleteCustomer(@PathVariable id: Long) = this.service.delete(id)

    @PatchMapping
    fun updateCustomer(
        @RequestParam(value = "customerId") id: Long,
        @RequestBody customerUpdateDTO: CustomerUpdateDTO
    ): ResponseEntity<CustomerView> {
        val customer = this.service.findById(id)
        val customerToUpdate: Customer = customerUpdateDTO.toEntity(customer)
        val customerUpdated: Customer = this.service.save(customerToUpdate)
        return ResponseEntity.status(HttpStatus.OK).body(CustomerView(customerUpdated))
    }


}
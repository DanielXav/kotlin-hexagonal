package com.danielxavier.hexagonal.adapters.`in`.controller

import com.danielxavier.hexagonal.adapters.`in`.controller.request.CustomerRequest
import com.danielxavier.hexagonal.adapters.`in`.controller.response.CustomerResponse
import com.danielxavier.hexagonal.application.core.domain.Customer
import com.danielxavier.hexagonal.application.ports.`in`.FindCustomerByIdCustomerPort
import com.danielxavier.hexagonal.application.ports.`in`.InsertCustomerInputPort
import jakarta.validation.Valid
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/customers")
class CustomerController(
    private val insertCustomerInputPort: InsertCustomerInputPort,
    private val findCustomerByIdCustomerPort: FindCustomerByIdCustomerPort
) {

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    fun insert(@Valid @RequestBody customerRequest: CustomerRequest) {
        with(customerRequest) {
            val customer = Customer(name = name, cpf = cpf)
            insertCustomerInputPort.insert(customer, zipCode)
        }
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    fun findById(@PathVariable id: String): CustomerResponse {
        val customer = findCustomerByIdCustomerPort.find(id)
        return CustomerResponse(customer)
    }
}
package com.danielxavier.hexagonal.adapters.out

import com.danielxavier.hexagonal.adapters.out.repository.CustomerRepository
import com.danielxavier.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.danielxavier.hexagonal.application.core.domain.Customer
import com.danielxavier.hexagonal.application.ports.out.InsertCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class InsertCustomerAdapter(
    private val customerRepository: CustomerRepository
): InsertCustomerOutputPort {

    override fun insert(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }
}
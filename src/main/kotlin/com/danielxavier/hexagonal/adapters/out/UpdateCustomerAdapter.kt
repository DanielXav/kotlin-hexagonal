package com.danielxavier.hexagonal.adapters.out

import com.danielxavier.hexagonal.adapters.out.repository.CustomerRepository
import com.danielxavier.hexagonal.adapters.out.repository.entity.CustomerEntity
import com.danielxavier.hexagonal.application.core.domain.Customer
import com.danielxavier.hexagonal.application.ports.out.UpdateCustomerOutputPort
import org.springframework.stereotype.Component

@Component
class UpdateCustomerAdapter(
    private val customerRepository: CustomerRepository
): UpdateCustomerOutputPort {

    override fun update(customer: Customer) {
        customerRepository.save(CustomerEntity(customer))
    }
}
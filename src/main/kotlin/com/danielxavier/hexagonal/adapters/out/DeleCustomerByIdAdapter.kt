package com.danielxavier.hexagonal.adapters.out

import com.danielxavier.hexagonal.adapters.out.repository.CustomerRepository
import com.danielxavier.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort
import org.springframework.stereotype.Component

@Component
class DeleCustomerByIdAdapter(
    private val customerRepository: CustomerRepository
): DeleteCustomerByIdOutputPort {

    override fun delete(id: String) {
        customerRepository.deleteById(id)
    }
}
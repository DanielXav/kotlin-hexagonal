package com.danielxavier.hexagonal.adapters.out

import com.danielxavier.hexagonal.adapters.out.repository.CustomerRepository
import com.danielxavier.hexagonal.application.core.domain.Customer
import com.danielxavier.hexagonal.application.ports.out.FindCustomerByIdOutputPort
import org.springframework.stereotype.Component
import kotlin.jvm.optionals.getOrNull

@Component
class FindCustomerByIdAdapter(
    private val customerRepository: CustomerRepository
): FindCustomerByIdOutputPort {
    override fun find(id: String): Customer? =
        customerRepository.findById(id).getOrNull().let {
            return it?.toCustomer()
    }
}
package com.danielxavier.hexagonal.application.ports.`in`

import com.danielxavier.hexagonal.application.core.domain.Customer

interface UpdateCustomerInputPort {

    fun update(customer: Customer, zipCode: String)
}
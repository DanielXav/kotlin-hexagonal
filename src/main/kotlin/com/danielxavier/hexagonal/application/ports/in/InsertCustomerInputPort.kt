package com.danielxavier.hexagonal.application.ports.`in`

import com.danielxavier.hexagonal.application.core.domain.Customer

interface InsertCustomerInputPort {

    fun insert(customer: Customer, zipCode: String)
}
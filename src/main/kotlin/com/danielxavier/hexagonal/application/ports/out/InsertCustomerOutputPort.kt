package com.danielxavier.hexagonal.application.ports.out

import com.danielxavier.hexagonal.application.core.domain.Customer

interface InsertCustomerOutputPort {

    fun insert(customer: Customer)
}
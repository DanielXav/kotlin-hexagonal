package com.danielxavier.hexagonal.application.ports.`in`

import com.danielxavier.hexagonal.application.core.domain.Customer

interface FindCustomerByIdCustomerPort {

    fun find(id: String): Customer
}
package com.danielxavier.hexagonal.application.ports.out

import com.danielxavier.hexagonal.application.core.domain.Customer

interface FindCustomerByIdOutputPort {

    fun find(id: String): Customer?
}
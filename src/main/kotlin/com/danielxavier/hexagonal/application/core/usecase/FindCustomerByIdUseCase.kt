package com.danielxavier.hexagonal.application.core.usecase

import com.danielxavier.hexagonal.application.core.exceptions.ObjectNotFoundException
import com.danielxavier.hexagonal.application.ports.`in`.FindCustomerByIdCustomerPort
import com.danielxavier.hexagonal.application.ports.out.FindCustomerByIdOutputPort

class FindCustomerByIdUseCase(
    private val findCustomerByIdOutputPort: FindCustomerByIdOutputPort
): FindCustomerByIdCustomerPort {

    override fun find(id: String) =
        findCustomerByIdOutputPort.find(id) ?: throw ObjectNotFoundException("Customer not found")

}
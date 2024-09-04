package com.danielxavier.hexagonal.application.core.usecase

import com.danielxavier.hexagonal.application.core.domain.Customer
import com.danielxavier.hexagonal.application.ports.`in`.FindCustomerByIdCustomerInputPort
import com.danielxavier.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import com.danielxavier.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import com.danielxavier.hexagonal.application.ports.out.UpdateCustomerOutputPort

class UpdateCustomerUseCase(
    private val findCustomerByIdCustomerInputPort: FindCustomerByIdCustomerInputPort,
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val updateCustomerOutputPort: UpdateCustomerOutputPort
): UpdateCustomerInputPort {

    override fun update(customer: Customer, zipCode: String) {
        if (customer.id == null) throw IllegalArgumentException("Customer ID cannot be null")
        findCustomerByIdCustomerInputPort.find(customer.id)

        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            updateCustomerOutputPort.update(it)
        }
    }
}
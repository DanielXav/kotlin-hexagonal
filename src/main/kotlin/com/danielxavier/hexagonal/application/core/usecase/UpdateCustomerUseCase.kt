package com.danielxavier.hexagonal.application.core.usecase

import com.danielxavier.hexagonal.application.core.domain.Customer
import com.danielxavier.hexagonal.application.ports.`in`.FindCustomerByIdCustomerInputPort
import com.danielxavier.hexagonal.application.ports.`in`.UpdateCustomerInputPort
import com.danielxavier.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import com.danielxavier.hexagonal.application.ports.out.SendCpfForValidationOutputPort
import com.danielxavier.hexagonal.application.ports.out.UpdateCustomerOutputPort

class UpdateCustomerUseCase(
    private val findCustomerByIdCustomerInputPort: FindCustomerByIdCustomerInputPort,
    private val findAddressByZipCodeOutputPort: FindAddressByZipCodeOutputPort,
    private val updateCustomerOutputPort: UpdateCustomerOutputPort,
    private val sendCpfForValidationOutputPort: SendCpfForValidationOutputPort
): UpdateCustomerInputPort {

    override fun update(customer: Customer, zipCode: String) {
        if (customer.id == null) throw IllegalArgumentException("Customer ID cannot be null")
        val savedCpf = findCustomerByIdCustomerInputPort.find(customer.id).cpf

        customer.apply {
            address = findAddressByZipCodeOutputPort.find(zipCode)
        }.let {
            updateCustomerOutputPort.update(it)
            if (savedCpf != it.cpf) {
                sendCpfForValidationOutputPort.send(it.cpf)
            }
        }
    }
}
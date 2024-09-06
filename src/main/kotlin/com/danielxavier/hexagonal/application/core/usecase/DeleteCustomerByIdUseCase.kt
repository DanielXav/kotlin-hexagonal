package com.danielxavier.hexagonal.application.core.usecase

import com.danielxavier.hexagonal.application.ports.`in`.DeleteCustomerByIdInputPort
import com.danielxavier.hexagonal.application.ports.`in`.FindCustomerByIdCustomerInputPort
import com.danielxavier.hexagonal.application.ports.out.DeleteCustomerByIdOutputPort

class DeleteCustomerByIdUseCase(
    private val findCustomerByIdInputPort: FindCustomerByIdCustomerInputPort,
    private val deleteCustomerByIdOutputPort: DeleteCustomerByIdOutputPort
): DeleteCustomerByIdInputPort {

    override fun delete(id: String) {
        findCustomerByIdInputPort.find(id)
        deleteCustomerByIdOutputPort.delete(id)
    }

}
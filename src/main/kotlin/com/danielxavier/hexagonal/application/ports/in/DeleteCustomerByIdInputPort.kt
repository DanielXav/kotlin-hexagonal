package com.danielxavier.hexagonal.application.ports.`in`

interface DeleteCustomerByIdInputPort {

    fun delete(id: String)
}
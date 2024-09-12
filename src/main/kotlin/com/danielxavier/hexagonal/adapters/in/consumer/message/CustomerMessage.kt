package com.danielxavier.hexagonal.adapters.`in`.consumer.message

import com.danielxavier.hexagonal.application.core.domain.Customer

data class CustomerMessage(
    val id: String,
    val name: String,
    val zipCode: String,
    val cpf: String,
    val isValidCpf: Boolean
) {
    fun toCustomer() = Customer(id, name, cpf = cpf, isValidCpf = isValidCpf)
}

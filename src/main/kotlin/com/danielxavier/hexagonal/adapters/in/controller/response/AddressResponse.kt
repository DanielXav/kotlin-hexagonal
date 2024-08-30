package com.danielxavier.hexagonal.adapters.`in`.controller.response

import com.danielxavier.hexagonal.application.core.domain.Address

data class AddressResponse(
    val street: String,
    val city: String,
    val state: String
) {
    constructor(address: Address): this (
        address.street,
        address.city,
        address.state
    )
}

package com.danielxavier.hexagonal.application.ports.out

import com.danielxavier.hexagonal.application.core.domain.Address

interface FindAddressByZipCodeOutputPort {

    fun find(zipCode: String): Address

}
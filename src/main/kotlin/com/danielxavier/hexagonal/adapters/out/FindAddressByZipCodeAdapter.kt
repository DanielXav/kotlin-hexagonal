package com.danielxavier.hexagonal.adapters.out

import com.danielxavier.hexagonal.adapters.out.client.FindAddressByZipCodeClient
import com.danielxavier.hexagonal.application.core.domain.Address
import com.danielxavier.hexagonal.application.ports.out.FindAddressByZipCodeOutputPort
import org.springframework.stereotype.Component

@Component
class FindAddressByZipCodeAdapter(
    private val findAddressByZipCodeClient: FindAddressByZipCodeClient
): FindAddressByZipCodeOutputPort {

    override fun find(zipCode: String): Address = findAddressByZipCodeClient.find(zipCode).toAddress()

}
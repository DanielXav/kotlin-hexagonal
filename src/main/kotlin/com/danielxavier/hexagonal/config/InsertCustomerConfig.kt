package com.danielxavier.hexagonal.config

import com.danielxavier.hexagonal.adapters.out.FindAddressByZipCodeAdapter
import com.danielxavier.hexagonal.adapters.out.InsertCustomerAdapter
import com.danielxavier.hexagonal.application.core.usecase.InsertCustomerUseCase
import com.danielxavier.hexagonal.application.ports.out.SendCpfForValidationOutputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class InsertCustomerConfig {

    @Bean
    fun insertCustomer(
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        insertCustomerAdapter: InsertCustomerAdapter,
        sendCpfForValidationOutputPort: SendCpfForValidationOutputPort
    ) = InsertCustomerUseCase(
            findAddressByZipCodeAdapter,
            insertCustomerAdapter,
            sendCpfForValidationOutputPort)
}
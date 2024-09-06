package com.danielxavier.hexagonal.config

import com.danielxavier.hexagonal.adapters.out.FindAddressByZipCodeAdapter
import com.danielxavier.hexagonal.adapters.out.UpdateCustomerAdapter
import com.danielxavier.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import com.danielxavier.hexagonal.application.core.usecase.UpdateCustomerUseCase
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class UpdateCustomerConfig {

    @Bean
    fun updateCustomer(
        findCustomerByUseCase: FindCustomerByIdUseCase,
        findAddressByZipCodeAdapter: FindAddressByZipCodeAdapter,
        updateCustomerAdapter: UpdateCustomerAdapter
    ) = UpdateCustomerUseCase(
            findCustomerByUseCase,
            findAddressByZipCodeAdapter,
            updateCustomerAdapter
        )
}
package com.danielxavier.hexagonal.config

import com.danielxavier.hexagonal.adapters.out.DeleCustomerByIdAdapter
import com.danielxavier.hexagonal.application.core.usecase.DeleteCustomerByIdUseCase
import com.danielxavier.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import com.danielxavier.hexagonal.application.ports.`in`.DeleteCustomerByIdInputPort
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class DeleteCustomerByIdConfig {

    @Bean
    fun deleteCustomerById(
        findCustomerByIdUseCase: FindCustomerByIdUseCase,
        deleteCustomerByIdAdapter: DeleCustomerByIdAdapter
    ) = DeleteCustomerByIdUseCase(
        findCustomerByIdUseCase,
        deleteCustomerByIdAdapter)
}
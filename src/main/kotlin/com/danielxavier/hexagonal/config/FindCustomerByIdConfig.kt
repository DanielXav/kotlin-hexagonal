package com.danielxavier.hexagonal.config

import com.danielxavier.hexagonal.application.core.usecase.FindCustomerByIdUseCase
import com.danielxavier.hexagonal.application.ports.out.FindCustomerByIdOutputPort
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class FindCustomerByIdConfig {

    @Bean
    fun findCustomerById(findCustomerByIdOutputPort: FindCustomerByIdOutputPort) =
        FindCustomerByIdUseCase(findCustomerByIdOutputPort)

}
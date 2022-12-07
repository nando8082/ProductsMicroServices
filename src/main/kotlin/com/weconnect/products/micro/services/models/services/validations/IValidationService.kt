package com.weconnect.products.micro.services.models.services.validations

import org.springframework.validation.BindingResult

interface IValidationService {

    fun validationObject(result: BindingResult) : Any

    fun getExceptionMessage(exception: Exception) : Any

}
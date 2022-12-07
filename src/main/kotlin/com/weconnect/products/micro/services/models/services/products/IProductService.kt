package com.weconnect.products.micro.services.models.services.products

import com.weconnect.products.micro.services.models.entities.Product
import org.springframework.transaction.annotation.Transactional


interface IProductService {

    @Transactional(readOnly = true)
    fun findAllProduct() : List<Product>

    @Transactional(readOnly = true)
    fun  findProductsByDriverID(driverID : Long): List<Product>

}
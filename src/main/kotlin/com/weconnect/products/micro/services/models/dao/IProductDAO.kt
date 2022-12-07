package com.weconnect.products.micro.services.models.dao

import com.weconnect.products.micro.services.models.entities.Product
import org.springframework.data.repository.CrudRepository

interface IProductDAO : CrudRepository<Product,Long>{

    fun findProductsByDriverDriverId(driverID: Long):List<Product>
}
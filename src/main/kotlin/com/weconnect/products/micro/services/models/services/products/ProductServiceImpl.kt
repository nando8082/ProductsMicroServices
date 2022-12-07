package com.weconnect.products.micro.services.models.services.products

import com.weconnect.products.micro.services.models.dao.IProductDAO
import com.weconnect.products.micro.services.models.entities.Product
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service

@Service
class ProductServiceImpl : IProductService {

    @Autowired
    private val iProductDAO : IProductDAO? = null

    override fun findAllProduct(): List<Product> {
        return iProductDAO!!.findAll() as List<Product>
    }

    override fun findProductsByDriverID(driverID: Long): List<Product> {
        return iProductDAO!!.findProductsByDriverDriverId(driverID = driverID)
    }

}
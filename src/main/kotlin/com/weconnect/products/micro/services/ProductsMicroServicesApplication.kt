package com.weconnect.products.micro.services

import io.swagger.v3.oas.annotations.OpenAPIDefinition
import io.swagger.v3.oas.annotations.info.Contact
import io.swagger.v3.oas.annotations.info.Info
import io.swagger.v3.oas.annotations.servers.Server
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
@SpringBootApplication
@OpenAPIDefinition(
    info = Info(
        title = "MICROSERVICIOS DE PRODUCTOS",
        description = "",
        contact = Contact(
            name = "DANIEL PINARGO",
            email = "dpinargo@est.ups.edu.ec"
        ),

        ),
    servers = [
        Server(
            url = "https://mibusetabackend.com:8091/products",
            description = "SERVIDOR DE PRODUCCION"
        )
    ]

)
class ProductsMicroServicesApplication

fun main(args: Array<String>) {

    runApplication<ProductsMicroServicesApplication>(*args)

}

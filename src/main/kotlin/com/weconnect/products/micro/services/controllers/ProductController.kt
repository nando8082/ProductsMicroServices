package com.weconnect.products.micro.services.controllers

import com.weconnect.products.micro.services.StaticValues
import com.weconnect.products.micro.services.models.entities.Product
import com.weconnect.products.micro.services.models.services.products.IProductService
import com.weconnect.products.micro.services.models.services.validations.IValidationService
import io.swagger.v3.oas.annotations.Operation
import io.swagger.v3.oas.annotations.Parameter
import io.swagger.v3.oas.annotations.media.Content
import io.swagger.v3.oas.annotations.media.Schema
import io.swagger.v3.oas.annotations.responses.ApiResponse
import io.swagger.v3.oas.annotations.responses.ApiResponses
import io.swagger.v3.oas.annotations.tags.Tag
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.dao.DataAccessException
import org.springframework.http.HttpStatus
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/productController")
@Tag(name = "CONTROLADOR DE PRODUCTOS",
    description = "ESTE MICROSERVICIO CONTROLA TODAS LA PETICIONES QUE SE REALIZARAN A LA BASE DE DATOS DENTRO DE LA TABLA DE PRODUCTOS")
class ProductController {

    @Autowired
    private val iProductService: IProductService? = null

    @Autowired
    private val iValidationService: IValidationService? = null

    @GetMapping("/findProductsByDriverID/{driverId}")
    @Operation(
        summary = "LISTAR PRODUCTOS POR ID DE CONDUCTOR",
        description = "ESTE SERVICIO SE ENCARGA DE LISTAR TODOS LOS PRODUCTOS QUE PERTENECEN" +
                "A UN CONDUCTOR, SI EL RESULTADO DE LA B[USQUEDA ES CORRECTA RETORNARA" +
                "UNA LISTA DE PRODUCTOS, CASO CONTRARIO NO LISTARA NADA",
        method = "GET",
        parameters = [Parameter(
            name = "driverID",
            description = "IDENTIFICADOR UNICO DEL CONDUCTOR",
            required = true
        )]
    )
    @ApiResponses(
        value = [
            ApiResponse(
                responseCode = "200",
                description = "SI EL IDENTIFICADOR DEL CONDUCTOR ES CORRECTO DEVOLVERA LOS PRODUCTOS EXISTENTES EN LA BASE DE DATOS",
                content = [
                    (Content(
                        mediaType = "application/json",
                        schema = Schema(
                            allOf = arrayOf(Product::class)
                        )
                    ))
                ]
            ),
            ApiResponse(
                responseCode = "404",
                description = "ESTE MENSAJE SE MOSTRARA EN CASO DE QUE EL IDENTIFICADOR DEL CONDUCTOR NO EXISTA EN LA BASE DE DATOS"
            ),
            ApiResponse(
                responseCode = "500",
                description = "ESTE MENSAJE SE MOSTRARA EN CASO DE QUE EXISTA UN  ERROR INTERNO DEL SERVIDOR"
            )
        ]
    )
    fun findProductsByDriverID(
        @PathVariable("driverId") driverId: Long,
    ): Any {
        val response = HashMap<String, Any>()
        return try {
            val productList = iProductService!!.findProductsByDriverID(
                driverID = driverId
            )
            run {
                response["message"] = StaticValues.MESSAGE_SUCCESS_FIND
                response["response"] = productList
                ResponseEntity<Map<*, *>>(response, HttpStatus.OK)
            }
        } catch (e: DataAccessException) {
            iValidationService!!.getExceptionMessage(e)
        }
    }

}
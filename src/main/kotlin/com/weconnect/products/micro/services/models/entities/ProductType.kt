package com.weconnect.products.micro.services.models.entities

import io.swagger.v3.oas.annotations.media.Schema
import java.io.Serializable
import javax.persistence.*

@Entity(name = "product_type")
@Schema(
    name = "Tipo de Producto",
    description = "ENTIDAD GESTIONADA EN ESTE MICREOSERVICIO, PERMITE  LA CREACION DE LA TABLA CON TODOS LOS ATRIBUTOS QUE TIENE UN"+
                    " TIPO DE PRODCUTO EN LA BASE DE DATOS")
class ProductType : Serializable {

    @Id
    @GeneratedValue(
            strategy = GenerationType.IDENTITY
    )
    @Column(name = "pt_id")
    @Schema(
        name = "id",
        description = "ES EL IDENTIFICADRO UNICO DEL PRODUCTO DENTRO DE LA BASE DE DATOS",
        example = "1",
        readOnly = true
    )
    val id: Long = 0

    @Column(name = "pt_name")
    @Schema(
        name = "name",
        description = "NOMBRE QUE TENDRA CADA TIPO DE PRODUCTO DENTRO DE LA BASE DE DATOS",
        example = "COMPLETO",
        readOnly = true
    )
    var name: String? = ""

    @Column(name = "pt_firebase_name")
    @Schema(
        name = "fireBaseName",
        description = "NOMBRE DEL TIPO DE PRODUCTO DENTRO DE FIREBASE",
        example = "COMBINADO",
        readOnly = true
    )
    var fireBaseName: String? = ""

}
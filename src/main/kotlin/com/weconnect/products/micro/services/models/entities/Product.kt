package com.weconnect.products.micro.services.models.entities

import io.swagger.v3.oas.annotations.media.Schema
import java.io.Serializable
import javax.persistence.*

@Entity(name = "product")
@Schema(
    name = "Producto",
    description = "ENTIDAD GESTIONADA EN ESTE MICREOSERVICIO, PERMITE  LA CREACION DE LA TABLA CON TODOS LOS ATRIBUTOS QUE TIENE UN "+
                    "PRODUCTO EN LA BASE DE DATOS")
class Product : Serializable {
    @Id
    @TableGenerator(
            name = "product_sequential_value", initialValue = 4980
    )
    @GeneratedValue(
            strategy = GenerationType.IDENTITY,
            generator = "product_sequential_value"
    )
    @Column(name = "pr_id")
    @Schema(
        name = "id",
        description = "ES EL IDENTIFICADOR UNICO DE CADA PRODUCTO DENTRO DE LA BASE DE DATOS",
        example = "1",
        readOnly = true
    )
    val id: Long = 0

    @Column(name = "pr_name")
    @Schema(
        name = "name",
        description = "ES EL NOMBRE DE CADA PRODUCTO DENTRO DE LA BASE DE DATOS",
        example = "COMPLETO ESTANDAR",
        readOnly = true
    )
    var name: String? = ""

    @Column(name = "pr_iva_percent")
    @Schema(
        name = "ivaPercent",
        description = "ES EL IDENTIFICADOR UNICO DE CADA PRODUCTO DENTRO DE LA BASE DE DATOS",
        example = "12",
        readOnly = true
    )
    var ivaPercent: Double? = 0.0

    @Column(name = "pr_state")
    @Schema(
        name = "state",
        description = "ES EL ESTADO DE CADA PRODUCTO QUE SE GUARDARA EN LA BASE DE DATOS",
        example = "1",
        readOnly = true
    )
    var state: Int? = 0

    @Column(name = "pr_cost")
    @Schema(
        name = "cost",
        description = "ES EL COSTO DE CADA PRODUCTO QUE SE GUARDARA EN LA BASE DE DATOS",
        example = "30",
        readOnly = true
    )
    var cost: Double? = 0.0

    @Column(name = "pr_reference_code")
    @Schema(
        name = "referenceCode",
        description = "ES EL CODIGO DE REFERENCIA DE CADA PRODUCTO QUE SE GUARDARA EN LA BASE DE DATOS",
        example = "COMB001",
        readOnly = true
    )
    var referenceCode: String? = ""

    @Column(name = "is_compensation_product")
    @Schema(
        name = "isCompensationProduct",
        description = "PERMITE SABER SI ES UN PRODUCTO DE COMPENSACION Y SE GUARDARA EN LA BASE DE DATOS",
        example = "FALSE",
        readOnly = true
    )
    var isCompensationProduct: Boolean? = false

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_driver", referencedColumnName = "dr_id")
    @Schema(
        name = "driver",
        description = "IDENTIFICADOR QUE HACE REFERENCIA AL CONDUCTOR AL QUE PERTENECE UN PRODUCTO",
        implementation = Driver::class,
        readOnly = true
    )
    var driver: Driver? = Driver()

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "id_product_type", referencedColumnName = "pt_id")
    @Schema(
        name = "productType",
        description = "IDENTIFICADOR QUE HACE REFERENCIA AL TYPO DE PRODUCTO AL QUE PERTENECE UN PRODUCTO",
        implementation = ProductType::class,
        readOnly = true
    )
    var productType: ProductType? = ProductType()

}
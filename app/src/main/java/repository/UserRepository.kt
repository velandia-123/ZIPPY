package com.zippy.zippy.repository

data class BusinessUser(
    val negocio: String,
    val propietario: String,
    val telefono: String,
    val correo: String,
    val direccion: String,
    val password: String
)

data class DeliveryUser(
    val nombre: String,
    val cedula: String,
    val telefono: String,
    val correo: String,
    val placa: String,
    val vehiculo: String,
    val password: String
)

object UserRepository {

    val businessUsers = mutableListOf<BusinessUser>()

    val deliveryUsers = mutableListOf<DeliveryUser>()

    fun addBusiness(user: BusinessUser) {
        businessUsers.add(user)
    }

    fun addDelivery(user: DeliveryUser) {
        deliveryUsers.add(user)
    }

    fun login(
        correo: String,
        password: String
    ): Boolean {

        val empresaExiste = businessUsers.any {
            it.correo == correo && it.password == password
        }

        val domiciliarioExiste = deliveryUsers.any {
            it.correo == correo && it.password == password
        }

        return empresaExiste || domiciliarioExiste
    }
}
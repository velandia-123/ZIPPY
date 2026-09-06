package com.zippy.zippy.model

data class Order(

    val negocio: String,

    val cliente: String,

    val direccion: String,

    val telefono: String,

    val valor: String,

    val observaciones: String,

    var estado: String = "Pendiente"

)
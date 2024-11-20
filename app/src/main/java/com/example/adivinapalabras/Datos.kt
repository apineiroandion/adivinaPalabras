package com.example.adivinapalabras

object Datos{
    val palabras = listOf("Hola", "Adios", "Casa", "Perro", "Gato", "Pajaro", "Pescado", "Cocina", "Cama", "Silla")
    var ronda = 0
    var intento = 0
    val intentosMax = 3
    var pista = ""
    val toastText = listOf("Has fallado", "Has acertado", "Has usado todas las pistas", "Has usado todos los intentos")
    val pistas = mapOf(
        "Hola" to listOf("Saludo", "Hi", "Saludar"),
        "Adios" to listOf("Despedida", "Bye", "Chao"),
        "Casa" to listOf("Hogar", "Vivienda", "Domicilio"),
        "Perro" to listOf("Can", "Mascota", "Animal"),
        "Gato" to listOf("Felino", "Mascota", "Animal"),
        "Pajaro" to listOf("Ave", "Alado", "Volador"),
        "Pescado" to listOf("Pez", "Marino", "Comida"),
        "Cocina" to listOf("Horno", "Cocinar", "Estufa"),
        "Cama" to listOf("Lecho", "Dormir", "Colchón"),
        "Silla" to listOf("Asiento", "Mueble", "Reposo")
    )
}
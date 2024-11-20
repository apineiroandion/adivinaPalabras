package com.example.adivinapalabras

import androidx.compose.runtime.mutableStateOf

class MyViewModel {
    var palabra = mutableStateOf("")
    var palabraJugador = mutableStateOf("")
    var pistaActual = mutableStateOf("")
    var mostrarResultado = mutableStateOf(false)
    var ronda = mutableStateOf(0)
    var intento = mutableStateOf(0)
    var textoRonda = mutableStateOf("")

    fun nuevaPalabra() {
        if (intento.value >= Datos.intentosMax) {
            return
        }
        palabra.value = Datos.palabras.random()
        palabraJugador.value = ""
        pistaActual.value = Datos.pistas[palabra.value]?.random() ?: "Sin pista disponible"
        mostrarResultado.value = false
    }

    fun actualizarPalabraJugador(palabra: String) {
        palabraJugador.value = palabra
    }

    fun comprobarPalabra(): Boolean {
        if (intento.value >= Datos.intentosMax) {
            reiniciarJuego()
            return false
        }
        val acierto = palabra.value.equals(palabraJugador.value, ignoreCase = true)
        if (acierto) {
            ronda.value++
            mostrarResultado.value = true
            textoRonda.value = "Has acertado"
            nuevaPalabra()
        } else {
            if (intento.value < Datos.intentosMax) {
                incrementarIntento()
                textoRonda.value = "Has fallado"
            }
            mostrarResultado.value = true
            if (intento.value >= Datos.intentosMax) {
                textoRonda.value = "Has usado todos los intentos"
                reiniciarJuego()
            }
        }
        return acierto
    }

    fun reiniciarJuego() {
        palabra.value = ""
        pistaActual.value = ""
        palabraJugador.value = ""
        ronda.value = 0
        intento.value = 0
        mostrarResultado.value = false
    }

    fun incrementarIntento() {
        intento.value++
    }

    fun reiniciarIntento() {
        intento.value = 0
    }

    fun comprobarIntento(): Boolean {
        return intento.value >= Datos.intentosMax
    }

}
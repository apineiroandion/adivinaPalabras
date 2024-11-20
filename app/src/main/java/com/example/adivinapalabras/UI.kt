package com.example.adivinapalabras

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@Composable
fun UI(model: MyViewModel) {
    Greeting(MyViewModel = model)
}

@Composable
fun Greeting(modifier: Modifier = Modifier, MyViewModel: MyViewModel) {
    val palabra = MyViewModel.palabra.value
    val palabraJugador = MyViewModel.palabraJugador.value
    val mostrarResultado = MyViewModel.mostrarResultado.value
    val intento = MyViewModel.intento.value
    val ronda = MyViewModel.ronda.value
    val pista = MyViewModel.pistaActual.value
    val textoRonada = MyViewModel.textoRonda.value

    Column (
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = modifier.fillMaxSize()
    ) {
        Text("Ronda: $ronda, Intentos: $intento", fontSize = 20.sp)
        Text("Pista: $pista", fontSize = 24.sp)
        Text(
            text = "Adivina la palabra",
            fontSize = 38.sp,
            modifier = Modifier.padding(vertical = 100.dp),
        )
        TextField(
            value = palabraJugador,
            onValueChange = { MyViewModel.actualizarPalabraJugador(it) },
            label = { Text("Introduce la palabra") },
            modifier = Modifier.padding(16.dp)
        )
        Text(
            text = "Palabra: ${palabra}",
            fontSize = 24.sp,
            modifier = Modifier.padding(vertical = 16.dp),
        )
        Text(
            text = "Intentos: ${intento} de ${Datos.intentosMax}",
            fontSize = 24.sp,
            modifier = Modifier.padding(vertical = 16.dp),
        )

        Button(
            onClick = {
                MyViewModel.nuevaPalabra()
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("START")
        }
        Button(
            onClick = {
                MyViewModel.comprobarPalabra()
            },
            modifier = Modifier.padding(16.dp)
        ) {
            Text("COMPROBAR")
        }
        if (mostrarResultado){
            Text(
                text = textoRonada,
                fontSize = 24.sp,
                modifier = Modifier.padding(vertical = 16.dp),
            )
        }
    }
}
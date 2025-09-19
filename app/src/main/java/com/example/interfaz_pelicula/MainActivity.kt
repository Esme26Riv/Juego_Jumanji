package com.example.interfaz_pelicula

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.runtime.*
import com.example.interfaz_pelicula.ui.theme.pantalla.MenuJumanjiSencillo
import com.example.interfaz_pelicula.ui.theme.pantalla.Personaje
import com.example.interfaz_pelicula.partida.InicioPartida

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            var pantallaActual by remember { mutableStateOf("menu") }
            var personajeSeleccionado by remember { mutableStateOf(Personaje.Smolder_Bravestone) }

            when (pantallaActual) {
                "menu" -> {
                    MenuJumanjiSencillo(
                        onIniciarPartida = { pantallaActual = "partida" }
                    )
                }
                "partida" -> {
                    InicioPartida(personajeSeleccionado, onVolverAlMenu = { pantallaActual = "menu" })
                }
            }
        }
    }
}

package com.example.interfaz_pelicula.ui.theme.moleculas

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color

val Marron_Obscuro = Color(0xFF743012)
val Amarillo_Dorado = Color(0xFFF6B141)

@Composable
fun FormularioTextoConBoton(
    texto: String,
    al_cambiar_el_texto: (String) -> Unit,
    al_pulsar_boton: () -> Unit,
    etiqueta: String = "PLACE HOLDER",
    modificador: Modifier = Modifier
) {
    Row(modifier = modificador.fillMaxWidth()) {
        TextField(
            value = texto,
            onValueChange = al_cambiar_el_texto
        )
        Button(
            onClick = al_pulsar_boton,
            colors = ButtonDefaults.buttonColors(
                containerColor = Marron_Obscuro,
                contentColor = Amarillo_Dorado
            ),
            modifier = Modifier.fillMaxWidth()
        ) {
            Text(etiqueta)
        }
    }
}

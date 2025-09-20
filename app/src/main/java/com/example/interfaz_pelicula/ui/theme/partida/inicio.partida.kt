package com.example.interfaz_pelicula.partida

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.interfaz_pelicula.ui.theme.pantalla.*

val OrangeRed = Color(0xFFFF5E00)
val VerdeFosforescente = Color(0xFF00BB2D)
val Rosa = Color(0xFFFF00FF)

@Composable
fun InicioPartida(personaje: Personaje, onVolverAlMenu: () -> Unit) {
    var estadoPartida by remember { mutableStateOf("inicio") }
    var mensaje by remember { mutableStateOf("Elige tu primer camino en Jumanji...") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Marron_Obscuro)
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        val titulo = when (estadoPartida) {
            "inicio" -> "Iniciando tu aventura en Jumanji"
            "selva", "acantilado" -> "Vas por el camino correcto, sigue así"
            "fin" -> "Fin de la partida"
            "victoria" -> "¡Felicidades! 🎉"
            else -> ""
        }

        Text(
            titulo,
            fontSize = 30.sp,
            fontWeight = FontWeight.Bold,
            color = if (estadoPartida == "victoria") VerdeFosforescente else OrangeRed,
            fontFamily = jumanjiFont,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        if (estadoPartida == "inicio") {
            Text(
                "${personaje.name} (${personaje.actor})",
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
                color = Rosa,
                fontFamily = jumanjiFont
            )
            Spacer(modifier = Modifier.height(20.dp))
        }

        Text(
            mensaje,
            fontSize = 25.sp,
            fontWeight = FontWeight.Bold,
            color = when (mensaje) {
                "Elige tu primer camino en Jumanji...",
                "Te adentras en la selva... ¡Encuentras frutas exóticas!",
                "Llegas a un acantilado, puedes trepar o saltar al otro lado, como Tarzán con una rama.",
                "¡Has superado el acantilado y encontrado un tesoro!" -> Rosa
                "Fin de la partida: ¡Te han comido los cocodrilos!",
                "Fin de la partida: La fruta era venenosa...",
                "Fin de la partida: No te creas Tarzán." -> VerdeFosforescente
                else -> Color.White
            },
            fontFamily = jumanjiFont
        )

        Spacer(modifier = Modifier.height(30.dp))

        when (estadoPartida) {
            "inicio" -> {
                Button(
                    onClick = {
                        mensaje = "Te adentras en la selva... ¡Encuentras frutas exóticas!"
                        estadoPartida = "selva"
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Amarillo_Dorado,
                        contentColor = Marron_Obscuro
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Ir a la Selva", fontWeight = FontWeight.Black, fontFamily = jumanjiFont, fontSize = 20.sp)
                }

                Spacer(modifier = Modifier.height(15.dp))

                Button(
                    onClick = {
                        mensaje = "Fin de la partida: ¡Te han comido los cocodrilos!"
                        estadoPartida = "fin"
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Amarillo_Dorado,
                        contentColor = Marron_Obscuro
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Seguir el Río", fontWeight = FontWeight.Black, fontFamily = jumanjiFont, fontSize = 20.sp)
                }
            }

            "selva" -> {
                Button(
                    onClick = {
                        mensaje = "Llegas a un acantilado, puedes trepar o saltar al otro lado, como Tarzán con una rama."
                        estadoPartida = "acantilado"
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Amarillo_Dorado,
                        contentColor = Marron_Obscuro
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Me aguanto el hambre", fontWeight = FontWeight.Black, fontFamily = jumanjiFont, fontSize = 20.sp)
                }

                Spacer(modifier = Modifier.height(15.dp))

                Button(
                    onClick = {
                        mensaje = "Fin de la partida: La fruta era venenosa..."
                        estadoPartida = "fin"
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Amarillo_Dorado,
                        contentColor = Marron_Obscuro
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Me las como para no morir de hambre", fontWeight = FontWeight.Black, fontFamily = jumanjiFont, fontSize = 20.sp)
                }
            }

            "acantilado" -> {
                Button(
                    onClick = {
                        mensaje = "¡Has superado el acantilado y encontrado un tesoro!"
                        estadoPartida = "victoria"
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Amarillo_Dorado,
                        contentColor = Marron_Obscuro
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Trepas el acantilado", fontWeight = FontWeight.Black, fontFamily = jumanjiFont, fontSize = 20.sp)
                }

                Spacer(modifier = Modifier.height(15.dp))

                Button(
                    onClick = {
                        mensaje = "Fin de la partida: No te creas Tarzán."
                        estadoPartida = "fin"
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Amarillo_Dorado,
                        contentColor = Marron_Obscuro
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text("Cruzas como Tarzán", fontWeight = FontWeight.Black, fontFamily = jumanjiFont, fontSize = 20.sp)
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (estadoPartida == "fin" || estadoPartida == "victoria") {
            Button(
                onClick = {
                    estadoPartida = "inicio"
                    mensaje = "Elige tu primer camino en Jumanji..."
                    onVolverAlMenu()
                },
                colors = ButtonDefaults.buttonColors(
                    containerColor = Amarillo_Dorado,
                    contentColor = Marron_Obscuro
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Terminar partida", fontWeight = FontWeight.Black, fontFamily = jumanjiFont, fontSize = 20.sp)
            }
        }
    }
}


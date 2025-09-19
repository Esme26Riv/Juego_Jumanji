package com.example.interfaz_pelicula.partida

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

val VerdeFosforescente = Color(0xFF00BB2D)


@Composable
fun InicioPartida(personaje: Personaje, onVolverAlMenu: () -> Unit) {
    var estadoPartida by remember { mutableStateOf("inicio") }
    var mensaje by remember { mutableStateOf("Elige tu primer camino en Jumanji...") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp),
        verticalArrangement = Arrangement.Center
    ) {
        // Título dinámico según la etapa de la partida
        val titulo = when (estadoPartida) {
            "inicio" -> "Iniciando tu aventura en Jumanji"
            "selva", "acantilado" -> "Vas por el camino correcto, sigue asi"
            "fin" -> "Fin de la partida"
            "victoria" -> "¡Victoria!"
            else -> ""
        }

        Text(
            titulo,
            fontSize = 28.sp,
            fontWeight = FontWeight.Bold,
            color = VerdeFosforescente,
            fontFamily = jumanjiFont,
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(20.dp))

        // Datos del personaje solo se muestran al inicio
        if (estadoPartida == "inicio") {
            Text(
                "${personaje.name} (${personaje.actor})",
                fontSize = 20.sp,
                fontWeight = FontWeight.SemiBold,
                color = Marron_Obscuro,
                fontFamily = jumanjiFont
            )
            Spacer(modifier = Modifier.height(20.dp))
        }

        Text(
            mensaje,
            fontSize = 18.sp,
            fontWeight = FontWeight.Medium,
            fontFamily = jumanjiFont
        )

        Spacer(modifier = Modifier.height(30.dp))

        when (estadoPartida) {
            "inicio" -> {
                Button(
                    onClick = {
                        mensaje = "Te adentras en la selva... ¡Encuentras frutas exoticas!"
                        estadoPartida = "selva"
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        "Ir a la Selva ",
                        fontWeight = FontWeight.Black,
                        fontFamily = jumanjiFont
                    )
                }

                Spacer(modifier = Modifier.height(15.dp))

                Button(
                    onClick = {
                        mensaje = "Fin de la partida: ¡Te han comido los cocodrilos!"
                        estadoPartida = "fin"
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        "Seguir el Río ",
                        fontWeight = FontWeight.Black,
                        fontFamily = jumanjiFont
                    )
                }
            }

            "selva" -> {
                Button(
                    onClick = {
                        mensaje = "Llegas a un acantilado, puedes trepar o saltar al otro lado, como tarzan con una rama que cuelga."
                        estadoPartida = "acantilado"
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        "Me aguanto el hambre",
                        fontFamily = jumanjiFont,

                        )
                }


                Spacer(modifier = Modifier.height(15.dp))

                Button(
                    onClick = {
                        mensaje = "Fin de la partida: No te comas todo lo que veas. La fruta era venenosa...."
                        estadoPartida = "fin"
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        "Me las como para no morir de hambre",
                        fontFamily = jumanjiFont
                    )
                }
            }

            "acantilado" -> {
                Button(
                    onClick = {
                        mensaje = "¡Has superado el acantilado y encontrado un tesoro!"
                        estadoPartida = "¡Felicidades has ganado!"
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        "Trepas el acantilado",
                        fontFamily = jumanjiFont
                    )
                }

                Spacer(modifier = Modifier.height(15.dp))

                Button(
                    onClick = {
                        mensaje = "Fin de la partida: No te creas Tarzan."
                        estadoPartida = "fin"
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Black,
                        contentColor = Color.White
                    ),
                    modifier = Modifier.fillMaxWidth()
                ) {
                    Text(
                        "Cruzas como Tarzan",
                        fontFamily = jumanjiFont
                    )
                }
            }
        }

        Spacer(modifier = Modifier.height(20.dp))

        if (estadoPartida == "fin" || estadoPartida == "victoria") {
            Button(
                onClick = onVolverAlMenu,
                colors = ButtonDefaults.buttonColors(
                    containerColor = Marron_Obscuro,
                    contentColor = Amarillo_Dorado
                ),
                modifier = Modifier.fillMaxWidth()
            ) {
                Text(
                    "Volver al menú",
                    fontFamily = jumanjiFont
                )
            }
        }
    }
}

package com.example.interfaz_pelicula.ui.theme.pantalla

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.interfaz_pelicula.ui.theme.moleculas.FormularioTextoConBoton
import com.example.interfaz_pelicula.R

val Marron_Obscuro = Color(0xFF743012)
val Amarillo_Dorado = Color(0xFFF6B141)
val VerdeFosforescente = Color(0xFF00BB2D)
val Rosa = Color(0xFFFF00FF)
val OrangeRed = Color(0xFFFF5E00)


val jumanjiFont = FontFamily(Font(R.font.calculator))

enum class Personaje(
    val actor: String,
    val fortalezas: Array<String>,
    val debilidades: Array<String>
) {
    Smolder_Bravestone(
        "Dwayne Johnson",
        arrayOf("Increíble", "Velocidad", "Escalada", "Boomerang", "Intensidad Ardiente"),
        arrayOf("Navaja automática")
    ),
    Ruby_Roundhouse(
        "Karen Gillan",
        arrayOf("Karate", "T’ai chi", "Aikido", "Danza de pelea", "Nunchuks"),
        arrayOf("Veneno")
    ),
    Mouse_Finbar(
        "Kevin Hart",
        arrayOf("Zoología", "Armas valet", "Lingüistica"),
        arrayOf("Pastel", "Velocidad", "Fuerza")
    ),
    Shelly_Oberon(
        "Jack Black",
        arrayOf("Cartografia", "Arqueologia", "Paleontologia", "Geometria"),
        arrayOf("Resistencia", "Calor", "Sol", "Arena")
    ),
    Ming_Fleetfoot(
        "Awkwafina",
        arrayOf("Ladra de gatos", "Carterista", "Experta en cajas fuertes"),
        arrayOf("Polen")
    )
}

@Composable
fun MenuJumanjiSencillo(onIniciarPartida: (() -> Unit)? = null) {
    var inputNumero by remember { mutableStateOf("") }
    var pantallaActual by remember { mutableStateOf("menu") }
    var personajeSeleccionado by remember { mutableStateOf(Personaje.Smolder_Bravestone) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(Marron_Obscuro)
            .padding(12.dp)
    ) {
        when (pantallaActual) {
            "menu" -> {
                Text(
                    "\nBienvenido a Jumanji",
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp),
                    fontSize = 60.sp,
                    color = VerdeFosforescente,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = jumanjiFont,
                    textAlign = TextAlign.Center
                )
                Text(
                    "\nElige que avatar quieres ser. Escribiendo el numero:\n",
                    fontFamily = jumanjiFont,
                    color = OrangeRed,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 35.sp
                )

                Personaje.values().forEachIndexed { index, personaje ->
                    Text(
                        "${index + 1}. ${personaje.name} (${personaje.actor})",
                        fontFamily = jumanjiFont,
                        color = Rosa,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = 25.sp
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                FormularioTextoConBoton(
                    texto = inputNumero,
                    al_cambiar_el_texto = { inputNumero = it },
                    al_pulsar_boton = {
                        val numero = inputNumero.toIntOrNull()
                        if (numero != null && numero in 1..Personaje.values().size) {
                            personajeSeleccionado = Personaje.values()[numero - 1]
                            pantallaActual = "juego"
                        }
                    },
                    etiqueta = "Elegir",
                    modificador = Modifier.fillMaxWidth()
                )
            }

            "juego" -> {
                Text(
                    text = "\n¡Felicidades!",
                    color = VerdeFosforescente,
                    fontSize = 70.sp,
                    fontWeight = FontWeight.Black,
                    fontFamily = jumanjiFont
                )
                Text(
                    "\nAhora Eres: ${personajeSeleccionado.name}, " +
                            "\nRepresentado por el actor: ${personajeSeleccionado.actor}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 30.sp,
                    color = Rosa,
                    fontFamily = jumanjiFont
                )
                Text(
                    "\nPoderes y debilidades de tu avatar son:",
                    fontWeight = FontWeight.Black,
                    color = Color.White,
                    fontFamily = jumanjiFont,
                    fontSize = 25.sp
                )

                Row(
                    modifier = Modifier
                        .fillMaxHeight(0.5f)
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .border(
                            width = 3.dp,
                            color = Color.White,
                            shape = RoundedCornerShape(12.dp)
                        )
                        .background(Color.White, shape = RoundedCornerShape(12.dp))
                        .padding(5.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .clip(RoundedCornerShape(8.dp))
                            .border(1.dp, Marron_Obscuro, RoundedCornerShape(8.dp))
                            .background(Amarillo_Dorado, RoundedCornerShape(8.dp))
                            .padding(10.dp)
                    ) {
                        Text(
                            "PODERES\n",
                            fontWeight = FontWeight.ExtraBold,
                            color = OrangeRed,
                            fontFamily = jumanjiFont,
                            fontSize = 35.sp,
                            textAlign = TextAlign.Center
                        )
                        personajeSeleccionado.fortalezas.forEach {
                            Text("• $it",
                                fontFamily = jumanjiFont,
                                color = Marron_Obscuro,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }

                    Spacer(modifier = Modifier.width(10.dp))

                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .clip(RoundedCornerShape(8.dp))
                            .border(1.dp, Marron_Obscuro, RoundedCornerShape(8.dp))
                            .background(Amarillo_Dorado, RoundedCornerShape(8.dp))
                            .padding(10.dp)
                    ) {
                        Text(
                            "DEBILIDADES\n",
                            fontWeight = FontWeight.ExtraBold,
                            color = OrangeRed,
                            fontFamily = jumanjiFont,
                            fontSize = 35.sp,
                            textAlign = TextAlign.Center
                        )
                        personajeSeleccionado.debilidades.forEach {
                            Text("• $it",
                                fontFamily = jumanjiFont,
                                color = Marron_Obscuro,
                                fontSize = 20.sp,
                                fontWeight = FontWeight.SemiBold
                            )
                        }
                    }
                }

                // Botón para iniciar partida
                onIniciarPartida?.let {
                    androidx.compose.material3.Button(
                        onClick = it,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Amarillo_Dorado,
                            contentColor = Marron_Obscuro
                        ),
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(top = 20.dp)
                    ) {
                        androidx.compose.material3.Text(
                            "Iniciar Partida",
                            fontSize = 20.sp
                        )
                    }
                }
            }
        }
    }
}

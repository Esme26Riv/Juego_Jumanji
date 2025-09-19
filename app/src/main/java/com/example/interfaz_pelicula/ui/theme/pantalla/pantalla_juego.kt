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

val VerdeFosforescente = Color(0xFF00BB2D)
val Marron_Obscuro = Color(0xFF743012)
val Amarillo_Dorado = Color(0xFFF6B141)
val Rosa = Color(0xFFB814B8)

val jumanjiFont = FontFamily(Font(R.font.calculator))  // Replace "jumanji_font" with your actual font file name


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
        arrayOf("Zoología", "Armas valet", "Lingüística"),
        arrayOf("Pastel", "Velocidad", "Fuerza")
    ),
    Shelly_Oberon(
        "Jack Black",
        arrayOf("Cartografía", "Arqueología", "Paleontología", "Geometría"),
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

    Column(modifier = Modifier.fillMaxSize().padding(12.dp)) {
        when (pantallaActual) {
            "menu" -> {
                Text(
                    "\nBienvenido a Jumanji",
                    modifier = Modifier
                        .fillMaxWidth()
                        .background(Marron_Obscuro)
                        .padding(8.dp),
                    fontSize = 40.sp,
                    color = Amarillo_Dorado,
                    fontWeight = FontWeight.ExtraBold,
                    fontFamily = jumanjiFont,
                    textAlign = TextAlign.Center
                )
                Text(
                    "\nElige qué avatar quieres ser. Escribiendo el número:\n",
                    fontFamily = jumanjiFont,
                    color = VerdeFosforescente,
                    fontWeight = FontWeight.SemiBold,
                    fontSize = 20.sp
                )

                Personaje.values().forEachIndexed { index, personaje ->
                    Text("${index + 1}. ${personaje.name} (${personaje.actor})",
                        fontFamily = jumanjiFont,
                        color = Rosa,
                        fontWeight = FontWeight.SemiBold
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
                    "\n¡Felicidades!",
                    color = Rosa,
                    fontSize = 50.sp,
                    fontWeight = FontWeight.Black,
                    fontFamily = jumanjiFont
                )
                Text(
                    "\nAhora Eres: ${personajeSeleccionado.name}, " +
                            "\nRepresentado por el actor: ${personajeSeleccionado.actor}",
                    fontWeight = FontWeight.Bold,
                    fontSize = 22.sp,
                    color = Marron_Obscuro,
                    fontFamily = jumanjiFont
                )
                Text(
                    "\nPoderes y debilidades de tu avatar son:",
                    fontWeight = FontWeight.Bold,
                    color = Rosa,
                    fontFamily = jumanjiFont
                )

                Row(
                    modifier = Modifier
                        .fillMaxHeight(0.5f)
                        .fillMaxWidth()
                        .padding(top = 12.dp)
                        .clip(RoundedCornerShape(12.dp))
                        .border(width = 3.dp, color = Marron_Obscuro, shape = RoundedCornerShape(12.dp))
                        .background(Amarillo_Dorado, shape = RoundedCornerShape(12.dp))
                        .padding(12.dp)
                ) {
                    Column(
                        modifier = Modifier
                            .weight(1f)
                            .fillMaxHeight()
                            .clip(RoundedCornerShape(8.dp))
                            .border(1.dp, Marron_Obscuro, RoundedCornerShape(8.dp))
                            .background(Color.White, RoundedCornerShape(8.dp))
                            .padding(10.dp)
                    ) {
                        Text(
                            "PODERES\n",
                            fontWeight = FontWeight.Black,
                            color = Marron_Obscuro,
                            fontFamily = jumanjiFont,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                        personajeSeleccionado.fortalezas.forEach {
                            Text("• $it",
                                fontFamily = jumanjiFont,
                                color = VerdeFosforescente,
                                fontWeight = FontWeight.Black
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
                            .background(Color.White, RoundedCornerShape(8.dp))
                            .padding(10.dp)
                    ) {
                        Text(
                            "DEBILIDADES\n",
                            fontWeight = FontWeight.Black,
                            color = Marron_Obscuro,
                            fontFamily = jumanjiFont,
                            fontSize = 18.sp,
                            textAlign = TextAlign.Center
                        )
                        personajeSeleccionado.debilidades.forEach {
                            Text("• $it",
                                fontFamily = jumanjiFont,
                                color = VerdeFosforescente,
                                fontWeight = FontWeight.Black
                            )
                        }
                    }
                }

                // Botón para iniciar partida
                onIniciarPartida?.let {
                    androidx.compose.material3.Button(
                        onClick = it,
                        colors = ButtonDefaults.buttonColors(
                            containerColor = Marron_Obscuro,
                            contentColor = Amarillo_Dorado
                        ),
                        modifier = Modifier.fillMaxWidth().padding(top = 20.dp)
                    ) {
                        androidx.compose.material3.Text("Iniciar Partida")
                    }
                }
            }
        }
    }
}

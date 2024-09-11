package cl.bootcamp.ejercicioindividual7

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import cl.bootcamp.ejercicioindividual7.ui.theme.EjercicioIndividual7Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EjercicioIndividual7Theme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    pantalla(
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}


@Composable
fun pantalla(modifier: Modifier = Modifier) {
    var isImagenVisible by rememberSaveable { mutableStateOf(false) }

    Column(
        modifier = Modifier
            .fillMaxSize()
    ) {
        TextoBienvenida(modifier = Modifier)
        TextoNombre(modifier = Modifier)
        Spacio(modifier = Modifier)
        // Pasar la acción del click correctamente para alternar la visibilidad
        BtnImagen(modifier = Modifier, isImagenVisible) {
            isImagenVisible = !isImagenVisible
        }
        // Mostrar la imagen solo si isImagenVisible es true
        if (isImagenVisible) {
            ImagenBtn(modifier = Modifier.fillMaxSize())
        }
    }
}

@Composable
fun BtnImagen(modifier: Modifier, isImagenVisible: Boolean, onClick: () -> Unit) {
    Box(
        modifier = Modifier.fillMaxWidth(),
        contentAlignment = Alignment.Center
    ) {
        Button(
            modifier = Modifier.align(alignment = Alignment.Center),
            shape = RoundedCornerShape(20),
            // Ejecutar el callback para alternar la visibilidad
            onClick = onClick
        ) {
            // Mostrar el texto dinámicamente según la visibilidad de la imagen
            Text(
                text = if (isImagenVisible) stringResource(id = R.string.cerrar) else stringResource(id = R.string.abrir))
        }
    }
}

@Composable
fun ImagenBtn(modifier: Modifier) {
    Image(
        painter = painterResource(id = R.drawable.imagen),
        contentDescription = null,
        modifier = Modifier.fillMaxWidth()
    )
}

@Composable
fun TextoBienvenida(modifier: Modifier) {
    Text(
        text = stringResource(id = R.string.bienvenido),
        fontSize = 40.sp,
        fontWeight = FontWeight.ExtraBold,
        modifier = modifier.fillMaxWidth()
            .padding(20.dp),
        textAlign = TextAlign.Center
    )
}

@Composable
fun TextoNombre(modifier: Modifier) {
    Text(
        text = stringResource(id = R.string.nombre),
        modifier = modifier.fillMaxWidth(),
        fontSize = 25.sp,
        fontWeight = FontWeight.Black,
        textAlign = TextAlign.Center
    )
}

@Composable
fun Spacio(modifier: Modifier) {
    Spacer(modifier = Modifier.height(20.dp))
}

@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    EjercicioIndividual7Theme {
        pantalla()
    }
}
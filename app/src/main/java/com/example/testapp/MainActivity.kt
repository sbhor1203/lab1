package com.example.testapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.testapp.ui.theme.TestappTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent { // no tocar
            TestappTheme { // no tocar
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding -> // no tocar
                    MyApp(
                        name = "Dear User",
                        modifier = Modifier.padding(innerPadding)
                            .padding(innerPadding)
                            .background(Color(0xFFADD8E6))

                    )
                }
            }
        }
    }
}

@Composable
fun MyApp(name: String, modifier: Modifier = Modifier) {
    var showMessage by remember { mutableStateOf(false) }


    Column(
        modifier = modifier
            .fillMaxSize()
            .padding(16.dp),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center
    ) {

        Greeting(name = name)
        Spacer(modifier = Modifier.height(32.dp))

        Text(
            text = "Bienvenido a CatGame ;)",
            fontSize = 24.sp,
            fontWeight = FontWeight.Bold,
            color = Color(0xFF1E88E5)

        )
        Spacer(modifier = Modifier.height(16.dp))
        Text(
            text = "Esperamos que te diviertas mucho",
            fontSize = 20.sp
        )
        Spacer(modifier = Modifier.height(40.dp))
        Text(
            text = "Para continuar por favor presiona el botón de abajo",
            fontSize = 10.sp ,
            color = Color(0xFFD32F2F)
        )
        Spacer(modifier = Modifier.height(32.dp))

        // Botón
        Button(onClick = { showMessage = !showMessage }) {
            Text(text = "Iniciar")
        }

        // Acción al presionar el botón
        if (showMessage) {
            Spacer(modifier = Modifier.height(16.dp))
            Text(text = "Inicializando Juego!", fontSize = 18.sp, color = MaterialTheme.colorScheme.primary)
        }


        // Greeting
        Spacer(modifier = Modifier.height(32.dp))
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier) {
    Text(
        text = "Hello $name!",
        modifier = modifier,
        fontSize = 24.sp,
        fontWeight =  FontWeight.Bold,
        color = Color(0xFF1E88E5)
    )
}

@Preview(
    showBackground = true,
    showSystemUi = true // habilita la interfaz para ver un preview
)
@Composable
fun MyAppPreview() {
    TestappTheme {
        MyApp(name = "Dear User")
    }
}
package pe.edu.idat.ec1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.input.TextFieldValue
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import pe.edu.idat.ec1.ui.theme.EC1Theme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            EC1Theme {
                val navController = rememberNavController()
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    NavHost(
                        navController = navController,
                        startDestination = "menu",
                        modifier = Modifier.padding(innerPadding)
                    ) {
                        composable("menu") { MenuScreen(navController) }
                        composable("pantalla1") { Pantalla1() }
                        composable("pantalla2") { Pantalla2() }
                        composable("pantalla3") { Pantalla3() }
                        composable("pantalla4") { Pantalla4() }
                    }
                }
            }
        }
    }
}

@Composable
fun MenuScreen(navController: NavHostController) {
    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center
    ) {
        Button(
            onClick = { navController.navigate("pantalla1") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text("Ejercicio 1")
        }
        Button(
            onClick = { navController.navigate("pantalla2") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text("Ejercicio 2")
        }
        Button(
            onClick = { navController.navigate("pantalla3") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text("Ejercicio 3")
        }
        Button(
            onClick = { navController.navigate("pantalla4") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp)
        ) {
            Text("Ejercicio 4")
        }
    }
}

@Composable
fun Pantalla1() {
    var cantidad by remember { mutableStateOf(TextFieldValue("")) }
    var precio by remember { mutableStateOf(TextFieldValue("")) }
    var result by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = cantidad,
            onValueChange = { cantidad = it },
            label = { Text("Ingrese la Cantidad") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(8.dp))
        OutlinedTextField(
            value = precio,
            onValueChange = { precio = it },
            label = { Text("Ingrese el Precio") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val cant = cantidad.text.toDoubleOrNull() ?: 0.0
                val prc = precio.text.toDoubleOrNull() ?: 0.0
                val total = cant * prc
                result = if (total > 200) {
                    val dsctoTotal = total * 0.8
                    "Total: $total\nDesctuento Total: $dsctoTotal"
                } else {
                    "Total: $total"
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular")
        }
        Spacer(modifier = Modifier.height(16.dp))
        result?.let {
            Text(text = it)
        }
    }
}

@Composable
fun Pantalla2() {
    var MontoPrestamo by remember { mutableStateOf(TextFieldValue("")) }
    var result by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = MontoPrestamo,
            onValueChange = { MontoPrestamo = it },
            label = { Text("Monto de prestamo") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val prestamo = MontoPrestamo.text.toDoubleOrNull() ?: 0.0
                val (numcuotas, interes) = when {
                    prestamo > 5000 -> 3 to 0.10
                    prestamo < 1000 -> 1 to 0.12
                    prestamo in 2000.0..3000.0 -> 2 to 0.12
                    else -> 5 to 0.12
                }
                val totalMonto = prestamo * (1 + interes)
                val MontoCuota = totalMonto / numcuotas
                result = "Número de cuotas: $numcuotas\n" +
                        "Total con Intereses: $totalMonto\n" +
                        "Monto por cuota: $MontoCuota"
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular")
        }
        Spacer(modifier = Modifier.height(16.dp))
        result?.let {
            Text(text = it)
        }
    }
}

@Composable
fun Pantalla3() {
    var num by remember { mutableStateOf(TextFieldValue("")) }
    var result by remember { mutableStateOf<String?>(null) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = num,
            onValueChange = { num = it },
            label = { Text("Ingrese un número del 1 al 5") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val num = num.text.toIntOrNull() ?: 0
                val vocal = when (num) {
                    1 -> "es: A"
                    2 -> "es: E"
                    3 -> "es: I"
                    4 -> "es: O"
                    5 -> "es: U"
                    else -> "no existe, debes ingresar de 0 a 5"
                }
                result = "La vocal correspondiente $vocal"
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Busca la Vocal")
        }
        Spacer(modifier = Modifier.height(16.dp))
        result?.let {
            Text(text = it)
        }
    }
}

@Composable
fun Pantalla4() {
    var limit by remember { mutableStateOf(TextFieldValue("")) }
    var results by remember { mutableStateOf<List<Pair<Int, Pair<Int, Int>>>>(emptyList()) }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        OutlinedTextField(
            value = limit,
            onValueChange = { limit = it },
            label = { Text("Ingresa el Limite") },
            modifier = Modifier.fillMaxWidth()
        )
        Spacer(modifier = Modifier.height(16.dp))
        Button(
            onClick = {
                val lim = limit.text.toIntOrNull() ?: 0
                results = (1..lim).map { it to (it * it * it to it * it * it * it) }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Calcular")
        }
        Spacer(modifier = Modifier.height(16.dp))
        results.let { list ->
            Column {
                list.forEach { (num, powers) ->
                    Text(text = "Número: $num, Cubo: ${powers.first}, Cuarta: ${powers.second}")
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EC1Theme {
        val navController = rememberNavController()
        MenuScreen(navController = navController)
    }
}
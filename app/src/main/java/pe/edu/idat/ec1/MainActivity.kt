package pe.edu.idat.ec1

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.material3.Button
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
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
    Text(
            text = "Esta es la pantalla 1",
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
    )
}

@Composable
fun Pantalla2() {
    Text(
        text = "Esta es la pantalla 2",
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
    )
}

@Composable
fun Pantalla3() {
    Text(
        text = "Esta es la pantalla 3",
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
    )
}

@Composable
fun Pantalla4() {
    Text(
        text = "Esta es la pantalla 4",
        modifier = Modifier
            .fillMaxSize()
            .wrapContentSize()
    )
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    EC1Theme {
        val navController = rememberNavController()
        MenuScreen(navController = navController)
    }
}
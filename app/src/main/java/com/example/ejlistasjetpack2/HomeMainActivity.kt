package com.example.ejlistasjetpack2

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.Button
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import androidx.navigation.navArgument
import coil.compose.rememberImagePainter
import com.example.ejlistasjetpack2.ui.theme.EjListasJetPack2Theme
import data.Montaje
import data.PantallaSealed
import data.activity2
import data.montajes


class MainActivity : ComponentActivity() {
    lateinit var navController: NavHostController
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            EjListasJetPack2Theme {

                Surface(color = MaterialTheme.colors.background) {

                    navController = rememberNavController()
                    NavigationComponent()
                }
            }
        }
    }
}

@Composable
fun NavigationComponent() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = "Home") {
        composable("Home") {
            DescripcionList(navController = navController)
        }
        composable(
            PantallaSealed.pantalla2.route,
            arguments = listOf(navArgument("titulo") {
                type = NavType.StringType
            }, navArgument("img") {
                type = NavType.StringType
            }, navArgument("precio") {
                type = NavType.StringType
            })
        ) { navBackStackEntry ->
            activity2(
                navBackStackEntry.arguments?.getString("titulo")!!,
                navBackStackEntry.arguments?.getString("img")!!,
                navBackStackEntry.arguments?.getString("precio")!!
            )
        }
    }
}


@Composable
fun DescripcionList(navController: NavController) {
    LazyColumn(
        modifier = Modifier
            .fillMaxSize()
    ) {
        items(montajes) { item ->
            Row(modifier = Modifier.clickable {
                navController.navigate(
                    PantallaSealed.pantalla2.parametrosProductos(
                        item.productos.nombre,
                        item.productos.imagen.replace("/", "\\"),
                        item.productos.precio
                    )
                )
            }) {
                ModeloItem(montaje = item)
            }
        }
    }
}

@Composable
fun ModeloItem(montaje: Montaje) {
    Row(
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(
            modifier = Modifier
                .size(80.dp)
                .padding(8.dp), painter = rememberImagePainter(montaje.productos.imagen),
            contentDescription = "Imagen del producto"
        )
        Column(
            modifier = Modifier
                .align(Alignment.CenterVertically)
                .weight(1f)
        ) {
            Text(
                modifier = Modifier.padding(2.dp),
                text = montaje.productos.nombre,
                fontWeight = FontWeight.Bold
            )
            Text(
                modifier = Modifier.padding(2.dp),
                text = montaje.productos.precio
            )
        }
        Text(
            modifier = Modifier.padding(5.dp),
            text = montaje.productos.descuento
        )
    }
}


@Preview(showBackground = true)
@Composable
fun ModeloItemPreview() {
    EjListasJetPack2Theme {

    }
}



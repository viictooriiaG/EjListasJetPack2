package data

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import coil.compose.rememberImagePainter

@Composable
fun activity2(titulo: String, img: String, precio: String) {
    Column(
        modifier = Modifier.fillMaxSize()



    ) {
        Image(
            modifier = Modifier
                .fillMaxWidth()
                .height(400.dp)
                .padding(bottom = 10.dp)
                .padding(8.dp), painter = rememberImagePainter(img),
            contentDescription = "Imagen del producto"
        )
        Text(

            text = precio,
            fontWeight = FontWeight.Bold,
            fontSize = 40.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth().padding(bottom = 20.dp),
            color = Color.Unspecified
        )

        Text(
            text = titulo,
            fontWeight = FontWeight.Bold,
            fontSize = 30.sp,
            textAlign = TextAlign.Center,
            modifier = Modifier.fillMaxWidth()
        )





    }
}



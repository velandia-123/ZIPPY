package com.zippy.zippy.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import ui.ZippyBackground
import ui.ZippyBlue
import ui.ZippySurface

@Composable
fun RegisterSelectionScreen(

    onBusinessClick: () -> Unit,

    onDeliveryClick: () -> Unit,

    onBackClick: () -> Unit

) {

    Column(

        modifier = Modifier
            .fillMaxSize()
            .background(ZippyBackground)
            .padding(24.dp),

        horizontalAlignment = Alignment.CenterHorizontally

    ) {

        Spacer(modifier = Modifier.height(30.dp))

        Text(

            text = "Crear cuenta",

            style = MaterialTheme.typography.headlineMedium

        )

        Spacer(modifier = Modifier.height(10.dp))

        Text(

            text = "¿Cómo deseas registrarte?",

            fontSize = 16.sp

        )

        Spacer(modifier = Modifier.height(35.dp))

        Card(

            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onBusinessClick()
                },

            colors = CardDefaults.cardColors(
                containerColor = ZippyBlue
            ),

            shape = RoundedCornerShape(18.dp)

        ) {

            Column(
                modifier = Modifier.padding(24.dp)
            ) {

                Text(
                    text = "🏪 Empresa / Negocio",
                    color = Color.White,
                    fontSize = 22.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Publicar domicilios y administrar pedidos.",
                    color = Color.White
                )

            }

        }

        Spacer(modifier = Modifier.height(24.dp))

        Card(

            modifier = Modifier
                .fillMaxWidth()
                .clickable {
                    onDeliveryClick()
                },

            colors = CardDefaults.cardColors(
                containerColor = ZippySurface
            ),

            shape = RoundedCornerShape(18.dp)

        ) {

            Column(
                modifier = Modifier.padding(24.dp)
            ) {

                Text(
                    text = "🛵 Domiciliario",
                    fontSize = 22.sp
                )

                Spacer(modifier = Modifier.height(8.dp))

                Text(
                    text = "Aceptar pedidos y realizar entregas."
                )

            }

        }

        Spacer(modifier = Modifier.weight(1f))

        OutlinedButton(

            onClick = {
                onBackClick()
            },

            modifier = Modifier.fillMaxWidth()

        ) {

            Text("Volver")

        }

    }

}
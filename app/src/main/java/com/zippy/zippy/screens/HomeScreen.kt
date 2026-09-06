package com.zippy.zippy.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ui.ZippyBackground
import ui.ZippyBlue
import ui.ZippySurface
import ui.ZippyText
import ui.ZippyTextSecondary

@Composable
fun HomeScreen(
    onPublishClick: () -> Unit,
    onOrdersClick: () -> Unit,
    onAvailableOrdersClick: () -> Unit,
    onProfileClick: () -> Unit
) {

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(ZippyBackground)
            .padding(24.dp),
        horizontalAlignment = Alignment.CenterHorizontally
    ) {

        Spacer(
            modifier = Modifier.height(30.dp)
        )

        Text(
            text = "ZIPPY",
            color = ZippyBlue,
            style = MaterialTheme.typography.headlineLarge
        )

        Spacer(
            modifier = Modifier.height(8.dp)
        )

        Text(
            text = "Domicilios Inteligentes",
            color = ZippyTextSecondary,
            style = MaterialTheme.typography.bodyLarge
        )

        Spacer(
            modifier = Modifier.height(35.dp)
        )

        Text(
            text = "Panel principal",
            color = ZippyText,
            style = MaterialTheme.typography.headlineSmall
        )

        Spacer(
            modifier = Modifier.height(25.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(
                containerColor = ZippySurface
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "🏪 Publicar domicilio",
                    style = MaterialTheme.typography.titleLarge,
                    color = ZippyText
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "Crea un nuevo domicilio para que un domiciliario pueda aceptarlo.",
                    color = ZippyTextSecondary
                )

                Spacer(
                    modifier = Modifier.height(15.dp)
                )

                Button(
                    onClick = onPublishClick,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                ) {

                    Text("Publicar domicilio")
                }
            }
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(
                containerColor = ZippySurface
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "🛵 Pedidos disponibles",
                    style = MaterialTheme.typography.titleLarge,
                    color = ZippyText
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "Consulta los domicilios disponibles y acepta uno para realizar la entrega.",
                    color = ZippyTextSecondary
                )

                Spacer(
                    modifier = Modifier.height(15.dp)
                )

                Button(
                    onClick = onAvailableOrdersClick,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                ) {

                    Text("Ver pedidos disponibles")
                }
            }
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

        Card(
            modifier = Modifier.fillMaxWidth(),
            shape = RoundedCornerShape(18.dp),
            colors = CardDefaults.cardColors(
                containerColor = ZippySurface
            )
        ) {

            Column(
                modifier = Modifier.padding(20.dp)
            ) {

                Text(
                    text = "📦 Mis pedidos",
                    style = MaterialTheme.typography.titleLarge,
                    color = ZippyText
                )

                Spacer(
                    modifier = Modifier.height(8.dp)
                )

                Text(
                    text = "Consulta los domicilios publicados y su estado actual.",
                    color = ZippyTextSecondary
                )

                Spacer(
                    modifier = Modifier.height(15.dp)
                )

                OutlinedButton(
                    onClick = onOrdersClick,
                    modifier = Modifier.fillMaxWidth(),
                    shape = RoundedCornerShape(12.dp)
                ) {

                    Text("Ver mis pedidos")
                }
            }
        }

        Spacer(
            modifier = Modifier.weight(1f)
        )

        OutlinedButton(
            onClick = onProfileClick,
            modifier = Modifier.fillMaxWidth()
        ) {

            Text("Mi perfil")
        }
    }
}
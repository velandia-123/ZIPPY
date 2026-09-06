package com.zippy.zippy.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.OutlinedButton
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.zippy.zippy.viewmodel.OrderRepository

@Composable
fun MyOrdersScreen(
    onBackClick: () -> Unit
) {

    val pedidos = OrderRepository.orders

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Mis pedidos",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        if (pedidos.isEmpty()) {

            Text(
                text = "Aún no hay pedidos publicados."
            )

        } else {

            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {

                items(
                    items = pedidos,
                    key = { pedido ->
                        pedido.hashCode()
                    }
                ) { pedido ->

                    Card(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(bottom = 12.dp),

                        elevation = CardDefaults.cardElevation(
                            defaultElevation = 5.dp
                        )
                    ) {

                        Column(
                            modifier = Modifier.padding(16.dp)
                        ) {

                            Text(
                                text = "Negocio: ${pedido.negocio}",
                                style = MaterialTheme.typography.titleMedium
                            )

                            Spacer(
                                modifier = Modifier.height(6.dp)
                            )

                            Text(
                                text = "Cliente: ${pedido.cliente}"
                            )

                            Text(
                                text = "Dirección: ${pedido.direccion}"
                            )

                            Text(
                                text = "Teléfono: ${pedido.telefono}"
                            )

                            Text(
                                text = "Valor: ${pedido.valor}"
                            )

                            if (pedido.observaciones.isNotBlank()) {

                                Text(
                                    text = "Observaciones: ${pedido.observaciones}"
                                )

                            }

                            Spacer(
                                modifier = Modifier.height(8.dp)
                            )

                            Text(
                                text = "Estado: ${pedido.estado}",
                                style = MaterialTheme.typography.titleSmall
                            )
                        }
                    }
                }
            }
        }

        Spacer(
            modifier = Modifier.height(16.dp)
        )

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
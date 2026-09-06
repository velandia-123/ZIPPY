package com.zippy.zippy.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.zippy.zippy.viewmodel.OrderRepository

@Composable
fun AvailableOrdersScreen(
    onBackClick: () -> Unit
) {

    val context = LocalContext.current

    // Solo mostramos los pedidos que todavía están pendientes
    val pedidos = OrderRepository.orders.filter {
        it.estado == "Pendiente"
    }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
    ) {

        Text(
            text = "Pedidos disponibles",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        if (pedidos.isEmpty()) {

            Text(
                text = "No hay domicilios disponibles en este momento."
            )

        } else {

            LazyColumn(
                modifier = Modifier.weight(1f)
            ) {

                items(pedidos) { pedido ->

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
                                text = "Negocio: ${pedido.negocio}"
                            )

                            Spacer(
                                modifier = Modifier.height(5.dp)
                            )

                            Text(
                                text = "Cliente: ${pedido.cliente}"
                            )

                            Spacer(
                                modifier = Modifier.height(5.dp)
                            )

                            Text(
                                text = "Dirección: ${pedido.direccion}"
                            )

                            Spacer(
                                modifier = Modifier.height(5.dp)
                            )

                            Text(
                                text = "Teléfono: ${pedido.telefono}"
                            )

                            Spacer(
                                modifier = Modifier.height(5.dp)
                            )

                            Text(
                                text = "Pago: ${pedido.valor}"
                            )

                            Spacer(
                                modifier = Modifier.height(5.dp)
                            )

                            Text(
                                text = "Observaciones: ${pedido.observaciones}"
                            )

                            Spacer(
                                modifier = Modifier.height(12.dp)
                            )

                            Text(
                                text = "Estado: ${pedido.estado}"
                            )

                            Spacer(
                                modifier = Modifier.height(16.dp)
                            )

                            Button(
                                onClick = {

                                    val indice =
                                        OrderRepository.orders.indexOf(pedido)

                                    if (indice >= 0) {

                                        OrderRepository.orders[indice] =
                                            pedido.copy(
                                                estado = "Aceptado"
                                            )

                                        Toast.makeText(
                                            context,
                                            "Domicilio aceptado correctamente",
                                            Toast.LENGTH_SHORT
                                        ).show()
                                    }
                                },

                                modifier = Modifier.fillMaxWidth()
                            ) {

                                Text(
                                    text = "Aceptar domicilio"
                                )
                            }
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
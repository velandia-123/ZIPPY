package com.zippy.zippy.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import com.zippy.zippy.repository.DeliveryUser
import com.zippy.zippy.repository.UserRepository

@Composable
fun DeliveryRegisterScreen(

    onRegisterSuccess: () -> Unit

) {

    val context = LocalContext.current

    var nombre by remember { mutableStateOf("") }
    var cedula by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var placa by remember { mutableStateOf("") }
    var vehiculo by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Text(
            text = "Registro de Domiciliario",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = nombre,
            onValueChange = { nombre = it },
            label = { Text("Nombre completo") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = cedula,
            onValueChange = { cedula = it },
            label = { Text("Número de cédula") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = telefono,
            onValueChange = { telefono = it },
            label = { Text("Teléfono") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = correo,
            onValueChange = { correo = it },
            label = { Text("Correo electrónico") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = placa,
            onValueChange = { placa = it },
            label = { Text("Placa del vehículo") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = vehiculo,
            onValueChange = { vehiculo = it },
            label = { Text("Tipo de vehículo") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = password,
            onValueChange = { password = it },
            label = { Text("Contraseña") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(24.dp))

        Button(

            onClick = {

                if (
                    nombre.isBlank() ||
                    cedula.isBlank() ||
                    telefono.isBlank() ||
                    correo.isBlank() ||
                    placa.isBlank() ||
                    vehiculo.isBlank() ||
                    password.isBlank()
                ) {

                    Toast.makeText(
                        context,
                        "Complete todos los campos",
                        Toast.LENGTH_SHORT
                    ).show()

                } else {

                    UserRepository.addDelivery(

                        DeliveryUser(

                            nombre = nombre,
                            cedula = cedula,
                            telefono = telefono,
                            correo = correo,
                            placa = placa,
                            vehiculo = vehiculo,
                            password = password

                        )

                    )

                    Toast.makeText(
                        context,
                        "Domiciliario registrado correctamente",
                        Toast.LENGTH_SHORT
                    ).show()

                    onRegisterSuccess()

                }

            },

            modifier = Modifier.fillMaxWidth()

        ) {

            Text("Registrar domiciliario")

        }

    }

}
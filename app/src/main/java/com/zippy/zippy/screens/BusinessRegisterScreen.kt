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
import com.zippy.zippy.repository.BusinessUser
import com.zippy.zippy.repository.UserRepository

@Composable
fun BusinessRegisterScreen(
    onRegisterSuccess: () -> Unit
) {

    val context = LocalContext.current

    var negocio by remember { mutableStateOf("") }
    var propietario by remember { mutableStateOf("") }
    var telefono by remember { mutableStateOf("") }
    var correo by remember { mutableStateOf("") }
    var direccion by remember { mutableStateOf("") }
    var password by remember { mutableStateOf("") }

    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(20.dp)
            .verticalScroll(rememberScrollState())
    ) {

        Text(
            text = "Registro de Negocio",
            style = MaterialTheme.typography.headlineMedium
        )

        Spacer(modifier = Modifier.height(20.dp))

        OutlinedTextField(
            value = negocio,
            onValueChange = { negocio = it },
            label = { Text("Nombre del negocio") },
            modifier = Modifier.fillMaxWidth()
        )

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedTextField(
            value = propietario,
            onValueChange = { propietario = it },
            label = { Text("Propietario") },
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
            value = direccion,
            onValueChange = { direccion = it },
            label = { Text("Dirección") },
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
                    negocio.isBlank() ||
                    propietario.isBlank() ||
                    telefono.isBlank() ||
                    correo.isBlank() ||
                    direccion.isBlank() ||
                    password.isBlank()
                ) {

                    Toast.makeText(
                        context,
                        "Complete todos los campos",
                        Toast.LENGTH_SHORT
                    ).show()

                } else {

                    val usuario = BusinessUser(
                        negocio = negocio.trim(),
                        propietario = propietario.trim(),
                        telefono = telefono.trim(),
                        correo = correo.trim(),
                        direccion = direccion.trim(),
                        password = password
                    )

                    UserRepository.addBusiness(usuario)

                    Toast.makeText(
                        context,
                        "Empresa registrada correctamente",
                        Toast.LENGTH_SHORT
                    ).show()

                    onRegisterSuccess()
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Crear perfil")
        }

        Spacer(modifier = Modifier.height(12.dp))

        OutlinedButton(
            onClick = {
                onRegisterSuccess()
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Volver")
        }
    }
}
package com.zippy.zippy.screens

import android.widget.Toast
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import components.ZippyButton
import components.ZippyTextField
import com.zippy.zippy.repository.UserRepository
import ui.*

@Composable
fun LoginScreen(
    onLoginSuccess: () -> Unit,
    onRegisterClick: () -> Unit
) {

    val context = LocalContext.current

    var correo by remember { mutableStateOf("") }
    var contraseña by remember { mutableStateOf("") }

    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(ZippyBackground)
    ) {

        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(28.dp),
            horizontalAlignment = Alignment.CenterHorizontally,
            verticalArrangement = Arrangement.Center
        ) {

            Text(
                text = "ZIPPY",
                style = ZippyTypography.Display,
                color = ZippyBlue
            )

            Spacer(modifier = Modifier.height(10.dp))

            Text(
                text = "La forma más rápida de gestionar domicilios",
                style = ZippyTypography.Body,
                color = ZippyTextSecondary
            )

            Spacer(modifier = Modifier.height(35.dp))

            Card(
                modifier = Modifier.fillMaxWidth(),
                shape = ZippyShapes.Large,
                colors = CardDefaults.cardColors(
                    containerColor = ZippySurface
                ),
                elevation = CardDefaults.cardElevation(
                    defaultElevation = 12.dp
                )
            ) {

                Column(
                    modifier = Modifier.padding(24.dp)
                ) {

                    Text(
                        text = "Iniciar sesión",
                        style = ZippyTypography.Title,
                        color = ZippyText
                    )

                    Spacer(modifier = Modifier.height(25.dp))

                    ZippyTextField(
                        value = correo,
                        onValueChange = {
                            correo = it
                        },
                        label = "Correo electrónico"
                    )

                    Spacer(modifier = Modifier.height(18.dp))

                    ZippyTextField(
                        value = contraseña,
                        onValueChange = {
                            contraseña = it
                        },
                        label = "Contraseña"
                    )

                    Spacer(modifier = Modifier.height(28.dp))

                    ZippyButton(
                        text = "Ingresar"
                    ) {

                        if (
                            correo.isBlank() ||
                            contraseña.isBlank()
                        ) {

                            Toast.makeText(
                                context,
                                "Ingrese correo y contraseña",
                                Toast.LENGTH_SHORT
                            ).show()

                        } else {

                            val correoLimpio = correo.trim()

                            val accesoCorrecto = UserRepository.login(
                                correo = correoLimpio,
                                password = contraseña
                            )

                            if (accesoCorrecto) {

                                Toast.makeText(
                                    context,
                                    "Inicio de sesión correcto",
                                    Toast.LENGTH_SHORT
                                ).show()

                                onLoginSuccess()

                            } else {

                                Toast.makeText(
                                    context,
                                    "Correo o contraseña incorrectos",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    }

                    Spacer(modifier = Modifier.height(12.dp))

                    TextButton(
                        onClick = {
                            onRegisterClick()
                        },
                        modifier = Modifier.align(Alignment.CenterHorizontally)
                    ) {

                        Text(
                            text = "Crear una cuenta",
                            color = ZippyBlue
                        )
                    }
                }
            }
        }
    }
}
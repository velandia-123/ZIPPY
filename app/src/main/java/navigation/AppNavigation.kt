package com.zippy.zippy.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.zippy.zippy.screens.AvailableOrdersScreen
import com.zippy.zippy.screens.BusinessRegisterScreen
import com.zippy.zippy.screens.DeliveryRegisterScreen
import com.zippy.zippy.screens.HomeScreen
import com.zippy.zippy.screens.LoginScreen
import com.zippy.zippy.screens.MyOrdersScreen
import com.zippy.zippy.screens.ProfileScreen
import com.zippy.zippy.screens.PublishDeliveryScreen
import com.zippy.zippy.screens.RegisterSelectionScreen
import com.zippy.zippy.screens.SplashScreen

@Composable
fun AppNavigation() {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = "splash"
    ) {

        // -------------------------
        // SPLASH
        // -------------------------

        composable("splash") {

            SplashScreen(
                onFinish = {

                    navController.navigate("login") {

                        popUpTo("splash") {
                            inclusive = true
                        }
                    }
                }
            )
        }

        // -------------------------
        // LOGIN
        // -------------------------

        composable("login") {

            LoginScreen(

                onLoginSuccess = {

                    navController.navigate("home") {

                        popUpTo("login") {
                            inclusive = true
                        }
                    }
                },

                onRegisterClick = {

                    navController.navigate("registerSelection")
                }
            )
        }

        // -------------------------
        // SELECCIÓN DE REGISTRO
        // -------------------------

        composable("registerSelection") {

            RegisterSelectionScreen(

                onBusinessClick = {

                    navController.navigate("businessRegister")
                },

                onDeliveryClick = {

                    navController.navigate("deliveryRegister")
                },

                onBackClick = {

                    navController.popBackStack()
                }
            )
        }

        // -------------------------
        // REGISTRO EMPRESA
        // -------------------------

        composable("businessRegister") {

            BusinessRegisterScreen(

                onRegisterSuccess = {

                    navController.navigate("login") {

                        popUpTo("registerSelection") {
                            inclusive = true
                        }
                    }
                }
            )
        }

        // -------------------------
        // REGISTRO DOMICILIARIO
        // -------------------------

        composable("deliveryRegister") {

            DeliveryRegisterScreen(

                onRegisterSuccess = {

                    navController.navigate("login") {

                        popUpTo("registerSelection") {
                            inclusive = true
                        }
                    }
                }
            )
        }

        // -------------------------
        // HOME
        // -------------------------

        composable("home") {

            HomeScreen(

                onPublishClick = {

                    navController.navigate("publish")
                },

                onOrdersClick = {

                    navController.navigate("orders")
                },

                onAvailableOrdersClick = {

                    navController.navigate("availableOrders")
                },

                onProfileClick = {

                    navController.navigate("profile")
                }
            )
        }

        // -------------------------
        // PUBLICAR DOMICILIO
        // -------------------------

        composable("publish") {

            PublishDeliveryScreen(

                onBackClick = {

                    navController.popBackStack()
                }
            )
        }

        // -------------------------
        // MIS PEDIDOS
        // -------------------------

        composable("orders") {

            MyOrdersScreen(

                onBackClick = {

                    navController.popBackStack()
                }
            )
        }

        // -------------------------
        // PEDIDOS DISPONIBLES
        // -------------------------

        composable("availableOrders") {

            AvailableOrdersScreen(

                onBackClick = {

                    navController.popBackStack()
                }
            )
        }

        // -------------------------
        // PERFIL
        // -------------------------

        composable("profile") {

            ProfileScreen(

                onLogout = {

                    navController.navigate("login") {

                        popUpTo("home") {
                            inclusive = true
                        }
                    }
                },

                onBackClick = {

                    navController.popBackStack()
                }
            )
        }
    }
}
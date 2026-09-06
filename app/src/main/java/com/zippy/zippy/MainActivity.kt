package com.zippy.zippy

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.zippy.zippy.navigation.AppNavigation
import com.zippy.zippy.ui.theme.ZIPPYTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            ZIPPYTheme {
                AppNavigation()
            }
        }
    }
}
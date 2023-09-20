package com.example.botttom_navigation_bar_jetpack_compose

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.compose.foundation.layout.Box
import androidx.compose.material.Scaffold
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.ui.Modifier
import androidx.compose.ui.modifier.modifierLocalConsumer
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.navigation.compose.rememberNavController
import com.example.botttom_navigation_bar_jetpack_compose.Bottom_Nav_Bar.util.BottomBar
import com.example.botttom_navigation_bar_jetpack_compose.Bottom_Nav_Bar.util.Bottom_Nav_Item
import com.example.botttom_navigation_bar_jetpack_compose.Navigation.BottomNavigationBar
import com.example.botttom_navigation_bar_jetpack_compose.Navigation.Navigation
import com.example.botttom_navigation_bar_jetpack_compose.ViewModals.MainViewModal
import com.example.botttom_navigation_bar_jetpack_compose.ui.theme.BotttomnavigationbarjetpackcomposeTheme

class MainActivity : ComponentActivity() {
    private val viewModel:MainViewModal by viewModels()

    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        installSplashScreen().apply {
            setKeepVisibleCondition{
                viewModel.isLoading.value
            }
        }
        setContent {
            BotttomnavigationbarjetpackcomposeTheme {
               Box() {
                   BottomBar()
               }
            }
        }
    }
}


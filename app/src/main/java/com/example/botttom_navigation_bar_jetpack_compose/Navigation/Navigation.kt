package com.example.botttom_navigation_bar_jetpack_compose.Navigation

import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.example.botttom_navigation_bar_jetpack_compose.Chat_Screen.ChatScreen
import com.example.botttom_navigation_bar_jetpack_compose.Home_Screen.HomeScreen
import com.example.botttom_navigation_bar_jetpack_compose.List_Screen.ListScreen
import com.example.botttom_navigation_bar_jetpack_compose.Settings_Screen.SettingsScreen

@Composable
fun Navigation( navController: NavHostController){
    NavHost(navController = navController, startDestination = "home" ){
        composable("home"){
                HomeScreen()
        }

        composable("chat"){
                ChatScreen()
        }

        composable("list"){
            ListScreen()
        }
        composable("settings"){
                SettingsScreen()
        }
    }
}

package com.example.botttom_navigation_bar_jetpack_compose.Bottom_Nav_Bar.util

import android.annotation.SuppressLint
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Notifications
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.navigation.compose.rememberNavController
import com.example.botttom_navigation_bar_jetpack_compose.Drawer.SideDrawer
import com.example.botttom_navigation_bar_jetpack_compose.Navigation.BottomNavigationBar
import com.example.botttom_navigation_bar_jetpack_compose.Navigation.Navigation
import com.example.botttom_navigation_bar_jetpack_compose.ViewModals.SideDrawerViewModel
import kotlinx.coroutines.launch

@OptIn(ExperimentalMaterialApi::class)
@SuppressLint("UnusedMaterialScaffoldPaddingParameter", "SuspiciousIndentation")
@Composable
fun BottomBar(){
    val navController = rememberNavController()
    val scaffoldState = rememberScaffoldState()
    val drawerState = rememberDrawerState(DrawerValue.Closed)
    val coroutineScope = rememberCoroutineScope()
    var selectedCategory by remember { mutableStateOf("") }
    val viewModel = remember { SideDrawerViewModel() }
        Scaffold(
            scaffoldState = scaffoldState,
            drawerContent = {
                // Pass the drawer state and the close function to the side drawer composable
                SideDrawer(
                    isOpen = drawerState.isOpen,
                    onDrawerClose = {  coroutineScope.launch{ drawerState.close() } },
                    selectedCategory=selectedCategory,
                    onCategorySelected = { category ->
                        selectedCategory = category

                    },
                    viewModel = viewModel
                )
            },
            bottomBar = {
                BottomNavigationBar(
                    items = listOf(
                        Bottom_Nav_Item(
                            name = "Home",
                            route = "home",
                            icon = Icons.Default.Home
                        ),
                        Bottom_Nav_Item(
                            name = "Chat",
                            route = "chat",
                            icon = Icons.Default.Notifications
                        ),
                        Bottom_Nav_Item(
                            name = "List",
                            route = "list",
                            icon = Icons.Default.List
                        ),
                        Bottom_Nav_Item(
                            name = "Settings",
                            route = "settings",
                            icon = Icons.Default.Settings
                        ),

                        ),
                    navController = navController,
                    onItemClick = {
                        navController.navigate(it.route)
                    }
                )
            }
        ) {
            Navigation(navController = navController)
        }
}
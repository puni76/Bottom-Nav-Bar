package com.example.botttom_navigation_bar_jetpack_compose.Bottom_Nav_Bar.util

import androidx.compose.ui.graphics.vector.ImageVector

data class Bottom_Nav_Item(
    val name:String,
    val route:String,
    val icon:ImageVector,
    val badgeCount:Int=0
)
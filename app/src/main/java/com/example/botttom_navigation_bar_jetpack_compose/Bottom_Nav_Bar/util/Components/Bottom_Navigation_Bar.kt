package com.example.botttom_navigation_bar_jetpack_compose.Navigation

import androidx.compose.foundation.layout.Column
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.botttom_navigation_bar_jetpack_compose.Bottom_Nav_Bar.util.Bottom_Nav_Item

@Composable
fun BottomNavigationBar(
    items:List<Bottom_Nav_Item>,
    navController: NavController,
    modifier: Modifier=Modifier,
    onItemClick:(Bottom_Nav_Item)->Unit
){
    val backSlashEntry=navController.currentBackStackEntryAsState()
    BottomNavigation (
        modifier = Modifier,
        backgroundColor = Color.DarkGray,
        elevation = 5.dp,
            ){
                items.forEach{items->
                    val selected = items.route==backSlashEntry.value?.destination?.route
                    BottomNavigationItem(
                        selected = selected,
                        onClick = { onItemClick(items) },
                        selectedContentColor = Color.Green,
                        unselectedContentColor = Color.Gray,
                        icon = {
                            Column(horizontalAlignment = CenterHorizontally) {
                                    if (items.badgeCount>0){
                                        BadgedBox(badge = {
                                            Text(text = items.badgeCount.toString())
                                        }) {
                                            Icon(
                                                imageVector = items.icon,
                                                contentDescription =items.name )
                                        }
                                    }else{
                                        Icon(
                                            imageVector = items.icon,
                                            contentDescription =items.name )
                                    }

                                if (selected){
                                    Text(
                                        text = items.name,
                                        textAlign = TextAlign.Center,
                                        fontSize = 10.sp,

                                    )
                                }
                            }
                        }
                    )
                }
    }
}
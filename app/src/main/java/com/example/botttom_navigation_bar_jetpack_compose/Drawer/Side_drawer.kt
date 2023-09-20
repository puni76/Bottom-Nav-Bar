package com.example.botttom_navigation_bar_jetpack_compose.Drawer

import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardActions
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowDropDown
import androidx.compose.material.icons.filled.Settings
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.botttom_navigation_bar_jetpack_compose.ViewModals.SideDrawerViewModel

@Composable
fun SideDrawer(
    isOpen: Boolean,
    onDrawerClose: () -> Unit,
    selectedCategory: String,
    onCategorySelected: (String) -> Unit,
    viewModel: SideDrawerViewModel
) {

        // Content inside the Side Drawer
        Column(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(16.dp)
        ) {
            // Drawer Title
            Text(
                text = "Side Drawer",
                fontSize = 24.sp,
                color = Color.Black,
                modifier = Modifier.padding(16.dp)
            )

            // User Info
            // Add your user image or initials here

            // User Name
            Text(
                text = "User Name",
                fontSize = 16.sp,
                color = Color.Gray,
                modifier = Modifier.padding(start = 16.dp)
            )

            // Categories Header
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable { viewModel.showDropdown.value = !(viewModel.showDropdown.value)!! }
                    .padding(start = 16.dp)
            ) {
                Text(
                    text = "Categories",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.weight(1f)
                )
                viewModel.showDropdown.value?.let {
                    IconToggleButton(
                        checked = it,
                        onCheckedChange = { viewModel.showDropdown.value = it }
                    ) {
                        Icon(
                            imageVector = Icons.Default.ArrowDropDown,
                            contentDescription = "Expand/Collapse Categories"
                        )
                    }
                }
            }

            // Categories List
            if (viewModel.showDropdown.value == true) {
                viewModel.categories.value?.forEach { category ->
                    Row(
                        verticalAlignment = Alignment.CenterVertically,
                        modifier = Modifier
                            .clickable {
                                onCategorySelected(category)
                                viewModel.showDropdown.value = false
                            }
                            .padding(start = 32.dp)
                    ) {
                        Text(
                            text = category,
                            fontSize = 16.sp,
                            color = if (category == selectedCategory) Color.Blue else Color.Black
                        )
                    }
                }

                // Create New Category
                Row(
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .clickable {
                            viewModel.onNewCategorySelected()
                        }
                        .padding(start = 32.dp)
                ) {
                    Text(
                        text = "+ Create New",
                        fontSize = 16.sp,
                        color = Color.Blue
                    )
                }
            }

            // New Category TextField
            if (viewModel.showTextField.value == true) {
                OutlinedTextField(
                    value = viewModel.newCategoryText.value ?: "",
                    onValueChange = { value ->
                        viewModel.newCategoryText.value = value
                    },
                    singleLine = true,
                    label = {
                        Text("Enter new category")
                    },
                    keyboardOptions = KeyboardOptions.Default.copy(imeAction = ImeAction.Done),
                    keyboardActions = KeyboardActions(
                        onDone = {
                            viewModel.onNewCategoryEntered()
                        }
                    ),
                    modifier = Modifier.padding(start = 16.dp)
                )
            }

            // Settings
            Row(
                verticalAlignment = Alignment.CenterVertically,
                modifier = Modifier
                    .clickable { /* Handle settings click if needed */ }
                    .padding(start = 16.dp)
            ) {
                Icon(
                    imageVector = Icons.Default.Settings,
                    contentDescription = "Settings",
                    tint = Color.Gray,
                    modifier = Modifier.size(28.dp)
                )
                Text(
                    text = "Settings",
                    fontSize = 20.sp,
                    fontWeight = FontWeight.Bold,
                    color = Color.Black,
                    modifier = Modifier.padding(start = 16.dp)
                )
            }
        }
    }


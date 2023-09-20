package com.example.botttom_navigation_bar_jetpack_compose.ViewModals

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SideDrawerViewModel : ViewModel() {
    val categories = MutableLiveData<List<String>>()
    val showDropdown = MutableLiveData<Boolean>()
    val selectedCategory = MutableLiveData<String>()
    val showTextField = MutableLiveData<Boolean>()
    val newCategoryText = MutableLiveData<String>()

    init {
        categories.value = listOf(
            "Todo List",
            "Calls/Email",
            "Personal Todo List",
            "Health and Fitness",
            "Daily Schedule",
            "Appointments"
        )
        showDropdown.value = false
        selectedCategory.value = ""
        showTextField.value = false
        newCategoryText.value = ""
    }

    fun onCategorySelected(category: String) {
        selectedCategory.value = category
        showDropdown.value = false
    }

    fun onNewCategorySelected() {
        showTextField.value = true
    }

    fun onNewCategoryEntered() {
        if (newCategoryText.value?.isNotEmpty() == true) {
            selectedCategory.value = newCategoryText.value
            onCategorySelected(newCategoryText.value ?: "")
        }
        showTextField.value = false
    }
}

package com.example.botttom_navigation_bar_jetpack_compose.ViewModals

import android.app.DownloadManager.Query
import androidx.compose.runtime.MutableState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.FlowPreview
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch

class MainViewModal:ViewModel() {
    private val _isLoading= MutableStateFlow(true)
    val isLoading = _isLoading.asStateFlow()
    private val _searchText = MutableStateFlow("")
    val searchText = _searchText.asStateFlow()
    private val _isSearching = MutableStateFlow(false)
    val isSearching = _isSearching.asStateFlow()
    private val _persons = MutableStateFlow(allPersons)

    init {
        viewModelScope.launch {
            delay(3000)
            _isLoading.value=false
        }
    }
    @OptIn(FlowPreview::class)
    val persons = searchText
        .debounce(1000L)
        .onEach { _isSearching.update { true } }
        .combine(_persons){ text ,persons->
            if (text.isBlank()){
                persons
            }else {
                delay(2000L)
                persons.filter {
                    it.doesMatchSearchQuery(text)
                }
            }

        }
        .onEach { _isSearching.update { false } }
        .stateIn(
            viewModelScope,
            SharingStarted.WhileSubscribed(5000),
            _persons.value
        )
    fun onSearchTextChange(text:String){
        _searchText.value= text
    }

}

data class Person(
    val firstName:String,
    val lastName: String,

){

    fun doesMatchSearchQuery(query: String):Boolean{
       "punith uppar "
       val matchingCombinations= listOf(
            "$firstName$lastName",
           "$firstName$lastName",
          "${firstName.first()}${lastName.last()}"
       )
       return matchingCombinations.any { it.contains(query, ignoreCase = true) }
   }
}

private val allPersons = listOf(
    Person(
        firstName = "punith",
        lastName = "s"
    ),
    Person(
        firstName = "manu",
        lastName = "p"
    ),
    Person(
        firstName = "lakki",
        lastName = "s"
    ),
    Person(
        firstName = "raju",
        lastName = "s"
    ),
    Person(
        firstName = "rangu",
        lastName = "s"
    ),
    Person(
        firstName = "uppar",
        lastName = "s"
    ),
)
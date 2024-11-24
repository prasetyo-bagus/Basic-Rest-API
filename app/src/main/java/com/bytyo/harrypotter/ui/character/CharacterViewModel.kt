package com.bytyo.harrypotter.ui.character

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.bytyo.harrypotter.api.RetrofitPotterAPI
import kotlinx.coroutines.Dispatchers

class CharacterViewModel : ViewModel() {

//    private val _text = MutableLiveData<String>().apply {
//        value = "This is home Fragment"
//    }
//    val text: LiveData<String> = _text

    fun getCharacters() = liveData(Dispatchers.IO) {
        try {
            val characters = RetrofitPotterAPI.potterAPIService.getCharacters("en")
            emit(characters)
        } catch (e: Exception) {
            emit((emptyList()))
        }
    }
}
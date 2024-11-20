package com.bytyo.harrypotter.ui.spell

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData

class SpellViewModel {

    private val _text = MutableLiveData<String>().apply {
        value = "This is Spell Fragment"
    }
    val text: LiveData<String> = _text

}
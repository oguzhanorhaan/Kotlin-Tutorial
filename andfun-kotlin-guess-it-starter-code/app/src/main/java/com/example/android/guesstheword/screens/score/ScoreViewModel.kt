package com.example.android.guesstheword.screens.score

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class ScoreViewModel(var finalScore: Int) : ViewModel() {

    private var _playAgainClicked = MutableLiveData<Boolean>()
    val playAgainClicked : LiveData<Boolean>
        get() = _playAgainClicked

    init {
        Log.i("ScoreViewModel","Final score is ${finalScore}")
        _playAgainClicked.value = false
    }

    fun playAgain() {
        _playAgainClicked.value = true
        _playAgainClicked.value = false
    }
}
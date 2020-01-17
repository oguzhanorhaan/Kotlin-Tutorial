package com.oguzhanorhan.kotlintutorial

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_next.*

class NextActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_next)

        val name = intent.getStringExtra("name")
        val surname = intent.getStringExtra("surname")
        textView.text = name +" "+surname
    }
}

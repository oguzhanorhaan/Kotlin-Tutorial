package com.oguzhanorhan.kotlintutorial

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.os.Handler
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var sharedPreferences : SharedPreferences
    var number = 0
    var runnable : Runnable = Runnable {  }
    var handler : Handler = Handler()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        println("Hello Kotlin")

        sharedPreferences = getSharedPreferences("com.oguzhanorhan.kotlintutorial", Context.MODE_PRIVATE)

        val myArray =  arrayOf("Kim","Virgil","Riccardo")
        println(myArray[0])
        myArray.set(1,"Marcelo")
        println(myArray[1])

        val mixedArray = arrayOf("Oğuzhan",17)
        println(mixedArray[1])

        //arraylist

        val mMusicians = arrayListOf<String>("Rihanna", "Kanye", "Travis")
        mMusicians.add("Kendrick")

        val mList = ArrayList<Int>()
        mList.add(1)
        mList.add(2)



        val mFixedList = ArrayList<Any>();
        mFixedList.add(1)
        mFixedList.add(true)
        mFixedList.add("oguzhan")

        //set
        val mExampleArray = arrayOf(1,1,2,3)
        println("element 1 ${mExampleArray[0]}")
        println("element 2 ${mExampleArray[1]}")

        val mSet = setOf<Int>(1,1,2,3)
        println("set size ${mSet.size}")
        mSet.forEach { println(it) }

        //Map- HashMap (Key-Value pairing)

        val calorieHashMap = hashMapOf<String,Int>()
        calorieHashMap.put("Apple",150)
        println(calorieHashMap["Apple"])

        val myNewMap = hashMapOf<String, Int>("A" to 1,"B" to 2,"C" to 3)
        println(myNewMap["C"])

        //switch - when

        val day = 3
        var dayString = ""

        when(day) {
            1 -> {
                dayString = "Monday"
            }

            2 -> dayString = "Tuesday"
        }

        // for loop

        val myArrayOfNumbers = arrayOf(12,12,14,15,21,57,30)

        for (num in myArrayOfNumbers) {
            val z = num/3*5
            println(z)
        }

        for (i in myArrayOfNumbers.indices) {
            val z = myArrayOfNumbers[i]/3*5
            println(z)
        }

        for (b in 0..9) {
            println(b)
        }

        sum(20,10)

        multiply(10,10)

        //classes
        var human = Human("Oguzhan","Orhan",5)
        var animal = Animal("Köpek", "Hav hav")

        //nullable

        var myText : String? = null
        var myAge : Int? = null

        if (myAge != null) {
            println(myAge!!*10) // -> null pointer exception
        }


        if (myAge != null ) {
            println(myAge!!*10)
        }

        // !! means , I approve that it is not null

        println(myAge?.compareTo(5))

        //elvis
        val resultt = myAge?.compareTo(5) ?: 25
        println(resultt)

        val age = sharedPreferences.getInt("age",0)

        helloKotlinText.text = "Hello Kotlin " + age

        var musician = Musician("Oguzhan",24)
        // musician.name NOT ALLOWED, private setter
       // musician.age = 26 NOT ALLOWED, private setter
        println(musician.age)

        //Inheritance
        var guitarPlayer = GuitarPlayer("Oguzhan",24)
        guitarPlayer.introduce()
        guitarPlayer.playGuitar()

        //musician.playGuitar NOT ALLOWED
        var cactusPlant = CactusPlant()
        println(cactusPlant.name)

        // LAMBDA
        val multiplyLambda = {a: Int , b: Int -> {
            a*b
        }}

        println(multiplyLambda(5,4))

        val addLambda : (Int, Int) -> Int = { a, b-> a+ b}

        println(addLambda(2,4))
    }

    private fun sum(a: Int, b: Int) {
            println(a+b)
    }

    private fun multiply  (a : Int, b: Int ) : Int {
        return a*b
    }

    fun buttonClick (view : View) { //method used by a view(button)
        helloKotlinText.text = "Button clicked"

        sharedPreferences.edit().putInt("age",24).apply()
    }

    fun openNextActivity (view: View) {
        val intent = Intent(this, NextActivity::class.java)
        intent.putExtra("name","Oguzhan")
        intent.putExtra("surname","Orhan")
        startActivity(intent)
    }

    fun openAlert() {
        val alert = AlertDialog.Builder(this@MainActivity)
        alert.setTitle("Alert Title")
        alert.setMessage("Message")
        alert.setPositiveButton("Ok") {
            dialog, which ->  Toast.makeText(this, "Clicked",Toast.LENGTH_LONG).show()
        }
        alert.show()
    }

    fun startCountdownTimer() {
        object : CountDownTimer(10000,1000) {
            override fun onFinish() {
                helloKotlinText.text = "Finished"
            }

            override fun onTick(millisUntilFinished: Long) {
                helloKotlinText.text = "Remaining ${millisUntilFinished/1000}"
            }
        }.start()
    }

    fun startRunnable() {
        number = 0

        runnable = object : Runnable {
            override fun run() {
                number += 1
                helloKotlinText.text = "$number"
                handler.postDelayed(this,1000)
            }

        }

        handler.post(runnable)
    }

    fun stopRunnable() {
        handler.removeCallbacks(runnable)
        number = 0
        helloKotlinText.text = "Stopped"
    }
}

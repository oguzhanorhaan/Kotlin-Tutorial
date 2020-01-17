package com.oguzhanorhan.kotlintutorial

class GuitarPlayer(name: String, age: Int) : Musician(name, age) {
    fun playGuitar() {
        println("Guitar play")
    }
}
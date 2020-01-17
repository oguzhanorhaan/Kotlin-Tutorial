package com.oguzhanorhan.kotlintutorial

open class Musician(name: String, age: Int) {
    var name: String = name
        private set
        get

    var age: Int = age
        private set
        get

    fun introduce() {
        println("My name is $name")
    }
}
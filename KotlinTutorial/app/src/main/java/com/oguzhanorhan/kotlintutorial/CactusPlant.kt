package com.oguzhanorhan.kotlintutorial

class CactusPlant : HouseDecor {
    override var name: String
        get() = "Cactus"
        set(value) {
            println(value)
        }
}
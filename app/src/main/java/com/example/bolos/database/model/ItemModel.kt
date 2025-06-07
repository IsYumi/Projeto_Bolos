package com.example.bolos.database.model

data class ItemModel(
    var title:String="",
    var description:String="",
    var price:Double=0.0,
    var rating:Double=0.0,
    var picUrl:String = "",
    var numberInCart:Int = 0,
    var extra: String = "")

package com.bytyo.harrypotter.api

data class Characters(
    //    @SerializedName("full_name")
    val fullName: String,
//    @SerializedName("nick_name")
    val nickname: String,
    val hogwartsHouse: String,
    val interpretedBy: String,
    val children: List<String>,
    val image: String,
    val birthdate: String,
)

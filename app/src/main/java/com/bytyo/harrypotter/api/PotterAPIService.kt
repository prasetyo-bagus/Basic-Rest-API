package com.bytyo.harrypotter.api

import com.bytyo.harrypotter.model.Books
import com.bytyo.harrypotter.model.Characters
import com.bytyo.harrypotter.model.Houses
import com.bytyo.harrypotter.model.Spells
import retrofit2.http.GET
import retrofit2.http.Path

interface PotterAPIService {

    /*
    GET /[lang]/books
    GET /[lang]/characters
    GET /[lang]/houses
    GET /[lang]/spells
     */

    @GET("{lang}/books")
    suspend fun getBooks(@Path("lang") language: String = "en")
            :List<Books>

    @GET("{lang}/characters")
    suspend fun getCharacters(@Path ("lang") language: String = "en")
            :List<Characters>

    @GET("{lang}/houses")
    suspend fun getHouses(@Path ("lang") language: String = "en")
            :List<Houses>

    @GET("{lang}/spells")
    suspend fun getSpells(@Path ("lang") language: String = "en")
            :List<Spells>
}
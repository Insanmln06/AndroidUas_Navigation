package com.insanmaulana.uasmy.Api

import com.insanmaulana.uasmy.Model.NoteModel
import retrofit2.Call
import retrofit2.http.GET

interface ApiEndpoint {
    @GET("struktur.php")
    fun data(): Call<NoteModel>
}
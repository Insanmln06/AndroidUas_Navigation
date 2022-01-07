package com.insanmaulana.uasmy

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.recyclerview.widget.RecyclerView
import com.insanmaulana.uasmy.Adapter.NoteAdapter
import com.insanmaulana.uasmy.Api.ApiRetrofit
import com.insanmaulana.uasmy.Model.NoteModel
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class activity_struktur : AppCompatActivity() {

    private val api by lazy { ApiRetrofit().endpoint }
    private lateinit var catatanAdapter: NoteAdapter
    private lateinit var lisNote: RecyclerView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_struktur)

    setupList()

    }

    private fun setupList(){
        lisNote = findViewById(R.id.list_catatan)
        catatanAdapter = NoteAdapter(arrayListOf())
        lisNote.adapter = catatanAdapter
    }

    override fun onStart() {
        super.onStart()
        getNote()
    }

    private fun getNote(){
        api.data().enqueue(object : Callback<NoteModel> {
            override fun onResponse(call: Call<NoteModel>, response: Response<NoteModel>) {
                if (response.isSuccessful){
                    val listData = response.body()!!.struktur
                    catatanAdapter.setData( listData )
//                    listData.forEach {
//                        Log.e("daftar_hadir","nama ${it.nama}")
//                    }
                }
            }

            override fun onFailure(call: Call<NoteModel>, t: Throwable) {
                Log.e("daftar_hadir",t.toString())
            }

        })
    }
}
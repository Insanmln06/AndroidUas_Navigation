package com.insanmaulana.uasmy.Adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.insanmaulana.uasmy.Model.NoteModel
import com.insanmaulana.uasmy.R
import java.util.ArrayList

class NoteAdapter (
    val notes: ArrayList<NoteModel.Data>
): RecyclerView.Adapter<NoteAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int)= ViewHolder(
        LayoutInflater.from(parent.context)
            .inflate(R.layout.adapter_struktur,parent,false)
    )

    override fun onBindViewHolder(holder: NoteAdapter.ViewHolder, position: Int) {
        val data=notes[position]
        holder.textNote.text=data.nama
    }

    override fun getItemCount() = notes.size

    class ViewHolder(view: View): RecyclerView.ViewHolder(view){
        val textNote = view.findViewById<TextView>(R.id.text_catatan)
    }
    public fun setData(data: List<NoteModel.Data>){
        notes.clear()
        notes.addAll(data)
        notifyDataSetChanged()
    }
}


package com.example.votointeligente

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView


class MyAdapter(lista: ArrayList<VotacionesModel>): RecyclerView.Adapter<MyAdapter.MyViewHolder>() {
    val mLista = lista


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val context = parent.context
        val inflater = LayoutInflater.from(context)
        // Inflate the custom layout

        // Inflate the custom layout
        val view: View = inflater.inflate(R.layout.item_votacion, parent, false)

        // Return a new holder instance
        return MyViewHolder(view)
    }

    override fun getItemCount(): Int {
        return mLista.size
    }

    override fun onBindViewHolder(holder: MyViewHolder, pos: Int) {
        holder.numero.text = mLista[pos].nro_votacion.toString()
        holder.texto.text = mLista[pos].nombre
    }


    class MyViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var numero: TextView = v.findViewById(R.id.numeroItem)
        var texto: TextView = v.findViewById(R.id.textoItem)
    }

}
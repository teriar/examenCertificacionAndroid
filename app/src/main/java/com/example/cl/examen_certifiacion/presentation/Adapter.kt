package com.example.cl.examen_certifiacion.presentation

import android.icu.text.Transliterator.Position
import android.os.Bundle
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import coil.load
import com.example.cl.examen_certifiacion.R
import com.example.cl.examen_certifiacion.data.local.HeroEntity
import com.example.cl.examen_certifiacion.databinding.ItemListaBinding

class Adapter : RecyclerView.Adapter<Adapter.ListViewHolder>() {


    lateinit var  binding: ItemListaBinding
    private val list = mutableListOf<HeroEntity>()



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Adapter.ListViewHolder {
       binding = ItemListaBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ListViewHolder(binding)
    }

    override fun onBindViewHolder(holder: Adapter.ListViewHolder, position: Int) {
        val list = list[position]
        holder.bind(list)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun setData(detalle: List<HeroEntity>){
        this.list.clear()
        this.list.addAll(detalle)
        notifyDataSetChanged()
    }



    class ListViewHolder(val view: ItemListaBinding):RecyclerView.ViewHolder(view.root) {
      fun bind(detail: HeroEntity){

          view.imageView.load(detail.imagenLink)
          view.txtNombre.text = detail.nombre

          view.imageView.setOnClickListener{
              val bundle = Bundle()
              val detalle = detail.id
              bundle.putInt("id", detalle)
              Navigation.findNavController(view.root).navigate(R.id.action_listFragment_to_detalleFragment, bundle)
          }

      }

    }
}
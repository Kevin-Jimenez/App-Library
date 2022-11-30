package com.example.applibrary.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applibrary.data.models.LibroItemModel
import com.example.applibrary.interfaces.OnLibroClickListener
import com.example.applibrary.databinding.ItemLibroBinding

class LibroAdapter(var list: List<LibroItemModel>): RecyclerView.Adapter<LibroAdapter.ViewHolder>() {

    var listener: OnLibroClickListener? = null
    class ViewHolder(val item: ItemLibroBinding): RecyclerView.ViewHolder(item.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemLibroBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val libro = list[position]
        holder.item.itemLibroTitle.text = libro.descripcion
        holder.item.itemLibroGeneral.text = libro.name
        holder.item.itemLibroSummary.text = libro.genero
        holder.item.itemLibroImage.setImageResource(libro.image.toInt())
        holder.item.itemLibroStar.rating = (libro.star / 5.0).toFloat()
        holder.item.root.setOnClickListener {
            listener?.onClick(libro)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateDataset(list: List<LibroItemModel>){
        this.list = list
        notifyDataSetChanged()
    }
}
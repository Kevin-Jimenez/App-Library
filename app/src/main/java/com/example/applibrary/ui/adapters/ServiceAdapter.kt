package com.example.applibrary.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.applibrary.interfaces.OnServiceClickListener
import com.example.applibrary.data.models.ServiceItemModel
import com.example.applibrary.databinding.ItemServiceBinding

class ServiceAdapter(var list: List<ServiceItemModel>): RecyclerView.Adapter<ServiceAdapter.ViewHolder>(){

    var listener: OnServiceClickListener? = null
    class ViewHolder(val item: ItemServiceBinding): RecyclerView.ViewHolder(item.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        return ViewHolder(ItemServiceBinding.inflate(inflater, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val service = list[position]
        holder.item.serviceDescripcion.text = service.title
        holder.item.serviceDescripcionResumen.text = service.description
        holder.item.serviceIcon.setImageResource(service.icon.toInt())
        holder.item.root.setOnClickListener {
            listener?.onClick(service)
        }
    }

    override fun getItemCount(): Int {
        return list.size
    }

    fun updateDataset(list: List<ServiceItemModel>){
        this.list = list
        notifyDataSetChanged()
    }
}
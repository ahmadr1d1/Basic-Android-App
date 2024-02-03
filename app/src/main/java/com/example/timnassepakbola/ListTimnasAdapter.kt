package com.example.timnassepakbola

import android.content.Intent
import android.view.*
import androidx.recyclerview.widget.RecyclerView
import com.example.timnassepakbola.databinding.ItemRowTimnasBinding

class ListTimnasAdapter(private val listTimnas: ArrayList<Timnas>) : RecyclerView.Adapter<ListTimnasAdapter.ListViewHolder>() {

    private lateinit var onItemClickCallback: OnItemClickCallback

    class ListViewHolder(var binding: ItemRowTimnasBinding) : RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ListViewHolder {
        val binding = ItemRowTimnasBinding.inflate(LayoutInflater.from(parent.context),parent, false)
        return ListViewHolder(binding)
    }

    override fun getItemCount(): Int = listTimnas.size

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val (name, description, photo) = listTimnas[position]
        holder.binding.imgItemPhoto.setImageResource(photo)
        holder.binding.tvItemName.text = name
        holder.binding.tvItemDescription.text = description

        holder.itemView.setOnClickListener {
            val intentDetail = Intent(holder.itemView.context, DetailActivity::class.java)
            intentDetail.putExtra("DETAIL", listTimnas[holder.adapterPosition])
            holder.itemView.context.startActivity(intentDetail)
        }
    }


    fun setOnItemClickCallback(onItemClickCallback: OnItemClickCallback) {
        this.onItemClickCallback = onItemClickCallback
    }

    interface OnItemClickCallback {
        fun onItemClicked(data: Timnas)
    }
}
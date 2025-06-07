package com.example.bolos.adapters

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.imageview.ShapeableImageView
import com.example.bolos.R
import com.example.bolos.activity.DetailActivity
import com.example.bolos.database.model.ItemModel
class ItemAdapter(
    private val items: List<ItemModel>
) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    inner class ItemViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val pic     : ShapeableImageView = view.findViewById(R.id.pic)
        val titleTxt: TextView           = view.findViewById(R.id.titleTxt)
        val priceTxt: TextView           = view.findViewById(R.id.priceTxt)
        val addBtn  : ImageView          = view.findViewById(R.id.imageView4)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.viewholder_popular, parent, false)
        return ItemViewHolder(view)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val item = items[position]

        holder.titleTxt.text = item.title
        holder.priceTxt.text = "R$ ${"%.2f".format(item.price)}"
        // carrega a imagem...
        val resName = item.picUrl.removePrefix("@drawable/")
        val resId = holder.pic.context.resources
            .getIdentifier(resName, "drawable", holder.pic.context.packageName)
        if (resId != 0) holder.pic.setImageResource(resId)

        // ← aqui, no ItemAdapter, vínculo o clique para abrir a DetailActivity
        holder.addBtn.setOnClickListener { v ->
            val ctx = v.context
            val intent = Intent(ctx, DetailActivity::class.java).apply {
                putExtra("EXTRA_TITLE", item.title)
                putExtra("EXTRA_DESC", item.description)
                putExtra("EXTRA_PRICE", item.price)
                putExtra("EXTRA_RATING", item.rating)
                putExtra("EXTRA_PIC", item.picUrl)
            }
            ctx.startActivity(intent)
        }
    }

    override fun getItemCount() = items.size
}
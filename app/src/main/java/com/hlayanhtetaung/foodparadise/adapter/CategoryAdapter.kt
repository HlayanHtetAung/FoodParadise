package com.hlayanhtetaung.foodparadise.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hlayanhtetaung.foodparadise.R
import com.squareup.picasso.Picasso
import com.hlayanhtetaung.foodparadise.model.CategoryX
import kotlinx.android.synthetic.main.card_view_for_recycler_item.view.*

class CategoryAdapter(
    private var categoryList: List<CategoryX>,
    private var clickListener: ClickListener
) :
    RecyclerView.Adapter<CategoryAdapter.CategoryViewHolder>() {

    inner class CategoryViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(categoryX: CategoryX) {
            itemView.categoryTitle.text = categoryX.strCategory
            Picasso.get().load(categoryX.strCategoryThumb).into(itemView.categoryImage)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CategoryViewHolder {
        return CategoryViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.card_view_for_recycler_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return 9
    }

    override fun onBindViewHolder(holder: CategoryViewHolder, position: Int) {
        holder.bind(categoryList[position])
        holder.itemView.setOnClickListener {
            clickListener.click(categoryList[position])
        }
    }

    interface ClickListener {
        fun click(categoryX: CategoryX)
    }
}
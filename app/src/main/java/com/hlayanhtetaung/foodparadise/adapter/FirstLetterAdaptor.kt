package com.hlayanhtetaung.foodparadise.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.hlayanhtetaung.foodparadise.R
import com.squareup.picasso.Picasso
import com.hlayanhtetaung.foodparadise.model.modelAtoZ.Meal
import kotlinx.android.synthetic.main.card_view_for_recycler_item.view.*

class FirstLetterAdaptor(var firstLetterList: List<Meal>) :
    RecyclerView.Adapter<FirstLetterAdaptor.FirstLetterViewHolder>() {

    class FirstLetterViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bindFirstLetter(meal: Meal) {
            itemView.categoryTitle.text = meal.strMeal
            Picasso.get().load(meal.strMealThumb).placeholder(R.drawable.hhh)
                .into(itemView.categoryImage)
        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FirstLetterViewHolder {
        return FirstLetterViewHolder(
            LayoutInflater.from(parent.context)
                .inflate(R.layout.card_view_for_recycler_item, parent, false)
        )
    }

    override fun getItemCount(): Int {
        return firstLetterList.size
    }

    override fun onBindViewHolder(holder: FirstLetterViewHolder, position: Int) {
        holder.bindFirstLetter(firstLetterList[position])
    }
}
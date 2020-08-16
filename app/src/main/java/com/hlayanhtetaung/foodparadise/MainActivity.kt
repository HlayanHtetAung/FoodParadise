package com.hlayanhtetaung.foodparadise

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.GridLayoutManager
import com.hlayanhtetaung.foodparadise.adapter.CategoryAdapter
import com.hlayanhtetaung.foodparadise.model.CategoryX
import com.squareup.picasso.Picasso
import com.hlayanhtetaung.foodparadise.viewmodel.ViewModelCategory
import com.hlayanhtetaung.foodparadise.viewmodel.ViewModelRandom
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_view_for_country.*
import kotlinx.android.synthetic.main.card_view_for_ingredient.*
import kotlinx.android.synthetic.main.card_view_for_letter.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val viewModelCategory = ViewModelProvider(this).get(ViewModelCategory::class.java)
        val viewModelRandom = ViewModelProvider(this).get(ViewModelRandom::class.java)

        viewModelCategory.loadResultCategory()
        viewModelRandom.loadResultRandom()

        categoryRecycler.layoutManager = GridLayoutManager(this, 3)

        viewModelCategory.getResultCategory().observe(
            this, Observer {
                categoryRecycler.adapter =
                    CategoryAdapter(it.categories, object : CategoryAdapter.ClickListener {
                        override fun click(categoryX: CategoryX) {
                            Toast.makeText(applicationContext, "Categories", Toast.LENGTH_SHORT)
                                .show()
                        }
                    })
            }
        )

        viewModelRandom.getResultRandom().observe(
            this, Observer {
                Picasso.get().load(it.meals[0].strMealThumb).into(randomImage)
                randomTitle.text = it.meals[0].strMeal
            }
        )

        randomCard.setOnClickListener {
            Toast.makeText(this, randomTitle.text.toString(), Toast.LENGTH_SHORT).show()
        }

        letterCard.setOnClickListener {}

        countryCard.setOnClickListener {
            Toast.makeText(this, "countryCard", Toast.LENGTH_SHORT).show()
        }

        ingredientCard.setOnClickListener {
            Toast.makeText(this, "ingredientCard", Toast.LENGTH_SHORT).show()
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menu?.add(getString(R.string.menu_action_search))
            ?.setIcon(R.drawable.ic_baseline_search_24)
            ?.setShowAsAction(
                MenuItem.SHOW_AS_ACTION_ALWAYS
            )
        return super.onCreateOptionsMenu(menu)
    }
}
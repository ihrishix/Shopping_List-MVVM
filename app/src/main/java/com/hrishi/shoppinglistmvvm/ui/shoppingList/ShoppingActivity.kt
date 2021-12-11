package com.hrishi.shoppinglistmvvm.ui.shoppingList

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.hrishi.shoppinglistmvvm.R
import com.hrishi.shoppinglistmvvm.data.db.ShoppingDatabase
import com.hrishi.shoppinglistmvvm.data.db.entity.ShoppingItem
import com.hrishi.shoppinglistmvvm.data.repositories.ShoppingRepositories
import com.hrishi.shoppinglistmvvm.other.ShoppingAdapter
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.instance

class ShoppingActivity : AppCompatActivity(){


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_shopping)

        val database = ShoppingDatabase(this)
        val repositories = ShoppingRepositories(database)
        val factory = ShoppingViewModelFactory(repositories)

        val viewModel = ViewModelProviders.of(this, factory).get(ShoppingViewModel::class.java)

        val adapter = ShoppingAdapter(listOf(), viewModel)

        val rv_ShoppingItem = findViewById<RecyclerView>(R.id.rvShoppingItems)
        rv_ShoppingItem.layoutManager = LinearLayoutManager(this)
        rv_ShoppingItem.adapter = adapter

        viewModel.getAllItems().observe(this, Observer {
            adapter.items = it
            adapter.notifyDataSetChanged()
        })

        val fab_add = findViewById<FloatingActionButton>(R.id.fab_add)

        fab_add.setOnClickListener{
            AddShoppingItemDialog(this,
            object : AddDialogListner{
                override fun onAddButtonClicked(item: ShoppingItem) {
                    viewModel.upsert(item)
                }
            }).show()
        }
    }
}
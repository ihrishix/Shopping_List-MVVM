package com.hrishi.shoppinglistmvvm.ui.shoppingList

import android.view.KeyEvent
import androidx.lifecycle.ViewModel
import com.hrishi.shoppinglistmvvm.data.db.entity.ShoppingItem
import com.hrishi.shoppinglistmvvm.data.repositories.ShoppingRepositories
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch


class ShoppingViewModel(
    val repository : ShoppingRepositories
) : ViewModel(){

    fun upsert(shoppingItem: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.upsert(shoppingItem)
    }

    fun delete(shoppingItem: ShoppingItem) = CoroutineScope(Dispatchers.Main).launch {
        repository.delete(shoppingItem)
    }

    fun getAllItems() = repository.getallItems()
}
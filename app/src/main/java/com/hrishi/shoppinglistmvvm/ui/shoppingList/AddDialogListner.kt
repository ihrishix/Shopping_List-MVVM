package com.hrishi.shoppinglistmvvm.ui.shoppingList

import com.hrishi.shoppinglistmvvm.data.db.entity.ShoppingItem

interface AddDialogListner {
    fun onAddButtonClicked(item:ShoppingItem)
}
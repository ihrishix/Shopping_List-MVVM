package com.hrishi.shoppinglistmvvm.ui.shoppingList

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.hrishi.shoppinglistmvvm.data.repositories.ShoppingRepositories

class ShoppingViewModelFactory(
    private val repositories: ShoppingRepositories
): ViewModelProvider.NewInstanceFactory() {

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ShoppingViewModel(repositories) as T
    }
}
package com.hrishi.shoppinglistmvvm.data.repositories

import com.hrishi.shoppinglistmvvm.data.db.ShoppingDatabase
import com.hrishi.shoppinglistmvvm.data.db.entity.ShoppingItem


class ShoppingRepositories(
    private val shoppingDatabase : ShoppingDatabase) {

    suspend fun upsert(item: ShoppingItem) = shoppingDatabase.shoppingDao.upsert(item)

    suspend fun delete(item: ShoppingItem) = shoppingDatabase.shoppingDao.delete(item)

    fun getallItems() = shoppingDatabase.shoppingDao.getALlItems()
}
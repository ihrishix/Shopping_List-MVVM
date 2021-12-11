package com.hrishi.shoppinglistmvvm.data.db

import androidx.lifecycle.LiveData
import androidx.room.*
import com.hrishi.shoppinglistmvvm.data.db.entity.ShoppingItem

@Dao
interface ShoppingDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun upsert(item : ShoppingItem)

    @Delete
    suspend fun delete(item : ShoppingItem)

    @Query("SELECT * FROM shopping_items")
    fun getALlItems(): LiveData<List<ShoppingItem>>
}
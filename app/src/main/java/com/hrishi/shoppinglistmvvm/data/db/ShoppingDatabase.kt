package com.hrishi.shoppinglistmvvm.data.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.hrishi.shoppinglistmvvm.data.db.entity.ShoppingItem

@Database(
    entities = [ShoppingItem::class], version = 1
)

abstract class ShoppingDatabase : RoomDatabase(){

    abstract val shoppingDao : ShoppingDao

    companion object{

        @Volatile
        private var instance : ShoppingDatabase? = null
        val LOCK = Any()

        operator fun invoke(context: Context) = instance ?: synchronized(LOCK){
            instance ?: CreateDatabase(context).also { instance = it }
        }

        private fun CreateDatabase(context: Context) =
            Room.databaseBuilder(context.applicationContext, ShoppingDatabase::class.java, "shopping_DB")
                .build()

    }

}
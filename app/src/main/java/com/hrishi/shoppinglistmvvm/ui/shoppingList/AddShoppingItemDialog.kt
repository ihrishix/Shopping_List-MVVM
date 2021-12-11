package com.hrishi.shoppinglistmvvm.ui.shoppingList

import android.content.Context
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatDialog
import com.hrishi.shoppinglistmvvm.R
import com.hrishi.shoppinglistmvvm.data.db.entity.ShoppingItem

class AddShoppingItemDialog(context:Context, var addDialogListner: AddDialogListner) : AppCompatDialog(context){

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.dialog_add_shopping_item)

        val tv_add = findViewById<TextView>(R.id.tvAdd)
        val tv_cancel = findViewById<TextView>(R.id.tvCancel)

        tv_add!!.setOnClickListener {
            val et_Name = findViewById<EditText>(R.id.etName)!!.text.toString()
            val et_Amount = findViewById<EditText>(R.id.etAmount)!!.text.toString()

            if(et_Name.isEmpty() || et_Amount.isEmpty()){
                Toast.makeText(context, "Please Enter all Information", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }
            val item = ShoppingItem(et_Name, et_Amount.toInt())

            addDialogListner.onAddButtonClicked(item)
            dismiss()
        }

        tv_cancel!!.setOnClickListener {
            cancel()
        }


    }

}
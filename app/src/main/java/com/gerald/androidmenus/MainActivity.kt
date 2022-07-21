package com.gerald.androidmenus

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.PopupMenu
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val button: Button = findViewById(R.id.buttonPopMenu)
        button.setOnLongClickListener {
            val popUpMenu = PopupMenu(this, button)
            popUpMenu.menuInflater.inflate(R.menu.popup_menu, popUpMenu.menu)
            //listeners
            popUpMenu.setOnMenuItemClickListener { item ->
                if (item.itemId == R.id.menu_item_delete) {
                    Toast.makeText(this, "Deleting", Toast.LENGTH_SHORT).show()
                } else if (item.itemId == R.id.menu_item_edit) {
                    Toast.makeText(this, "Editing Text", Toast.LENGTH_SHORT).show()
                }
                true
            }
            popUpMenu.show()
            true


        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.top_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.menu_item_share -> Toast.makeText(this, "Share Via", Toast.LENGTH_SHORT).show()
            R.id.menu_item_call -> Toast.makeText(this, "Calling", Toast.LENGTH_SHORT).show()
            R.id.menu_item_SMS -> Toast.makeText(this, "Sending Message", Toast.LENGTH_SHORT).show()

        }
        return true
    }
}
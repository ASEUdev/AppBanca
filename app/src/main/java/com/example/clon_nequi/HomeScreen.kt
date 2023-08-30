package com.example.clon_nequi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.PopupMenu
import android.widget.TextView
import com.google.android.material.floatingactionbutton.FloatingActionButton

class HomeScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_inicio)
        val floatingActionButton: FloatingActionButton = findViewById(R.id.floatingActionButton)
        floatingActionButton.setOnClickListener { showPopupMenu(it) }
        val balance = findViewById<TextView>(R.id.txtTotal)
        balance.text = "$${BalanceManager.getBalance()}0"
    }

    private fun showPopupMenu(view: View) {
        val popupMenu = PopupMenu(this, view)
        val inflater = popupMenu.menuInflater
        inflater.inflate(R.menu.menu, popupMenu.menu)

        popupMenu.setOnMenuItemClickListener { item: MenuItem ->
            when (item.itemId) {
                R.id.retiro -> {
                    val intent = Intent(this, Retiro::class.java)
                    startActivity(intent)
                    true
                }
                R.id.transferencia -> {
                    val intent = Intent(this, Transferencia::class.java)
                    startActivity(intent)
                    true
                }
                R.id.servicio -> {
                    // Acción para la opción 2
                    true
                }
                else -> false
            }
        }

        popupMenu.show()
    }

    override fun onResume() {
        super.onResume()
        val balance =findViewById<TextView>(R.id.txtTotal)
        balance.text = "$${BalanceManager.getBalance()}0"
    }
}
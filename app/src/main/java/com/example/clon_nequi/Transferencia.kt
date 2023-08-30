package com.example.clon_nequi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class Transferencia : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_transferencia)
        val btnTransferir = findViewById<Button>(R.id.btnTransferir)
        val cantidad = findViewById<EditText>(R.id.inputTransferir)

        btnTransferir.setOnClickListener {
            if(BalanceManager.getBalance() - cantidad.text.toString().toDouble() < 0){
                Toast.makeText(this, "El valor a transferir supera tu saldo actual.", Toast.LENGTH_SHORT).show()
            }else{
                BalanceManager.restBalance(cantidad.text.toString().toDouble())
                finish() //
            }

        }

    }
}

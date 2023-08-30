package com.example.clon_nequi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val edt_numberPhone: EditText = findViewById(R.id.edt_NumberPhone)
        val btnIniciaSesion: Button = findViewById(R.id.btn_login)


        btnIniciaSesion.setOnClickListener{
            when (val userPhone = edt_numberPhone.text.toString()) {
                "123" -> {
                    val login = Intent ( this, PasswordScreen::class.java)
                    login.putExtra("clave", userPhone)
                    startActivity(login)
                }
                "" -> {
                    Toast.makeText(this, "Introduzca un numero de telefono.", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    if (userPhone.length != 10) {
                        Toast.makeText(this,   "El numero de telefono debe tener 10 digitos.", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this, "Este telefono no esta registrado, por favor intenta de nuevo.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
            edt_numberPhone.setText("")
            }
    }
}
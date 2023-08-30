package com.example.clon_nequi

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageButton
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.core.widget.addTextChangedListener

class PasswordScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_password_screen)

        val input1: EditText = findViewById(R.id.input_num1)
        val input2: EditText = findViewById(R.id.input_num2)
        val input3: EditText = findViewById(R.id.input_num3)
        val input4: EditText = findViewById(R.id.input_num4)

        val btnSublogin: Button = findViewById(R.id.btn_subLogin)
        val btnBack: ImageButton = findViewById(R.id.btn_back)

        input1.requestFocus()
        input1.addTextChangedListener {
            input4.setSelection(0)
            findViewById<EditText>(R.id.input_num2).requestFocus()
        }
        input2.addTextChangedListener {
            findViewById<EditText>(R.id.input_num3).requestFocus()
        }
        input3.addTextChangedListener {
            findViewById<EditText>(R.id.input_num4).requestFocus()
        }
        btnBack.setOnClickListener{
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

        btnSublogin.setOnClickListener{
            when(val userPassword = "${input1.text}${input2.text}${input3.text}${input4.text}") {
                "0000" -> {
                    val login = Intent ( this, HomeScreen::class.java)
                    login.putExtra("clave", userPassword)
                    startActivity(login)
                }
                "" -> {
                    Toast.makeText(this, "Por favor introduce una contraseña.", Toast.LENGTH_SHORT).show()
                }
                else -> {
                    if(userPassword.length < 4){
                        Toast.makeText(this, "La entrada es incompleta.", Toast.LENGTH_SHORT).show()
                    }else{
                        Toast.makeText(this, "La contraseña es incorrecta por favor intenta de nuevo.", Toast.LENGTH_SHORT).show()
                    }
                }
            }
        }
    }

    override fun onResume() {
        super.onResume()
        val input1 = findViewById<EditText>(R.id.input_num1)
        val input2 = findViewById<EditText>(R.id.input_num2)
        val input3= findViewById<EditText>(R.id.input_num3)
        val input4 = findViewById<EditText>(R.id.input_num4)
        input1.setText("")
        input2.setText("")
        input3.setText("")
        input4.setText("")
        input1.requestFocus()
    }
}
package com.example.clon_nequi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import android.widget.TextView
import android.widget.Toast

class Retiro : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_retiro)
        val txtCodigo: TextView = findViewById(R.id.txtMostrarCodigo)
        val txtTime: TextView = findViewById(R.id.txtTime)
        val num = (Math.random()*100001).toInt()
        txtCodigo.text = num.toString()
        val timer = object : CountDownTimer(20000, 1000) {
            override fun onTick(millisUntilFinished: Long) {
                txtTime.text = "${millisUntilFinished/1000}"
            }

            override fun onFinish() {
                Toast.makeText(this@Retiro, "El tiempo ha caducado", Toast.LENGTH_SHORT).show()
            }

        }
        timer.start()
    }
}
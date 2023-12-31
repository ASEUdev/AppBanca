
package com.example.clon_nequi

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer

class SplashScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash_screen)
        VerSplasScreen()
    }


    fun VerSplasScreen(){
        object : CountDownTimer (2000, 1000){
            override fun onTick(millisUntilFinished: Long) {
            }

            override fun onFinish() {
                val intent = Intent(this@SplashScreen, MainActivity::class.java)
                startActivity(intent)
                finishAffinity()
            }

        }.start()
    }
}


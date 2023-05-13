package com.example.proyectocatedrafiinal.Splash

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.CountDownTimer
import com.example.proyectocatedrafiinal.Login.login
import com.example.proyectocatedrafiinal.R

class Main_Splash : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.splash_main)

        startTimer()

    }
    fun startTimer(){
        object : CountDownTimer(1500,1000){
            override fun onTick(millisUntilFinished: Long) {

            }

            override fun onFinish() {
                val intent= Intent(applicationContext, login::class.java).apply {  }
                startActivity(intent)
            }

        }.start()
    }
}
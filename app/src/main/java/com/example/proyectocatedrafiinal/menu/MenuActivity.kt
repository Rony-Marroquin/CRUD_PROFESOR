package com.example.proyectocatedrafiinal.menu

import android.annotation.SuppressLint
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.proyectocatedrafiinal.Alumno.MainActivity
import com.example.proyectocatedrafiinal.profesor.Porfesor_Activity
import com.example.proyectocatedrafiinal.R

class MenuActivity : AppCompatActivity() {
    @SuppressLint("ResourceType")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.menu)

        val btnAlumno = findViewById<Button>(R.id.button)
        val btnProfesor = findViewById<Button>(R.id.button2)
        val btncerrar = findViewById<Button>(R.id.button3)

        btnAlumno.setOnClickListener(){
            val Lanzar_alumno = Intent(this, MainActivity::class.java)
            startActivity(Lanzar_alumno)
        }

        btnProfesor.setOnClickListener(){
            val Lanzar_profesor = Intent(this, Porfesor_Activity::class.java)
            startActivity(Lanzar_profesor)
        }

    }
}
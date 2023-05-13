package com.example.proyectocatedrafiinal.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.example.proyectocatedrafiinal.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class CrearCuenta : AppCompatActivity() {

    private  lateinit var firebaseAuth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_crear_cuenta)
        val txtCorreo_Nuevo = findViewById<EditText>(R.id.editTextTextEmailAddress3)
        val contraseña_Nuevo = findViewById<EditText>(R.id.editTextTextPassword3)
        val btnregistrarse= findViewById<Button>(R.id.button5)


        firebaseAuth= Firebase.auth

        btnregistrarse.setOnClickListener(){
            crearNuevaCuenta(txtCorreo_Nuevo.text.toString(),contraseña_Nuevo.text.toString())
        }

    }

    private fun crearNuevaCuenta (email:String,password:String){

        firebaseAuth.createUserWithEmailAndPassword(email,password).addOnCompleteListener(this)
        {
            task ->

            if (task.isSuccessful){
                Toast.makeText(baseContext,"Cuenta creada exitosamente",Toast.LENGTH_LONG).show()
                val registrarse= Intent(this, login::class.java)
                startActivity(registrarse)
            }
            else{
                Toast.makeText(baseContext,"Ocurrio un error",Toast.LENGTH_LONG).show()
            }
        }

    }
}
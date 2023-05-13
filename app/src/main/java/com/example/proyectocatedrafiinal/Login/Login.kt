package com.example.proyectocatedrafiinal.Login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import com.example.proyectocatedrafiinal.menu.MenuActivity
import com.example.proyectocatedrafiinal.R
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class login : AppCompatActivity() {
    private  lateinit var firebaseAuth: FirebaseAuth
    private lateinit var  authStateListener: FirebaseAuth.AuthStateListener

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
          firebaseAuth= Firebase.auth
        val btnIngresar= findViewById<Button>(R.id.button3)
         val edtcorreo= findViewById<EditText>(R.id.editTextTextEmailAddress3)
        val edtcontraseña= findViewById<EditText>(R.id.editTextTextPassword3)
        val btnCrearCuenta= findViewById<TextView>(R.id.textView2)


        btnIngresar.setOnClickListener(){
           signIn(edtcorreo.text.toString(),edtcontraseña.text.toString())


        }

        btnCrearCuenta.setOnClickListener(){
            val registrarse= Intent(this, CrearCuenta::class.java)
            startActivity(registrarse)
        }
    }

    private fun signIn(email:String,Password:String){
        firebaseAuth.signInWithEmailAndPassword(email,Password).addOnCompleteListener(this){task ->
            if(task.isSuccessful){
                val user=firebaseAuth.currentUser
                Toast.makeText(baseContext,"Auteticacion exitosa",Toast.LENGTH_LONG).show()
                val lanzar = Intent(this, MenuActivity::class.java)
                startActivity(lanzar)
            }
            else{
                Toast.makeText(baseContext,"Error en el correo o contraseña",Toast.LENGTH_LONG).show()
            }
        }
    }
}
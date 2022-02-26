package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.example.myapplication.databinding.ActivityMainBinding
import com.google.android.material.dialog.MaterialAlertDialogBuilder
import com.google.firebase.firestore.ktx.firestore
import com.google.firebase.ktx.Firebase

class MainActivity : AppCompatActivity() {

    lateinit var layout:ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)

        layout= ActivityMainBinding.inflate(layoutInflater)

        setContentView(layout.root)

        //BASE DE DATOS FIREBASE
        val db = Firebase.firestore

        val entrar=layout.btnIn
        val salir=layout.btnOut
        val user=layout.etxtUser
        val key=layout.etxtKey

        var login=false


        salir.setOnClickListener {
            finish()
        }

        entrar.setOnClickListener {

            if(user.text.toString().isEmpty() || key.text.toString().isEmpty())
            {
                return@setOnClickListener
            }

            db.collection("Users")
                .whereEqualTo("nick",user.text.toString())
                .get()
                .addOnSuccessListener { result ->

                    Log.i("result",result.size().toString())

                    for (document in result) {
                        if(key.text.toString() == document.data.get("password").toString())
                        {
                            login=true
                        }
                    }

                    if(login){
                        startActivity(Intent(this,system::class.java))
                    }else{
                        MaterialAlertDialogBuilder(this)
                            .setTitle("Error de Inicio de Session")
                            .setMessage("Usuario o Contraseña incorrecta")
                            .setPositiveButton("Reintentar"){d,w->
                                user.text.clear()
                                key.text.clear()
                                user.requestFocus()
                            }
                    }

                }
        }

    }

}
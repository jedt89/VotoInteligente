package com.example.votointeligente

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import android.view.View
import android.widget.EditText
import android.widget.Toast

class LoginActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.login)
    }

    fun capturaLogin(v:View){
        //creacion de objeto usuario y conexion(?) con el campo en el xml
        val usuario=findViewById<EditText>(R.id.login_edt_usuario)
        val passwrod=findViewById<EditText>(R.id.login_edt_pass)
        //conversion del campo EditText a string mediante el objeto creado
        val user=usuario.text.toString()
        val pass=passwrod.text.toString()

        println("user: "+user+"\npass: "+pass)
        if (user.isEmpty())
            Toast.makeText(this,"Usuario invalido",Toast.LENGTH_LONG).show()
        else
            Toast.makeText(this,"Usuario correcto",Toast.LENGTH_LONG).show()
        if (pass.isEmpty())
            Toast.makeText(this,"Contraseña incorrecta",Toast.LENGTH_LONG).show()
        else
            Toast.makeText(this,"Contraseña valida",Toast.LENGTH_LONG).show()
    }
}
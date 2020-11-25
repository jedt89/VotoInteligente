package com.example.votointeligente

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    var loginList= ArrayList<UsuarioModel>()//crea un ArrayList con los datos de UsuarioModel
    lateinit var usuario:EditText
    lateinit var passwrod:EditText
    lateinit var user:String
    lateinit var pass:String
    lateinit var validacion: String



    override fun onCreate(savedInstanceState: Bundle?) {

        var context: Context = this
        super.onCreate(savedInstanceState)

        setContentView(R.layout.login)

    }

    fun capturaLogin(v:View){
        val intent = Intent(this, Resultados::class.java)
        intent.putExtra("id", 32)
        startActivity(intent)
    }

    fun capturaLogin2(v:View){

        lateinit var intent :Intent
        //creacion de objeto usuario y conexion(?) con el campo en el xml
        usuario=findViewById<EditText>(R.id.login_edt_usuario)
        passwrod=findViewById<EditText>(R.id.login_edt_pass)
        //conversion del campo EditText a string mediante el objeto creado
        user=usuario.text.toString()
        pass=passwrod.text.toString()

        if (user.isEmpty()) //true
            Toast.makeText(this,"Usuario inválido",Toast.LENGTH_LONG).show()
        else
            Toast.makeText(this,"Usuario válido $user",Toast.LENGTH_LONG).show()
        if (pass.isEmpty())
            Toast.makeText(this,"Contraseña inválida ",Toast.LENGTH_LONG).show()
        else
            Toast.makeText(this,"Contraseña válida $pass",Toast.LENGTH_LONG).show()


        Data()
       if(validacion=="1")
        acceder()


    }

    private fun acceder()
    {
        intent = Intent(this@MainActivity, PerfilActivity::class.java)
        intent.putExtra("parametro", "string")
        startActivity(intent)

    }

    private fun Data() {
        val call: Call<List<UsuarioModel>> = ApiClient.getClient.validar_usuario(user, pass)

        call.enqueue(
            object : Callback<List<UsuarioModel>> {
                override fun onFailure(call: Call<List<UsuarioModel>>, t: Throwable) {

                    if (t.message != null) {
                        val mensaje = t.message
                    }
                }

                override fun onResponse(
                    call: Call<List<UsuarioModel>>,
                    response: Response<List<UsuarioModel>>
                ) {

                    loginList.addAll(response!!.body()!!)

                    val exception: HttpException = HttpException(response)
                    println(exception.code())

                  if(response.code()==401)
                 {
                    println("Error 401")

                 }

                 else {
                     validacion  = "1"

                 }





                }
            }
        )


    }


}
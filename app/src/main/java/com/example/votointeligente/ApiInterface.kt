package com.example.votointeligente



import retrofit2.Call
import retrofit2.http.*


interface ApiInterface {

    //Votaciones
    @GET("/index.php/votacion/{nro_votacion}")
    fun listarVotaciones():
            Call<List<VotacionesModel>>
    @POST("/index.php/votacion/")
    fun votar():Call<List<VotacionesModel>>
    //Validaciones de usuario
    @FormUrlEncoded
    @POST("index.php/usuario")
    fun validar_usuario(
        @Field("rut") rut: String?,
        @Field("password") password: String?
    ): Call<List<UsuarioModel>>

    @FormUrlEncoded
    @POST("index.php/actualizarpassword")
    fun cambiar_password(
        @Field("rut") rut: String?,
        @Field("password_nuevo") password_nuevo: String?

    ): Call<List<UsuarioModel>>

    @FormUrlEncoded
    @POST("index.php/actualizarcorreo")
    fun cambiar_email(
        @Field("rut") rut: String?,
        @Field("email_nuevo") email_nuevo: String?

    ): Call<List<UsuarioModel>>

    //Pregunta y Votacion
    @GET("/index.php/votacion/preguntavotacion/{nro_votacion}/")
    fun pregunta_por_votacion(
        @Path("nro_votacion") nro_votacion: Int
    ): Call<List<PreguntaVotacion>>

    //Registrar opción de voto pregunta

    @FormUrlEncoded
    @POST("/index.php/votacion/respuestavotacion")
    fun votacion_respuesta(
        @Field("id_respuesta") id_respuesta: Int?,
        @Field("apruebo") apruebo: Int,
        @Field("rechazo") rechazo: Int?,
        @Field("abstengo") abstengo: Int?

    ): Call<List<RespuestaVotacionModel>>

    @GET("/index.php/respuestas/{nro_votacion}/")
    fun resultados(
        @Path("nro_votacion") nro_votacion: Int
    ): Call<List<RespuestaVotacionModel>>


}
package com.example.votointeligente

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class PreguntaVotacion (
    @Expose
    @SerializedName("id_pregunta")
    val id_pregunta: Int,
    @Expose
    @SerializedName("enunciado")
    val enunciado: String,
    @Expose
    @SerializedName("detalle")
    val detalle: String,
    @Expose
    @SerializedName("FK_nro_votacion")
    val FK_nro_votacion: Int,

    @Expose
    @SerializedName("FK_respuesta_votacion")
    val FK_respuesta_votacion: Int

)
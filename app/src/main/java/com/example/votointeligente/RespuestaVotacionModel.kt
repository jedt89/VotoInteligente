package com.example.votointeligente

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName

data class RespuestaVotacionModel (

    @Expose
    @SerializedName("id_respuesta")
    val id_respuesta: Int,

    @Expose
    @SerializedName("apruebo")
    val apruebo: Int,

    @Expose
    @SerializedName("rechazo")
    val rechazo: Int,

    @Expose
    @SerializedName("abstengo")
    val abstengo: Int,

    @Expose
    @SerializedName("nulo")
    val nulo: Int,

    @Expose
    @SerializedName("blanco")
    val blanco: Int


)



package com.example.votointeligente

import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName


data class VotacionesModel(

    @Expose
    @SerializedName("nro_votacion")
    val nro_votacion: Int,

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



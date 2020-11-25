package com.example.votointeligente

import android.graphics.Color
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.github.mikephil.charting.charts.BarChart
import com.github.mikephil.charting.charts.PieChart
import com.github.mikephil.charting.data.*
import com.github.mikephil.charting.utils.ColorTemplate
import retrofit2.Call
import retrofit2.Callback
import retrofit2.HttpException
import retrofit2.Response
import java.util.*
import kotlin.collections.ArrayList


class Resultados : AppCompatActivity() {
    var resultados= ArrayList<RespuestaVotacionModel>()//crea un ArrayList con los datos de UsuarioModel
    var dato : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultados)

        dato = savedInstanceState!!.getInt("id")


        //barras()
        circular()
    }

    private fun circular() {
        val grafico : PieChart = findViewById(R.id.grafico)
        var lista = ArrayList<PieEntry>()

        lista.add(PieEntry(resultados.get(0).apruebo.toFloat(), "apruebo"))
        lista.add(PieEntry(resultados.get(0).rechazo.toFloat(), "rechazo"))
        lista.add(PieEntry(resultados.get(0).blanco.toFloat(), "blanco"))
        lista.add(PieEntry(resultados.get(0).nulo.toFloat(), "nulo"))
        lista.add(PieEntry(resultados.get(0).abstengo.toFloat(), "abstengo"))

        val colors = ArrayList<Int>()
        for (c in ColorTemplate.COLORFUL_COLORS) colors.add(c)


        var dataSet = PieDataSet(lista, "Grafico circular")
        dataSet.sliceSpace = 8f
        dataSet.valueTextSize = 12f
        dataSet.valueTextColor = Color.WHITE
        dataSet.setColors(colors)

        grafico.centerText = "Repoblacion de arboles en el centro de la ciudad"
        grafico.data = PieData(dataSet)
    }

    fun barras() {
        val grafico : BarChart = findViewById(R.id.grafico)
        var lista = ArrayList<BarEntry>()

        for (i in 0..10){
            var y =(Math.random() * 8) + 1
            lista.add(BarEntry(i.toFloat(), y.toFloat()))
        }

        var dataSet = BarDataSet(lista, "Grafico de Barras")
        grafico.data = BarData(dataSet)
    }

    private fun data(numVotacion : Int) {
        val call: Call<List<RespuestaVotacionModel>> = ApiClient.getClient.resultados(numVotacion)

        call.enqueue(
            object : Callback<List<RespuestaVotacionModel>> {
                override fun onFailure(call: Call<List<RespuestaVotacionModel>>, t: Throwable) {

                    if (t.message != null) {
                        val mensaje = t.message
                    }
                }

                override fun onResponse(
                    call: Call<List<RespuestaVotacionModel>>,
                    response: Response<List<RespuestaVotacionModel>>
                ) {

                    resultados.addAll(response!!.body()!!)

                    val exception: HttpException = HttpException(response)
                    println(exception.code())


                }
            }
        )

    }
}
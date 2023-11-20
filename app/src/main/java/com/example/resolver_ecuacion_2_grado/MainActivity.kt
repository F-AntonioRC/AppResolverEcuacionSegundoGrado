package com.example.resolver_ecuacion_2_grado

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.EditText
import android.widget.Toast
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var valorA : EditText
    lateinit var valorB : EditText
    lateinit var valorC : EditText
    lateinit var x1 : EditText
    lateinit var x2 : EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        valorA = findViewById(R.id.valorA)
        valorB = findViewById(R.id.ValorB)
        valorC = findViewById(R.id.ValorC)
        x1 = findViewById(R.id.ResultadoX1)
        x2 = findViewById(R.id.ResultadoX2)

    }

    fun calcularResultado(view: View) {
        val A : Float? = valorA.text.toString().toFloatOrNull()
        val B : Float? = valorB.text.toString().toFloatOrNull()
        val C : Float? = valorC.text.toString().toFloatOrNull()

        if(A == null || B == null || C == null ){
            Toast.makeText(this, "Debe Ingresar los datos en los campos", Toast.LENGTH_SHORT).show()
        } else {
            val raiz = B * B - 4 * A * C

            if(raiz < 0){
                x1.setText("Sin solucion")
                x2.setText("Sin solucion")
            } else {
                val raizDiscriminante = sqrt(raiz)
                val resultadox1 =(-B + raizDiscriminante) / (2 * A)
                val resultadox2 = (-B - raizDiscriminante) / (2 * A)

                if(resultadox1 == resultadox2){
                    x1.setText(resultadox1.toString())
                    x2.setText("")
                }else{
                    x1.setText(resultadox1.toString())
                    x2.setText(resultadox2.toString())
                }
            }

        }
    }

    fun nuevaEcuacion(view: View) {
        valorA.setText("")
        valorB.setText("")
        valorC.setText("")
        x1.setText("")
        x2.setText("")
    }
}
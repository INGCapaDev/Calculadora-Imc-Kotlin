package com.example.imckotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.math.pow

class MainActivity : AppCompatActivity() {
    private lateinit var btnCalculate:Button
    private lateinit var btnExit:Button
    private lateinit var btnClear:Button
    private lateinit var lblIMC:TextView
    private lateinit var txtHeight:EditText
    private lateinit var txtWeight:EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnCalculate = findViewById(R.id.btnCalculate)
        btnExit = findViewById(R.id.btnExit)
        btnClear = findViewById(R.id.btnClear)
        lblIMC = findViewById(R.id.lblIMC)
        txtHeight = findViewById(R.id.txtHeight)
        txtWeight = findViewById(R.id.txtWeight)

        btnCalculate.setOnClickListener {
            if (txtHeight.text.toString().contentEquals("")){
                Toast.makeText(applicationContext, "Height Data Required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            if (txtWeight.text.toString().contentEquals("")){
                Toast.makeText(applicationContext, "Weight Data Required", Toast.LENGTH_SHORT).show()
                return@setOnClickListener
            }

            var height: Double = txtHeight.text.toString().toDouble()
            val weight: Double = txtWeight.text.toString().toDouble()

            height = height.pow(2.0)
            val imc: Double = weight / height
            val stringImc = "The IMC is ${"%.2f".format(imc)}"

            lblIMC.text = stringImc
        }

        btnClear.setOnClickListener {
            txtHeight.text.clear()
            txtWeight.text.clear()
            lblIMC.text = ""
            txtHeight.requestFocus()
        }

        btnExit.setOnClickListener {
            finish()
        }
    }
}
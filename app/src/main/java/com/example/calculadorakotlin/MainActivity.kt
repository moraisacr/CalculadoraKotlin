package com.example.calculadorakotlin

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import net.objecthunter.exp4j.ExpressionBuilder

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        supportActionBar!!.hide()

        numero_zero.setOnClickListener{AcrescentarUmaExpressao("0", true)}
        numero_um.setOnClickListener { AcrescentarUmaExpressao("1", true)}
        numero_dois.setOnClickListener { AcrescentarUmaExpressao("2", true)}
        numero_tres.setOnClickListener { AcrescentarUmaExpressao("3", true)}
        numero_quatro.setOnClickListener { AcrescentarUmaExpressao("4", true)}
        numero_cinco.setOnClickListener { AcrescentarUmaExpressao("5", true)}
        numero_seis.setOnClickListener { AcrescentarUmaExpressao("6" , true)}
        numero_sete.setOnClickListener { AcrescentarUmaExpressao("7", true)}
        numero_oito.setOnClickListener { AcrescentarUmaExpressao("8", true)}
        numero_nove.setOnClickListener { AcrescentarUmaExpressao("9", true)}
        ponto.setOnClickListener { AcrescentarUmaExpressao(".", true)}


        //operadores
        soma.setOnClickListener{ AcrescentarUmaExpressao("+",false)}
        subtracao.setOnClickListener{ AcrescentarUmaExpressao("-",false)}
        multiplicacao.setOnClickListener{ AcrescentarUmaExpressao("*",false)}
        divisao.setOnClickListener{ AcrescentarUmaExpressao("/",false)}

        limpar.setOnClickListener{
            expressao.text = ""
            txt_resultado.text = ""
        }
        backspace.setOnClickListener {
            val string =expressao.text.toString()

            if(string.isNotBlank()){
                expressao.text = string.substring(0,string.length-1)
            }
            txt_resultado.text = ""
        }
        igual.setOnClickListener {

            try{
                val expressao = ExpressionBuilder(expressao.text.toString()).build()
                val resultado = expressao.evaluate()
                val longResult = resultado.toLong()

                if(resultado == longResult.toDouble())
                    txt_resultado.text = longResult.toString()
                else
                    txt_resultado.text = resultado.toString()

            }catch(e: Exception){

            }


        }


    }

     fun AcrescentarUmaExpressao(string: String, limpar_dados: Boolean){

        if(txt_resultado.text.isNotEmpty()){
            expressao.text =""
        }
        if(limpar_dados){
            txt_resultado.text =""
            expressao.append(string)
        }else{
            expressao.append(txt_resultado.text)
            expressao.append(string)
            txt_resultado.text =""
        }
    }
}
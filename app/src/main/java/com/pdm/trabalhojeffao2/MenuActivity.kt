package com.pdm.trabalhojeffao2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.pdm.trabalhojeffao2.databinding.ActivityMenuBinding

class MenuActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityMenuBinding
    private  var opc=0
    private lateinit var  intent:Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMenuBinding.inflate(layoutInflater) //usaremos o viewBinding - infalte infla o xml para poder usar
        val view= viewBinding.root
        setContentView(view)

        viewBinding.btAtv1.setOnClickListener{

            startActivity(resultintent(1))
        }
        viewBinding.btAtv2.setOnClickListener {
            startActivity(resultintent(2))
        }
        viewBinding.btAtv3.setOnClickListener{
            startActivity(resultintent(3))
        }
        viewBinding.btAtv4.setOnClickListener {
            startActivity(resultintent(4))
        }
    }

    private fun resultintent( opc:Int): Intent {

        when(opc){
            1-> intent= Intent(this,MainActivity::class.java)
            2-> intent= Intent(this,Atividade2Activity::class.java)
            3-> intent= Intent(this,Atividade3Activity::class.java)
            4-> intent= Intent(this,Atividade4Activity::class.java)
            else -> println("Intent invalida")

        }
        return intent
    }
}
package com.pdm.trabalhojeffao2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pdm.trabalhojeffao2.Atividade4.FiltrarAlunoActivity
import com.pdm.trabalhojeffao2.Atividade4.InserirAlunoActivity
import com.pdm.trabalhojeffao2.Atividade4.MostrarAlunoActivity
import com.pdm.trabalhojeffao2.Atividade4.RemoverAlunoActivity
import com.pdm.trabalhojeffao2.databinding.ActivityAtividade4Binding

class Atividade4Activity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityAtividade4Binding
    private lateinit var intent: Intent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityAtividade4Binding.inflate(layoutInflater)
        val view= viewBinding.root
        setContentView(view)

        viewBinding.btInserirAluno.setOnClickListener {
            startActivity(resultintent(1))
        }

        viewBinding.btMostrarAluno.setOnClickListener {
            startActivity(resultintent(2))
        }

        viewBinding.btFiltrarAluno.setOnClickListener {
            startActivity(resultintent(3))
        }

        viewBinding.btRemoverAluno.setOnClickListener {
            startActivity(resultintent(4))
        }

    }

    private fun resultintent( opc:Int): Intent {

        when(opc){
            1-> intent= Intent(this, InserirAlunoActivity::class.java)
            2-> intent= Intent(this, MostrarAlunoActivity::class.java)
            3-> intent= Intent(this, FiltrarAlunoActivity::class.java)
            4-> intent= Intent(this, RemoverAlunoActivity::class.java)
            else -> println("Intent invalida")
        }
        return intent
    }
}
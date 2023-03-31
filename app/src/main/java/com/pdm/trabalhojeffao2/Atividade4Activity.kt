package com.pdm.trabalhojeffao2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import com.pdm.trabalhojeffao2.Atividade4.*
import com.pdm.trabalhojeffao2.databinding.ActivityAtividade4Binding

var alunoEnsSupMock = EnsinoSuperior("123","Philipe",12,10F)
var alunoEnsMedMock = EnsinoMedio("345","Jefferson",10,5)
class Atividade4Activity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityAtividade4Binding
    //private lateinit var intent: Intent
    private var listaAluno=ArrayList<Aluno>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityAtividade4Binding.inflate(layoutInflater)
        val view= viewBinding.root
        setContentView(view)
        listaAluno.add(alunoEnsSupMock)
        listaAluno.add(alunoEnsMedMock)




        viewBinding.btInserirAluno.setOnClickListener {
            startActivity(resultintent(1))
            var codigo = intent.extras?.getString("codigo")
            println("CODIGO RECEBIDO $codigo")
        }

        viewBinding.btMostrarAluno.setOnClickListener {
            //startActivity(resultintent(2))
            println(listaAluno)

        }

        viewBinding.btFiltrarAluno.setOnClickListener {
            startActivity(resultintent(3))
        }

        viewBinding.btRemoverAluno.setOnClickListener {
            startActivity(resultintent(4))
        }


        val bundle: Bundle? = intent.extras
        bundle?.apply{

            var listaAlunoRecebida = getSerializable("listaAluno")

            if(listaAlunoRecebida!= null){
                println("AQUI ESTA O RETORNO DA ACTIVITY:\n")
                println(listaAlunoRecebida)

            }
        }
    }



    override fun onRestart() {
        super.onRestart()
       // val name = intent.extras?.getString(KEY_NAME,"Key name nao enviada")
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
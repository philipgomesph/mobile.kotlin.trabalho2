package com.pdm.trabalhojeffao2.Atividade4

import android.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.pdm.trabalhojeffao2.databinding.ActivityMostrarAlunoBinding



// View Bind
private lateinit var viewBinding: ActivityMostrarAlunoBinding

//List View
lateinit var lvAlunos:ListView

class MostrarAlunoActivity : AppCompatActivity() {
    //Deletar aqui
    private var listaAluno=ArrayList<Aluno>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityMostrarAlunoBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)


        val bundle: Bundle? = intent.extras
        bundle?.apply{

            var listaAlunoRecebida = getSerializable("listaMostra")

            val alunos = listaAlunoRecebida as ArrayList<Aluno>
            listaAluno.addAll(alunos)

            if(listaAluno!= null){
                println("Array que chegou da ACTIVITY:\n")
                println(listaAluno)

            }
        }

        println("Array que chegou da ACTIVITY 11:\n")
        println(listaAluno)

        lvAlunos = viewBinding.lvAluno
        var arrayAdapterAlunos = ArrayAdapter(this, R.layout.simple_list_item_1 , listaAluno)
        lvAlunos.adapter = arrayAdapterAlunos

        viewBinding.btMaiorNumAlunos.setOnClickListener {


            var maiorNum=0
            var nomeCurso=""
            listaAluno.forEach {

                if (maiorNum<it.numeroDeAlunos)
                {
                    maiorNum=it.numeroDeAlunos
                    nomeCurso=it.nome
                }

            }
            if(listaAluno.isEmpty()==true){
                Toast.makeText(this,"Lista de alunos esta vazia",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Curso com Maior numero de alunos é o $nomeCurso com $maiorNum alunos.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
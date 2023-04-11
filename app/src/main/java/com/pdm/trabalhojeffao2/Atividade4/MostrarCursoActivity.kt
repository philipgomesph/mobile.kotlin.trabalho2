package com.pdm.trabalhojeffao2.Atividade4

import android.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.pdm.trabalhojeffao2.databinding.ActivityMostrarCursoBinding



// View Bind
private lateinit var viewBinding: ActivityMostrarCursoBinding

//List View
lateinit var lvAlunos:ListView

class MostrarAlunoActivity : AppCompatActivity() {

    private var listaCurso=ArrayList<Curso>()
    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        viewBinding = ActivityMostrarCursoBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)


        val bundle: Bundle? = intent.extras
        bundle?.apply{

            var listaAlunoRecebida = getSerializable("listaMostra")

            val alunos = listaAlunoRecebida as ArrayList<Curso>
            listaCurso.addAll(alunos)

            if(listaCurso!= null){
                println("Array que chegou da ACTIVITY:\n")
                println(listaCurso)

            }
        }

        println("Array que chegou da ACTIVITY 11:\n")
        println(listaCurso)

        lvAlunos = viewBinding.lvAluno
        var arrayAdapterAlunos = ArrayAdapter(this, R.layout.simple_list_item_1 , listaCurso)
        lvAlunos.adapter = arrayAdapterAlunos

        viewBinding.btMaiorNumAlunos.setOnClickListener {
            var maiorNum=0
            var nomeCurso=""
            listaCurso.forEach {
                if (maiorNum<it.numeroDeAlunos)
                {
                    maiorNum=it.numeroDeAlunos
                    nomeCurso=it.nome
                }
            }
            if(listaCurso.isEmpty()==true){
                Toast.makeText(this,"Lista de alunos esta vazia",Toast.LENGTH_LONG).show()
            }else{
                Toast.makeText(this, "Curso com Maior numero de alunos é o $nomeCurso com $maiorNum alunos.", Toast.LENGTH_SHORT).show()
            }
        }

        viewBinding.btTotalAlunos.setOnClickListener {
            var totalAlunos=0
            listaCurso.forEach {
                totalAlunos += it.numeroDeAlunos
            }
            Toast.makeText(this, "Numero total de alunos é $totalAlunos", Toast.LENGTH_SHORT).show()
        }

        viewBinding.btMenorNota.setOnClickListener {
            var menorNota = 9999999F
            var nomeCurso=""
            listaCurso.forEach {
                if(it is EnsinoSuperior){
                    if (menorNota>it.notaNoMec){
                        menorNota=it.notaNoMec
                        nomeCurso=it.nome
                    }
                    Toast.makeText(this, "Curso com menor nota no mec é $nomeCurso com nota $menorNota", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }
}
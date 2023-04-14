package com.pdm.trabalhojeffao2

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.pdm.trabalhojeffao2.Atividade4.*
import com.pdm.trabalhojeffao2.databinding.ActivityAtividade4Binding

var alunoEnsSupMock = EnsinoSuperior("123","PDM",12,10F)
var alunoEnsMedMock = EnsinoMedio("345","Eletronica",10,5)
class Atividade4Activity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityAtividade4Binding
    //private lateinit var intent: Intent
    private var listaCurso=ArrayList<Curso>()



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityAtividade4Binding.inflate(layoutInflater)
        val view= viewBinding.root
        setContentView(view)
        listaCurso.add(alunoEnsSupMock)
        listaCurso.add(alunoEnsMedMock)

        viewBinding.btInserirAluno.setOnClickListener {

            startActivity(resultintent(1))
            //var codigo = intent.extras?.getString("codigo")
            //println("CODIGO RECEBIDO $codigo")
            finish()
        }

        viewBinding.btMostrarAluno.setOnClickListener {
            //startActivity(resultintent(2))
            //println(listaCurso)
            val intent = Intent(this, MostrarAlunoActivity::class.java)
            intent.putExtra("listaMostra",listaCurso)
            this.startActivity(intent)
        }

        viewBinding.btFiltrarAluno.setOnClickListener {
            val intent = Intent(this, FiltrarCursoActivity::class.java)
            intent.putExtra("filtraCurso",listaCurso)
            this.startActivity(intent)
        }

        viewBinding.btRemoverAluno.setOnClickListener {
           // startActivity(resultintent(4))
            val intent = Intent(this, RemoverAlunoActivity::class.java)
            intent.putExtra("removeCurso",listaCurso)
            this.startActivity(intent)

        }


        val bundle: Bundle? = intent.extras
        bundle?.apply{

            var listaAlunoRecebida = getSerializable("listaCurso")

            val alunos = listaAlunoRecebida as ArrayList<Curso>
            listaCurso.addAll(alunos)

            if(listaAlunoRecebida!= null){
                println("AQUI ESTA O RETORNO DA ACTIVITY:\n")
                println(listaAlunoRecebida)

            }
        }
    }

    private fun resultintent( opc:Int): Intent {

        when(opc){
            1-> intent= Intent(this, InserirCursoActivity::class.java)
            2-> intent= Intent(this, MostrarAlunoActivity::class.java)
            3-> intent= Intent(this, FiltrarCursoActivity::class.java)
            4-> intent= Intent(this, RemoverAlunoActivity::class.java)
            else -> println("Intent invalida")
        }
        return intent
    }


}
package com.pdm.trabalhojeffao2.Atividade4

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.pdm.trabalhojeffao2.R
import com.pdm.trabalhojeffao2.databinding.ActivityRemoverCursoBinding

//viewBind
private lateinit var viewBinding:ActivityRemoverCursoBinding

//List View
lateinit var lvCursosDelete: ListView

//Array
private var listaCurso=ArrayList<Curso>()
class RemoverAlunoActivity : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding=ActivityRemoverCursoBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)

        val bundle: Bundle? = intent.extras
        bundle?.apply{

            var listaCursoRecebida = getSerializable("removeCurso")

            val cursos = listaCursoRecebida as ArrayList<Curso>
            listaCurso.addAll(cursos)

            if(listaCurso!= null){
                println("Array de cursos que chegou da ACTIVITY:\n")
                println(listaCurso)
            }
        }

        lvCursosDelete = viewBinding.lvCursoDelete
        var arrayAdapterCurso = ArrayAdapter(this, android.R.layout.simple_list_item_1 , listaCurso)
        lvCursosDelete.adapter = arrayAdapterCurso

        viewBinding.lvCursoDelete.onItemClickListener=AdapterView.OnItemClickListener{
            parent,view,position,id->

            //var pegaPosicao = listaCurso[position]

            Toast.makeText(this, "Curso Removido ${listaCurso[position]}", Toast.LENGTH_SHORT).show()
            listaCurso.removeAt(position)
            lvCursosDelete.adapter=arrayAdapterCurso

            //listaCurso.removeAt(position+1)
        }
    }
}
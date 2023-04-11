package com.pdm.trabalhojeffao2.Atividade4

import android.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.pdm.trabalhojeffao2.databinding.ActivityFiltrarCursoBinding

// View Bind
private lateinit var viewBinding: ActivityFiltrarCursoBinding

//List View
lateinit var lvCursos: ListView

class FiltrarCursoActivity : AppCompatActivity() {

    private var listaCurso=ArrayList<Curso>()
    private var listaCurso1=ArrayList<Curso>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding= ActivityFiltrarCursoBinding.inflate(layoutInflater)
        val view = viewBinding.root
        setContentView(view)

        val bundle: Bundle? = intent.extras
        bundle?.apply{

            var listaCursoRecebida = getSerializable("filtraCurso")

            val cursos = listaCursoRecebida as ArrayList<Curso>
            listaCurso.addAll(cursos)

            if(listaCurso!= null){
                println("Array de cursos que chegou da ACTIVITY:\n")
                println(listaCurso)
            }
        }

        lvCursos = viewBinding.lvCurso
        var arrayAdapterCurso = ArrayAdapter(this, R.layout.simple_list_item_1 , listaCurso)
        lvCursos.adapter = arrayAdapterCurso

        viewBinding.btMostraTudo.setOnClickListener {
            lvCursos = viewBinding.lvCurso
            var arrayAdapterCurso = ArrayAdapter(this, R.layout.simple_list_item_1 , listaCurso)
            lvCursos.adapter = arrayAdapterCurso
        }

        viewBinding.btFiltraCodigo.setOnClickListener {
            var codigoFiltrar = viewBinding.tvFiltraCodigo.text.toString()

            listaCurso.forEach {
                if(codigoFiltrar==it.codigoDoCurso){
                    listaCurso1.add(it)
                }
            }
            if(listaCurso1.isEmpty()){
                Toast.makeText(this, "Nao existe curso com esse codigo", Toast.LENGTH_SHORT).show()
            }else{
                var arrayAdapterCurso = ArrayAdapter(this, R.layout.simple_list_item_1 , listaCurso1)
                lvCursos.adapter = arrayAdapterCurso
            }

        }

    }
}
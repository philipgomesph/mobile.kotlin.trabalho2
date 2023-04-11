package com.pdm.trabalhojeffao2.Atividade4

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.pdm.trabalhojeffao2.Atividade4Activity
import com.pdm.trabalhojeffao2.databinding.ActivityInserirAlunoBinding



//Variaveis
private var listaAluno=ArrayList<Curso>()
private lateinit var viewBinding: ActivityInserirAlunoBinding



class InserirAlunoActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityInserirAlunoBinding.inflate(layoutInflater)
        var view= viewBinding.root
        setContentView(view)


        // Logica BackEnd
        viewBinding.btInserirAluno.setOnClickListener {
            var codigo = viewBinding.etCodigoDoCurso.text.toString()
            var nome = viewBinding.etNome.text.toString()
            var numAluno = viewBinding.etNumeroDeAlunos.text.toString().toInt()

            if (viewBinding.switEtapa.isChecked()==false){

                var notaMec = viewBinding.etNotaNoMec.text.toString().toFloat()
                var ensSup = EnsinoSuperior(codigo,nome,numAluno,notaMec)
                listaAluno.add(ensSup)

                Toast.makeText(this, "Curso cadastrado: $ensSup", Toast.LENGTH_SHORT).show()
            }
            if(viewBinding.switEtapa.isChecked()==true){

                var numDeAlunNaOlmpMat = viewBinding.etNumDeAlunosNaOlimpiada.text.toString().toInt()
                var ensMed = EnsinoMedio(codigo,nome,numAluno,numDeAlunNaOlmpMat)

                listaAluno.add(ensMed)

                Toast.makeText(this, "Curso cadastrado: $ensMed", Toast.LENGTH_SHORT).show()
            }

            val intent = Intent(this, Atividade4Activity::class.java)
            intent.putExtra("codigo",codigo )
            println("Lista de ALUNOS: $listaAluno /////")
            intent.putExtra("listaAluno",listaAluno)
            limpaCampo()
            finish()
            this.startActivity(intent)
        }


        // Logica FrontEnd
        viewBinding.switEtapa.setOnClickListener {
            viewBinding.etNotaNoMec.text.clear()
            viewBinding.etNumDeAlunosNaOlimpiada.text.clear()

            if (viewBinding.switEtapa.isChecked()==false)
            {

                viewBinding.etNumDeAlunosNaOlimpiada.setVisibility(View.INVISIBLE)
                viewBinding.etNotaNoMec.setVisibility(View.VISIBLE)

            }else{
                viewBinding.etNumDeAlunosNaOlimpiada.setVisibility(View.VISIBLE)
                viewBinding.etNotaNoMec.setVisibility(View.INVISIBLE)
            }
        }
        
        
    }
}

private fun limpaCampo(){
    viewBinding.etCodigoDoCurso.text.clear()
    viewBinding.etNome.text.clear()
    viewBinding.etNumeroDeAlunos.text.clear()
    viewBinding.etNotaNoMec.text.clear()
    viewBinding.etNumDeAlunosNaOlimpiada.text.clear()
}
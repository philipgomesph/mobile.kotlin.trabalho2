package com.pdm.trabalhojeffao2.Atividade4

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Toast
import com.pdm.trabalhojeffao2.R
import com.pdm.trabalhojeffao2.databinding.ActivityInserirAlunoBinding

var alunoEnsSupMock = EnsinoSuperior("123","Philipe",12,10F)
var alunoEnsMedMock = EnsinoMedio("345","Jefferson",10,5)

//Variaveis
private var listaAluno=ArrayList<Aluno>()
private lateinit var viewBinding: ActivityInserirAlunoBinding


class InserirAlunoActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityInserirAlunoBinding.inflate(layoutInflater)
        var view= viewBinding.root
        setContentView(view)

        listaAluno.add(alunoEnsSupMock)
        listaAluno.add(alunoEnsMedMock)


        // Logica BackEnd
        viewBinding.btInserirAluno.setOnClickListener {
            var codigo = viewBinding.etCodigoDoCurso.text.toString()
            var nome = viewBinding.etNome.text.toString()
            var numAluno = viewBinding.etNumeroDeAlunos.text.toString().toInt()
            if (viewBinding.switEtapa.isChecked()==false){

                var notaMec = viewBinding.etNotaNoMec.text.toString().toFloat()
                var ensSup = EnsinoSuperior(codigo,nome,numAluno,notaMec)
                listaAluno.add(ensSup)
                Toast.makeText(this, "Aluno cadastrado: $ensSup", Toast.LENGTH_SHORT).show()
            }
            if(viewBinding.switEtapa.isChecked()==true){
                var numDeAlunNaOlmpMat = viewBinding.etNumDeAlunosNaOlimpiada.text.toString().toInt()
                var ensMed = EnsinoMedio(codigo,nome,numAluno,numDeAlunNaOlmpMat)
                listaAluno.add(ensMed)
                Toast.makeText(this, "Aluno cadastrado: $ensMed", Toast.LENGTH_SHORT).show()
            }
            limpaCampo()
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
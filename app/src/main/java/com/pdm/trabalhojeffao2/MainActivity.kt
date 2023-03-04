package com.pdm.trabalhojeffao2

import android.content.Intent
import android.os.Bundle
import android.support.design.widget.Snackbar
import android.support.v7.app.AppCompatActivity
import android.util.Log
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import android.view.Menu
import android.view.MenuItem
import com.pdm.trabalhojeffao2.databinding.ActivityMainBinding

data class Funcionario(val cpf:String, val name:String, val function:String, val salary:Float)

class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityMainBinding
    var listaFuncionario = ArrayList<Funcionario>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityMainBinding.inflate(layoutInflater) //usaremos o viewBinding - infalte infla o xml para poder usar
        val view= viewBinding.root
        setContentView(view)
//trocando user git
        viewBinding.btAddEmploye.setOnClickListener{

            if(viewBinding.cpf.text.isEmpty() || viewBinding.function.text.isEmpty() || viewBinding.name.text.isEmpty() ||viewBinding.salary.text.isEmpty() ) {
                Log.d(
                    "Debug",
                    "Há campos não preenchidos"
                )
            }else
            {
                var salario = viewBinding.salary.text.toString().toFloat()

                var funcionario=Funcionario((viewBinding.cpf.text.toString()),(viewBinding.name.text.toString()),(viewBinding.function.text.toString()),salario)

                listaFuncionario.add(funcionario)

                Log.d("Debug","Lista de Funcionarios: $listaFuncionario")
            }
        }

        viewBinding.btNextExercise.setOnClickListener{
            startActivity(resultintent())
        }


    }

    private fun resultintent(): Intent {
        val intent= Intent(this,Atividade2Activity::class.java)

        return intent
    }

}
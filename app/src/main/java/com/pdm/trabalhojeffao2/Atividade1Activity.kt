package com.pdm.trabalhojeffao2

import android.R
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
import android.widget.*
import com.pdm.trabalhojeffao2.databinding.ActivityAtividade1Binding



data class Funcionario(val cpf:String, val name:String, val function:String, val salary:Float){
    override fun toString(): String = "\nFuncionario:\n\tCPF: $cpf\n\tNOME: $name\n\tFUNÇÂO: $function\n\tSALARIO: $salary"
}

lateinit var lv_pessoas : ListView


class MainActivity : AppCompatActivity() {

    private lateinit var viewBinding: ActivityAtividade1Binding
    var listaFuncionario = ArrayList<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewBinding = ActivityAtividade1Binding.inflate(layoutInflater) //usaremos o viewBinding - infalte infla o xml para poder usar
        val view= viewBinding.root
        setContentView(view)

        lv_pessoas = viewBinding.lvPessoas
        var arrayAdapterFuncionarios = ArrayAdapter(this, R.layout.simple_list_item_1, listaFuncionario)

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

                listaFuncionario.add(funcionario.toString())
                lv_pessoas.adapter = arrayAdapterFuncionarios


                viewBinding.cpf.text.clear()
                viewBinding.name.text.clear()
                viewBinding.salary.text.clear()
                viewBinding.function.text.clear()

                Log.d("Debug","Lista de Funcionarios: $listaFuncionario")
            }
        }

        viewBinding.lvPessoas.onItemClickListener=
            AdapterView.OnItemClickListener{
                parent, view,position,id->
                var textoSelecionado = parent.getItemAtPosition(position)
                Toast.makeText(this, "Item clicado: "+textoSelecionado,Toast.LENGTH_LONG).show()
                // listaFuncionario.set(position, pessoa) - UPDATE
                listaFuncionario.removeAt(position) // - DELETE
                lv_pessoas.adapter = arrayAdapterFuncionarios
            }
        viewBinding.btNextExercise.setOnClickListener{
            startActivity(resultintent())
        }


    }

    private fun resultintent(): Intent {
        val intent= Intent(this,MenuActivity::class.java)

        return intent
    }

}
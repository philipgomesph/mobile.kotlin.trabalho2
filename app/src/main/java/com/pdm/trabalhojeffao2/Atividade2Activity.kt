package com.pdm.trabalhojeffao2


import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.os.Debug
import android.util.Log
import com.pdm.trabalhojeffao2.databinding.ActivityAtividade2Binding


data class PostoDeGasolina(var cnpj:String,var cidade:String,var caixa:Double,var volumeArmazenado:Int , var qtdeFuncionarios:Int)
private lateinit var viewBinding: ActivityAtividade2Binding
var listaPosto = ArrayList<PostoDeGasolina>()


//Dado mocado
var postoMocado = PostoDeGasolina("000","0000",22.22,222,22)


class Atividade2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityAtividade2Binding.inflate(layoutInflater)
        val view= viewBinding.root
        setContentView(view)

        listaPosto.add(postoMocado)

        viewBinding.btInsert.setOnClickListener{
            if(cnpjExiste(viewBinding.cnpj.text.toString())!=true)
                if(camposVazios()==true) Log.d("Debug","Preencha os campos antes de continuar") else adicionaEmpresa()
            limpaCampos()
        }

        viewBinding.btShow.setOnClickListener{
            mostraEmpresa()
        }

        viewBinding.btUpdate.setOnClickListener{
            if(cnpjExiste(viewBinding.cnpj.text.toString())==false)
            {
                Log.d("Debug","CNPJ não existe")
            }else
                if(camposVazios()==true) Log.d("Debug","Preencha os campos antes de continuar, sera atualizado pelo cnpj") else atualizaEmpresa()

            limpaCampos()
        }

        viewBinding.btDelete.setOnClickListener{

            if(cnpjExiste(viewBinding.cnpj.text.toString())==false) Log.d("Debug","CNPJ não existe") else removeEmpresa()
            limpaCampos()

        }

        viewBinding.btBox.setOnClickListener{
            somaCaixa()

        }
        viewBinding.btBackExercise.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }
        viewBinding.btNextExercise.setOnClickListener{
            startActivity(Intent(this,Atividade3Activity::class.java))
        }
    }
}

fun adicionaEmpresa(){

        var cnpj = viewBinding.cnpj.text.toString()
        var cidade = viewBinding.cidade.text.toString()
        var caixa = viewBinding.caixa.text.toString().toDouble()
        var volumeArmazenado = viewBinding.volumeArmazenado.text.toString().toInt()
        var qtdFuncionario = viewBinding.qtdFuncionario.text.toString().toInt()


        var posto = PostoDeGasolina(cnpj,cidade,caixa,volumeArmazenado,qtdFuncionario)
        listaPosto.add(posto)

        Log.d("Debug","Lista de Empresas: $listaPosto")

}

fun mostraEmpresa(){
    Log.d("Debug","Empresas cadastradas: $listaPosto")
}

fun atualizaEmpresa(){

    var atualizaCnpj = viewBinding.cnpj.text.toString()

    listaPosto.forEach{
        if(it.cnpj == atualizaCnpj){
            it.cidade= viewBinding.cidade.text.toString()
            it.caixa = viewBinding.caixa.text.toString().toDouble()
            it.volumeArmazenado = viewBinding.volumeArmazenado.text.toString().toInt()
            it.qtdeFuncionarios = viewBinding.qtdFuncionario.text.toString().toInt()

            Log.d("Debug", "Empresa atualizada, valores: $it")
        }
    }
}

fun removeEmpresa(){
    if (viewBinding.cnpj.text.isEmpty()) {
        Log.d("Debug", "Campo CNPJ nao inserido, inserir cnpj a ser deletado")
    }else{
        listaPosto.forEach{
            if(it.cnpj == viewBinding.cnpj.text.toString())
                Log.d("Debug","Empresa deletada com sucesso ${viewBinding.cnpj.text.toString()}")
                listaPosto.remove(it)

        }
    }
}

fun cnpjExiste(cnpjVerifica:String):Boolean{
     var existe:Boolean=false

    listaPosto.forEach{
        if(it.cnpj == cnpjVerifica)
        {
            existe=true
        }
    }

    return  existe
}

fun camposVazios():Boolean {
    var verifica: Boolean =false

    if (viewBinding.cnpj.text.isEmpty() || viewBinding.cidade.text.isEmpty() || viewBinding.caixa.text.isEmpty() || viewBinding.caixa.text.isEmpty() || viewBinding.volumeArmazenado.text.isEmpty() || viewBinding.qtdFuncionario.text.isEmpty()){
        Log.d("Debug", "Há campos não preenchidos")
        verifica = true

    }
    return verifica
}

fun somaCaixa(){
    var soma:Double=0.0
    listaPosto.forEach{
        soma += it.caixa
    }
    Log.d("Debug","Caixa total das empresas: $soma")
}

fun limpaCampos(){
    viewBinding.cnpj.text.clear()
    viewBinding.cidade.text.clear()
    viewBinding.caixa.text.clear()
    viewBinding.volumeArmazenado.text.clear()
    viewBinding.qtdFuncionario.text.clear()
}
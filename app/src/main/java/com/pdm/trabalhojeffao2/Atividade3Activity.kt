package com.pdm.trabalhojeffao2

import android.R
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import android.widget.Toast
import com.pdm.trabalhojeffao2.ClassAtv3.Cadeira
import com.pdm.trabalhojeffao2.ClassAtv3.Cama
import com.pdm.trabalhojeffao2.ClassAtv3.Estante
import com.pdm.trabalhojeffao2.ClassAtv3.Movel

import com.pdm.trabalhojeffao2.databinding.ActivityAtividade3Binding

private lateinit var viewBinding: ActivityAtividade3Binding

// Atributos moveis
private lateinit var codigo:String
private lateinit var material:String
private var peso=0F
private lateinit var cor:String

//Cadeira
private  var qtdPernas =0
private  var encosto = false

//Cama
private lateinit var tamanhoCama :String
private var pesoSuportado=0F

//Estante
private var alturaEstante = 0F
private var qtdCompartimentos = 0

//List View
lateinit var lvMoveis:ListView


//Dado Mocados
var cadeiraMock = Cadeira("123", "Madeira",15F, "Marrom", 3, true)
var camaMock = Cama("456", "Aço",200F, "Branca", "KingSize", 1000F)
var estanteMock = Estante("789", "Madeira", 5F, "Ferro",2F,10)

private var listaMoveis=ArrayList<Movel>()
private lateinit var listaCadeira:Cadeira
private lateinit var listaCama: Cama
private lateinit var listaEstante: Estante


class Atividade3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityAtividade3Binding.inflate(layoutInflater)
        val view= viewBinding.root
        setContentView(view)

        viewBinding.cbChair.setChecked(true)
        listaMoveis.add(cadeiraMock)
        listaMoveis.add(camaMock)
        listaMoveis.add(estanteMock)
        lvMoveis = viewBinding.lvMovel
        var arrayAdapterMoveis = ArrayAdapter(this, R.layout.simple_list_item_1 , listaMoveis)

        lvMoveis.adapter = arrayAdapterMoveis
        // Logica BackEnd

        /*
       //Moveis
        codigo = viewBinding.etCode.text.toString()
        material = viewBinding.etMaterial.text.toString()
        peso = viewBinding.etWeight.text.toString().toFloat()
        cor = viewBinding.etColor.text.toString()


        //Atributos Cadeira
        qtdPernas = viewBinding.etLags.text.toString().toInt()
        encosto = viewBinding.cbChairBack.isChecked()

        //Atributos Cama
        tamanhoCama = viewBinding.etSize.text.toString()
        pesoSuportado = viewBinding.etWeightSuported.text.toString().toFloat() //float

        //Atributos Estante
        alturaEstante = viewBinding.etEstanteHeight.text.toString().toFloat()//float
        qtdCompartimentos = viewBinding.etQtdCompart.text.toString().toInt() //int
        */


        //Adicionar Movel
        viewBinding.bttAddMovel.setOnClickListener{

            if(viewBinding.etCode.isEnabled()==false){
                Toast.makeText(this,"Agora é possivel adicionar um novo movel", Toast.LENGTH_LONG).show()
                viewBinding.etCode.setEnabled(true)
                return@setOnClickListener
            }

            if(verificaCamposMovel()==true){
                Toast.makeText(this,"Existe campos vazio para moveis", Toast.LENGTH_LONG).show()
                return@setOnClickListener
            }

            //Atributo Moveis
            codigo = viewBinding.etCode.text.toString()
            material = viewBinding.etMaterial.text.toString()
            peso = viewBinding.etWeight.text.toString().toFloat()
            cor = viewBinding.etColor.text.toString()

            if(viewBinding.cbChair.isChecked()){
                //Atributos Cadeira
                if(verificaCamposCadeira()==true){
                    Toast.makeText(this,"Existe campos vazio para cadeira", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }
                qtdPernas = viewBinding.etLags.text.toString().toInt()
                encosto = viewBinding.cbChairBack.isChecked()

                if(qtdPernas<3)
                {
                    Toast.makeText(this,"Cadeira tem menos que 3 pernas, favor inserir mais pernas", Toast.LENGTH_LONG).show()
                }else{
                    var cadeira = Cadeira(codigo, material, peso, cor, qtdPernas, encosto)
                    listaMoveis.add(cadeira)
                    lvMoveis.adapter = arrayAdapterMoveis

                    Toast.makeText(this,"Cadeira adicionada: $cadeira", Toast.LENGTH_LONG).show()
                    limpaCampo()
                }
            }
            if (viewBinding.cbBed.isChecked()){

                if(verificaCamposCama()==true){
                    Toast.makeText(this,"Existe campos vazio para Cama", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }
                //Atributos Cama
                tamanhoCama = viewBinding.etSize.text.toString()
                pesoSuportado = viewBinding.etWeightSuported.text.toString().toFloat() //float

                var cama = Cama(codigo, material, peso, cor, tamanhoCama, pesoSuportado)
                listaMoveis.add(cama)
                lvMoveis.adapter = arrayAdapterMoveis

                Toast.makeText(this,"Cama adicionada: $cama", Toast.LENGTH_LONG).show()
                limpaCampo()

            }
            if(viewBinding.cbEstante.isChecked()){
                if (verificaCamposEstante()==true){
                    Toast.makeText(this,"Existe campos vazio para Estante", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }

                //Atributos Estante
                alturaEstante = viewBinding.etEstanteHeight.text.toString().toFloat()//float
                qtdCompartimentos = viewBinding.etQtdCompart.text.toString().toInt() //int

                var estante = Estante(codigo, material, peso, cor, alturaEstante, qtdCompartimentos)
                listaMoveis.add(estante)
                lvMoveis.adapter = arrayAdapterMoveis

                Toast.makeText(this,"Estante adicionada: $estante", Toast.LENGTH_LONG).show()
                limpaCampo()
            }
        }

        viewBinding.lvMovel.onItemClickListener=AdapterView.OnItemClickListener{
            parent,view,position,id->

            //var itemSelecionado = parent.getItemIdAtPosition(position)

            var atualizaMovel = listaMoveis[position]
            viewBinding.etCode.setEnabled(false)

            viewBinding.etCode.setText(atualizaMovel.code)

            viewBinding.btRemoveMovel.setOnClickListener{

                Toast.makeText(this,"Movel Removido: ${listaMoveis[position]}", Toast.LENGTH_LONG).show()
                listaMoveis.removeAt(position)
                lvMoveis.adapter=arrayAdapterMoveis
            }

            viewBinding.btUpdateMovel.setOnClickListener {
                if(verificaCamposMovel()==true){
                    Toast.makeText(this,"Existe campos vazio para moveis", Toast.LENGTH_LONG).show()
                    return@setOnClickListener
                }
                var codeToUpdate = viewBinding.etCode.text.toString()

                //Atributo Moveis
                codigo = viewBinding.etCode.text.toString()
                material = viewBinding.etMaterial.text.toString()
                peso = viewBinding.etWeight.text.toString().toFloat()
                cor = viewBinding.etColor.text.toString()

                if(viewBinding.cbChair.isChecked()){
                    if(verificaCamposCadeira()==true){
                        Toast.makeText(this,"Existe campos vazio para cadeira", Toast.LENGTH_LONG).show()
                        return@setOnClickListener
                    }
                    //Atributos Cadeira
                    qtdPernas = viewBinding.etLags.text.toString().toInt()
                    encosto = viewBinding.cbChairBack.isChecked()

                    if(qtdPernas<3)
                    {
                        Toast.makeText(this,"Cadeira tem menos que 3 pernas, favor inserir mais pernas", Toast.LENGTH_LONG).show()
                    }else{
                        var cadeira = Cadeira(codigo, material, peso, cor, qtdPernas, encosto)
                        listaMoveis.add(position,cadeira)
                        lvMoveis.adapter = arrayAdapterMoveis

                        Toast.makeText(this,"Cadeira adicionada: $cadeira", Toast.LENGTH_LONG).show()
                        limpaCampo()
                    }
                }
                if (viewBinding.cbBed.isChecked())
                {

                    //Atributos Cama
                    tamanhoCama = viewBinding.etSize.text.toString()
                    pesoSuportado = viewBinding.etWeightSuported.text.toString().toFloat() //float

                    var cama = Cama(codigo, material, peso, cor, tamanhoCama, pesoSuportado)
                    listaMoveis.add(position,cama)
                    lvMoveis.adapter = arrayAdapterMoveis

                    Toast.makeText(this,"Cama adicionada: $cama", Toast.LENGTH_LONG).show()
                    limpaCampo()

                }
                if(viewBinding.cbEstante.isChecked())
                {
                    //Atributos Estante
                    alturaEstante = viewBinding.etEstanteHeight.text.toString().toFloat()//float
                    qtdCompartimentos = viewBinding.etQtdCompart.text.toString().toInt() //int

                    var estante = Estante(codigo, material, peso, cor, alturaEstante, qtdCompartimentos)
                    listaMoveis.add(position,estante)
                    lvMoveis.adapter = arrayAdapterMoveis

                    Toast.makeText(this,"Estante adicionada: $estante", Toast.LENGTH_LONG).show()
                    limpaCampo()
                }

                listaMoveis.removeAt(position+1)
            }
        }


        //Logica FrontEnd
        viewBinding.cbChair.setOnClickListener{
            if(viewBinding.cbChair.isChecked()){
                viewBinding.etLags.setVisibility(View.VISIBLE)
                viewBinding.cbChairBack.setVisibility(View.VISIBLE)
                viewBinding.etSize.setVisibility(View.INVISIBLE)
                viewBinding.etWeightSuported.setVisibility(View.INVISIBLE)
                viewBinding.etEstanteHeight.setVisibility(View.INVISIBLE)
                viewBinding.etQtdCompart.setVisibility(View.INVISIBLE)
                limpaCampo()
            }
            viewBinding.cbBed.setChecked(false)
            viewBinding.cbEstante.setChecked(false)
        }

        viewBinding.cbBed.setOnClickListener{
            if(viewBinding.cbBed.isChecked()){
                viewBinding.etLags.setVisibility(View.INVISIBLE)
                viewBinding.cbChairBack.setVisibility(View.INVISIBLE)
                viewBinding.cbChairBack.setChecked(false)
                viewBinding.etSize.setVisibility(View.VISIBLE)
                viewBinding.etWeightSuported.setVisibility(View.VISIBLE)
                viewBinding.etEstanteHeight.setVisibility(View.INVISIBLE)
                viewBinding.etQtdCompart.setVisibility(View.INVISIBLE)
                limpaCampo()
            }
            viewBinding.cbChair.setChecked(false)
            viewBinding.cbEstante.setChecked(false)
        }

        viewBinding.cbEstante.setOnClickListener{
            if(viewBinding.cbEstante.isChecked()){
                viewBinding.etLags.setVisibility(View.INVISIBLE)
                viewBinding.cbChairBack.setVisibility(View.INVISIBLE)
                viewBinding.cbChairBack.setChecked(false)
                viewBinding.etSize.setVisibility(View.INVISIBLE)
                viewBinding.etWeightSuported.setVisibility(View.INVISIBLE)
                viewBinding.etEstanteHeight.setVisibility(View.VISIBLE)
                viewBinding.etQtdCompart.setVisibility(View.VISIBLE)
                limpaCampo()
            }
            viewBinding.cbChair.setChecked(false)
            viewBinding.cbBed.setChecked(false)
        }

    }

}

private fun limpaCampo(){
    viewBinding.etCode.text.clear()
    viewBinding.etMaterial.text.clear()
    viewBinding.etWeight.text.clear()
    viewBinding.etColor.text.clear()

    viewBinding.etLags.text.clear()
    viewBinding.cbChairBack.setChecked(false)

    viewBinding.etSize.text.clear()
    viewBinding.etWeightSuported.text.clear()

    viewBinding.etEstanteHeight.text.clear()
    viewBinding.etQtdCompart.text.clear()
}

private fun verificaCamposMovel():Boolean{
    var verific:Boolean=false
    if(viewBinding.etCode.text.isEmpty() || viewBinding.etMaterial.text.isEmpty() || viewBinding.etWeight.text.isEmpty() || viewBinding.etColor.text.isEmpty())
        verific=true
    return verific
}

private fun verificaCamposCadeira():Boolean{
    var verific:Boolean=false
    if(viewBinding.etLags.text.isEmpty())
        verific=true
    return verific
}

private fun verificaCamposCama():Boolean{
    var verific:Boolean=false
    if(viewBinding.etSize.text.isEmpty() || viewBinding.etWeightSuported.text.isEmpty())
        verific=true
    return verific
}

private fun verificaCamposEstante():Boolean{
    var verific:Boolean=false
    if(viewBinding.etEstanteHeight.text.isEmpty() || viewBinding.etQtdCompart.text.isEmpty())
        verific=true
    return verific
}

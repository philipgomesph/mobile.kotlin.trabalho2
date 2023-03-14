package com.pdm.trabalhojeffao2.ClassAtv3

class Cadeira (code:String, material:String,weight:Float, color:String, qtdLag:Int, chairBack:Boolean) :Movel(code, material,weight, color){
    var qtdLag: Int
    var chairBack:Boolean

    init{
        this.qtdLag = qtdLag
        this.chairBack = chairBack
    }

    override fun toString(): String {
        return "Movel: \n\tCodigo ='$code',\n\t Material ='$material',\n\t Peso =$weight,\n\t Cor ='$color', \n\t Tipo =Cadeira,\n\t Pernas ='$qtdLag',\n\t Encosto ='$chairBack' "
    }


}
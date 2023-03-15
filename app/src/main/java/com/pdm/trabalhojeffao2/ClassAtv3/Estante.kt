package com.pdm.trabalhojeffao2.ClassAtv3

class Estante(code: String, material: String, weight: Float, color: String,estanteHeight:Float,qtdCompart: Int) :
    Movel(code, material, weight, color) {
        var estanteHeight:Float
        var qtdCompart:Int

        init {
            this.estanteHeight = estanteHeight
            this.qtdCompart = qtdCompart
        }

    override fun toString(): String {
        return "Movel: \n\tCodigo ='$code',\n\t" +
                " Material ='$material',\n\t" +
                " Peso =$weight,\n\t" +
                " Cor ='$color', \n\t" +
                " Tipo =Estante,\n\t" +
                " Altura ='$estanteHeight',\n\t" +
                " Quantidade de Compartimentos ='$qtdCompart'"
    }
}
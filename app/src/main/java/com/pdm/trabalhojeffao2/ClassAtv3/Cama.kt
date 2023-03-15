package com.pdm.trabalhojeffao2.ClassAtv3

class Cama(code:String, material:String,weight:Float, color:String, size:String, weightSupported: Float): Movel(code, material, weight, color) {
    var size:String
    var weightSupported: Float

    init {
        this.size=size
        this.weightSupported = weightSupported
    }

    override fun toString(): String {
        return "Movel: \n\tCodigo ='$code',\n\t" +
                " Material ='$material',\n\t" +
                " Peso =$weight,\n\t" +
                " Cor ='$color', \n\t" +
                " Tipo =Cama,\n\t" +
                " Tamanho ='$size',\n\t" +
                " Peso Suportado = '$weightSupported' "
    }
}

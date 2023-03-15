package com.pdm.trabalhojeffao2.ClassAtv3

open class Movel(code:String, material:String,weight:Float, color:String) {
    var code:String
    var material:String
    var weight:Float
    var color:String

    init {
        this.code = code
        this.material = material
        this.weight = weight
        this.color = color
    }

    override fun toString(): String {
        return "Movel: \n\tCodigo ='$code',\n\t Material ='$material',\n\t Peso ='$weight',\n\t Cor ='$color'"
    }
}
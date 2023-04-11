package com.pdm.trabalhojeffao2.Atividade4


import java.io.Serializable


open class Curso (var codigoDoCurso:String, var nome:String, var numeroDeAlunos:Int):
    Serializable {

   /* var codigoDoCurso:String
    var nome:String
    var numeroDeAlunos:Int
*/
   init {
       this.codigoDoCurso = codigoDoCurso
       this.nome = nome
       this.numeroDeAlunos = numeroDeAlunos

   }
    override fun toString(): String {
        return "Curso: \n\t" +
            "Codigo do curso: $codigoDoCurso ,\n\t" +
            "Nome: $nome ,\n\t" +
            "Numero de Alunos: $numeroDeAlunos\n\t ,"}


}
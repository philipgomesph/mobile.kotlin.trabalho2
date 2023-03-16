package com.pdm.trabalhojeffao2.Atividade4

open class Aluno (codigoDoCurso:String, nome:String, numeroDeAlunos:Int){
    var codigoDoCurso:String
    var nome:String
    var numeroDeAlunos:Int

    init {
        this.codigoDoCurso=codigoDoCurso
        this.nome=nome
        this.numeroDeAlunos=numeroDeAlunos
    }

    override fun toString(): String {
        return "Aluno: \n\t" +
                "Codigo do curso: $codigoDoCurso ,\n\t" +
                "Nome: $nome ,\n\t" +
                "Numero de Alunos: $numeroDeAlunos\n\t ,"
    }

}
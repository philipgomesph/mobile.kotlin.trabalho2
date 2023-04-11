package com.pdm.trabalhojeffao2.Atividade4

import java.io.Serializable

class EnsinoSuperior(codigoDoCurso: String, nome: String, numeroDeAlunos: Int, notaNoMec:Float):
    Curso(codigoDoCurso, nome, numeroDeAlunos), Serializable {
        var notaNoMec:Float
        init {
            this.notaNoMec=notaNoMec
        }

    override fun toString(): String {
        return "Curso: \n\t" +
                "Codigo do curso: $codigoDoCurso ,\n\t" +
                "Nome: $nome ,\n\t" +
                "Numero de Alunos: $numeroDeAlunos\n\t " +
                "Etapa: EnsinoSuperior\n\t" +
                "Nota no Mec: $notaNoMec\n\t"
    }


}
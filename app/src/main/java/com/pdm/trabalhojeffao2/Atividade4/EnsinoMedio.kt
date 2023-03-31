package com.pdm.trabalhojeffao2.Atividade4

import android.os.Parcelable
import kotlinx.parcelize.Parcelize
import java.io.Serializable


class EnsinoMedio(  codigoDoCurso:String,   nome:String,  numeroDeAlunos:Int,  numDeAlunoNaOlimpiadaDeMatematica:Int):
    Serializable,
    Aluno(codigoDoCurso, nome, numeroDeAlunos) {
        var numDeAlunoNaOlimpiadaDeMatematica:Int
        init {
            this.numDeAlunoNaOlimpiadaDeMatematica=numDeAlunoNaOlimpiadaDeMatematica
        }

    override fun toString(): String {
        return  "Aluno: \n\t" +
                "Codigo do curso: $codigoDoCurso ,\n\t" +
                "Nome: $nome ,\n\t" +
                "Numero de Alunos: $numeroDeAlunos\n\t " +
                "Etapa: EnsinoMedio\n\t" +
                "Numero de Alunos na Olimpiadas de Matematica: $numDeAlunoNaOlimpiadaDeMatematica\n\t"
    }

}
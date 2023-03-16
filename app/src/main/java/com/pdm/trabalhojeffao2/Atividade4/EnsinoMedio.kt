package com.pdm.trabalhojeffao2.Atividade4

class EnsinoMedio(codigoDoCurso: String, nome: String, numeroDeAlunos: Int, numDeAlunoNaOlimpiadaDeMatematica:Int):
    Aluno(codigoDoCurso, nome, numeroDeAlunos) {
        var numDeAlunoNaOlimpiadaDeMatematica:Int
        init {
            this.numDeAlunoNaOlimpiadaDeMatematica=numDeAlunoNaOlimpiadaDeMatematica
        }

    override fun toString(): String {
        return "Etapa: EnsinoMedio\n\t" +
                "Numero de Alunos na Olimpiadas de Matematica: $numDeAlunoNaOlimpiadaDeMatematica\n\t"
    }

}
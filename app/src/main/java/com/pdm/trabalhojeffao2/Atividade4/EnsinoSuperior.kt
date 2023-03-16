package com.pdm.trabalhojeffao2.Atividade4

class EnsinoSuperior(codigoDoCurso: String, nome: String, numeroDeAlunos: Int, notaNoMec:Float):
    Aluno(codigoDoCurso, nome, numeroDeAlunos) {
        var notaNoMec:Float
        init {
            this.notaNoMec=notaNoMec
        }

    override fun toString(): String {
        return "Etapa: EnsinoSuperior\n\t" +
                "Nota no Mec: $notaNoMec\n\t"
    }


}
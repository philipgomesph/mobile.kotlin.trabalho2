package com.pdm.trabalhojeffao2.Atividade4

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.pdm.trabalhojeffao2.R
import com.pdm.trabalhojeffao2.databinding.ActivityInserirAlunoBinding

class InserirAlunoActivity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityInserirAlunoBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityInserirAlunoBinding.inflate(layoutInflater)
        var view= viewBinding.root
        setContentView(view)


    }
}
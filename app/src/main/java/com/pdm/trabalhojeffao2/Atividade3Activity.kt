package com.pdm.trabalhojeffao2

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View

import com.pdm.trabalhojeffao2.databinding.ActivityAtividade3Binding

private lateinit var viewBinding: ActivityAtividade3Binding
class Atividade3Activity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityAtividade3Binding.inflate(layoutInflater)
        val view= viewBinding.root
        setContentView(view)



    }


}
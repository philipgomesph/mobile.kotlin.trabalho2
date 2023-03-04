package com.pdm.trabalhojeffao2

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.pdm.trabalhojeffao2.databinding.ActivityAtividade2Binding
import com.pdm.trabalhojeffao2.databinding.ActivityMainBinding

class Atividade2Activity : AppCompatActivity() {
    private lateinit var viewBinding: ActivityAtividade2Binding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        viewBinding = ActivityAtividade2Binding.inflate(layoutInflater)
        val view= viewBinding.root
        setContentView(view)

        viewBinding.btBackExercise.setOnClickListener{
            startActivity(Intent(this,MainActivity::class.java))
        }

    }
}
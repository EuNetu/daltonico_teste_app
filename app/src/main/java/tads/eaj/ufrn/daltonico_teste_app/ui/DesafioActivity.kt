package tads.eaj.ufrn.daltonico_teste_app.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import tads.eaj.ufrn.daltonico_teste_app.R
import tads.eaj.ufrn.daltonico_teste_app.databinding.ActivityDesafioBinding
import tads.eaj.ufrn.daltonico_teste_app.databinding.ActivityMainBinding

class DesafioActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDesafioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_desafio)
    }
}
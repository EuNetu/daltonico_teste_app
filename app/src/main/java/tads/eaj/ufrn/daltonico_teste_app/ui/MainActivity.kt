package tads.eaj.ufrn.daltonico_teste_app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import tads.eaj.ufrn.daltonico_teste_app.R
import tads.eaj.ufrn.daltonico_teste_app.databinding.ActivityMainBinding
import tads.eaj.ufrn.daltonico_teste_app.model.Desafio

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var respostaDesafio = Desafio("", "", "")

    val dasafioOneLauncher = registerForActivityResult(ActivityResultContracts.StartActivityForResult()){
            result ->
        if (result.resultCode == RESULT_OK){

        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        binding.respostasDesafio = respostaDesafio
        binding.buttonDesafio1.setOnClickListener {
            intent = Intent(this, DesafioActivity::class.java)
            intent.putExtra("resposta1", binding.textViewDesafio1.text)
            dasafioOneLauncher.launch(intent)
        }
    }
}
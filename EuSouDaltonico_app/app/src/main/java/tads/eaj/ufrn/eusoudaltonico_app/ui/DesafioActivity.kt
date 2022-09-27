package tads.eaj.ufrn.eusoudaltonico_app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.databinding.DataBindingUtil
import tads.eaj.ufrn.eusoudaltonico_app.R
import tads.eaj.ufrn.eusoudaltonico_app.databinding.ActivityDesafioBinding

class DesafioActivity : AppCompatActivity() {

    private lateinit var binding: ActivityDesafioBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_desafio)
        binding.imageViewDesafio.setImageResource(intent.extras!!.getInt("IMAGEM"))
        binding.buttonOK.setOnClickListener {
            val intent = Intent()
            intent.putExtra("RESULTADO", binding.editTextResposta.text.toString())
            setResult(RESULT_OK, intent)
            finish()
        }
        binding.buttonCancelar.setOnClickListener {
            setResult(RESULT_CANCELED)
            finish()
        }
    }
}
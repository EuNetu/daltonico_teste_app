package tads.eaj.ufrn.eusoudaltonico_app.ui

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Toast
import androidx.activity.result.contract.ActivityResultContracts
import androidx.databinding.DataBindingUtil
import tads.eaj.ufrn.eusoudaltonico_app.R
import tads.eaj.ufrn.eusoudaltonico_app.databinding.ActivityMainBinding
import tads.eaj.ufrn.eusoudaltonico_app.ui.model.Desafio

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    var respostaDesafio = Desafio("", "", "")

    val dasafioOneLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                respostaDesafio.resposta1 = result.data!!.getStringExtra("RESULTADO").toString()
            }else{
                Toast.makeText(this, "Desafio cancelado", Toast.LENGTH_SHORT).show()
            }
        }
    val dasafioTwoLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                respostaDesafio.resposta2 = result.data!!.getStringExtra("RESULTADO").toString()
            }else{
                Toast.makeText(this, "Desafio cancelado", Toast.LENGTH_SHORT).show()
            }
        }
    val dasafioThreeLauncher =
        registerForActivityResult(ActivityResultContracts.StartActivityForResult()) { result ->
            if (result.resultCode == RESULT_OK) {
                respostaDesafio.resposta3 = result.data!!.getStringExtra("RESULTADO").toString()
            }else{
                Toast.makeText(this, "Desafio cancelado", Toast.LENGTH_SHORT).show()
            }
        }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.buttonDesafio1.setOnClickListener {
            intent = Intent(this, DesafioActivity::class.java)
            intent.putExtra("IMAGEM", R.drawable.dezdaltonismo)
            dasafioOneLauncher.launch(intent)
        }
        binding.buttonDesafio2.setOnClickListener {
            intent = Intent(this, DesafioActivity::class.java)
            intent.putExtra("IMAGEM", R.drawable.ciquentasetedaltonismo)
            dasafioTwoLauncher.launch(intent)
        }
        binding.buttonDesafio3.setOnClickListener {
            intent = Intent(this, DesafioActivity::class.java)
            intent.putExtra("IMAGEM", R.drawable.setedaltonismo)
            dasafioThreeLauncher.launch(intent)
        }
        binding.buttonResultado.setOnClickListener {
            val resultadoFinal = respostaDesafio.resultadoDoTeste()
            if (resultadoFinal.equals("Você deixou algum desafio em branco")){
                Toast.makeText(this, respostaDesafio.resultadoDoTeste(), Toast.LENGTH_SHORT).show()
                binding.textViewResultado.text = ""
            }else{
                binding.textViewResultado.text = respostaDesafio.resultadoDoTeste()
            }

        }

    }

    override fun onResume() {
        super.onResume()
        binding.respostaDesafio = respostaDesafio
    }
}
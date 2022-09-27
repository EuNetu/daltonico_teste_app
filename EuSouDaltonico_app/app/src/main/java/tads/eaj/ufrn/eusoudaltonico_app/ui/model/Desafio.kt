package tads.eaj.ufrn.eusoudaltonico_app.ui.model

class Desafio (
    var resposta1:String,
    var resposta2:String,
    var resposta3:String
){
    fun resultadoDoTeste(): String{
        if (this.resposta1.equals("") || this.resposta2.equals("") || this.resposta3.equals("")){
            return "Você deixou algum desafio em branco"
        }
        if(this.resposta1.equals("10") && this.resposta2.equals("57") && this.resposta3.equals("7")){
            return "Você não é daltônico"
        }
        return "Vá a um oftalmologista"
    }
}
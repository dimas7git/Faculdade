package com.example.aulasorte3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //VAMOS CRIAR UM MÉTODO PARA SORTEAR UMA FRASE
    public void sorteiaFrase(View view){
        //CRIAMOS REFERÊNCIA PARA ELEMENTO DA INTERFACE
        TextView txtFrase =  findViewById(R.id.textSorte);
        //VAMOS CRIAR UM VETOR DE FRASES
        String[] frases={
                "A persistência é o caminho do êxito.","Toda ação humana, quer se torne positiva ou negativa, precisa depender de motivação.","No meio da dificuldade encontra-se a oportunidade.","É parte da cura o desejo de ser curado.","O que me preocupa não é o grito dos maus. É o silêncio dos bons.","O sucesso é a soma de pequenos esforços repetidos dia após dia.","A melhor maneira de prever o futuro é criá-lo.","Acredite em si mesmo e tudo será possível.","A persistência realiza o impossível.","Nada é impossível para quem persiste.","O sucesso é a consequência do esforço constante.","A jornada de mil milhas começa com um único passo.","Grandes conquistas exigem tempo e paciência.","A cada obstáculo, uma oportunidade se revela.","A vida é um presente, aproveite-a ao máximo.","O otimismo é a fé que leva à realização.","Nunca é tarde demais para seguir seus sonhos.","O fracasso é apenas uma oportunidade para recomeçar com mais inteligência.","O sucesso é construído sobre a base dos erros e frustrações.","Acredite no seu potencial e siga em frente.","A persistência supera a resistência.","A motivação é o primeiro passo para o sucesso.","Cada novo dia é uma nova chance.","A paciência é a chave para todas as portas do sucesso.","A coragem é a força que o leva adiante.","Seja a mudança que você deseja ver no mundo.","O pensamento positivo abre portas para o sucesso.","Nunca desista, pois a próxima tentativa pode ser a vencedora.","O caminho para o topo começa de baixo.","Acredite em si mesmo, e o resto virá naturalmente."
        };
        //VAMOS CRIAR O CÓDIGO DE SORTEIO COM VALORES ALEATÓRIOS
        int i=new Random().nextInt(30);
        //ADPTAR O CAMPO DE TEXTO PARA MOSTRAR A POSIÇÃO SORTEADA
        String fraseSorteada=frases[i];
        txtFrase.setText(frases[i]);

        //VAMOS CRIAR A REFERÊNCIA PARA O RESULTADO
        EditText txtEntrada = findViewById(R.id.editTextFrase);
        TextView txtRes = findViewById(R.id.textViewResultado);
        //FAZER A VERIFICAÇÃO
        if(fraseSorteada.equalsIgnoreCase(""+txtEntrada.getText())){
            txtFrase.setText("Essa frase já existe!");
        }
        else{
            String[] novoVetorFrases = new String[frases.length + 1];
            for (int j = 0; j < frases.length; j++) {
                novoVetorFrases[j] = frases[j];
            }
            novoVetorFrases[novoVetorFrases.length - 1] = txtEntrada.getText().toString();
            frases = novoVetorFrases;
            txtRes.setText("A frase: '"+txtEntrada.getText()+"' foi adicionado ao nosso banco!");
            txtFrase.setText("Essa frase não existia! Foi adicionado ao nosso banco! Muito obrigado!");
        }
    }


}

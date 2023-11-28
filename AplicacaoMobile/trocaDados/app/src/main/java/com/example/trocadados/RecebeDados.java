package com.example.trocadados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.textclassifier.TextClassification;
import android.widget.TextView;

public class RecebeDados extends AppCompatActivity {

    private TextView txtnome,txtidade;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recebe_dados);

        txtnome=findViewById(R.id.txtNome);
        txtidade=findViewById(R.id.txtIdade);
        //vamos criar duas variaveis intermediarias para receber os valores da primeira activity
        String nome;
        int idade;

        //vamos criar o objeto que recebe os dados
        Bundle dados = getIntent().getExtras();

        // em seguida recebemos a String e o int com o metodo especifico
        nome = dados.getString("nome");
        idade = dados.getInt("idade");

        //agora vamos mostrar os dados recebidos nos respectivos textviews
        txtnome.setText(""+nome);
        txtidade.setText(""+idade);
    }
}

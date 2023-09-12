package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    //vamos criar um método para mudar o texto do textview na interface
    public void trocarTexto(View view) {
        //vamos criar a referência para o campo textview que está na interface
        TextView texto = findViewById(R.id.textViewTexto);
        //após a criação da refêrencia podemos usar o método que escreve um conjunto de caracteres no campo texto
        String textoAtual = texto.getText().toString();
        if (textoAtual.equals("mudei o texto")) {
            texto.setText("Texto Original");
        } else {
            texto.setText("mudei o texto");
        }

    }
}

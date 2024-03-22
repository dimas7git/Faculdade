package com.example.trocadados;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class RecebeDados extends AppCompatActivity {

    private TextView txtNota1,txtNota2,txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recebe_dados);

        txtNota1=findViewById(R.id.txtNota1);
        txtNota2=findViewById(R.id.txtNota2);
        txtResultado=findViewById(R.id.txtResultado);

        int nota1,nota2,peso1,peso2,resultado;


        Bundle dados = getIntent().getExtras();


        nota1 = dados.getInt("nota1");
        nota2 = dados.getInt("nota2");
        peso1 = dados.getInt("peso1");
        peso2= dados.getInt("peso2");

        resultado = ((nota1 * peso1 + nota2 * peso2) / (peso1 + peso2));


        txtNota1.setText(""+nota1);
        txtNota2.setText(""+nota2);
        txtResultado.setText(""+resultado);

    }
}

package com.example.calculartriangulo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Activity3 extends AppCompatActivity {

    private TextView txtResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_3);

        txtResultado=findViewById(R.id.txtResultado);


        int lado1,lado2,lado3;
        String resultado;


        Bundle dados = getIntent().getExtras();


        lado1 = dados.getInt("lado1");
        lado2 = dados.getInt("lado2");
        lado3 = dados.getInt("lado3");

        if ((lado1 == lado2) && (lado2 == lado3)) {
            txtResultado.setText("Os lados formam um triângulo equilátero");
        } else if ((lado1 == lado2) || (lado2 == lado3) || (lado3 == lado1)) {
            txtResultado.setText("Os lados formam um triângulo isósceles");
        } else {
            txtResultado.setText("Os lados formam um triângulo escaleno");
        }

    }
}

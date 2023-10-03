package com.example.ex01;

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
    int pontoMaquina = 0;
    int pontoHumano = 0;



    public void verifica(View view) {

        EditText txtDigitado = findViewById(R.id.editTextNum);
        TextView txtResultado = findViewById(R.id.txtResultadoSorteio);
        TextView txtEscolhaMaquina = findViewById(R.id.txtResultadoMaquina);
        TextView txtPontoHumano = findViewById(R.id.txtPontoHumano);
        TextView txtPontoMaquina = findViewById(R.id.txtPontoMaquina);
        Integer[] numbers = {1, 2, 3, 4, 5, 6};
        int res = new Random().nextInt(numbers.length);
        int maq = new Random().nextInt(numbers.length);
        int escolhaDaMaquina = numbers[maq];
        int numeroSorteado = numbers[res];
        String imprimir = "Número sorteado foi: " + Integer.toString(numeroSorteado);
        String imprimir2 = Integer.toString(escolhaDaMaquina);
        txtResultado.setText(imprimir);
        txtEscolhaMaquina.setText("Número escolhido pela máquina foi: "+ imprimir2);

        String textoDigitadoHumano = txtDigitado.getText().toString();

        int numeroMaquina = escolhaDaMaquina;
        String textoPontoMaquina = txtPontoMaquina.getText().toString();
        String textoPontoHumano = txtPontoHumano.getText().toString();
        int numeroDigitadoHumano = Integer.parseInt(textoDigitadoHumano);


        if (numeroSorteado == numeroDigitadoHumano) {
            pontoHumano += 1;
            txtPontoHumano.setText("VOCÊ\n " + pontoHumano);
        }
            if (numeroSorteado == numeroMaquina) {
                pontoMaquina += 1;
                txtPontoMaquina.setText("MÁQUINA\n " + pontoMaquina);
            }
        }
    }


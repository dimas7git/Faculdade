package com.example.calculartriangulo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Activity2 extends AppCompatActivity {

    private TextView txtResultado;
    private Button btnNext;
    private boolean forma;  // Declare como variável de instância
    int lado1, lado2, lado3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_2);

        txtResultado = findViewById(R.id.txtResultado);
        btnNext = findViewById(R.id.btnPg3);


        Bundle dados = getIntent().getExtras();
            lado1 = dados.getInt("lado1");
            lado2 = dados.getInt("lado2");
            lado3 = dados.getInt("lado3");

            if (((lado1 + lado2) > lado3) && ((lado1 + lado3) > lado2) && ((lado2 + lado3) > lado1)) {
                txtResultado.setText("Sim, os lados formam um triângulo");
                btnNext.setVisibility(View.VISIBLE);
                forma = true;
            } else {
                txtResultado.setText("Não, os lados não formam um triângulo");
                forma = false;
            }

            btnNext.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(getApplicationContext(), Activity3.class);
                    intent.putExtra("lado1", lado1);
                    intent.putExtra("lado2", lado2);
                    intent.putExtra("lado3", lado3);

                    startActivity(intent);
                }
            });
    }
}
/*
    public void chama3 (View view){
       // if (forma) {
                    Intent intent2 = new Intent(getApplicationContext(), Activity3.class);
                    startActivity(intent2);
              //  }
            }/*
        }

*/

package com.example.activity;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

//Vamos criar um objeto para o botão
    private Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //vamos criar a referencia na interface
        button = findViewById(R.id.button);

        //vamos criar a ação que fica "escutando"/esperando alguma ação sobre o elemento
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //vamos criar uma intent para controlar
                //as mudanças de processos, neste caso
                //será aberta uma nova activity
                Intent intent= new Intent(getApplicationContext(), segundActivity.class);
                // entao pedimos para executar
                startActivity(intent);

            }
        });
    }


}

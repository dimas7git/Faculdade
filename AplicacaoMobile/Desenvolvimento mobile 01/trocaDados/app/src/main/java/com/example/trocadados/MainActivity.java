package com.example.trocadados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText txtnota1,txtpeso1,txtnota2, txtpeso2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        txtnota1 = findViewById(R.id.txtNota1);
        txtpeso1 = findViewById(R.id.txtPeso1);
        txtnota2 = findViewById(R.id.txtNota2);
        txtpeso2 = findViewById(R.id.txtPeso2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), RecebeDados.class);

                String Nota1 = txtnota1.getText().toString();
                String Peso1 = txtpeso1.getText().toString();
                String Nota2 = txtnota2.getText().toString();
                String Peso2 = txtpeso2.getText().toString();

                int notaUM = Integer.parseInt(Nota1);
                int pesoUM = Integer.parseInt(Peso1);
                int notaDOIS = Integer.parseInt(Nota2);
                int pesoDOIS = Integer.parseInt(Peso2);


                intent.putExtra("nota1", notaUM);
                intent.putExtra("peso1", pesoUM);
                intent.putExtra("nota2", notaDOIS);
                intent.putExtra("peso2", pesoDOIS);

                startActivity(intent);

            }
        });
    }
}

package com.example.calculartriangulo;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    private Button button;
    private EditText txtlado1,txtlado2,txtlado3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);
        txtlado1 = findViewById(R.id.txtResultado);
        txtlado2 = findViewById(R.id.txtLado2);
        txtlado3 = findViewById(R.id.txtLado3);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Activity2.class);

                String Lado1 = txtlado1.getText().toString();
                String Lado2 = txtlado2.getText().toString();
                String Lado3 = txtlado3.getText().toString();

                int LadoUM = Integer.parseInt(Lado1);
                int LadoDOIS = Integer.parseInt(Lado2);
                int LadoTRES = Integer.parseInt(Lado3);


                intent.putExtra("lado1", LadoUM);
                intent.putExtra("lado2", LadoDOIS);
                intent.putExtra("lado3", LadoTRES);


                startActivity(intent);

            }
        });
    }
}

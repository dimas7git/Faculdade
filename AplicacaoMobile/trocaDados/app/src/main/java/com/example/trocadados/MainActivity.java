package com.example.trocadados;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //vamos chamar a segunda activity
                Intent intent = new Intent(getApplicationContext(), RecebeDados.class);

            //para cada valor a ser enviado, utilizamos o método que envia o nome e idade - putExtra()
                intent.putExtra("nome", "Dimas");
                intent.putExtra("idade", 20);


                startActivity(intent);

            }
        });
    }
}

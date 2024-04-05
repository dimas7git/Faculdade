package com.example.eximobiliaria;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    @Override
    public void onCreate(Bundle estado) {
        super.onCreate(estado);
        setContentView(R.layout.activity_main);

        ImageView btn = findViewById(R.id.seta);

        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                segundaTela();
            }
        });
    }
    private void segundaTela() {
        Intent intent = new Intent(this, Segunda.class);
        startActivity(intent);
    }


}
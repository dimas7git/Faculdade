package com.example.ex_12_04;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.Button;
import android.view.View;
import android.content.Intent;

public class MainActivity extends AppCompatActivity {

    private Button btnNextPage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnNextPage = findViewById(R.id.btnNextPage);

        btnNextPage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View     v) {
                Intent intent = new Intent(getApplicationContext(), Activity2.class);

                startActivity(intent);

            }
        });

    }
}

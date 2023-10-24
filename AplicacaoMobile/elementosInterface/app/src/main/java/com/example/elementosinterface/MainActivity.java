package com.example.elementosinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Vamos as variáveis de forma global
    private EditText  editTextRoupa;
    private TextView  textViewEscolha;
    private TextView TextViewCor;
    private CheckBox checkBoxBranco,checkBoxVerde,checkBoxAzul;
    List<String> checked = new ArrayList<String>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        editTextRoupa = findViewById(R.id.editTextRoupa);
        textViewEscolha = findViewById(R.id.textViewResultado);
        TextViewCor = findViewById(R.id.textViewResultCor);
        checkBoxAzul = findViewById(R.id.cazul);
        checkBoxBranco = findViewById(R.id.cbranco);
        checkBoxVerde = findViewById(R.id.cverde);
    }

    public void changeTextRoupa(View view){
        textViewEscolha.setText(editTextRoupa.getText());
        verificaCheck(view);
    }

    public void verificaCheck(View view){
        checked.clear();
        if(checkBoxVerde.isChecked()){
            checked.add(checkBoxVerde.getText().toString());
        }
        if(checkBoxAzul.isChecked()){
            checked.add(checkBoxAzul.getText().toString());
        }
        if(checkBoxBranco.isChecked()){
          checked.add(checkBoxBranco.getText().toString());
        }
    TextViewCor.setText(checked.toString());
    }
}

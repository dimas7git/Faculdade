package com.example.componentesinterface;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    //Vamos as variáveis de forma global
    private EditText  editTextRoupa;

    private RadioGroup rgTamanho;
    private TextView campoRadio;
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
        campoRadio = findViewById(R.id.txtTamanho);
        rgTamanho = findViewById(R.id.rgTamanho);

        chegarRadioButton();
    }

    public void changeTextRoupa(View view){
        textViewEscolha.setText(editTextRoupa.getText());
        verificaCheck(view);
        chegarRadioButton();
    }

    public void chegarRadioButton(){
        rgTamanho.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup radioGroup, int checkedId) {
                if(checkedId == R.id.rbGrande){
                    campoRadio.setText("Grande");
                } else if(checkedId == R.id.rbMedio){
                    campoRadio.setText("Médio");
                }else if(checkedId == R.id.rbPequeno){
                    campoRadio.setText("Pequeno");
                }
            }
        });
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

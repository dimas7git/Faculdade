package com.example.atvd_28;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;


public class Add extends Activity {

    private EditText edtNome;
    private EditText edtDia;
    private Disciplina disciplina;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adiciona);

        edtNome = (EditText)findViewById(R.id.campoNome);
        edtDia = (EditText)findViewById(R.id.campoDia);

        Intent intent = getIntent();
        disciplina = (Disciplina)intent.getSerializableExtra("disciplina");

        if (disciplina != null) {
            edtNome.setText(disciplina.nome);
            edtDia.setText(disciplina.dia);
        }

        Button btnSalvar = (Button)findViewById(R.id.botao);
        btnSalvar.setOnClickListener(new View.OnClickListener() {
            @Override

            public void onClick(View v) {
                salvar();

            }
        });
    }

    public void salvar() {
        // Intent i = new Intent(this, MainActivity.class);
        //startActivityForResult(i, 1);

        Banco bd = new Banco(this);
        bd.abrir();
        setResult(MainActivity.REQUEST_SALVOU);

        if (disciplina != null) {
            bd.atualizaEvento(disciplina.id,
                    edtNome.getText().toString(),
                    edtDia.getText().toString());
        } else {
            bd.insereEvento(
                    edtNome.getText().toString(),
                    edtDia.getText().toString());
        }

        bd.fechar();
        // Intent intent = new Intent();
        //intent.putExtra("key", "value");
        finish();
    }



}
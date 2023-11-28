package com.example.gravidaderelativa;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private RadioButton btnMercurio, btnVenus, btnMarte, btnJupiter, btnSaturno, btnUrano;
    private EditText txtPeso;
    private TextView txtResul;
    private ImageView imagem;
    private ToggleButton ativar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btnMercurio = findViewById(R.id.btnMercurio);
        btnVenus = findViewById(R.id.btnVenus);
        btnMarte = findViewById(R.id.btnMarte);
        btnJupiter = findViewById(R.id.btnJupiter);
        btnSaturno = findViewById(R.id.btnSaturno);
        btnUrano = findViewById(R.id.btnUrano);
        txtPeso = findViewById(R.id.txtPeso);
        txtResul = findViewById(R.id.txtResul);
        imagem = findViewById(R.id.imageButton);
        ativar = findViewById(R.id.tbAtivar);
    }


    public void ativar(View view){
        if(ativar.getText().equals("ON")){
            txtPeso.setEnabled(true);
        } else{
            txtPeso.setEnabled(false);
        }

    }

    public void calcGravidade(View view){
        double peso = Double.parseDouble(txtPeso.getText().toString());
        if(btnMercurio.isChecked()){
            txtResul.setText("Seu peso neste planeta é: " + peso*0.37) ;
            imagem.setImageResource(R.drawable.mercurio);
        }else if(btnVenus.isChecked()){
            txtResul.setText("Seu peso neste planeta é: " + peso*0.88) ;
            imagem.setImageResource(R.drawable.venus);
        } else if(btnMarte.isChecked()){
            txtResul.setText("Seu peso neste planeta é:     " + peso*0.38) ;
            imagem.setImageResource(R.drawable.marte);
        } else if(btnJupiter.isChecked()){
            txtResul.setText("Seu peso neste planeta é: " + peso*2.64) ;
            imagem.setImageResource(R.drawable.jupiter);
        } else if(btnSaturno.isChecked()){
            txtResul.setText("Seu peso neste planeta é: " + peso*1.15) ;
            imagem.setImageResource(R.drawable.saturno);
        } else if(btnUrano.isChecked()){
            txtResul.setText("Seu peso neste planeta é: " + peso*1.17) ;
            imagem.setImageResource(R.drawable.urano);
        }

        btnMercurio.setChecked(false);
        btnUrano.setChecked(false);
        btnSaturno.setChecked(false);
        btnJupiter.setChecked(false);
        btnMarte.setChecked(false);
        btnVenus.setChecked(false);

    }
}

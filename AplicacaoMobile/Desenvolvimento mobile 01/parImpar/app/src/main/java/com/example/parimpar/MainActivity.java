package com.example.parimpar;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MainActivity extends AppCompatActivity {
    private String escolhaUsuarioImparPar;
    private int escolhaUsuario=0, vitoriasMAquina=0, vitoriasUsuario=0, jogos=0;
    private List<ImageView> imageViews = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        imageViews.add((ImageView) findViewById(R.id.imgum));
        imageViews.add((ImageView) findViewById(R.id.imgdois));
        imageViews.add((ImageView) findViewById(R.id.imgtres));
        imageViews.add((ImageView) findViewById(R.id.imgquatro));
        imageViews.add((ImageView) findViewById(R.id.imgcinco));
    }

    public void selecionarDedo(View view) {
        int id = view.getId();
        switch (id) {
            case R.id.imgum:
                this.escolhaUsuario = 1;
                break;
            case R.id.imgdois:
                this.escolhaUsuario = 2;
                break;
            case R.id.imgtres:
                this.escolhaUsuario = 3;
                break;
            case R.id.imgquatro:
                this.escolhaUsuario = 4;
                break;
            case R.id.imgcinco:
                this.escolhaUsuario = 5;
                break;
        }
    }

    public void par(View view){
        this.escolhaUsuarioImparPar = "Par";
        calc(view);
    }
    public void impar(View view){
        this.escolhaUsuarioImparPar = "Impar";
        calc(view);
    }
    public void calc(View view){
        TextView txtEscolhaMaquina = findViewById(R.id.txtEscolhaMaquina);
        TextView txtEscolhaUsuario = findViewById(R.id.txtEscolharHumano);
        TextView txtResul = findViewById(R.id.txtResul);
        int i =new Random().nextInt(5);
        txtEscolhaMaquina.setText("Escolha maquina: \n" + i);
        txtEscolhaUsuario.setText("Escolha usuario: \n" + escolhaUsuario);
        int soma = escolhaUsuario + i;

        int resul = soma % 2;

        if ((resul == 0 && this.escolhaUsuarioImparPar.equalsIgnoreCase("Par")) || (resul == 1 && this.escolhaUsuarioImparPar.equalsIgnoreCase("Impar"))) {
            txtResul.setText("Úsuario ganhou");
            txtResul.setTextColor(Color.GREEN);
            vitoriasUsuario++;
        } else {
            txtResul.setText("Úsuario perdeu");
            txtResul.setTextColor(Color.RED);
            vitoriasMAquina++;
        }

        jogos++;
        if (jogos == 5) {
            TextView txtResultadoFinal = findViewById(R.id.txtResul);
            Button btnimpar = findViewById(R.id.btnImpar);
            Button btnpar = findViewById(R.id.btnPar);
            TextView escolha = findViewById(R.id.textView2);
            txtResul.setTextColor(Color.BLACK);
            txtResultadoFinal.setText("Resultado final:\n Usuário " + vitoriasUsuario + " x " + vitoriasMAquina + " Máquina");
            for (ImageView imageView : imageViews) {
                ViewGroup.LayoutParams params = imageView.getLayoutParams();
                params.height = 0;
                params.width = 0;
                imageView.setLayoutParams(params);
            }
            escolha.setVisibility(View.INVISIBLE);
            btnimpar.setVisibility(View.INVISIBLE);
            btnpar.setVisibility(View.INVISIBLE);
        }
    }
}

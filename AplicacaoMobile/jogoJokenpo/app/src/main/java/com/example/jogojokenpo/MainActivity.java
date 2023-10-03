package com.example.jogojokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;


public class MainActivity extends AppCompatActivity {

    //Vamos criar duas variáveis globlais
    private String escolhaSmart, escolhaUsuario;
    private int  pontoMaquina, pontoHumano;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void escolhePedra(View view){
        this.escolhaUsuario = "pedra";
        ImageView imgUsuario = findViewById(R.id.imageViewUsuario);
        imgUsuario.setImageResource(R.drawable.pedra);
        sortear(view);
        resultado(view);
    }
    public void escolhePapel(View view){
        this.escolhaUsuario = "papel";
        ImageView imgUsuario = findViewById(R.id.imageViewUsuario);
        imgUsuario.setImageResource(R.drawable.papel);
        sortear(view);
        resultado(view);
    }
    public void escolheTesoura(View view){
        this.escolhaUsuario = "tesoura";
        ImageView imgUsuario = findViewById(R.id.imageViewUsuario);
        imgUsuario.setImageResource(R.drawable.tesoura);
        sortear(view);
        resultado(view);
    }

    public void resultado(View view){
        TextView txtResult = findViewById(R.id.textView4);
        TextView txtPontoHumano = findViewById(R.id.textViewpontoHumano);
        TextView txtPontoMaquina = findViewById(R.id.textViewpontomaquina);
        if(escolhaUsuario.equals("pedra") && escolhaSmart.equals("papel")){
            txtResult.setText("Você perdeu");
             txtResult.setTextColor(Color.parseColor("#FF0000"));
            pontoMaquina++;
            txtPontoMaquina.setText("MÁQUINA\n " + pontoMaquina);
        }else if(escolhaUsuario.equals("papel") && escolhaSmart.equals("tesoura")){
            txtResult.setText("Você perdeu");
              txtResult.setTextColor(Color.parseColor("#FF0000"));
            pontoMaquina++;
            txtPontoMaquina.setText("MÁQUINA\n " + pontoMaquina);
        }else if(escolhaUsuario.equals("tesoura") && escolhaSmart.equals("pedra")){
            txtResult.setText("Você perdeu");
            txtResult.setTextColor(Color.parseColor("#FF0000"));
            pontoMaquina++;
            txtPontoMaquina.setText("MÁQUINA\n " + pontoMaquina);
        }else if(escolhaUsuario.equals(escolhaSmart)) {
            txtResult.setText("Empate");
            txtResult.setTextColor(Color.parseColor("#000000"));
        }else{
            txtResult.setText("Você ganhou");
            txtResult.setTextColor(Color.parseColor("#008000"));
            pontoHumano++;
            txtPontoHumano.setText("VOCÊ\n " + pontoHumano);
        }
    }

    public void sortear(View view) {
        ImageView imgSmart = findViewById(R.id.imageViewSmart);
        int i=new Random().nextInt(3);
        if(i==0){
            imgSmart.setImageResource(R.drawable.pedra);
            this.escolhaSmart="pedra";
        }else if(i==1){
            imgSmart.setImageResource(R.drawable.papel);
            this.escolhaSmart="papel";
        }
        else if(i==2){
            imgSmart.setImageResource(R.drawable.tesoura);
            this.escolhaSmart="tesoura";
        }
    }
}

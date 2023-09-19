package com.example.ex02_soma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelStoreOwner;

import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void somar(View view){
        TextView resultado = findViewById(R.id.resultado);
        EditText numero1 = findViewById(R.id.editText);
        EditText numero2 = findViewById(R.id.editText2);
        //vamos criar variavies numericas para receber o valor convertido da String
        double n1,n2,res;
        n1=Integer.parseInt(numero1.getText().toString());
        n2=Integer.parseInt(numero2.getText().toString());
        res = n1+n2;
        resultado.setText(""+res);
    }
    public void dividir(View view){
        TextView resultado = findViewById(R.id.resultado);
        EditText numero1 = findViewById(R.id.editText);
        EditText numero2 = findViewById(R.id.editText2);
        //vamos criar variavies numericas para receber o valor convertido da String
        double n1,n2,res;
        n1=Integer.parseInt(numero1.getText().toString());
        n2=Integer.parseInt(numero2.getText().toString());
        res = n1/n2;
        resultado.setText(""+res);
    }
    public void subtrair(View view){
        TextView resultado = findViewById(R.id.resultado);
        EditText numero1 = findViewById(R.id.editText);
        EditText numero2 = findViewById(R.id.editText2);
        //vamos criar variavies numericas para receber o valor convertido da String
        double n1,n2,res;
        n1=Integer.parseInt(numero1.getText().toString());
        n2=Integer.parseInt(numero2.getText().toString());
        res = n1-n2;
        resultado.setText(""+res);
    }
    public void multiplicar(View view){
        TextView resultado = findViewById(R.id.resultado);
        EditText numero1 = findViewById(R.id.editText);
        EditText numero2 = findViewById(R.id.editText2);
        //vamos criar variavies numericas para receber o valor convertido da String
        double n1,n2,res;
        n1=Integer.parseInt(numero1.getText().toString());
        n2=Integer.parseInt(numero2.getText().toString());
        res = n1*n2;
        resultado.setText(""+res);
    }
}

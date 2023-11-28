package com.example.calcularimc;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private EditText editTextAltura, editTextPeso;
    private TextView textViewResultado, textViewPesoIdeal;
    private ImageView imageView2;
    private Switch switchAtivar, switchSexo;
    private Button buttonCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editTextAltura = findViewById(R.id.editTextAltura);
        editTextPeso = findViewById(R.id.editTextPeso);
        textViewResultado = findViewById(R.id.textViewResultado);
        textViewPesoIdeal = findViewById(R.id.textViewPesoIdeal);
        imageView2 = findViewById(R.id.imageView2);
        switchAtivar = findViewById(R.id.switchAtivar);
        switchSexo = findViewById(R.id.switchSexo);
        buttonCalcular = findViewById(R.id.buttonCalcular);

        // Inicialmente, desabilita os campos de entrada
        setCamposHabilitados(false);

        switchAtivar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setCamposHabilitados(switchAtivar.isChecked());
            }
        });

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularIMC();
            }
        });
    }

    private void setCamposHabilitados(boolean habilitado) {
        editTextAltura.setEnabled(habilitado);
        editTextPeso.setEnabled(habilitado);
    }

    private void calcularIMC() {
        // Obtém os valores inseridos pelo usuário
        double altura = Double.parseDouble(editTextAltura.getText().toString());
        double peso = Double.parseDouble(editTextPeso.getText().toString());

        // Calcula o IMC de acordo com o sexo
        double imc;
        double pesoIdeal;
        if (switchSexo.isChecked()) {
            imc = peso / (altura * altura);
            pesoIdeal = (72.7 * altura) - 58;
        } else {
            imc = peso / (altura * altura);
            pesoIdeal = (62.1 * altura) - 44.7;
        }
        if (switchSexo.isChecked()) {
            imageView2.setImageResource(R.drawable.homem);
        } else {
            // Mulher selecionada
            imageView2.setImageResource(R.drawable.mulher);
        }

// Exibe os resultados
        textViewResultado.setText("Seu IMC é: " + String.format("%.2f", imc));

// Verifica o estado de saúde com base no IMC
        String estadoSaude = obterEstadoSaude(imc);
        textViewResultado.append("\nEstado de Saúde: " + estadoSaude);

// Exibe o peso ideal
        textViewPesoIdeal.setText("Peso Ideal: " + String.format("%.2f", pesoIdeal) + " kg");


        // Exibe a imagem correspondente ao sexo
        //imageViewSexo.setImageResource(switchSexo.isChecked() ? R.drawable.feminino : R.drawable.masculino);
    }

    private String obterEstadoSaude(double imc) {
        if (imc < 18.5) {
            return "Abaixo do Peso";
        } else if (imc >= 18.5 && imc < 24.9) {
            return "Peso Normal";
        } else if (imc >= 25 && imc < 29.9) {
            return "Sobrepeso";
        } else if (imc >= 30 && imc < 34.9) {
            return "Obesidade Grau I";
        } else if (imc >= 35 && imc < 39.9) {
            return "Obesidade Grau II";
        } else {
            return "Obesidade Grau III";
        }
    }
}
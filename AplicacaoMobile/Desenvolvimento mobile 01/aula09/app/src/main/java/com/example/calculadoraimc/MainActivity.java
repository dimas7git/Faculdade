package com.example.calculadoraimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.ToggleButton;

public class MainActivity extends AppCompatActivity {

    private TextView txtResultadoToogle, getTxtResultadoSwitch, txtResultadoCheck;
    private ToggleButton toggleButton;
    private Switch switch1;

    private CheckBox checkBoxAtivar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        toggleButton = findViewById(R.id.toggleButton);
        switch1 = findViewById(R.id.switch1);
        txtResultadoToogle = findViewById(R.id.txtResultToogle);
        getTxtResultadoSwitch = findViewById(R.id.txtResultSwitch);
    }

    public void verifica(View v){
        if(switch1.isChecked()){
            getTxtResultadoSwitch.setText("Ligado");
        }else {
            getTxtResultadoSwitch.setText("Desligado");
        }
        if(toggleButton.isChecked()){
            txtResultadoToogle.setText("Toggle ligado");
        }else {
            txtResultadoToogle.setText("Toggle desligado");
        }
        if(toggleButton.isChecked()){
            txtResultadoCheck.setText("Checkbox ligado");
        }else {
            txtResultadoCheck.setText("Checkbox desligado");
        }
    }
}
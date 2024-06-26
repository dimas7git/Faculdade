package com.example.atvd19_04;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;
import android.app.ListActivity;

public class Meses extends Activity {

    String[] meses = {
            "Janeiro", "Fevereiro", "Março",
            "Abril", "Maio", "Junho",
            "Julho",
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.act_meses);


        ArrayAdapter<String> arrayMeses = new ArrayAdapter<>(
                this, android.R.layout.simple_list_item_1, meses
        );

        ListView listaMeses = (ListView)findViewById(R.id.listaMeses);

        listaMeses.setAdapter(arrayMeses);


        voltar tp = new voltar();
        tp.setSaida(this);

        Button bt3;
        bt3 = (Button)findViewById(R.id.btnVoltar);
        bt3.setOnClickListener(tp);

        listaMeses.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String itemSelecionado = meses[position];
                Toast.makeText(getApplicationContext(), itemSelecionado, Toast.LENGTH_SHORT).show();
            }
        });

    }

}
class voltar implements View.OnClickListener {

    private Meses saida;

    @Override
    public void onClick(View v) {
        Intent i = new Intent(saida, MainActivity.class);
        saida.startActivity(i);
    }

    public void setSaida(Meses p2) {
        saida = p2;
    }
}
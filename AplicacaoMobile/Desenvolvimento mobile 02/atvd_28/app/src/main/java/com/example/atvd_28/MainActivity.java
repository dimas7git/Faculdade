package com.example.atvd_28;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends Activity {



    private Banco bd;
    private List<Disciplina> disciplinas = new ArrayList<Disciplina>();
    private DisciplinaAdapter adaptadorDisciplina;
    public static final int REQUEST_EDICAO = 0;
    public static final int REQUEST_SALVOU = 1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        abreAdd t1 = new abreAdd();
        t1.setSaida(this);

        Button bt1;
        bt1 = (Button)findViewById(R.id.btnAdd);
        bt1.setOnClickListener(t1);

        //Botao para Abrir os meses
        abreMeses t2 = new abreMeses();
        t2.setSaida(this);

        Button bt2;
        bt2 = (Button)findViewById(R.id.btnMeses);
        bt2.setOnClickListener(t2);

        bd = new Banco(this);
        lerDados();
    }

    class abreAdd implements View.OnClickListener {

        private MainActivity saida;

        @Override
        public void onClick(View v) {
            Intent i = new Intent(saida, Add.class);
            saida.startActivityForResult(i,0);
        }

        public void setSaida(MainActivity p) {
            saida = p;
        }
    }

    //classe para abrir a interface de ver Meses
    class abreMeses implements View.OnClickListener {

        private MainActivity saida;

        @Override
        public void onClick(View v) {
            Intent i = new Intent(saida, Meses.class);
            saida.startActivity(i);
        }

        public void setSaida(MainActivity p2) {
            saida = p2;
        }
    }

    public void lerDados() {
        bd.abrir();
        disciplinas.clear();

        Cursor cursor = bd.retornaTodosEventos();
        if (cursor.moveToFirst()) {
            do {
                Disciplina d = new Disciplina();
                d.id = cursor.getColumnIndex(Banco.KEY_ID);
                d.nome = String.valueOf(cursor.getColumnIndex(Banco.KEY_NOME));
                d.dia = String.valueOf(cursor.getColumnIndex(Banco.KEY_DIA));

                disciplinas.add(d);
            } while (cursor.moveToNext());
        }
        cursor.close();

        bd.fechar();

        if (adaptadorDisciplina == null) {
            adaptadorDisciplina = new DisciplinaAdapter(this, disciplinas) {
                @Override
                public void edita(Disciplina disciplina) {
                    Intent intent = new Intent(getApplicationContext(), Add.class);
                    intent.putExtra("disciplina", disciplina);
                    startActivityForResult(intent, REQUEST_EDICAO);
                }

                @Override
                public void deleta(Disciplina disciplina) {
                    bd.abrir();
                    bd.apagaEvento(disciplina.id);
                    bd.fechar();
                    lerDados();
                }
            };

            ListView lista = (ListView)findViewById(R.id.listaDisciplinas);
            lista.setAdapter(adaptadorDisciplina);
        } else {
            adaptadorDisciplina.novosDados(disciplinas);
            adaptadorDisciplina.notifyDataSetChanged();  // Notifica o adaptador sobre os novos dados
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.item_disciplina, menu);
        return true;
    }

    @Override
    public boolean onMenuItemSelected(int featureId, MenuItem item) {

        if (item.getItemId() == R.id.menu_add) {
            //Toast.makeText(this, "teste", Toast.LENGTH_LONG).show();
            Intent intent = new Intent (this, Add.class);
            startActivityForResult(intent, REQUEST_EDICAO);
            return true;
        } else {
            return super.onMenuItemSelected(featureId, item);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == REQUEST_EDICAO) {
            if (resultCode == REQUEST_SALVOU) {
                lerDados();
            }
        }
    }


}
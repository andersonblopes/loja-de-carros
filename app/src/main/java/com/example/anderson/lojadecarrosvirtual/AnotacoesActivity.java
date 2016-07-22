package com.example.anderson.lojadecarrosvirtual;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

import java.util.ArrayList;

public class AnotacoesActivity extends AppCompatActivity {

    Button btNovaCompra;
    EditText etNota;
    Button btAnotar;
    ListView lvAnotacoes;

    private ArrayList<String> notas = new ArrayList<String>();
    ArrayAdapter<String> adapter = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anotacoes);

        btNovaCompra = (Button) findViewById(R.id.btNovaCompra);

        etNota = (EditText) findViewById(R.id.etNota);
        btAnotar = (Button) findViewById(R.id.btAnotar);
        lvAnotacoes = (ListView) findViewById(R.id.lvAnotacoes);

        adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1, notas);
        lvAnotacoes.setAdapter(adapter);

        btAnotar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String textoNota = etNota.getText().toString();
                if(textoNota.length() > 0){
                    etNota.setText("");
                    etNota.findFocus();
                    notas.add(textoNota);
                    adapter.notifyDataSetChanged();
                }
            }
        });

        lvAnotacoes.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder alerta = new AlertDialog.Builder(AnotacoesActivity.this);
                alerta.setTitle("Nota");
                alerta.setMessage("Você deseja apagar esta nota?");
                final int positionToRemove = position;
                alerta.setNegativeButton("Não", null);
                alerta.setPositiveButton("Sim", new AlertDialog.OnClickListener(){
                    public void onClick(DialogInterface dialog, int wich){
                        notas.remove(positionToRemove);
                        adapter.notifyDataSetChanged();
                    }
                });
                alerta.show();
            }
        });


        btNovaCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                novaCompra();
            }
        });
    }

    void novaCompra() {
        Intent intent = new Intent();
        intent.setClass(AnotacoesActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

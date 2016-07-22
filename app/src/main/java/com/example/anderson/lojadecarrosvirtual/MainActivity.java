package com.example.anderson.lojadecarrosvirtual;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Vibrator;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

public class MainActivity extends AppCompatActivity {

    Button btCpr, btAnotacoes;
    CheckBox cbHb20, cbIx35, cbElantra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btCpr = (Button) findViewById(R.id.btComprar);
        btAnotacoes = (Button) findViewById(R.id.btAnotacoes);
        cbHb20 = (CheckBox) findViewById(R.id.cbHb20);
        cbIx35 = (CheckBox) findViewById(R.id.cbIx35);
        cbElantra = (CheckBox) findViewById(R.id.cbElantra);

        btCpr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float total = 0;
                String msg = "Você comprou os seguintes carros: \n\n";
                if (cbHb20.isChecked()) {
                    msg += "HB20\n";
                    total += 41.695;
                }
                if (cbIx35.isChecked()) {
                    msg += "Ix25\n";
                    total += 80.000;
                }
                if (cbElantra.isChecked()) {
                    msg += "Elantra\n";
                    total += 95.000;
                }

                if (total > 0) {
                    msg += "\nTotal a pagar: R$ " + total;
                    Vibrator vb = (Vibrator) getSystemService(Context.VIBRATOR_SERVICE);
                    vb.vibrate(100);
                    finalizaCompra();

                } else {
                    msg = "Selecione pelo menos um carro para efetuar a compra!!!";
                }

                /*
                AlertDialog.Builder alertDialog = new AlertDialog.Builder(MainActivity.this);
                alertDialog.setMessage(msg);
                alertDialog.show();
                */
            }
        });

        btAnotacoes.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent();
                intent.setClass(MainActivity.this, AnotacoesActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    void finalizaCompra() {
        Intent intent = new Intent();
        intent.setClass(MainActivity.this, FinalizaCompraActivity.class);
        startActivity(intent);
        finish();
    }
}

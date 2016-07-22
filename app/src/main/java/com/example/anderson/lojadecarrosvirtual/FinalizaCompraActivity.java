package com.example.anderson.lojadecarrosvirtual;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

public class FinalizaCompraActivity extends AppCompatActivity {

    Button btNovaCompra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_finaliza_compra);

        btNovaCompra = (Button) findViewById(R.id.btNovaCompra);

        btNovaCompra.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                novaCompra();
            }
        });

    }

    void novaCompra() {
        Intent intent = new Intent();
        intent.setClass(FinalizaCompraActivity.this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}

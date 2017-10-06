package com.example.transeguro.transeguroapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class Historial extends AppCompatActivity {
Button btn_hquejas, btn_hsugerencias;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        btn_hquejas = (Button)findViewById(R.id.btn_hquejas);
        btn_hsugerencias = (Button)findViewById(R.id.btn_hsugerencias);

        btn_hquejas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),hquejas.class);
                startActivity(i);
            }
        });

        btn_hsugerencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),hsugerencias.class);
                startActivity(i);
            }
        });
    }
}

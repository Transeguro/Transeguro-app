package com.example.transeguro.transeguroapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;

public class foro extends AppCompatActivity {

    ImageButton ib_acerca, ib_rutas, ib_conductores,imagelista, ib_otras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_foro);

        ib_acerca=(ImageButton)findViewById(R.id.ib_acerca);
        ib_acerca.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),datos_empresa.class);
                startActivity(i);
            }
        });

        ib_rutas=(ImageButton)findViewById(R.id.ib_rutas);
        ib_rutas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),rutas.class);
                startActivity(i);
            }
        });

        ib_conductores=(ImageButton)findViewById(R.id.ib_conductores);
        ib_conductores.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),lista_conductores.class);
                startActivity(i);
            }
        });

        ib_otras=(ImageButton)findViewById(R.id.ib_otras);
        ib_otras.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),lista_sugerencias.class);
                startActivity(i);
            }
        });

    }
}

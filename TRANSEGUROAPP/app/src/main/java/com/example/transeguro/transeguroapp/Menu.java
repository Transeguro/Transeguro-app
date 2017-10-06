package com.example.transeguro.transeguroapp;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageButton;
import android.widget.Toast;

import at.markushi.ui.CircleButton;

public class Menu extends AppCompatActivity {
CircleButton btn;
    ImageButton ib_foro, ib_historial, ib_sugerencias, ib_quejas;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ib_foro=(ImageButton)findViewById(R.id.ib_foro);
        ib_foro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),foro.class);
                startActivity(i);
            }
        });

        ib_historial=(ImageButton)findViewById(R.id.ib_historial);
        ib_historial.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),Historial.class);
                startActivity(i);
            }
        });

        ib_sugerencias=(ImageButton)findViewById(R.id.ib_sugerencias);
        ib_sugerencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),registrar_sugerencias.class);
                startActivity(i);
            }
        });

        ib_quejas=(ImageButton)findViewById(R.id.ib_quejas);
        ib_quejas.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i=new Intent(getApplicationContext(),registro_quejas.class);
                startActivity(i);
            }
        });


       //BOTON DE PERFIL
        btn=(CircleButton)findViewById(R.id.circleButton);
        btn.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick (View v){
//cambiar el login por la clase de perfil cuando lo haga
                showOptions();
            }

        });

    }


    private void showOptions() {
        final CharSequence[] option = {"Editar Perfil","Cerrar sesión"};
        final AlertDialog.Builder builder = new AlertDialog.Builder(Menu.this);
        builder.setTitle("Elige una opción");
        builder.setItems(option, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(option[which] == "Editar Perfil"){
                    Intent i=new Intent(getApplicationContext(),perfil.class);
                    startActivity(i);
                }else if(option[which] == "Cerrar sesión"){
                    Intent i=new Intent(getApplicationContext(),Login.class);
                    startActivity(i);
                }else {
                    Intent intent = new Intent(Intent.ACTION_MAIN);
                    intent.addCategory(Intent.CATEGORY_HOME);
                    intent.setFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
                    startActivity(intent);
                }
            }
        });

        builder.show();
    }


}
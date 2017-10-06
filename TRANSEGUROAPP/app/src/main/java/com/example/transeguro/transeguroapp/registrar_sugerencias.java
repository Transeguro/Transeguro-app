package com.example.transeguro.transeguroapp;

import android.content.Intent;
import android.database.SQLException;
import android.support.annotation.IdRes;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.*;

import com.ms.square.android.expandabletextview.ExpandableTextView;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ExpandableListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public class registrar_sugerencias extends AppCompatActivity {


Button btn_registrar_sugerencias;


    private ExpandableListView listView;
    private ExpandableListAdapter listAdapter;
    private List<String> listDataHeader;
    private HashMap<String, List<String>> listHash;

    Spinner spinnerCategoria;
    String[] Categorias = new String[]{"Conductores", "Vehiculos"};
    ArrayAdapter<String> Categoria;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_sugerencias);


        btn_registrar_sugerencias = (Button)findViewById(R.id.btn_registrar_sugerencias);

        btn_registrar_sugerencias.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Sugerencia registrada correctamente",
                        Toast.LENGTH_SHORT).show();
                Intent i= new Intent(getApplicationContext(),Menu.class);
                startActivity(i);
            }
        });


        spinnerCategoria= (Spinner) findViewById(R.id.spinnerCategoria1);
        Categoria = new ArrayAdapter<String>
                (this, android.R.layout.simple_spinner_item, Categorias);
        spinnerCategoria.setAdapter(Categoria);

        listView = (ExpandableListView) findViewById(R.id.lvExp1);
        initData();
        listAdapter = new ExpandableListAdapter(this, listDataHeader, listHash);
        listView.setAdapter(listAdapter);


    }
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        Toast.makeText(getBaseContext(), parent.getItemAtPosition(position)+ "is selected",Toast.LENGTH_SHORT).show();
        view.setSelected(true);
    }

    private void initData() {
        listDataHeader = new ArrayList<>();
        listHash = new HashMap<>();

        listDataHeader.add("Conductores");
        listDataHeader.add("Vehículos");

        List<String> Conductores = new ArrayList<>();
        Conductores.add("Acosta Canto Tomás José");
        Conductores.add("Briseño Arias Abe");
        Conductores.add("Castro Heredia Felizardo");
        Conductores.add("Erazo Bernal Carlos Luis");
        Conductores.add("Flores Cruz Jaime");

        List<String> Vehículos = new ArrayList<>();
        Vehículos.add("Micro A");
        Vehículos.add("Micro B");
        Vehículos.add("Micro C");
        Vehículos.add("Micro D");
        Vehículos.add("Micro E");
        listHash.put(listDataHeader.get(0), Conductores);
        listHash.put(listDataHeader.get(1), Vehículos);

    }

}


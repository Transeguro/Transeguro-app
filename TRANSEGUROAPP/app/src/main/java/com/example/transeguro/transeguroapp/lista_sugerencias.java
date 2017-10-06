package com.example.transeguro.transeguroapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;


public class lista_sugerencias extends AppCompatActivity {

    ListView lst;
    String[] Asunto ={"Mejor atención", "Cuidado con los transeuntes", "Evaluación a los conductores","Felicitaciones","Sugerencias para web","Personas mayores ayuda"};
    String[] desc={"Atiendame mejor por favor conductores malos", "Casi me atropellan, que horror","En mi opinion el conductor era muy irrespetuoso", "Estoy muy contenta con su servicio","Tienen pagina web o no?","Debe haber una mejor ayuda por parte de los conductores"};
    String[] Categoria ={"Conductor", "Vehiculo","Conductor","Vehiculo","Conductor","Vehiculo"};
    Integer [] imgid={R.mipmap.ic_sugeren, R.mipmap.ic_sugeren,R.mipmap.ic_sugeren,R.mipmap.ic_sugeren,R.mipmap.ic_sugeren,R.mipmap.ic_sugeren };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_sugerencias);


        lst= (ListView)findViewById(R.id.listview2);
        CustomListview2 customListview2=new CustomListview2(this,Asunto,desc,Categoria,imgid);
        lst.setAdapter(customListview2);

    }
}

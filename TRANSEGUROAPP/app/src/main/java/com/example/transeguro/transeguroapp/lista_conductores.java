package com.example.transeguro.transeguroapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;

public class lista_conductores extends AppCompatActivity {
ListView lst;
    String[] Conductores ={"Acosta Canto Rodrigo Jaime"," Perez Espinosa Tomás José", "Briseño Arias Abe","Castro Heredia Felizardo","Erazo Bernal Carlos Luis","Flores Cruz Jaime"};
    String[] desc={"E07847105", "A42324534","A43456343", "E42324545", "G23424544","R45665432"};
    String[] Clase ={"AI", "AI","AI","AI","AI","AI"};
    String[] FechaExpedicion ={"20/09/2017","10/05/2017","01/05/2008","06/03/2010","31/02/2015","20/08/2013"};
    String[] FechaRevalidacion ={"20/09/2024","10/05/2024","01/11/2017","06/03/2018","31/02/20122","20/08/2020"};
    Integer [] imgid={R.drawable.ic_person, R.drawable.ic_person,R.drawable.ic_person,R.drawable.ic_person,R.drawable.ic_person,R.drawable.ic_person };



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_conductores);


        lst= (ListView)findViewById(R.id.listview);
CustomListview customListview=new CustomListview(this,Conductores,desc,Clase,FechaExpedicion, FechaRevalidacion,imgid);
        lst.setAdapter(customListview);

    }
}

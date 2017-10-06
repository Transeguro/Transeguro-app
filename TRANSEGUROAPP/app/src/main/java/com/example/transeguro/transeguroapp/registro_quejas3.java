package com.example.transeguro.transeguroapp;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class registro_quejas3 extends AppCompatActivity {
Button btnregistrarqueja;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro_quejas3);

        btnregistrarqueja =(Button)findViewById(R.id.btnregistrarqueja);
        btnregistrarqueja.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(getApplicationContext(),"Su queja ha sido registrada",
                        Toast.LENGTH_SHORT).show();
                Intent i= new Intent(getApplicationContext(),Menu.class);
                startActivity(i);
            }
        });

    }
}

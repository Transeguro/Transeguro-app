package com.example.transeguro.transeguroapp;

import android.content.Intent;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.ViewSwitcher;

public class rutas extends AppCompatActivity {
    private ImageSwitcher sw;
    private Button pr,nx;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rutas);
        sw = (ImageSwitcher) findViewById(R.id.imgsw);
        pr = (Button) findViewById(R.id.pr);
        nx = (Button) findViewById(R.id.nx);
        sw.setFactory(new ViewSwitcher.ViewFactory() {
            @Override
            public View makeView() {
                ImageView imageView = new ImageView(getApplicationContext());
                imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
                return imageView;
            }
        });

        pr.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                sw.setImageResource(R.drawable.rutab);

            }
        });

        nx.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v){
                sw.setImageResource(R.drawable.rutac);

            }
        });



    }
}

package com.example.transeguro.transeguroapp;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.IdRes;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Christip on 01/10/2017.
 */

public class CustomListview2  extends ArrayAdapter<String>{

    private String [] Asunto;
    private String[] desc;
    private String[] Categoria;
    private Integer[] imgid;
    private Activity context;

    public CustomListview2(Activity context, String [] Asunto ,String[] desc,String[] Categoria,Integer[] imgid) {
        super(context, R.layout.listview_layout2,Asunto);

        this.context=context;
        this.Asunto=Asunto;
        this.desc=desc;
        this.Categoria=Categoria;
        this.imgid=imgid;

    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View r= convertView;
        ViewHolder viewHolder=null;
        if(r==null)
        {
            LayoutInflater layoutInflater= context.getLayoutInflater();
            r=layoutInflater.inflate(R.layout.listview_layout,null,true);
            viewHolder= new ViewHolder(r);
            r.setTag(viewHolder);

        }

        else
        {
            viewHolder=(ViewHolder)r.getTag();

        }
        viewHolder.ivw.setImageResource(imgid[position]);
        viewHolder.tvw1.setText(Asunto[position]);
        viewHolder.tvw2.setText(desc[position]);
        viewHolder.tvw3.setText(Categoria[position]);



        return r;
    }

    class ViewHolder{

        TextView tvw1;
        TextView tvw2;
        TextView tvw3;
        ImageView ivw;
        ViewHolder(View v)
        {
            tvw1=(TextView)v.findViewById(R.id.textView2);
            tvw2=(TextView)v.findViewById(R.id.textView3);
            tvw3=(TextView)v.findViewById(R.id.textView4);
            ivw=(ImageView)v.findViewById(R.id.imageView2);
        }


    }





}

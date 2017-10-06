package com.example.transeguro.transeguroapp;

import android.content.ContentValues;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.regex.Pattern;

import static com.example.transeguro.transeguroapp.Login.usuarioconectado;

public class perfil extends AppCompatActivity {
    EditText txtcorreo1,txtpassword1,txtnombre1,txtapellido1,txtedad1,txtdni1;
    TextInputLayout impcorreo1,imppassword1,impnombre1,impapellido1,impedad1,impdni1;
    Button btnactualizar;
    ConexionSQLiteHelper db;

    Boolean pas,nom,ape,eda,dni,pas2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);
        db = new ConexionSQLiteHelper(this,"BD", null, 1);

        pas=false; nom=false; ape=false; eda=false; dni=false; pas2=false;

        txtcorreo1 = (EditText)findViewById(R.id.txtcorreo1);
        txtpassword1 = (EditText)findViewById(R.id.txtpassword1);
        txtnombre1 = (EditText)findViewById(R.id.txtnombre1);
        txtapellido1 = (EditText)findViewById(R.id.txtapellido1);
        txtedad1 = (EditText)findViewById(R.id.txtedad1);
        txtdni1 = (EditText)findViewById(R.id.txtdni1);
        imppassword1 = (TextInputLayout)findViewById(R.id.imppassword1);


        txtcorreo1.setText(usuarioconectado);
        String[] parametros = {usuarioconectado};
        try{
            SQLiteDatabase sql= db.getReadableDatabase();
            Cursor cursor= sql.rawQuery("SELECT nombre,apellido,edad,dni FROM Usuario WHERE correo=?",parametros);
            cursor.moveToFirst();
            txtpassword1.setText("");
            txtnombre1.setText(cursor.getString(0));
            txtapellido1.setText(cursor.getString(1));
            txtedad1.setText(cursor.getString(2));
            txtdni1.setText(cursor.getString(3));
            db.close();
        }catch (Exception e){
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
        }



        btnactualizar=(Button)findViewById(R.id.btnactualizar);
        btnactualizar.setOnClickListener(new View.OnClickListener()
        { @Override
        public void onClick(View v)
        {

        try {
            Pattern p = Pattern.compile("[0-9A-Za-zñ]+");
            if(txtpassword1.getText().toString().equals("")) {
                pas=true;
            }else{
                pas2=true;
                if (p.matcher(txtpassword1.getText().toString()).matches() == false) {
                    imppassword1.setError("Password inválido. Solo Letras y Números.");
                    pas = false;
                } else {
                    pas = true;
                    imppassword1.setError(null);
                    p = Pattern.compile("[A-Za-zñ]+");
                }
            }

            if (p.matcher(txtnombre1.getText().toString()).matches() == false) {
                nom = false;
            } else
                nom = true;

            if (p.matcher(txtapellido1.getText().toString()).matches() == false) {
                ape = false;
            } else
                ape = true;

            p = Pattern.compile("[0-9]+");
            if (p.matcher(txtedad1.getText().toString()).matches() == false || txtedad1.length() > 2) {
                eda = false;
            } else
                eda = true;

            p = Pattern.compile("[0-9]+");
            if (p.matcher(txtdni1.getText().toString()).matches() == false || txtdni1.length() != 8) {
                dni = false;
            } else
                dni = true;
        }catch(Exception e){
            Toast.makeText(getApplicationContext(),"Error",Toast.LENGTH_SHORT).show();
        }
/*
            if(pas==true && nom==true  && ape==true && eda==true && dni==true){
                String usu=txtcorreo1.getText().toString();
                String clave =txtpassword1.getText().toString();
                    String[] parametros = {usuarioconectado};

                    ContentValues values = new ContentValues();
                    if(pas2==false)
                        values.put("contraseña", txtpassword1.getText().toString());
                    values.put("nombre", txtnombre1.getText().toString());
                    values.put("apellido", txtapellido1.getText().toString());
                    values.put("edad", txtedad1.getText().toString());
                    values.put("dni", txtdni1.getText().toString());
                    try {
                        SQLiteDatabase sql = db.getWritableDatabase();
                        sql.update("Usuario", values, "correo =?", parametros);
                        Toast.makeText(getApplicationContext(), "Datos Actualizados", Toast.LENGTH_SHORT).show();
                        db.close();
                    }catch(Exception e) {
                        Toast.makeText(getApplicationContext(), "la cagaste peor wey", Toast.LENGTH_SHORT).show();
                    }

                    Intent i= new Intent(getApplicationContext(),Login.class);
                    startActivity(i);
            }else {
                Toast.makeText(getApplicationContext(),"Datos Incorrectos",
                        Toast.LENGTH_SHORT).show();
            }
*/
            Toast.makeText(getApplicationContext(),"Boton En mantenimiento",
                    Toast.LENGTH_SHORT).show();
        }

        });
    }
}





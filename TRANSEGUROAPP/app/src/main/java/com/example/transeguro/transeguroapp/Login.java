package com.example.transeguro.transeguroapp;

import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.media.MediaCodec;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.regex.Pattern;

public class Login extends AppCompatActivity {

    EditText txtpassword, txtcorreo;
    TextInputLayout impcorreo, imppassword;
    TextView tvregistrese;
    Button btningresar;
    ConexionSQLiteHelper db;

    Boolean Cor = false, pas = false, nom = false, ape = false, eda = false, dni = false;

    public static String usuarioconectado;

    Cursor cursor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        txtcorreo = (EditText) findViewById(R.id.txtcorreo);
        txtpassword = (EditText) findViewById(R.id.txtpassword);
        impcorreo = (TextInputLayout) findViewById(R.id.impcorreo);
        imppassword = (TextInputLayout) findViewById(R.id.imppassword);

        db = new ConexionSQLiteHelper(this, "BD", null, 1);

        //cuenta de prueba
        SQLiteDatabase sql = db.getWritableDatabase();
        sql.execSQL("INSERT INTO Usuario (correo,contraseña,nombre,apellido,edad,dni) values ('rfh0701@hotmail.com', 'Malgg246', 'Renzo', 'Flores', 23, '70024963')");
        db.close();


//METODO PARA CONECTAR TVREGISTRESE CON CLASE REGISTRAR
        tvregistrese = (TextView) findViewById(R.id.tvregistrese);
        tvregistrese.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(Login.this, registrar.class);
                Login.this.startActivity(i);

            }
        });

//METODO PARA CONECTAR BOTON INGRESAR CON LA CLASE MENU
        btningresar = (Button) findViewById(R.id.btningresar);
        btningresar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String usu = txtcorreo.getText().toString();
                String clave = txtpassword.getText().toString();

                if (Patterns.EMAIL_ADDRESS.matcher(usu).matches() == false) {
                    impcorreo.setError("Correo Invalido. Debe ser usuario@correo.com");
                    Cor = false;
                } else {
                    Cor = true;
                    impcorreo.setError(null);
                }

                Pattern p = Pattern.compile("[A-Za-z0-9ñ]+");
                if (p.matcher(clave).matches() == false) {
                    imppassword.setError("Ingrese Número y Letras");
                    pas = false;
                } else {
                    pas = true;
                    imppassword.setError(null);
                }

                if (Cor == true && pas == true) {
                    SQLiteDatabase sql = db.getReadableDatabase();
                    String[] parametros = {usu};

                    try {
                        cursor = sql.rawQuery("SELECT correo,contraseña FROM Usuario WHERE correo=?", parametros);
                        cursor.moveToFirst();
                        if (usu.equals(cursor.getString(0)) && clave.equals(cursor.getString(1))) {
                            usuarioconectado = cursor.getString(0);
                            Intent i = new Intent(getApplicationContext(), Menu.class);
                            startActivity(i);
                        } else {
                            Toast.makeText(getApplicationContext(), "Usuario o Password Incorrectos", Toast.LENGTH_SHORT).show();
                        }
                    } catch (Exception e) {
                        Toast.makeText(getApplicationContext(), "Usuario o Password Incorrectos", Toast.LENGTH_SHORT).show();
                    }
                }
            }
        });
    }
}


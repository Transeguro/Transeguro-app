package com.example.transeguro.transeguroapp;

import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.support.design.widget.TextInputLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.regex.Pattern;


public class registrar extends AppCompatActivity {

    EditText txtcorreo,txtpassword,txtnombre,txtapellido,txtedad,txtdni;
    TextInputLayout impcorreo,imppassword,impnombre,impapellido,impedad,impdni;
    Button btnregistrar;
    ConexionSQLiteHelper db;

    Boolean Cor=false, pas=false, nom=false, ape=false, eda=false, dni=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar);

        txtcorreo = (EditText)findViewById(R.id.txtcorreo);
        txtpassword = (EditText)findViewById(R.id.txtpassword);
        txtnombre = (EditText)findViewById(R.id.txtnombre);
        txtapellido = (EditText)findViewById(R.id.txtapellido);
        txtedad = (EditText)findViewById(R.id.txtedad);
        txtdni = (EditText)findViewById(R.id.txtdni);
        impcorreo = (TextInputLayout)findViewById(R.id.impcorreo);
        imppassword = (TextInputLayout)findViewById(R.id.imppassword);
        db = new ConexionSQLiteHelper(this, "BD",null,1);


        btnregistrar=(Button)findViewById(R.id.btnregistrar);
        btnregistrar.setOnClickListener(new View.OnClickListener()
        { @Override
        public void onClick(View v)
        {

            if(Patterns.EMAIL_ADDRESS.matcher(txtcorreo.getText().toString()).matches()==false) {
                impcorreo.setError("Correo Invalido.Debe ser usuario@correo.com");
                Cor = false;
            }else {
                Cor=true;
                impcorreo.setError(null);
            }

            Pattern p = Pattern.compile("[0-9A-Za-zñ]+");
            if(p.matcher(txtpassword.getText().toString()).matches()==false) {
                imppassword.setError("Password inválido. Solo Letras y Números.");
                pas = false;
            }
            else {
                pas=true;
                imppassword.setError(null);
            }

            p = Pattern.compile("[A-Za-zñ]+");
            if(p.matcher(txtnombre.getText().toString()).matches()==false) {
                nom = false;
            }
            else
                nom=true;

            if(p.matcher(txtapellido.getText().toString()).matches()==false) {
                ape = false;
            }
            else
                ape=true;

            p = Pattern.compile("[0-9]+");
            if(p.matcher(txtedad.getText().toString()).matches()==false || txtedad.length()>2) {
                eda = false;
            }
            else
                eda=true;

            p = Pattern.compile("[0-9]+");
            if(p.matcher(txtdni.getText().toString()).matches()==false || txtdni.length()!=8) {
                dni = false;
            }
            else
                dni=true;


            if(Cor==true && pas==true && nom==true  && ape==true && eda==true && dni==true){
                String usu=txtcorreo.getText().toString();


                if(usu.matches("[a-zA-Z0-9._-]+@[a-z]+.[a-z]+")) {

                    SQLiteDatabase sql = db.getWritableDatabase();
                    sql.execSQL("INSERT INTO Usuario (correo, contraseña, nombre, apellido, edad, dni)" +
                            "values ('" + txtcorreo.getText().toString()+ "'," +
                                    "'" + txtpassword.getText().toString() + "',"+
                                    "'" + txtnombre.getText().toString() + "' ,"+
                                    "'" + txtapellido.getText().toString() + "' ,"+
                                    " " + txtedad.getText().toString() + " ," +
                                    "'" + txtdni.getText().toString() + "');");
                    Toast.makeText(getApplicationContext(),"Datos Correctos",Toast.LENGTH_SHORT).show();
                    db.close();

                    Intent i= new Intent(getApplicationContext(),Login.class);
                    startActivity(i);
                }else {
                    Toast.makeText(getApplicationContext(),"Correo: ejemplo@algo.algo",
                            Toast.LENGTH_SHORT).show();
                }
            }else {
                Toast.makeText(getApplicationContext(),"Datos Incorrectos",
                        Toast.LENGTH_SHORT).show();
            }

        }

        });
    }
}

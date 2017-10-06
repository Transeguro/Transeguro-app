package com.example.transeguro.transeguroapp;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by HP1 on 02/10/2017.
 */

public class ConexionSQLiteHelper extends SQLiteOpenHelper{
    //TEXT as ISO8601 strings ("YYYY-MM-DD HH:MM:SS.SSS"). Para fechas
    //Craemos un    a variable que contendra la sentencia
    String sql =
            "CREATE TABLE Usuario (id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                    "                      correo TEXT UNIQUE," +
                    "                      contraseña TEXT," +
                    "                      nombre TEXT," +
                    "                      apellido TEXT," +
                    "                      edad INTEGER," +
                    "                      dni TEXT);" +
                    "                      " +
                    "CREATE TABLE Quejas (codigo INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "                     id_usuario TEXT, " +
                    "                     descripcion TEXT, " +
                    "                     fechaqueja TEXT, " +
                    "                     fuente BLOB, " +
                    "                     categoria TEXT, " +
                    "                     info TEXT, " +
                    "                     fecha INTEGER," +
                    "                    FOREIGN KEY (id_usuario) REFERENCES Usuario (id)" +
                    "                    FOREIGN KEY (info) REFERENCES asignados (no));" +
                    "                    " +
                    "CREATE TABLE Sugerencias (codigo INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "                          id_usuario TEXT, " +
                    "                          titulo TEXT, " +
                    "                          descripcion TEXT, " +
                    "                          categoria TEXT," +
                    "                    FOREIGN KEY (id_usuario) REFERENCES Usuario (id));" +
                    "                    " +
                    "CREATE TABLE Conductores (id INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "                          nombre TEXT, " +
                    "                          apellido TEXT, " +
                    "                          dni TEXT, " +
                    "                          licencia TEXT);" +
                    "                          " +
                    "CREATE TABLE Rutas (codigo INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "                    nombre TEXT, " +
                    "                    inicio TEXT, " +
                    "                    final TEXT);" +
                    "                    " +
                    "CREATE TABLE Vehiculos (codigo INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "                        modelo TEXT, " +
                    "                        placa TEXT, " +
                    "                        marca TEXT);" +
                    "                        \n" +
                    "CREATE TABLE Asignados (nro INTEGER PRIMARY KEY AUTOINCREMENT, " +
                    "                        id_conductor INTEGER, " +
                    "                        codigo_ruta INTEGER, " +
                    "                        codigo_vehiculo INTEGER," +
                    "                     FOREIGN KEY (id_conductor) REFERENCES Conductor (id), " +
                    "                     FOREIGN KEY (codigo_ruta) REFERENCES Ruta (codigo), " +
                    "                     FOREIGN KEY (codigo_vehiculo) REFERENCES Vehiculo (codigo));";

    public ConexionSQLiteHelper(Context context, String name, SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        //Este metodo se ejecuta automaticamente cuando la base de datos no exite
        //es decir, que la primera vez que se hace llamado a la clase, crea la BD
        db.execSQL(sql);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        //Este metodo se ejecuta cuando se detecta que la versión de la base de datos
        //cambio, por lo que se debe definir todos los procesos de migración de la estructura
        //anterior a la estructura nueva. POr simplicidad del ejemplo, lo que haremos es eliminar la
        // tabla existente y crearla nuevamente.

        db.execSQL("DROP TABLE IF EXISTS Usuario");
        db.execSQL("DROP TABLE IF EXISTS Quejas");
        db.execSQL("DROP TABLE IF EXISTS Sugerencias");
        db.execSQL("DROP TABLE IF EXISTS Conductores");
        db.execSQL("DROP TABLE IF EXISTS Rutas");
        db.execSQL("DROP TABLE IF EXISTS Vehiculos");
        db.execSQL("DROP TABLE IF EXISTS Asignados");
        db.execSQL(sql);
    }
}
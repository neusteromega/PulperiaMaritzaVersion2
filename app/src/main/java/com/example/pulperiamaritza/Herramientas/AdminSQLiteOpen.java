package com.example.pulperiamaritza.Herramientas;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class AdminSQLiteOpen extends SQLiteOpenHelper {
    //Método Constructor
    public AdminSQLiteOpen(@Nullable Context context, @Nullable String name, @Nullable SQLiteDatabase.CursorFactory factory, int version) {
        super(context, name, factory, version);
    }

    //Aquí se crean todas las tablas de la BDD mediante consultas
    @Override
    public void onCreate(SQLiteDatabase BaseDatos) {
        BaseDatos.execSQL("CREATE TABLE Categorias (CatID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, CatNombre TEXT NOT NULL, CatImagen INTEGER NOT NULL);");
        BaseDatos.execSQL("CREATE TABLE Proveedores (PrvID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, PrvNombre TEXT NOT NULL, PrvImagen INTEGER NOT NULL);");
        BaseDatos.execSQL("CREATE TABLE Productos (PrdID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, PrdNombre1 TEXT NOT NULL, PrdNombre2 TEXT NOT NULL, PrdTipo1 TEXT NOT NULL, PrdTipo2 TEXT, PrdPrecio1 TEXT NOT NULL, PrdPrecio2 TEXT, CatID INTEGER NOT NULL, PrvID INTEGER NOT NULL, PrdImagen INTEGER NOT NULL, FOREIGN KEY(CatID) REFERENCES Categorias(CatID), FOREIGN KEY(PrvID) REFERENCES Proveedores(PrvID));");
        BaseDatos.execSQL("CREATE TABLE VentasEncabezado (VntID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, VntFecha TEXT NOT NULL, VntBolsas INTEGER NOT NULL);");
        BaseDatos.execSQL("CREATE TABLE VentasDetalle (VntID INTEGER NOT NULL, PrdID INTEGER NOT NULL, PrdPrecio REAL NOT NULL, PrdCantidad REAL NOT NULL, PrdTipo TEXT NOT NULL, FOREIGN KEY(VntID) REFERENCES VentasEncabezado(VntID), FOREIGN KEY(PrdID) REFERENCES Productos(PrdID), PRIMARY KEY(VntID, PrdID));");
        BaseDatos.execSQL("CREATE TABLE CarritoTemporal (CrtID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, CrtNombre TEXT NOT NULL, CrtTipo TEXT NOT NULL, CrtCantidad TEXT NOT NULL, CrtPrecio TEXT NOT NULL, CrtTotal TEXT NOT NULL, CrtImagen INTEGER NOT NULL);");
        BaseDatos.execSQL("CREATE TABLE Roles (RolID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, RolNombre TEXT NOT NULL);");
        BaseDatos.execSQL("CREATE TABLE Usuarios (UsuID INTEGER PRIMARY KEY AUTOINCREMENT NOT NULL, UsuNombreApellido TEXT NOT NULL, UsuCorreo TEXT NOT NULL, UsuTelefono TEXT NOT NULL, UsuContrasena TEXT NOT NULL, RolID INTEGER NOT NULL, FOREIGN KEY(RolID) REFERENCES Roles(RolID));");
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {

    }
}

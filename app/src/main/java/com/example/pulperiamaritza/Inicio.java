package com.example.pulperiamaritza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import com.example.pulperiamaritza.Herramientas.ProductosTodos;

public class Inicio extends AppCompatActivity {

    ProductosTodos todos = new ProductosTodos(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio);

        //Llamamos al método "verificarDatos" para corroborar que la tabla de Roles esté vacía, si está vacía, retornará un 0 que se guardará en la variable "rol"
        int rol = todos.verificarDatos("Roles");

        if (rol == 0)
            todos.insertarRoles();
    }

    public void iniciarSesion(View view) {
        Intent pagina = new Intent(this, IniciarSesion.class);
        startActivity(pagina);
    }

    public void registrarse(View view) {
        Intent pagina = new Intent(this, Registrarse.class);
        startActivity(pagina);
    }
}
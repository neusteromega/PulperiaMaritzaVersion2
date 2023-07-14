package com.example.pulperiamaritza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ConsultarTodo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_todo);
    }

    public void verPerfil(View view) {
        Intent pagina = new Intent(this, Perfil.class);
        startActivity(pagina);
    }

    public void verCategorias(View view) {
        Intent pagina = new Intent(this, Categorias.class);
        startActivity(pagina);
    }

    public void verProductos(View view) {
        Intent pagina = new Intent(this, Productos.class);
        startActivity(pagina);
    }

    public void verProveedores(View view) {
        Intent pagina = new Intent(this, Proveedores.class);
        startActivity(pagina);
    }

    public void carritoVenta(View view) {
        Intent pagina = new Intent(this, CarritoCompra.class);
        startActivity(pagina);
    }

    public void historial(View view) {
        Intent pagina = new Intent(this, Historial.class);
        startActivity(pagina);
    }

    public void menuPrincipal(View view) {
        Intent pagina = new Intent(this, MenuPrincipal.class);
        startActivity(pagina);
    }
}
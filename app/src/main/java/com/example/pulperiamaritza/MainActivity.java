package com.example.pulperiamaritza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import com.example.pulperiamaritza.Modelos.ProductoItemsModel;
import com.example.pulperiamaritza.Herramientas.ProductosTodos;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    ProductosTodos todos = new ProductosTodos(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        List<ProductoItemsModel> items = todos.obtenerProductos();
        List<ProductoItemsModel> items2 = todos.obtenerProductosBDD();

        int cat = todos.verificarDatos("Categorias");
        int prv = todos.verificarDatos("Proveedores");

        if (cat == 0)
            todos.insertarDatos("Categorias");

        if (prv == 0)
            todos.insertarDatos("Proveedores");

        //Toast.makeText(this, "items: " + items.size(), Toast.LENGTH_SHORT).show();
        Toast.makeText(this, "items BDD: " + items2.size(), Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                Intent intent = new Intent(MainActivity.this, MenuPrincipal.class);
                startActivity(intent);
                finish();
            }
        }, 3000);
    }
}
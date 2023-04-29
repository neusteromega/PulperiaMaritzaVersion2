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

        //List<ProductoItemsModel> items = todos.obtenerProductos1();
        List<ProductoItemsModel> items2 = todos.obtenerProductosBDD();

        //Llamamos al método "verificarDatos" para corroborar que esta tres tablas están vacías, si están vacías, retornará un 0 que se guardará en las siguientes tres variables enteras
        int cat = todos.verificarDatos("Categorias");
        int prv = todos.verificarDatos("Proveedores");
        int prd = todos.verificarDatos("Productos");

        //Solo si las variables "cat, prv, prd" son 0, que se ejecute la inserción de los datos llamando al método "insertarDatos" de la clase "ProductosTodos"
        if (cat == 0)
            todos.insertarDatos("Categorias", 0); //Enviamos el número 0 para indicar que se van a insertar datos a una tabla que no es la de productos (en este caso, a la de categorías)

        if (prv == 0)
            todos.insertarDatos("Proveedores", 0); //Enviamos el número 0 para indicar que se van a insertar datos a una tabla que no es la de productos (en este caso, a la de proveedores)

        if (prd == 0)
            todos.insertarDatos("Productos", 1); //Mandamos el número 1 para indicar que se debe insertar la primera lista de productos

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
package com.example.pulperiamaritza;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.pulperiamaritza.Modelos.ProductoItemsModel;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.List;

public class ConsultarTodo extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_consultar_todo);

        //insertarFirebase();
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
        Intent pagina = new Intent(this, CarritoVenta.class);
        startActivity(pagina);
    }

    public void historial(View view) {
        Intent pagina = new Intent(this, Historial.class);
        startActivity(pagina);
    }

    /*
    public void insertarFirebase() {
        FirebaseDatabase db = FirebaseDatabase.getInstance();
        DatabaseReference dbref = db.getReference(ProductoItemsModel.class.getSimpleName());

        dbref.addListenerForSingleValueEvent(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot snapshot) {
                items = todos.obtenerItems();

                for (int i = 0; i < items.size(); i++) {
                    ProductoItemsModel productos = new ProductoItemsModel(items.get(i).getNombre(), items.get(i).getCategoria(), items.get(i).getCantidad1(), items.get(i).getCantidad2(), items.get(i).getPrecio1(), items.get(i).getPrecio2(), items.get(i).getImagen(), items.get(i).getProveedor());
                    dbref.push().setValue(productos);
                    Toast.makeText(todos, "Exito", Toast.LENGTH_SHORT).show();
                }
            }

            @Override
            public void onCancelled(@NonNull DatabaseError error) {
                Toast.makeText(todos, "Error dog", Toast.LENGTH_SHORT).show();
            }
        });
    }*/
}
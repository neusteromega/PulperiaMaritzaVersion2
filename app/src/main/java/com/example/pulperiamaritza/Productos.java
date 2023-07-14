package com.example.pulperiamaritza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.SearchView;

import com.example.pulperiamaritza.Adaptadores.ProductosAdapter;
import com.example.pulperiamaritza.Modelos.ProductoItemsModel;
import com.example.pulperiamaritza.Herramientas.ProductosTodos;

import java.util.List;

public class Productos extends AppCompatActivity implements SearchView.OnQueryTextListener {

    private SearchView searchView;
    private RecyclerView rvProductos;
    private ProductosAdapter adapter;
    public List<ProductoItemsModel> items;
    private ProductosTodos todos = new ProductosTodos(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos);
        inicializarVistas();
        inicializarValores();
    }

    private void inicializarVistas() {
        rvProductos = findViewById(R.id.rvProductos);
        searchView = findViewById(R.id.svBuscarProducto);
    }

    private void inicializarValores() {
        LinearLayoutManager manager = new LinearLayoutManager(this); //Creamos un adaptador para que el RecyclerView se vea en forma de tarjetas
        rvProductos.setLayoutManager(manager); //Asignamos el adaptador

        items = todos.obtenerProductosBDD(); //Obtenemos e igualamos los items a la lista "items" llamando al método "obtenerProductosBDD" de la clase "ProductosTodos"
        adapter = new ProductosAdapter(items); //Creamos un objeto de tipo ProductosAdapter en el cual enviamos la lista "items", y dicho objeto lo igualamos al otro objeto de tipo ProductosAdapter llamado "adapter"

        adapter.setOnClickListener(new View.OnClickListener() { //Usando el objeto de "adapter" llamamos al método "setOnClickListener" de la clase ProductosAdapter
            @Override
            public void onClick(View view) { //Al dar click en una tarjeta del RecyclerView "rvProductos" se realizará lo siguiente
                Intent intent = new Intent(getApplicationContext(), ProductosDetalle.class);
                intent.putExtra("productoImagen", items.get(rvProductos.getChildAdapterPosition(view)).getImagen());
                intent.putExtra("productoPrecio", items.get(rvProductos.getChildAdapterPosition(view)).getPrecio1());
                intent.putExtra("productoPrecio2", items.get(rvProductos.getChildAdapterPosition(view)).getPrecio2());
                intent.putExtra("productoNombre", items.get(rvProductos.getChildAdapterPosition(view)).getNombre1());
                intent.putExtra("productoNombre2", items.get(rvProductos.getChildAdapterPosition(view)).getNombre2());
                intent.putExtra("productoCategoria", items.get(rvProductos.getChildAdapterPosition(view)).getCategoria());
                intent.putExtra("productoProveedor", items.get(rvProductos.getChildAdapterPosition(view)).getProveedor());
                intent.putExtra("productoTipo", items.get(rvProductos.getChildAdapterPosition(view)).getTipo1());
                intent.putExtra("productoTipo2", items.get(rvProductos.getChildAdapterPosition(view)).getTipo2());
                startActivity(intent);

                //Toast.makeText(getApplicationContext(), "Selección: " + items.get(rvProductos.getChildAdapterPosition(view)).getNombre(), Toast.LENGTH_SHORT).show();
            }
        });

        rvProductos.setAdapter(adapter); //Asignamos el adaptador al RecyclerView "rvProductos"

        searchView.setOnQueryTextListener(this);
    }

    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        adapter.filtrado(s);
        return false;
    }

    public void menuPrincipal(View view) {
        Intent pagina = new Intent(this, MenuPrincipal.class);
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
}
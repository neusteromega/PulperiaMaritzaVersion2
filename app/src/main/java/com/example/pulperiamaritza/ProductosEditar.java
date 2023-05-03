package com.example.pulperiamaritza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.Toast;

import com.example.pulperiamaritza.Herramientas.ProductosTodos;
import com.example.pulperiamaritza.Modelos.CatPrvItemsModel;

import java.util.ArrayList;
import java.util.List;

public class ProductosEditar extends AppCompatActivity {

    private ImageView imgProducto;
    private Spinner spCategorias, spProveedores;
    private EditText nombre1, nombre2, precio1, precio2, tipo1, tipo2;
    private ProductosTodos todos = new ProductosTodos(this);
    private List<CatPrvItemsModel> items;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_editar);

        imgProducto = findViewById(R.id.imgEdit);
        spCategorias = findViewById(R.id.spnCategoriasEdit);
        spProveedores = findViewById(R.id.spnProveedorEdit);
        nombre1 = findViewById(R.id.txtNombre1Edit);
        nombre2 = findViewById(R.id.txtNombre2Edit);
        precio1 = findViewById(R.id.txtPrecio1Edit);
        precio2 = findViewById(R.id.txtPrecio2Edit);
        tipo1 = findViewById(R.id.txtTipo1Edit);
        tipo2 = findViewById(R.id.txtTipo2Edit);

        Intent intent = getIntent();
        imgProducto.setImageResource(intent.getIntExtra("prdImagen", 0));

        List<String> categorias = new ArrayList<>();
        List<String> proveedores = new ArrayList<>();

        items = todos.obtenerCategoriasBDD();
        for (int i = 0; i < items.size(); i++) {
            categorias.add(items.get(i).getNombre());
        }

        items = todos.obtenerProveedoresBDD();
        for (int i = 0; i < items.size(); i++) {
            proveedores.add(items.get(i).getNombre());
        }

        ArrayAdapter<String> adapterCat = new ArrayAdapter<String>(this, R.layout.spinner_item_categorias, categorias);
        //adapterCat.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spCategorias.setAdapter(adapterCat);
        spCategorias.setSelection(Spinner.INVALID_POSITION);

        ArrayAdapter<String> adapterPrv = new ArrayAdapter<String>(this, R.layout.spinner_item_categorias, proveedores);
        //adapterPrv.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spProveedores.setAdapter(adapterPrv);
        spProveedores.setSelection(Spinner.INVALID_POSITION);

        //Toast.makeText(this, "CATEGORIAS POSICION: " + spCategorias.getSelectedItemPosition(), Toast.LENGTH_SHORT).show();
    }

    public void deseleccionarSpinnerCategorias(View view) {
        spCategorias.setSelection(Spinner.INVALID_POSITION);

        /*if (spCategorias.getSelectedItemPosition() == Spinner.INVALID_POSITION)
            spCategorias.setSelection(4);*/
    }

    public void deseleccionarSpinnerProveedores(View view) {
        if (spCategorias.getSelectedItem().toString() != null)
            Toast.makeText(this, "CATEGORÍA ITEM: "+ spCategorias.getSelectedItem().toString(), Toast.LENGTH_SHORT).show();
    }
}
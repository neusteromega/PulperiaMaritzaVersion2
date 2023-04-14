package com.example.pulperiamaritza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SearchView;

import com.example.pulperiamaritza.Adaptadores.CatPrvAdapter;
import com.example.pulperiamaritza.Modelos.CatPrvItemsModel;
import com.example.pulperiamaritza.Herramientas.ProductosTodos;

import java.util.ArrayList;
import java.util.List;

public class Categorias extends AppCompatActivity implements SearchView.OnQueryTextListener {

    List<CatPrvItemsModel> items = new ArrayList<>();

    GridView gridView;
    SearchView searchView;
    CatPrvAdapter customAdapter;
    ProductosTodos todos = new ProductosTodos(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_categorias);

        //Inicializamos el GridView y el SearchView
        gridView = findViewById(R.id.gvCategorias);
        searchView = findViewById(R.id.svBuscarCategoria);

        //Llenamos la Lista con los elementos (Categoría e Imagen)
        items = todos.obtenerCategoriasBDD();

        //Pasamos la lista de elementos a la clase "CatPrvAdapter", y a su vez, se recorre toda esa clase que nos retorna el adaptador para luego asignarlo en el GridView
        customAdapter = new CatPrvAdapter(items, this);

        //Asignamos el adaptador al GridView
        gridView.setAdapter(customAdapter);

        //Esto hace que la función "onQueryTextSubmit" se ejecute
        searchView.setOnQueryTextListener(this);

        gridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                Intent intent = new Intent(getApplicationContext(), ProductosPorCatPrv.class);
                intent.putExtra("categoria", items.get(i).getNombre());
                intent.putExtra("tipo", "Categoria");
                startActivity(intent);
            }
        });
    }

    //Estos dos métodos nos ayudan a que el buscador sea en tiempo real, que encuentre resultados con solo escribir
    @Override
    public boolean onQueryTextSubmit(String s) {
        return false;
    }

    @Override
    public boolean onQueryTextChange(String s) {
        customAdapter.filtrado(s);
        return false;
    }

    public void carritoVenta(View view) {
        Intent pagina = new Intent(this, CarritoVenta.class);
        startActivity(pagina);
    }

    /*public class CustomAdapter extends BaseAdapter{
        private List<CategoriaItemsModel> itemsModelList;
        private List<CategoriaItemsModel> itemsModelListFiltered;
        private Context context;

        public CustomAdapter(List<CategoriaItemsModel> itemsList, Context context) {
            this.itemsModelListFiltered = itemsList;
            itemsModelList = new ArrayList<>();
            itemsModelList.addAll(itemsList);
            this.context = context;
        }

        public void filtrado(String txtBuscar) {
            int longitud = txtBuscar.length();

            if (longitud == 0) {
                itemsModelListFiltered.clear();
                itemsModelListFiltered.addAll(itemsModelList);
            }
            else {
                List<CategoriaItemsModel> coleccion = itemsModelListFiltered.stream()
                        .filter(i -> i.getNombre().toLowerCase().contains(txtBuscar.toLowerCase()))
                        .collect(Collectors.toList());

                itemsModelListFiltered.clear();
                itemsModelListFiltered.addAll(coleccion);
            }

            notifyDataSetChanged();
        }

        @Override
        public int getCount() {
            return itemsModelListFiltered.size();
        }

        @Override
        public Object getItem(int i) {
            return null;
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View convertView, ViewGroup viewGroup) {

            //Creamos una vista inflada y le metemos el diseño de "categorias_items" para cada casilla del GridView
            View view = getLayoutInflater().inflate(R.layout.categorias_items, null);

            //Enlazamos los componentes del diseño de "categorias_items" a dos variables
            ImageView imageCategorias = view.findViewById(R.id.imgImagenCategoria);
            TextView tvCategorias = view.findViewById(R.id.lblNombreCategoria);

            //Asignamos cada origen de imagenCategoria y el texto de nombreCategoria a los dos variables antes declaradas
            imageCategorias.setImageResource(itemsModelListFiltered.get(i).getImagen());
            tvCategorias.setText(itemsModelListFiltered.get(i).getNombre());

            return view;
        }
    }*/
}
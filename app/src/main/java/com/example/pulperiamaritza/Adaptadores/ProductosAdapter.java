package com.example.pulperiamaritza.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pulperiamaritza.Modelos.ProductoItemsModel;
import com.example.pulperiamaritza.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class ProductosAdapter extends RecyclerView.Adapter<ProductosAdapter.RecyclerHolder> implements View.OnClickListener {
    private List<ProductoItemsModel> items; //Creamos una lista de tipo ProductoItemsModel
    private List<ProductoItemsModel> itemsOriginal; //Creamos otra lista de tipo ProductoItemsModel que nos servirá para el filtrado y búsqueda de datos del RecyclerView
    private View.OnClickListener listener; //Creamos un escuchador (listener) de tipo "View.OnClickListener" que nos servirá para el onClick de cada tarjeta del RecyclerView

    public ProductosAdapter(List<ProductoItemsModel> items) { //Método Constructor en el cual inicializamos la lista "items"
        this.items = items;
        itemsOriginal = new ArrayList<>();
        itemsOriginal.addAll(items);
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_productos, parent, false); //Inflamos la vista que utilizaremos para las tarjetas del RecyclerView
        view.setOnClickListener(this);
        return new RecyclerHolder(view); //Retornamos un nuevo objeto de tipo RecyclerHolder (La clase estática de abajo) y le mandamos la vista de la variable "view"
    }

    //Este método se ejecuta las veces que el método "getItemCount" lo indique, o sea, dependiendo del size de la lista "items"
    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        ProductoItemsModel item = items.get(position); //Creamos una lista de tipo ProductoItemsModel llamada "item" la cual igualamos a la otra lista "items" extrayendo posición por posición

        //Haciendo uso del objeto "holder", asignamos los textos a las diferentes variables que se encuentran en la clase estática "RecyclerHolder"
        holder.imgProducto.setImageResource(item.getImagen());
        holder.tvProducto.setText(item.getNombre1());
        holder.tvCategoria.setText(item.getCategoria());
        holder.tvCantidad.setText(item.getTipo1());
        holder.tvPrecio.setText("L."+ item.getPrecio1());
    }

    public void filtrado(String txtBuscar) {
        int longitud = txtBuscar.length();

        if (longitud == 0) {
            items.clear();
            items.addAll(itemsOriginal);
        }
        else {
            List<ProductoItemsModel> coleccion = items.stream()
                    .filter(i -> i.getNombre1().toLowerCase().contains(txtBuscar.toLowerCase()))
                    .collect(Collectors.toList());

            items.clear();
            items.addAll(coleccion);
        }

        notifyDataSetChanged();
    }

    @Override
    public int getItemCount() {
        return items.size(); //Retornamos la cantidad de elementos que tiene la lista "items"
    }

    public void setOnClickListener(View.OnClickListener listener) {
        this.listener = listener;
    }

    @Override
    public void onClick(View view) {
        if (listener != null) {
            listener.onClick(view);
        }
    }

    public static class RecyclerHolder extends RecyclerView.ViewHolder {
        //Variables para cada elemento cambiante de las tarjetas del RecyclerView
        private ImageView imgProducto;
        private TextView tvProducto;
        private TextView tvCategoria;
        private TextView tvCantidad;
        private TextView tvPrecio;

        public RecyclerHolder(@NonNull View itemView) { //Método Constructor que recibe un View
            super(itemView);

            //Referenciamos los elementos de la vista de las tarjetas del RecyclerView a las variables de arriba
            imgProducto = itemView.findViewById(R.id.imgdeProducto);
            tvProducto = itemView.findViewById(R.id.lblNombreProducto);
            tvCategoria = itemView.findViewById(R.id.lblCategoriaProducto);
            tvCantidad = itemView.findViewById(R.id.lblCantidadProducto);
            tvPrecio = itemView.findViewById(R.id.lblPrecioProducto);
        }
    }
}

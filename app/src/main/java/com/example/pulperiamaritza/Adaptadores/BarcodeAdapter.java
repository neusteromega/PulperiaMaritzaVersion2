package com.example.pulperiamaritza.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pulperiamaritza.Modelos.BarcodeItemsModel;
import com.example.pulperiamaritza.R;

import java.util.List;

public class BarcodeAdapter extends RecyclerView.Adapter<BarcodeAdapter.RecyclerHolder> {
    private List<BarcodeItemsModel> items; //Creamos una lista de tipo BarcodeItemsModel

    public BarcodeAdapter(List<BarcodeItemsModel> items) { //Inicializamos la lista "items" en el método constructor
        this.items = items;
    }

    @NonNull
    @Override
    public BarcodeAdapter.RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_codigobarras, parent, false); //Inflamos la vista que utilizaremos para las tarjetas del RecyclerView
        return new RecyclerHolder(view); //Retornamos un nuevo objeto de tipo RecyclerHolder (La clase estática de abajo) y le mandamos la vista de la variable "view"
    }

    //Este método se ejecuta las veces que el método "getItemCount" lo indique, o sea, dependiendo del size de la lista "items"
    @Override
    public void onBindViewHolder(@NonNull BarcodeAdapter.RecyclerHolder holder, int position) {
        BarcodeItemsModel item = items.get(position); //Variable de tipo BarcodeItemsModel que obtiene los datos almacenados en la list "items" (un dato de la lista a la vez, dependiendo de la variable "posicion") también de tipo BarcodeItemsModel

        //Haciendo uso del objeto "holder", asignamos el código de barras al hint de la variable de tipo "EditText" que se encuentra en la clase estática "RecyclerHolder"
        holder.txtBarcode.setHint(item.getBarcode());
    }

    @Override
    public int getItemCount() {
        return items.size(); //Retornamos la cantidad de elementos que tiene la lista "items"
    }

    public static class RecyclerHolder extends RecyclerView.ViewHolder {
        private EditText txtBarcode; //Creamos la variable para el único elemento de la tarjeta del RecyclerView (el edittext del código de barras)

        public RecyclerHolder(@NonNull View itemView) { //Método constructor de la clase "RecyclerHolder"
            super(itemView);
            txtBarcode = itemView.findViewById(R.id.txtBarcodeEdit); //Enlazamos la variable de arriba con el elemento edittext de la tarjeta del RecyclerView
        }
    }
}

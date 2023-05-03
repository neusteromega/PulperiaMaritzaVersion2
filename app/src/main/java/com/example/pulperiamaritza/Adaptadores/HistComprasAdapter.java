package com.example.pulperiamaritza.Adaptadores;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pulperiamaritza.Modelos.HistComprasItemsModel;
import com.example.pulperiamaritza.R;

import java.util.List;

public class HistComprasAdapter extends RecyclerView.Adapter<HistComprasAdapter.RecyclerHolder> implements View.OnClickListener {
    private List<HistComprasItemsModel> items; //Creamos una lista de tipo HistComprasItemsModel
    private View.OnClickListener listener; //Creamos un escuchador (listener) de tipo "View.OnClickListener" que nos servirá para el onClick de cada tarjeta del RecyclerView

    public HistComprasAdapter(List<HistComprasItemsModel> items) { //Inicializamos la lista "items" en el método constructor
        this.items = items;
    }

    @NonNull
    @Override
    public HistComprasAdapter.RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_histcompras, parent, false); //Inflamos la vista que utilizaremos para las tarjetas del RecyclerView
        view.setOnClickListener(this);
        return new RecyclerHolder(view); //Retornamos un nuevo objeto de tipo RecyclerHolder (La clase estática de abajo) y le mandamos la vista de la variable "view"
    }

    //Este método se ejecuta las veces que el método "getItemCount" lo indique, o sea, dependiendo del size de la lista "items"
    @Override
    public void onBindViewHolder(@NonNull HistComprasAdapter.RecyclerHolder holder, int position) {
        HistComprasItemsModel item = items.get(position); //Variable de tipo HistComprasItemsModel que obtiene los datos almacenados en la list "items" (un dato de la lista a la vez, dependiendo de la variable "posicion") también de tipo HistComprasItemsModel

        //Haciendo uso del objeto "holder", asignamos los textos a las diferentes variables que se encuentran en la clase estática "RecyclerHolder"
        holder.tvCodigo.setText(item.getCodigo());
        holder.tvVendedor.setText(item.getVendedor());
        holder.tvFecha.setText(item.getFecha());
        holder.tvTotal.setText("L."+ item.getTotal());
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
        private TextView tvCodigo;
        private TextView tvVendedor;
        private TextView tvFecha;
        private TextView tvTotal;

        public RecyclerHolder(@NonNull View itemView) { //Método Constructor que recibe un View
            super(itemView);

            //Referenciamos los elementos de la vista de las tarjetas del RecyclerView a las variables de arriba
            tvCodigo = itemView.findViewById(R.id.lblCodigoCompraHist);
            tvVendedor = itemView.findViewById(R.id.lblVendedorCompraHist);
            tvFecha = itemView.findViewById(R.id.lblFechaCompraHist);
            tvTotal = itemView.findViewById(R.id.lblTotalCompraHist);
        }
    }
}

package com.example.pulperiamaritza.Adaptadores;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.pulperiamaritza.Modelos.CatPrvItemsModel;
import com.example.pulperiamaritza.R;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class CatPrvAdapter extends BaseAdapter {
    private List<CatPrvItemsModel> items;
    private List<CatPrvItemsModel> itemsOriginal;
    private Context context;

    public CatPrvAdapter(List<CatPrvItemsModel> itemsList, Context context) {
        this.items = itemsList;
        itemsOriginal = new ArrayList<>();
        itemsOriginal.addAll(itemsList);
        this.context = context;
    }

    public void filtrado(String txtBuscar) {
        int longitud = txtBuscar.length();

        if (longitud == 0) {
            items.clear();
            items.addAll(itemsOriginal);
        }
        else {
            List<CatPrvItemsModel> coleccion = items.stream()
                    .filter(i -> i.getNombre().toLowerCase().contains(txtBuscar.toLowerCase()))
                    .collect(Collectors.toList());

            items.clear();
            items.addAll(coleccion);
        }

        notifyDataSetChanged();
    }

    @Override
    public int getCount() {
        return items.size();
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
        LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        //Creamos una vista inflada y le metemos el diseño de "categorias_items" para cada casilla del GridView
        View view = inflater.inflate(R.layout.items_catprv, null);
        //View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.categorias_items, viewGroup,false);

        //Enlazamos los componentes del diseño de "categorias_items" a dos variables
        ImageView imageCategorias = view.findViewById(R.id.imgImagenCatPrv);
        TextView tvCategorias = view.findViewById(R.id.lblNombreCatPrv);

        //Asignamos cada origen de imagenCategoria y el texto de nombreCategoria a los dos variables antes declaradas
        imageCategorias.setImageResource(items.get(i).getImagen());
        tvCategorias.setText(items.get(i).getNombre());

        return view;
    }
}

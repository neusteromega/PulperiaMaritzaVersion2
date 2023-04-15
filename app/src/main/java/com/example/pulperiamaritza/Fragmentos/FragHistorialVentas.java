package com.example.pulperiamaritza.Fragmentos;

import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.pulperiamaritza.Adaptadores.HistVentasAdapter;
import com.example.pulperiamaritza.Herramientas.ProductosTodos;
import com.example.pulperiamaritza.Modelos.HistVentasItemsModel;
import com.example.pulperiamaritza.R;

import java.util.ArrayList;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragHistorialVentas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragHistorialVentas extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    RecyclerView rvHistorialVentas;
    List<HistVentasItemsModel> itemsVentas;

    public FragHistorialVentas() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment HistorialVentas.
     */
    // TODO: Rename and change types and number of parameters
    public static FragHistorialVentas newInstance(String param1, String param2) {
        FragHistorialVentas fragment = new FragHistorialVentas();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View vista = inflater.inflate(R.layout.fragment_historial_ventas, container, false);

        ProductosTodos todos = new ProductosTodos(getContext()); //Ponemos el objeto aquí y no de forma global ya que el "getContext()" se genera cuando se crea el fragment, aquí en "onCreateView"
        rvHistorialVentas = vista.findViewById(R.id.rvHistVentas); //Enlazamos el RecyclerView "rvHistVentas" a la variable "rvHistorialVentas"

        rvHistorialVentas.setLayoutManager(new LinearLayoutManager(getContext())); //Usamos "getContext()" y no "this" porque no estamos en un activity, sino en un fragment
        itemsVentas = todos.obtenerVentas();

        if (itemsVentas != null) {
            HistVentasAdapter adapter = new HistVentasAdapter(itemsVentas);
            rvHistorialVentas.setAdapter(adapter);
        }

        return vista;
    }
}
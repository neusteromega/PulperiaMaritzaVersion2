package com.example.pulperiamaritza.Fragmentos;

import android.app.DatePickerDialog;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.DatePicker;
import android.widget.LinearLayout;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pulperiamaritza.Adaptadores.HistVentasAdapter;
import com.example.pulperiamaritza.Herramientas.ProductosTodos;
import com.example.pulperiamaritza.Modelos.HistVentasItemsModel;
import com.example.pulperiamaritza.R;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link FragHistorialVentas#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FragHistorialVentas extends Fragment implements PopupMenu.OnMenuItemClickListener {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private RecyclerView rvHistorialVentas; //Creamos una variable de tipo RecyclerView
    private List<HistVentasItemsModel> itemsVentas; //Creamos una lista de tipo HistVentasItemsModel
    private TextView lblTotalVendido, lblFiltro, lblFechaSeleccionada;
    private LinearLayout lnlFiltrar, lnlSeleccionarFecha;
    private int day, month, year;

    public FragHistorialVentas() {
        // Required empty public constructor
    }

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
        double totalVentas = 0; //Variable para guardar la sumatoria de los totales de las ventas

        View vista = inflater.inflate(R.layout.fragment_historial_ventas, container, false);
        ProductosTodos todos = new ProductosTodos(getContext()); //Ponemos el objeto aquí y no de forma global ya que el "getContext()" se genera cuando se crea el fragment, aquí en "onCreateView"

        //Enlazamos los componentes gráficos del fragment a sus respectivas variables
        rvHistorialVentas = vista.findViewById(R.id.rvHistVentas);
        lblTotalVendido = vista.findViewById(R.id.lblTotalVendidoHVnt);
        lnlFiltrar = vista.findViewById(R.id.LLFiltrar);
        lnlSeleccionarFecha = vista.findViewById(R.id.LLSeleccionar);
        lblFiltro = vista.findViewById(R.id.lblFiltroCalendario);
        lblFechaSeleccionada = vista.findViewById(R.id.lblFechaHVnt);

        rvHistorialVentas.setLayoutManager(new LinearLayoutManager(getContext())); //Usamos "getContext()" y no "this" porque no estamos en un activity, sino en un fragment
        itemsVentas = todos.obtenerVentas(); //Obtenemos los datos de las ventas llamando al método "obtenerVentas()" de la clase ProductosTodos y los guardamos en la lista "itemsVentas"

        if (itemsVentas != null) { //Verificamos que la lista "itemsVentas" no sea nula
            HistVentasAdapter adapter = new HistVentasAdapter(itemsVentas); //Creamos una variable de tipo HistVentasAdapter y le pasamos al método constructor de la clase la lista "itemsVentas"
            rvHistorialVentas.setAdapter(adapter); //Asignamos el adaptador al RecyclerView "rvHistorialVentas"

            for (int i = 0; i < itemsVentas.size(); i++) { //Creamos un for que recorra toda la lista "itemsVentas"
                totalVentas += Double.parseDouble(itemsVentas.get(i).getTotal()); //Vamos sumando y guardando los totales de las ventas en la variable "totalVentas"
            }

            lblTotalVendido.setText("L." + String.format("%.2f", totalVentas)); //Asignamos el totalVentas al elemento lblTotalVendido
        }

        lnlFiltrar.setOnClickListener(new View.OnClickListener() { //Creamos un "setOnClickListener" para que implemente el evento onClick al LinearLayout "lnlFiltrar"
            @Override
            public void onClick(View view) {
                menuFiltrado(view); //Mandamos a llamar al método "menuFiltrado" y le enviamos una vista como parámetro
            }
        });

        lnlSeleccionarFecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarDatePickerDialog();
            }
        });

        return vista;
    }

    public void menuFiltrado(View view) {
        try {
            PopupMenu popup = new PopupMenu(requireContext(), view); //Objeto de tipo "PopupMenu"
            popup.setOnMenuItemClickListener(this); //Indicamos que asigne el evento "OnMenuItemClick" para que haga algo cada vez que se dé click a una opción del menú
            popup.inflate(R.menu.popupmenu_opcionesfiltrado); //Inflamos la vista del menú indicando la ruta de dicha vista gráfica
            popup.show(); //Mostramos el menú ya inflado
        }
        catch (Exception e) {
            Log.e("TagDeLaExcepcion", "Mensaje de la excepción: " + e.getMessage(), e);
        }
    }

    @Override
    public boolean onMenuItemClick(MenuItem menuItem) { //Parte lógica de lo que queremos que haga cada opción del popup menú
        switch (menuItem.getItemId()) { //Switch que responderá dependiendo el id del item que se está clickeando
            case R.id.menuDiaFilt:
                Toast.makeText(getContext(), "Día", Toast.LENGTH_SHORT).show();
                lblFiltro.setText("Día");
                return true;
            case R.id.menuSemanaFilt:
                Toast.makeText(getContext(), "Semana", Toast.LENGTH_SHORT).show();
                lblFiltro.setText("Semana");
                return true;
            case R.id.menuMesFilt:
                Toast.makeText(getContext(), "Mes", Toast.LENGTH_SHORT).show();
                lblFiltro.setText("Mes");
                return true;
            case R.id.menuYearFilt:
                Toast.makeText(getContext(), "Año", Toast.LENGTH_SHORT).show();
                lblFiltro.setText("Año");
                return true;
            default:
                return false;
        }
    }

    private void mostrarDatePickerDialog() {
        final Calendar c = Calendar.getInstance(); //

        year = c.get(Calendar.YEAR); //Obtenemos el año seleccionado
        month = c.get(Calendar.MONTH); //Obtenemos el mes seleccionado
        day = c.get(Calendar.DAY_OF_MONTH); //Obtenemos el día seleccionado

        DatePickerDialog datePickerDialog = new DatePickerDialog(requireContext(), new DatePickerDialog.OnDateSetListener() {
            @Override
            public void onDateSet(DatePicker datePicker, int year, int monthOfYear, int dayOfMonth) {
                lblFechaSeleccionada.setText(String.format("%02d/%02d/%04d", dayOfMonth, monthOfYear + 1, year)); //Asignamos la fecha seleccionada con el formato "00-00-0000" al TextView "lblFechaSeleccionada" y
            }
        }, year, month, day);

        datePickerDialog.show();
    }
}
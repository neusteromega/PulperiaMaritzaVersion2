package com.example.pulperiamaritza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pulperiamaritza.Adaptadores.CarritoAdapter;
import com.example.pulperiamaritza.Modelos.CarritoItemsModel;
import com.example.pulperiamaritza.Herramientas.ProductosTodos;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;

public class CarritoVenta extends AppCompatActivity {

    private RecyclerView rvCarrito;
    private CarritoAdapter adapter;
    private TextView lblSubtotal, lblBolsas, lblBolsasTotal, lblTotal;
    public List<CarritoItemsModel> itemsCarrito;
    private ProductosTodos todos = new ProductosTodos(this);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_carrito_venta);

        lblSubtotal = (TextView) findViewById(R.id.lblSubtotalCar);
        lblBolsas = (TextView) findViewById(R.id.lblCantidadBolsas);
        lblBolsasTotal = (TextView) findViewById(R.id.lblBolsasTotal);
        lblTotal = (TextView) findViewById(R.id.lblTotalCar);

        inicializarVistas();
        inicializarValores();
        subtotalCarrito();
        totalCarrito();
    }

    private void inicializarVistas() {
        rvCarrito = findViewById(R.id.rvCarrito);
    }

    private void inicializarValores() {
        LinearLayoutManager manager = new LinearLayoutManager(this);

        rvCarrito.setLayoutManager(manager);

        itemsCarrito = todos.obtenerCarrito();
        adapter = new CarritoAdapter(itemsCarrito, this);
        rvCarrito.setAdapter(adapter);
    }

    public void subtotalCarrito() {
        double subtotal = 0;
        List<CarritoItemsModel> items = todos.obtenerCarrito();

        for (int i = 0; i < items.size(); i++) {
            subtotal += Double.parseDouble(items.get(i).getTotal());
        }

        /*TextView lblSubtotal;
        lblSubtotal = findViewById(R.id.lblSubtotalCar);*/

        lblSubtotal.setText("L." + String.format("%.2f", subtotal));
    }

    public void totalCarrito() {
        double subtotal = 0;
        double total = 0;
        List<CarritoItemsModel> items = todos.obtenerCarrito();

        for (int i = 0; i < items.size(); i++) {
            subtotal += Double.parseDouble(items.get(i).getTotal());
        }

        total = subtotal + Integer.parseInt(lblBolsas.getText().toString());
        lblTotal.setText("L." + String.format("%.2f", total));
    }

    public void bolsasDisminuir(View view) {
        String cantidadTxt = lblBolsas.getText().toString();
        int cantidadNum = Integer.parseInt(cantidadTxt);

        if (cantidadNum > 0)
            cantidadNum -= 1;

        cantidadTxt = String.valueOf(cantidadNum);

        lblBolsas.setText(cantidadTxt);
        totalBolsas(cantidadNum);
        totalCarrito();
    }

    public void bolsasAumentar(View view) {
        String cantidadTxt = lblBolsas.getText().toString();
        int cantidadNum = Integer.parseInt(cantidadTxt);

        cantidadNum += 1;
        cantidadTxt = String.valueOf(cantidadNum);

        lblBolsas.setText(cantidadTxt);

        totalBolsas(cantidadNum);
        totalCarrito();
    }

    public void totalBolsas(int cantidad) {
        double bolsasTotal = cantidad;

        lblBolsasTotal.setText("L." + String.format("%.2f", bolsasTotal));
    }

    public void confirmarVenta(View view) {
        String bolsasTxt = lblBolsas.getText().toString(); //Guardamos la cantidad de bolsas que se encuentra en el textView "lblBolsas" en una variable String
        int bolsasNum = Integer.parseInt(bolsasTxt); //Convertimos "bolsasTxt" a int, y guardamos el entero en "bolsasNum"

        //Guardar la fecha de hoy
        Calendar calendar = Calendar.getInstance(); //Obtener la fecha actual
        SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MM-yyyy"); //Crear el formato de fecha que deseas
        String fechaActual = dateFormat.format(calendar.getTime()); //Convertir la fecha a un String

        int conf = todos.insertarVenta(fechaActual, bolsasNum); //Usando el objeto "todos" de la clase "ProductosTodos", llamamos al método "insertarVenta" y le mandamos la fecha de hoy (fechaActual) y la cantidad de bolsas (bolsasNum) como parámetros

        if (conf == 1) { //Si "conf" es uno, significa que si se realizó la confirmación de la venta...
            todos.eliminarCarritoCompleto(); //..., por ello, llamamos al método "eliminarCarritoCompleto()" que nos va a borrar los datos de la tabla "CarritoTemporal" y así poder limpiar el carrito de venta
            this.recreate(); //Llamamos al método "recreate()" que recrear el Activity y poder ver el carrito vacío
        }
    }

    public void menuPrincipal(View view) {
        Intent pagina = new Intent(this, MenuPrincipal.class);
        startActivity(pagina);
    }

    public void historial(View view) {
        Intent pagina = new Intent(this, Historial.class);
        startActivity(pagina);
    }
}
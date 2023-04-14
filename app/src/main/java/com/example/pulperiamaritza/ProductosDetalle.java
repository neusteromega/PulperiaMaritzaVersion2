package com.example.pulperiamaritza;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;

import com.example.pulperiamaritza.Herramientas.ProductosTodos;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ProductosDetalle extends AppCompatActivity implements TextWatcher {

    private ImageView imgProducto;
    private TextView lblPrecio, lblNombreProducto, lblCategoria, lblProveedor, lblDatosTitulo, lblTipoProducto, lblTotalProducto;
    private EditText lblCantidad;
    private Switch swCambiar;
    private ProductosTodos todos = new ProductosTodos(this);

    @RequiresApi(api = Build.VERSION_CODES.O)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_productos_detalle);

        imgProducto = findViewById(R.id.imgProductoDet);
        lblPrecio = findViewById(R.id.lblPrecioProductoDet);
        lblNombreProducto = findViewById(R.id.lblNombreProductoDet);
        lblCategoria = findViewById(R.id.lblCategoriaProductoDet);
        lblProveedor = findViewById(R.id.lblProveedorProductoDet);
        lblDatosTitulo = findViewById(R.id.lblTituloDatosDet);
        lblTipoProducto = findViewById(R.id.lblTipoProductoDet);
        lblCantidad = findViewById(R.id.txtCantidadProductoDet);
        lblTotalProducto = findViewById(R.id.lblTotalProductoDet);
        swCambiar = findViewById(R.id.swCambiar);

        lblCantidad.addTextChangedListener(this); // Agregar el TextWatcher al EditText

        Intent intent = getIntent();
        imgProducto.setImageResource(intent.getIntExtra("productoImagen", 0));
        lblPrecio.setText("L." + intent.getStringExtra("productoPrecio"));
        lblNombreProducto.setText(intent.getStringExtra("productoNombre"));
        lblCategoria.setText(intent.getStringExtra("productoCategoria"));
        lblProveedor.setText(intent.getStringExtra("productoProveedor"));

        if (intent.getStringExtra("productoCantidad").contentEquals("1 U")) {
            lblTipoProducto.setText("Unidad");
        }
        else {
            String tipoTexto = intent.getStringExtra("productoCantidad");
            tipoTexto = tipoTexto.replaceAll("[^\\p{L}]", "");
            lblTipoProducto.setText(tipoTexto);
        }

        //Obtener el mes actual
        LocalDate fechaActual = LocalDate.now();
        int mesActual = fechaActual.getMonthValue();
        DateTimeFormatter formatoMes = DateTimeFormatter.ofPattern("MMMM", new Locale("es", "HN"));
        String nombreMes = fechaActual.format(formatoMes);
        nombreMes = nombreMes.substring(0, 1).toUpperCase() + nombreMes.substring(1);

        lblDatosTitulo.setText("Datos del Producto en "+ nombreMes);

        if (intent.getStringExtra("productoCantidad2").contentEquals("0")) {
            swCambiar.setVisibility(View.INVISIBLE);
        }

        String cantidadTxt = lblCantidad.getText().toString();
        int cantidadNum = Integer.parseInt(cantidadTxt);
        calcularTotal(cantidadNum);

        //Toast.makeText(this, intent.getIntExtra("productoImagen", 0), Toast.LENGTH_LONG).show();
    }

    public void carritoVenta(View view) {
        Intent pagina = new Intent(this, CarritoVenta.class);
        startActivity(pagina);
    }

    public void cambiarSwitch(View view) {
        if (view.getId() == R.id.swCambiar) {
            //Validamos que el switch esté activado
            if (swCambiar.isChecked()) {
                Intent intent = getIntent();
                lblPrecio.setText("L." + intent.getStringExtra("productoPrecio2"));

                if (intent.getStringExtra("productoCantidad2").contentEquals("1 U")) {
                    lblTipoProducto.setText("Unidad");
                } else {
                    //Extraemos solo el texto que se encuentra en la segunda cantidad que puede tener el producto
                    String tipoTexto = intent.getStringExtra("productoCantidad2");
                    tipoTexto = tipoTexto.replaceAll("[^\\p{L}]", "");
                    lblTipoProducto.setText(tipoTexto);
                }

                String cantidadTxt = lblCantidad.getText().toString();
                int cantidadNum = Integer.parseInt(cantidadTxt);
                calcularTotal(cantidadNum);
            }
            else { //Aquí el switch no está activado
                Intent intent = getIntent();
                lblPrecio.setText("L." + intent.getStringExtra("productoPrecio"));

                if (intent.getStringExtra("productoCantidad").contentEquals("1 U")) {
                    lblTipoProducto.setText("Unidad");
                } else {
                    //Extraemos solo el texto que se encuentra en la primera cantidad que puede tener el producto
                    String tipoTexto = intent.getStringExtra("productoCantidad");
                    tipoTexto = tipoTexto.replaceAll("[^\\p{L}]", "");
                    lblTipoProducto.setText(tipoTexto);
                }

                String cantidadTxt = lblCantidad.getText().toString();
                int cantidadNum = Integer.parseInt(cantidadTxt);
                calcularTotal(cantidadNum);
            }
        }
    }

    public void productoDisminuir(View view) {
        String cantidadTxt = lblCantidad.getText().toString();
        int cantidadNum = Integer.parseInt(cantidadTxt);

        if (cantidadNum > 1)
            cantidadNum -= 1;

        cantidadTxt = String.valueOf(cantidadNum);

        lblCantidad.setText(cantidadTxt);
        calcularTotal(cantidadNum);
    }

    public void productoAumentar(View view) {
        String cantidadTxt = lblCantidad.getText().toString();
        int cantidadNum = Integer.parseInt(cantidadTxt);

        cantidadNum += 1;
        cantidadTxt = String.valueOf(cantidadNum);

        lblCantidad.setText(cantidadTxt);
        calcularTotal(cantidadNum);
    }

    public void calcularTotal(int cantidad) {
        double total;
        String precioTxt = lblPrecio.getText().toString();

        Intent intent = getIntent();
        String precio1 = intent.getStringExtra("productoPrecio");
        String precio2 = intent.getStringExtra("productoPrecio2");

        if (precioTxt.contains(precio1)) {
            double precioNum = Double.parseDouble(precio1);
            total = cantidad * precioNum;

            lblTotalProducto.setText("L." + String.format("%.2f", total));
        }
        else if (precioTxt.contains(precio2)) {
            double precioNum = Double.parseDouble(precio2);
            total = cantidad * precioNum;

            lblTotalProducto.setText("L." + String.format("%.2f", total));
        }
    }

    public void carrito(View view) {
        String regex = "(?<=L\\.)\\d+\\.\\d+";
        String precio = lblPrecio.getText().toString();
        String resultPrecio = "";
        String total = lblTotalProducto.getText().toString();
        String resultTotal = "";

        Pattern patternPrecio = Pattern.compile(regex);
        Matcher matcherPrecio = patternPrecio.matcher(precio);

        if (matcherPrecio.find())
            resultPrecio = matcherPrecio.group();

        Pattern patternTotal = Pattern.compile(regex);
        Matcher matcherTotal = patternTotal.matcher(total);

        if (matcherTotal.find())
            resultTotal = matcherTotal.group();

        Intent intent = getIntent();
        /*todos.nombreProducto = lblNombreProducto.getText().toString();
        todos.tipoProducto = lblTipoProducto.getText().toString();
        todos.cantidadProducto = lblCantidad.getText().toString();
        todos.precioProducto = resultPrecio;
        todos.totalProducto = resultTotal;
        todos.imagenProducto = intent.getIntExtra("productoImagen", 0);*/

        //insertarDatosCarrito(resultPrecio, resultTotal, intent.getIntExtra("productoImagen", 0));
        todos.insertarDatosCarrito(lblNombreProducto.getText().toString(), lblTipoProducto.getText().toString(), lblCantidad.getText().toString(), resultPrecio, resultTotal, intent.getIntExtra("productoImagen", 0));
    }

    //Antes de que el texto del Edittext cambie
    @Override
    public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    //Durante el texto del Edittext está cambiando
    @Override
    public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

    }

    //Después de que el texto del Edittext cambie
    @Override
    public void afterTextChanged(Editable editable) {
        //Cuando detecte que el Edittext está vacío, que asigne un 0
        String text = editable.toString().trim();
        if (text.isEmpty()) {
            editable.append("0");
        }

        calcularTotal(Integer.parseInt(editable.toString()));
    }
}
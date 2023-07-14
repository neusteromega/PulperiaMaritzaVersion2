package com.example.pulperiamaritza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pulperiamaritza.Herramientas.ProductosTodos;
import com.example.pulperiamaritza.Modelos.ProductoItemsModel;
import com.google.zxing.integration.android.IntentIntegrator;
import com.google.zxing.integration.android.IntentResult;

import java.util.List;

public class MenuPrincipal extends AppCompatActivity {

    ProductosTodos todos = new ProductosTodos(this);
    TextView scan;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu_principal);

        scan = (TextView) findViewById(R.id.barras);

        //Obtenemos la lista de los productos en la BDD
        List<ProductoItemsModel> items = todos.obtenerProductosBDD();

        //Mandamos a llamar el método "insertarDatos" solamente si el tamaño de la lista "items" es de 204, si es mayor, significa que ya se insertó la segunda porción de productos
        if (items.size() == 204)
            todos.insertarDatos("Productos", 2); //Le mandamos el nombre de la tabla "Productos" y el número 2 para indicar que se debe insertar la segunda lista de productos
    }

    public void consultarProductos(View view) {
        Intent pagina = new Intent(this, ConsultarTodo.class);
        startActivity(pagina);
    }

    public void insertarNuevo(View view) {
        Intent pagina = new Intent(this, InsertarNuevo.class);
        startActivity(pagina);
    }

    public void carritoVenta(View view) {
        Intent pagina = new Intent(this, CarritoCompra.class);
        startActivity(pagina);
    }

    public void historial(View view) {
        Intent pagina = new Intent(this, Historial.class);
        startActivity(pagina);
    }

    public void facturar(View view) {
        try {
            //Hacemos esto para abrir el escaneo
            IntentIntegrator integrador = new IntentIntegrator(MenuPrincipal.this); //Objeto integrador para pasar algunas actividades personalizables al lector de códigos de barras
            integrador.setDesiredBarcodeFormats(IntentIntegrator.ALL_CODE_TYPES); //Con esto seleccionamos el tipo de código a utilizar, en este caso seleccionamos que abarque todos los tipos
            integrador.setPrompt("Escanee el Código de Barras"); //Titulo que aparecerá en el lector
            integrador.setCameraId(0); //Indicamos que cámara utilizará, ponemos 0 para referenciar la cámara trasera del celular
            integrador.setBeepEnabled(true); //Activamos con "true" el sonido de beep para saber cuando se haya registrado el código de barras
            integrador.setBarcodeImageEnabled(true);
            integrador.setTorchEnabled(true); //Activar el flash
            integrador.initiateScan(); //Esto es para que inicie el escaneo
        }
        catch (Exception e) { //Capturamos la excepción por cualquier cosa
            Log.e("MiTag", "Error al abrir la cámara para escanear", e);
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        IntentResult result = IntentIntegrator.parseActivityResult(requestCode, resultCode, data); //Aquí guardamos el resultado del escaneo

        if (result != null) { //Comparamos si el result no es nulo, por lo tanto, si está retornando información
            if (result.getContents() == null) { //Si cancelamos el proceso, o sea es nulo, entoncemos enviamos una alerta con un Toast
                Toast.makeText(this, "Escaneo Cancelado", Toast.LENGTH_LONG).show(); //Mostramos un mensaje para indicar que el escaneo fue cancelado
            }
            else {
                Toast.makeText(this, result.getContents(), Toast.LENGTH_SHORT).show(); //result.getContents() muestra el código que se escaneó
                scan.setText(result.getContents()); //Guardamos el código escaneado en el TextView "scan"
            }
        }
        else {
            super.onActivityResult(requestCode, resultCode, data);
        }
    }
}
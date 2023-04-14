package com.example.pulperiamaritza;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.pulperiamaritza.Fragmentos.FragHistorialCompras;
import com.example.pulperiamaritza.Fragmentos.FragHistorialVentas;

public class Historial extends AppCompatActivity {

    private TextView btnVentas, btnCompras, lnaVentas, lnaCompras;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_historial);

        btnVentas = (TextView) findViewById(R.id.btnHistVentas);
        btnCompras = (TextView) findViewById(R.id.btnHistCompras);
        lnaVentas = (TextView) findViewById(R.id.lblHistVentasLinea);
        lnaCompras = (TextView) findViewById(R.id.lblHistComprasLinea);

        btnCompras.setTextColor(getResources().getColor(R.color.blue_secundario));
        btnVentas.setTextColor(getResources().getColor(R.color.blue_principal));
        lnaCompras.setVisibility(View.INVISIBLE);
    }

    public void fragHistCompras(View view) {
        FragHistorialCompras fragCompras = new FragHistorialCompras(); //Objeto para referenciar el fragmento del historial de compras
        FragmentTransaction fragTransaction = getSupportFragmentManager().beginTransaction(); //Creamos un objeto de tipo "FragmentTransaction" que recibe un Manager de Fragment y comienza la transacción (por decirlo así) con "beginTransaction()"
        fragTransaction.replace(R.id.fragHistorial, fragCompras); //Hacemos un reemplazo en el contenedor del fragment (fragHistorial) por el "fragCompras"
        fragTransaction.commit(); //Esto es para que se guarden los cambios
        btnCompras.setTextColor(getResources().getColor(R.color.blue_principal));
        btnVentas.setTextColor(getResources().getColor(R.color.blue_secundario));
        lnaCompras.setVisibility(View.VISIBLE);
        lnaVentas.setVisibility(View.INVISIBLE);
    }

    public void fragHistVentas(View view) {
        FragHistorialVentas fragVentas = new FragHistorialVentas(); //Objeto para referenciar el fragmento del historial de ventas
        FragmentTransaction fragTransaction = getSupportFragmentManager().beginTransaction(); //Creamos un objeto de tipo "FragmentTransaction" que recibe un Manager de Fragment y comienza la transacción (por decirlo así) con "beginTransaction()"
        fragTransaction.replace(R.id.fragHistorial, fragVentas); //Hacemos un reemplazo en el contenedor del fragment (fragHistorial) por el "fragVentas"
        fragTransaction.commit(); //Esto es para que se guarden los cambios
        btnCompras.setTextColor(getResources().getColor(R.color.blue_secundario));
        btnVentas.setTextColor(getResources().getColor(R.color.blue_principal));
        lnaCompras.setVisibility(View.INVISIBLE);
        lnaVentas.setVisibility(View.VISIBLE);
    }
}
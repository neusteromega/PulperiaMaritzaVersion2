package com.example.pulperiamaritza;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.pulperiamaritza.Herramientas.AdminSQLiteOpen;

public class Perfil extends AppCompatActivity {

    private TextView lblNombre, lblCorreo, lblTelefono, lblContra;
    private ImageView imgContra;
    public static int idUsuario; //Variable estática que recibirá el ID del usuario justo cuando este inicie sesión
    private static String contraUsuario; //Variable estática que recibirá la contraseña del usuario desde el método "mostrarDatos()"
    private int cantidadClicks = 0; //Se utilizará en la parte de ocultar la contraseña

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_perfil);

        lblNombre = (TextView) findViewById(R.id.lblNombrePerfil);
        lblCorreo = (TextView) findViewById(R.id.lblCorreoPerfil);
        lblTelefono = (TextView) findViewById(R.id.lblTelefonoPerfil);
        lblContra = (TextView) findViewById(R.id.lblContraPerfil);
        imgContra = (ImageView) findViewById(R.id.imgVerContraPerfil);

        mostrarDatos();
    }

    private void mostrarDatos() {
        //Creamos un objeto de la clase AdminSQLiteOpen y le mandamos los parámetros al constructor de dicha clase.
        AdminSQLiteOpen admin = new AdminSQLiteOpen(this, "PulperiaMaritza", null, 1);
        SQLiteDatabase baseDatos = admin.getWritableDatabase();

        try {
            //Creamos un cursor llamado "datos" con el cual podemos ejecutar la instrucción SELECT que me busque el nombre y apellido, correo, teléfono y contraseña del usuario usando el ID del mismo
            Cursor datos = baseDatos.rawQuery("SELECT UsuNombreApellido, UsuCorreo, UsuTelefono, UsuContrasena FROM Usuarios WHERE UsuID = " + idUsuario, null);

            if (datos.moveToFirst()) { //Utilizamos el "if (datos.moveToFirst())" para mover el cursor "datos" a la primera fila de registros que encontró en la sentencia SELECT, sino encontró registros, no entrará a este if
                //Asignamos a los TextViews los datos del usuario extraídos en el cursor "datos"
                lblNombre.setText(datos.getString(0));
                lblCorreo.setText(datos.getString(1));
                lblTelefono.setText(datos.getString(2));
                lblContra.setText(datos.getString(3));

                contraUsuario = datos.getString(3); //Guardamos la contraseña del usuario en la variable global estática "contraUsuario"
                ocultarContra(); //Llamamos al método "ocultarContra()" para que nos oculte la contraseña al cargar el activity
            }
        }
        catch (Exception e) {
            Toast.makeText(this, "ERROR AL OBTENER EL PERFIL", Toast.LENGTH_SHORT).show();
        }
        finally {
            if (baseDatos != null) { //Verificamos si "baseDatos" no es null para poder cerrar la conexión
                baseDatos.close();
            }
        }
    }

    public void ocultarContraClick(View view) { //Cuando demos click en el bóton del ojo para mostrar/ocultar contraseña, nos mandará a este método
        ocultarContra();
    }

    private void ocultarContra() {
        //En este if verificamos si la variable "cantidadClicks" es divisible entre 2 y si al realizar la división su residuo es 0
        if (cantidadClicks % 2 == 0) { //La cantidad de clicks al principio es 0 (Lo inicializamos en 0 arriba),
            //Si el residuo del número de "cantidadClicks" al dividirlo entre 2 es 0, se ocultará la contraseña y se mostrará el icono del ojo
            lblContra.setText("********");
            imgContra.setImageResource(R.mipmap.icono_showcontraazul);
        }
        else {
            //Si el residuo del número de "cantidadClicks" al dividirlo entre 2 no es 0, se mostrará la contraseña y también el icono cambiará al ojo tachado
            lblContra.setText(contraUsuario);
            imgContra.setImageResource(R.mipmap.icono_hidecontrazul);
        }

        cantidadClicks++; //Aquí vamos aumentando la cantidad de clicks cada vez que se entre a la función
    }
}
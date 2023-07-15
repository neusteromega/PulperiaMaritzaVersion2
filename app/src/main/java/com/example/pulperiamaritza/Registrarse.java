package com.example.pulperiamaritza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pulperiamaritza.Herramientas.AdminSQLiteOpen;

public class Registrarse extends AppCompatActivity {

    private EditText txtNombreApellido, txtTelefono, txtCorreo, txtContra, txtConfContra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrarse);

        txtNombreApellido = (EditText) findViewById(R.id.txtNombreRegistrarse);
        txtTelefono = (EditText) findViewById(R.id.txtTelefonoRegistrarse);
        txtCorreo = (EditText) findViewById(R.id.txtCorreoRegistrarse);
        txtContra = (EditText) findViewById(R.id.txtContraRegistrarse);
        txtConfContra = (EditText) findViewById(R.id.txtConfContraRegistrarse);
    }

    public void iniciarSesion(View view) {
        Intent pagina = new Intent(this, IniciarSesion.class);
        startActivity(pagina);
    }

    public void registro(View view) {
        //Creamos un objeto de la clase AdminSQLiteOpen y le mandamos los parámetros al constructor de dicha clase
        AdminSQLiteOpen admin = new AdminSQLiteOpen(this, "PulperiaMaritza", null, 1);
        SQLiteDatabase baseDatos = admin.getWritableDatabase();

        //Enlazamos los EditText con las variables String
        String nombreApellido = txtNombreApellido.getText().toString();
        String telefono = txtTelefono.getText().toString();
        String correo = txtCorreo.getText().toString();
        String contra = txtContra.getText().toString();
        String confContra = txtConfContra.getText().toString();

        if (!nombreApellido.isEmpty() && !telefono.isEmpty() && !correo.isEmpty() && !contra.isEmpty() && !confContra.isEmpty()) { //Si las cajas de texto no están vacías, que entre al if
            if (confContra.contentEquals(contra)) { //Si los campos de contraseña y confirmar contraseña no coinciden, no podrá entrar al if
                ContentValues usuario = new ContentValues(); //Creamos un contenedor que almacenará los datos a insertar en la base de datos

                //Guardamos los datos en cada campo de la tabla de la base de datos
                usuario.put("UsuNombreApellido", nombreApellido);
                usuario.put("UsuCorreo", correo);
                usuario.put("UsuTelefono", telefono);
                usuario.put("UsuContrasena", contra);
                usuario.put("RolID", 1);

                //Realizamos la inserción de los datos especificando el nombre de la tabla, y al final, colocamos el ContentValues "usuario"
                long id = baseDatos.insert("Usuarios", null, usuario);
                baseDatos.close();

                if (id > 0) { //Si "id" recibió un valor mayor que 0, significa que se realizó correctamente la inserción de datos
                    Toast.makeText(this, "REGISTRO CONFIRMADO", Toast.LENGTH_SHORT).show();

                    /*txtNombreApellido.setText("");
                    txtTelefono.setText("");
                    txtCorreo.setText("");
                    txtContra.setText("");
                    txtConfContra.setText("");*/

                    Intent pagina = new Intent(this, IniciarSesion.class);
                    startActivity(pagina);
                }
                else {
                    Toast.makeText(this, "ERROR AL REGISTRARSE", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(this, "LAS CONTRASEÑAS NO COINCIDEN", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "TODOS LOS CAMPOS DEBEN LLENARSE", Toast.LENGTH_SHORT).show();
        }
    }
}
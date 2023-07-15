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

public class EditarPerfil extends AppCompatActivity {

    private EditText txtNombreApellido, txtTelefono, txtCorreo, txtContra, txtConfContra;
    public static int idUsuario; //Variable global estática que recibe el ID del usuario desde la pantalla de Perfil

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_editar_perfil);

        txtNombreApellido = (EditText) findViewById(R.id.txtNombreRegistrarse);
        txtTelefono = (EditText) findViewById(R.id.txtTelefonoRegistrarse);
        txtCorreo = (EditText) findViewById(R.id.txtCorreoRegistrarse);
        txtContra = (EditText) findViewById(R.id.txtContraRegistrarse);
        txtConfContra = (EditText) findViewById(R.id.txtConfContraRegistrarse);
    }

    public void modificar(View view) {
        //Creamos un objeto de la clase AdminSQLiteOpen y le mandamos los parámetros al constructor de dicha clase
        AdminSQLiteOpen admin = new AdminSQLiteOpen(this, "PulperiaMaritza", null, 1);
        SQLiteDatabase baseDatos = admin.getWritableDatabase();

        //Enlazamos los EditText con las variables String
        String nombreApellido = txtNombreApellido.getText().toString();
        String telefono = txtTelefono.getText().toString();
        String correo = txtCorreo.getText().toString();
        String contra = txtContra.getText().toString();
        String confContra = txtConfContra.getText().toString();

        if (!nombreApellido.isEmpty() || !telefono.isEmpty() || !correo.isEmpty() || !contra.isEmpty() || !confContra.isEmpty()) {
            if (confContra.contentEquals(contra)) {
                try {
                    ContentValues usuario = new ContentValues();
                    int cant = 0;

                    if (!nombreApellido.isEmpty()) {
                        usuario.put("UsuNombreApellido", nombreApellido);
                    }

                    if (!telefono.isEmpty()) {
                        usuario.put("UsuTelefono", telefono);
                    }

                    if (!correo.isEmpty()) {
                        usuario.put("UsuCorreo", correo);
                    }

                    if (!contra.isEmpty()) {
                        usuario.put("UsuContrasena", contra);
                    }

                    if (usuario.size() > 0)
                        cant = baseDatos.update("Usuarios", usuario, "UsuID = " + idUsuario, null);

                    baseDatos.close();

                    if (cant == 1) {
                        Toast.makeText(this, "DATOS ACTUALIZADOS", Toast.LENGTH_SHORT).show();
                        Intent pagina = new Intent(this, Perfil.class);
                        startActivity(pagina);
                    } else {
                        Toast.makeText(this, "ERROR AL ACTUALIZAR", Toast.LENGTH_SHORT).show();
                    }
                }
                catch (Exception e) {
                    Toast.makeText(this, "ERROR EN LA BASE DE DATOS", Toast.LENGTH_SHORT).show();
                }
            }
            else {
                Toast.makeText(this, "LAS CONTRASEÑAS NO COINCIDEN", Toast.LENGTH_SHORT).show();
            }
        }
        else {
            Toast.makeText(this, "NO PUEDE DEJAR TODOS LOS CAMPOS VACÍOS", Toast.LENGTH_SHORT).show();
        }
    }
}
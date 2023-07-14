package com.example.pulperiamaritza;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.pulperiamaritza.Herramientas.AdminSQLiteOpen;

public class IniciarSesion extends AppCompatActivity {

    private EditText txtCorreo, txtContra;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_iniciar_sesion);

        txtCorreo = (EditText) findViewById(R.id.txtCorreoLogin);
        txtContra = (EditText) findViewById(R.id.txtContrasenaLogin);
    }

    public void registrarse(View view) {
        Intent pagina = new Intent(this, Registrarse.class);
        startActivity(pagina);
    }

    public void consultarCredenciales (View view) {
        AdminSQLiteOpen admin = new AdminSQLiteOpen(this, "PulperiaMaritza", null, 1);
        SQLiteDatabase baseDatos = admin.getWritableDatabase();

        String correo = txtCorreo.getText().toString();
        String contra = txtContra.getText().toString();

        if (!correo.isEmpty() && !contra.isEmpty()) { //Si las cajas de texto no están vacías, que entre al if
            try {
                //Creamos un cursor llamado "fila" con el cual podemos ejecutar la instrucción SELECT que me busque el correo, contraseña y ID de rol usando el correo ingresado por el usuario
                Cursor fila = baseDatos.rawQuery("SELECT UsuID, UsuCorreo, UsuContrasena, RolID FROM Usuarios WHERE UsuCorreo = '" + correo + "'", null);

                if (fila.moveToFirst()) { //Utilizamos el "if (fila.moveToFirst())" para mover el cursor "fila" a la primera fila de registros que encontró en la sentencia SELECT, sino encontró registros, no entrará a este if
                    if (fila.getString(2).contentEquals(contra)) { //Una vez entremos al if, verificamos que la contraseña del usuario sea la correspondiente al correo ingresado por el mismo
                        if (fila.getInt(3) == 1) { //Comprobamos el rol del usuario que está iniciando sesión, si el ID del rol es 1, significa que es un cliente, entonces lo mandamos a la pantalla donde puede consultar todos los productos, categorias y proveedores
                            Perfil perfil = new Perfil(); //Creamos un objeto de la clase "Perfil"
                            perfil.idUsuario = fila.getInt(0); //Enviamos el ID del usuario que está iniciando sesión a la variable estática "idUsuario"

                            Intent pagina = new Intent(this, ConsultarTodo.class);
                            startActivity(pagina);
                        }
                        else { //Pero el rol del usuario que está iniciando sesión no es 1, significa que será 2, por lo tanto es un empleado, por ello, se le redigirá a la pantalla de menú principal
                            Perfil perfil = new Perfil(); //Creamos un objeto de la clase "Perfil"
                            perfil.idUsuario = fila.getInt(0); //Enviamos el ID del usuario que está iniciando sesión a la variable estática "idUsuario"

                            Intent pagina = new Intent(this, MenuPrincipal.class);
                            startActivity(pagina);
                        }
                    }
                    else {
                        Toast.makeText(this, "CONTRASEÑA INCORRECTA", Toast.LENGTH_SHORT).show();
                    }
                }
                else {
                    Toast.makeText(this, "NO SE ENCONTRÓ EL CORREO ELECTRÓNICO", Toast.LENGTH_SHORT).show();
                }
            }
            catch (Exception e) {
                Toast.makeText(this, "ERROR AL OBTENER LAS CREDENCIALES", Toast.LENGTH_SHORT).show();
            }
            finally {
                if (baseDatos != null) { //Verificamos si "baseDatos" no es null para poder cerrar la conexión
                    baseDatos.close();
                }
            }
        }
        else {
            Toast.makeText(this, "TODOS LOS CAMPOS DEBEN LLENARSE", Toast.LENGTH_SHORT).show();
        }
    }
}
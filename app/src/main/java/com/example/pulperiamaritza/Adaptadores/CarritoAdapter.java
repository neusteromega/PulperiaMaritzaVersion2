package com.example.pulperiamaritza.Adaptadores;

import android.content.Context;
import android.content.DialogInterface;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AlertDialog;
import androidx.recyclerview.widget.RecyclerView;

import com.example.pulperiamaritza.CarritoCompra;
import com.example.pulperiamaritza.Modelos.CarritoItemsModel;
import com.example.pulperiamaritza.Herramientas.ProductosTodos;
import com.example.pulperiamaritza.R;

import java.util.List;

public class CarritoAdapter extends RecyclerView.Adapter<CarritoAdapter.RecyclerHolder> {
    List<CarritoItemsModel> items; //Creamos una lista de tipo CarritoItemsModel
    Context context;

    public CarritoAdapter(List<CarritoItemsModel> items, Context context) { //Inicializamos la lista "items" en el método constructor
        this.items = items;
        this.context = context;
    }

    @NonNull
    @Override
    public RecyclerHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.items_carrito, parent, false); //Inflamos la vista que utilizaremos para las tarjetas del RecyclerView
        return new RecyclerHolder(view); //Retornamos un nuevo objeto de tipo RecyclerHolder (La clase estática de abajo) y le mandamos la vista de la variable "view"
    }

    //Este método se ejecuta las veces que el método "getItemCount" lo indique, o sea, dependiendo del size de la lista "items"
    @Override
    public void onBindViewHolder(@NonNull RecyclerHolder holder, int position) {
        CarritoItemsModel item = items.get(position); //Variable de tipo CarritoItemsModel que obtiene los datos almacenados en la list "items" (un dato de la lista a la vez, dependiendo de la variable "posicion") también de tipo CarritoItemsModel

        //Pasamos los datos guardados en la lista "item" de tipo CarritoItemsModel a los distintos elementos de cada tarjeta del RecyclerView
        holder.imgProducto.setImageResource(item.getImagen());
        holder.tvProducto.setText(item.getNombre());
        holder.tvTipo.setText(item.getTipo() + ":");
        holder.tvCantidad.setText(item.getCantidad());
        holder.tvPrecioUnitario.setText("L."+ item.getPrecio());
        holder.tvTotal.setText("L."+ item.getTotal());

        holder.imgQuitar.setOnClickListener(new View.OnClickListener() { //Implementamos un "setOnClickListener" al "imgQuitar" para que se realice una acción al momento que se le dé clic a la imagen de la "x" que hay en cada tarjeta del RecyclerView
            @Override
            public void onClick(View view) {
                //Creamos un nuevo "AlertDialog" que nos pregunte si deseamos eliminar el producto seleccionado del carrito
                new AlertDialog.Builder(context).setTitle("ELIMINAR PRODUCTO").setMessage("¿Está seguro que desea eliminar el producto del carrito?")
                    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() { //Aquí se ejecutará una acción si el usuario seleccionó la opción de "Confirmar"
                        public void onClick(DialogInterface dialogInterface, int i) { //Es un "onClick" ya que estamos dando clic al botón de "Confirmar" que se muestra en la ventana emergente
                            ProductosTodos todos = new ProductosTodos(context); //Objeto de la clase "ProductosTodos" y le mandamos un context como parámetro
                            todos.eliminarDatosCarrito(item.getNombre()); //Referenciamos el método "eliminarDatosCarrito" que como su nombre lo dice, elimina el elemento seleccionado de la tabla "CarritoTemporal" que está en la BDD, y para ello le mandamos como parámetro el nombre del producto a eliminar

                            /*Intent intent = new Intent(context, CarritoVenta.class);
                            context.startActivity(intent);*/

                            if (context instanceof CarritoCompra) { //Verificamos si el context es una instancia de un Activity
                                CarritoCompra carrito = (CarritoCompra) context; //Objeto de la clase "CarritoVenta" que lo igualamos a un context que convertimos a un objeto "Activity" de la clase "CarritoVenta"
                                carrito.recreate(); //Llamamos al método "recreate()" que recrear el Activity
                            }
                        }
                    }).setNegativeButton(android.R.string.no, new DialogInterface.OnClickListener() { //Aquí se ejecutará una acción si el usuario seleccionó la opción de "Cancelar"
                        public void onClick(DialogInterface dialogInterface, int i) { //Aquí también es un "onClick" ya que estamos dando clic al botón de "Cancelar" que se muestra en la ventana emergente
                            Log.d("Mensaje", "Se canceló la acción"); //Como se canceló la eliminación del producto del carrito, se muestra un mensaje en el Logcat indicando que se canceló la acción
                        }
                }).show();
            }
        });

        holder.tvCantidad.addTextChangedListener(new TextWatcher() { //Implementamos un "addTextChangedListener" al "tvCantidad" para capturar cada vez que el o los números del EditText de Cantidad cambien
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) { //Antes de que el texto del Edittext cambie

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) { //Durante el texto del Edittext está cambiando

            }

            @Override
            public void afterTextChanged(Editable editable) { //Después de que el texto del Edittext cambie
                //Cuando detecte que el Edittext está vacío, que asigne un 0
                String text = editable.toString().trim();
                if (text.isEmpty()) {
                    editable.append("0");
                }

                //Calculamos el total del producto creando una variable double llamada "total" la cual almacena la multiplicación entre el precio "item.getPrecio()" y la cantidad del producto "editable.toString()". Como el precio y la cantidad son String, los convertimos a double e Integer respectivamente
                double total = Double.parseDouble(item.getPrecio()) * Integer.parseInt(editable.toString());
                holder.tvTotal.setText("L." + String.format("%.2f", total)); //Asignamos el total al "tvTotal". Ponemos un "L." que indica que son lempiras y lo concatenamos a la variable "total" que utiliza un "String.format" para asegurar que tenga dos valores después del punto decimal

                ProductosTodos todos = new ProductosTodos(context); //Objeto de la clase "ProductosTodos" y le mandamos un context como parámetro
                todos.actualizarDatosCarrito(holder.tvProducto.getText().toString(), editable.toString(), String.format("%.2f", total)); //Referenciamos el método "actualizarDatosCarrito" que me actualiza los campos de cantidad y total en la tabla "CarritoTemporal" de la BDD

                CarritoCompra carrito = (CarritoCompra) context; //Objeto de la clase "CarritoVenta" que lo igualamos a un context que convertimos a un objeto "Activity" de la clase "CarritoVenta"
                carrito.subtotalCarrito(); //Llamamos al método "subtotalCarrito" que calcula el subtotal
                carrito.totalCarrito(); //Llamamos al método "totalCarrito" que calcula el total
            }
        });

        holder.tvMenos.setOnClickListener(new View.OnClickListener() { //Implementamos un "setOnClickListener" al "tvMenos" que nos indica cuando se da clic al botón para reducir la cantidad del producto en el carrito
            @Override
            public void onClick(View view) {
                String cantidadTxt = holder.tvCantidad.getText().toString(); //Variable String que guarda la cantidad actual
                int cantidadNum = Integer.parseInt(cantidadTxt); //Convertimos la cantidad a un entero

                if (cantidadNum > 1) //Verificamos que la cantidad no pueda ser menor a un 1
                    cantidadNum -= 1; //Restamos un valor a la cantidad

                cantidadTxt = String.valueOf(cantidadNum); //Convertimos la nueva cantidad a String

                holder.tvCantidad.setText(cantidadTxt); //Asignamos el String de la nueva cantidad al "tvCantidad"

                double total = Double.parseDouble(item.getPrecio()) * cantidadNum; //Calculamos el total del producto creando una variable double llamada "total" la cual almacena la multiplicación entre el precio "item.getPrecio()" y la cantidad del producto "cantidadNum". Como el precio es String, lo convertimos a double
                holder.tvTotal.setText("L." + String.format("%.2f", total)); //Asignamos el total al "tvTotal". Ponemos un "L." que indica que son lempiras y lo concatenamos a la variable "total" que utiliza un "String.format" para asegurarnos que tenga dos valores después del punto decimal

                ProductosTodos todos = new ProductosTodos(context); //Objeto de la clase "ProductosTodos" y le mandamos un context como parámetro
                todos.actualizarDatosCarrito(holder.tvProducto.getText().toString(), cantidadTxt, String.format("%.2f", total)); //Referenciamos el método "actualizarDatosCarrito" que me actualiza los campos de cantidad y total en la tabla "CarritoTemporal" de la BDD

                CarritoCompra carrito = (CarritoCompra) context; //Objeto de la clase "CarritoVenta" que lo igualamos a un context que convertimos a un objeto "Activity" de la clase "CarritoVenta"
                carrito.subtotalCarrito(); //Llamamos al método "subtotalCarrito" que calcula el subtotal
                carrito.totalCarrito(); //Llamamos al método "totalCarrito" que calcula el total
            }
        });

        holder.tvMas.setOnClickListener(new View.OnClickListener() { //Implementamos un "setOnClickListener" al "tvMas" que nos indica cuando se da clic al botón para aumentar la cantidad del producto en el carrito
            @Override
            public void onClick(View view) {
                String cantidadTxt = holder.tvCantidad.getText().toString(); //Variable String que guarda la cantidad actual
                int cantidadNum = Integer.parseInt(cantidadTxt); //Convertimos la cantidad a un entero

                cantidadNum += 1; //Aumentamos un valor a la cantidad
                cantidadTxt = String.valueOf(cantidadNum); //Convertimos la nueva cantidad a String

                holder.tvCantidad.setText(cantidadTxt); //Asignamos el String de la nueva cantidad al "tvCantidad"

                double total = Double.parseDouble(item.getPrecio()) * cantidadNum; //Calculamos el total del producto creando una variable double llamada "total" la cual almacena la multiplicación entre el precio "item.getPrecio()" y la cantidad del producto "cantidadNum". Como el precio es String, lo convertimos a double
                holder.tvTotal.setText("L." + String.format("%.2f", total)); //Asignamos el total al "tvTotal". Ponemos un "L." que indica que son lempiras y lo concatenamos a la variable "total" que utiliza un "String.format" para asegurarnos que tenga dos valores después del punto decimal

                ProductosTodos todos = new ProductosTodos(context); //Objeto de la clase "ProductosTodos" y le mandamos un context como parámetro
                todos.actualizarDatosCarrito(holder.tvProducto.getText().toString(), cantidadTxt, String.format("%.2f", total)); //Referenciamos el método "actualizarDatosCarrito" que me actualiza los campos de cantidad y total en la tabla "CarritoTemporal" de la BDD

                CarritoCompra carrito = (CarritoCompra) context; //Objeto de la clase "CarritoVenta" que lo igualamos a un context que convertimos a un objeto "Activity" de la clase "CarritoVenta"
                carrito.subtotalCarrito(); //Llamamos al método "subtotalCarrito" que calcula el subtotal
                carrito.totalCarrito(); //Llamamos al método "totalCarrito" que calcula el total
            }
        });
    }

    @Override //Retorna el tamaño de la lista "items"
    public int getItemCount() {
        return items.size();
    }

    public static class RecyclerHolder extends RecyclerView.ViewHolder {
        //Creamos variables para los elementos de la tarjeta del RecyclerView
        private ImageView imgProducto;
        private TextView tvProducto;
        private TextView tvTipo;
        private EditText tvCantidad;
        private TextView tvPrecioUnitario;
        private TextView tvTotal;
        private TextView imgQuitar;
        private TextView tvMenos;
        private TextView tvMas;

        public RecyclerHolder(@NonNull View itemView) { //Método constructor de la clase "RecyclerHolder"
            super(itemView);

            //Enlazamos las variables de arriba a los elementos de la tarjeta del RecyclerView
            imgProducto = itemView.findViewById(R.id.imgProductoCar);
            tvProducto = itemView.findViewById(R.id.lblNombreProductoCar);
            tvTipo = itemView.findViewById(R.id.lblTipoProductoCar);
            tvCantidad = itemView.findViewById(R.id.txtCantidadCar);
            tvPrecioUnitario = itemView.findViewById(R.id.lblPrecioUnitarioCar);
            tvTotal = itemView.findViewById(R.id.lblTotalProductoCar);
            imgQuitar = itemView.findViewById(R.id.btnEliminarProductoCar);
            tvMenos = itemView.findViewById(R.id.btnMenosCar);
            tvMas = itemView.findViewById(R.id.btnMasCar);
        }
    }
}

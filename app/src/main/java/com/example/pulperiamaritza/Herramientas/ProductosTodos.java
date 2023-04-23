package com.example.pulperiamaritza.Herramientas;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.widget.Toast;

import com.example.pulperiamaritza.Modelos.CarritoItemsModel;
import com.example.pulperiamaritza.Modelos.CatPrvItemsModel;
import com.example.pulperiamaritza.Modelos.HistVentasItemsModel;
import com.example.pulperiamaritza.Modelos.ProductoItemsModel;
import com.example.pulperiamaritza.R;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;


public class ProductosTodos extends AppCompatActivity {

    public Context context;

    public ProductosTodos(Context context) {
        this.context = context;
    }

    public int verificarDatos(String tabla) {
        //Creamos un objeto de la clase AdminSQLiteOpen y le mandamos los parámetros al constructor de dicha clase
        AdminSQLiteOpen admin = new AdminSQLiteOpen(context, "PulperiaMaritza", null, 1);
        SQLiteDatabase baseDatos = admin.getWritableDatabase();

        //Creamos un cursor llamado "fila" con el cual podemos ejecutar la instrucción SELECT
        Cursor fila = baseDatos.rawQuery("SELECT * FROM "+ tabla, null);

        //Comprobamos si "fila" tiene valores, si los tiene retornará un 1, si no los tiene retornará un 0
        if (fila == null || !fila.moveToFirst()) {
            return 0;
        }
        else {
            return 1;
        }
    }

    public List<ProductoItemsModel> obtenerProductos() {
        List<ProductoItemsModel> itemsList = new ArrayList<>();

        //Refrescos
        itemsList.add(new ProductoItemsModel("Coca Cola 500 ml", "0", "Refrescos", "1 U", "0", "20.00", "0", R.mipmap.ref_cocacola_500ml, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Coca Cola 1.1 lts", "0", "Refrescos", "1 U", "0", "27.00", "0", R.mipmap.ref_cocacola_11litros, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Coca Cola 1.25 lts", "0", "Refrescos", "1 U", "0", "32.00", "0", R.mipmap.ref_cocacola_litrocuarto, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Coca Cola 1.25 lts Vidrio", "0", "Refrescos", "1 U", "0", "25.00", "0", R.mipmap.ref_cocacola_litrovidrio, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Coca Cola 2 lts", "0", "Refrescos", "1 U", "0", "48.00", "0", R.mipmap.ref_cocacola_2litros, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Coca Cola 3 lts", "0", "Refrescos", "1 U", "0", "65.00", "0", R.mipmap.ref_cocacola_3litros, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Pepsi Mini 192 ml Vidrio", "0", "Refrescos", "1 U", "0", "7.00", "0", R.mipmap.ref_pepsi_mini, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Pepsi 355 ml Vidrio", "0", "Refrescos", "1 U", "0", "10.00", "0", R.mipmap.ref_pepsi_355mlvidrio, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Pepsi 355 ml Lata", "0", "Refrescos", "1 U", "0", "17.00", "0", R.mipmap.ref_pepsi_lata, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Pepsi 500 ml", "0", "Refrescos", "1 U", "0", "20.00", "0", R.mipmap.ref_pepsi_500ml, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Pepsi 1.1 lts", "0", "Refrescos", "1 U", "0", "27.00", "0", R.mipmap.ref_pepsi_11litros, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Pepsi 1.25 lts", "0", "Refrescos", "1 U", "0", "32.00", "0", R.mipmap.ref_pepsi_litrocuarto, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Pepsi 1.25 lts Vidrio", "0", "Refrescos", "1 U", "0", "25.00", "0", R.mipmap.ref_pepsi_litrovidrio, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Pepsi 2 lts", "0", "Refrescos", "1 U", "0", "48.00", "0", R.mipmap.ref_pepsi_2litros, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Pepsi 3 lts", "0", "Refrescos", "1 U", "0", "60.00", "0", R.mipmap.ref_pepsi_3litros, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Canada Dry 500 ml", "0", "Refrescos", "1 U", "0", "20.00", "0", R.mipmap.ref_canadadry_500ml, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Tropical Banana 500 ml", "0", "Refrescos", "1 U", "0", "20.00", "0", R.mipmap.ref_banana_500ml, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Tropical Banana 1.25 lts", "0", "Refrescos", "1 U", "0", "32.00", "0", R.mipmap.ref_banana_litrocuarto, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Tropical Banana 2 lts", "0", "Refrescos", "1 U", "0", "48.00", "0", R.mipmap.ref_banana_2litros, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Tropical Banana 3 lts", "0", "Refrescos", "1 U", "0", "65.00", "0", R.mipmap.ref_banana_3litros, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Tropical Uva 500 ml", "0", "Refrescos", "1 U", "0", "20.00", "0", R.mipmap.ref_uva_500ml, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Tropical Uva 1.25 lts", "0", "Refrescos", "1 U", "0", "32.00", "0", R.mipmap.ref_uva_litrocuarto, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Tropical Uva 2 lts", "0", "Refrescos", "1 U", "0", "48.00", "0", R.mipmap.ref_uva_2litros, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Tropical Uva 3 lts", "0", "Refrescos", "1 U", "0", "65.00", "0", R.mipmap.ref_uva_3litros, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Fresca 500 ml", "0", "Refrescos", "1 U", "0", "20.00", "0", R.mipmap.ref_fresca_500ml, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Fresca 1.25 lts", "0", "Refrescos", "1 U", "0", "32.00", "0", R.mipmap.ref_fresca_litrocuarto, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Fresca 2 lts", "0", "Refrescos", "1 U", "0", "48.00", "0", R.mipmap.ref_fresca_2litros, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Fresca 3 lts", "0", "Refrescos", "1 U", "0", "65.00", "0", R.mipmap.ref_fresca_3litros, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Teem 355 ml Vidrio", "0", "Refrescos", "1 U", "0", "10.00", "0", R.mipmap.ref_teem_vidrio, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Mountain Dew 355 ml Lata", "0", "Refrescos", "1 U", "0", "17.00", "0", R.mipmap.ref_mountaindew_lata, "Pepsi"));
        itemsList.add(new ProductoItemsModel("7UP 355 ml Vidrio", "0", "Refrescos", "1 U", "0", "10.00", "0", R.mipmap.ref_7up_vidrio, "Pepsi"));
        itemsList.add(new ProductoItemsModel("7UP 500 ml", "0", "Refrescos", "1 U", "0", "20.00", "0", R.mipmap.ref_7up_500ml, "Pepsi"));
        itemsList.add(new ProductoItemsModel("7UP 1.25 lts", "0", "Refrescos", "1 U", "0", "32.00", "0", R.mipmap.ref_7up_litrocuarto, "Pepsi"));
        itemsList.add(new ProductoItemsModel("7UP 2 lts", "0", "Refrescos", "1 U", "0", "48.00", "0", R.mipmap.ref_7up_2litros, "Pepsi"));
        itemsList.add(new ProductoItemsModel("7UP 3 lts", "0", "Refrescos", "1 U", "0", "60.00", "0", R.mipmap.ref_7up_3litros, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Mirinda Naranja 355 ml Vidrio", "0", "Refrescos", "1 U", "0", "10.00", "0", R.mipmap.ref_mirindanaranja_vidrio, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Mirinda Naranja 500 ml", "0", "Refrescos", "1 U", "0", "20.00", "0", R.mipmap.ref_mirindanaranja_500ml, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Mirinda Naranja 1.25 lts", "0", "Refrescos", "1 U", "0", "32.00", "0", R.mipmap.ref_mirindanaranja_litrocuarto, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Mirinda Naranja 2 lts", "0", "Refrescos", "1 U", "0", "48.00", "0", R.mipmap.ref_mirindanaranja_2litros, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Mirinda Naranja 3 lts", "0", "Refrescos", "1 U", "0", "60.00", "0", R.mipmap.ref_mirindanaranja_3litros, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Mirinda Banana 355 ml Vidrio", "0", "Refrescos", "1 U", "0", "10.00", "0", R.mipmap.ref_mirindabanana_vidrio, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Mirinda Banana 500 ml", "0", "Refrescos", "1 U", "0", "20.00", "0", R.mipmap.ref_mirindabanana_500ml, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Mirinda Uva 355 ml Vidrio", "0", "Refrescos", "1 U", "0", "10.00", "0", R.mipmap.ref_mirindauva_vidrio, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Mirinda Uva 500 ml", "0", "Refrescos", "1 U", "0", "20.00", "0", R.mipmap.ref_mirindauva_500ml, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Sprite 500 ml", "0", "Refrescos", "1 U", "0", "20.00", "0", R.mipmap.ref_sprite_500ml, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Sprite 1.25 lts", "0", "Refrescos", "1 U", "0", "32.00", "0", R.mipmap.ref_sprite_litrocuarto, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Sprite 2 lts", "0", "Refrescos", "1 U", "0", "48.00", "0", R.mipmap.ref_sprite_2litros, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Sprite 3 lts", "0", "Refrescos", "1 U", "0", "65.00", "0", R.mipmap.ref_sprite_3litros, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Té Lipton 500 ml", "0", "Refrescos", "1 U", "0", "20.00", "0", R.mipmap.ref_lipton_500ml, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Té Lipton 2 lts", "0", "Refrescos", "1 U", "0", "47.00", "0", R.mipmap.ref_lipton_2litros, "Pepsi"));

        //Jugos
        itemsList.add(new ProductoItemsModel("Aloe Vera 500 ml", "0", "Jugos", "1 U", "0", "35.00", "0", R.mipmap.jug_aloevera, "Bodega"));
        itemsList.add(new ProductoItemsModel("Jugo de Naranja Leyde 473 ml", "0", "Jugos", "1 Medio", "0", "18.00", "0", R.mipmap.jug_mediojugo_leyde, "Leyde"));
        itemsList.add(new ProductoItemsModel("Jugo de Naranja Leyde 946 ml", "0", "Jugos", "1 Litro", "0", "30.00", "0", R.mipmap.jug_litrojugo_leyde, "Leyde"));
        itemsList.add(new ProductoItemsModel("Jugo de Naranja Sula 473 ml", "0", "Jugos", "1 Medio", "0", "18.00", "0", R.mipmap.jug_mediojugo_sula, "Sula"));
        itemsList.add(new ProductoItemsModel("Jugo de Naranja Sula 946 ml", "0", "Jugos", "1 Litro", "0", "30.00", "0", R.mipmap.jug_litrojugo_sula, "Sula"));
        itemsList.add(new ProductoItemsModel("Jugo Naturas 330 ml Lata", "0", "Jugos", "1 U", "0", "14.00", "0", R.mipmap.jug_naturas330mllata, "Dinant"));
        itemsList.add(new ProductoItemsModel("Jugo Naturas 200 ml Caja", "0", "Jugos", "1 U", "0", "10.00", "0", R.mipmap.jug_naturas200mlcaja, "Dinant"));
        itemsList.add(new ProductoItemsModel("Del Valle Néctar 330 ml Lata", "0", "Jugos", "1 U", "0", "14.00", "0", R.mipmap.jug_delvalle_330mllata, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Enjoy Néctar 330 ml Lata", "0", "Jugos", "1 U", "0", "14.00", "0", R.mipmap.jug_enjoynectar_330mllata, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Jugo Enjoy 500 ml", "0", "Jugos", "1 U", "0", "17.00", "0", R.mipmap.jug_enjoy_500ml, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Quanty 8 oz Pepito", "0", "Jugos", "1 U", "0", "10.00", "0", R.mipmap.jug_quanty_8ozpepito, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Quanty Medio Galón", "0", "Jugos", "1 U", "0", "45.00", "0", R.mipmap.jug_quanty_mediogalon, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Jugo De la Granja 500 ml", "0", "Jugos", "1 U", "0", "17.00", "0", R.mipmap.jug_delagranja, "Dinant"));
        itemsList.add(new ProductoItemsModel("Jugo de Zanahoria Sula 473 ml", "0", "Jugos", "1 U", "0", "22.00", "0", R.mipmap.jug_jugozanahoria_sula, "Sula"));
        itemsList.add(new ProductoItemsModel("Jugo Montana 355 ml Bolsa", "0", "Jugos", "1 U", "0", "7.00", "0", R.mipmap.jug_montana_355ml, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Juicy de Naranja 1.7 lts", "0", "Jugos", "1 U", "0", "32.00", "0", R.mipmap.jug_juicy, "Leyde"));
        itemsList.add(new ProductoItemsModel("Cifrut 1.5 lts", "0", "Jugos", "1 U", "0", "23.00", "0", R.mipmap.jug_cifrut15lts, "AJE"));
        itemsList.add(new ProductoItemsModel("Cifrut 3 lts", "0", "Jugos", "1 U", "0", "48.00", "0", R.mipmap.jug_cifrut3lts, "AJE"));

        //Lácteos
        itemsList.add(new ProductoItemsModel("Leche Leyde 900 ml", "0", "Lácteos", "1 Litro", "0", "31.00", "0", R.mipmap.lac_litroleche_leyde, "Leyde"));
        itemsList.add(new ProductoItemsModel("Leche Sula 900 ml", "0", "Lácteos", "1 Litro", "0", "31.00", "0", R.mipmap.lac_litroleche_sula, "Sula"));
        itemsList.add(new ProductoItemsModel("Leche Leyde 473 ml", "0", "Lácteos", "1 Medio", "0", "18.00", "0", R.mipmap.lac_medioleche_leyde2, "Leyde"));
        itemsList.add(new ProductoItemsModel("Leche Sula 450 ml", "0", "Lácteos", "1 Medio", "0", "18.00", "0", R.mipmap.lac_medioleche_sula, "Sula"));
        itemsList.add(new ProductoItemsModel("Huevos", "0", "Lácteos", "1 U", "1 Cartón", "6.00", "150.00", R.mipmap.lac_huevos, "Quesería"));
        itemsList.add(new ProductoItemsModel("Mantequilla", "0", "Lácteos", "1 Libra", "1 Media", "58.00", "29.00", R.mipmap.lac_mediamantequilla, "Quesería"));
        //itemsList.add(new ProductoItemsModel("Media de Mantequilla", "0", "Lácteos", "1 Media", "0", "29.00", "0", R.mipmap.lac_mediamantequilla, "Quesería"));
        itemsList.add(new ProductoItemsModel("Bolsa de Mantequilla Leyde", "0", "Lácteos", "1 U", "0", "12.00", "0", R.mipmap.lac_mantequilla_leyde, "Leyde"));
        itemsList.add(new ProductoItemsModel("Queso Crema", "0", "Lácteos", "1 Libra", "1 Media", "58.00", "29.00", R.mipmap.lac_libraquesocrema, "Quesería"));
        //itemsList.add(new ProductoItemsModel("Media de Queso Crema", "0", "Lácteos", "1 Media", "0", "29.00", "0", R.mipmap.lac_mediaquesocrema, "Quesería"));
        itemsList.add(new ProductoItemsModel("Queso Duro", "0", "Lácteos", "1 Libra", "1 Media", "92.00", "46.00", R.mipmap.lac_libraquesoduro, "Quesería"));
        //itemsList.add(new ProductoItemsModel("Media de Queso Duro", "0", "Lácteos", "1 Media", "0", "46.00", "0", R.mipmap.lac_mediaquesoduro, "Quesería"));
        itemsList.add(new ProductoItemsModel("Quesillo Leyde", "0", "Lácteos", "1 U", "0", "45.00", "0", R.mipmap.lac_quesillo_leyde, "Leyde"));
        itemsList.add(new ProductoItemsModel("Queso Amarillo Leyde", "0", "Lácteos", "1 U", "0", "31.00", "0", R.mipmap.lac_quesoamarillo_leyde, "Leyde"));
        itemsList.add(new ProductoItemsModel("Malteada ChocoLeyde 473 ml", "0", "Lácteos", "1 U", "0", "21.00", "0", R.mipmap.lac_chocoleyde, "Leyde"));
        itemsList.add(new ProductoItemsModel("Malteada FresaLeyde 473 ml", "0", "Lácteos", "1 U", "0", "21.00", "0", R.mipmap.lac_fresaleyde, "Leyde"));
        itemsList.add(new ProductoItemsModel("Malteada VainiLeyde 473 ml", "0", "Lácteos", "1 U", "0", "21.00", "0", R.mipmap.lac_vainileyde, "Leyde"));
        itemsList.add(new ProductoItemsModel("Malteada ChocoSula 473 ml", "0", "Lácteos", "1 U", "0", "21.00", "0", R.mipmap.lac_chocosula, "Sula"));
        itemsList.add(new ProductoItemsModel("Malteada FresiSula 473 ml", "0", "Lácteos", "1 U", "0", "21.00", "0", R.mipmap.lac_fresisula, "Sula"));
        itemsList.add(new ProductoItemsModel("Malteada VainiSula 473 ml", "0", "Lácteos", "1 U", "0", "21.00", "0", R.mipmap.lac_vainisula, "Sula"));
        itemsList.add(new ProductoItemsModel("Leche Descremada Sula 946 ml", "0", "Lácteos", "1 Caja", "0", "39.00", "0", R.mipmap.lac_lechedescremada_sula, "Sula"));
        itemsList.add(new ProductoItemsModel("Leche Entera Sula 946 ml", "0", "Lácteos", "1 Caja", "0", "39.00", "0", R.mipmap.lac_lecheenteracaja_sula, "Sula"));
        itemsList.add(new ProductoItemsModel("Leche Deslactosada Sula 946 ml", "0", "Lácteos", "1 Caja", "0", "39.00", "0", R.mipmap.lac_lechedeslactosada_sula, "Sula"));

        //Carnes y Embutidos
        itemsList.add(new ProductoItemsModel("Pechuga de Pollo", "0", "Carnes y Embutidos", "1 Libra", "1 Media", "42.00", "21.00", R.mipmap.car_librapollo, "Pollo Rey"));
        itemsList.add(new ProductoItemsModel("Pechuga de Pollo sin Ala", "0", "Carnes y Embutidos", "1 Libra", "1 Media", "45.00", "22.50", R.mipmap.car_pechugasinala, "Pollo Rey"));
        itemsList.add(new ProductoItemsModel("Carne Molida", "0", "Carnes y Embutidos", "1 Libra", "1 Media", "68.00", "34.00", R.mipmap.car_carnemolida, "Pollo Rey"));
        itemsList.add(new ProductoItemsModel("Chuleta Ahumada Toledo", "0", "Carnes y Embutidos", "1 Libra", "1 Media", "97.00", "48.50", R.mipmap.car_chuletaahumada, "Pollo Rey"));
        itemsList.add(new ProductoItemsModel("Chuleta de Cerdo", "0", "Carnes y Embutidos", "1 Libra", "1 Media", "47.00", "23.50", R.mipmap.car_chuletacerdo, "Pollo Rey"));
        itemsList.add(new ProductoItemsModel("Costilla de Cerdo", "0", "Carnes y Embutidos", "1 Libra", "1 Media", "48.00", "24.00", R.mipmap.car_costillacerdo, "Pollo Rey"));
        itemsList.add(new ProductoItemsModel("Alitas de Pollo", "0", "Carnes y Embutidos", "1 Caja", "0", "80.00", "0", R.mipmap.car_alitas, "Pollo Rey"));
        itemsList.add(new ProductoItemsModel("Pechuguitas Crispy", "0", "Carnes y Embutidos", "1 Caja", "0", "89.00", "0", R.mipmap.car_pechuguitascrispy, "Pollo Rey"));
        itemsList.add(new ProductoItemsModel("Trocitos de Pechuga", "0", "Carnes y Embutidos", "1 Caja", "0", "89.00", "0", R.mipmap.car_trocitospechuga, "Pollo Rey"));
        itemsList.add(new ProductoItemsModel("Paquete de Jamón", "0", "Carnes y Embutidos", "1 U", "0", "32.00", "0", R.mipmap.car_jamon, "Pollo Rey"));
        itemsList.add(new ProductoItemsModel("Hot Dog", "0", "Carnes y Embutidos", "1 U", "0", "3.00", "0", R.mipmap.car_hotdog, "Pollo Rey"));
        itemsList.add(new ProductoItemsModel("Hot Dog de Pollo", "0", "Carnes y Embutidos", "1 U", "0", "9.00", "0", R.mipmap.car_hotdogpollo, "Pollo Rey"));
        itemsList.add(new ProductoItemsModel("Longaniza", "0", "Carnes y Embutidos", "1 U", "0", "7.00", "0", R.mipmap.car_longaniza, "Pollo Rey"));
        itemsList.add(new ProductoItemsModel("Chorizo Parrillero", "0", "Carnes y Embutidos", "1 U", "0", "7.00", "0", R.mipmap.car_chorizoparrillero, "Pollo Rey"));
        itemsList.add(new ProductoItemsModel("Choripollo", "0", "Carnes y Embutidos", "1 U", "0", "14.00", "0", R.mipmap.car_choripollo, "Pollo Rey"));
        itemsList.add(new ProductoItemsModel("Menudos de Pollo", "0", "Carnes y Embutidos", "1 U", "0", "28.00", "0", R.mipmap.car_menudospollo, "Pollo Rey"));
        itemsList.add(new ProductoItemsModel("Patas de Pollo", "0", "Carnes y Embutidos", "1 U", "0", "28.00", "0", R.mipmap.car_pataspollo, "Pollo Rey"));

        //Cervezas
        itemsList.add(new ProductoItemsModel("Salvavida Vidrio", "0", "Cervezas", "1 U", "1 Caja", "20.00", "480.00", R.mipmap.cer_salvavida_vidrio, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Salvavida Lata", "0", "Cervezas", "1 U", "1 Caja", "25.00", "600.00", R.mipmap.cer_salvavida_lata, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Barena Vidrio", "0", "Cervezas", "1 U", "1 Caja", "22.00", "528.00", R.mipmap.cer_barena_vidrio, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Barena Lata", "0", "Cervezas", "1 U", "1 Caja", "28.00", "672.00", R.mipmap.cer_barena_lata, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Michelob Ultra", "0", "Cervezas", "1 U", "1 Caja", "34.00", "816.00", R.mipmap.cer_ultra, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Corona Extra", "0", "Cervezas", "1 U", "1 Caja", "35.00", "840.00", R.mipmap.cer_corona, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Miller Draft", "0", "Cervezas", "1 U", "1 Caja", "35.00", "840.00", R.mipmap.cer_millerdraft, "Cervecería Hondureña"));

        //Churros
        itemsList.add(new ProductoItemsModel("Alboroto", "0", "Churros", "1 U", "0", "3.00", "0", R.mipmap.chu_alboroto, "Diana"));
        itemsList.add(new ProductoItemsModel("Anillitos Barbacoa", "0", "Churros", "1 U", "1 U", "3.00", "28.00", R.mipmap.chu_anillitosbbq, "Dinant"));
        itemsList.add(new ProductoItemsModel("Buenachos Queso", "0", "Churros", "1 U", "0", "4.00", "0", R.mipmap.chu_buenachosnaranja, "Boca Deli"));
        itemsList.add(new ProductoItemsModel("Buenachos Picante", "0", "Churros", "1 U", "0", "4.00", "0", R.mipmap.chu_buenachospicante, "Boca Deli"));
        itemsList.add(new ProductoItemsModel("Cappy Gorditos", "0", "Churros", "1 U", "0", "3.00", "0", R.mipmap.chu_cappygorditos, "Dinant"));
        itemsList.add(new ProductoItemsModel("Cappy Infladitos", "0", "Churros", "1 U", "0", "5.00", "0", R.mipmap.chu_cappyinfladitos, "Dinant"));
        itemsList.add(new ProductoItemsModel("Caribas Picante Grande", "0", "Churros", "1 U", "0", "32.00", "0", R.mipmap.chu_caribaspicante, "Frito Lay"));
        itemsList.add(new ProductoItemsModel("Caribas Sofrito Grande", "0", "Churros", "1 U", "0", "32.00", "0", R.mipmap.chu_caribassofrito, "Frito Lay"));
        itemsList.add(new ProductoItemsModel("Centavitos", "0", "Churros", "1 U", "0", "3.00", "0", R.mipmap.chu_centavitos, "Diana"));
        itemsList.add(new ProductoItemsModel("Cheetos Azules", "0", "Churros", "1 U", "0", "7.00", "0", R.mipmap.chu_cheetosazules, "Frito Lay"));
        itemsList.add(new ProductoItemsModel("Cheetos Naranja", "0", "Churros", "1 U", "0", "7.00", "0", R.mipmap.chu_cheetosnaranja, "Frito Lay"));
        itemsList.add(new ProductoItemsModel("Chicharrón Criollo", "0", "Churros", "1 U", "1 U", "10.00", "48.00", R.mipmap.chu_chicharronsinpicar, "Dinant"));
        itemsList.add(new ProductoItemsModel("Chicharrón Picante", "0", "Churros", "1 U", "1 U", "10.00", "48.00", R.mipmap.chu_chicharronpicante, "Dinant"));
        itemsList.add(new ProductoItemsModel("Crujitos", "0", "Churros", "1 U", "0", "7.00", "0", R.mipmap.chu_crujitos, "Frito Lay"));
        itemsList.add(new ProductoItemsModel("Doraditas Twist", "0", "Churros", "1 U", "0", "4.00", "0", R.mipmap.chu_doraditasazul, "Frito Lay"));
        itemsList.add(new ProductoItemsModel("Doraditas Barbacoa", "0", "Churros", "1 U", "0", "4.00", "0", R.mipmap.chu_doraditasbbq, "Frito Lay"));
        itemsList.add(new ProductoItemsModel("Doraditas Limón", "0", "Churros", "1 U", "0", "4.00", "0", R.mipmap.chu_doraditaslimon, "Frito Lay"));
        itemsList.add(new ProductoItemsModel("Doraditas Queso", "0", "Churros", "1 U", "0", "4.00", "0", R.mipmap.chu_doraditasqueso, "Frito Lay"));
        itemsList.add(new ProductoItemsModel("Doritos Picante", "0", "Churros", "1 U", "1 U", "7.00", "30.00", R.mipmap.chu_doritospicante, "Frito Lay"));
        itemsList.add(new ProductoItemsModel("Doritos Queso", "0", "Churros", "1 U", "1 U", "7.00", "30.00", R.mipmap.chu_doritosqueso, "Frito Lay"));
        itemsList.add(new ProductoItemsModel("Elotitos", "0", "Churros", "1 U", "0", "4.00", "0", R.mipmap.chu_elotitos, "Diana"));
        itemsList.add(new ProductoItemsModel("Frijolí", "0", "Churros", "1 U", "0", "4.00", "0", R.mipmap.chu_frijoli, "Boca Deli"));
        itemsList.add(new ProductoItemsModel("Fritos Antojitos", "0", "Churros", "1 U", "0", "7.00", "0", R.mipmap.chu_fritosantojitos, "Frito Lay"));
        itemsList.add(new ProductoItemsModel("Fritos Twist", "0", "Churros", "1 U", "0", "7.00", "0", R.mipmap.chu_fritostwist, "Frito Lay"));
        itemsList.add(new ProductoItemsModel("Futbolito", "0", "Churros", "1 U", "0", "3.00", "0", R.mipmap.chu_futbolito, "Rica Sula"));
        itemsList.add(new ProductoItemsModel("Golazo", "0", "Churros", "1 U", "0", "3.00", "0", R.mipmap.chu_golazo, "Rica Sula"));
        itemsList.add(new ProductoItemsModel("Gustitos", "0", "Churros", "1 U", "0", "3.00", "0", R.mipmap.chu_gustitos, "Boca Deli"));
        itemsList.add(new ProductoItemsModel("Jalapeños", "0", "Churros", "1 U", "0", "4.00", "0", R.mipmap.chu_jalapenos, "Diana"));
        itemsList.add(new ProductoItemsModel("Maní con Limón", "0", "Churros", "1 U", "0", "4.00", "0", R.mipmap.chu_manilimon, "Dinant"));
        itemsList.add(new ProductoItemsModel("Maní Mixto", "0", "Churros", "1 U", "0", "4.00", "0", R.mipmap.chu_manimixto, "Dinant"));
        itemsList.add(new ProductoItemsModel("Maní con Sal", "0", "Churros", "1 U", "0", "4.00", "0", R.mipmap.chu_manisal, "Dinant"));
        itemsList.add(new ProductoItemsModel("Nachos", "0", "Churros", "1 U", "0", "4.00", "0", R.mipmap.chu_nachos, "Diana"));
        itemsList.add(new ProductoItemsModel("Palitos de Papas", "0", "Churros", "1 U", "0", "3.00", "0", R.mipmap.chu_palitosdepapas, "Dinant"));
        itemsList.add(new ProductoItemsModel("Poffets Queso", "0", "Churros", "1 U", "0", "30.00", "0", R.mipmap.chu_poffetsqueso, "Frito Lay"));
        itemsList.add(new ProductoItemsModel("Quesitrix Picante", "0", "Churros", "1 U", "0", "3.00", "0", R.mipmap.chu_quesitrixpicante, "Boca Deli"));
        itemsList.add(new ProductoItemsModel("Quesitrix Queso", "0", "Churros", "1 U", "0", "3.00", "0", R.mipmap.chu_quesitrixqueso, "Boca Deli"));
        itemsList.add(new ProductoItemsModel("Ranchitas Barbacoa", "0", "Churros", "1 U", "1 U", "6.00", "30.00", R.mipmap.chu_ranchitasbbq, "Dinant"));
        itemsList.add(new ProductoItemsModel("Ranchitas Picante", "0", "Churros", "1 U", "1 U", "6.00", "30.00", R.mipmap.chu_ranchitaspicante, "Dinant"));
        itemsList.add(new ProductoItemsModel("Ranchitas Queso", "0", "Churros", "1 U", "1 U", "6.00", "30.00", R.mipmap.chu_ranchitasqueso, "Dinant"));
        itemsList.add(new ProductoItemsModel("Ranchitas Naturales", "0", "Churros", "1 U", "1 U", "8.00", "44.00", R.mipmap.chu_ranchitasnaturales, "Dinant"));
        itemsList.add(new ProductoItemsModel("Rica Sula", "0", "Churros", "1 U", "0", "7.00", "0", R.mipmap.chu_ricasula, "Rica Sula"));
        itemsList.add(new ProductoItemsModel("Taco 3 Quesos", "0", "Churros", "1 U", "0", "4.00", "0", R.mipmap.chu_tacoamarillo, "Dinant"));
        itemsList.add(new ProductoItemsModel("Taco Tornitos Queso", "0", "Churros", "1 U", "0", "4.00", "0", R.mipmap.chu_tacoazul, "Dinant"));
        itemsList.add(new ProductoItemsModel("Taco Barbacoa", "0", "Churros", "1 U", "0", "4.00", "0", R.mipmap.chu_tacobbq, "Dinant"));
        itemsList.add(new ProductoItemsModel("Taco Limón", "0", "Churros", "1 U", "0", "4.00", "0", R.mipmap.chu_tacolimon, "Dinant"));
        itemsList.add(new ProductoItemsModel("Taco Picante", "0", "Churros", "1 U", "0", "4.00", "0", R.mipmap.chu_tacopicante, "Dinant"));
        itemsList.add(new ProductoItemsModel("Taco Chile Toreado", "0", "Churros", "1 U", "0", "4.00", "0", R.mipmap.chu_tacoverdepicante, "Dinant"));
        itemsList.add(new ProductoItemsModel("Takis Fuego", "0", "Churros", "1 U", "0", "15.00", "0", R.mipmap.chu_takisfuego, "Bimbo"));
        itemsList.add(new ProductoItemsModel("Taqueritos Picante", "0", "Churros", "1 U", "1 U", "6.00", "33.00", R.mipmap.chu_taqueritospicantes, "Dinant"));
        itemsList.add(new ProductoItemsModel("Taqueritos Queso", "0", "Churros", "1 U", "0", "6.00", "0", R.mipmap.chu_taqueritosqueso, "Dinant"));
        itemsList.add(new ProductoItemsModel("Tortillita", "0", "Churros", "1 U", "0", "3.00", "0", R.mipmap.chu_tortillita, "Rica Sula"));
        itemsList.add(new ProductoItemsModel("Toztecas Picante", "0", "Churros", "1 U", "0", "4.00", "0", R.mipmap.chu_toztecaspicante, "Diana"));
        itemsList.add(new ProductoItemsModel("Trompetas de Pizza", "0", "Churros", "1 U", "0", "3.00", "0", R.mipmap.chu_trompetaspizza, "Boca Deli"));
        itemsList.add(new ProductoItemsModel("Yummipops Queso", "0", "Churros", "1 U", "0", "8.00", "0", R.mipmap.chu_yummipopsqueso, "Dinant"));
        itemsList.add(new ProductoItemsModel("Yummipops con Sal", "0", "Churros", "1 U", "0", "8.00", "0", R.mipmap.chu_yummipopssal, "Dinant"));
        itemsList.add(new ProductoItemsModel("Yummix Tropical", "0", "Churros", "1 U", "1 U", "8.00", "42.00", R.mipmap.chu_yummixtropical, "Dinant"));
        itemsList.add(new ProductoItemsModel("Yummix Picante", "0", "Churros", "1 U", "1 U", "8.00", "42.00", R.mipmap.chu_yummixpicante, "Dinant"));
        itemsList.add(new ProductoItemsModel("Zambos con Chicharrón", "0", "Churros", "1 U", "1 U", "6.00", "38.00", R.mipmap.chu_zamboschicharron, "Dinant"));
        itemsList.add(new ProductoItemsModel("Zambos Originales", "0", "Churros", "1 U", "1 U", "6.00", "38.00", R.mipmap.chu_zambosoriginales, "Dinant"));
        itemsList.add(new ProductoItemsModel("Zambos Ceviche", "0", "Churros", "1 U", "1 U", "6.00", "38.00", R.mipmap.chu_zambosceviche, "Dinant"));
        itemsList.add(new ProductoItemsModel("Zambos Picante", "0", "Churros", "1 U", "1 U", "6.00", "38.00", R.mipmap.chu_zambospicante, "Dinant"));
        itemsList.add(new ProductoItemsModel("Yuquitas con Sal", "0", "Churros", "1 U", "0", "4.00", "0", R.mipmap.chu_zambosyuquitas, "Dinant"));
        itemsList.add(new ProductoItemsModel("Yuquitas Picante", "0", "Churros", "1 U", "0", "4.00", "0", R.mipmap.chu_zambosyuquitaspicantes, "Dinant"));
        itemsList.add(new ProductoItemsModel("Zibas Clásicas", "0", "Churros", "1 U", "0", "8.00", "0", R.mipmap.chu_zibasamarilla, "Dinant"));
        itemsList.add(new ProductoItemsModel("Zibas Miel y Mostaza", "0", "Churros", "1 U", "0", "8.00", "0", R.mipmap.chu_zibasazul, "Dinant"));
        itemsList.add(new ProductoItemsModel("Zibas Queso", "0", "Churros", "1 U", "0", "8.00", "0", R.mipmap.chu_zibasnaranja, "Dinant"));
        itemsList.add(new ProductoItemsModel("Zibas Crema y Especias", "0", "Churros", "1 U", "0", "8.00", "0", R.mipmap.chu_zibasverde, "Dinant"));
        itemsList.add(new ProductoItemsModel("Zibas Ketchup", "0", "Churros", "1 U", "0", "8.00", "0", R.mipmap.chu_zibasketchup, "Dinant"));

        //Dulces
        itemsList.add(new ProductoItemsModel("Alka", "0", "Dulces", "1 U", "0", "1.00", "0", R.mipmap.dul_alka, "Bodega"));
        itemsList.add(new ProductoItemsModel("Chao", "0", "Dulces", "1 U", "0", "0.66", "0", R.mipmap.dul_confiteschao, "Bodega"));
        itemsList.add(new ProductoItemsModel("Barra de Snickers", "0", "Dulces", "1 U", "0", "25.00", "0", R.mipmap.dul_snickers_barra, "Bodega"));
        itemsList.add(new ProductoItemsModel("Chocolate M&M", "0", "Dulces", "1 Paquete", "0", "28.00", "0", R.mipmap.dul_mm_chocolates, "Bodega"));
        itemsList.add(new ProductoItemsModel("Chocolate Bon o Bon", "0", "Dulces", "1 U", "0", "6.00", "0", R.mipmap.dul_bonobon_chocolate, "Bodega"));
        itemsList.add(new ProductoItemsModel("Panditas Clásicos", "0", "Dulces", "1 U", "0", "23.00", "0", R.mipmap.dul_panditasclasicos, "Bimbo"));
        itemsList.add(new ProductoItemsModel("Bubbaloo", "0", "Dulces", "1 U", "0", "1.00", "0", R.mipmap.dul_bubbaloo, "Bodega"));
        itemsList.add(new ProductoItemsModel("Chicles Winterfresh", "0", "Dulces", "1 Paquete", "0", "15.00", "0", R.mipmap.dul_chicles_winterfresh, "Bodega"));
        itemsList.add(new ProductoItemsModel("Chicle Yerbabuena", "0", "Dulces", "1 U", "0", "1.00", "0", R.mipmap.dul_chiclesyerbabuena_xtime, "Bodega"));
        itemsList.add(new ProductoItemsModel("Chicle Menta", "0", "Dulces", "1 U", "0", "0.66", "0", R.mipmap.dul_chiclesmenta, "Bodega"));
        itemsList.add(new ProductoItemsModel("Cerecita", "0", "Dulces", "1 U", "0", "3.00", "0", R.mipmap.dul_cerecita, "Diana"));
        itemsList.add(new ProductoItemsModel("Botonetas", "0", "Dulces", "1 U", "0", "3.00", "0", R.mipmap.dul_botonetas, "Bodega"));
        itemsList.add(new ProductoItemsModel("Xixi - Leche de Burra", "0", "Dulces", "1 U", "0", "0.66", "0", R.mipmap.dul_lecheburra_xixi, "Dinant"));
        itemsList.add(new ProductoItemsModel("MiniBum de Mango", "0", "Dulces", "1 U", "0", "0.66", "0", R.mipmap.dul_confitemango_minibum, "Bodega"));
        itemsList.add(new ProductoItemsModel("Chicloso Nougat", "0", "Dulces", "1 U", "0", "2.00", "0", R.mipmap.dul_chicloso_nougat, "Diana"));
        itemsList.add(new ProductoItemsModel("Goma Pino", "0", "Dulces", "1 U", "0", "2.00", "0", R.mipmap.dul_gomapino, "Diana"));
        itemsList.add(new ProductoItemsModel("Bom Bom", "0", "Dulces", "1 U", "0", "2.00", "0", R.mipmap.dul_bonbon_bombombum, "Bodega"));
        itemsList.add(new ProductoItemsModel("Paleta de Corazón", "0", "Dulces", "1 U", "0", "2.00", "0", R.mipmap.dul_paletacorazon_tipitin, "Bodega"));
        itemsList.add(new ProductoItemsModel("Paleta Cervecita", "0", "Dulces", "1 U", "0", "2.00", "0", R.mipmap.dul_paletacervecita, "Bodega"));
        itemsList.add(new ProductoItemsModel("Pastillitas de Fruta", "0", "Dulces", "1 U", "0", "3.00", "0", R.mipmap.dul_pastillitas_fruta, "Diana"));
        itemsList.add(new ProductoItemsModel("Cereal Choco Blast", "0", "Dulces", "1 U", "0", "7.00", "0", R.mipmap.dul_cereal_chocoblast, "Gamesa"));
        itemsList.add(new ProductoItemsModel("Cereal Fruty Ohs", "0", "Dulces", "1 U", "0", "7.00", "0", R.mipmap.dul_cereal_frutyohs, "Gamesa"));
        itemsList.add(new ProductoItemsModel("Cereal Marshmallow Stars", "0", "Dulces", "1 U", "0", "7.00", "0", R.mipmap.dul_cereal_marshmallowstars, "Gamesa"));

        //Helados
        itemsList.add(new ProductoItemsModel("Barrita", "0", "Helados", "1 U", "0", "10.00", "0", R.mipmap.hel_barrita, "Sarita"));
        itemsList.add(new ProductoItemsModel("Helado Casero", "0", "Helados", "1 U", "0", "18.00", "0", R.mipmap.hel_casero, "Sarita"));
        itemsList.add(new ProductoItemsModel("Choco Cono", "0", "Helados", "1 U", "0", "22.00", "0", R.mipmap.hel_chococono, "Sarita"));
        itemsList.add(new ProductoItemsModel("Cinta Negra Normal", "0", "Helados", "1 U", "0", "22.00", "0", R.mipmap.hel_cintanegra, "Sarita"));
        itemsList.add(new ProductoItemsModel("Cinta Negra Crispy", "0", "Helados", "1 U", "0", "28.00", "0", R.mipmap.hel_cintacrispy, "Sarita"));
        itemsList.add(new ProductoItemsModel("Cono Soft", "0", "Helados", "1 U", "0", "20.00", "0", R.mipmap.hel_conosoft, "Sarita"));
        itemsList.add(new ProductoItemsModel("Copa Sundae", "0", "Helados", "1 U", "0", "35.00", "0", R.mipmap.hel_copasundae, "Sarita"));
        itemsList.add(new ProductoItemsModel("Paleta Corazón", "0", "Helados", "1 U", "0", "22.00", "0", R.mipmap.hel_corazon, "Sarita"));
        itemsList.add(new ProductoItemsModel("Cremolino", "0", "Helados", "1 U", "0", "10.00", "0", R.mipmap.hel_cremolino, "Sarita"));
        itemsList.add(new ProductoItemsModel("Paleta Cremosa", "0", "Helados", "1 U", "0", "18.00", "0", R.mipmap.hel_cremosa, "Sarita"));
        itemsList.add(new ProductoItemsModel("Crunchy Pop", "0", "Helados", "1 U", "0", "30.00", "0", R.mipmap.hel_crunchypop, "Sarita"));
        itemsList.add(new ProductoItemsModel("Paleta Giga", "0", "Helados", "1 U", "0", "35.00", "0", R.mipmap.hel_giga, "Sarita"));
        itemsList.add(new ProductoItemsModel("Litro de Helado", "0", "Helados", "1 U", "0", "90.00", "0", R.mipmap.hel_litro, "Sarita"));
        itemsList.add(new ProductoItemsModel("Medio Galón de Helado", "0", "Helados", "1 U", "0", "160.00", "0", R.mipmap.hel_mediogalon, "Sarita"));
        itemsList.add(new ProductoItemsModel("Palito", "0", "Helados", "1 U", "0", "10.00", "0", R.mipmap.hel_palito, "Sarita"));
        itemsList.add(new ProductoItemsModel("Paleta de Fruta", "0", "Helados", "1 U", "0", "20.00", "0", R.mipmap.hel_fruta, "Sarita"));
        itemsList.add(new ProductoItemsModel("Paleta de Sandía", "0", "Helados", "1 U", "0", "18.00", "0", R.mipmap.hel_sandia, "Sarita"));
        itemsList.add(new ProductoItemsModel("Sandwich de Helado", "0", "Helados", "1 U", "0", "25.00", "0", R.mipmap.hel_sandwich, "Sarita"));
        itemsList.add(new ProductoItemsModel("Sanguchito", "0", "Helados", "1 U", "0", "20.00", "0", R.mipmap.hel_sanguchito, "Sarita"));
        itemsList.add(new ProductoItemsModel("Sorby Twist", "0", "Helados", "1 U", "0", "14.00", "0", R.mipmap.hel_sorbytwist, "Sarita"));
        itemsList.add(new ProductoItemsModel("Topolino", "0", "Helados", "1 U", "0", "7.00", "0", R.mipmap.hel_topolinos, "Sarita"));
        itemsList.add(new ProductoItemsModel("Vasito", "0", "Helados", "1 U", "0", "20.00", "0", R.mipmap.hel_vasito, "Sarita"));

        //Medicamentos
        itemsList.add(new ProductoItemsModel("Acetaminofen", "0", "Medicamentos", "1 U", "0", "2.00", "0", R.mipmap.med_acetaminofen, "Bodega"));
        itemsList.add(new ProductoItemsModel("Acetaminofen en Jarabe", "0", "Medicamentos", "1 U", "0", "55.00", "0", R.mipmap.med_acetaminofenjarabe, "Bodega"));
        itemsList.add(new ProductoItemsModel("Agua Oxigenada", "0", "Medicamentos", "1 U", "0", "20.00", "0", R.mipmap.med_aguaoxigenada, "Bodega"));
        itemsList.add(new ProductoItemsModel("Alcohol Medicado", "0", "Medicamentos", "1 U", "0", "30.00", "0", R.mipmap.med_alcoholmedicado, "Bodega"));
        itemsList.add(new ProductoItemsModel("Alergil", "0", "Medicamentos", "1 U", "0", "5.00", "0", R.mipmap.med_alergil, "Bodega"));
        itemsList.add(new ProductoItemsModel("Aliviol Forte", "0", "Medicamentos", "1 U", "0", "9.00", "0", R.mipmap.med_aliviolforte, "Bodega"));
        itemsList.add(new ProductoItemsModel("Alka Seltzer", "0", "Medicamentos", "1 U", "0", "6.00", "0", R.mipmap.med_alkaseltzer, "Bodega"));
        itemsList.add(new ProductoItemsModel("Amoxicilina", "0", "Medicamentos", "1 U", "0", "2.00", "0", R.mipmap.med_amoxicilina, "Bodega"));
        itemsList.add(new ProductoItemsModel("Artribión", "0", "Medicamentos", "1 U", "0", "5.00", "0", R.mipmap.med_artribion, "Bodega"));
        itemsList.add(new ProductoItemsModel("Citrolax", "0", "Medicamentos", "1 U", "0", "75.00", "0", R.mipmap.med_citrolax, "Bodega"));
        itemsList.add(new ProductoItemsModel("Curitas", "0", "Medicamentos", "1 U", "0", "1.00", "0", R.mipmap.med_curitas, "Bodega"));
        itemsList.add(new ProductoItemsModel("Diclofenaco", "0", "Medicamentos", "1 U", "0", "2.00", "0", R.mipmap.med_diclofenaco, "Bodega"));
        itemsList.add(new ProductoItemsModel("Dolofin", "0", "Medicamentos", "1 U", "0", "3.00", "0", R.mipmap.med_dolofin, "Bodega"));
        itemsList.add(new ProductoItemsModel("Gasas", "0", "Medicamentos", "1 U", "0", "3.00", "0", R.mipmap.med_gasas, "Bodega"));
        itemsList.add(new ProductoItemsModel("Gotas Tevirin", "0", "Medicamentos", "1 U", "0", "40.00", "0", R.mipmap.med_tevirin, "Bodega"));
        itemsList.add(new ProductoItemsModel("Gripex Adulto", "0", "Medicamentos", "1 U", "0", "5.00", "0", R.mipmap.med_gripexadulto, "Bodega"));
        itemsList.add(new ProductoItemsModel("Gripex Niños", "0", "Medicamentos", "1 U", "0", "4.00", "0", R.mipmap.med_gripexninos, "Bodega"));
        itemsList.add(new ProductoItemsModel("Hierrovit", "0", "Medicamentos", "1 U", "0", "75.00", "0", R.mipmap.med_hierrovit, "Bodega"));
        itemsList.add(new ProductoItemsModel("Iboprodol", "0", "Medicamentos", "1 U", "0", "5.00", "0", R.mipmap.med_iboprodol, "Bodega"));
        itemsList.add(new ProductoItemsModel("Ibuprofeno", "0", "Medicamentos", "1 U", "0", "2.00", "0", R.mipmap.med_ibuprofeno, "Bodega"));
        itemsList.add(new ProductoItemsModel("Loratadina", "0", "Medicamentos", "1 U", "0", "3.00", "0", R.mipmap.med_loratadina, "Bodega"));
        itemsList.add(new ProductoItemsModel("Magnesia Elcott", "0", "Medicamentos", "1 U", "0", "20.00", "0", R.mipmap.med_magnesiaelcott, "Bodega"));
        itemsList.add(new ProductoItemsModel("Mascarillas", "0", "Medicamentos", "1 U", "0", "5.00", "0", R.mipmap.med_mascarilla, "Bodega"));
        itemsList.add(new ProductoItemsModel("Mentolina", "0", "Medicamentos", "1 U", "0", "10.00", "0", R.mipmap.med_mentolina, "Bodega"));
        itemsList.add(new ProductoItemsModel("Milagrosa", "0", "Medicamentos", "1 U", "0", "2.00", "0", R.mipmap.med_milagrosa, "Bodega"));
        itemsList.add(new ProductoItemsModel("Omeprazol", "0", "Medicamentos", "1 U", "0", "12.00", "0", R.mipmap.med_omeprazol, "Bodega"));
        itemsList.add(new ProductoItemsModel("Panadol Extra Fuerte", "0", "Medicamentos", "1 U", "0", "7.00", "0", R.mipmap.med_panadolextrafuerte, "Bodega"));
        itemsList.add(new ProductoItemsModel("Panadol Mujer", "0", "Medicamentos", "1 U", "0", "11.00", "0", R.mipmap.med_panadolmujer, "Bodega"));
        itemsList.add(new ProductoItemsModel("Panadol Multisíntomas", "0", "Medicamentos", "1 U", "0", "12.00", "0", R.mipmap.med_panadolmultisintomas, "Bodega"));
        itemsList.add(new ProductoItemsModel("Panadol Niños", "0", "Medicamentos", "1 U", "0", "3.00", "0", R.mipmap.med_panadolninos, "Bodega"));
        itemsList.add(new ProductoItemsModel("Panadol Ultra", "0", "Medicamentos", "1 U", "0", "9.00", "0", R.mipmap.med_panadolultra, "Bodega"));
        itemsList.add(new ProductoItemsModel("Pastillas Vick", "0", "Medicamentos", "1 U", "0", "11.00", "0", R.mipmap.med_pastillasvick, "Bodega"));
        itemsList.add(new ProductoItemsModel("Pepto Bismol", "0", "Medicamentos", "1 U", "0", "100.00", "0", R.mipmap.med_peptobismol, "Bodega"));
        itemsList.add(new ProductoItemsModel("Perlas de Eter", "0", "Medicamentos", "1 U", "0", "5.00", "0", R.mipmap.med_perlaseter, "Bodega"));
        itemsList.add(new ProductoItemsModel("Pulmo Grip", "0", "Medicamentos", "1 U", "0", "17.00", "0", R.mipmap.med_pulmogrip, "Bodega"));
        itemsList.add(new ProductoItemsModel("Reumazolón", "0", "Medicamentos", "1 U", "0", "2.00", "0", R.mipmap.med_reumazolon, "Bodega"));
        itemsList.add(new ProductoItemsModel("Sal Andrews", "0", "Medicamentos", "1 U", "0", "6.00", "0", R.mipmap.med_salandrews, "Bodega"));
        itemsList.add(new ProductoItemsModel("Sudagrip Cápsulas", "0", "Medicamentos", "1 U", "0", "6.00", "0", R.mipmap.med_sudagripcapsula, "Bodega"));
        itemsList.add(new ProductoItemsModel("Sudagrip Té", "0", "Medicamentos", "1 U", "0", "15.00", "0", R.mipmap.med_sudagripte, "Bodega"));
        itemsList.add(new ProductoItemsModel("Suero Oralectril", "0", "Medicamentos", "1 Bote", "0", "38.00", "0", R.mipmap.med_suero_oralectrilbote, "Bodega"));
        itemsList.add(new ProductoItemsModel("Tabcin Gripe y Tos Cápsulas", "0", "Medicamentos", "1 U", "0", "17.00", "0", R.mipmap.med_tabcinmoradacapsula, "Bodega"));
        itemsList.add(new ProductoItemsModel("Tabcin Gripe y Tos Efervescente", "0", "Medicamentos", "1 U", "0", "6.00", "0", R.mipmap.med_tabcinmoradaefervescente, "Bodega"));
        itemsList.add(new ProductoItemsModel("Pastillas Tap-On", "0", "Medicamentos", "1 U", "0", "9.00", "0", R.mipmap.med_tapon, "Bodega"));
        itemsList.add(new ProductoItemsModel("Tetraciclina", "0", "Medicamentos", "1 U", "0", "3.00", "0", R.mipmap.med_tetraciclina, "Bodega"));
        itemsList.add(new ProductoItemsModel("Jarabe Tosan", "0", "Medicamentos", "1 U", "0", "100.00", "0", R.mipmap.med_tosan, "Bodega"));
        itemsList.add(new ProductoItemsModel("Vick Vaporub", "0", "Medicamentos", "1 Lata", "0", "20.00", "0", R.mipmap.med_vickvaporub, "Bodega"));
        itemsList.add(new ProductoItemsModel("Viropulmin", "0", "Medicamentos", "1 U", "0", "60.00", "0", R.mipmap.med_viropulmin, "Bodega"));
        itemsList.add(new ProductoItemsModel("Vitaflenaco", "0", "Medicamentos", "1 U", "0", "6.00", "0", R.mipmap.med_vitaflenaco, "Bodega"));

        //Cigarros
        itemsList.add(new ProductoItemsModel("Belmont Rojo Pequeño", "Belmont Rojo", "Cigarros", "1 Paquete", "1 U", "48.00", "5.00", R.mipmap.cig_beltmontrojo, "Bodega"));
        itemsList.add(new ProductoItemsModel("Belmont Rojo Grande", "Belmont Rojo", "Cigarros", "1 Paquete", "1 U", "70.00", "5.00", R.mipmap.cig_beltmontrojo, "Bodega"));
        itemsList.add(new ProductoItemsModel("Belmont Mentolado Pequeño", "Belmont Mentolado", "Cigarros", "1 Paquete", "1 U", "48.00", "6.00", R.mipmap.cig_beltmontmentolado, "Bodega"));
        itemsList.add(new ProductoItemsModel("Belmont Doble Click Pequeño", "Belmont Doble Click", "Cigarros", "1 Paquete", "1 U", "48.00", "6.00", R.mipmap.cig_beltmontdobleclick, "Bodega"));
        itemsList.add(new ProductoItemsModel("Royal Pequeño", "Royal", "Cigarros", "1 Paquete", "1 U", "30.00", "3.00", R.mipmap.cig_royal, "Bodega"));
        itemsList.add(new ProductoItemsModel("Royal Grande", "Royal", "Cigarros", "1 Paquete", "1 U", "55.00", "3.00", R.mipmap.cig_royal, "Bodega"));

        //Aguas e Hidratantes
        itemsList.add(new ProductoItemsModel("Gatorade", "0", "Aguas e Hidratantes", "1 U", "0", "30.00", "0", R.mipmap.agu_gatorade, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Aguazul 750 ml", "0", "Aguas e Hidratantes", "1 U", "0", "14.00", "0", R.mipmap.agu_aguazul_750ml, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Aguazul 5 lts", "0", "Aguas e Hidratantes", "1 U", "0", "45.00", "0", R.mipmap.agu_aguazul_5lts, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Agua Pingüino 5 Galones", "0", "Aguas e Hidratantes", "1 U", "0", "28.00", "0", R.mipmap.agu_pinguino_botellon, "Agua Pingüino"));
        itemsList.add(new ProductoItemsModel("Agua Pingüino 500 ml Bolsa", "0", "Aguas e Hidratantes", "1 U", "0", "3.00", "0", R.mipmap.agu_pinguino_bolsagrande, "Agua Pingüino"));
        itemsList.add(new ProductoItemsModel("Agua Pingüino 250 ml Bolsa", "0", "Aguas e Hidratantes", "1 U", "0", "2.00", "0", R.mipmap.agu_pinguino_bolsapequena, "Agua Pingüino"));
        itemsList.add(new ProductoItemsModel("Agua Mimos 5 Galones", "0", "Aguas e Hidratantes", "1 U", "0", "28.00", "0", R.mipmap.agu_mimos_botellon, "Agua Mimos"));
        itemsList.add(new ProductoItemsModel("Agua Mimos 500 ml Bolsa", "0", "Aguas e Hidratantes", "1 U", "0", "3.00", "0", R.mipmap.agu_mimos_bolsagrande, "Agua Mimos"));
        itemsList.add(new ProductoItemsModel("Agua Mimos 250 ml Bolsa", "0", "Aguas e Hidratantes", "1 U", "0", "2.00", "0", R.mipmap.agu_mimos_bolsapequena, "Agua Mimos"));

        //Energizantes
        itemsList.add(new ProductoItemsModel("Adrenalina 12 oz Pequeña", "0", "Energizantes", "1 U", "0", "42.00", "0", R.mipmap.ene_adrenalina_10ozpequena, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Adrenalina 16 oz Grande", "0", "Energizantes", "1 U", "0", "48.00", "0", R.mipmap.ene_adrenalina_16ozgrande, "Pepsi"));
        itemsList.add(new ProductoItemsModel("AMP 12 oz Pequeña", "0", "Energizantes", "1 U", "0", "18.00", "0", R.mipmap.ene_amp_12ozpequena, "Pepsi"));
        itemsList.add(new ProductoItemsModel("AMP 500 ml Grande", "0", "Energizantes", "1 U", "0", "23.00", "0", R.mipmap.ene_amp_500ml, "Pepsi"));
        itemsList.add(new ProductoItemsModel("Fury 500 ml", "0", "Energizantes", "1 U", "0", "20.00", "0", R.mipmap.ene_fury_500ml, "Cervecería Hondureña"));
        itemsList.add(new ProductoItemsModel("Raptor 600 ml", "0", "Energizantes", "1 U", "0", "23.00", "0", R.mipmap.ene_raptor_600ml, "AJE"));
        itemsList.add(new ProductoItemsModel("Volt 300 ml Pequeña", "0", "Energizantes", "1 U", "0", "15.00", "0", R.mipmap.ene_volt_300mlpequena, "AJE"));
        itemsList.add(new ProductoItemsModel("Volt 625 ml Grande", "0", "Energizantes", "1 U", "0", "20.00", "0", R.mipmap.ene_volt_625mlgrande, "AJE"));

        //Utiles Escolares
        itemsList.add(new ProductoItemsModel("Lápiz Grafito", "0", "Utiles Escolares", "1 U", "0", "6.00", "0", R.mipmap.uti_lapizgrafito, "ACOSA"));
        itemsList.add(new ProductoItemsModel("Lápiz Tinta", "0", "Utiles Escolares", "1 U", "0", "6.00", "0", R.mipmap.uti_lapiztinta, "ACOSA"));
        itemsList.add(new ProductoItemsModel("Borrador", "0", "Utiles Escolares", "1 U", "0", "6.00", "0", R.mipmap.uti_borrador, "ACOSA"));
        itemsList.add(new ProductoItemsModel("Sacapuntas", "0", "Utiles Escolares", "1 U", "0", "6.00", "0", R.mipmap.uti_sacapuntas, "ACOSA"));
        itemsList.add(new ProductoItemsModel("Lápices de Colores", "0", "Utiles Escolares", "1 Caja", "0", "45.00", "0", R.mipmap.uti_paquetecolores, "ACOSA"));
        itemsList.add(new ProductoItemsModel("Regla", "0", "Utiles Escolares", "1 U", "0", "10.00", "0", R.mipmap.uti_reglatransparente, "ACOSA"));
        itemsList.add(new ProductoItemsModel("Corrector", "0", "Utiles Escolares", "1 U", "0", "20.00", "0", R.mipmap.uti_corrector, "ACOSA"));
        itemsList.add(new ProductoItemsModel("Silicón Pequeño 30 ml", "0", "Utiles Escolares", "1 Bote", "0", "20.00", "0", R.mipmap.uti_siliconpequeno_bote30ml, "ACOSA"));
        itemsList.add(new ProductoItemsModel("Silicón Mediano 100 ml", "0", "Utiles Escolares", "1 Bote", "0", "42.00", "0", R.mipmap.uti_siliconmediano_bote100ml, "ACOSA"));
        itemsList.add(new ProductoItemsModel("Barra de Silicón", "0", "Utiles Escolares", "1 U", "0", "10.00", "0", R.mipmap.uti_tubosilicon, "ACOSA"));
        itemsList.add(new ProductoItemsModel("Pegamento Blanco", "0", "Utiles Escolares", "1 Bote", "0", "15.00", "0", R.mipmap.uti_pegamentoblanco_pequeno, "ACOSA"));
        itemsList.add(new ProductoItemsModel("Cuaderno de Resorte - 1 Materia", "0", "Utiles Escolares", "1 U", "0", "35.00", "0", R.mipmap.uti_cuadernoresorte_1materia, "ACOSA"));
        itemsList.add(new ProductoItemsModel("Cuaderno de Resorte - 2 Materias", "0", "Utiles Escolares", "1 U", "0", "40.00", "0", R.mipmap.uti_cuadernoresorte_2materias, "ACOSA"));
        itemsList.add(new ProductoItemsModel("Cuaderno - 100 Páginas", "0", "Utiles Escolares", "1 U", "0", "20.00", "0", R.mipmap.uti_cuadernopequeno_100paginas, "ACOSA"));
        itemsList.add(new ProductoItemsModel("Cuaderno - 200 Páginas", "0", "Utiles Escolares", "1 U", "0", "25.00", "0", R.mipmap.uti_cuadernopequeno_200paginas, "ACOSA"));
        itemsList.add(new ProductoItemsModel("Tijera", "0", "Utiles Escolares", "1 U", "0", "25.00", "0", R.mipmap.uti_tijera, "ACOSA"));
        itemsList.add(new ProductoItemsModel("Marcador Acrílico", "0", "Utiles Escolares", "1 U", "0", "20.00", "0", R.mipmap.uti_marcadoracrilico, "ACOSA"));
        itemsList.add(new ProductoItemsModel("Marcador Permanente", "0", "Utiles Escolares", "1 U", "0", "20.00", "0", R.mipmap.uti_marcadorpermanente, "ACOSA"));
        itemsList.add(new ProductoItemsModel("Marcadores de Colores", "0", "Utiles Escolares", "1 Paquete", "0", "23.00", "0", R.mipmap.uti_paquetemarcadores, "ACOSA"));
        itemsList.add(new ProductoItemsModel("Cartulina Iris", "0", "Utiles Escolares", "1 U", "0", "16.00", "0", R.mipmap.uti_cartulinairis, "ACOSA"));
        itemsList.add(new ProductoItemsModel("Folder Manila", "0", "Utiles Escolares", "1 U", "0", "6.00", "0", R.mipmap.uti_foldermanila, "ACOSA"));
        itemsList.add(new ProductoItemsModel("Papel Bond", "0", "Utiles Escolares", "1 Hoja", "0", "0.50", "0", R.mipmap.uti_papelbond, "ACOSA"));
        itemsList.add(new ProductoItemsModel("Papel Construcción", "0", "Utiles Escolares", "1 Hoja", "0", "2.00", "0", R.mipmap.uti_papelconstruccion, "ACOSA"));
        itemsList.add(new ProductoItemsModel("Plastilina", "0", "Utiles Escolares", "1 Caja", "0", "30.00", "0", R.mipmap.uti_plastilina, "ACOSA"));


        String productos[] = {"Salsina Naturas"};
        String productos2[] = {"0"};
        String categorias[] = {"Abarrotería"};
        String cantidades[] = {"1 U"};
        String cantidades2[] = {"0"};
        String precios1[] = {"15.00"};
        String precios2[] = {"0"};
        int imagenes[] = {R.mipmap.aba_salsinanaturas};
        String proveedores[] = {"Bodega"};

        for(int i = 0; i < productos.length; i++) {
            ProductoItemsModel itemsModel = new ProductoItemsModel(productos[i], productos2[i], categorias[i], cantidades[i], cantidades2[i], precios1[i], precios2[i], imagenes[i], proveedores[i]);
            itemsList.add(itemsModel);
        }

        return itemsList;
    }


    public List<CatPrvItemsModel> obtenerCategorias() {
        List<CatPrvItemsModel> itemsList = new ArrayList<>();

        itemsList.add(new CatPrvItemsModel("Abarrotería", R.mipmap.cat_abarroteria));
        itemsList.add(new CatPrvItemsModel("Refrescos", R.mipmap.cat_refrescos));
        itemsList.add(new CatPrvItemsModel("Cervezas", R.mipmap.cat_cervezas));
        itemsList.add(new CatPrvItemsModel("Helados", R.mipmap.cat_helados));
        itemsList.add(new CatPrvItemsModel("Jugos", R.mipmap.cat_jugos));
        itemsList.add(new CatPrvItemsModel("Lácteos", R.mipmap.cat_lacteos));
        itemsList.add(new CatPrvItemsModel("Carnes y Embutidos", R.mipmap.cat_carnesembutidos));
        itemsList.add(new CatPrvItemsModel("Churros", R.mipmap.cat_churros));
        itemsList.add(new CatPrvItemsModel("Galletas", R.mipmap.cat_galletas));
        itemsList.add(new CatPrvItemsModel("Panes", R.mipmap.cat_panes));
        itemsList.add(new CatPrvItemsModel("Dulces", R.mipmap.cat_dulces));
        itemsList.add(new CatPrvItemsModel("Aguas e Hidratantes", R.mipmap.cat_aguashidratantes));
        itemsList.add(new CatPrvItemsModel("Energizantes", R.mipmap.cat_energizantes));
        itemsList.add(new CatPrvItemsModel("Medicamentos", R.mipmap.cat_medicamentos));
        itemsList.add(new CatPrvItemsModel("Higiene", R.mipmap.cat_higiene));
        itemsList.add(new CatPrvItemsModel("Limpieza", R.mipmap.cat_limpieza));
        itemsList.add(new CatPrvItemsModel("Cigarros", R.mipmap.cat_cigarros));
        itemsList.add(new CatPrvItemsModel("Plásticos", R.mipmap.cat_plasticos));
        itemsList.add(new CatPrvItemsModel("Verduras", R.mipmap.cat_verduras));
        itemsList.add(new CatPrvItemsModel("Ferretería", R.mipmap.cat_ferreteria));
        itemsList.add(new CatPrvItemsModel("Utiles Escolares", R.mipmap.cat_utilesescolares));

        return itemsList;
    }


    public List<CatPrvItemsModel> obtenerProveedores() {
        List<CatPrvItemsModel> itemsList = new ArrayList<>();

        itemsList.add(new CatPrvItemsModel("Bodega", R.mipmap.logo_bodega));
        itemsList.add(new CatPrvItemsModel("Pepsi", R.mipmap.logo_pepsi));
        itemsList.add(new CatPrvItemsModel("Cervecería Hondureña", R.mipmap.logo_cerveceria));
        itemsList.add(new CatPrvItemsModel("Leyde", R.mipmap.logo_leyde));
        itemsList.add(new CatPrvItemsModel("Sula", R.mipmap.logo_sula));
        itemsList.add(new CatPrvItemsModel("Sarita", R.mipmap.logo_sarita));
        itemsList.add(new CatPrvItemsModel("Dinant", R.mipmap.logo_dinant));
        itemsList.add(new CatPrvItemsModel("Bimbo", R.mipmap.logo_bimbo));
        itemsList.add(new CatPrvItemsModel("Pollo Rey", R.mipmap.logo_pollorey));
        itemsList.add(new CatPrvItemsModel("Cuquis", R.mipmap.logo_pancuquis));
        itemsList.add(new CatPrvItemsModel("Pan Jerusalem", R.mipmap.logo_panjerusalem));
        itemsList.add(new CatPrvItemsModel("Pan San Carlos", R.mipmap.logo_sancarlos));
        itemsList.add(new CatPrvItemsModel("Pan Hawit", R.mipmap.logo_panhawit));
        itemsList.add(new CatPrvItemsModel("Quesería", R.mipmap.logo_queseria));
        itemsList.add(new CatPrvItemsModel("Agua Pingüino", R.mipmap.logo_aguapinguino));
        itemsList.add(new CatPrvItemsModel("Agua Mimos", R.mipmap.logo_aguamimos));
        itemsList.add(new CatPrvItemsModel("Frito Lay", R.mipmap.logo_fritolay));
        itemsList.add(new CatPrvItemsModel("Gamesa", R.mipmap.logo_gamesa));
        itemsList.add(new CatPrvItemsModel("Boca Deli", R.mipmap.logo_bocadeli));
        itemsList.add(new CatPrvItemsModel("Diana", R.mipmap.logo_diana));
        itemsList.add(new CatPrvItemsModel("Rica Sula", R.mipmap.logo_ricasula));
        itemsList.add(new CatPrvItemsModel("ACOSA", R.mipmap.logo_acosa));
        itemsList.add(new CatPrvItemsModel("Tigo", R.mipmap.logo_tigo));
        itemsList.add(new CatPrvItemsModel("Claro", R.mipmap.logo_claro));
        itemsList.add(new CatPrvItemsModel("AJE", R.mipmap.logo_aje));
        itemsList.add(new CatPrvItemsModel("Arroz Progreso", R.mipmap.logo_arrozprogreso));
        itemsList.add(new CatPrvItemsModel("Azúcar El Cañal", R.mipmap.logo_azucarelcanal));
        itemsList.add(new CatPrvItemsModel("Frijol Catrachito", R.mipmap.logo_frijolcatrachito));
        itemsList.add(new CatPrvItemsModel("Tortillas", R.mipmap.logo_tortillas));

        return itemsList;
    }

    //Método que inserta datos en las tablas de Categorias, Proveedores y Productos en la base de datos
    public void insertarDatos(String tabla) {
        //Creamos 3 listas para almacenar los datos de las Categorías, Proveedores y Productos
        List<CatPrvItemsModel> itemsCategorias;
        List<CatPrvItemsModel> itemsProveedores;
        List<ProductoItemsModel> itemsProductos;

        List<Integer> codCategorias = new ArrayList<Integer>();
        List<Integer> codProveedores = new ArrayList<Integer>();

        //Llenamos las 3 listas llamando a sus respectivos métodos que retornan una Lista ya con los datos
        itemsProductos = obtenerProductos();
        itemsCategorias = obtenerCategorias();
        itemsProveedores = obtenerProveedores();

        for (int i = 0; i < itemsProductos.size(); i++) {
            codCategorias.add(codigoCatPrv(itemsProductos.get(i).getCategoria(), 1));
            codProveedores.add(codigoCatPrv(itemsProductos.get(i).getProveedor(), 2));
        }

        //Creamos un objeto de la clase AdminSQLiteOpen y le mandamos los parámetros al constructor de dicha clase. En este caso, como no estamos en una clase que deriva de un activity o un fragment, el contexto lo recuperamos como parámetro y lo mandamos desde una clase que si sea derivada de una activity o fragment
        AdminSQLiteOpen admin = new AdminSQLiteOpen(context, "PulperiaMaritza", null, 1);
        SQLiteDatabase baseDatos = admin.getWritableDatabase();

        //Creamos un switch para insertar datos dependiendo el nombre de la tabla
        switch (tabla) {
            case "Categorias":
                //Creamos un ciclo for que recorre todas las filas de la lista itemsCategorias
                for (int i = 0; i < itemsCategorias.size(); i++) {
                    ContentValues cat = new ContentValues();

                    //Guardamos los datos de "Nombre" e "Imagen" de la "itemsCategorias" en un contentValues llamado "cat" específicando el nombre de la columna correspondiente en la tabla de "Categorias"; como está en un ciclo for, se guardarán hasta que llegue al final de la lista "itemsCategorias"
                    cat.put("CatNombre", itemsCategorias.get(i).getNombre());
                    cat.put("CatImagen", itemsCategorias.get(i).getImagen());

                    //Realizamos la inserción especificando el nombre de la tabla, y al final, colocamos el ContentValues "cat"
                    baseDatos.insert("Categorias", null, cat);
                }

                //Cerramos la conexión a la base de datos
                baseDatos.close();
                break;

            case "Proveedores":
                for (int i = 0; i < itemsProveedores.size(); i++) {
                    ContentValues prv = new ContentValues();

                    prv.put("PrvNombre", itemsProveedores.get(i).getNombre());
                    prv.put("PrvImagen", itemsProveedores.get(i).getImagen());

                    baseDatos.insert("Proveedores", null, prv);
                }

                baseDatos.close();
                break;

            case "Productos":
                //int j = 0;
                for (int i = 0; i < itemsProductos.size(); i++) {
                    ContentValues prd = new ContentValues();

                    prd.put("PrdNombre1", itemsProductos.get(i).getNombre1());
                    prd.put("PrdNombre2", itemsProductos.get(i).getNombre2());
                    prd.put("PrdTipo1", itemsProductos.get(i).getTipo1());
                    prd.put("PrdTipo2", itemsProductos.get(i).getTipo2());
                    prd.put("PrdPrecio1", itemsProductos.get(i).getPrecio1());
                    prd.put("PrdPrecio2", itemsProductos.get(i).getPrecio2());
                    prd.put("CatID", codCategorias.get(i));
                    prd.put("PrvID", codProveedores.get(i));
                    prd.put("PrdImagen", itemsProductos.get(i).getImagen());

                    //j++;

                    baseDatos.insert("Productos", null, prd);
                }

                baseDatos.close();
                break;
        }
    }

    public void insertarDatosCarrito(String nombre, String tipo, String cantidad, String precio, String total, int imagen) {
        //Creamos un objeto de la clase AdminSQLiteOpen y le mandamos los parámetros al constructor de dicha clase. En este caso, como no estamos en una clase que deriva de un activity o un fragment, el contexto lo recuperamos como parámetro y lo mandamos desde una clase que si sea derivada de una activity o fragment
        AdminSQLiteOpen admin = new AdminSQLiteOpen(context, "PulperiaMaritza", null, 1);
        SQLiteDatabase baseDatos = admin.getWritableDatabase();

        try {
            //Creamos un contenedor que almacenará los datos a insertar en la base de datos
            ContentValues datos = new ContentValues();

            //Guardamos los datos en cada campo de la tabla de la base de datos
            datos.put("CrtNombre", nombre);
            datos.put("CrtTipo", tipo);
            datos.put("CrtCantidad", cantidad);
            datos.put("CrtPrecio", precio);
            datos.put("CrtTotal", total);
            datos.put("CrtImagen", imagen);

            //Realizamos la inserción de los datos especificando el nombre de la tabla, y al final, colocamos el ContentValues "datos"
            long id = baseDatos.insert("CarritoTemporal", null, datos);

            if (id > 0)
                Toast.makeText(context, "PRODUCTO AGREGADO EN EL CARRITO", Toast.LENGTH_SHORT).show();
            else
                Toast.makeText(context, "ERROR AL AGREGAR EL PRODUCTO AL CARRITO", Toast.LENGTH_SHORT).show();
        }
        catch (Exception e) {
            Toast.makeText(context, "ERROR AL AGREGAR PRODUCTOS AL CARRITO", Toast.LENGTH_SHORT).show();
        }
        finally {
            if (baseDatos != null) { //Verificamos si "baseDatos" no es null para poder cerrar la conexión
                baseDatos.close();
            }
        }
    }

    public void actualizarDatosCarrito(String nombre, String cantidad, String total) {
        //Creamos un objeto de la clase AdminSQLiteOpen y le mandamos los parámetros al constructor de dicha clase. En este caso, como no estamos en una clase que deriva de un activity o un fragment, el contexto lo recuperamos como parámetro y lo mandamos desde una clase que si sea derivada de una activity o fragment
        AdminSQLiteOpen admin = new AdminSQLiteOpen(context, "PulperiaMaritza", null, 1);
        SQLiteDatabase baseDatos = admin.getWritableDatabase();

        //Creamos un contenedor que almacenará los datos a actualizar en la base de datos
        ContentValues datos = new ContentValues();

        //Hacemos la actualización de los datos solo en los campos que queremos
        datos.put("CrtCantidad", cantidad);
        datos.put("CrtTotal", total);

        //Aquí guardamos un resultado en la variable "confirmacion", si es un 1 fue un éxito, si no es 1 no fue un éxito. "baseDatos.update" porque vamos a actualizar uno o varios elementos de la tabla. También dentro de los paréntesis indicamos primero el nombre de la tabla "CarritoTemporal", luego el ContentValues "datos", la claúsula WHERE para solo actualizar un dato específico, y por último un "null"
        int confirmacion = baseDatos.update("CarritoTemporal", datos, "CrtNombre = '" + nombre + "'", null);

        //Mostramos un mensaje indicando si la modificación de los datos fue un éxito, o si no lo fue
        /*if (confirmacion == 1) {
            Toast.makeText(context, "PRODUCTO DEL CARRITO MODIFICADO", Toast.LENGTH_SHORT).show();
        }
        else {
            Toast.makeText(context, "NO SE MODIFICÓ EL PRODUCTO DEL CARRITO", Toast.LENGTH_SHORT).show();
        }*/
    }

    public void eliminarDatosCarrito(String nombre) {
        //Creamos un objeto de la clase AdminSQLiteOpen y le mandamos los parámetros al constructor de dicha clase. En este caso, como no estamos en una clase que deriva de un activity o un fragment, el contexto lo recuperamos como parámetro y lo mandamos desde una clase que si sea derivada de una activity o fragment
        AdminSQLiteOpen admin = new AdminSQLiteOpen(context, "PulperiaMaritza", null, 1);
        SQLiteDatabase baseDatos = admin.getWritableDatabase();

        int id = baseDatos.delete("CarritoTemporal", "CrtNombre = '"+ nombre +"'", null);
        baseDatos.close();

        if (id == 1)
            Toast.makeText(context, "PRODUCTO ELIMINADO DEL CARRITO", Toast.LENGTH_SHORT).show();
    }

    public void eliminarCarritoCompleto() {
        //Creamos un objeto de la clase AdminSQLiteOpen y le mandamos los parámetros al constructor de dicha clase. En este caso, como no estamos en una clase que deriva de un activity o un fragment, el contexto lo recuperamos como parámetro y lo mandamos desde una clase que si sea derivada de una activity o fragment
        AdminSQLiteOpen admin = new AdminSQLiteOpen(context, "PulperiaMaritza", null, 1);
        SQLiteDatabase baseDatos = admin.getWritableDatabase();

        int id = baseDatos.delete("CarritoTemporal", null, null); //Eliminamos todas las filas de la tabla, por eso en "whereClause" ponemos null ya que no tendremos una condición WHERE
        baseDatos.close(); //Cerramos la conexión

        /*if (id > 0) //Si "id" es mayor a 0, quiere decir que "baseDatos.delete" si afectó (o eliminó) una o varias filas
            Toast.makeText(context, "CARRITO ELIMINADO", Toast.LENGTH_SHORT).show(); //Enviamos un mensaje que se eliminaron todas las filas del carrito*/
    }

    public int insertarVenta(String fecha, int bolsas) {
        //Creamos un objeto de la clase AdminSQLiteOpen y le mandamos los parámetros al constructor de dicha clase. En este caso, como no estamos en una clase que deriva de un activity o un fragment, el contexto lo recuperamos como parámetro y lo mandamos desde una clase que si sea derivada de una activity o fragment
        AdminSQLiteOpen admin = new AdminSQLiteOpen(context, "PulperiaMaritza", null, 1);
        SQLiteDatabase baseDatos = admin.getWritableDatabase();
        List<CarritoItemsModel> itemsCarrito = obtenerCarrito(); //Guardamos los productos del Carrito en la lista "itemsCarrito" de tipo CarritoItemsModel; esto lo hacemos llamando al método "obtenerCarrito()"
        List<Integer> codigosProductos = new ArrayList<Integer>();

        try {
            int id = 0;
            long verificar2 = 0;
            //Creamos dos contenedores que almacenarán los datos a insertar en las tablas "VentasEncabezado" y "VentasDetalle" de la base de datos
            ContentValues encabezado = new ContentValues();
            ContentValues detalle = new ContentValues();

            //Guardamos los datos en cada campo de la tabla "VentasEncabezado" de la base de datos
            encabezado.put("VntFecha", fecha);
            encabezado.put("VntBolsas", bolsas);

            //Realizamos la inserción de los datos especificando el nombre de la tabla, y al final, colocamos el ContentValues "encabezado"
            long verificar1 = baseDatos.insert("VentasEncabezado", null, encabezado);

            //Hacemos una consulta SELECT para encontrar el VntID que se acaba de insertar (como es autonumérico, entonces es el último de la columna), para ello, usamos un "ORDER BY VntID DESC" que nos ordena los resultados de la consulta de forma descendente, y usamos un "LIMIT 1" para que solo nos muestre el primer valor que se encontró en la consulta
            Cursor codigo = baseDatos.rawQuery("SELECT VntID FROM VentasEncabezado ORDER BY VntID DESC LIMIT 1", null);

            if (codigo.moveToFirst()) //Utilizamos el "if (codigo.moveToFirst())" para mover el cursor "codigo" a la primera fila de registros que encontró en la sentencia SELECT
                id = codigo.getInt(0);

            for (int i = 0; i < itemsCarrito.size(); i++) {
                codigosProductos.add(codigoProducto(itemsCarrito.get(i).getNombre()));
            }

            for (int i = 0; i < itemsCarrito.size(); i++) {
                //Guardamos los datos en cada campo de la tabla "VentasDetalle" de la base de datos
                detalle.put("VntID", id); //Guardamos el ID de la última inserción en la tabla "VentasEncabezado", dicho ID está guardado en la variable "id"
                detalle.put("PrdID", codigosProductos.get(i)); //CAMBIAR POR SKU!!!!! | Como el ID del producto no está en la lista "itemsCarrito", llamamos al método "codigoProducto()" y le mandamos el nombre del producto como parámetro
                detalle.put("PrdPrecio", Double.parseDouble(itemsCarrito.get(i).getPrecio())); //Convertimos a Double porque en la BDD el campo es de tipo REAL
                detalle.put("PrdCantidad", Double.parseDouble(itemsCarrito.get(i).getCantidad())); //Convertimos a Double porque en la BDD el campo es de tipo REAL
                detalle.put("PrdTipo", itemsCarrito.get(i).getTipo());

                verificar2 = baseDatos.insert("VentasDetalle", null, detalle);
            }

            if (verificar1 > 0 && verificar2 > 0) { //Si ambos "verificar" son mayores a 0, quiere decir que ambas inserciones a las tablas "VentasEncabezado" y "VentasDetalle" se realizaron correctamente
                Toast.makeText(context, "VENTA CONFIRMADA", Toast.LENGTH_SHORT).show();
                return 1; //Retornamos 1 si se completó la confirmación
            }
            else { //Si una o las dos inserciones no se realizaron bien (uno o ambos "verificar" no son mayores a 0), entonces se mostrará un mensaje de error
                Toast.makeText(context, "ERROR AL CONFIRMAR LA VENTA", Toast.LENGTH_SHORT).show();
                return 0; //Retornamos 0 si hubo un error
            }
        }
        catch (Exception e) {
            Toast.makeText(context, "ERROR AL CONFIRMAR LA VENTA", Toast.LENGTH_SHORT).show();
        }
        finally {
            if (baseDatos != null) { //Verificamos si "baseDatos" no es null para poder cerrar la conexión
                baseDatos.close();
            }
        }

        return -1; //Retornamos -1 por cualquier cosa
    }

    //Método para obtener todos los productos de la base de datos
    public List<ProductoItemsModel> obtenerProductosBDD() {

        //Creamos una lista de tipo "ProductoItemsModel" para guardar los elementos extraídos de la Base de datos
        List<ProductoItemsModel> listaItems = new ArrayList<>();

        //Creamos un objeto de la clase AdminSQLiteOpen y le mandamos los parámetros al constructor de dicha clase. En este caso, como no estamos en una clase que deriva de un activity o un fragment, el contexto lo recuperamos como parámetro y lo mandamos desde una clase que si sea derivada de una activity o fragment
        AdminSQLiteOpen admin = new AdminSQLiteOpen(context, "PulperiaMaritza", null, 1);
        SQLiteDatabase baseDatos = admin.getWritableDatabase();

        try {
            //Creamos un cursor "fila" que recupera todos los valores encontrados en la siguiente sentencia SELECT
            Cursor fila = baseDatos.rawQuery("SELECT A.PrdNombre1, A.PrdNombre2, B.CatNombre, A.PrdTipo1, A.PrdTipo2, A.PrdPrecio1, A.PrdPrecio2, A.PrdImagen, C.PrvNombre FROM Productos A INNER JOIN Categorias B ON A.CatID = B.CatID INNER JOIN Proveedores C ON A.PrvID = C.PrvID", null);

            if (fila.moveToFirst()) { //Utilizamos el "if (fila.moveToFirst())" para mover el cursor "fila" a la primera fila de registros que encontró en la sentencia SELECT
                do { //Hacemos un do-while que va a recorrer todas las filas de datos que haya encontrado el cursor "fila"
                    listaItems.add(new ProductoItemsModel(fila.getString(0), fila.getString(1), fila.getString(2), fila.getString(3), fila.getString(4), fila.getString(5), fila.getString(6), fila.getInt(7), fila.getString(8)));
                } while (fila.moveToNext());
            }
        }
        catch (Exception e) {
            Toast.makeText(context, "ERROR AL OBTENER LOS PRODUCTOS", Toast.LENGTH_LONG).show();
        }
        finally {
            if (baseDatos != null) { //Verificamos si "baseDatos" no es null para poder cerrar la conexión
                baseDatos.close();
            }
        }

        //Retornamos la lista con los datos de los Productos
        return listaItems;
    }

    //Método para obtener todas las categorías de la base de datos
    public List<CatPrvItemsModel> obtenerCategoriasBDD() {

        //Creamos una lista de tipo "CatPrvItemsModel" para guardar los elementos extraídos de la Base de datos
        List<CatPrvItemsModel> categoriasItems = new ArrayList<>();

        //Creamos un objeto de la clase AdminSQLiteOpen y le mandamos los parámetros al constructor de dicha clase. En este caso, como no estamos en una clase que deriva de un activity o un fragment, el contexto lo recuperamos como parámetro y lo mandamos desde una clase que si sea derivada de una activity o fragment
        AdminSQLiteOpen admin = new AdminSQLiteOpen(context, "PulperiaMaritza", null, 1);
        SQLiteDatabase baseDatos = admin.getWritableDatabase();

        try {
            //Creamos un cursor "fila" que recupera todos los valores encontrados en la siguiente sentencia SELECT
            Cursor fila = baseDatos.rawQuery("SELECT CatNombre, CatImagen FROM Categorias", null);

            if (fila.moveToFirst()) { //Utilizamos el "if (fila.moveToFirst())" para mover el cursor "fila" a la primera fila de registros que encontró en la sentencia SELECT
                do { //Hacemos un do-while que va a recorrer todas las filas de datos que haya encontrado el cursor "fila"
                    categoriasItems.add(new CatPrvItemsModel(fila.getString(0), fila.getInt(1)));
                } while (fila.moveToNext());
            }
        }
        catch (Exception e) {
            Toast.makeText(context, "ERROR AL OBTENER LAS CATEGORÍAS", Toast.LENGTH_LONG).show();
        }
        finally {
            if (baseDatos != null) { //Verificamos si "baseDatos" no es null para poder cerrar la conexión
                baseDatos.close();
            }
        }

        //Retornamos la lista con los datos de las Categorías
        return categoriasItems;
    }

    //Método para obtener todos los proveedores de la base de datos
    public List<CatPrvItemsModel> obtenerProveedoresBDD() {
        //Creamos una lista de tipo "CatPrvItemsModel" para guardar los elementos extraídos de la Base de datos
        List<CatPrvItemsModel> proveedoresItems = new ArrayList<>();

        //Creamos un objeto de la clase AdminSQLiteOpen y le mandamos los parámetros al constructor de dicha clase. En este caso, como no estamos en una clase que deriva de un activity o un fragment, el contexto lo recuperamos como parámetro y lo mandamos desde una clase que si sea derivada de una activity o fragment
        AdminSQLiteOpen admin = new AdminSQLiteOpen(context, "PulperiaMaritza", null, 1);
        SQLiteDatabase baseDatos = admin.getWritableDatabase();

        try {
            //Creamos un cursor "fila" que recupera todos los valores encontrados en la siguiente sentencia SELECT
            Cursor fila = baseDatos.rawQuery("SELECT PrvNombre, PrvImagen FROM Proveedores", null);

            if (fila.moveToFirst()) { //Utilizamos el "if (fila.moveToFirst())" para mover el cursor "fila" a la primera fila de registros que encontró en la sentencia SELECT
                do { //Hacemos un do-while que va a recorrer todas las filas de datos que haya encontrado el cursor "fila"
                    proveedoresItems.add(new CatPrvItemsModel(fila.getString(0), fila.getInt(1)));
                } while (fila.moveToNext());
            }
        }
        catch (Exception e) {
            Toast.makeText(context, "ERROR AL OBTENER LOS PROVEEDORES", Toast.LENGTH_LONG).show();
        }
        finally {
            if (baseDatos != null) { //Verificamos si "baseDatos" no es null para poder cerrar la conexión
                baseDatos.close();
            }
        }

        //Retornamos la lista con los datos de los Proveedores
        return proveedoresItems;
    }

    //Método para obtener los productos dependiendo la categoría seleccionada
    public List<ProductoItemsModel> obtenerProductosPorCategoria(String categoria) {
        List<ProductoItemsModel> itemsTodos;
        List<ProductoItemsModel> itemsCategoria = new ArrayList<>();

        itemsTodos = obtenerProductosBDD();

        //Recorremos toda la lista itemsTodos, y cuando encuentre una categoría con el mismo nombre guardado en la variable "categoria", que agregue ese elemento a la lista "itemsCategoria"
        for(int i = 0; i < itemsTodos.size(); i++) {
            if (categoria.contentEquals(itemsTodos.get(i).getCategoria())) {
                itemsCategoria.add(new ProductoItemsModel(itemsTodos.get(i).getNombre1(), itemsTodos.get(i).getNombre2(), itemsTodos.get(i).getCategoria(), itemsTodos.get(i).getTipo1(), itemsTodos.get(i).getTipo2(), itemsTodos.get(i).getPrecio1(), itemsTodos.get(i).getPrecio2(), itemsTodos.get(i).getImagen(), itemsTodos.get(i).getProveedor()));
            }
        }

        return itemsCategoria;
    }

    //Método para obtener los productos dependiendo el proveedor seleccionado
    public List<ProductoItemsModel> obtenerProductosPorProveedor(String proveedor) {
        List<ProductoItemsModel> itemsTodos;
        List<ProductoItemsModel> itemsProveedor = new ArrayList<>();

        itemsTodos = obtenerProductosBDD();

        //Recorremos toda la lista itemsTodos, y cuando encuentre un proveedor con el mismo nombre guardado en la variable "proveedor", que agregue ese elemento a la lista "itemsProveedor"
        for(int i = 0; i < itemsTodos.size(); i++) {
            if (proveedor.contentEquals(itemsTodos.get(i).getProveedor())) {
                itemsProveedor.add(new ProductoItemsModel(itemsTodos.get(i).getNombre1(), itemsTodos.get(i).getNombre2(), itemsTodos.get(i).getCategoria(), itemsTodos.get(i).getTipo1(), itemsTodos.get(i).getTipo2(), itemsTodos.get(i).getPrecio1(), itemsTodos.get(i).getPrecio2(), itemsTodos.get(i).getImagen(), itemsTodos.get(i).getProveedor()));
            }
        }

        return itemsProveedor;
    }

    public List<CarritoItemsModel> obtenerCarrito() {
        List<CarritoItemsModel> itemsCarrito = new ArrayList<>(); //Creamos una lista de tipo "CarritoItemsModel" para guardar los datos del Carrito

        //Creamos un objeto de la clase AdminSQLiteOpen y le mandamos los parámetros al constructor de dicha clase. En este caso, como no estamos en una clase que deriva de un activity o un fragment, el contexto lo recuperamos como parámetro y lo mandamos desde una clase que si sea derivada de una activity o fragment
        AdminSQLiteOpen admin = new AdminSQLiteOpen(context, "PulperiaMaritza", null, 1);
        SQLiteDatabase baseDatos = admin.getWritableDatabase();

        try {
            Cursor fila = baseDatos.rawQuery("SELECT CrtNombre, CrtTipo, CrtCantidad, CrtPrecio, CrtTotal, CrtImagen FROM CarritoTemporal", null); //Creamos un cursor que guardará los datos que retorne la consulta SELECT

            if (fila.moveToFirst()) { //Utilizamos el "if (fila.moveToFirst())" para mover el cursor "fila" a la primera fila de registros que encontró en la sentencia SELECT
                do { //Hacemos un do-while que va a recorrer todas las filas de datos que haya encontrado el cursor "fila"
                    itemsCarrito.add(new CarritoItemsModel(fila.getString(0), fila.getString(1), fila.getString(2), fila.getString(3), fila.getString(4), fila.getInt(5))); //Guardamos cada fila de datos del cursor en la lista "itemsCarrito"
                } while (fila.moveToNext());
            }
        }
        catch (Exception e) {
            Toast.makeText(context, "ERROR AL OBTENER LOS DATOS DEL CARRITO", Toast.LENGTH_SHORT).show();
        }
        finally {
            if (baseDatos != null) { //Verificamos si "baseDatos" no es null para poder cerrar la conexión
                baseDatos.close();
            }
        }

        return itemsCarrito; //Retornamos la lista "itemsCarrito"
    }

    public List<HistVentasItemsModel> obtenerVentas() {
        List<HistVentasItemsModel> itemsVentas = new ArrayList<>(); //Creamos una lista de tipo "HistVentasItemsModel" para guardar los datos de las ventas

        //Creamos un objeto de la clase AdminSQLiteOpen y le mandamos los parámetros al constructor de dicha clase. En este caso, como no estamos en una clase que deriva de un activity o un fragment, el contexto lo recuperamos como parámetro y lo mandamos desde una clase que si sea derivada de una activity o fragment
        AdminSQLiteOpen admin = new AdminSQLiteOpen(context, "PulperiaMaritza", null, 1);
        SQLiteDatabase baseDatos = admin.getWritableDatabase();

        try {
            Cursor fila = baseDatos.rawQuery("SELECT A.VntID, A.VntFecha, SUM(B.PrdPrecio * B.PrdCantidad) + A.VntBolsas [Total] FROM VentasEncabezado A INNER JOIN VentasDetalle B ON A.VntID = B.VntID GROUP BY A.VntID, A.VntFecha", null); //Creamos un cursor que guardará los datos que retorne la consulta SELECT

            if (fila.moveToFirst()) { //Utilizamos el "if (fila.moveToFirst())" para mover el cursor "fila" a la primera fila de registros que encontró en la sentencia SELECT
                do { //Hacemos un do-while que va a recorrer todas las filas de datos que haya encontrado el cursor "fila"
                    itemsVentas.add(new HistVentasItemsModel(String.valueOf(fila.getInt(0)), fila.getString(1), String.format("%.2f", fila.getFloat(2)))); //Guardamos cada fila de datos del cursor en la lista "itemsVentas"
                } while (fila.moveToNext());
            }
        }
        catch (Exception e) {
            Toast.makeText(context, "ERROR AL OBTENER EL HISTORIAL DE VENTAS", Toast.LENGTH_SHORT).show();
        }
        finally {
            if (baseDatos != null) { //Verificamos si "baseDatos" no es null para poder cerrar la conexión
                baseDatos.close();
            }
        }

        return itemsVentas; //Retornamos la lista "itemsVentas"
    }

    //Método para extraer los códigos de las categorías y proveedores
    public int codigoCatPrv(String nombre, int tipo) {  //"nombre" recibe el nombre de Categoría/Proveedor, y "tipo" si es 1, vamos a encontrar el código de la categoría, pero si es 2, vamos a encontrar el código del proveedor
        //Creamos un objeto de la clase AdminSQLiteOpen y le mandamos los parámetros al constructor de dicha clase. En este caso, como no estamos en una clase que deriva de un activity o un fragment, el contexto lo recuperamos como parámetro y lo mandamos desde una clase que si sea derivada de una activity o fragment
        AdminSQLiteOpen admin = new AdminSQLiteOpen(context, "PulperiaMaritza", null, 1);
        SQLiteDatabase baseDatos = admin.getWritableDatabase();

        try {
            if (tipo == 1) { //Si "tipo" es 1, buscamos el CatID
                Cursor cat = baseDatos.rawQuery("SELECT CatID FROM Categorias WHERE CatNombre = '" + nombre + "'", null);

                if (cat.moveToFirst()) //Retornamos el código encontrado en el cursor "cat"
                    return cat.getInt(0);
            }
            else { //Si "tipo" no es 1, buscamos el PrvID
                Cursor prv = baseDatos.rawQuery("SELECT PrvID FROM Proveedores WHERE PrvNombre = '" + nombre + "'", null);

                if (prv.moveToFirst()) //Retornamos el código encontrado en el cursor "prv"
                    return prv.getInt(0);
            }
        }
        catch (Exception e) {
            Toast.makeText(context, "ERROR AL OBTENER EL CÓDIGO", Toast.LENGTH_SHORT).show();
        }
        finally {
            if (baseDatos != null) { //Verificamos si "baseDatos" no es null para poder cerrar la conexión
                baseDatos.close();
            }
        }

        return 0; //Retornamos 0 si lo anterior da error
    }

    public int codigoProducto(String nombre) { //CAMBIAR POR SKU!!!!
        //Creamos un objeto de la clase AdminSQLiteOpen y le mandamos los parámetros al constructor de dicha clase. En este caso, como no estamos en una clase que deriva de un activity o un fragment, el contexto lo recuperamos como parámetro y lo mandamos desde una clase que si sea derivada de una activity o fragment
        AdminSQLiteOpen admin = new AdminSQLiteOpen(context, "PulperiaMaritza", null, 1);
        SQLiteDatabase baseDatos = admin.getWritableDatabase();

        try {
            //Creamos un cursor llamado "id", que almacena el resultado que retorne la siguiente consulta SELECT
            Cursor id = baseDatos.rawQuery("SELECT PrdID FROM Productos WHERE PrdNombre1 = '" + nombre + "' OR PrdNombre2 = '" + nombre + "'", null);

            if (id.moveToFirst()) //Utilizamos el "if (id.moveToFirst())" para mover el cursor "id" a la primera fila de registros que encontró en la sentencia SELECT
                return id.getInt(0); //Si la condición del if encontró un primer registro, entonces retornamos dicho registro con "return id.getInt(0)" (0 es la posición del primer registro encontrado)
        }
        catch (Exception e) {
            Toast.makeText(context, "ERROR AL OBTENER EL CÓDIGO DEL PRODUCTO", Toast.LENGTH_SHORT).show();
        }
        finally {
            if (baseDatos != null) { //Verificamos si "baseDatos" no es null para poder cerrar la conexión
                baseDatos.close();
            }
        }

        return -1; //Retornamos -1 si lo anterior da error
    }
}
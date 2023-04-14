package com.example.pulperiamaritza.Modelos;

public class ProductoItemsModel {
    private String nombre;
    private String categoria;
    private String tipo1;
    private String tipo2;
    private String precio1;
    private String precio2;
    private int imagen;
    private String proveedor;

    public ProductoItemsModel(String nombre, String categoria, String tipo1, String tipo2, String precio1, String precio2, int imagen, String proveedor) {
        this.nombre = nombre;
        this.categoria = categoria;
        this.tipo1 = tipo1;
        this.tipo2 = tipo2;
        this.precio1 = precio1;
        this.precio2 = precio2;
        this.imagen = imagen;
        this.proveedor = proveedor;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCategoria() {
        return categoria;
    }

    public void setCategoria(String categoria) {
        this.categoria = categoria;
    }

    public String getTipo1() {
        return tipo1;
    }

    public void setTipo1(String tipo1) { this.tipo1 = tipo1; }

    public String getTipo2() { return tipo2; }

    public void setTipo2(String tipo2) { this.tipo2 = tipo2; }

    public String getPrecio1() { return precio1; }

    public void setPrecio1(String precio1) {
        this.precio1 = precio1;
    }

    public String getPrecio2() { return precio2; }

    public void setPrecio2(String precio2) { this.precio2 = precio2; }

    public int getImagen() {
        return imagen;
    }

    public void setImagen(int imagen) {
        this.imagen = imagen;
    }

    public String getProveedor() {
        return proveedor;
    }

    public void setProveedor(String proveedor) {
        this.proveedor = proveedor;
    }
}

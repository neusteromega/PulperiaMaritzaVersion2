package com.example.pulperiamaritza.Modelos;

public class HistVentasItemsModel {
    private String codigo;
    private String fecha;
    private String total;

    public HistVentasItemsModel(String codigo, String fecha, String total) {
        this.codigo = codigo;
        this.fecha = fecha;
        this.total = total;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getFecha() {
        return fecha;
    }

    public void setFecha(String fecha) {
        this.fecha = fecha;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }
}

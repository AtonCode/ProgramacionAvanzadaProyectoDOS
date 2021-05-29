package model;

import java.util.ArrayList;

public class Cliente{

    private double cedula;
    private String nombre;
    private ArrayList<Factura> historialCompras;

    public Cliente(double cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.historialCompras = new ArrayList<Factura>();
    }

    public double getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void HistorialCompras(Factura factura) {
        this.historialCompras.add(factura);
    }
    public ArrayList<Factura> getHistorialCompras() {
        return historialCompras;
    }
}

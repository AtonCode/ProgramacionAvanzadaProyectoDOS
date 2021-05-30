package model;

import java.util.ArrayList;

public class Cliente{

    private double cedula;
    private String nombre;
    private ArrayList<Factura> historialCompras;// se lleca cn factura

    public Cliente() {
    }

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

    public void comprar(ArrayList<Producto> producto){
        Factura factura=new Factura(producto);
        factura.calcular_TotalPrecio();
        factura.getTotalPrecio();
        factura.getNumeroProductos();
        this.historialCompras.add(factura);
    }

    public ArrayList<Factura> getHistorialCompras() {
        return historialCompras;
    }

}

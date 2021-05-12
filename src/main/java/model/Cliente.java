package model;

import java.util.ArrayList;

public class Cliente{

    private int cedula;
    private String nombre;

    private ArrayList<Venta> historialCompras=new ArrayList<Venta>();

    public Cliente(int cedula, String nombre) {
        this.cedula = cedula;
        this.nombre = nombre;
    }

    public int getCedula() {
        return cedula;
    }

    public String getNombre() {
        return nombre;
    }

    public void llenarHistorialCompras(){

    }
}

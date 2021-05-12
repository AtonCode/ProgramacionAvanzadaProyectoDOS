package model;

import java.util.ArrayList;

public class Sucursal extends Tienda {

    private boolean abierta;
    private ArrayList<Venta> historialVentas=new ArrayList<Venta>();

    public Sucursal(String nombre, String ubicacion) {
        super(nombre, ubicacion);
        this.abierta = true;
    }

    public boolean isAbierta() {
        return abierta;
    }
    public void setAbierta(boolean abierta) {
        this.abierta = abierta;
    }
}

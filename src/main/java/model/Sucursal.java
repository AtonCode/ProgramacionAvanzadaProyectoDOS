package model;

import java.util.ArrayList;

public class Sucursal extends Tienda {
    private int idSucursal;
    private boolean abierta;
    private ArrayList<Producto> inventario=new ArrayList<Producto>();


    public Sucursal(int idSucursal, String nombre, String ubicacion) {
        super(nombre, ubicacion);
        this.abierta = true;
        this.idSucursal = idSucursal;
    }

    public int getIdSucursal() {
        return idSucursal;
    }
    public boolean isAbierta() { return abierta; }
    public void setAbierta(boolean abierta) {
        this.abierta = abierta;
    }
    public ArrayList<Producto> getInventario() {
        return inventario;
    }

    public void setProductoInventario(Producto producto) {
        this.inventario.add(producto);
    }
}

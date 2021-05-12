package model;

import java.util.ArrayList;

public class Tienda {

    private String nombre;
    private String ubicacion;

    private ArrayList<Sucursal> sucursales=new ArrayList<Sucursal>();
    private ArrayList<Producto> inventarioGeneral = new ArrayList<Producto>();
    private ArrayList<Cliente> clientesGeneral = new ArrayList<Cliente>();

    public Tienda(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;
    }

    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public String getUbicacion() {
        return ubicacion;
    }
    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public int getNumSucursales() {
        return sucursales.size();
    }

    public void addSucursal(Sucursal sucursal){
        sucursales.add(sucursal);
    }



}

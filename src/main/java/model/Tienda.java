package model;

import java.util.ArrayList;

public class Tienda {

    private String nombre;
    private String ubicacion;

    private ArrayList<Sucursal> sucursales;
    private ArrayList<Producto> inventarioGeneral;
    private ArrayList<Cliente> clientesGeneral;

    public Tienda(String nombre, String ubicacion) {
        this.nombre = nombre;
        this.ubicacion = ubicacion;

        this.sucursales = new ArrayList<Sucursal>();
        this.inventarioGeneral = new ArrayList<Producto>();
        this.clientesGeneral = new ArrayList<Cliente>();
    }

    public String getNombre() {
        return nombre;
    }
    public ArrayList<Sucursal> getSucursales() {
        return sucursales;
    }
    public ArrayList<Producto> getInventarioGeneral() {
        return inventarioGeneral;
    }
    public ArrayList<Cliente> getClientesGeneral() {
        return clientesGeneral;
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
    public void agregarProductos(ArrayList <Producto> productos){
        for(Producto pr: productos) {
            this.inventarioGeneral.add(pr); // recive un arraylist de inventraio y lo recorrre, copiando cada producto en el array general
        }
    }
    public void setSucursales(Sucursal s) {
        this.sucursales.add(s);
    }

    public void eliminarSucursal(Sucursal s){
        this.sucursales.remove(s);
    }

}

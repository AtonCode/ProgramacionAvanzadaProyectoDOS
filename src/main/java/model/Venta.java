package model;

import java.util.ArrayList;

public class Venta {

    private Factura factura;
    private ArrayList<Producto> carritoCompra = new ArrayList<Producto>();

    public Venta(){
    }

    public Factura getFactura() {
        return factura;
    }
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    public ArrayList<Producto> getCarritoCompra() {
        return carritoCompra;
    }
    public void setCarritoCompra(ArrayList<Producto> carritoCompra) {
        this.carritoCompra = carritoCompra;
    }
    public int getNumeroProductos() {
        return carritoCompra.size();
    }
    private void  llenarCarritoCompra(Producto producto){
        carritoCompra.add(producto);
    }
    private void generarFactura(){
        this.factura = new Factura(this.carritoCompra);
    }
}

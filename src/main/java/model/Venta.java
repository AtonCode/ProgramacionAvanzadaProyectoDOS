package model;

import java.util.ArrayList;

public class Venta {

    private Factura factura;
    private ArrayList<Producto> Compras = new ArrayList<Producto>();

    public Venta() {
    }

    public Venta(ArrayList<Producto> compras) {
        Compras = compras;
    }

    public Factura getFactura() {
        return factura;
    }
    public void setFactura(Factura factura) {
        this.factura = factura;
    }
    public ArrayList<Producto> getCarritoCompra() {
        return Compras;
    }
    public void setCarritoCompra(ArrayList<Producto> carritoCompra) {
        this.Compras = carritoCompra;
    }
    public int getNumeroProductos() {
        return Compras.size();
    }
    public void  llenarCarritoCompra(Producto producto){ Compras.add(producto);
    }
    public void generarFactura(){
        this.factura = new Factura(this.Compras);
    }
}

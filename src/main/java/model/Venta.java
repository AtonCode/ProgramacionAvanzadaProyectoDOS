package model;

import java.util.ArrayList;

public class Venta {

    private Factura factura;
    private ArrayList<Producto> carritoCompra = new ArrayList<Producto>();

    public Venta(){

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

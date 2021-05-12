
package model;
import java.util.ArrayList;

public class Factura {

    private int totalPrecio;
    private ArrayList<Producto> carritoCompra;

    public Factura(ArrayList<Producto> carritoCompra) {
        this.carritoCompra = carritoCompra;
        }

    public int getTotalPrecio() {
        return totalPrecio;
    }
    public ArrayList<Producto> getCarritoCompra() {
        return carritoCompra;
    }
    public int getNumeroProductos(){
        return this.carritoCompra.size();
    }

    public void calcular_TotalPrecio(){

        for (Producto p:carritoCompra) {
            this.totalPrecio += p.precio;
        }

    }
    public void generar_txt(){

    }

}

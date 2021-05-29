
package model;
import java.util.ArrayList;
import java.util.Date;

public class Factura {

    private int totalPrecio;
    private int cantdiadTotal;
    private Date fecha;
    private ArrayList<Producto> carritoCompra;

    public Factura(ArrayList<Producto> carritoCompra) {
        this.carritoCompra = carritoCompra;
        this.fecha = new Date();
    }

    public int getTotalPrecio() {
        return totalPrecio;
    }

    public ArrayList<Producto> getCarritoCompra() {
        return carritoCompra;
    }

    public int getNumeroProductos() {
        return this.carritoCompra.size();
    }

    public int getCantdiadTotal() {
        return cantdiadTotal;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setCarritoCompra(Producto producto) {
        this.carritoCompra.add(producto);
    }

    public void calcular_TotalPrecio() {
        int cont = 0;
        for (Producto p : carritoCompra) {
            this.totalPrecio += p.getPrecio();
            cont++;
        }
        this.cantdiadTotal = cont;
    }

    public void generar_txt() {

    }
    public void imprimir(){
        System.out.println("Fecha: "+this.fecha);
        System.out.println("--------------------------------------");
        for(Producto producto: carritoCompra){
            System.out.println(producto.getNombre()+'\t'+producto.getPrecio());
        }
        System.out.println("--------------------------------------");
        System.out.println("     ");
        System.out.println("Total de productos: "+this.cantdiadTotal+'\t'+"Precio total: "+this.totalPrecio);
        System.out.println("--------------------------------------");
    }
}

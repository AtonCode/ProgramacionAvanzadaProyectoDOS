
package model;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
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

        try (
             FileWriter fw = new FileWriter("factura.txt");
             BufferedWriter bw = new BufferedWriter(fw)) {
            for (Producto p: this.carritoCompra) {
                bw.write("Fecha: "+this.fecha);
                bw.write("ID: "+p.getId()+"\t"+" Nombre: "+ p.getNombre()+'\t'+" Precio $: "+p.getPrecio());
                bw.newLine();
            }
            bw.write("Total de Productos: "+this.cantdiadTotal+'\t'+" Precio Total: $"+this.totalPrecio);
            bw.newLine();

            System.out.println("Archivo correctamente escrito");
        }catch(IOException ioe) {
            System.err.println("Error al procesar archivo: "+ioe.getMessage());
            ioe.printStackTrace();
        }

    }
    public void imprimir(){
        System.out.println("Fecha: "+this.fecha);
        System.out.println("--------------------------------------");
        for(Producto producto: carritoCompra){
            System.out.println("Nombre: "+producto.getNombre()+'\t'+producto.getPrecio());
        }
        System.out.println("--------------------------------------");
        System.out.println("     ");
        System.out.println("Total de productos: "+this.cantdiadTotal+'\t'+" Precio total: "+this.totalPrecio);
        System.out.println("--------------------------------------");
    }
}

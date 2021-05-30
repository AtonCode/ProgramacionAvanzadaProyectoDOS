package control;
import model.Cliente;
import model.Producto;
import model.Sucursal;
import model.Tienda;

import java.util.ArrayList;


public class ControlTienda {

    private Tienda tienda;
    private int numSucursales;
    private ControlInventario controlInventario;

    public ControlTienda() {
        this.tienda = new Tienda("GigaByte", "WWW");
        this.controlInventario = new ControlInventario(this.tienda);
        this.controlInventario.cargar_inventarioProductosComponente("/Users/atoncode/Documents/GitHub/ProgramacionAvanzadaProyectoDOS/src/main/java/recursos/a.csv");
        //this.controlInventario.cargar_inventarioProductosDispositivo("/Users/atoncode/Documents/GitHub/ProgramacionAvanzadaProyectoDOS/src/main/java/recursos/b.csv");

    }

    public Tienda getTienda() {
        return tienda;
    }

    public int getNumSucursales() {
        return numSucursales;
    }
    public ControlInventario getControlInventario() {
        return controlInventario;
    }


    //Cliente
    public void crearCliente(double cedula, String nombre){
        Cliente cliente = new Cliente(cedula,nombre);
        this.tienda.getClientesGeneral().add(cliente);
    }
    public void eliminarCliente(double cedula){
        for (Cliente c: this.tienda.getClientesGeneral()) {
            if(c.getCedula()== cedula){
                this.tienda.getClientesGeneral().remove(c);
                break;
            }else System.out.println("No Existe");
        }
    }

    public Cliente buscarCliente(double cedula){
        Cliente cliente=new Cliente ();
        for (Cliente c: this.tienda.getClientesGeneral()) {
            if(c.getCedula()== cedula){
                cliente=c;
                break;
            }else System.out.println("No Existe");
        }
        return cliente;
    }


    //Sucursal
    public void crearSucursal(int id, String nombre, String ubicacion){
        Sucursal sucursal = new Sucursal(id, nombre,ubicacion);
        this.tienda.setSucursales(sucursal);
        this.numSucursales = this.tienda.getNumSucursales();
    }
    public void eliminarSucursal(int idSucursalEliminar){
        for (Sucursal sucursal: this.tienda.getSucursales()){
            if(sucursal.getIdSucursal() == idSucursalEliminar){
                this.tienda.getSucursales().remove(sucursal);
                System.out.println("Sucursal ID: " + sucursal.getIdSucursal() + " ELIMINADA");
                break;
            }
        }
    }

    public Sucursal mostrarSucursal(){
        for (Sucursal s:this.tienda.getSucursales()) {
            return s;
        }
        return null;
    }

    public void crearInventarioGeneral() {// esta funcion recolecta el inventario de las sucursales y l concatena en el inventario general

        for(int i=0; i<numSucursales;i++) {
            ArrayList<Sucursal> tempsucursales = new ArrayList<Sucursal>();// array temporal en el cual almaceno las sucusales
            tempsucursales.addAll(this.tienda.getSucursales());//arraylist temporal

            Sucursal[] temp=new Sucursal[tempsucursales.size()];//creo un array que me almacena las sucursales
            temp= tempsucursales.toArray(temp);// transfier la informacion del array.

                tienda.agregarProductos(temp[i].getInventario());
        }
    }

    //Inventario
    public boolean consultaDisponibilidadProductoInventario(int id){
        boolean disponibilidad=false;
        for (Producto p: this.tienda.getInventarioGeneral()) {
            if(p.getId() == id){
                if(p.getCantidad()>0) {
                    System.out.println("Disponible");
                    disponibilidad=true;
                    break;
                }else System.out.println("No Disponible");
            }
        }
        return disponibilidad;
    }
    public void addProductoInventario(Producto producto){
        this.tienda.getInventarioGeneral().add(producto);
    }

    public void eliminarProductoInventario(int id){
        for (Producto p: this.tienda.getInventarioGeneral()) {
            if((p.getId() == id)){
                this.tienda.getInventarioGeneral().remove(p);
                System.out.println("Producto ID: "+id+" ELIMINADO");
                break;
            }
        }
    }
    public void editarCantidadProductoInventario(int id, int nuevaCantidad){
        for (Producto p: this.tienda.getInventarioGeneral()) {
            if((p.getId() == id)){
                p.setCantidad(nuevaCantidad);
                System.out.println("Producto ID: "+id+" Modificado");
                break;
            }
        }
    }
}

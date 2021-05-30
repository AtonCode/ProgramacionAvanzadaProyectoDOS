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
    private ControlUsuario controlUsuario;

    public ControlTienda() {
        this.tienda = new Tienda("GigaByte", "WWW");

        this.controlInventario = new ControlInventario();
        this.controlUsuario = new ControlUsuario();

        this.controlInventario.cargar_inventario();
        this.controlUsuario.cargar_Clientes();
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
    public ControlUsuario getControlUsuario() {
        return controlUsuario;
    }

    //Cliente
    public void crearCliente(double cedula, String nombre){
        Cliente cliente = new Cliente(cedula,nombre);
        this.tienda.getClientesGeneral().add(cliente);
    }
    public void eliminarCliente(double cedula, String nombre){

        for (Cliente c: this.tienda.getClientesGeneral()) {
            if((c.getCedula()== cedula) && (c.getNombre() == nombre)){
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

    //public Factura comprar(){

    //}

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

    public void CrearInventarioGeneral() {// esta funcion coge el inventario de las sucursales y l concatena en el inventario general

        for(int i=0; i<numSucursales;i++) {
            ArrayList<Sucursal> tempsucursales = new ArrayList<Sucursal>();// array temporal en el cual almaceno las sucusales
            tempsucursales.addAll(this.tienda.getSucursales());//arraylist temporal

            Sucursal[] temp=new Sucursal[tempsucursales.size()];//creo un array que me almacena las sucursales
            temp= tempsucursales.toArray(temp);// transfier la informacion del array.

                tienda.agregarProductos(temp[i].getInventario());
        }
    }

    //Inventario
    public void consultaDisponibilidadProductoInventario(int id){
        for (Producto p: this.tienda.getInventarioGeneral()) {
            if(p.getId() == id){
                if(p.getCantidad()!=0) {
                    System.out.println("Disponible");
                }
            }else System.out.println("No Disponible");
        }
    }
    public void addProductoInventario(Producto producto){
        this.tienda.getInventarioGeneral().add(producto);
    }

    public void eliminarProductoInventario(int id){
        for (Producto p: this.tienda.getInventarioGeneral()) {
            if((p.getId() == id)){
                this.tienda.getInventarioGeneral().remove(p);
            }else System.out.println("No Existe");
        }
    }
    public void editarCantidadProductoInventario(int id, int nuevaCantidad){
        for (Producto p: this.tienda.getInventarioGeneral()) {
            if((p.getId() == id)){
                p.setCantidad(nuevaCantidad);
            }else System.out.println("No Existe");
        }
    }
}

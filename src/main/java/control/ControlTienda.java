package control;
import model.Cliente;
import model.Producto;
import model.Sucursal;
import model.Tienda;


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
    public void crearCliente(int cedula, String nombre){
        Cliente cliente = new Cliente(cedula,nombre);
        this.tienda.getClientesGeneral().add(cliente);
    }
    public void eliminar_Cliente(int cedula, String nombre){

        for (Cliente c: this.tienda.getClientesGeneral()) {
            if((c.getCedula()== cedula) && (c.getNombre() == nombre)){
                this.tienda.getClientesGeneral().remove(c);
            }else System.out.println("No Existe");
        }
    }
    public Cliente mostrarClientes(){
        for (Cliente c:this.tienda.getClientesGeneral()) {
            return c;
        }
        return null;
    }

    //Sucursal
    public void crearSucursal(String nombre, String ubicacion){
        Sucursal sucursal = new Sucursal(nombre,ubicacion);
        this.tienda.getSucursales().add(sucursal);
        this.numSucursales = this.tienda.getNumSucursales();
    }
    public void eliminarSucursal(String nombre, String ubicacion){
        for (Sucursal s: this.tienda.getSucursales()) {
            if((s.getNombre() == nombre) && (s.getUbicacion() == ubicacion)){
                this.tienda.getSucursales().remove(s);
            }else System.out.println("No Existe");
        }
        this.numSucursales = this.tienda.getNumSucursales();
    }
    public Sucursal mostrarSucursal(){
        for (Sucursal s:this.tienda.getSucursales()) {
            return s;
        }
        return null;
    }

    //Inventario
    public void consultaDisponibilidadProductoInventario(int id){
        for (Producto p: this.tienda.getInventarioGeneral()) {
            if((p.getId() == id)){
                System.out.println("Disponible");

            }else System.out.println("No Disponible");
        }
    }
    public void addProductoInventario(){
        Producto p = new Producto();
        this.tienda.getInventarioGeneral().add(p);
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

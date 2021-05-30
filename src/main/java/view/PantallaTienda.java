
package view;

import control.ControlTienda;
import model.*;

import java.sql.Array;
import java.util.ArrayList;
import java.util.Scanner;

public class PantallaTienda {

    public static void main(String[] args) {

        int opcion;
        ControlTienda controlTienda = new ControlTienda();
        Scanner entrada = new Scanner(System.in);

        //Sucursales
        controlTienda.crearSucursal(1,"La 45", "Bogota D.C");
        controlTienda.crearSucursal(2,"La 100", "Villavicencio");
        controlTienda.crearSucursal(3,"La 100", "Villavicencio");
        //Clientes
        controlTienda.crearCliente(1, "Aton");
        controlTienda.crearCliente(2, "Natalia");

        int elector=1;
        while(elector==1) {
            opcion = menuPrincipal();
            System.out.println("");
            int elector2 = 1;
            switch (opcion) {
                case 1:
                    while (elector2 == 1) {
                        int eleccion = OpcionesSucursales();
                        switch (eleccion) {
                            case 1: // crea una sucursal
                                int count = 3;
                                int opt = 1;
                                while (opt == 1) {

                                    System.out.println(" Ingrese los datos de la  nueva sucursal");
                                    System.out.println("                                    ");
                                    System.out.println("------------------------------------");

                                    System.out.println(" Ingrese nombre: ");
                                    String nombre;
                                    entrada.reset();
                                    nombre = entrada.nextLine();

                                    System.out.println("                                    ");
                                    System.out.println("------------------------------------");

                                    System.out.println(" Ingrese la direccion: ");
                                    String direccion;
                                    entrada.reset();
                                    direccion = entrada.nextLine();
                                    controlTienda.crearSucursal(count, nombre, direccion);
                                    count++;

                                    System.out.println("------------------------------------");
                                    System.out.println("Desea Crear Una mas ");
                                    System.out.println("1).si");
                                    System.out.println("2).no");
                                    entrada.reset();
                                    opt = entrada.nextInt();
                                    System.out.println("------------------------------------");
                                    System.out.println("------------------------------------");
                                }
                                break;
                            case 2:
                                entrada.reset();
                                System.out.println(" ");
                                System.out.println("Sucursales Disponibles para Eliminar");
                                System.out.println("-------------------------------------------------------------------------------------------------");
                                for (Sucursal sucursal : controlTienda.getTienda().getSucursales()) {
                                    System.out.println("Id Sucursal: " + sucursal.getIdSucursal());
                                    System.out.println("Nombre Sucursal: " + sucursal.getNombre() + '\t' + " | Ubicacion Sucursal: " + sucursal.getUbicacion());
                                    System.out.println("-------------------------------------------------------------------------------------------------");
                                }
                                System.out.println(" ");

                                int elec6 = 1;
                                while (elec6 == 1) {
                                    System.out.println("------------------------------------");
                                    System.out.println("Ingrese ID Sucursal a Eliminar: ");
                                    int idEliminar;
                                    entrada.reset();
                                    idEliminar = entrada.nextInt();
                                    entrada.reset();
                                    System.out.println("------------------------------------");
                                    controlTienda.eliminarSucursal(idEliminar);
                                    System.out.println(" ");
                                    System.out.println("desea eliminar otra sucursal? ");
                                    System.out.println(" ");
                                    System.out.println("1).si ");
                                    System.out.println("2).no ");
                                    entrada.reset();
                                    elec6 = entrada.nextInt();
                                    entrada.reset();
                                }
                                break;

                            case 3://Elegir sucursal
                                entrada.reset();
                                for (Sucursal sucursal : controlTienda.getTienda().getSucursales()) {
                                    System.out.println("ID Sucursal:" + sucursal.getIdSucursal());
                                    System.out.println(sucursal.getNombre() + '\t' + sucursal.getUbicacion());
                                    System.out.println(" ");
                                }

                                System.out.println("-------------------------------------------------");
                                System.out.println(" ");
                                System.out.println("Digite el ID Sucursal: ");
                                int idSucursal;
                                idSucursal = entrada.nextInt();
                                entrada.reset();

                                int contandor = 0;
                                for (Sucursal sucursal : controlTienda.getTienda().getSucursales()) {

                                    if (sucursal.getIdSucursal() == idSucursal) {

                                        int elector3 = 1;
                                        while (elector3 == 1) {
                                            int des;
                                            des = menuSucursal(controlTienda.getTienda().getSucursales().get(controlTienda.getTienda().getSucursales().indexOf(sucursal)));

                                            switch (des) {
                                                case 1:
                                                    System.out.println(" ");
                                                    System.out.println("Productos de la Sucursal: " + controlTienda.getTienda().getSucursales().get((controlTienda.getTienda().getSucursales().indexOf(sucursal))).getNombre());
                                                    System.out.println(" ");
                                                    System.out.println("---------------------------------------------------------------");
                                                    for (Producto producto : controlTienda.getTienda().getInventarioGeneral()) {
                                                        if ((producto.isDisponibilidad() == true) && (producto.getIdSucursal() == controlTienda.getTienda().getSucursales().get((controlTienda.getTienda().getSucursales().indexOf(sucursal))).getIdSucursal())) {

                                                            System.out.println("Nombre Producto: " + producto.getNombre());
                                                            System.out.println("Numeros de Producto: " + producto.getCantidad());
                                                            System.out.println("Precio $: " + producto.getPrecio());
                                                            System.out.println("ID Producto: " + producto.getId());
                                                            System.out.println("ID Sucursal pertenece: " + producto.getIdSucursal());
                                                            System.out.println("Tipo de Producto: " + producto.getTipo());
                                                            System.out.println("Descripcion: " + producto.getDescripcion());
                                                            System.out.println("Resumen: " + producto.getResumen());
                                                            System.out.println("Descripcion: " + producto.getDescripcion());
                                                            System.out.println("Get Info: " + producto.getInfo());
                                                            System.out.println("---------------------------------------------------------------");
                                                            System.out.println(" ");

                                                        }

                                                    }
                                                    System.out.println("---------------------------------------------------------------");
                                                    System.out.println(" ");

                                                    break;
                                                case 2:// Añadir Producto
                                                    int elec4 = 1;
                                                    while (elec4 == 1) {
                                                        entrada.reset();
                                                        System.out.println("-------------------------------------");

                                                        System.out.println("Ingrese id del producto: ");
                                                        double idPrducto;
                                                        idPrducto = entrada.nextDouble();
                                                        entrada.reset();

                                                        double idSucur = idSucursal;

                                                        //estado true
                                                        System.out.println("Ingrese la cantidad: ");
                                                        int cantidad;
                                                        cantidad = entrada.nextInt();
                                                        entrada.reset();

                                                        System.out.println("Ingrese el tipo ");
                                                        int tipo = 0;
                                                        System.out.println("1). Componente");
                                                        System.out.println("2). Dispositivo");
                                                        if (tipo == 1) {

                                                            System.out.println("Ingrese el nombre");
                                                            String nombre;
                                                            nombre = entrada.nextLine();
                                                            entrada.reset();

                                                            System.out.println("Ingrese Precio");
                                                            int precio;
                                                            precio = entrada.nextInt();
                                                            entrada.reset();

                                                            System.out.println("Ingrese descripcion");
                                                            String descripcion;
                                                            descripcion = entrada.nextLine();
                                                            entrada.reset();

                                                            System.out.println("Ingrese el resumen del componente ");
                                                            String resumen;
                                                            resumen = entrada.nextLine();
                                                            entrada.reset();

                                                            System.out.println("Ingrese al dispositivo que pertenece");
                                                            String dispositivo;
                                                            dispositivo = entrada.nextLine();
                                                            entrada.reset();

                                                            System.out.println("Ingrese Descripcion fisica");
                                                            String descripcionFisica;
                                                            descripcionFisica = entrada.nextLine();
                                                            entrada.reset();

                                                            System.out.println("Ingrese Descrpcion adicional ");
                                                            String descripcionAdicional;
                                                            descripcionAdicional = entrada.nextLine();
                                                            entrada.reset();

                                                            Producto temp = new Componente(idPrducto, idSucursal, cantidad, "componente", nombre, precio, descripcion, resumen, dispositivo, descripcionFisica, descripcionAdicional);
                                                            controlTienda.getTienda().getSucursales().get((controlTienda.getTienda().getSucursales().indexOf(sucursal))).getInventario().add(temp);
                                                            controlTienda.addProductoInventario(temp);

                                                            System.out.println("   ");
                                                            System.out.println("---------------------------------");
                                                            System.out.println("desea ingresar otro producto?");
                                                            System.out.println("1).Si");
                                                            System.out.println("2).No");
                                                            elec4 = entrada.nextInt();
                                                            System.out.println("---------------------------------");
                                                            System.out.println("   ");

                                                        }
                                                        if (tipo == 2) {

                                                            System.out.println("Ingrese el nombre");
                                                            String nombre;
                                                            nombre = entrada.nextLine();
                                                            entrada.reset();

                                                            System.out.println("Ingrese Precio");
                                                            int precio;
                                                            precio = entrada.nextInt();
                                                            entrada.reset();

                                                            System.out.println("Ingrese descripcion");
                                                            String descripcion;
                                                            descripcion = entrada.nextLine();
                                                            entrada.reset();

                                                            System.out.println("Ingrese el resumen del dispositivo ");
                                                            String resumen;
                                                            resumen = entrada.nextLine();
                                                            entrada.reset();

                                                            System.out.println("Ingrese el tipo de pantalla");
                                                            String tipoPantalla;
                                                            tipoPantalla = entrada.nextLine();
                                                            entrada.reset();

                                                            System.out.println("Ingrese almacenamiento");
                                                            String almacenamiento;
                                                            almacenamiento = entrada.nextLine();
                                                            entrada.reset();

                                                            System.out.println("Ingrese su procesamiento");
                                                            String procesamiento;
                                                            procesamiento = entrada.nextLine();
                                                            entrada.reset();

                                                            System.out.println("Ingrese su tecnica");
                                                            String tecnica;
                                                            tecnica = entrada.nextLine();
                                                            entrada.reset();

                                                            System.out.println("Ingrese su descripcion fisica");
                                                            String descripcionFisica;
                                                            descripcionFisica = entrada.nextLine();
                                                            entrada.reset();

                                                            System.out.println("Ingrese su conectividad");
                                                            String conectividad;
                                                            conectividad = entrada.nextLine();
                                                            entrada.reset();

                                                            System.out.println("Ingrese su infrmacion adicional");
                                                            String informacionAdicional;
                                                            informacionAdicional = entrada.nextLine();
                                                            entrada.reset();

                                                            Producto temp = new Dispositivo(idPrducto, idSucursal, cantidad, "Dispositivo", nombre, precio, descripcion, resumen, tipoPantalla, almacenamiento, procesamiento, tecnica, descripcionFisica, conectividad, informacionAdicional);
                                                            controlTienda.getTienda().getSucursales().get((controlTienda.getTienda().getSucursales().indexOf(sucursal))).getInventario().add(temp);
                                                            controlTienda.addProductoInventario(temp);

                                                            System.out.println("   ");
                                                            System.out.println("---------------------------------");
                                                            System.out.println("desea ingresar otro producto?");
                                                            System.out.println("1).Si");
                                                            System.out.println("2).No");
                                                            elec4 = entrada.nextInt();
                                                            System.out.println("---------------------------------");
                                                            System.out.println("   ");
                                                        }

                                                    }
                                                    break;
                                                case 3:// Eliminar Producto
                                                    int elec5 = 1;
                                                    while (elec5 == 1) {
                                                        entrada.reset();
                                                        System.out.println(" ");
                                                        System.out.println("---------------------------------------------------------------");
                                                        System.out.println("Eliminar Producto de la Sucursal" + controlTienda.getTienda().getSucursales().get((controlTienda.getTienda().getSucursales().indexOf(sucursal))).getUbicacion());
                                                        System.out.println(" ");
                                                        System.out.println("---------------------------------------------------------------");
                                                        System.out.println("Digita el ID del Producto que desa Eliminar: ");
                                                        entrada.reset();
                                                        int idProductoEliminar = entrada.nextInt();
                                                        entrada.reset();

                                                        for (Producto producto : controlTienda.getTienda().getInventarioGeneral()) {
                                                            if (producto.getIdSucursal() == controlTienda.getTienda().getSucursales().get((controlTienda.getTienda().getSucursales().indexOf(sucursal))).getIdSucursal()) {
                                                                controlTienda.getTienda().getSucursales().get((controlTienda.getTienda().getSucursales().indexOf(sucursal))).getInventario().remove(producto);
                                                                controlTienda.eliminarProductoInventario(idProductoEliminar);
                                                                System.out.println(" ");
                                                            }
                                                        }
                                                        System.out.println("   ");
                                                        System.out.println("---------------------------------");
                                                        System.out.println("desea eliminar otro producto?");
                                                        System.out.println("1).Si");
                                                        System.out.println("2).No");
                                                        elec5 = entrada.nextInt();
                                                        System.out.println("---------------------------------");
                                                        System.out.println("   ");
                                                        System.out.println(" ");
                                                    }
                                                    break;
                                                case 4://editar cantidad de producto
                                                    int elec7 = 1;
                                                    while (elec7 == 1) {
                                                        double id;
                                                        System.out.println("ingrese el ID del producto del que desea modificar la cantidad");
                                                        entrada.reset();
                                                        id = entrada.nextDouble();

                                                        for (Producto producto : controlTienda.getTienda().getInventarioGeneral()) {
                                                            if ((producto.getId() == id) && (producto.getIdSucursal() == controlTienda.getTienda().getSucursales().get((controlTienda.getTienda().getSucursales().indexOf(sucursal))).getIdSucursal())) {
                                                                System.out.println("ingrese la cantidad");
                                                                int cantidad;
                                                                cantidad = entrada.nextInt();
                                                                System.out.println("ID del prodcuto que va a modificar: " + producto.getId());
                                                                System.out.println("Nombre del producto al que desea cambiar cantidad: " + producto.getNombre());
                                                                System.out.println("Cantidad inicial del producto: " + producto.getCantidad());
                                                                System.out.println("---------------------------------");
                                                                System.out.println("   ");
                                                                System.out.println(" ");

                                                                controlTienda.editarCantidadProductoInventario(id, cantidad);

                                                                System.out.println("ID del prodcuto que modifico : " + producto.getId());
                                                                System.out.println("Nombre del producto que modifico : " + producto.getNombre());
                                                                System.out.println("Cantidad final del producto : " + producto.getCantidad());
                                                                System.out.println("---------------------------------");
                                                                System.out.println("   ");
                                                                System.out.println(" ");
                                                                break;
                                                            }
                                                        }
                                                        System.out.println("Desea modificar mas productos? ");
                                                        System.out.println("1). Si");
                                                        System.out.println("2). No");
                                                        entrada.reset();
                                                        elec7 = entrada.nextInt();
                                                        System.out.println("");
                                                    }
                                                    break;
                                                case 5:
                                                    elector3 = 2;
                                                    break;
                                                default:
                                                    System.out.println("Eleccion de numero no valido");
                                            }
                                        }

                                    }
                                }
                                break;
                            case 4:
                                elector2 = 2;
                                break;
                            default:
                                System.out.println("Eleccion de numero no valido");
                        }
                    }
                    break;
                case 2:
                    int elector3 = 1;
                    while (elector3 == 1) {
                        int elec;
                        elec = OpcionesCliente();
                        switch (elec) {
                            case 1:
                                int elec3 = 1;
                                while (elec3 == 1) {
                                    System.out.println("ingrese los datos de la persona que desa crear: ");
                                    System.out.println("                                    ");
                                    System.out.println("------------------------------------------------");
                                    System.out.println("ingrese la cedula: ");
                                    double cedula;

                                    entrada.reset();
                                    cedula = entrada.nextDouble();

                                    System.out.println("ingrese el nombre del cliente: ");
                                    String nombre;
                                    entrada.reset();
                                    Scanner nom = new Scanner(System.in);
                                    nombre = nom.nextLine();

                                    controlTienda.crearCliente(cedula, nombre);

                                    System.out.println("         ");
                                    System.out.println("desea serguir creando cliente? ");
                                    System.out.println(" ");
                                    System.out.println("1) si ");
                                    System.out.println("2) no ");
                                    entrada.reset();
                                    elec3 = entrada.nextInt();
                                    entrada.reset();

                                }
                                break;

                            case 2:
                                int elec4 = 1;
                                while (elec4 == 1) {

                                    System.out.println("ingrese los datos de la persona que desa eliminar: ");
                                    System.out.println("                                    ");
                                    System.out.println("------------------------------------------------");
                                    System.out.println("ingrese la cedula: ");
                                    double c;
                                    entrada.reset();
                                    c = entrada.nextDouble();

                                    controlTienda.eliminarCliente(c);
                                    System.out.println("desea eliminar otro cliente? ");
                                    System.out.println("1). Si");
                                    System.out.println("2). No");
                                    entrada.reset();
                                    elec4 = entrada.nextInt();


                                }
                                break;

                            case 3:
                                int elec5 = 1;
                                while (elec5 == 1) {
                                    System.out.println("ingrese los datos de la persona que desea buscar su historial: ");
                                    System.out.println("                                    ");
                                    System.out.println("------------------------------------------------");
                                    System.out.println("ingrese la cedula: ");
                                    double cedula;
                                    entrada.reset();
                                    cedula = entrada.nextDouble();


                                    System.out.println(controlTienda.buscarCliente(cedula).getHistorialCompras());
                                    System.out.print("desea buscar otro cliente? ");
                                    System.out.print("1). Si");
                                    System.out.print("2). No");
                                    entrada.reset();
                                    elec5 = entrada.nextInt();

                                }
                                break;
                            case 4:
                                int elec6 = 1;
                                while (elec6 == 1) {

                                    System.out.println("Ingrese la cedula del cliente al cual quiere verle el historial");
                                    double cedulat;
                                    entrada.reset();
                                    cedulat = entrada.nextDouble();
                                    System.out.println("Nombre: " + controlTienda.buscarCliente(cedulat).getNombre());
                                    System.out.println("Cedula: " + controlTienda.buscarCliente(cedulat).getCedula());
                                    int cont = 0;

                                    for (Factura factura : controlTienda.buscarCliente(cedulat).getHistorialCompras()) {
                                        cont++;
                                        System.out.println("Factura numero: " + cont);
                                        factura.imprimir();
                                    }

                                    System.out.println("ingrese la opcion que desea realizar: ");
                                    System.out.println("1).Buscar otro cliente ");
                                    System.out.println("2).salir ");
                                    entrada.reset();
                                    elec6 = entrada.nextInt();

                                }
                                break;

                            case 5:
                                int elec7 = 0;
                                while (elec7 == 0) {
                                    System.out.println("Mostrar todos los clientes");
                                    System.out.println("----------------------------------------------");
                                    for (Cliente client : controlTienda.getTienda().getClientesGeneral()) {
                                        System.out.println("Nombre: " + client.getNombre() + '\t' + " Cedula: " + client.getCedula());
                                    }

                                    System.out.println("Elija la opcion que desea");
                                    System.out.println("1).Salir");
                                    entrada.reset();
                                    elec7 = entrada.nextInt();

                                    System.out.println("                                    ");
                                    System.out.println("----------------------------------------------");
                                }
                                break;
                            case 6:

                                double cedula;
                                System.out.println("Bienvenido a la opcion de comprar ");
                                System.out.println("Ingrese la cedula del cliente que realiza la compra: ");
                                entrada.reset();
                                cedula=entrada.nextDouble();
                                for(Cliente temp:controlTienda.getTienda().getClientesGeneral()){

                                    if(temp.getCedula()==cedula){
                                        int idsuc;
                                        System.out.println("                                    ");
                                        System.out.println("----------------------------------------------");
                                        System.out.println("Ingrese el ID de la sucursal donde desea realizar la compra: ");
                                        entrada.reset();
                                        idsuc=entrada.nextInt();
                                        System.out.println("----------------------------------------------");
                                        for(Sucursal tempSuc: controlTienda.getTienda().getSucursales()){
                                            if(tempSuc.getIdSucursal()==idsuc){

                                                int des;
                                                int elec8=1;
                                                while(elec8==1){
                                                des=menuComprar(temp);
                                                Venta venta=new Venta();
                                                    ArrayList<Producto> carrito=new ArrayList<Producto>();
                                                switch (des){
                                                    case 1:
                                                        for(Producto tempPr: controlTienda.getTienda().getInventarioGeneral()){
                                                            if(tempPr.getIdSucursal()==idsuc){
                                                                System.out.println("Nombre: "+tempPr.getNombre());
                                                                System.out.println("ID: "+tempPr.getId());
                                                                System.out.println("Cantidad: "+tempPr.getCantidad());
                                                                System.out.println("Disponibilidad: "+tempPr.isDisponibilidad());
                                                                System.out.println("Tipo: "+tempPr.getTipo());
                                                                System.out.println("Precio: "+tempPr.getPrecio());
                                                                System.out.println("----------------------------------------------");
                                                            }
                                                        }
                                                        break;
                                                    case 2:
                                                        int elect4=1;
                                                        while(elect4==1){
                                                            double id;
                                                            System.out.println("ingrese el ID del producto que desas comprar: ");
                                                            entrada.reset();

                                                            id=entrada.nextDouble();

                                                            for(Producto productos: controlTienda.getTienda().getInventarioGeneral()){
                                                                if((productos.getId()==id) && (productos.getIdSucursal()==idsuc)){
                                                                    System.out.println("nombre del producto: "+productos.getNombre());
                                                                    System.out.println("precio: "+productos.getPrecio());
                                                                    System.out.println("----------------------------------------------");
                                                                    System.out.println("Seguro desea agregar este producto");
                                                                    int desi=0;
                                                                    System.out.println("1). si");
                                                                    System.out.println("2). No");
                                                                    entrada.reset();
                                                                    desi=entrada.nextInt();

                                                                    if(desi==1){

                                                                        carrito.add(productos);
                                                                        System.out.println("entro" +carrito.size());
                                                                        productos.setCantidad(productos.getCantidad()-1);

                                                                        System.out.println("desea agrgar otro prodcuto?");
                                                                        System.out.println("1). si");
                                                                        System.out.println("2). No");
                                                                        entrada.reset();
                                                                        elect4=entrada.nextInt();
                                                                        break;

                                                                    }else{ break;}
                                                                }
                                                                else{
                                                                    System.out.println("Id no encntrado");
                                                                    break;
                                                                }
                                                            }
                                                            venta.setCarritoCompra(carrito);
                                                        }
                                                        break;
                                                    case 3:

                                                        double cont=0;
                                                        System.out.println("Carrito de compras del usuario: "+ temp.getNombre());

                                                        for(Producto product: venta.getCarritoCompra()){

                                                            System.out.println("normbre del producto "+product.getNombre());
                                                            System.out.println("ID del producto "+product.getId());
                                                            cont=(product.getPrecio())+cont;

                                                        }
                                                        System.out.println("----------------------------------");
                                                        System.out.println("valor aprox: "+ cont);
                                                        System.out.println("cantidad de productos: "+ venta.getNumeroProductos());
                                                        break;
                                                    case 4:

                                                        break;
                                                    case 5:
                                                        elec8=2;
                                                        break;

                                                    default:
                                                        System.out.println("Eleccion de numero no valido");
                                                  }
                                               }
                                            }
                                        }
                                    }
                                }
                                break;
                            case 7:
                                elector3 = 2;
                                break;

                            default:
                                System.out.println("Eleccion de numero no valido");
                        }
                    }
                    break;
                case 3:
                    int elector5 = 1;
                    while (elector5==1){
                        entrada.reset();
                        int opt = opcionesInventario();
                        if (opt == 1) {
                            controlTienda.guardarInventarioGeneral();
                            System.out.println("Inventario Guardado");
                            System.out.println(" ");
                        }
                        if (opt == 2) {
                            int elector4 = 1;
                            while (elector4 == 1) {
                                System.out.println("---------------------------------------------------------------");
                                System.out.println("Ingresa el ID del Producto que desea buscar");
                                double idProducto = entrada.nextDouble();
                                System.out.println(" ");
                                System.out.println("---------------------------------------------------------------");
                                for (Producto producto : controlTienda.getTienda().getInventarioGeneral()) {
                                    if (producto.getId() == idProducto) {
                                        System.out.println("ID Producto: " + producto.getId());
                                        System.out.println("ID Sucursal pertenece: " + producto.getIdSucursal());
                                        System.out.println("Nombre Producto: " + producto.getNombre());
                                        System.out.println("Numeros de Producto: " + producto.getCantidad());
                                        System.out.println("Precio $: " + producto.getPrecio());
                                        System.out.println("---------------------------------------------------------------");
                                        System.out.println(" ");
                                        break;
                                    }
                                }
                                System.out.println("ingrese la opcion que desea realizar: ");
                                System.out.println("1).Buscar otro prodcuto ");
                                System.out.println("2).salir ");
                                entrada.reset();
                                elector4 = entrada.nextInt();
                                System.out.println("---------------------------------------------------------------");
                                System.out.println(" ");
                               }
                             }
                            if(opt == 3){
                             elector5=2;
                           }
                        }
                        break;

                        case 4:
                            elector = 2;
                            break;

                        default:
                            System.out.println("Eleccion de numero no valido");
                    }
            }
    }

    public static int menuPrincipal(){
        int eleccion;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bienvenidos a la Tienda Gigabyte");
        System.out.println("                                ");
        System.out.println("-----------------------------------------------");
        System.out.println("         Menu Princial          ");
        System.out.println("-----------------------------------------------");
        System.out.println("1) Opciones Sucursales ");
        System.out.println("2) Opciones Cliente ");
        System.out.println("3) Opciones inventario ");
        System.out.println("4) Salir");
        System.out.println("Dijita el numero de la opcion que desee: ");
        eleccion = entrada.nextInt();

        return eleccion;
    }
    public static int OpcionesSucursales(){
        int opcion;
        Scanner sc =new Scanner(System.in);
        System.out.println("          Elija la opcion que desea:        ");
        System.out.println("                             ");
        System.out.println("-----------------------------------------------");
        System.out.println("1). Crear sucursal");
        System.out.println("2). Eliminar sucursal");
        System.out.println("3). Elegir sucursal");
        System.out.println("4). Salir");
        System.out.println("Dijita el numero de la opcion que desee: ");
        opcion=sc.nextInt();
        return opcion;
    }
    public static int OpcionesCliente(){
        int opcion;
        Scanner sc =new Scanner(System.in);
        System.out.println("          Elija la opcion que desea:        ");
        System.out.println("                             ");
        System.out.println("-----------------------------------------------");
        System.out.println("1). Crear cliente. ");
        System.out.println("2). Eliminar cliente. ");
        System.out.println("4). mostrar historial de ventas cliente. ");
        System.out.println("5). mostrar clientes. ");
        System.out.println("6). comprar");
        System.out.println("7). Salir. ");
        System.out.println("Dijita el numero de la opcion que desee: ");
        opcion=sc.nextInt();
        return opcion;
    }


    public static int menuSucursal(Sucursal sucursal){
        int opcion;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bienvenidos a la Sucursal " + sucursal.getUbicacion());
        System.out.println("                                ");
        System.out.println("-----------------------------------------------");
        System.out.println("         Menu Sucursal          ");
        System.out.println("-----------------------------------------------");
        System.out.println("1) Mostrar Inventario ");//falta
        System.out.println("2) Agregar producto ");
        System.out.println("3) Eliminar producto ");
        System.out.println("4) Editar cantidad de producto");
        System.out.println("5) Salir");
        System.out.println("Dijita el numero de la opcion que desee: ");
        opcion = entrada.nextInt();

        return opcion;
    }
    public static int opcionesInventario(){
        int opcion;
        Scanner entrada = new Scanner(System.in);
        System.out.println("1) Guardar Inventario");
        System.out.println("2) Buscar Producto");
        System.out.println("3) salir");

        System.out.println("Dijita el numero de la opcion que desee: ");

        opcion= entrada.nextInt();

        return opcion;

    }

    public static int menuComprar(Cliente cliente){
        int opcion;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bienvenido " + cliente.getNombre());
        System.out.println("                                ");
        System.out.println("-----------------------------------------------");
        System.out.println("               Menu Compra         ");
        System.out.println("-----------------------------------------------");
        System.out.println("1).Ver Produtos ");
        System.out.println("2).Agregar a carrito ");
        System.out.println("3).mostrar carrito ");
        System.out.println("4).Facturar ");
        System.out.println("5).Salir ");
        System.out.println("Dijita el numero de la opcion que desee: ");
        opcion = entrada.nextInt();

        return opcion;
    }

}

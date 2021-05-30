
package view;

import control.ControlTienda;
import model.Cliente;
import model.Factura;
import model.Producto;
import model.Sucursal;

import java.util.Scanner;

public class PantallaTienda {

    public static void main(String[] args) {

        int opcion;
        ControlTienda controlTienda = new ControlTienda();
        Scanner entrada = new Scanner(System.in);

        //Sucursales
        controlTienda.crearSucursal(1,"La 45", "Bogota D.C");
        controlTienda.crearSucursal(2,"La 100", "Villavicencio");
        controlTienda.crearSucursal(4,"La 100", "Villavicencio");
        //Clientes
        controlTienda.crearCliente(1, "Aton");
        controlTienda.crearCliente(2, "Natalia");

        int elector=1;
        while(elector==1){
            opcion = menuPrincipal();
            System.out.println("");
            int elector2=1;
            switch (opcion) {
                    case 1:
                        while(elector2==1){
                            int eleccion = OpcionesSucursales();
                            switch (eleccion) {
                             case 1: // crea una sucursal
                                 int count = 3;
                                 int opt = 1;
                                 while (opt == 1){

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
                                     controlTienda.crearSucursal(count,nombre, direccion);
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
                                System.out.println("Nombre Sucursal: " + sucursal.getNombre()+'\t'+" | Ubicacion Sucursal: " +sucursal.getUbicacion());
                                System.out.println("-------------------------------------------------------------------------------------------------");
                            }
                            System.out.println(" ");

                            int elec6=1;
                            while(elec6==1) {
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
                                System.out.println(sucursal.getNombre()+'\t'+sucursal.getUbicacion());
                                System.out.println(" ");
                            }

                            System.out.println("-------------------------------------------------");
                            System.out.println(" ");
                            System.out.println("Digite el ID Sucursal: ");
                            double idSucursal;
                            idSucursal=entrada.nextDouble();
                            entrada.reset();

                            int contandor=0;
                            for(Sucursal sucursal: controlTienda.getTienda().getSucursales()){
                                contandor++;
                                if(sucursal.getIdSucursal() == idSucursal){

                                    int elector3=1;
                                    while(elector3==1) {
                                        int des;
                                        des=menuSucursal(controlTienda.getTienda().getSucursales().get(contandor-1));
                                        switch (des) {

                                            case 1:
                                                System.out.println(" ");
                                                System.out.println("Productos de la Sucursal");
                                                System.out.println(" ");
                                                System.out.println("---------------------------------------------------------------");
                                                for(Producto producto : controlTienda.getTienda().getSucursales().get(contandor-1).getInventario()){
                                                    if(producto.getId()==controlTienda.getTienda().getSucursales().get(contandor-1).getIdSucursal()){

                                                        System.out.println("Disponibilidad: "+ producto.isDisponibilidad());
                                                        System.out.println("Nombre Producto: "+ producto.getNombre());
                                                        System.out.println("Numeros de Producto: "+ producto.getCantidad());
                                                        System.out.println("Precio $: "+ producto.getPrecio());
                                                        System.out.println("ID Producto: "+ producto.getId());
                                                        System.out.println("ID Sucursal pertenece: " + producto.getIdSucursal());
                                                        System.out.println("Tipo de Producto: "+ producto.getTipo());
                                                        System.out.println("Descripcion: "+ producto.getDescripcion());
                                                        System.out.println("Resumen: "+ producto.getResumen());
                                                        System.out.println("Descripcion: "+ producto.getDescripcion());
                                                        System.out.println("Get Info: "+ producto.getInfo());
                                                        System.out.println("---------------------------------------------------------------");
                                                        System.out.println(" ");

                                                    }

                                                }
                                                System.out.println("---------------------------------------------------------------");
                                                System.out.println(" ");
                                                break;
                                            case 2:// Añadir Producto
                                                entrada.reset();


                                                break;
                                            case 3:// Eliminar Producto
                                                entrada.reset();
                                                System.out.println(" ");
                                                System.out.println("Eliminar Producto de la Sucursal");
                                                System.out.println(" ");
                                                System.out.println("---------------------------------------------------------------");
                                                System.out.println("Digita el ID del Producto que desa Eliminar ");
                                                int idProductoEliminar = entrada.nextInt();
                                                entrada.reset();

                                                controlTienda.eliminarProductoInventario(idProductoEliminar);
                                                System.out.println(" ");

                                                break;
                                            case 4:
                                                entrada.reset();
                                                elector3=2;
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
                    int elec;
                    elec = OpcionesCliente();
                    Scanner dato = new Scanner(System.in);
                    switch (elec) {
                        case 1:
                            int elec3=1;
                            while(elec3==1){
                                System.out.println("ingrese los datos de la persona que desa crear: ");
                                System.out.println("                                    ");
                                System.out.println("------------------------------------------------");
                                System.out.println("ingrese la cedula: ");
                                double cedula;
                                cedula = dato.nextDouble();
                                dato.reset();

                                System.out.println("ingrese el nombre del cliente: ");
                                String nombre;
                                dato.reset();
                                nombre = dato.nextLine();
                                dato.reset();

                                controlTienda.crearCliente(cedula, nombre);

                                System.out.println("         ");
                                System.out.println("desea serguir creando cliente? ");
                                System.out.println(" ");
                                System.out.println("1) si ");
                                System.out.println("2) no ");
                                elec3 = dato.nextInt();
                                dato.reset();

                            }
                            break;

                        case 2:
                            int elec4=1;
                            while (elec4==1) {

                                System.out.println("ingrese los datos de la persona que desa eliminar: ");
                                System.out.println("                                    ");
                                System.out.println("------------------------------------------------");
                                System.out.println("ingrese la cedula: ");
                                double c;
                                c = dato.nextDouble();
                                dato.reset();
                                controlTienda.eliminarCliente(c);
                                System.out.print("desea eliminar otro cliente? ");
                                System.out.print("1). Si");
                                System.out.print("2). No");
                                elec4=dato.nextInt();
                                dato.reset();

                            }
                            break;

                        case 3:
                            int elec5=1;
                            while(elec5==1) {
                                System.out.println("ingrese los datos de la persona que desea buscar su historial: ");
                                System.out.println("                                    ");
                                System.out.println("------------------------------------------------");
                                System.out.println("ingrese la cedula: ");
                                double cedula;
                                cedula = dato.nextDouble();
                                dato.reset();

                                System.out.println(controlTienda.buscarCliente(cedula).getHistorialCompras());
                                System.out.print("desea buscar otro cliente? ");
                                System.out.print("1). Si");
                                System.out.print("2). No");
                                elec5 = dato.nextInt();
                                dato.reset();
                            }
                            break;
                        case 4:
                            int elec6=1;
                            while(elec6==1){

                                System.out.println("Ingrese la cedula del cliente al cual quiere verle el historial");
                                double cedulat;
                                cedulat=dato.nextDouble();
                                dato.reset();

                                System.out.println("Nombre: "+controlTienda.buscarCliente(cedulat).getNombre());
                                System.out.println("Cedula: "+controlTienda.buscarCliente(cedulat).getCedula());
                                int cont=0;

                                for(Factura factura:controlTienda.buscarCliente(cedulat).getHistorialCompras()){
                                    cont++;
                                    System.out.println("Factura numero: "+cont);
                                    factura.imprimir();
                                }

                                System.out.println("ingrese la opcion que desea realizar: ");
                                System.out.println("1).Buscar otro cliente ");
                                System.out.println("2).salir ");
                                elec6=dato.nextInt();
                                dato.reset();
                            }
                            break;

                        case 5:
                            int elec7=0;
                            while(elec7==0) {
                                System.out.println("Mostrar todos los clientes");
                                System.out.println("----------------------------------------------");
                                for (Cliente client : controlTienda.getTienda().getClientesGeneral()) {
                                    System.out.println("Nombre: " + client.getNombre() + '\t' + " Cedula: " + client.getCedula());
                                }

                                System.out.println("Elija la opcion que desea");
                                System.out.println("1).Salir");
                                elec7=dato.nextInt();
                                dato.reset();
                                System.out.println("                                    ");
                                System.out.println("----------------------------------------------");
                            }
                            break;

                        default:
                            System.out.println("Eleccion de numero no valido");
                    }

                    break;
                case 3:
                    // ControlTienda.ControlInventario.CargarInventario();

                    //ControlTienda.ControlInventario.GuardarInventario();

                    break;

                case 4:
                    elector=2;
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
        System.out.println("3) Opciones inventario ");//falta
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
        System.out.println("6). Salir. ");
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
        System.out.println("1) mostrar Inventario ");//falta
        System.out.println("2) agregar producto ");
        System.out.println("3) eliminar producto ");
        System.out.println("4) Salir");
        System.out.println("Dijita el numero de la opcion que desee: ");
        opcion = entrada.nextInt();

        return opcion;
    }
    public static int opcionesInventario(){
        int opcion;
        Scanner entrada = new Scanner(System.in);
        System.out.println("1) Cargar Inventario");
        System.out.println("2) Guardar Inventario");
        System.out.println("3) Crear Inventario general");
        System.out.println("4) salir");
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
        System.out.println("         Menu Compra         ");
        System.out.println("-----------------------------------------------");
        System.out.println("1) Ver Produtos");
        System.out.println("2) disponibilidad");
        System.out.println("3) Salir");
        System.out.println("Dijita el numero de la opcion que desee: ");
        opcion = entrada.nextInt();

        return opcion;
    }

}

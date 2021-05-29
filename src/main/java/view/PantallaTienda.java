
package view;

import control.ControlInventario;
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

        //Sucursales
        controlTienda.crearSucursal(1,"La 45", "BogotaDC");
        controlTienda.crearSucursal(2,"La 100", "Villavicencio");
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
                                 String opt = "y";
                                 while (opt == "y"){
                                     Scanner sc = new Scanner(System.in);
                                     System.out.println(" Ingrese los datos de la que desea crear sucursal ");
                                     System.out.println("                                    ");
                                     System.out.println("------------------------------------");

                                     System.out.println(" Ingrese nombre: ");
                                     String nombre;
                                     nombre = sc.nextLine();

                                     System.out.println("                                    ");
                                     System.out.println("------------------------------------");

                                     System.out.println(" Ingrese la direccion: ");
                                     String direccion;
                                     direccion = sc.nextLine();
                                     controlTienda.crearSucursal(count,nombre, direccion);
                                     count++;

                                     System.out.println("------------------------------------");
                                     System.out.println("Desea Crear Una mas ");
                                     opt = sc.nextLine();
                                     System.out.println("------------------------------------");
                                     System.out.println("------------------------------------");
                                 }
                            break;
                        case 2:
                            Scanner op = new Scanner(System.in);
                            for (Sucursal sucursal : controlTienda.getTienda().getSucursales()) {
                                System.out.println("Id Sucursal: " + sucursal.getIdSucursal());
                                System.out.println("Nombre Sucursal: " + sucursal.getNombre()+'\t'+" Ubicacion Sucursal: " +sucursal.getUbicacion());
                                System.out.println("---------------------------------");
                            }
                            System.out.println(" ");
                            System.out.println(" Ingrese los datos de la que desea sucursal eliminar  ");
                            System.out.println("                                    ");
                            System.out.println("------------------------------------");

                            System.out.println(" Ingrese ID: ");
                            int id;
                            id = op.nextInt();
                            controlTienda.eliminarSucursal(id);
                            System.out.println("------------------------------------");

                            break;
                        case 3:

                            for (Sucursal sucursal : controlTienda.getTienda().getSucursales()) {
                                System.out.println("id Sucursal:" + sucursal.getIdSucursal());
                                System.out.println(sucursal.getNombre()+'\t'+sucursal.getUbicacion());
                                System.out.println("                              ");
                            }

                            System.out.println("digite el Id sucursal");
                            double elec;
                            Scanner desicion=new Scanner(System.in);
                            elec=desicion.nextDouble();

                            int contandor=0;
                            for(Sucursal tempsuc: controlTienda.getTienda().getSucursales()){
                                contandor++;
                                if(tempsuc.getIdSucursal()==elec){

                                    int elector3=1;
                                    while(elector3==1) {
                                        int des;
                                        des=menuSucursal(controlTienda.getTienda().getSucursales().get(contandor-1));
                                        switch (des) {

                                            case 1:
                                                for(Producto tempP: controlTienda.getTienda().getSucursales().get(contandor-1).getInventario()){
                                                    if(tempP.getId()==controlTienda.getTienda().getSucursales().get(contandor-1).getIdSucursal()) {
                                                       System.out.println("funciona");
                                                        tempP.getCantidad();
                                                        tempP.getId();
                                                        tempP.getIdSucursal();
                                                    }
                                                }
                                                break;
                                            case 2:
                                                break;
                                            case 3:
                                                break;
                                            case 4:
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
                    switch (elec) {
                        case 1:
                            int elec3=1;
                            while(elec3==1) {

                                Scanner datos = new Scanner(System.in);
                                Scanner dato = new Scanner(System.in);
                                System.out.println("ingrese los datos de la persona que desa crear: ");
                                System.out.println("                                    ");
                                System.out.println("------------------------------------------------");
                                System.out.println("ingrese la cedula: ");
                                double cedula;

                                cedula = dato.nextDouble();

                                System.out.println("ingrese el nombre del cliente: ");
                                String nombre;

                                nombre = datos.nextLine();

                                controlTienda.crearCliente(cedula, nombre);

                                System.out.println("         ");
                                System.out.println("desea serguir ingresar cliente? ");
                                System.out.println(" ");
                                System.out.println("1) si ");
                                System.out.println("2) no ");
                                elec3 = dato.nextInt();
                            }
                            break;

                        case 2:
                            int elec4=1;
                            while (elec4==1) {
                                Scanner dat = new Scanner(System.in);
                                System.out.println("ingrese los datos de la persona que desa eliminar: ");
                                System.out.println("                                    ");
                                System.out.println("------------------------------------------------");
                                System.out.println("ingrese la cedula: ");
                                double c;
                                c = dat.nextDouble();

                                System.out.println("ingrese el nombre del cliente: ");
                                String n;

                                n = dat.nextLine();

                                controlTienda.eliminarCliente(c, n);
                            }
                            break;

                        case 3:

                            Scanner cliente = new Scanner(System.in);
                            System.out.println("ingrese los datos de la persona que desea buscar su historial: ");
                            System.out.println("                                    ");
                            System.out.println("------------------------------------------------");
                            System.out.println("ingrese la cedula: ");
                            double cedula;
                            cedula= cliente.nextDouble();


                            System.out.println(controlTienda.buscarCliente(cedula).getHistorialCompras());


                            break;
                        case 4:
                            int elec5=1;
                            while(elec5==1){
                                Scanner cedulatemp=new Scanner(System.in);
                                System.out.println("Ingrese la cedula del cliente al cual quiere verle el historial");
                                double cedulat;
                                cedulat=cedulatemp.nextDouble();

                                System.out.println("Nombre: "+controlTienda.buscarCliente(cedulat).getNombre());
                                System.out.println("Cedula: "+controlTienda.buscarCliente(cedulat).getCedula());
                                int cont=0;
                                for(Factura factura:controlTienda.buscarCliente(cedulat).getHistorialCompras()){
                                    cont++;
                                    System.out.println("Factura numero: "+cont);
                                    factura.imprimir();
                                }
                                Scanner op=new Scanner(System.in);
                                System.out.println("ingrese la opcion que desea realizar: ");
                                System.out.println("1).Buscar otro cliente ");
                                System.out.println("2).salir ");
                                elec5=op.nextInt();
                            }
                            break;

                        case 5:
                            int elec6=0;
                            while(elec6==0) {
                                System.out.println("Mostrar todos los clientes");
                                System.out.println("----------------------------------------------");
                                for (Cliente client : controlTienda.getTienda().getClientesGeneral()) {
                                    System.out.println("Nombre: " + client.getNombre() + '\t' + " Cedula: " + client.getCedula());
                                }
                                Scanner v =new Scanner(System.in);
                                System.out.println("Elija la opcion que desea");
                                System.out.println("1).Salir");
                                elec6=v.nextInt();
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


package view;

import control.*;
import model.Sucursal;

import java.util.Scanner;

public class PantallaTienda {

    public static void main(String[] args) {

        int opcion;
        ControlTienda controlTienda = new ControlTienda(2);
        opcion = menuPrincipal();

        if(opcion == 5){
            controlTienda.
            opcion = menuSucursal(sucursal);
        }





    }

    public static int menuPrincipal(){
        int opcion;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bienvenidos a la Tienda Gigabyte");
        System.out.println("                                ");
        System.out.println("         Menu Princial          ");
        System.out.println("1) Crear mas Sucursales");
        System.out.println("2) Crear Cliente");
        System.out.println("3) Cargar Inventario");
        System.out.println("4) Guardar Inventario");
        System.out.println("5) Elegir Sucursal");
        System.out.println("6) Salir");
        System.out.println("Dijita el numero de la opcion que desee: ");
        opcion = entrada.nextInt();

        return opcion;
    }

    public static int menuSucursal(Sucursal sucursal){
        int opcion;
        Scanner entrada = new Scanner(System.in);
        System.out.println("Bienvenidos a la Sucursal " + sucursal.getUbicacion());
        System.out.println("                                ");
        System.out.println("         Menu Sucursal          ");
        System.out.println("1) Comprar");
        System.out.println("2) Salir");
        System.out.println("Dijita el numero de la opcion que desee: ");
        opcion = entrada.nextInt();

        return opcion;
    }

}

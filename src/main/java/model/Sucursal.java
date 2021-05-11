package model;

import java.util.ArrayList;

public class Sucursal extends Tienda {
    private String direccion;
    private ArrayList<Venta> ventas=new ArrayList<Venta>();
    private boolean abierta;
}

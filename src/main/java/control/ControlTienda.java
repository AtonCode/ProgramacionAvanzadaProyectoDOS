package control;
import model.Sucursal;
import model.Tienda;

import java.lang.ref.PhantomReference;
import java.util.ArrayList;

public class ControlTienda {

    private Tienda tienda = new Tienda("GigaByte", "WWW");
    private int numSucursales;
    private ArrayList<Sucursal> sucursales = new ArrayList<Sucursal>();

    private ControlInventario controlInventario = new ControlInventario();
    private ControlUsuario controlUsuario = new ControlUsuario();

    public ControlTienda(int numSucursales) {
        this.numSucursales = numSucursales;
    }

    public void crerSucursal(){
        
    }
}

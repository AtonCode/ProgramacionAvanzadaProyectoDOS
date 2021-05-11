package model;

public class EmpleadoSucursal extends Usuario {

    private int contraseña;
    private int numcaja;
    private int idSucursal;
    private float sueldoBase;
    private float sueldoFinal;

    public EmpleadoSucursal(int cedula, String nombre, String tipoUsuario, int numcaja, int idSucursal) {
        super(cedula, nombre, tipoUsuario);
        this.numcaja = numcaja;
        this.idSucursal = idSucursal;
    }
}

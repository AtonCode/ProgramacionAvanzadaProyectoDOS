package model;

public class Administrador extends Usuario{

    private int contraseña;
    private int idSucursal;

    public Administrador(int cedula, String nombre, String tipoUsuario, int contraseña, int idSucursal) {
        super(cedula, nombre, tipoUsuario);
        this.contraseña = contraseña;
        this.idSucursal = idSucursal;
    }
}

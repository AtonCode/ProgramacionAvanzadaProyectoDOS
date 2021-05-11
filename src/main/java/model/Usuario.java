package model;

public class Usuario {

    private int cedula;
    private String nombre;
    private String tipoUsuario;

    public Usuario(int cedula, String nombre, String tipoUsuario) {
        this.cedula = cedula;
        this.nombre = nombre;
        this.tipoUsuario = tipoUsuario;
    }
}

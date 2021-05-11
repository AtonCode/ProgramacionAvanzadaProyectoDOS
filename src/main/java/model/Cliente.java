package model;

public class Cliente extends Usuario{

    private int numeroCompras;
    private float descuentos;
    private int puntos;

    public Cliente(int cedula, String nombre, String tipoUsuario) {
        super(cedula, nombre, tipoUsuario);
    }
}

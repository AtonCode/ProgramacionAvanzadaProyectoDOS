package model;

public class Cliente extends Usuario{

    private int numeroCompras;
    private float descuentos;
    private int puntos;

    public Cliente(int cedula, String nombre, String tipoUsuario) {
        super(cedula, nombre, tipoUsuario);
    }

    public Cliente(int cedula, String nombre, String tipoUsuario, int numeroCompras, float descuentos, int puntos) {
        super(cedula, nombre, tipoUsuario);
        this.numeroCompras = numeroCompras;
        this.descuentos = descuentos;
        this.puntos = puntos;
    }

    public int getNumeroCompras() {
        return numeroCompras;
    }

    public void setNumeroCompras(int numeroCompras) {
        this.numeroCompras = numeroCompras;
    }

    public float getDescuentos() {
        return descuentos;
    }

    public void setDescuentos(float descuentos) {
        this.descuentos = descuentos;
    }

    public int getPuntos() {
        return puntos;
    }

    public void setPuntos(int puntos) {
        this.puntos = puntos;
    }

    @Override
    public String toString() {
        return "Cliente{" +
                "numeroCompras=" + numeroCompras +
                ", descuentos=" + descuentos +
                ", puntos=" + puntos +
                '}';
    }
}

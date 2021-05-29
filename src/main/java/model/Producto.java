package model;

public abstract class Producto {

    private double id;
    private double idSucursal;
    private int cantidad;
    private String tipo;
    private String nombre;
    private double precio;
    private String descripcion;
    private String resumen;

    public Producto() {
    }

    public Producto(double id, double idSucursal, int cantidad, String tipo, String nombre, double precio, String descripcion, String resumen) {
        this.id = id;
        this.idSucursal = idSucursal;
        this.cantidad = cantidad;
        this.tipo = tipo;
        this.nombre = nombre;
        this.precio = precio;
        this.descripcion = descripcion;
        this.resumen = resumen;
    }

    public double getId() {
        return id;
    }
    public void setId(double id) {
        this.id = id;
    }
    public int getCantidad() {
        return cantidad;
    }
    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }
    public String getTipo() {
        return tipo;
    }
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    public String getNombre() {
        return nombre;
    }
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    public double getPrecio() {
        return precio;
    }
    public void setPrecio(double precio) {
        this.precio = precio;
    }
    public String getDescripcion() {
        return descripcion;
    }
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }
    public String getResumen() {
        return resumen;
    }
    public void setResumen(String resumen) {
        this.resumen = resumen;
    }
    public double getIdSucursal() {
        return idSucursal;
    }
    public void setIdSucursal(double idSucursal) {
        this.idSucursal = idSucursal;
    }
    public abstract String getInfo();

    @Override
    public String toString() {
        return "Producto" +'\t' +
                "id=" + id +
                " idSucursal=" + idSucursal +'\t'+
                " cantidad=" + cantidad +'\t'+
                " tipo=" + tipo + '\t'+
                " nombre=" + nombre + '\t'+
                " precio=" + precio +'\t'+
                " descripcion='" + descripcion + '\t' +
                " resumen='" + resumen + '\t';
    }
}

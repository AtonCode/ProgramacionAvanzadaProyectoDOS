package model;

public class Dispositivo extends Producto{
    private String pantalla;
    private String almacenamient;
    private String procesamiento;
    private String tecnicas;
    private String descripcion_fisica;
    private String conectividad;
    private String informacinAdicional;
    private String descripcion;

    public Dispositivo() {
    }

    public Dispositivo(double id, double idSucursal, int cantidad, String tipo, String nombre, double precio, String descripcion, String resumen, String pantalla, String almacenamient, String procesamiento, String tecnicas, String descripcion_fisica, String conectividad, String informacinAdicional, String descripcion1) {
        super(id, idSucursal, cantidad, tipo, nombre, precio, descripcion, resumen);
        this.pantalla = pantalla;
        this.almacenamient = almacenamient;
        this.procesamiento = procesamiento;
        this.tecnicas = tecnicas;
        this.descripcion_fisica = descripcion_fisica;
        this.conectividad = conectividad;
        this.informacinAdicional = informacinAdicional;
        this.descripcion = descripcion1;
    }

    public String getPantalla() {
        return pantalla;
    }

    public void setPantalla(String pantalla) {
        this.pantalla = pantalla;
    }

    public String getAlmacenamient() {
        return almacenamient;
    }

    public void setAlmacenamient(String almacenamient) {
        this.almacenamient = almacenamient;
    }

    public String getProcesamiento() {
        return procesamiento;
    }

    public void setProcesamiento(String procesamiento) {
        this.procesamiento = procesamiento;
    }

    public String getTecnicas() {
        return tecnicas;
    }

    public void setTecnicas(String tecnicas) {
        this.tecnicas = tecnicas;
    }

    public String getDescripcion_fisica() {
        return descripcion_fisica;
    }

    public void setDescripcion_fisica(String descripcion_fisica) {
        this.descripcion_fisica = descripcion_fisica;
    }

    public String getConectividad() {
        return conectividad;
    }

    public void setConectividad(String conectividad) {
        this.conectividad = conectividad;
    }

    public String getInformacinAdicional() {
        return informacinAdicional;
    }

    public void setInformacinAdicional(String informacinAdicional) {
        this.informacinAdicional = informacinAdicional;
    }

    @Override
    public String getDescripcion() {
        return descripcion;
    }

    @Override
    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String getInfo() {
         return super.toString() + "Dispositivo" + '\t' +
                "pantalla= " + pantalla + '\t' +
                " almacenamient= " + almacenamient + '\t' +
                " procesamiento= " + procesamiento + '\t' +
                " tecnicas= " + tecnicas + '\t' +
                " descripcion_fisica= " + descripcion_fisica + '\t' +
                " conectividad= " + conectividad + '\t' +
                " informacinAdicional= " + informacinAdicional + '\t' +
                " descripcion= " + descripcion + '\t';


    }


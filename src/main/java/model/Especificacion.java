package model;
// no se si deba eliminarla
public class Especificacion {
    private boolean pantalla;
    private boolean almacenamient;
    private boolean procesamiento;
    private boolean tecnicas;
    private String descripcion_fisica;
    private boolean conectividad;
    private boolean informacinAdicional;
    private String descripcion;

    public Especificacion() {
    }

    public boolean isPantalla() {
        return pantalla;
    }

    public void setPantalla(boolean pantalla) {
        this.pantalla = pantalla;
    }

    public boolean isAlmacenamient() {
        return almacenamient;
    }

    public void setAlmacenamient(boolean almacenamient) {
        this.almacenamient = almacenamient;
    }

    public boolean isProcesamiento() {
        return procesamiento;
    }

    public void setProcesamiento(boolean procesamiento) {
        this.procesamiento = procesamiento;
    }

    public boolean isTecnicas() {
        return tecnicas;
    }

    public void setTecnicas(boolean tecnicas) {
        this.tecnicas = tecnicas;
    }

    public String getDescripcion_fisica() {
        return descripcion_fisica;
    }

    public void setDescripcion_fisica(String descripcion_fisica) {
        this.descripcion_fisica = descripcion_fisica;
    }

    public boolean isConectividad() {
        return conectividad;
    }

    public void setConectividad(boolean conectividad) {
        this.conectividad = conectividad;
    }

    public boolean isInformacinAdicional() {
        return informacinAdicional;
    }

    public void setInformacinAdicional(boolean informacinAdicional) {
        this.informacinAdicional = informacinAdicional;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    @Override
    public String toString() {
        return "Especificacion{" +
                "pantalla=" + pantalla +
                ", almacenamient=" + almacenamient +
                ", procesamiento=" + procesamiento +
                ", tecnicas=" + tecnicas +
                ", descripcion_fisica='" + descripcion_fisica + '\'' +
                ", conectividad=" + conectividad +
                ", informacinAdicional=" + informacinAdicional +
                ", descripcion='" + descripcion + '\'' +
                '}';
    }
}

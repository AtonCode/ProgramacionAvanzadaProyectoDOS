package model;

public class Componente extends Producto{

    private String dispsitivoPertence;
    private String descripcion_fisica;
    private String informacinAdicional;


    public Componente(double id, int idSucursal, int cantidad, String tipo, String nombre, double precio, String descripcion, String resumen, String dispsitivoPertence, String descripcion_fisica, String informacinAdicional) {
        super(id, idSucursal, cantidad, tipo, nombre, precio, descripcion, resumen);

        this.dispsitivoPertence = dispsitivoPertence;
        this.descripcion_fisica = descripcion_fisica;
        this.informacinAdicional = informacinAdicional;
    }

    public String getDispsitivoPertence() {
        return dispsitivoPertence;
    }

    public void setDispsitivoPertence(String dispsitivoPertence) {
        this.dispsitivoPertence = dispsitivoPertence;
    }

    public String getDescripcion_fisica() {
        return descripcion_fisica;
    }

    public void setDescripcion_fisica(String descripcion_fisica) {
        this.descripcion_fisica = descripcion_fisica;
    }

    public String getInformacinAdicional() {
        return informacinAdicional;
    }

    public void setInformacinAdicional(String informacinAdicional) {
        this.informacinAdicional = informacinAdicional;
    }

    @Override
    public String getInfo() {
        return super.toString()+("Componente" + '\t'+
                "dispsitivoPertence= " + dispsitivoPertence + '\t' +
                " descripcion_fisica= " + descripcion_fisica + '\t' +
                " informacinAdicional= " + informacinAdicional + '\t');
    }
    @Override
    public String imprimirInfo(){
        return (this.dispsitivoPertence+","+this.descripcion_fisica+","+this.informacinAdicional);
    }
}



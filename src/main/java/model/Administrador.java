package model;

public class Administrador extends Usuario{

    private long Contraseña;
    private float salario;


    public Administrador(){
        super();
    }

    public Administrador(int cedula, String nombre, String tipoUsuario, long contraseña, float salario) {
        super(cedula, nombre, tipoUsuario);
        Contraseña = contraseña;
        this.salario = salario;
    }

    public float getSalario() {
        return salario;
    }
    public void agregar_cliente(){


    }
}

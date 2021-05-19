package clases;

public class Cliente {
    Integer id;
    String nombres;
    String apellidos;
    String dni;
    String edad;
    String celular;
    String direccion;

    public Cliente(String nombres, String apellidos, String dni, String edad, String celular, String direccion) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.dni = dni;
        this.edad = edad;
        this.celular = celular;
        this.direccion = direccion;
    }
}

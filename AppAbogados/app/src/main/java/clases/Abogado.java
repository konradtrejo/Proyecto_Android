package clases;

public class Abogado {
    Integer id;
    String nombres;
    String apellidos;
    String edad;
    String celular;
    String colegiatura;
    String despacho;

    public Abogado(String nombres, String apellidos, String edad, String celular, String colegiatura, String despacho) {
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.edad = edad;
        this.celular = celular;
        this.colegiatura = colegiatura;
        this.despacho = despacho;
    }
}

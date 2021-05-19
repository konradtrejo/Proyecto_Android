package clases;

public class Caso {
    Integer id;
    String nombre;
    Integer idAbogado;
    Integer idCliente;
    Integer idEscrito;

    public Caso(String nombre, Integer idAbogado, Integer idCliente, Integer idEscrito) {
        this.nombre = nombre;
        this.idAbogado = idAbogado;
        this.idCliente = idCliente;
        this.idEscrito = idEscrito;
    }
}

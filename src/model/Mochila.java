package model;

public class Mochila {

    private String nombre;
    private int idEntrenador;
    private int cantidad;
	private int idObjeto;

    // Constructor
    public Mochila(int idEntrenador, int idObjeto, int cantidad) {
        this.idEntrenador = idEntrenador;
        this.idObjeto = idObjeto;
        this.cantidad = cantidad;
    }

    // Getters y Setters
    public int getIdObjeto() {
        return idObjeto;
    }

    public void setIdObjeto(int idObjeto) {
        this.idObjeto = idObjeto;
    }
    
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    // para ver en consola mas facilmente
    @Override
    public String toString() {
        return "Objeto: " + nombre + ", Cantidad: " + cantidad;
    }
}
package model;

public class Mochila {

    private String nombre;
    private int cantidad;

    // Constructor
    public Mochila(String nombre, int cantidad) {
        this.nombre = nombre;
        this.cantidad = cantidad;
    }

    // Getters y Setters
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
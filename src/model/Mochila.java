package model;

public class Mochila {

    private int id_entrenador;
    private int id_objeto;
    private int cantidad;
    
    public Mochila(int id_entrenador, int idObjeto, int cantidad) {
        this.id_entrenador = id_entrenador;
        this.id_objeto = idObjeto;
        this.cantidad = cantidad;
    }
    
    public int getIdEntrenador() {
        return id_entrenador;
    }

    public void setIdEntrenador(int idEntrenador) {
        this.id_entrenador = idEntrenador;
    }

    public int getIdObjeto() {
        return id_objeto;
    }

    public void setIdObjeto(int idObjeto) {
        this.id_objeto = idObjeto;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

}

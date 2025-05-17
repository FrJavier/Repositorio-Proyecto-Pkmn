package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import database.DatabaseConnection;

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

    // para ver en consola mas fácilmente
    @Override
    public String toString() {
        return "Objeto: " + nombre + ", Cantidad: " + cantidad;
    }

    // Método corregido: ahora recibe el idEntrenador como parámetro
    public static void agregarObjeto(int idEntrenador, String nombreObjeto) {
        try (Connection conexion = DatabaseConnection.getConnection()) {

            // Paso 1: Obtener el id del objeto por su nombre
            int idObjeto = -1;
            String queryId = "SELECT id_objeto FROM objeto WHERE num_objeto = ?";
            try (PreparedStatement stmtId = conexion.prepareStatement(queryId)) {
                stmtId.setString(1, nombreObjeto);
                try (ResultSet rs = stmtId.executeQuery()) {
                    if (rs.next()) {
                        idObjeto = rs.getInt("id_objeto");
                    } else {
                        System.err.println("Objeto no encontrado en la tabla objeto: " + nombreObjeto);
                        return;
                    }
                }
            }

            // Paso 2: Insertar o actualizar en la tabla mochila
            String sql = """
                INSERT INTO mochila (id_entrenador, id_objeto, cantidad)
                VALUES (?, ?, 1)
                ON DUPLICATE KEY UPDATE cantidad = cantidad + 1
                """;

            try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
                stmt.setInt(1, idEntrenador);
                stmt.setInt(2, idObjeto);
                stmt.executeUpdate();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

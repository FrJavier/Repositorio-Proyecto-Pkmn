package database;

import database.EntrenadorDatabase;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;
import model.Entrenador;
import model.Mochila;
import model.Objeto;

public class MochilaDatabase {
	
	static int id_entrenador;
	
	

	    public static ArrayList<Mochila> cargarObjetos(int idEntrenador) {
	        ArrayList<Mochila> mochila = new ArrayList<>();
	        String sql = "SELECT id_objeto, cantidad FROM mochila WHERE id_entrenador = ?";

	        try (Connection conn = DatabaseConnection.getConnection();
	             PreparedStatement stmt = conn.prepareStatement(sql)) {

	            stmt.setInt(1, idEntrenador);
	            ResultSet rs = stmt.executeQuery();

	            while (rs.next()) {
	                int idObjeto = rs.getInt("id_objeto");
	                int cantidad = rs.getInt("cantidad");
	                mochila.add(new Mochila(idEntrenador, idObjeto, cantidad));
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return mochila;
	    }

	    public static void agregarObjeto(int idEntrenador, int idObjeto, int cantidadAgregar) {
	        String sqlExiste = "SELECT cantidad FROM mochila WHERE id_entrenador = ? AND id_objeto = ?";
	        String sqlInsertar = "INSERT INTO mochila (id_entrenador, id_objeto, cantidad) VALUES (?, ?, ?)";
	        String sqlActualizar = "UPDATE mochila SET cantidad = ? WHERE id_entrenador = ? AND id_objeto = ?";

	        try (Connection conn = DatabaseConnection.getConnection()) {
	            PreparedStatement stmtExiste = conn.prepareStatement(sqlExiste);
	            stmtExiste.setInt(1, idEntrenador);
	            stmtExiste.setInt(2, idObjeto);
	            ResultSet rs = stmtExiste.executeQuery();

	            if (rs.next()) {
	                int cantidadActual = rs.getInt("cantidad");
	                int nuevaCantidad = cantidadActual + cantidadAgregar;

	                PreparedStatement stmtActualizar = conn.prepareStatement(sqlActualizar);
	                stmtActualizar.setInt(1, nuevaCantidad);
	                stmtActualizar.setInt(2, idEntrenador);
	                stmtActualizar.setInt(3, idObjeto);
	                stmtActualizar.executeUpdate();
	            } else {
	                PreparedStatement stmtInsertar = conn.prepareStatement(sqlInsertar);
	                stmtInsertar.setInt(1, idEntrenador);
	                stmtInsertar.setInt(2, idObjeto);
	                stmtInsertar.setInt(3, cantidadAgregar);
	                stmtInsertar.executeUpdate();
	            }
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }
	    }
	    
	    
    public static boolean actualizarCantidad(int idEntrenador, int idObjeto, int nuevaCantidad) {
        try (Connection con = DatabaseConnection.getConnection()) {
        	//Si es cerro no aparece
        	if (nuevaCantidad <= 0) {
                
                return restarObjeto(idEntrenador, idObjeto);
            }
        	
            String sql = "UPDATE MOCHILA SET CANTIDAD = ? WHERE ID_ENTRENADOR = ? AND ID_OBJETO = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, nuevaCantidad);
            stmt.setInt(2, idEntrenador);
            stmt.setInt(3, idObjeto);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    
    public static boolean restarObjeto(int idEntrenador, int idObjeto) {
        try (Connection con = DatabaseConnection.getConnection()) {
            String sql = "DELETE FROM MOCHILA WHERE ID_ENTRENADOR = ? AND ID_OBJETO = ?";
            PreparedStatement stmt = con.prepareStatement(sql);
            stmt.setInt(1, idEntrenador);
            stmt.setInt(2, idObjeto);
            return stmt.executeUpdate() > 0;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }
    }
    public static void crearmochilanueva(int Entrenador) {
		agregarObjeto(id_entrenador,8,10 );
		agregarObjeto(id_entrenador,1,1);
    }
    
    
}


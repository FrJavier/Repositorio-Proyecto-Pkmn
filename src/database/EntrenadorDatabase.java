package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Random;

import model.Entrenador;


public class EntrenadorDatabase {

	public static void crearEntrenador(Connection conexion, Entrenador entrenador)throws SQLException  {
		// TODO Auto-generated method stub
	
			
			entrenador.setId_entrenador(obtenerId_Entrenador(conexion));
			entrenador.setPokedollares(generarPokedolares());
			
			String sql = "INSERT INTO ENTRENADOR (id_entrenador, usuario, pass, pokedollares) \r\n"
						+ "VALUES(?,?,?,?)";
			PreparedStatement st = conexion.prepareStatement(sql);
			st.setInt(1, entrenador.getId_entrenador());
			st.setString(2, entrenador.getUsuario());
			st.setString(3, entrenador.getPass());
			st.setDouble(4, entrenador.getPokedollares());
			st.executeUpdate();
			
			
		}

	private static int obtenerId_Entrenador(Connection con) throws SQLException {
		int idEntrenador = 0;
		String sql = "SELECT MAX(id_entrenador)+1\r\n" + "FROM entrenador";

		Statement st;

		st = con.createStatement();
		ResultSet rs = st.executeQuery(sql);

		while (rs.next()) {
			idEntrenador = rs.getInt(1);
		}

		return idEntrenador;
	}
		
	private static int generarPokedolares() {
		Random rd = new Random();
		return rd.nextInt(501) + 1000;
	}
		
	public static void obtenerIDPokedolaresEntre(Connection conn, Entrenador entrenador) {
	    String sql = "SELECT id_entrenador, pokedollares FROM entrenador WHERE usuario = ?";
	    try (PreparedStatement ps = conn.prepareStatement(sql)) {
	        ps.setString(1, entrenador.getUsuario());
	        try (ResultSet rs = ps.executeQuery()) {
	            if (rs.next()) {
	                entrenador.setId_entrenador(rs.getInt("id_entrenador"));
	                entrenador.setPokedollares(rs.getInt("pokedollares"));
	            }
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

		
	}
	


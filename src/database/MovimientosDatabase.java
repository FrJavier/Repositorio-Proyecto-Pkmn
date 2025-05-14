package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;

import model.Estado;
import model.MVataque;
import model.MVestado;
import model.MVmejora;
import model.movimiento;
import model.Pokemon;
import model.tipo;

public class MovimientosDatabase {
	
	public static LinkedList<movimiento> cargarMovimientos(Connection conexion, int idPokemon) throws SQLException {
		String sql = "SELECT M.id_movimiento,\r\n" 
					+ "	M.nom_movimiento,\r\n" 
				+ "    M.potencia,\r\n"
				+ "    M.tipo,\r\n" 
				+ "    M.estado,\r\n" 
				+ "    M.QUITA,\r\n" 
				+ "    M.turnos,\r\n"
				+ "    M.pp_max,\r\n"
				+ "    M.nivel_aprendizaje\r\n"
				+ "FROM movimiento_pokemon MP\r\n" 
				+ "INNER JOIN movimiento M\r\n"
				+ "	ON M.id_movimiento = MP.id_movimiento\r\n" 
				+ "WHERE MP.id_pokemon=?";

		PreparedStatement ps = conexion.prepareStatement(sql);
		ps.setInt(1, idPokemon);

		ResultSet rs = ps.executeQuery();
		LinkedList<movimiento> listadoMovimientos = new LinkedList<movimiento>();

		while (rs.next()) {
			if (!rs.getString(8).equals("")) {//Mejora
				MVmejora mj = new MVmejora();
				mj.setId_movimiento(rs.getInt(1));
				mj.setNom_movimiento(rs.getString(2));
				mj.setDuracion(rs.getInt(7));
				mj.setTurnos(rs.getInt(10));
				mj.setTipoMejora(rs.getString(8));
				listadoMovimientos.add(mj);
				
			} else if (!rs.getString(5).equals("")) {
				MVestado est = new MVestado();
				est.setId_movimiento(rs.getInt(1));
				est.setNom_movimiento(rs.getString(2));
				est.setduracion(rs.getInt(7));
				est.setTurnos(rs.getInt(10));
				est.setEstado(Estado.convertirEstado(rs.getString(5)));
				
				listadoMovimientos.add(est);
			} else {
				MVataque at = new MVataque();

				at.setId_movimiento(rs.getInt(1));
				at.setNom_movimiento(rs.getString(2));
				at.setPotencia(rs.getInt(3));
				at.setTipo(tipo.convertir(rs.getString(4)));
				at.setTurnos(rs.getInt(10));
				
				listadoMovimientos.add(at);
			}
		}
		return listadoMovimientos;
	}

	
}

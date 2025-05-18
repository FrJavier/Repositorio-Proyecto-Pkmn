package database;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.Collections;
import java.util.ArrayList;

import model.Estado;
import model.MVataque;
import model.MVestado;
import model.MVmejora;
import model.movimiento;
import model.Pokemon;
import model.tipo;

public class MovimientosDatabase {
	
	public static LinkedList<movimiento> cargarMovimientos(Connection conexion, int idPokemon) throws SQLException {
	    String sql = """
	        SELECT M.id_movimiento, M.nom_movimiento, M.potencia, M.tipo,MP.id_pokemon,
	               M.estado, M.mejora, M.turnos, M.pp_max, M.nivel_aprendizaje
	        FROM movimiento_pokemon MP
	        INNER JOIN movimiento M ON M.id_movimiento = MP.id_movimiento
	        WHERE MP.id_pokemon = ?
	    """;

	    PreparedStatement ps = conexion.prepareStatement(sql);
	    ps.setInt(1, idPokemon);
	    ResultSet rs = ps.executeQuery();

	    LinkedList<movimiento> listadoMovimientos = new LinkedList<>();

	    while (rs.next()) {
	        String mejora = rs.getString("mejora");
	        String estado = rs.getString("estado");

	        if (mejora != null && !mejora.isEmpty()) {
	            MVmejora mj = new MVmejora();
	            mj.setId_movimiento(rs.getInt("id_movimiento"));
	            mj.setNom_movimiento(rs.getString("nom_movimiento"));
	            mj.setDuracion(rs.getInt("pp_max"));
	            mj.setTurnos(rs.getInt("turnos"));
	            mj.setTipoMejora(mejora);
	            listadoMovimientos.add(mj);

	        } else if (estado != null && !estado.isEmpty()) {
	            MVestado est = new MVestado();
	            est.setId_movimiento(rs.getInt("id_movimiento"));
	            est.setNom_movimiento(rs.getString("nom_movimiento"));
	            est.setduracion(rs.getInt("pp_max"));
	            est.setTurnos(rs.getInt("turnos"));
	            est.setEstado(Estado.convertirEstado(estado));
	            listadoMovimientos.add(est);

	        } else {
	            MVataque at = new MVataque();
	            at.setId_movimiento(rs.getInt("id_movimiento"));
	            at.setNom_movimiento(rs.getString("nom_movimiento"));
	            at.setPotencia(rs.getInt("potencia"));
	            at.setTipo(tipo.convertir(rs.getString("tipo")));
	            at.setTurnos(rs.getInt("turnos"));
	            listadoMovimientos.add(at);
	        }
	    }
	    return listadoMovimientos;
	}
	
	public static void asignarMovimientosAleatorios(Connection conexion, int idPokemon) throws SQLException {
	    

		String sqlDelete = "DELETE FROM movimiento_pokemon WHERE id_pokemon = ?";
	    try (PreparedStatement psDelete = conexion.prepareStatement(sqlDelete)) {
	        psDelete.setInt(1, idPokemon);
	        psDelete.executeUpdate();}
	    
	    String sqlTodos = "SELECT id_movimiento, pp_max FROM movimiento";
	    ArrayList<int[]> movimientosDisponibles = new ArrayList<>();
	    try (PreparedStatement psTodos = conexion.prepareStatement(sqlTodos);
	         ResultSet rs = psTodos.executeQuery()) {
	        while (rs.next()) {
	            int id = rs.getInt("id_movimiento");
	            int ppMax = rs.getInt("pp_max");
	            movimientosDisponibles.add(new int[]{id, ppMax});
	        }
	    }

	    // Barajar aleatoriamente y elegir hasta 4
	    Collections.shuffle(movimientosDisponibles);
	    int cantidadMovimientos = Math.min(4, movimientosDisponibles.size());

	    // Insertar los movimientos seleccionados
	    String sqlInsert = "INSERT INTO movimiento_pokemon (id_pokemon, id_movimiento, pp_actuales) VALUES (?, ?, ?)";
	    try (PreparedStatement psInsert = conexion.prepareStatement(sqlInsert)) {
	        for (int i = 0; i < cantidadMovimientos; i++) {
	            int[] movimiento = movimientosDisponibles.get(i);
	            int idMovimiento = movimiento[0];
	            int ppMax = movimiento[1];

	            psInsert.setInt(1, idPokemon);
	            psInsert.setInt(2, idMovimiento);
	            psInsert.setInt(3, ppMax);
	            psInsert.executeUpdate();
	        }
	    }
	}

}

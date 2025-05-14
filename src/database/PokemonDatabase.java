package database;


import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Random;

import controller.LoginController;
import model.Entrenador;
import model.movimiento;
import model.Pokemon;
import model.tipo;
import database.DatabaseConnection;
import javafx.stage.Stage;
import database.MovimientosDatabase;

public class PokemonDatabase {
	
	
		public static void obtenerPokemon(Connection conexion, Entrenador entrenador, int caja)throws SQLException{
			
			String sql ="Select id_pokemon,\r\n"
					+ "		dx.num_pokedex,\r\n"
					+ "		dx.nombre,\r\n"
					+ "		dx.TIPO_O1,\r\n"
					+ "		dx.TIPO_O2,\r\n"
					+ "		dx.IMG_Frontal,\r\n"
					+ "		dx.IMG_Trasera,\r\n"
					+ "		dx.SONIDO,\r\n"
					+ "		dx.NIVEL_EVOLUCION,\r\n"
					+ "		dx.num_pokedex,\r\n"
					+ "		pk.ataque,\r\n"
					+ "		pk.atk_especial,\r\n"
					+ "		pk.defensa,\r\n"
					+ "		pk.def_especial,\r\n"
					+ "		pk.note,\r\n"
					+ "		pk.nivel\r\n"
					+ "FROM pokemon\r\n"
					+ "INNER JOIN pokedex dx\r\n"
					+ "	ON dx.num_pokedex = pk.num_pokedex\r\n"
					+ "WHERE pk.id_entrenador =?\r\n";
			
			PreparedStatement ps = conexion.prepareStatement(sql);
			ps.setInt(1, entrenador.getId_entrenador());
			ps.setInt(2, caja);
			
			ResultSet rs = ps.executeQuery();
			LinkedList<Pokemon> listadoPokemon = new LinkedList<Pokemon>();
			Pokemon prueba;
			while (rs.next()) {
				prueba = new Pokemon();
				prueba.setId_pokemon(rs.getInt(1));
				prueba.setNum_pokedex(rs.getInt(2));
				prueba.setNombre(rs.getString(3));
				prueba.setTipo1(tipo.convertir(rs.getString(4)));
				prueba.setTipo2(tipo.convertir(rs.getString(5)));
				prueba.setIMG_Frontal(rs.getString(6));
				prueba.setIMG_Frontal(rs.getString(7));
				prueba.setNIVEL_EVOLUCION(rs.getInt(9));
				prueba.setAtaque(rs.getInt(11));
				prueba.setAtk_especial(rs.getInt(12));
				prueba.setDefensa(rs.getInt(13));
				prueba.setNote(rs.getString(14));
				prueba.setNivel(rs.getInt(15));
				prueba.setMovimientos(MovimientosDatabase.cargarMovimientos(conexion, prueba.getId_pokemon()));
				//poke.setObjeto(obtenerObjeto(conexion, poke.getIdPokemon()));
				listadoPokemon.add(prueba);
			}
			
			if(caja ==1) {
				entrenador.setEquipo(listadoPokemon);
			}else {
				entrenador.setPokemonCaja(listadoPokemon);
			}
		}
		
		
	}


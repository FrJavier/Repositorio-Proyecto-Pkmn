package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Random;

import database.DatabaseConnection;
import database.MochilaDatabase;

public class Entrenador {

	private int id_entrenador;
	private String usuario;
	private String pass;
	private int pokedollares;

	private LinkedList<Pokemon> equipo;
	private LinkedList<Caja> caja;
	private ArrayList<Mochila> Mochila;

	public int getId_entrenador() {
		return id_entrenador;
	}

	public void setId_entrenador(int id_entrenador) {
		this.id_entrenador = id_entrenador;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getPass() {
		return pass;
	}

	public void setPass(String pass) {
		this.pass = pass;
	}

	public int getPokedollares() {
		return pokedollares;
	}

	public void setPokedollares(int pokedollares) {
		this.pokedollares = pokedollares;
	}

	@Override
	public String toString() {
		return "Entrenador [id_entrenador=" + id_entrenador + ", usuario=" + usuario + ", pass=" + pass
				+ ", pokedollares=" + pokedollares + ", equipo=" + equipo + ", caja=" + caja + ", mochila=" + Mochila
				+ "]";
	}

	public Entrenador(int id_entrenador, String usuario, String pass, int pokedollares) {
		super();
		this.id_entrenador = id_entrenador;
		this.usuario = usuario;
		this.pass = pass;
		this.pokedollares = pokedollares;
	}

	public Entrenador(String usuario, String pass) {
		super();
		this.usuario = usuario;
		this.pass = pass;

	}

	public Entrenador(int id_entrenador, String usuario, String pass, int pokedollares, LinkedList<Pokemon> equipo,
			LinkedList<Caja> caja, ArrayList<model.Mochila> Mochila) {
		super();
		this.id_entrenador = id_entrenador;
		this.usuario = usuario;
		this.pass = pass;
		this.pokedollares = pokedollares;
		this.equipo = equipo;
		this.caja = caja;
		this.Mochila = Mochila;
	}

	// para comprobar el dinero del que dispone el entreandor en la tienda
	public int getDinero() {
		return this.pokedollares;
	}

	// para hacer operaciones de restas y cosas asi cuando compras un objeto en la
	// tienda
	public void setDinero(int dinero) {
		this.pokedollares = dinero;
	}

	// devuelve el equipo actual (es para el centro pokemon)
	public LinkedList<Pokemon> getEquipo() {
		return equipo;
	}

	// esto por si nos hace falta en algun momento, no hace falta en verdad pero por
	// si acaso
	public void setEquipo(LinkedList<Pokemon> equipo) {
		this.equipo = equipo;
	}

	// asegurarnos de que solo podemos meter 6 pokemons en el equipo y si ya tienes
	// 6, que los nuevos los envie a la caja
	public void agregarPokemonAlEquipo(Pokemon nuevo) {
		if (equipo == null) {
			equipo = new LinkedList<>();
		}

		if (caja == null) {
			caja = new LinkedList<>();
		}

		if (equipo.size() < 6) {
			equipo.add(nuevo);
		} else {
			caja.add(new Caja(nuevo));
			System.out.println("Tu equipo solo puede tener 6 Pokémons, el nuevo Pokémon se ha enviado a la caja");
		}
	}

	public void agregarObjeto(String nombreObjeto) {
		mochila.agregarObjeto(nombreObjeto);
	    
	    try (Connection conexion = DatabaseConnection.getConnection()) {
	        String sql = "INSERT INTO objetos_entrenador (entrenador_id, objeto_nombre) VALUES (?, ?)";
	        try (PreparedStatement stmt = conexion.prepareStatement(sql)) {
	            stmt.setInt(1, this.id_entrenador); // Asegúrate de tener `id` en Entrenador
	            stmt.setString(2, nombreObjeto);
	            stmt.executeUpdate();
	        }
	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}

	private Mochila mochila;



public void cargarMochila() {
    Mochila = MochilaDatabase.cargarObjetos(this.id_entrenador);
}



}

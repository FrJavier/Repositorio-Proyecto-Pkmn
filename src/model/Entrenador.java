package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Random;

public class Entrenador {
	
	private int id_entrenador;
	private String usuario;
	private String pass;
	private int pokedollares;
	
	private LinkedList<pokemon> equipo;
	private LinkedList<Caja> caja;
	private LinkedList <Mochila> Mochila;
	
	
	
	
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
	
	public Entrenador( String usuario, String pass) {
		super();
		this.usuario = usuario;
		this.pass = pass;
		
	}
	public Entrenador(int id_entrenador, String usuario, String pass, int pokedollares, LinkedList<pokemon> equipo,
			LinkedList<Caja> caja, LinkedList<model.Mochila> Mochila) {
		super();
		this.id_entrenador = id_entrenador;
		this.usuario = usuario;
		this.pass = pass;
		this.pokedollares = pokedollares;
		this.equipo = equipo;
		this.caja = caja;
		this.Mochila = Mochila;
	}
	
	
	

	
	
	
}

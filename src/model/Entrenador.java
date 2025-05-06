package model;

import java.util.LinkedList;

public class Entrenador {
	
	private int id_entrenador;
	private String usuario;
	private String pass;
	private int pokedollares;
	
	
	
	
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
				+ ", pokedollares=" + pokedollares + "]";
	}
	
	
	public Entrenador(int id_entrenador, String usuario, String pass, int pokedollares) {
		super();
		this.id_entrenador = id_entrenador;
		this.usuario = usuario;
		this.pass = pass;
		this.pokedollares = pokedollares;
	}
	
	
	
	
	
	
	
}

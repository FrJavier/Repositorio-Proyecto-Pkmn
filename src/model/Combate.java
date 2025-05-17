package model;

import java.util.LinkedList;
import java.util.Random;

public class Combate {

	int combate_id;
	int ganador_id;
	Entrenador jugador;
	Entrenador rival;
	LinkedList<Turno> contTurnos;
	int pkDerrotadosRival;
	int pkDerrotadosUser;

	

	public int getCombate_id() {
		return combate_id;
	}



	public void setCombate_id(int combate_id) {
		this.combate_id = combate_id;
	}



	public int getGanador_id() {
		return ganador_id;
	}



	public void setGanador_id(int ganador_id) {
		this.ganador_id = ganador_id;
	}



	public Entrenador getJugador() {
		return jugador;
	}



	public void setJugador(Entrenador jugador) {
		this.jugador = jugador;
	}



	public Entrenador getRival() {
		return rival;
	}



	public void setRival(Entrenador rival) {
		this.rival = rival;
	}



	public LinkedList<Turno> getContTurnos() {
		return contTurnos;
	}



	public void setContTurnos(LinkedList<Turno> contTurnos) {
		this.contTurnos = contTurnos;
	}



	public int getPkDerrotadosRival() {
		return pkDerrotadosRival;
	}



	public void setPkDerrotadosRival(int pkDerrotadosRival) {
		this.pkDerrotadosRival = pkDerrotadosRival;
	}



	public int getPkDerrotadosUser() {
		return pkDerrotadosUser;
	}



	public void setPkDerrotadosUser(int pkDerrotadosUser) {
		this.pkDerrotadosUser = pkDerrotadosUser;
	}



	public Combate(Entrenador jugador, Entrenador rival) {
		this.jugador = jugador;
		this.rival = rival;
		this.contTurnos = new LinkedList<>();

		
		
		
	}



	public Combate(int combate_id, int ganador_id, Entrenador jugador, Entrenador rival, LinkedList<Turno> contTurnos,
			int pkDerrotadosRival, int pkDerrotadosUser) {
		super();
		this.combate_id = combate_id;
		this.ganador_id = ganador_id;
		this.jugador = jugador;
		this.rival = rival;
		this.contTurnos = contTurnos;
		this.pkDerrotadosRival = pkDerrotadosRival;
		this.pkDerrotadosUser = pkDerrotadosUser;
	}

}

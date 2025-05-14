package model;

public abstract class movimiento {
	
	private int id_movimiento;
	private String nom_movimiento;
	private int turnos;
	
	
	public int getId_movimiento() {
		return id_movimiento;
	}
	public void setId_movimiento(int id_movimiento) {
		this.id_movimiento = id_movimiento;
	}
	public String getNom_movimiento() {
		return nom_movimiento;
	}
	public void setNom_movimiento(String nom_movimiento) {
		this.nom_movimiento = nom_movimiento;
	}
	public int getTurnos() {
		return turnos;
	}
	public void setTurnos(int turnos) {
		this.turnos = turnos;
	}
	
	public abstract void ejecutar(Pokemon atacante, Pokemon objetivo);

	public boolean calcularProbabilidad() {

		double random = Math.random();

				return random < 0.5;
	}
	
	
	

}

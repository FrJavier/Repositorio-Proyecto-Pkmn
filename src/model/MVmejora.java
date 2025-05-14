package model;

public class MVmejora extends movimiento {

	@Override
	public void ejecutar(Pokemon atacante, Pokemon objetivo) {	
	}
	
	private int duracion;
	private String tipoMejora;
	
	public int getDuracion() {
		return duracion;
	}
	public void setDuracion(int duracion) {
		this.duracion = duracion;
	}
	public String getTipoMejora() {
		return tipoMejora;
	}
	public void setTipoMejora(String tipoMejora) {
		this.tipoMejora = tipoMejora;
	}
	
	
	
	

}

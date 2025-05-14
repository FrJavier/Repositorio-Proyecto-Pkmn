package model;

public class Objeto {
	
	private int id_objeto;
	private String num_objeto; //esto hay que mirarlo porque deberia ser "nom_objeto", en la base de datos esta como "num_objeto" por eso lo he puesto igual
	private double ataque;
	private double at_especial;
	private double defensa;
	private double def_especial;
	private double velocidad;
	private double precio;
	private double pp_mov; //esto tampoco entiendo porque es asi
	
	
	public int getId_objeto() {
		return id_objeto;
	}
	public void setId_objeto(int id_objeto) {
		this.id_objeto = id_objeto;
	}
	public String getNum_objeto() {
		return num_objeto;
	}
	public void setNum_objeto(String num_objeto) {
		this.num_objeto = num_objeto;
	}
	public double getAtaque() {
		return ataque;
	}
	public void setAtaque(double ataque) {
		this.ataque = ataque;
	}
	public double getAt_especial() {
		return at_especial;
	}
	public void setAt_especial(double at_especial) {
		this.at_especial = at_especial;
	}
	public double getDefensa() {
		return defensa;
	}
	public void setDefensa(double defensa) {
		this.defensa = defensa;
	}
	public double getDef_especial() {
		return def_especial;
	}
	public void setDef_especial(double def_especial) {
		this.def_especial = def_especial;
	}
	public double getVelocidad() {
		return velocidad;
	}
	public void setVelocidad(double velocidad) {
		this.velocidad = velocidad;
	}
	public double getPrecio() {
		return precio;
	}
	public void setPrecio(double precio) {
		this.precio = precio;
	}
	public double getPp_mov() {
		return pp_mov;
	}
	public void setPp_mov(double pp_mov) {
		this.pp_mov = pp_mov;
	}
	
	
}

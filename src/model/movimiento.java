package model;

public class movimiento {
	
	private int id_movimiento;
	private String nom_movimiento;
	private int nivel_aprendizaje;
	private int pp_max;
	private String tipo;
	private int potencia;
	private String estado;
	private int turnos;
	private int num;
	
	public enum TipoMovimiento {
	    NORMAL,
	    FUEGO,
	    AGUA,
	    PLANTA,
	    ELECTRICO,
	    HIELO,
	    LUCHA,
	    VENENO,
	    TIERRA,
	    VOLADOR,
	    PSIQUICO,
	    BICHO,
	    ROCA,
	    FANTASMA,
	    DRAGON;
	}

}

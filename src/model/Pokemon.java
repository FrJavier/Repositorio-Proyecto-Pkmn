package model;

import java.util.LinkedList;

import model.tipo;

public class Pokemon {

	private int id_pokemon;
	private int id_entrenador;
	private int num_pokedex;
	private String note; // esto deberia ser mote en vez de note, pero esta puesto tal cual en la base de
							// datos
	private int vitalidad;
	private int ataque;
	private int defensa;
	private int atk_especial;
	private int def_especial;
	private int velocidad;
	private int nivel;
	private int fertilidad;
	private char sexo;
	private String estado;
	private int equipo;
	private int id_objeto;
	private String nombre;
	static LinkedList<movimiento> movimientos;

	private String IMG_Frontal;
	private String IMG_Trasera;
	private int NIVEL_EVOLUCION;
	private String SONIDO;
	private static tipo tipo1;
	private static tipo tipo2;
	private Objeto Objeto;
	private int hpActual;
	private int hpTotal;
	private String rutaImagen;

	public static LinkedList<movimiento> getMovimientos() {
		return movimientos;
	}

	public static void setMovimientos(LinkedList<movimiento> movimientos) {
		Pokemon.movimientos = movimientos;
	}

	public String getIMG_Frontal() {
		return IMG_Frontal;
	}

	public void setIMG_Frontal(String iMG_Frontal) {
		IMG_Frontal = iMG_Frontal;
	}

	public String getIMG_Trasera() {
		return IMG_Trasera;
	}

	public void setIMG_Trasera(String iMG_Trasera) {
		IMG_Trasera = iMG_Trasera;
	}

	public int getNIVEL_EVOLUCION() {
		return NIVEL_EVOLUCION;
	}

	public void setNIVEL_EVOLUCION(int nIVEL_EVOLUCION) {
		NIVEL_EVOLUCION = nIVEL_EVOLUCION;
	}

	public String getSONIDO() {
		return SONIDO;
	}

	public void setSONIDO(String sONIDO) {
		SONIDO = sONIDO;
	}

	public static tipo getTipo1() {
		return tipo1;
	}

	public static void setTipo1(tipo tipo1) {
		Pokemon.tipo1 = tipo1;
	}

	public static tipo getTipo2() {
		return tipo2;
	}

	public static void setTipo2(tipo tipo2) {
		Pokemon.tipo2 = tipo2;
	}

	public Objeto getObjeto() {
		return Objeto;
	}

	public void setObjeto(Objeto Objeto) {
		this.Objeto = Objeto;
	}

	public int getId_pokemon() {
		return id_pokemon;
	}

	public void setId_pokemon(int id_pokemon) {
		this.id_pokemon = id_pokemon;
	}

	public int getId_entrenador() {
		return id_entrenador;
	}

	public void setId_entrenador(int id_entrenador) {
		this.id_entrenador = id_entrenador;
	}

	public int getNum_pokedex() {
		return num_pokedex;
	}

	public void setNum_pokedex(int num_pokedex) {
		this.num_pokedex = num_pokedex;
	}

	public String getNote() {
		return note;
	}

	public void setNote(String note) {
		this.note = note;
	}

	public int getVitalidad() {
		return vitalidad;
	}

	public void setVitalidad(int vitalidad) {
		this.vitalidad = vitalidad;
	}

	public int getAtaque() {
		return ataque;
	}

	public void setAtaque(int ataque) {
		this.ataque = ataque;
	}

	public int getDefensa() {
		return defensa;
	}

	public void setDefensa(int defensa) {
		this.defensa = defensa;
	}

	public int getAtk_especial() {
		return atk_especial;
	}

	public void setAtk_especial(int atk_especial) {
		this.atk_especial = atk_especial;
	}

	public int getDef_especial() {
		return def_especial;
	}

	public void setDef_especial(int def_especial) {
		this.def_especial = def_especial;
	}

	public int getVelocidad() {
		return velocidad;
	}

	public void setVelocidad(int velocidad) {
		this.velocidad = velocidad;
	}

	public int getNivel() {
		return nivel;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

	public int getFertilidad() {
		return fertilidad;
	}

	public void setFertilidad(int fertilidad) {
		this.fertilidad = fertilidad;
	}

	public char getSexo() {
		return sexo;
	}

	public void setSexo(char sexo) {
		this.sexo = sexo;
	}

	public String getEstado() {
		return estado;
	}

	public void setEstado(String estado) {
		this.estado = estado;
	}

	public int getEquipo() {
		return equipo;
	}

	public void setEquipo(int equipo) {
		this.equipo = equipo;
	}

	public int getId_objeto() {
		return id_objeto;
	}

	public void setId_objeto(int id_objeto) {
		this.id_objeto = id_objeto;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getRutaImagen() {
		return IMG_Frontal != null ? IMG_Frontal : "/img/default.png"; //ruta por defecto si es null
	}

	public int getHpActual() {
		return vitalidad;
	}

	public int getHpTotal() {
		return 100; //utilizamos 100 como valor maximo de la vida del pokemon
	}

	public void setRutaImagen(String rutaImagen) {
		this.rutaImagen = rutaImagen;
	}

	public void setHpActual(int hpActual) {
		this.hpActual = hpActual;
	}

	public void setHpTotal(int hpTotal) {
		this.hpTotal = hpTotal;
	}

	public Pokemon(int id_pokemon, int id_entrenador, int num_pokedex, String note, int vitalidad, int ataque,
			int defensa, int atk_especial, int def_especial, int velocidad, int nivel, int fertilidad, char sexo,
			String estado, int equipo, int id_objeto, String nombre, String iMG_Frontal, String iMG_Trasera,
			int nIVEL_EVOLUCION, String sONIDO, model.Objeto Objeto) {
		super();
		this.id_pokemon = id_pokemon;
		this.id_entrenador = id_entrenador;
		this.num_pokedex = num_pokedex;
		this.note = note;
		this.vitalidad = vitalidad;
		this.ataque = ataque;
		this.defensa = defensa;
		this.atk_especial = atk_especial;
		this.def_especial = def_especial;
		this.velocidad = velocidad;
		this.nivel = nivel;
		this.fertilidad = fertilidad;
		this.sexo = sexo;
		this.estado = estado;
		this.equipo = equipo;
		this.id_objeto = id_objeto;
		this.nombre = nombre;
		IMG_Frontal = iMG_Frontal;
		IMG_Trasera = iMG_Trasera;
		NIVEL_EVOLUCION = nIVEL_EVOLUCION;
		SONIDO = sONIDO;
		this.Objeto = Objeto;
	}

	public Pokemon(int num_pokedex, String nombre, tipo tipo1, tipo tipo2, int NIVEL_EVOLUCION, String IMG_Frontal,
			String IMG_Trasera) {

		this.num_pokedex = num_pokedex;
		this.nombre = nombre;
		this.tipo1 = tipo1;
		this.tipo2 = tipo2;
		this.NIVEL_EVOLUCION = NIVEL_EVOLUCION;
		this.IMG_Frontal = IMG_Frontal;
		this.IMG_Trasera = IMG_Trasera;
	}

	public Pokemon() {
		// TODO Auto-generated constructor stub
	}

}

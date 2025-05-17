package model;

public class Turno {
	
	//la innombrable E-Word para hacer el menu de acciones del combate
	public enum Accion {
        ATAQUE,
        OBJETO,
        CAMBIO,
        HUIR
    }

	private Accion accion;
    private movimiento movimiento; //el movimiento que se usa, si hay
    private Objeto objeto;          //el objeto que se usa, si hay
    private int nuevoPokemonIndex;  //indice para cambio de Pokémon

    public Turno(Accion accion) {
        this.accion = accion;
    }

    public Accion getAccion() {
        return accion;
    }

    public void setAccion(Accion accion) {
        this.accion = accion;
    }

    public movimiento getMovimiento() {
        return movimiento;
    }

    public void setMovimiento(movimiento movimiento) {
        this.movimiento = movimiento;
    }

    public Objeto getObjeto() {
        return objeto;
    }

    public void setObjeto(Objeto objeto) {
        this.objeto = objeto;
    }

    public int getNuevoPokemonIndex() {
        return nuevoPokemonIndex;
    }

    public void setNuevoPokemonIndex(int nuevoPokemonIndex) {
        this.nuevoPokemonIndex = nuevoPokemonIndex;
    }
    
    //metodos para el switch que hay en combate a la hora de elegir que hara el jugador en cada turno
    
    public static Turno crearTurnoAtaque(movimiento mov) {
        Turno t = new Turno(Accion.ATAQUE);
        t.setMovimiento(mov);
        return t;
    }

    public static Turno crearTurnoObjeto(Objeto obj) {
        Turno t = new Turno(Accion.OBJETO);
        t.setObjeto(obj);
        return t;
    }

    public static Turno crearTurnoCambio(int index) {
        Turno t = new Turno(Accion.CAMBIO);
        t.setNuevoPokemonIndex(index);
        return t;
    }

    public static Turno crearTurnoHuida() {
        return new Turno(Accion.HUIR);
    }
     
}

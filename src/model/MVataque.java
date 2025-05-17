package model;

public class MVataque extends movimiento {
	
	 	private int poder;
	    private tipo tipo;
	    private int pp;

	    public void MovimientoFisico(String nombre, int poder, int pp, tipo tipo) {
	        this.setNom_movimiento(nombre);
	        this.poder = poder;
	        this.pp = pp;
	        this.tipo = tipo;
	    }

	    public int getPoder() {
	        return poder;
	    }

	    public tipo getTipo() {
	        return tipo;
	    }

	    public int getPp() {
	        return pp;
	    }

	    public void setPp(int pp) {
	        this.pp = pp;
	    }

	    @Override
	    public void ejecutar(Pokemon atacante, Pokemon objetivo) {
	        //puedes llamar desde ahí
	       
	    }

	    public boolean isFisico() {
	        return true;
	    }
	
}

package model;

public class MVataque extends movimiento {
	
	 private int potencia;
	    private tipo tipo;

	    @Override
	    public void ejecutar(pokemon atacante, pokemon objetivo) {

	    }

	    @Override
	    public boolean calcularProbabilidad() {
	        return false;
	    }



	    public void setPotencia (int potencia) {
	        this.potencia = potencia;
	    }

	    public int getPotencia () {
	        return potencia;
	    }


	    public void setTipo (tipo tipo) {
	        this.tipo = tipo;
	    }


	    public  tipo getTipo() {
	        return tipo;
	    }


	    

	
	
}

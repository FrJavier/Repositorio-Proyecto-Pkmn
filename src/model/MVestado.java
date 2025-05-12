package model;

public class MVestado extends movimiento{
	


		private int duracion;
		private Estado estado;

		

		public void setduracion(int duracion) {

			this.duracion = duracion;
		}

		public int getduracion() {

			return duracion;
		}

		public void setEstado(Estado estado) {

			this.estado = estado;
		}

		public Estado getEstado() {

			return estado;
		}

		public void aplicarEstado(movimiento nombre) {
			
		}

		public void quitaEstado(movimiento nombre) {
			estado = null;
		}

		@Override
		public void ejecutar(pokemon atacante, pokemon objetivo) {
			// TODO Auto-generated method stub
			
		}

	}


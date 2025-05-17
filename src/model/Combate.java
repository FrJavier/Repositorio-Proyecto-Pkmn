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

	private Pokemon pokemonJugador;
	private Pokemon pokemonRival;

	private Random random = new Random();

	public Combate(Entrenador jugador, Entrenador rival) {
		this.jugador = jugador;
		this.rival = rival;
		this.contTurnos = new LinkedList<>();

		// selecciona el primer Pokémon de cada equipo como activo
		if (jugador.getEquipo() != null && !jugador.getEquipo().isEmpty()) {
			this.pokemonJugador = jugador.getEquipo().get(0);
		}
		if (rival.getEquipo() != null && !rival.getEquipo().isEmpty()) {
			this.pokemonRival = rival.getEquipo().get(0);
		}
	}

	// metodo para ejecutar ataque
	public String ejecutarAtaque(Pokemon atacante, Pokemon defensor, movimiento movimiento) {
		if (movimiento.getPp() <= 0) {
			return atacante.getNombre() + " no tiene PP para usar " + movimiento.getNombre();
		}

		int danio = calcularDanio(atacante, defensor, movimiento);

		int nuevaVitalidad = defensor.getVitalidad() - danio;
		defensor.setVitalidad(Math.max(nuevaVitalidad, 0)); // No baja de 0

		movimiento.setPp(movimiento.getPp() - 1);

		String resultado = atacante.getNombre() + " usó " + movimiento.getNombre() + " y causó " + danio + " de daño.";

		if (defensor.getVitalidad() == 0) {
			resultado += " " + defensor.getNombre() + " se debilitó.";
			if (defensor == pokemonRival)
				pkDerrotadosUser++;
			else if (defensor == pokemonJugador)
				pkDerrotadosRival++;
		}

		return resultado;
	}

	// formula "simple" de daño
	public int calcularDanio(Pokemon atacante, Pokemon defensor, movimiento movimiento) {
		int nivel = atacante.getNivel();
		int poder = movimiento.getPoder(); // potencia del movimiento

		double ataqueStat;
		double defensaStat;

		if (movimiento.isFisico()) {
			ataqueStat = atacante.getAtaque();
			defensaStat = defensor.getDefensa();
		} else {
			ataqueStat = atacante.getAtk_especial();
			defensaStat = defensor.getDef_especial();
		}

		double base = (((2 * nivel / 5.0) + 2) * poder * (ataqueStat / defensaStat)) / 50.0 + 2;

		double efectividad = calcularEfectividad(movimiento.getTipo(), defensor.getTipo1(), defensor.getTipo2());

		double randomMod = 0.85 + random.nextDouble() * 0.15;

		double danioFinal = base * efectividad * randomMod;

		return (int) danioFinal;
	}

	// calcular efectividad segun tipos
	public double calcularEfectividad(tipo tipoMovimiento, tipo tipoDef1, tipo tipoDef2) {
		double mult1 = tipoMovimiento.calcularMultiplicadorContra(tipoDef1);
		double mult2 = 1.0;
		if (tipoDef2 != null) {
			mult2 = tipoMovimiento.calcularMultiplicadorContra(tipoDef2);
		}
		return mult1 * mult2;
	}

	// usar objeto en Pokémon
	public String usarObjeto(Pokemon objetivo, Objeto objeto) {
		StringBuilder resultado = new StringBuilder(objetivo.getNombre()); // aqui he utilizado un stringbuilder, es
																			// para poder modificar contenido despues de
																			// la creacion de la variable en si con
																			// .append

		boolean efectoAplicado = false;

		if (objeto.getAtaque() > 0) {
			objetivo.setAtaque((int) (objetivo.getAtaque() + objeto.getAtaque()));
			resultado.append(" aumentó su Ataque.");
			efectoAplicado = true;
		}
		if (objeto.getDefensa() > 0) {
			objetivo.setDefensa((int) (objetivo.getDefensa() + objeto.getDefensa()));
			resultado.append(" aumentó su Defensa.");
			efectoAplicado = true;
		}
		if (objeto.getAt_especial() > 0) {
			objetivo.setAtk_especial((int) (objetivo.getAtk_especial() + objeto.getAt_especial()));
			resultado.append(" aumentó su Ataque Especial.");
			efectoAplicado = true;
		}
		if (objeto.getDef_especial() > 0) {
			objetivo.setDef_especial((int) (objetivo.getDef_especial() + objeto.getDef_especial()));
			resultado.append(" aumentó su Defensa Especial.");
			efectoAplicado = true;
		}
		if (objeto.getVelocidad() > 0) {
			objetivo.setVelocidad((int) (objetivo.getVelocidad() + objeto.getVelocidad()));
			resultado.append(" aumentó su Velocidad.");
			efectoAplicado = true;
		}

		// curar vitalidad suponiendo que precio guarda valor de curacion
		if (objeto.getPrecio() > 0) {
			int vidaAnterior = objetivo.getVitalidad();
			int vidaMaxima = 100; // Aquí define o pasa el máximo real
			int nuevaVitalidad = Math.min(vidaAnterior + (int) objeto.getPrecio(), vidaMaxima);
			objetivo.setVitalidad(nuevaVitalidad);
			resultado.append(" recuperó vitalidad.");
			efectoAplicado = true;
		}

		if (!efectoAplicado) {
			resultado.append(" no tuvo efecto.");
		}

		return resultado.toString();
	}

	// Cambiar Pokémon activo del jugador
	public String cambiarPokemonJugador(int indice) {
		if (indice < 0 || indice >= jugador.getEquipo().size()) {
			return "Índice de Pokémon inválido.";
		}

		Pokemon nuevo = jugador.getEquipo().get(indice);

		if (nuevo.getVitalidad() <= 0) {
			return nuevo.getNombre() + " está debilitado y no puede entrar.";
		}

		this.pokemonJugador = nuevo;
		return "Cambiamos a " + nuevo.getNombre() + ".";
	}

	// Getters básicos
	public Pokemon getPokemonJugador() {
		return pokemonJugador;
	}

	public Pokemon getPokemonRival() {
		return pokemonRival;
	}

	public int getPkderrotadosrival() {
		return pkDerrotadosRival;
	}

	public int getPkderrotadosuser() {
		return pkDerrotadosUser;
	}

	public String ejecutarAccion(Turno turno, Pokemon atacante, Pokemon defensor) {

		// verificar antes de ejecutar accion si el pokemon esta debilitado
		if (atacante.getVitalidad() <= 0) {
			return atacante.getNombre() + " está debilitado y no puede realizar acciones.";
		}

		switch (turno.getAccion()) {
		case ATAQUE:
			movimiento mov = turno.getMovimiento();
			if (mov == null) {
				return atacante.getNombre() + " no seleccionó un movimiento válido.";
			}
			if (mov instanceof movimiento) {
				if (mov.getTurnos() <= 0) {
					return atacante.getNombre() + " no tiene PP para usar " + mov.getNom_movimiento();
				}
				// ejecutar el movimiento (altera/cambia la vida/estado al defensor)
				mov.ejecutar(atacante, defensor);
				mov.setTurnos(mov.getTurnos() - 1); // reducimos PP o turnos disponibles para usar el ataque en cuestion
				String resultado = atacante.getNombre() + " usó " + mov.getNom_movimiento() + ".";
				if (defensor.getVitalidad() <= 0) {
					resultado += " " + defensor.getNombre() + " se debilitó.";
					if (defensor == pokemonRival)
						pkDerrotadosUser++;
					else if (defensor == pokemonJugador)
						pkDerrotadosRival++;
				}
				return resultado;
			} else {
				return "Movimiento no válido.";
			}

		case OBJETO:
			Objeto obj = turno.getObjeto();
			if (obj == null) {
				return atacante.getNombre() + " no seleccionó un objeto válido.";
			}
			return usarObjeto(atacante, obj);

		case CAMBIO:
			int nuevoIndex = turno.getNuevoPokemonIndex();
			return cambiarPokemonJugador(nuevoIndex);

		case HUIR:
			boolean huirExito = Math.random() < 0.5; // 50% de chance
			if (huirExito) {
				return atacante.getNombre() + " huyó exitosamente del combate.";
			} else {
				return atacante.getNombre() + " intentó huir pero falló.";
			}

		default:
			return "Acción desconocida.";
		}
	}
	// faltan por poner los gets que ponen que falta en la clase movimiento y el
	// metodo calcularMultiplicadorContra en la clase tipo para las debilidades
}

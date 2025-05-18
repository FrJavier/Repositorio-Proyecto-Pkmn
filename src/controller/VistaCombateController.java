package controller;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.Random;

import javax.swing.JOptionPane;

import database.MovimientosDatabase;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;
import model.Entrenador;
import model.MVataque;
import model.Objeto;
import model.Pokemon;
import model.Turno;
import model.movimiento;
import model.tipo;

public class VistaCombateController {


    @FXML
    private Pane barracombate;

    @FXML
    private Pane barracombate1;

    @FXML
    private Button btnEmpezar;

    @FXML
    private Button btnatacar;

    @FXML
    private Button btnhuir;

    @FXML
    private Button btnmv1;

    @FXML
    private Button btnmv2;

    @FXML
    private Button btnmv3;

    @FXML
    private Button btnmv4;

    @FXML
    private Button btnobjeto;

    @FXML
    private Button btnswap;

    @FXML
    private ImageView imgcontenedoracombate;

    @FXML
    private ImageView imgcontenedoracombate1;

    @FXML
    private ImageView imgfondocombate;

    @FXML
    private ImageView imginfpkcombate;

    @FXML
    private ImageView imginfpkcombateenemigo;

    @FXML
    private ImageView imgpkmnrival;

    @FXML
    private ImageView imgpkmuser;

    @FXML
    private Pane panepkm;

    @FXML
    private Pane panerival;

    @FXML
    private ProgressBar progressbarcombate;

    @FXML
    private ProgressBar progressbarenemigo;

    @FXML
    private Label txtdtlpkenemigo;

    @FXML
    private Label txtnombrepk;

    @FXML
    private Label txtnombrepkenemigo;

    @FXML
    private Label txtnvlpkm;

	Entrenador entrenador;
	Pokemon pokemon;
	Turno turno;
	Pokemon atacante;
	Pokemon defensor;
	private Pokemon pokemonJugador;
	private Pokemon pokemonEntrenador;
	private Pokemon pokemonRival;
	int pkDerrotadosUser;
	int pkDerrotadosRival;
	private Random random = new Random();
	MVataque m = new MVataque();
	private Stage stage ;
	movimiento mov;
	private Connection conn;
	
	
	public void init(Stage stage, Entrenador entrenador, Turno turno) {
	    this.stage = stage;
	    this.entrenador = entrenador;
	    this.turno = turno;
	    
	    if (pokemonJugador == null) {
	        System.out.println("pokemonJugador es null");
	    } else {
	        System.out.println("pokemonJugador id: " + pokemonJugador.getId_pokemon());
	    }

	    if (turno != null) {
	        this.mov = turno.getMovimiento();
	    } else {
	        this.mov = null;
	        System.out.println("Atención: turno es null en init de VistaCombateController");
	    }
	}
	
	public String ejecutarAtaque(Pokemon atacante, Pokemon defensor, movimiento movimiento) {
		if (movimiento.getPp() <= 0) {
			return atacante.getNombre() + " no tiene PP para usar " + movimiento.getNom_movimiento();
		}

		int danio = calcularDanio(atacante, defensor, m);

		int nuevaVitalidad = defensor.getVitalidad() - danio;
		defensor.setVitalidad(Math.max(nuevaVitalidad, 0)); // No baja de 0

		movimiento.setPp(movimiento.getPp() - 1);

		String resultado = atacante.getNombre() + " usó " + movimiento.getNom_movimiento() + " y causó " + danio
				+ " de daño.";

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
	public int calcularDanio(Pokemon atacante, Pokemon defensor,MVataque movimiento) {
		int nivel = atacante.getNivel();
		int poder = movimiento.getPoder();

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

		double randomMod = 0.85 + random.nextDouble() * 0.15;

		double danioFinal = base * randomMod;

		return (int) danioFinal;
	}
	
	@FXML
	public void initialize() {
		
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

		if (indice < 0 || indice >= entrenador.getEquipo().size()) {
			return "Índice de Pokémon inválido.";
		}

		Pokemon nuevo = entrenador.getEquipo().get(indice);

		if (nuevo.getVitalidad() <= 0) {
			return nuevo.getNombre() + " está debilitado y no puede entrar.";
		}

		this.pokemonJugador = nuevo;
		return "Cambiamos a " + nuevo.getNombre() + ".";
	}

	public String ejecutarAccion(Turno turno, Pokemon atacante, Pokemon defensor) {

		// verificar antes de ejecutar accion si el pokemon esta debilitado
		if (atacante.getVitalidad() <= 0) {
			return atacante.getNombre() + " está debilitado y no puede realizar acciones.";
		}
		return "hecho";
	}

	public String ataque(ActionEvent event) {
		btnmv1.setOnAction(e -> {
		    mov = pokemonJugador.getMovimientos().get(0);
		    ataque(e);
		    
		}
		
				);
		
		if (mov == null) {
			JOptionPane.showMessageDialog(null, "No existe movimiento");
			return "Movimiento no disponible.";
		}

		if (mov instanceof movimiento) {
			if (mov.getTurnos() <= 0) {
				JOptionPane.showMessageDialog(null, "No le quedan PPs al movimiento");
				return "Sin PPs";
			}

			// Ejecutar el movimiento
			mov.ejecutar(atacante, defensor);
			mov.setTurnos(mov.getTurnos() - 1);

			String resultado = atacante.getNombre() + " usó " + mov.getNom_movimiento() + ".";

			if (defensor.getVitalidad() <= 0) {
				resultado += " " + defensor.getNombre() + " se debilitó.";
				if (defensor == pokemonRival)
					pkDerrotadosUser++;
				else if (defensor == pokemonJugador)
					pkDerrotadosRival++;
			}

			return resultado;
		}

		JOptionPane.showMessageDialog(null, "Movimiento no válido");
		return "Movimiento inválido.";
	}


	

	public void huir(ActionEvent event) {
		 try {
	            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Menu.fxml"));
	            Parent root = loader.load();

	            // Obtener el controlador del menú cargado
	            Menu menuController = loader.getController();

	            // Inicializar el controlador con el entrenador y el stage actuales
	            menuController.init(entrenador, stage, null); 

	            // Cambiar la escena al menú
	            Scene scene = new Scene(root);
	            stage.setScene(scene);
	            stage.show();
	        } catch (Exception e) {
	            e.printStackTrace();
	        }
		
			
	}

	@FXML
	private void generarPokemon() {
		Random azar = new Random();
		int pokemonid = azar.nextInt(151) + 1;

		String sql = "SELECT pkdx.IMG_Frontal, p.nombre, p.vitalidad, p.ataque, p.defensa, p.atk_especial, p.def_especial, p.velocidad, "
		           + "p.nivel FROM pokedex pkdx INNER JOIN pokemon p ON pkdx.num_pokedex = p.num_pokedex WHERE pkdx.num_pokedex = " + pokemonid;

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemones", "root", "");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			if (rs.next()) {
				
				Pokemon rival=new Pokemon();
				String imgFrontal = rs.getString("IMG_Frontal");
				String nombre = rs.getString("nombre");
				
				File archivo = new File(imgFrontal);
				Image image = new Image(archivo.toURI().toString());
				
				rival.setNombre(nombre);
	            rival.setVitalidad(rs.getInt("vitalidad"));
	            rival.setAtaque(rs.getInt("ataque"));
	            rival.setDefensa(rs.getInt("defensa"));
	            rival.setNivel(rs.getInt("nivel"));
	            

				imgpkmnrival.setVisible(true);

				txtnombrepkenemigo.setVisible(true);
				imgpkmnrival.setImage(image);
				txtnombrepkenemigo.setText(nombre);
				txtdtlpkenemigo.setText("NIVEL :"+String.valueOf(rival.getNivel()));


			} else {
				System.out.println("No se encontró un Pokémon con ID: " + pokemonid);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	}
	
	
	
	private Pokemon sacarpokemon() {
		Pokemon primerPokemon = null;

		String sql = "SELECT p.id_pokemon, p.nombre, p.nivel, p.vitalidad, p.id_entrenador, p.velocidad, "
	               + "p.atk_especial, pk.iMG_Trasera, p.ataque, p.defensa, p.def_especial, p.Estado "
	               + "FROM pokemon p "
	               + "JOIN pokedex pk ON p.num_pokedex = pk.num_pokedex "
	               + "WHERE p.id_entrenador = ? "
	               + "ORDER BY p.id_pokemon ASC "
	               + "LIMIT 1";

	    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemones", "root", ""); 
	         PreparedStatement stmt = conn.prepareStatement(sql)) {

	        stmt.setInt(1, entrenador.getId_entrenador());
	        ResultSet rs = stmt.executeQuery();

	        if (rs.next()) {
	            primerPokemon = new Pokemon(
	                rs.getInt("id_pokemon"),
	                rs.getString("nombre"),
	                rs.getInt("nivel"),
	                rs.getInt("vitalidad"),
	                rs.getInt("id_entrenador"),
	                rs.getInt("velocidad"),
	                rs.getInt("atk_especial"),
	                rs.getString("iMG_Trasera"),
	                rs.getInt("ataque"),
	                rs.getInt("defensa"),
	                rs.getInt("def_especial"),
	                rs.getString("Estado")
	                
	         );
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }

	    return primerPokemon;
	}
	
	@FXML
	private void Comenzarcombate(ActionEvent event) {
		
		try {
	        if (conn == null || conn.isClosed()) {
	            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemones", "root", "");
	        }

		panepkm.setVisible(true);
		panerival.setVisible(true);
		imgpkmuser.setVisible(true);
		barracombate.setVisible(true);
		btnEmpezar.setVisible(false);

		generarPokemon(); // genera rival
		pokemonJugador = sacarpokemon(); // selecciona Pokémon del jugador

		if (pokemonJugador != null) {
			int idPokemon = pokemonJugador.getId_pokemon(); 

			try {
				LinkedList<movimiento> movimientos = MovimientosDatabase.cargarMovimientos(conn, pokemonJugador.getId_pokemon());
				System.out.println("Movimientos cargados: " + movimientos.size());
			} catch (SQLException e) {
				JOptionPane.showMessageDialog(null, "Error al cargar movimientos del Pokémon");
				e.printStackTrace();
				return;
			}

			txtnombrepk.setText(pokemonJugador.getNombre());
			txtnvlpkm.setText("Nivel: " + pokemonJugador.getNivel());

			File archivo = new File(pokemonJugador.getIMG_Trasera());
			Image image = new Image(archivo.toURI().toString());
			imgpkmuser.setImage(image);

		} else {
			JOptionPane.showMessageDialog(null, "ERROR: No se ha cargado el Pokémon.");
		} } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
	
    @FXML
    private void abrirMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Menu.fxml"));
            Parent root = loader.load();

            // Obtener el controlador del menú cargado
            Menu menuController = loader.getController();

            // Inicializar el controlador con el entrenador y el stage actuales
            menuController.init(entrenador, stage, null); 

            // Cambiar la escena al menú
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

	

	public int getPkDerrotadosUser() {
		return pkDerrotadosUser;
	}

	public void setPkDerrotadosUser(int pkDerrotadosUser) {
		this.pkDerrotadosUser = pkDerrotadosUser;
	}
	public void setPokemon(Pokemon pokemon) {
	    this.pokemon = pokemon;
	    System.out.println("Pokemon recibido en VistaCombateController: " + pokemon.getNombre());
	}

	public int getPkDerrotadosRival() {
		return pkDerrotadosRival;
	}

	public void setPkDerrotadosRival(int pkDerrotadosRival) {
		this.pkDerrotadosRival = pkDerrotadosRival;
	}
	public void setConnection(Connection conn) {
	    this.conn = conn;
	}

	public void init(Stage currentStage, Entrenador entrenador2, Menu menu) {
		// TODO Auto-generated method stub
		
	}
	
	public void setPokemonJugador(Pokemon pokemon) {
	    this.pokemonJugador = pokemon;
	}

	public void init() {
		// TODO Auto-generated method stub
		
	}

	public void setEntrenador(Entrenador entrenador2) {
		// TODO Auto-generated method stub
		
	}
	public void setPokemonEntrenador(Pokemon pokemon) {
	    this.pokemonEntrenador = pokemon;
	}
	
	
	

}

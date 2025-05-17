package controller;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;

import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Entrenador;
import model.Mochila;
import model.Objeto;
import model.Pokemon;
import database.DatabaseConnection;
import database.EntrenadorDatabase;
import database.MochilaDatabase;

public class PokemonCapturaController {

	@FXML
	private Button btnGenerar;

	@FXML
	private ImageView imgCapturaPokemon;

	@FXML
	private ImageView imgCaturar;

	@FXML
	private ImageView imgPokemonCaptura;

	@FXML
	private ImageView imgPotaxioAtras;

	@FXML
	private ImageView imgSalir;

	@FXML
	private Label lblNumeroPokebolas;

	@FXML
	private Label lbltxtpkmncptura;

	// Init--------------------------------------------------------------------------
	// variables necesarias para iniciar el init
	private Menu menu;
	private Entrenador entrenador;
	private Stage stage;
	Random azar = new Random();
	int pokemonid=0;

	// metodo
	public void init(Stage stage, Entrenador entrenador, Menu menu) {
		this.stage = stage;
		this.entrenador = entrenador; // guarda el entrenador
		this.menu = menu;// guarda el controlador del menu
		cargarPokeballs();

	}
	// ------------------------SS------------------------------------------------------

	// Volver al
	// menu----------------------------------------------------------------
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

	// ------------------------------------------------------------------------------

	@FXML
	void capturar() {

	}

	private Pokemon pokemon;
	private int pokeballs = 0;
	private final int ID_POKEBOLA = 8;

	private void cargarPokeballs() {
		try (Connection conexion = DatabaseConnection.getConnection()) {
			ArrayList<Mochila> mochila = MochilaDatabase.cargarObjetos(entrenador.getId_entrenador());
			for (Mochila objeto : mochila) {
				if (objeto.getIdObjeto() == 8) {
					pokeballs = objeto.getCantidad();

					break;
				}
			}
			actualizarLblPokeballs();

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void actualizarLblPokeballs() {
		lblNumeroPokebolas.setText(String.valueOf(pokeballs));
		lblNumeroPokebolas.setStyle("-fx-font-size: 32px; -fx-text-fill: #ff0000;");
	}

	private void actualizarPokeballsBD() {
		try (Connection conexion = DatabaseConnection.getConnection()) {
			MochilaDatabase.actualizarCantidad(entrenador.getId_entrenador(), ID_POKEBOLA, pokeballs);

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// Generar pokemon
	@FXML
	public void generarPokemon(ActionEvent event) {
		Random azar = new Random();
		int pokemonid = azar.nextInt(151) + 1;

		String sql =  "SELECT p.id_pokemon, p.id_entrenador, p.num_pokedex, pd.nombre, pd.IMG_Frontal, " +
	             "p.nivel, p.note, p.vitalidad, p.ataque, p.defensa, p.atk_especial, p.def_especial, p.velocidad " +
	             "FROM pokemon p " +
	             "JOIN pokedex pd ON p.num_pokedex = pd.num_pokedex " +
	             "WHERE p.id_pokemon = "+pokemonid;{

		try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemones", "root", "");
				Statement stmt = conn.createStatement();
				ResultSet rs = stmt.executeQuery(sql)) {

			if (rs.next()) {
				String imgFrontal = rs.getString("IMG_Frontal");
				String nombre = rs.getString("nombre");
				int vitalidad = rs.getInt("vitalidad");
	            int ataque = rs.getInt("ataque");
	            int defensa = rs.getInt("defensa");
	            int atk_especial = rs.getInt("atk_especial");
	            int def_especial = rs.getInt("def_especial");
	            int velocidad = rs.getInt("velocidad");
				
				File archivo = new File(imgFrontal);
				Image image = new Image(archivo.toURI().toString());
				pokemon = new Pokemon();
				pokemon.setNombre(nombre);
				pokemon.setNum_pokedex(pokemonid);
		        pokemon.setVitalidad(vitalidad);
		        pokemon.setAtaque(ataque);
		        pokemon.setDefensa(defensa);
		        pokemon.setAtk_especial(atk_especial);
		        pokemon.setDef_especial(def_especial);
		        pokemon.setVelocidad(velocidad);


				imgPokemonCaptura.setVisible(true);

				lbltxtpkmncptura.setVisible(true);
				imgPokemonCaptura.setImage(image);
				lbltxtpkmncptura.setText(nombre);

			} else {
				System.out.println("No se encontró un Pokémon con ID: " + pokemonid);
			}

		} catch (SQLException e) {
			e.printStackTrace();
		}
	             }
	}

	public void capturarPkmn(MouseEvent event) {

		int nuevoIdPokemon = 0;
		
	    if (pokeballs > 0 && pokemon != null) {
	        pokeballs--;
	        actualizarLblPokeballs();
	        actualizarPokeballsBD();

	        Random azar = new Random();
	        int suerte = azar.nextInt(10) + 1;

	        if (suerte <= 5) {
	            JOptionPane.showMessageDialog(null, "SE TE HA ESCAPAO XD");
	            generarPokemon(null);
	        } else {
	            String mote = null;  // Declarar fuera para usar en la inserción

	            int opcion = JOptionPane.showConfirmDialog(null, "POKEMON " + pokemon.getNombre() + " CAPTURAO ¿QUIERES PONERLE UN MOTE?");

	            if (opcion == JOptionPane.YES_OPTION) {
	                mote = JOptionPane.showInputDialog(null, "¿QUE MOTE LE QUIERES PONER?");
	                pokemon.setNote(mote);
	            }

	            try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemones", "root", "");
	            	     PreparedStatement ps = conn.prepareStatement(
	            	         "INSERT INTO pokemon (id_entrenador, num_pokedex, nivel, note, vitalidad, ataque, defensa, atk_especial, def_especial, velocidad,nombre) " +
	            	         "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?,?)")) {

	            	    ps.setInt(1, entrenador.getId_entrenador());
	            	    ps.setInt(2, pokemon.getNum_pokedex());
	            	    ps.setInt(3, 1); 
	            	    ps.setString(4, mote);
	            	    ps.setInt(5, pokemon.getVitalidad());
	            	    ps.setInt(6, pokemon.getAtaque());
	            	    ps.setInt(7, pokemon.getDefensa());
	            	    ps.setInt(8, pokemon.getAtk_especial());
	            	    ps.setInt(9, pokemon.getDef_especial());
	            	    ps.setInt(10, pokemon.getVelocidad());
	            	    ps.setString(11, pokemon.getNombre());

	            	    ps.executeUpdate();

	                
	                entrenador.agregarPokemonAlEquipo(pokemon);

	                JOptionPane.showMessageDialog(null, "Pokémon capturado y añadido a tu equipo!");

	                generarPokemon(null);

	            } catch (SQLException e) {
	                e.printStackTrace();
	                JOptionPane.showMessageDialog(null, "Error al guardar el Pokémon en la base de datos.");
	            }
	        }

	    } else {
	        JOptionPane.showMessageDialog(null, "NO TIENES POKEBALLS COMPRA ANDA");
	    }
	}


	public void setEntrenador(Entrenador entrenador) {
		this.entrenador = entrenador;
	}

}

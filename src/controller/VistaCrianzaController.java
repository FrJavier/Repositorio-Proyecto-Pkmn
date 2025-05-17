package controller;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import javax.swing.JOptionPane;

import database.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceDialog;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Entrenador;
import model.Pokemon;

public class VistaCrianzaController {

	

    @FXML
    private ImageView imgPokemon1;

    @FXML
    private ImageView imgPokemon2;

    @FXML
    private ImageView imgPotaxio;

	private Pokemon pokemonPadre;

	private Pokemon pokemonMadre;

	public void amor() {
	    if (pokemonPadre == null || pokemonMadre == null) {
	        JOptionPane.showMessageDialog(null, "Debes seleccionar dos Pokémon para cruzar.");
	        return;
	    }

	    // Por simplicidad, el hijo tendrá el num_pokedex del padre (o podrías implementar herencia)
	    int numPokedexHijo = pokemonPadre.getNum_pokedex();

	    // Creamos un objeto Pokémon hijo copiando stats del padre (por ejemplo)
	    Pokemon hijo = new Pokemon();
	    hijo.setNum_pokedex(numPokedexHijo);
	    hijo.setNivel(1);
	    hijo.setNote(null); // Sin mote al principio

	    // Aquí puedes decidir cómo calcular las stats del hijo, por ejemplo promedio o random:
	    hijo.setVitalidad((pokemonPadre.getVitalidad() + pokemonMadre.getVitalidad()) / 2);
	    hijo.setAtaque((pokemonPadre.getAtaque() + pokemonMadre.getAtaque()) / 2);
	    hijo.setDefensa((pokemonPadre.getDefensa() + pokemonMadre.getDefensa()) / 2);
	    hijo.setAtk_especial((pokemonPadre.getAtk_especial() + pokemonMadre.getAtk_especial()) / 2);
	    hijo.setDef_especial((pokemonPadre.getDef_especial() + pokemonMadre.getDef_especial()) / 2);
	    hijo.setVelocidad((pokemonPadre.getVelocidad() + pokemonMadre.getVelocidad()) / 2);

	    // Si quieres nombre, puedes heredarlo del padre, madre o asignar uno especial
	    hijo.setNombre(pokemonPadre.getNombre());

	    // Guardar en BD igual que en capturarPkmn
	    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemones", "root", "");
	         PreparedStatement ps = conn.prepareStatement(
	                 "INSERT INTO pokemon (id_entrenador, num_pokedex, nivel, note, vitalidad, ataque, defensa, atk_especial, def_especial, velocidad, nombre) " +
	                 "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)")) {

	        ps.setInt(1, entrenador.getId_entrenador());
	        ps.setInt(2, hijo.getNum_pokedex());
	        ps.setInt(3, hijo.getNivel());
	        ps.setString(4, hijo.getNote());
	        ps.setInt(5, hijo.getVitalidad());
	        ps.setInt(6, hijo.getAtaque());
	        ps.setInt(7, hijo.getDefensa());
	        ps.setInt(8, hijo.getAtk_especial());
	        ps.setInt(9, hijo.getDef_especial());
	        ps.setInt(10, hijo.getVelocidad());
	        ps.setString(11, hijo.getNombre());

	        ps.executeUpdate();

	        entrenador.agregarPokemonAlEquipo(hijo);
	        JOptionPane.showMessageDialog(null, "¡Has creado un nuevo Pokémon bebé!");

	    } catch (SQLException e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error al guardar el Pokémon bebé en la base de datos.");
	    }
	}



	@FXML
	void añadirPokemon1(MouseEvent event) {
	    if (entrenador.getEquipo() == null || entrenador.getEquipo().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "No tienes Pokémon en tu equipo.");
	        return;
	    }

	    List<String> nombresPokemon = entrenador.getEquipo().stream()
	            .map(Pokemon::getNombre)
	            .toList();

	    ChoiceDialog<String> dialog = new ChoiceDialog<>(nombresPokemon.get(0), nombresPokemon);
	    dialog.setTitle("Seleccionar Pokémon");
	    dialog.setHeaderText("Elige un Pokémon del equipo");
	    dialog.setContentText("Pokémon:");

	    dialog.showAndWait().ifPresent(nombreSeleccionado -> {
	        Pokemon seleccionado = entrenador.getEquipo().stream()
	                .filter(p -> p.getNombre().equals(nombreSeleccionado))
	                .findFirst()
	                .orElse(null);

	        if (seleccionado != null) {
	            this.pokemonPadre = seleccionado;

	            try (Connection connection = DatabaseConnection.getConnection()) {
	                String sql = "SELECT Img_Frontal FROM pokedex WHERE num_pokedex = ?";
	                PreparedStatement stmt = connection.prepareStatement(sql);
	                stmt.setInt(1, seleccionado.getNum_pokedex());
	                ResultSet rs = stmt.executeQuery();

	                if (rs.next()) {
	                    String rutaImagen = rs.getString("Img_Frontal");
	                    File archivo = new File(rutaImagen);
	                    Image imagen = new Image(archivo.toURI().toString());
	                    imgPokemon1.setImage(imagen);
	                }
	            } catch (Exception e) {
	                JOptionPane.showMessageDialog(null, "Error al obtener la imagen del Pokémon.");
	                e.printStackTrace();
	            }
	        }
	    });
	}






	@FXML
	void añadirPokemon2(MouseEvent event) {
	    if (entrenador.getEquipo() == null || entrenador.getEquipo().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "No tienes Pokémon en tu equipo.");
	        return;
	    }

	    List<String> nombresPokemon = entrenador.getEquipo().stream()
	            .map(Pokemon::getNombre)
	            .toList();

	    ChoiceDialog<String> dialog = new ChoiceDialog<>(nombresPokemon.get(0), nombresPokemon);
	    dialog.setTitle("Seleccionar Pokémon");
	    dialog.setHeaderText("Elige un Pokémon del equipo");
	    dialog.setContentText("Pokémon:");

	    dialog.showAndWait().ifPresent(nombreSeleccionado -> {
	        Pokemon seleccionado = entrenador.getEquipo().stream()
	                .filter(p -> p.getNombre().equals(nombreSeleccionado))
	                .findFirst()
	                .orElse(null);

	        if (seleccionado != null) {
	            this.pokemonMadre = seleccionado;

	            try (Connection connection = DatabaseConnection.getConnection()) {
	                String sql = "SELECT Img_Frontal FROM pokedex WHERE num_pokedex = ?";
	                PreparedStatement stmt = connection.prepareStatement(sql);
	                stmt.setInt(1, seleccionado.getNum_pokedex());
	                ResultSet rs = stmt.executeQuery();

	                if (rs.next()) {
	                    String rutaImagen = rs.getString("Img_Frontal");
	                    File archivo = new File(rutaImagen);
	                    Image imagen = new Image(archivo.toURI().toString());
	                    imgPokemon2.setImage(imagen);
	                }
	            } catch (Exception e) {
	                JOptionPane.showMessageDialog(null, "Error al obtener la imagen del Pokémon.");
	                e.printStackTrace();
	            }
	        }
	    });
	}



    @FXML
    void queTocas(MouseEvent event) {
		JOptionPane.showMessageDialog(null, "Chacho que tocas?!");
    }
	
    //Init--------------------------------------------------------------------------
    //variables necesarias para iniciar el init
    private Menu menu;
    private Entrenador entrenador;
    private Stage stage;

    //metodo
    public void init(Stage stage, Entrenador entrenador, Menu menu) {
        this.stage = stage;
        this.entrenador = entrenador;  // guarda el entrenador
        this.menu = menu;  // guarda el controlador del menu
    }
    //------------------------------------------------------------------------------
    //Volver al menu----------------------------------------------------------------
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
    //------------------------------------------------------------------------------

}
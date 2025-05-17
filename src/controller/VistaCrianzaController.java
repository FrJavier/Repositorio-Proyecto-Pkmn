package controller;

import java.io.File;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
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

	@FXML
	void amor(MouseEvent event) {
	    if (pokemonPadre == null || pokemonMadre == null) {
	        JOptionPane.showMessageDialog(null, "Debes seleccionar dos Pokémon primero.");
	        return;
	    }

	    if (!pokemonPadre.getNombre().equalsIgnoreCase(pokemonMadre.getNombre())) {
	        JOptionPane.showMessageDialog(null, "Los Pokémon deben ser del mismo tipo para criar.");
	        return;
	    }

	    // Preguntar si quiere ponerle mote
	    String mote = JOptionPane.showInputDialog(null, 
	        "¿Quieres darle un mote al nuevo " + pokemonPadre.getNombre() + "? (Deja vacío para mantener el nombre)");

	    if (mote == null) {
	        // El usuario canceló
	        return;
	    }

	    // Crear el nuevo Pokémon
	    Pokemon bebe = new Pokemon();
	    bebe.setNombre(pokemonPadre.getNombre());
	    bebe.setNote(mote.isEmpty() ? pokemonPadre.getNombre() : mote);
	    bebe.setNivel(1);
	    bebe.setVitalidad(10);
	    bebe.setAtaque(5);
	    bebe.setDefensa(5);
	    bebe.setAtk_especial(5);
	    bebe.setDef_especial(5);
	    bebe.setVelocidad(5);
	    bebe.setSexo(Math.random() < 0.5 ? 'M' : 'H');
	    bebe.setIMG_Frontal(pokemonPadre.getIMG_Frontal());
	    bebe.setIMG_Trasera(pokemonPadre.getIMG_Trasera());
	    bebe.setNIVEL_EVOLUCION(pokemonPadre.getNIVEL_EVOLUCION());
	    bebe.setSONIDO(pokemonPadre.getSONIDO());
	    bebe.setEstado("saludable");
	    bebe.setFertilidad(5);
	    bebe.setId_entrenador(entrenador.getId_entrenador());
	    bebe.setEquipo(0); // No está en el equipo
	    bebe.setId_objeto(0); // Sin objeto

	    // Insertar el nuevo Pokémon en la base de datos (en la caja)
	    try (Connection databaseLink = DatabaseConnection.getConnection()) {
	        String sql = "INSERT INTO pokemon (id_entrenador, num_pokedex, note, vitalidad, ataque, defensa, atk_especial, def_especial, velocidad, nivel, fertilidad, sexo, estado, equipo, id_objeto, nombre, IMG_Frontal, IMG_Trasera, NIVEL_EVOLUCION, SONIDO) "
	                   + "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
	        PreparedStatement stmt = databaseLink.prepareStatement(sql);
	        stmt.setInt(1, entrenador.getId_entrenador());
	        stmt.setInt(2, pokemonPadre.getNum_pokedex());
	        stmt.setString(3, bebe.getNote());
	        stmt.setInt(4, bebe.getVitalidad());
	        stmt.setInt(5, bebe.getAtaque());
	        stmt.setInt(6, bebe.getDefensa());
	        stmt.setInt(7, bebe.getAtk_especial());
	        stmt.setInt(8, bebe.getDef_especial());
	        stmt.setInt(9, bebe.getVelocidad());
	        stmt.setInt(10, bebe.getNivel());
	        stmt.setInt(11, bebe.getFertilidad());
	        stmt.setString(12, String.valueOf(bebe.getSexo()));
	        stmt.setString(13, bebe.getEstado());
	        stmt.setInt(14, bebe.getEquipo());
	        stmt.setInt(15, bebe.getId_objeto());
	        stmt.setString(16, bebe.getNombre());
	        stmt.setString(17, bebe.getIMG_Frontal());
	        stmt.setString(18, bebe.getIMG_Trasera());
	        stmt.setInt(19, bebe.getNIVEL_EVOLUCION());
	        stmt.setString(20, bebe.getSONIDO());

	        stmt.executeUpdate();
	    } catch (Exception e) {
	        e.printStackTrace();
	        JOptionPane.showMessageDialog(null, "Error al guardar el nuevo Pokémon en la base de datos.");
	        return;
	    }

	    // Añadir también al objeto entrenador (caja)
	    entrenador.agregarPokemonAlEquipo(bebe); // Este método ya lo envía a la caja si hay 6

	    JOptionPane.showMessageDialog(null, "¡Ha nacido un nuevo " + bebe.getNombre() + "!");
	    
	    // Limpiar selección
	    pokemonPadre = null;
	    pokemonMadre = null;
	    imgPokemon1.setImage(null);
	    imgPokemon2.setImage(null);
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

            loader.setController(menu);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //------------------------------------------------------------------------------

}
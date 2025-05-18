package controller;

import javafx.scene.image.Image;
import java.util.LinkedList;
import java.util.List;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.ChoiceDialog;

import model.Entrenador;
import model.Pokemon;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.io.File;
import javax.swing.JOptionPane;

import database.DatabaseConnection;

public class CentropokemonController {




    @FXML
    private Button btnCurarBoton;

    @FXML
    private Button btnSalircpBoton;

    @FXML
    private ImageView imgPkmCp;

    @FXML
    private VBox vboxCentroPokemon;
    
    // Variable para guardar el índice del pokemon actual
    private int pokemonActualIndex = 0;
    private final int vidaATope = 100;

    // Variables para manejar la lógica
    private Menu menu;
    private Entrenador entrenador;
    private Stage stage;

    // Variable para guardar el Pokémon padre seleccionado (para crianza, supongo)
    private Pokemon pokemonPadre;

    // Método para inicializar
    public void init(Stage stage, Entrenador entrenador, Menu menu) {
        this.stage = stage;
        this.entrenador = entrenador;
        this.menu = menu;

        if (entrenador.getEquipo() == null || entrenador.getEquipo().isEmpty()) {
            System.out.println("El equipo del entrenador está vacío");
            return;
        }
            }

 




    @FXML
    private void abrirMenu(ActionEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Menu.fxml"));
            Parent root = loader.load();

            Menu menuController = loader.getController();
            menuController.init(entrenador, stage, null);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    
    @FXML
    private void curaPokemon(ActionEvent event) {
        if (entrenador == null || entrenador.getEquipo() == null || entrenador.getEquipo().isEmpty()) {
	        JOptionPane.showMessageDialog(null, "no hay pokemons para curar");
            return;
        }

        // Curar todos los Pokemon: poner vitalidad a 100
        for (Pokemon pkm : entrenador.getEquipo()) {
            pkm.setVitalidad(vidaATope);
        }

        JOptionPane.showMessageDialog(null, "¡Todos los Pokemon se han curado!");

    }



    
}

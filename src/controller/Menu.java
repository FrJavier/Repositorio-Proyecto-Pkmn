package controller;

import java.sql.Connection;

import database.DatabaseConnection;
import javafx.event.ActionEvent; 
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import model.Entrenador;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;



public class Menu {

    Stage stage= new Stage();

    @FXML
    private ImageView btnCentroPokemon;

    @FXML
    private ImageView btnEntrenamiento;

    @FXML
    private ImageView btnGimnasio;

    @FXML
    private ImageView btnGuarderia;

    @FXML
    private ImageView btnSalir;

    @FXML
    private ImageView btnTienda;

    @FXML
    private ImageView imgMenuFondo;

    @FXML
    private ImageView imgPersonaje;
    
    private LoginController loginControllerr;
    private Stage stag;
    private Entrenador entrenador;

    @FXML
    private void abrirTienda(MouseEvent event) {
        try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Tienda.fxml"));
			Parent root = loader.load();

			// Crear y mostrar la nueva escena
			Scene scene = new Scene(root);
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void abrirCentroPokemon(MouseEvent event) {
        try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/CentroPokemon.fxml"));
			Parent root = loader.load();

			// Crear y mostrar la nueva escena
			Scene scene = new Scene(root);
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void abrirVistaCombate(MouseEvent event) {
        try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/VistaCombate.fxml"));
			Parent root = loader.load();

			// Crear y mostrar la nueva escena
			Scene scene = new Scene(root);
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void abrirCapturarPokemon(MouseEvent event) {
        try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/PokemonCaptura.fxml"));
			Parent root = loader.load();

			// Crear y mostrar la nueva escena
			Scene scene = new Scene(root);
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    private void abrirGuarderia(MouseEvent event) {
        try {
			FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Guarderia.fxml"));
			Parent root = loader.load();

			// Crear y mostrar la nueva escena
			Scene scene = new Scene(root);
			Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
			stage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void cerrar(MouseEvent  event) {
    	Stage stage=(Stage) btnSalir.getScene().getWindow();
    	stage.close();
    }

	public void init(Entrenador ent, Stage stage2, LoginController loginController) {
		this.loginControllerr =loginController;
		this.stage = stage2;
		this.entrenador = ent;
		DatabaseConnection con = new DatabaseConnection();

		Connection conexion = con.getConnection();
	}
}

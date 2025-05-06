package controller;

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
import javafx.fxml.FXMLLoader;
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

    @FXML
    private void abrirTienda(MouseEvent event) {
    	try {
        	FXMLLoader loader= new FXMLLoader(getClass().getResource("../view/Tienda.fxml"));
        	Parent root = loader.load();
        	//Muestra escena
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.setTitle("Tienda Pokémon");
            stage.show();
            System.out.println("Imagen clicada");
    	}catch(Exception e) {
    		e.printStackTrace();
    	};
    }
}

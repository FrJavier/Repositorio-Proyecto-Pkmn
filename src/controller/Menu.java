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

	//elementos del fxml----------------
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
	//-----------------------------------

    
    //Variables--------------------------------
    Stage stage= new Stage();
    private LoginController loginControllerr;
    private Stage stag;
    private Entrenador entrenador;
    //-----------------------------------------

    
    //Abre la tienda---------------------------------------------------------------------------
    @FXML
    private void abrirTienda(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Tienda.fxml"));
            Parent root = loader.load();

            // carga el controlador de la tienda
            TiendaController tiendaController = loader.getController();

            // cambia la escena actual del stage por la otra nueva
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            tiendaController.init(currentStage, entrenador, this);

            // crea y enseña la nueva escena
            Scene scene = new Scene(root);
            currentStage.setScene(scene);  // esto es para cambiar en la misma ventana
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //-----------------------------------------------------------------------------------------

    //Abre centro pokemon----------------------------------------------------------------------------
    //----------------------------------------------------------------------------------------------- 
    @FXML
    private void abrirCentroPokemon(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Centropokemonfx.fxml"));
            Parent root = loader.load();

            CentropokemonController centroController = loader.getController();

            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            centroController.init(currentStage, entrenador, this);

            Scene scene = new Scene(root);
            currentStage.setScene(scene);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }



    //-----------------------------------------------------------------------------------------------

    //Abre centro crianza----------------------------------------------------------------------------
    @FXML
    private void abrirGuarderia(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/VistaCrianza.fxml"));
            Parent root = loader.load();

            // coje el controlador y pasarle los datos necesarios
            VistaCrianzaController crianzaController = loader.getController();
            
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            crianzaController.init(currentStage, entrenador, this);

            // crea y muestra la nueva escena
            Scene scene = new Scene(root);
            currentStage.setScene(scene);
            
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    //-----------------------------------------------------------------------------------------------
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

            // Obtener el controlador y pasarle los datos necesarios
            PokemonCapturaController capturaController = loader.getController();
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            capturaController.init(currentStage, entrenador, this);

            // Crear y mostrar la nueva escena
            Scene scene = new Scene(root);
            currentStage.setScene(scene);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    @FXML
    void cerrar(MouseEvent  event) {
    	Stage stage=(Stage) btnSalir.getScene().getWindow();
    	stage.close();
    }
   
    
    @FXML
    private void abrirEquipo(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Equipopokemon.fxml"));
            Parent root = loader.load();

            // carga el ccontrolador de la tienda
            EquipopokemonController EquipopokemonController = loader.getController();

            // cambia la escena actual del stage por la otra nueva
            Stage currentStage = (Stage) ((Node) event.getSource()).getScene().getWindow();
            EquipopokemonController.init(currentStage, entrenador, this);

            // crea y enseña la nueva escena
            Scene scene = new Scene(root);
            currentStage.setScene(scene);  // esto es para cambiar en la misma ventana
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
	
    //Init--------------------------------------------------------------------------
    //variables necesarias para iniciar el init
    private LoginController loginController;
    
    //metodo
	public void init(Entrenador ent, Stage stage, LoginController loginController) {
	    this.entrenador = ent;
	    this.stage = stage;
	    this.loginController = loginController;
	}
    //------------------------------------------------------------------------------


}

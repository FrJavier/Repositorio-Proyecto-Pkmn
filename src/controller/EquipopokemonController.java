package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Entrenador;
import controller.Menu;

public class EquipopokemonController {
	
	private Menu menu;
	private Stage stage;
	
    @FXML
    private Label hpPkmCinco;

    @FXML
    private Label hpPkmCuatro;

    @FXML
    private Label hpPkmDos;

    @FXML
    private Label hpPkmSeis;

    @FXML
    private Label hpPkmTres;

    @FXML
    private Label hpPkmUno;

    @FXML
    private ImageView pokemonEquipoCinco;

    @FXML
    private ImageView pokemonEquipoCuatro;

    @FXML
    private ImageView pokemonEquipoDos;

    @FXML
    private ImageView pokemonEquipoSeis;

    @FXML
    private ImageView pokemonEquipoTres;

    @FXML
    private ImageView pokemonEquipoUno;

    @FXML
    private ProgressBar vitalidadPkmCinco;

    @FXML
    private ProgressBar vitalidadPkmCuatro;

    @FXML
    private ProgressBar vitalidadPkmDos;

    @FXML
    private ProgressBar vitalidadPkmSeis;

    @FXML
    private ProgressBar vitalidadPkmTres;

    @FXML
    private ProgressBar vitalidadPkmUno;

    @FXML
    private ImageView volverCombate;
	private Entrenador entrenador;
    
  //metodo
	
    public void init(Stage stage, Entrenador entrenador, Menu menu) {
        this.stage = stage;
        this.entrenador = entrenador;  // guarda el entrenador
        this.menu = menu;  // guarda el controlador del menu
    }
    //------------------------------------------------------------------------------
    //Volver al menu----------------------------------------------------------------
    @FXML
    private void abrirMenu(MouseEvent event) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Menu.fxml"));
            Parent root = loader.load();

            loader.setController(this);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    
    
    

}

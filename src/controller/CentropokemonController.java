package controller;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Entrenador;

public class CentropokemonController {

    @FXML
    private Button btnCurarBoton;

    @FXML
    private Button btnSalircpBoton;

    @FXML
    private ImageView btnSiguientePkmCp;

    @FXML
    private ImageView imgPkmCp;

    @FXML
    private Label numVitalidadPkmCp;

    @FXML
    private VBox vboxCentroPokemon;

    @FXML
    private ProgressBar vitalidadPkmCp;

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
    
}

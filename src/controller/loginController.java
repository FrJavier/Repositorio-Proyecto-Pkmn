package controller;

import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class LoginController {
	
	public Stage stage;

    @FXML
    private ImageView imgLoginDia;

    @FXML
    private ImageView imgLoginMañana;

    @FXML
    private ImageView imgLoginNoche;

    @FXML
    private ImageView imgLoginTarde;

    @FXML
    private ImageView imgLogoAbajo;

    @FXML
    private ImageView imgLogoPokemon;

    @FXML
    private ImageView imgUsuarioContraseñaLogin;

    @FXML
    private ImageView imgUsuarioLogin;

    @FXML
    private PasswordField passwordFieldUsuarioLogin;

    @FXML
    private TextField txtFieldUsuarioLogin;
    
    public void setStage (Stage primaryStage) {
    	stage=primaryStage;
    }

}

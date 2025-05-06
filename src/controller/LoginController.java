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

public class LoginController {
	@FXML
	private Button btnEntrar;

	@FXML
	private Button btnSalir;

	@FXML
	private Button btnRegistrar;

	@FXML
	private ImageView imgEntrar;

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

	@FXML
	private Label txtError;

	private Stage stage; // Añadimos un Stage para controlar la ventana

	@FXML
	void cerrar(ActionEvent event) {
		Stage stage = (Stage) btnSalir.getScene().getWindow();
		stage.close();
	}

	// Este método se llama desde Main.java para pasar el Stage
	public void setStage(Stage stage) {
		this.stage = stage;
	}

	@FXML
	private void entrar() {

		if (txtFieldUsuarioLogin.getText().isEmpty()) {
			txtError.setText("Inserta un nombre de usuario, por favor");
			txtError.setVisible(true);
		} else if (passwordFieldUsuarioLogin.getText().isEmpty()) {
			txtError.setText("Inserta una contraseña, por favor");
			txtError.setVisible(true);
		} else {

			try {
				// Cargar la vista Menu.fxml
				FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Menu.fxml"));
				Parent root = loader.load();

				// Crear y mostrar la nueva escena
				Scene scene = new Scene(root);
				stage.setScene(scene);
				stage.setTitle("Menú Potaxies");
				stage.show();
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	}
	
	@FXML
    void handleLogin(MouseEvent event) {

    }

}

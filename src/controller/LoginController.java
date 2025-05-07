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
import model.Entrenador;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import database.DatabaseConnection;
import database.EntrenadorDatabase;
import javafx.scene.image.Image;
import javafx.scene.input.KeyEvent;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;
import java.io.File;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import controller.Menu;

import javax.swing.JOptionPane;

import com.mysql.cj.protocol.Resultset;

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
	public void loguearse(MouseEvent event) {
		// Object evt = event.getSource();

		if (txtFieldUsuarioLogin.getText().isEmpty()) {
			txtError.setText("Inserta un nombre de usuario, por favor");
			txtError.setVisible(true);

		} else if (passwordFieldUsuarioLogin.getText().isEmpty()) {
			txtError.setText("Inserta una contraseña, por favor");
			txtError.setVisible(true);
		} else {
			String usuario = txtFieldUsuarioLogin.getText();
			String pass = passwordFieldUsuarioLogin.getText();

			String sql = "SELECT pass\n" + "FROM entrenador\n" + "WHERE usuario = ?";

			DatabaseConnection con = new DatabaseConnection();

			Connection conexion = con.getConnection();

			try {
				PreparedStatement ps = conexion.prepareStatement(sql);
				ps.setString(1, usuario);

				ResultSet rs = ps.executeQuery();

				Entrenador entrenador = new Entrenador(usuario, pass);

				if (!rs.isBeforeFirst()) {

					int opcion = JOptionPane.showConfirmDialog(null, "Usuario no registrado, ¿desea registrarlo?");

					if (opcion == JOptionPane.YES_OPTION) {

						EntrenadorDatabase.crearEntrenador(conexion, entrenador);

						abrirMenuPrincipal(entrenador);

					} else {
						passwordFieldUsuarioLogin.setText("");
					}
				} else {
					while (rs.next()) {
						if (rs.getString(1).equals(pass)) {
							System.out.println("Usuario encontrado");
							// Cambiamos de ventana
							/*EntrenadorDatabase.obtenerIDPokedolaresEntre(conexion, entrenador);*/
							abrirMenuPrincipal(entrenador);

						} else {
							txtError.setText("Contraseña incorrecta");
							txtError.setVisible(true);
						}
					}
				}

			} catch (SQLException e) {
				e.printStackTrace();
			}

		}
	}

	private void abrirMenuPrincipal(Entrenador ent) {
				try {
					FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Menu.fxml"));
					Parent root = loader.load();
					Menu menu= loader.getController();
					
					
					
					Scene scene = new Scene(root);
					Stage stage = new Stage();
					stage.setScene(scene);//Cargamos la escena en el stage
					
					menu.init(ent, stage, this);
					
					stage.show();
					this.stage.close();
					
					
				}catch(IOException e) {
					e.printStackTrace();
				}

}
	
	
}

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
import database.MochilaDatabase;

import javax.swing.JOptionPane;
import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.time.LocalTime;

public class LoginController {

    @FXML private Button btnEntrar;
    @FXML private Button btnSalir;
    @FXML private Button btnRegistrar;

    @FXML private ImageView imgEntrar;
    @FXML private ImageView imgLoginDia;
    @FXML private ImageView imgLoginMañana;
    @FXML private ImageView imgLoginNoche;
    @FXML private ImageView imgLoginTarde;
    @FXML private ImageView imgLogoAbajo;
    @FXML private ImageView imgLogoPokemon;
    @FXML private ImageView imgUsuarioContraseñaLogin;
    @FXML private ImageView imgUsuarioLogin;

    @FXML private PasswordField passwordFieldUsuarioLogin;
    @FXML private TextField txtFieldUsuarioLogin;
    @FXML private Label txtError;

    private Stage stage;

    // Seteamos el stage desde el main o quien cargue esta vista
    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    public void initialize() {
        mostrarImagenPorHora();
    }

    private void mostrarImagenPorHora() {
        // Ocultar todas las imagenes primero
        imgLoginDia.setVisible(false);
        imgLoginMañana.setVisible(false);
        imgLoginTarde.setVisible(false);
        imgLoginNoche.setVisible(false);

        // coje la hora actual
        LocalTime ahora = LocalTime.now();

        if (ahora.isAfter(LocalTime.of(6, 0)) && ahora.isBefore(LocalTime.of(12, 0))) {
            imgLoginMañana.setVisible(true); // 6:00 - 11:59
        } else if (ahora.isAfter(LocalTime.of(12, 0)) && ahora.isBefore(LocalTime.of(18, 0))) {
            imgLoginTarde.setVisible(true); // 12:00 - 17:59
        } else if (ahora.isAfter(LocalTime.of(18, 0)) && ahora.isBefore(LocalTime.of(21, 0))) {
            imgLoginDia.setVisible(true); // 18:00 - 20:59 (atardecer)
        } else {
            imgLoginNoche.setVisible(true); // 21:00 - 5:59
        }
    }

    @FXML
    void cerrar(ActionEvent event) {
        if (stage != null) {
            stage.close();
        } else {
            Stage s = (Stage) btnSalir.getScene().getWindow();
            s.close();
        }
    }

    @FXML
    public void loguearse(MouseEvent event) {
        txtError.setVisible(false);

        String usuario = txtFieldUsuarioLogin.getText().trim();
        String pass = passwordFieldUsuarioLogin.getText();

        if (usuario.isEmpty()) {
            txtError.setText("Inserta un nombre de usuario, por favor");
            txtError.setVisible(true);
            return;
        }
        if (pass.isEmpty()) {
            txtError.setText("Inserta una contraseña, por favor");
            txtError.setVisible(true);
            return;
        }

        String sql = "SELECT pass FROM entrenador WHERE usuario = ?";

        DatabaseConnection con = new DatabaseConnection();
        try (Connection conexion = con.getConnection();
             PreparedStatement ps = conexion.prepareStatement(sql)) {

            ps.setString(1, usuario);

            try (ResultSet rs = ps.executeQuery()) {

                Entrenador entrenador = new Entrenador(usuario, pass);

                if (!rs.isBeforeFirst()) {
                    int opcion = JOptionPane.showConfirmDialog(null, "Usuario no registrado, ¿desea registrarlo?");
                    if (opcion == JOptionPane.YES_OPTION) {
                        EntrenadorDatabase.crearEntrenador(conexion, entrenador);
                        EntrenadorDatabase.obtenerIDPokedolaresEntre(conexion, entrenador);
                        entrenador.setPokedollares(20000);
                        MochilaDatabase.agregarObjeto(entrenador.getId_entrenador(), 8, 10);
                        abrirMenuPrincipal(entrenador);
                    } else {
                        passwordFieldUsuarioLogin.clear();
                    }
                } else {
                    boolean accesoConcedido = false;
                    while (rs.next()) {
                        if (rs.getString("pass").equals(pass)) {
                            System.out.println("Usuario encontrado");
                            EntrenadorDatabase.obtenerIDPokedolaresEntre(conexion, entrenador);
                            abrirMenuPrincipal(entrenador);
                            accesoConcedido = true;
                            break;
                        }
                    }
                    if (!accesoConcedido) {
                        txtError.setText("Contraseña incorrecta");
                        txtError.setVisible(true);
                    }
                }
            }

        } catch (SQLException e) {
            e.printStackTrace();
            txtError.setText("Error en la base de datos.");
            txtError.setVisible(true);
        }
    }

    private void abrirMenuPrincipal(Entrenador ent) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Menu.fxml"));
            Parent root = loader.load();

            Menu menu = loader.getController();

            Scene scene = new Scene(root);
            stage.setScene(scene);

            menu.init(ent, stage, this);

            stage.show();

        } catch (IOException e) {
            e.printStackTrace();
            txtError.setText("Error al cargar el menú principal.");
            txtError.setVisible(true);
        }
    }
}

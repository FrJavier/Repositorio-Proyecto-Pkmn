// TiendaController.java
package controller;

import java.sql.Connection;

import database.DatabaseConnection;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Entrenador;

public class TiendaController {

    @FXML
    private ImageView imgEstanteria;

    @FXML
    private ImageView imgObjAnillo;

    @FXML private ImageView imgPokedollares;
    
    @FXML
    private ImageView imgObjBaston;

    @FXML
    private ImageView imgObjChaleco;

    @FXML
    private ImageView imgObjEter;

    @FXML
    private ImageView imgObjPesa;

    @FXML
    private ImageView imgObjPila;

    @FXML
    private ImageView imgObjPokeball;

    @FXML
    private ImageView imgSalir;

    @FXML
    private ImageView imgTienda;

    @FXML
    private Label lblPokeDollares;

    
    private Stage stage;
    private Menu menu;
    private Entrenador entrenador;
    private int pokedollares;

    public void init(Stage stage, Entrenador entrenador, Menu menu) {
        this.stage = stage;
        this.entrenador = entrenador;
        this.menu = menu;
        cargarPokedollares();
    }

    private void cargarPokedollares() {
        try (Connection conexion = DatabaseConnection.getConnection()) {
            pokedollares = entrenador.getDinero();
            actualizarLblPokedollares();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void actualizarLblPokedollares() {
        lblPokeDollares.setText(String.valueOf(pokedollares));
    }

    @FXML
    private void abrirMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Menu.fxml"));
            Parent root = loader.load();

            // Obtener el controlador del menú cargado
            Menu menuController = loader.getController();

            // Inicializar el controlador con el entrenador y el stage actuales
            menuController.init(entrenador, stage, null); 

            // Cambiar la escena al menú
            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mostrarAlerta(String titulo, String mensaje) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }

    @FXML
    private void comprarAnilloUnico(MouseEvent event) {
        realizarCompra("ANILLO_UNICO", 15000);
    }

    @FXML
    private void comprarBaston(MouseEvent event) {
        realizarCompra("BASTON", 10000);
    }

    @FXML
    private void comprarChaleco(MouseEvent event) {
        realizarCompra("CHALECO", 10000);
    }

    @FXML
    private void comprarEter(MouseEvent event) {
        realizarCompra("ETER", 500);
    }

    @FXML
    private void comprarPesa(MouseEvent event) {
        realizarCompra("PESA", 10000);
    }

    @FXML
    private void comprarPilas(MouseEvent event) {
        realizarCompra("PILAS", 10000);
    }

    @FXML
    private void comprarPokeball(MouseEvent event) {
        realizarCompra("POKEBALL", 50);
    }

    private void realizarCompra(String objeto, int precio) {
        if (entrenador.getPokedollares() >= precio) {
            entrenador.setPokedollares(entrenador.getPokedollares() - precio);
            entrenador.agregarObjeto(objeto);
            mostrarAlerta("Compra exitosa", "Has comprado 1 " + objeto + ".");
            pokedollares = entrenador.getPokedollares();
            actualizarLblPokedollares();
        } else {
            mostrarAlerta("Fondos insuficientes", "No tienes suficiente dinero para comprar " + objeto + ".");
        }
    }
}
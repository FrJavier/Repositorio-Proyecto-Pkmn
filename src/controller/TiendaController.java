package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Entrenador;

public class TiendaController {

    @FXML
    private ImageView imgEstanteria;

    @FXML
    private ImageView imgObjAnillo;

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
    //variables
	private Stage stage;

    //Init--------------------------------------------------------------------------
    //variables necesarias para iniciar el init
    private Menu menu;
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
    private void abrirMenu() {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/Menu.fxml"));
            Parent root = loader.load();

            loader.setController(menu);

            Scene scene = new Scene(root);
            stage.setScene(scene);
            stage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    //------------------------------------------------------------------------------


}

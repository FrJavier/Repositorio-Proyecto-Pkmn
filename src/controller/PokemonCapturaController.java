package controller;

import java.sql.Connection;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Entrenador;
import model.Mochila;
import model.Objeto;
import model.Pokemon;
import database.DatabaseConnection;
import database.EntrenadorDatabase;
import database.MochilaDatabase;

public class PokemonCapturaController {


    @FXML
    private ImageView imgCapturaPokemon;

    @FXML
    private ImageView imgCaturar;

    @FXML
    private ImageView imgPokemonCaptura;

    @FXML
    private ImageView imgPotaxioAtras;

    @FXML
    private ImageView imgSalir;

    @FXML
    private Label lblNumeroPokebolas;

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

    @FXML
    void capturar(MouseEvent event) {

    }
    
    
	private Pokemon pokemon;
	private int pokeballs = 0;
	private final int ID_POKEBOLA = 8;


	
	private void cargarPokeballs() {
		try (Connection conexion = DatabaseConnection.getConnection()) {
			ArrayList<Mochila> mochila = MochilaDatabase.cargarObjetos(entrenador.getId_entrenador());
			for (Mochila objeto : mochila) {
				if(objeto.getIdObjeto() == ID_POKEBOLA) {
					pokeballs = objeto.getCantidad();
					break;
				}
			}
			actualizarLblPokeballs();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void actualizarLblPokeballs() {
		lblNumeroPokebolas.setText(String.valueOf(pokeballs));
		lblNumeroPokebolas.setStyle("-fx-font-size: 32px; -fx-text-fill: #ff0000;");
	}
	
	private void actualizarPokeballsBD() {
		try (Connection conexion = DatabaseConnection.getConnection()){
			MochilaDatabase.actualizarCantidad(entrenador.getId_entrenador(), ID_POKEBOLA, pokeballs);
		
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
}

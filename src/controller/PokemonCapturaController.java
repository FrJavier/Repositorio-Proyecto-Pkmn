package controller;

import java.io.File;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.*;
import java.util.ArrayList;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
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
    private Button btnGenerar;

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
    
    @FXML
    private Label lbltxtpkmncptura;

    //Init--------------------------------------------------------------------------
    //variables necesarias para iniciar el init
    private Menu menu;
    private Entrenador entrenador;
    private Stage stage;
    Random azar=new Random();
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
	
	//Generar pokemon
	@FXML
	public void generarPokemon(ActionEvent event) {
	    Random azar = new Random();  // <- Este faltaba
	    int pokemonid = azar.nextInt(151) + 1;

	    String sql = "SELECT IMG_Frontal,nombre FROM pokedex WHERE num_pokedex = " + pokemonid;

	    try (Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/pokemones","root","");
	         Statement stmt = conn.createStatement();
	         ResultSet rs = stmt.executeQuery(sql)) {

	        if (rs.next()) {
	            String imgFrontal = rs.getString("IMG_Frontal");
	            String nombre = rs.getString("nombre");
	            File archivo=new File (imgFrontal);
	            Image image = new Image(archivo.toURI().toString());
	            imgPokemonCaptura.setVisible(true);
	            
	            lbltxtpkmncptura.setVisible(true);
	            imgPokemonCaptura.setImage(image);
	            lbltxtpkmncptura.setText(nombre);
	        } else {
	            System.out.println("No se encontró un Pokémon con ID: " + pokemonid);
	        }

	    } catch (SQLException e) {
	        e.printStackTrace();
	    }
	}
}

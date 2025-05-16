package controller;

import java.util.HashMap;
import java.util.Map;
import javafx.scene.control.Alert;
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
	// variables
	private Stage stage;

	// Init--------------------------------------------------------------------------
	// variables necesarias para iniciar el init
	private Menu menu;
	private Entrenador entrenador;

	// ------------------------------------------------------------------------------
	// Volver al
	// menu----------------------------------------------------------------
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

	// ------------------------------------------------------------------------------
	
	// variables para mapear objetos con precios
	private Map<ImageView, String> objetoPorImagen = new HashMap<>();
	private Map<String, Integer> precios = new HashMap<>();

	// inicializarmos objetos y precios
	public void init(Stage stage, Entrenador entrenador, Menu menu) {
		this.stage = stage;
		this.entrenador = entrenador;
		this.menu = menu;
		inicializarObjetos(); // Llamamos a este método que viene abajo
	}

	private void inicializarObjetos() {
		objetoPorImagen.put(imgObjAnillo, "Anillo");
		objetoPorImagen.put(imgObjBaston, "Baston");
		objetoPorImagen.put(imgObjChaleco, "Chaleco");
		objetoPorImagen.put(imgObjEter, "Eter");
		objetoPorImagen.put(imgObjPesa, "Pesa");
		objetoPorImagen.put(imgObjPila, "Pila");
		objetoPorImagen.put(imgObjPokeball, "Pokeball");

		precios.put("Anillo", 100);
		precios.put("Baston", 150);
		precios.put("Chaleco", 120);
		precios.put("Eter", 80);
		precios.put("Pesa", 90);
		precios.put("Pila", 70);
		precios.put("Pokeball", 50);
	}

	// metodo para comprar objetos
	@FXML
	private void comprarObjeto(MouseEvent event) {
		ImageView clicado = (ImageView) event.getSource();

		if (objetoPorImagen.containsKey(clicado)) {
			String nombreObjeto = objetoPorImagen.get(clicado);
			int precio = precios.get(nombreObjeto);

			if (entrenador.getDinero() >= precio) {
				entrenador.setDinero(entrenador.getDinero() - precio);
				entrenador.agregarObjeto(nombreObjeto);
				mostrarAlerta("Compra exitosa", "Has comprado un " + nombreObjeto + " por " + precio + " pokedólares.");
			} else {
				mostrarAlerta("Fondos insuficientes", "No tienes suficiente dinero para comprar " + nombreObjeto + ".");
			}
		}
	}
	
	//metodo para mostrar aletar despues de comprar
	private void mostrarAlerta(String titulo, String mensaje) {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setTitle(titulo);
		alert.setHeaderText(null);
		alert.setContentText(mensaje);
		alert.showAndWait();
	}

	public void init(Stage currentStage, Entrenador entrenador2, PokemonCapturaController pokemonCapturaController) {
		// TODO Auto-generated method stub
		
	}
	
	//falta enlazar los objetos en el fmxl <ImageView fx:id="imgObjAnillo" onMouseClicked="#comprarObjeto" />
}

package controller;

import javafx.scene.image.Image;
import java.util.LinkedList;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import model.Entrenador;
import model.Pokemon;

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
    
    //variables para los metodos de curar pokemons
    private int pokemonActualIndex = 0;
    private final int vidaATope = 100;
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
        
        //comprobar si el entrenador tiene un equipo que curar
        if (entrenador.getEquipo() == null || entrenador.getEquipo().isEmpty()) {
        	System.out.println("El equipo del entrenador esta vacio");
        	return;
        }
        
        actualizarVistaPokemon();
    }
    
    private void actualizarVistaPokemon() {
    	LinkedList<Pokemon> equipo = entrenador.getEquipo();
    	if (equipo == null || equipo.isEmpty()) return;
    	
    	if (pokemonActualIndex >= equipo.size()) {
    		pokemonActualIndex = 0;
    	}
    	
    	Pokemon pkm = equipo.get(pokemonActualIndex);
    	
    	//cargar la imagen del pokemon correspondiente
    	
    	try {
    		Image imagen = new Image(pkm.getIMG_Frontal());
    		imgPkmCp.setImage(imagen);
    	} catch (Exception e) {
    		System.out.println("No se pudo cargar la imagen del pokemon");
    	}
    	
    	//como no hay vida para cada pokemon vamos a poner que el valor de la vida para cada pokemon es 100
    	int vidaActual = pkm.getVitalidad();
    	double progreso = Math.min(1.0, (double) vidaActual/vidaATope);
    	vitalidadPkmCp.setProgress(progreso);
    	numVitalidadPkmCp.setText(vidaActual + " / " + vidaATope);
    }
    
    @FXML
    private void curarPokemon() {
    	LinkedList<Pokemon> equipo = entrenador.getEquipo();
    	if (equipo == null || equipo.isEmpty()) return;
    	
    	Pokemon pkm = equipo.get(pokemonActualIndex);
    	pkm.setVitalidad(vidaATope);
    	actualizarVistaPokemon();
    }
    
     @FXML
     private void siguientePokemon() {
    	 LinkedList<Pokemon> equipo = entrenador.getEquipo();
    	 if (equipo == null || equipo.size() <= 1) return; //para que no te deje darle a siguiente si tienes 0 pkm o si solo tienes 1
    	 
    	 pokemonActualIndex = (pokemonActualIndex + 1) % equipo.size();
    	 actualizarVistaPokemon();
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

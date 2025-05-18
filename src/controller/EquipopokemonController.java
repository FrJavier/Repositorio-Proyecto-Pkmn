package controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ProgressBar;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import model.Entrenador;
import model.Pokemon;

import java.util.LinkedList;

import javax.swing.JOptionPane;

import controller.Menu;

public class EquipopokemonController {
	
	private Menu menu;
	private Stage stage;
	
    @FXML
    private Label hpPkmCinco;

    @FXML
    private Label hpPkmCuatro;

    @FXML
    private Label hpPkmDos;

    @FXML
    private Label hpPkmSeis;

    @FXML
    private Label hpPkmTres;

    @FXML
    private Label hpPkmUno;

    @FXML
    private ImageView imgEligeUnPokemon;

    @FXML
    private ImageView pokemonEquipoCinco;

    @FXML
    private ImageView pokemonEquipoCuatro;

    @FXML
    private ImageView pokemonEquipoDos;

    @FXML
    private ImageView pokemonEquipoSeis;

    @FXML
    private ImageView pokemonEquipoTres;

    @FXML
    private ImageView pokemonEquipoUno;

    @FXML
    private ProgressBar vitalidadPkmCinco;

    @FXML
    private ProgressBar vitalidadPkmCuatro;

    @FXML
    private ProgressBar vitalidadPkmDos;

    @FXML
    private ProgressBar vitalidadPkmSeis;

    @FXML
    private ProgressBar vitalidadPkmTres;

    @FXML
    private ProgressBar vitalidadPkmUno;

    @FXML
    private ImageView volverCombate;
    
    
    
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
    
    @FXML
    void elegirPokemon(MouseEvent event) {
        // Mostrar los Pokémon que están en la caja (equipo == 0)
        java.util.List<Pokemon> caja = entrenador.getPokemonCaja();

        if (caja.isEmpty()) {
            JOptionPane.showMessageDialog(null, "No tienes Pokémon en la caja.");
            return;
        }

        // Crear un array de opciones con los nombres/motes
        String[] opcionesCaja = caja.stream()
            .map(p -> p.getNote() + " (Lv." + p.getNivel() + ")")
            .toArray(String[]::new);

        String seleccion = (String) JOptionPane.showInputDialog(
                null,
                "Elige un Pokémon de la caja para añadir al equipo:",
                "Caja Pokémon",
                JOptionPane.PLAIN_MESSAGE,
                null,
                opcionesCaja,
                opcionesCaja[0]);

        if (seleccion == null) return; // Usuario canceló

        // Buscar el Pokémon seleccionado
        Pokemon elegido = null;
        for (Pokemon p : caja) {
            if (seleccion.contains(p.getNote())) {
                elegido = p;
                break;
            }
        }

        if (elegido == null) return;

        // Comprobar si el equipo está lleno
        if (entrenador.getEquipo().size() >= 6) {
            int respuesta = JOptionPane.showConfirmDialog(null,
                    "Tu equipo está lleno. ¿Quieres sacar un Pokémon para meter a " + elegido.getNote() + "?",
                    "Equipo lleno",
                    JOptionPane.YES_NO_OPTION);

            if (respuesta == JOptionPane.YES_OPTION) {
                // Mostrar Pokémon del equipo actual
                String[] opcionesEquipo = entrenador.getEquipo().stream()
                        .map(p -> p.getNote() + " (Lv." + p.getNivel() + ")")
                        .toArray(String[]::new);

                String pokeASacar = (String) JOptionPane.showInputDialog(
                        null,
                        "¿Qué Pokémon quieres sacar del equipo?",
                        "Sacar Pokémon",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        opcionesEquipo,
                        opcionesEquipo[0]);

                if (pokeASacar == null) return;

                Pokemon aSacar = null;
                for (Pokemon p : entrenador.getEquipo()) {
                    if (pokeASacar.contains(p.getNote())) {
                        aSacar = p;
                        break;
                    }
                }

                if (aSacar != null) {
                    // Intercambiar
                    entrenador.sacarDelEquipo(aSacar); // pone equipo = 0
                    entrenador.meterAlEquipo(elegido); // pone equipo = 1

                    JOptionPane.showMessageDialog(null, elegido.getNote() + " ha sido añadido al equipo.\n" + aSacar.getNote() + " ha sido enviado a la caja.");
                }

            } else {
                JOptionPane.showMessageDialog(null, "No se ha hecho ningún cambio.");
            }

        } else {
            // Añadir directamente al equipo
            entrenador.meterAlEquipo(elegido);
            JOptionPane.showMessageDialog(null, elegido.getNote() + " ha sido añadido al equipo.");
        }

 
    }
    
    //metodo para actualizar las vistas de los pokemon que hay en el equipo
    public void actualizarVistaEquipo(Entrenador entrenador) {
        LinkedList<Pokemon> equipo = entrenador.getEquipo();

        ImageView[] imagenes = {
            pokemonEquipoUno, pokemonEquipoDos, pokemonEquipoTres,
            pokemonEquipoCuatro, pokemonEquipoCinco, pokemonEquipoSeis
        };

        Label[] hps = {
            hpPkmUno, hpPkmDos, hpPkmTres,
            hpPkmCuatro, hpPkmCinco, hpPkmSeis
        };

        ProgressBar[] barras = {
            vitalidadPkmUno, vitalidadPkmDos, vitalidadPkmTres,
            vitalidadPkmCuatro, vitalidadPkmCinco, vitalidadPkmSeis
        };

        for (int i = 0; i < 6; i++) {
            if (i < equipo.size()) {
                Pokemon pkm = equipo.get(i);

                try {
                    imagenes[i].setImage(new Image(getClass().getResourceAsStream(pkm.getRutaImagen())));
                } catch (Exception e) {
                    System.out.println("No se pudo cargar la imagen para: " + pkm.getRutaImagen());
                    imagenes[i].setImage(null); // Por si la imagen no existe
                }

                imagenes[i].setVisible(true);

                int hpActual = pkm.getHpActual();
				int hpTotal = pkm.getHpTotal();
                double porcentaje = (double) hpActual / hpTotal;

                hps[i].setText("HP " + hpActual + "/" + hpTotal);
                hps[i].setVisible(true);

                barras[i].setProgress(porcentaje);
                barras[i].setVisible(true);
            } else {
                //ocultar los elementos si no hay pokemon
                imagenes[i].setVisible(false);
                hps[i].setVisible(false);
                barras[i].setVisible(false);
            }
        }
    }
    
    

}

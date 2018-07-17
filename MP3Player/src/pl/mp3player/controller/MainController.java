package pl.mp3player.controller;

import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class MainController implements Initializable {

    @FXML
    private Button nextButton;

    @FXML
    private Slider volumeSlider;

    @FXML
    private Slider songSlider;

    @FXML
    private MenuItem aboutMenuItem;

    @FXML
    private TableView<?> contentTable;

    @FXML
    private MenuItem fileMenuItem;

    @FXML
    private MenuItem closeMenuItem;

    @FXML
    private MenuItem dirMenuItem;

    @FXML
    private Menu helpMenu;

    @FXML
    private Button prevButton;

    @FXML
    private ToggleButton playButton;

    @FXML
    private Menu fileMenu;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

    }
}

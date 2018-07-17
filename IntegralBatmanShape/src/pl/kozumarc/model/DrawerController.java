package pl.kozumarc.model;

import javafx.concurrent.WorkerStateEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.control.TextField;
import pl.kozumarc.Main;
import javafx.scene.control.ProgressBar;
import javafx.scene.control.Label;

public class DrawerController {

    @FXML
    private Canvas canvas;
    private DrawerTask task;
    private Main main;
    @FXML
    private ProgressBar progressBar;
    @FXML
    private TextField liczbaPunktow;
    @FXML
    private Label wynik;

    @FXML
    private void handleRunBtnAction(){
        GraphicsContext gc = canvas.getGraphicsContext2D();
        int p=Integer.parseInt(liczbaPunktow.getText());
        task = new DrawerTask(gc,p);
        progressBar.progressProperty().bind(task.progressProperty());
        task.setOnSucceeded(new EventHandler<WorkerStateEvent>() {
            @Override
            public void handle(WorkerStateEvent event) {
                double var=(double)task.getValue();
                wynik.setText(Double.toString(var));
            }
        });

        new Thread(task).start();
    }
    @FXML
    private void handleStopBtnAction()
    {
        task.cancel();
    }
    public void setMainApp(Main main) {
        this.main = main;
    }
}

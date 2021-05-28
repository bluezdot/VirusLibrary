package hust.soict.dsai.team3.screen;

import hust.soict.dsai.team3.controller.VirusWithEnvelopeScreenController;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import javax.swing.*;

public class VirusWithEnvelopeScreen extends Application {

    @Override
    public void start(Stage primaryStage) {

        try {
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/sample/VirusWithEnvelopeScreen.fxml"));
            VirusWithEnvelopeScreenController controller = new VirusWithEnvelopeScreenController();
            fxmlloader.setController(controller);
            Parent root = fxmlloader.load();
            Scene scene = new Scene(root);

            primaryStage.setTitle("VIRUS WITH ENVELOPE");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}

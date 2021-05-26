package hust.soict.dsai.team3.screen;

import hust.soict.dsai.team3.controller.EnvelopeStructureController;
import hust.soict.dsai.team3.model.virus.Virus;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class StructureScreen extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Virus hiv = new Virus(getClass().getClassLoader().getResource("virus/HIV/").getFile());
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("virus/virus_structure.fxml"));
//        StructureController hover = new StructureController(hiv);
        EnvelopeStructureController hover = new EnvelopeStructureController(hiv);
        hover.setStage(primaryStage);
        loader.setController(hover);
        Parent root = loader.load();
        primaryStage.setTitle("Virus Structure");
        primaryStage.setFullScreen(true);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

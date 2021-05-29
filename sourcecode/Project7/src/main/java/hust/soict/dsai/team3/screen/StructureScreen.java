package hust.soict.dsai.team3.screen;

import hust.soict.dsai.team3.controller.StructureController;
import hust.soict.dsai.team3.model.virus.EnvelopeVirus;
import hust.soict.dsai.team3.model.virus.NonEnvelopeVirus;
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
        Virus hiv = new EnvelopeVirus(getClass().getClassLoader().getResource("virus/HIV/").getFile());
        Virus pvirus = new NonEnvelopeVirus(getClass().getClassLoader().getResource("virus/PolioVirus/").getFile());
        Virus hbv = new EnvelopeVirus(getClass().getClassLoader().getResource("virus/HBV/").getFile());
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/virus_structure.fxml"));
//        StructureController hover = new StructureController(hiv);
        StructureController hover = new StructureController(hbv);
//        StructureController hover = new StructureController(hcv);
        hover.setStage(primaryStage);
        loader.setController(hover);
        Parent root = loader.load();
        primaryStage.setTitle("Virus Structure");
        primaryStage.setResizable(false);
//        primaryStage.setFullScreen(true);
        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

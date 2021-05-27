package hust.soict.dsai.team3.screen;


import hust.soict.dsai.team3.model.cell.Cell;
import hust.soict.dsai.team3.model.virus.EnvelopeVirus;
import hust.soict.dsai.team3.model.virus.Virus;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import sample.InfectingControllerTest;

public class InfectingScreen extends Application {


    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception{
        Virus hiv = new EnvelopeVirus(getClass().getClassLoader().getResource("virus/HIV/").getFile());
        Cell cell = new Cell(getClass().getClassLoader().getResource("cell/Cell").getFile());
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/infectingTest.fxml"));
        InfectingControllerTest infectingControllerTest = new InfectingControllerTest(hiv, cell);
        loader.setController(infectingControllerTest);
        Parent root = loader.load();
        primaryStage.setTitle("Virus Demonstration");

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}

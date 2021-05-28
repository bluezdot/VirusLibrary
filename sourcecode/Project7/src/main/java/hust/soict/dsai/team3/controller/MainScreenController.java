package hust.soict.dsai.team3.controller;

import hust.soict.dsai.team3.model.virus.EnvelopeVirus;
import hust.soict.dsai.team3.model.virus.NonEnvelopeVirus;
import hust.soict.dsai.team3.model.virus.Virus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainScreenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem itemAim;

    @FXML
    private MenuItem itemProblem;

    @FXML
    private MenuItem itemUsage;

    @FXML
    private Button btnHIV;

    @FXML
    private Button btnHBV;

    @FXML
    private Button btnHCV;

    @FXML
    private Button btnPolioVirus;

    @FXML
    private Button btnNoroVirus;

    @FXML
    private Button btnRhinoVirus;


    // Handle Menu: problem, usage and aim button on pressed

    @FXML
    void itemUsageOnPressed(ActionEvent event) {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,
                "Updating",
                "Usage",
                JOptionPane.INFORMATION_MESSAGE);
    }

    @FXML
    void itemAimOnPressed(ActionEvent event) {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,
                "Investigate many types of virus",
                "Aim",
                JOptionPane.INFORMATION_MESSAGE);
    }

    @FXML
    void itemProblemOnPressed(ActionEvent event){
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,
                "COVID-19 has been spreading all over the world and there is the need of understanding \n" +
                "different type of viruses, as well as the way they infect in order to have the basic knowledge to \n" +
                "prevent them",
                "Problem",
                JOptionPane.INFORMATION_MESSAGE);
    }


    // Handle switch scene

    @FXML
    void btnHIVOnPressed(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) btnHIV.getScene().getWindow();
        Virus hiv = new EnvelopeVirus(getClass().getClassLoader().getResource("virus/HIV/").getFile());
        Virus pvirus = new NonEnvelopeVirus(getClass().getClassLoader().getResource("virus/PolioVirus/").getFile());
        Virus hcv = new EnvelopeVirus(getClass().getClassLoader().getResource("virus/HCV/").getFile());

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/virus_structure.fxml"));
        StructureController hover = new StructureController(hiv);

        loader.setController(hover);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        primaryStage.setTitle("Virus Structure");
        primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void btnHBVOnPressed(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) btnHBV.getScene().getWindow();
        Virus hbv = new EnvelopeVirus(getClass().getClassLoader().getResource("virus/HBV/").getFile());

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/virus_structure.fxml"));
        StructureController hover = new StructureController(hbv);

        loader.setController(hover);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        primaryStage.setTitle("Virus Structure");
        primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.show();

    }

    @FXML
    void btnHCVOnPressed(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) btnHCV.getScene().getWindow();
        Virus hcv = new EnvelopeVirus(getClass().getClassLoader().getResource("virus/HCV/").getFile());

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/virus_structure.fxml"));
        StructureController hover = new StructureController(hcv);

        loader.setController(hover);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        primaryStage.setTitle("Virus Structure");
        primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void btnNoroVirusOnPressed(ActionEvent event) {

    }

    @FXML
    void btnPolioVirusOnPressed(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) btnPolioVirus.getScene().getWindow();
        Virus polio = new EnvelopeVirus(getClass().getClassLoader().getResource("virus/PolioVirus/").getFile());

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/virus_structure.fxml"));
        StructureController hover = new StructureController(polio);

        loader.setController(hover);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        primaryStage.setTitle("Virus Structure");
        primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void btnRhinoVirusOnPressed(ActionEvent event) {

    }

//     @FXML
//     void btnWithEnvelopeOnPressed(ActionEvent event) throws IOException {
//        Stage primaryStage = (Stage) btnWithEnvelope.getScene().getWindow();
//         Virus hiv = new EnvelopeVirus(getClass().getClassLoader().getResource("virus/HIV/").getFile());
//         Virus pvirus = new NonEnvelopeVirus(getClass().getClassLoader().getResource("virus/PolioVirus/").getFile());
//         Virus hcv = new EnvelopeVirus(getClass().getClassLoader().getResource("virus/HCV/").getFile());
//
//         FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/virus_structure.fxml"));
//         StructureController hover = new StructureController(hiv);
//
//         loader.setController(hover);
//         Parent root = loader.load();
//         Scene scene = new Scene(root);
//
//         primaryStage.setTitle("Virus Structure");
//         primaryStage.setFullScreen(true);
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }
//
//     @FXML
//     void btnWithoutEnvelopeOnPressed(ActionEvent event) throws IOException {
//         Stage primaryStage = (Stage) btnWithEnvelope.getScene().getWindow();
//         Virus hiv = new EnvelopeVirus(getClass().getClassLoader().getResource("virus/HIV/").getFile());
//         Virus pvirus = new NonEnvelopeVirus(getClass().getClassLoader().getResource("virus/PolioVirus/").getFile());
//         Virus hcv = new EnvelopeVirus(getClass().getClassLoader().getResource("virus/HCV/").getFile());
//
//         FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/virus_structure.fxml"));
//         StructureController hover = new StructureController(pvirus);
//
//         loader.setController(hover);
//         Parent root = loader.load();
//         Scene scene = new Scene(root);
//
//         primaryStage.setTitle("Virus Structure");
//         primaryStage.setFullScreen(true);
//         primaryStage.setScene(scene);
//         primaryStage.show();
//     }



    @FXML
    void initialize() {
        assert btnHBV != null : "fx:id=\"btnHBV\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert itemAim != null : "fx:id=\"itemAim\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert itemProblem != null : "fx:id=\"itemProblem\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert btnPolioVirus != null : "fx:id=\"btnPolioVirus\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert btnHIV != null : "fx:id=\"btnHIV\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert btnNoroVirus != null : "fx:id=\"btnNoroVirus\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert btnRhinoVirus != null : "fx:id=\"btnRhinoVirus\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert itemUsage != null : "fx:id=\"itemUsage\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert btnHCV != null : "fx:id=\"btnHCV\" was not injected: check your FXML file 'MainScreen.fxml'.";

    }
}
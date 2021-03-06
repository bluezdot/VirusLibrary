package hust.soict.dsai.team3.controller;

import hust.soict.dsai.team3.model.virus.EnvelopeVirus;
import hust.soict.dsai.team3.model.virus.NonEnvelopeVirus;
import hust.soict.dsai.team3.model.virus.Virus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.ScrollPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;
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
    private Button btnHEV;

    @FXML
    private Button btnPolioVirus;

    @FXML
    private Button btnNoroVirus;

    @FXML
    private Button btnRhinoVirus;


    // Handle Menu: problem, usage and aim button on pressed

    @FXML
    void itemUsageOnPressed(ActionEvent event) throws IOException {
        Button returnButton = new Button("Return to main");
        returnButton.setPrefSize(500, 100);

        ScrollPane scrollPane = new ScrollPane();
        VBox panel = new VBox();
        panel.setAlignment(Pos.CENTER);
        Stage primaryStage = (Stage) btnHIV.getScene().getWindow();
        panel.getChildren().addAll(getTitle("Step 1"), getImage("usage/one.png"), getTitle("Step 1"), getImage("usage/two.png"), getTitle("Step 2"), getImage("usage/three.png"), getTitle("Step 2"), getImage("usage/five.png"), getTitle("Step 3"), getImage("usage/four.png"));

        returnButton.setOnAction(e -> {
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/MainScreen.fxml"));

            MainScreenController controller = new MainScreenController();
            fxmlloader.setController(controller);
            Parent root = null;
            try {
                root = fxmlloader.load();
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            Scene scene = new Scene(root);

            primaryStage.setTitle("VIRUS MAIN MENU");
            primaryStage.setScene(scene);
            primaryStage.show();

//            // Set X close
//            primaryStage.setOnCloseRequest(eve -> {
//                // window = primaryStage;
//
//                try {
//                    FXMLLoader fxmlloader1 = new FXMLLoader(getClass().getClassLoader().getResource("fxml/MainScreen.fxml"));
//                    MainScreenController controller1 = new MainScreenController();
//                    fxmlloader1.setController(controller1);
//                    Parent root1 = fxmlloader1.load();
//                    Scene scene1 = new Scene(root1);
//
//
//                    primaryStage.setTitle("VIRUS MAIN MENU");
//                    primaryStage.setScene(scene1);
//                    primaryStage.show();
//
//                } catch (Exception e1) {
//                    e1.printStackTrace();
//                }
//
//                // Set X close confirmation
//                primaryStage.setOnCloseRequest(e2 -> {
//                    JFrame frame = new JFrame();
//                    int n = JOptionPane.showConfirmDialog(
//                            frame,
//                            "Do you want to exit the program ?",
//                            "Exit application",
//                            JOptionPane.YES_NO_OPTION);
//                    if (n == 0) {
//                        // close application when user confirm "Yes"
//                        System.out.println(n);
//                        System.exit(0);
//                    } else {
//                        // cancel the application exit when user click "No"
//                        event.consume();
//                    }
//                });
//            });
        });
        panel.getChildren().add(returnButton);
        scrollPane.setContent(panel);
        scrollPane.setVisible(true);


        primaryStage.setTitle("Usage");
        primaryStage.setScene(new Scene(scrollPane));
        primaryStage.show();
    }

    public ImageView getImage(String file) {
        Image image = new Image(getClass().getClassLoader().getResource(file).toExternalForm());
        ImageView iview = new ImageView(image);
        return iview;
    }

    public Text getTitle(String title) {
        Text text = new Text(title);
        text.setFont(Font.font("Verdana", FontWeight.BOLD, 20));
        text.setFill(Color.RED);
        return text;
    }

    @FXML
    void itemAimOnPressed(ActionEvent event) {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,
                "Investigate structure of viruses and how they infect to cell",
                "Aim",
                JOptionPane.INFORMATION_MESSAGE);
    }

    @FXML
    void itemProblemOnPressed(ActionEvent event) {
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
    void btnNoroVirusOnPressed(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) btnNoroVirus.getScene().getWindow();
        Virus noro = new NonEnvelopeVirus(getClass().getClassLoader().getResource("virus/NoroVirus/").getFile());

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/virus_structure.fxml"));
        StructureController hover = new StructureController(noro);

        loader.setController(hover);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        primaryStage.setTitle("Virus Structure");
        primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    void btnHEVOnPressed(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) btnHEV.getScene().getWindow();
        Virus hev = new NonEnvelopeVirus(getClass().getClassLoader().getResource("virus/HEV/").getFile());

        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/virus_structure.fxml"));
        StructureController hover = new StructureController(hev);

        loader.setController(hover);
        Parent root = loader.load();
        Scene scene = new Scene(root);

        primaryStage.setTitle("Virus Structure");
        primaryStage.setFullScreen(true);
        primaryStage.setScene(scene);
        primaryStage.show();
    }


    @FXML
    void btnPolioVirusOnPressed(ActionEvent event) throws IOException {
        Stage primaryStage = (Stage) btnPolioVirus.getScene().getWindow();
        Virus polio = new NonEnvelopeVirus(getClass().getClassLoader().getResource("virus/PolioVirus/").getFile());

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
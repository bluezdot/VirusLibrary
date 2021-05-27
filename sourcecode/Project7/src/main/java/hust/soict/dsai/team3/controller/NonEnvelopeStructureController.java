package hust.soict.dsai.team3.controller;

import hust.soict.dsai.team3.model.virus.EnvelopeVirus;
import hust.soict.dsai.team3.model.virus.Virus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class NonEnvelopeStructureController extends StructureController {

    HashMap<String, Button> btnComponents = new HashMap<>();

    public NonEnvelopeStructureController(Virus virus){
        super(virus);
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
//        super.initialize(url, resourceBundle);
        primaryView = new ImageView(virus.getOverviewImage());
        center.getChildren().add(primaryView);
        hoverView = new ImageView();
        for (String component : virus.getComponents().keySet()){
            btnComponents.put(component, new Button(component));
            setHoverProperty(btnComponents.get(component), component);
            btnComponents.get(component).setOnAction(e -> {
                setCenterPic(e, component);
            });
        }

        GridPane left = new GridPane();
        int start = 0;
        for (Button button : btnComponents.values()){
            left.add(button, 0, start++);
        }
        left.setVgap(10);
        left.setAlignment(Pos.CENTER);
        borderPane.setLeft(left);
        BorderPane.setAlignment(left, Pos.CENTER);
    }

    @FXML
    void envelopePressed(ActionEvent event) {
        setCenterPic(event, EnvelopeVirus.ENVELOPE);
    }


}
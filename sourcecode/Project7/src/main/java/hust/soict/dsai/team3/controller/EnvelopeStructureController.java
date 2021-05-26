package hust.soict.dsai.team3.controller;

import hust.soict.dsai.team3.model.virus.EnvelopeVirus;
import hust.soict.dsai.team3.model.virus.Virus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import java.net.URL;
import java.util.ResourceBundle;

public class EnvelopeStructureController extends StructureController{

    public EnvelopeStructureController(Virus virus) {
        super(virus);
    }

    @FXML
    protected Button btnEnvelop;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        super.initialize(url, resourceBundle);

        btnEnvelop.hoverProperty().addListener((javafx.beans.value.ChangeListener<? super Boolean>) (observable, oldValue, newValue) -> {
            setHoverPic(newValue, EnvelopeVirus.ENVELOPE);
        });
    }

    @FXML
    void envelopePressed(ActionEvent event) {
        setCenterPic(event, EnvelopeVirus.ENVELOPE);
    }

}

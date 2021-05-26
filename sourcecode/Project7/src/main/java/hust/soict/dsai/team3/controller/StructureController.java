package hust.soict.dsai.team3.controller;

import hust.soict.dsai.team3.model.virus.Virus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class StructureController implements Initializable {
    protected Virus virus;
    protected Stage stage;
    protected ImageView primaryView;
    protected ImageView hoverView;
    protected Boolean presentMode = false;


    public StructureController(Virus virus) {
        this.virus = virus;
    }

    @FXML
    protected BorderPane borderPane;

    @FXML
    protected Button btnAN;

    @FXML
    protected Button btnCapsid;

    @FXML
    protected Button btnEnzime;

    @FXML
    protected VBox center;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        primaryView = new ImageView(virus.getOverviewImage());
        center.getChildren().add(primaryView);
        hoverView = new ImageView();

        btnAN.hoverProperty().addListener((javafx.beans.value.ChangeListener<? super Boolean>) (observable, oldValue, newValue) -> {
            setHoverPic(newValue, Virus.ACID_NUCLEIC);
        });

        btnCapsid.hoverProperty().addListener((javafx.beans.value.ChangeListener<? super Boolean>) (observable, oldValue, newValue) -> {
            setHoverPic(newValue, Virus.CAPSID);
        });

        btnEnzime.hoverProperty().addListener((javafx.beans.value.ChangeListener<? super Boolean>) (observable, oldValue, newValue) -> {
            setHoverPic(newValue, Virus.ENZIME);
        });
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }


    @FXML
    void anPressed(ActionEvent event) {
        setCenterPic(event, Virus.ACID_NUCLEIC);
    }

    @FXML
    void capsidPressed(ActionEvent event) {
        setCenterPic(event, Virus.CAPSID);
    }

    @FXML
    void enzimePressed(ActionEvent event) {
        setCenterPic(event, Virus.ENZIME);
    }




    protected void setHoverPic(Boolean newValue, String component) {
        if (newValue && !center.getChildren().contains(hoverView)) {
            center.getChildren().clear();
            hoverView.setImage(virus.getOverviewImageOf(component));
            center.getChildren().add(hoverView);
        }

        if (!newValue && !center.getChildren().contains(primaryView) && !presentMode) {
            center.getChildren().clear();
            center.getChildren().add(primaryView);
        }
    }

    protected void setCenterPic(ActionEvent event, String component){
        if (!presentMode) {
            ((Button) event.getSource()).setText("Return to Overview");
            presentMode = true;
            center.getChildren().clear();
            hoverView.setImage(virus.getDetailImageOf(component));
            center.getChildren().add(hoverView);
            TextArea des = new TextArea(virus.getComponent(component).toString());
            des.setEditable(false);
            center.getChildren().add(des);
        } else {
            presentMode = false;
            ((Button) event.getSource()).setText(component);
        }
    }
}

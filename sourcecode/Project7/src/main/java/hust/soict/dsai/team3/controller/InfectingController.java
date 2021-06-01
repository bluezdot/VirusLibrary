package hust.soict.dsai.team3.controller;


import hust.soict.dsai.team3.model.cell.Cell;
import hust.soict.dsai.team3.model.virus.Virus;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public abstract class InfectingController implements Initializable {
    TranslateTransition translateTransition;
    protected Virus virus;
    protected Cell cell;

    public InfectingController(Virus virus, Cell cell) {
        this.virus = virus;
        this.cell = new Cell(cell);
    }

    public InfectingController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cell.setComponentsSize(300, 300, 300);

        cellPane.getChildren().clear();
        cellPane.getChildren().add(cell);
        cellPane.setTranslateX(200);
        cellPane.setTranslateY(200);

        rootVirus.getChildren().clear();
        virus.setImage(virus.getOverviewImage());
        virus.setVisible(true);
        virus.setFitWidth(70);
        virus.setPreserveRatio(true);
        rootVirus.getChildren().add(virus);

        translateTransition = createTranslateTransitionFor(rootVirus, cell.getCenter());

        attack();

    }

    @FXML
    protected StackPane cellPane;

    @FXML
    protected ImageView layer;

    @FXML
    protected ImageView nucleus;

    @FXML
    protected StackPane rootVirus;

    @FXML
    protected AnchorPane root;


    protected TranslateTransition createTranslateTransitionFor(Node node, Node target) {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(node);
        translateTransition.setDuration(Duration.millis(2000));
        Bounds nodeBound = node.localToScene(node.getBoundsInLocal());
        Bounds targetBound = target.localToScene(target.getBoundsInLocal());
        translateTransition.setByX(targetBound.getCenterX() - nodeBound.getCenterX());
        translateTransition.setByY(targetBound.getCenterY() - nodeBound.getCenterY());
        return translateTransition;
    }

    protected boolean intersects(Node node1, Node node2) {
        return node1.localToScene(node1.getBoundsInLocal()).intersects(node2.localToScene(node2.getBoundsInLocal()));
    }


    protected void attack(){}


}
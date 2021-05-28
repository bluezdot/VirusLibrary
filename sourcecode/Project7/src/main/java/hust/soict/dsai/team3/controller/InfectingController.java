package hust.soict.dsai.team3.controller;


import hust.soict.dsai.team3.model.cell.Cell;
import hust.soict.dsai.team3.model.virus.EnvelopeVirus;
import hust.soict.dsai.team3.model.virus.Virus;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
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

public class InfectingController implements Initializable {
    TranslateTransition translateTransition;
    private Virus virus;
    private Cell cell;

    public InfectingController(Virus virus, Cell cell) {
        this.virus = virus;
        this.cell = cell;
    }

    public InfectingController() {
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        cell.setComponentsSize(300,300,300);


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

        translateTransition = createTranslateTransitionFor(rootVirus, cell.getNucleus());

        if (virus instanceof EnvelopeVirus) {
            envelopeAttack();
        } else {
            nonEnvelopeAttack();
        }

    }

    @FXML
    private StackPane cellPane;

    @FXML
    private ImageView layer;

    @FXML
    private ImageView nucleus;

    @FXML
    private StackPane rootVirus;

    @FXML
    private AnchorPane root;


    private TranslateTransition createTranslateTransitionFor(Node node, Node target) {
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(node);
        translateTransition.setDuration(Duration.millis(2000));
        Bounds nodeBound = node.localToScene(node.getBoundsInLocal());
        Bounds targetBound = target.localToScene(target.getBoundsInLocal());
        translateTransition.setByX(targetBound.getCenterX() - nodeBound.getCenterX());
        translateTransition.setByY(targetBound.getCenterY() - nodeBound.getCenterY());
        return translateTransition;
    }

    private boolean intersects(Node node1, Node node2) {
        return node1.localToScene(node1.getBoundsInLocal()).intersects(node2.localToScene(node2.getBoundsInLocal()));
    }

    void envelopeAttack() {


        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(400),
                (evt) -> {
                    translateTransition.play();
                    if (intersects(rootVirus, cell.getLayer())) {
                        virus.attack(cell);
                    }
                    if (intersects(rootVirus, cell.getCenter())) {
                        translateTransition.pause();
                        cell.addInfectVirus(virus);
                    }

                })
        );
        timeline.setCycleCount(20);  //Animation.INDEFINITE
        timeline.play();
    }

    void nonEnvelopeAttack() {


        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(400),
                (evt) -> {
                    translateTransition.play();
                    if (intersects(rootVirus, cell.getMembrane())) {
                        virus.attack(cell);

                    }

                    if (intersects(rootVirus, cell.getNucleus())) {
                        translateTransition.stop();
                        virus.setVisible(false);
                        root.getChildren().add(infectCell());


                    }

                })
        );
        timeline.setCycleCount(20);  //Animation.INDEFINITE
        timeline.play();
    }

    StackPane infectCell() {
        StackPane sPane = new StackPane();
        Cell cell = new Cell(this.cell);
        cell.setComponentsSize(300,300,300);
        sPane.getChildren().add(cell);
        virus.attack(cell);
        int max = 400;
        int min = 0;
        sPane.setTranslateX(((Math.random() * (max - min)) + min));
        sPane.setTranslateY(((Math.random() * (max - min)) + min));
        return sPane;
    }
}
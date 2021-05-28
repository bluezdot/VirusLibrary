package test;

import hust.soict.dsai.team3.model.cell.Cell;
import hust.soict.dsai.team3.model.virus.Virus;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.geometry.Bounds;
import javafx.scene.Node;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.util.Duration;

import java.net.URL;
import java.util.ResourceBundle;

public class InfectingControllerTest implements Initializable {
    TranslateTransition translateTransition;
    private Virus virusClass;
    private Cell cellClass;

    public InfectingControllerTest(Virus virus, Cell cell){
        this.virusClass = virus;
        this.cellClass = cell;
    }

    public InfectingControllerTest(){}

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        cellClass.getLayer().setFitHeight(300);
        cellClass.getLayer().setPreserveRatio(true);
        cellClass.getNucleus().setFitHeight(130);
        cellClass.getNucleus().setPreserveRatio(true);
//        cellClass.getMembrane().setVisible(false);

        cell.getChildren().clear();
        cell.getChildren().add(cellClass);

        rootVirus.getChildren().clear();
        virusClass.setFitWidth(34);
        virusClass.setPreserveRatio(true);
        rootVirus.getChildren().add(virusClass);

        translateTransition = createTranslateTransitionFor(rootVirus, cellClass.getNucleus());

        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(400),
                (evt) -> {
                    translateTransition.play();
                    if (intersects(rootVirus, cellClass.getLayer())){
                        virusClass.attack(cellClass);
                    }
                    if (intersects(rootVirus, cellClass.getNucleus())){
                        translateTransition.pause();
                        cellClass.addInfectVirus(virusClass);
                    }

                })
        );
        timeline.setCycleCount(20);  //Animation.INDEFINITE
        timeline.play();


    }

    @FXML
    private StackPane cell;

    @FXML
    private ImageView layer;

    @FXML
    private ImageView nucleus;

    @FXML
    private StackPane cloneVirus2;

    @FXML
    private StackPane cloneVirus1;

    @FXML
    private StackPane rootVirus;


    private TranslateTransition createTranslateTransitionFor(Node node, Node target){
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(node);
        translateTransition.setDuration(Duration.millis(1000));
        Bounds nodeBound = node.localToScene(node.getBoundsInLocal());
        Bounds targetBound = target.localToScene(target.getBoundsInLocal());
        translateTransition.setByX(targetBound.getCenterX() - nodeBound.getCenterX());
        translateTransition.setByY(targetBound.getCenterY() - nodeBound.getCenterY());
        return translateTransition;
    }

    private boolean intersects(Node node1, Node node2){
        return node1.localToScene(node1.getBoundsInLocal()).intersects(node2.localToScene(node2.getBoundsInLocal()));
    }
}
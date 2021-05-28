package test;

import hust.soict.dsai.team3.model.virus.Virus;
import javafx.animation.*;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Group;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.shape.CubicCurveTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.util.Duration;

public class TestController {
    PathTransition pathTransition;
    TranslateTransition translateTransition;
    private int _dy = 3;
    private Virus virus_class;
//    public final Image AN = new Image(getClass().getClassLoader().getResource("virus/HIV/HIV_ARN.png").toString());
//    public final Image CAPSID = new Image(getClass().getClassLoader().getResource("virus/HIV/HIV_capsid.png").toString());
//    public final Image ENVELOPE = new Image(getClass().getClassLoader().getResource("virus/HIV/HIV_envelope_glicoprotein.png").toString());
//    public final Image ENZIME = new Image(getClass().getClassLoader().getResource("virus/HIV/HIV_enzim.png").toString());
//    public final Image LAYER = new Image(getClass().getClassLoader().getResource("virus/HIV/HIV_layer.png").toString());

    public TestController(Virus virus) {
        this.virus_class = virus;
    }

    @FXML
    private void initialize() throws  Exception{
//        ClassLoader classLoader = Thread.currentThread().getContextClassLoader();
//        File file = new File(classLoader.getResource("virus/HIV/AcidNucleic/info.txt").getFile());
//        String testAN_info = new String(Files.readAllBytes(file.toPath()));
//        AcidNucleic testAN = new AcidNucleic("virus/HIV/AcidNucleic/overview.png", testAN_info, ANType.ARN);



//        System.out.println(testAN.toString());
        an.setImage(virus_class.getOverviewImageOf("AcidNucleic"));
        envelope.setImage(virus_class.getOverviewImageOf("Envelope"));
        enzim.setImage(virus_class.getOverviewImageOf("Enzime"));
//        layer.setImage(LAYER);
        capsid.setImage(virus_class.getOverviewImageOf("Capsid"));
        initPathTransition();
        cell.setImage(new Image("cell/cell.png"));
        translateTransition = createTranslateTransitionFor(virus, cell);
    }

    @FXML
    private ImageView cell;

//    @FXML
//    private Pane paneTest;

    @FXML
    private Group virus;

    @FXML
    private ImageView envelope;

    @FXML
    private ImageView enzim;

    @FXML
    private ImageView layer;

    @FXML
    private ImageView capsid;

    @FXML
    private ImageView an;

    @FXML
    void runAnimate(ActionEvent event) {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(10),
                (evt) -> {
//            virus.setLayoutY(virus.getLayoutY() + _dy);
//            virus.setLayoutX(virus.getLayoutX() + _dy);
                    translateTransition.play();
            if (virus.getBoundsInParent().intersects(cell.getBoundsInParent())){
                translateTransition.pause();
                _dy = 0;
            }
                })
        );
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        System.out.println(virus_class.getOverviewImageOf("Capsid").toString());
//        translateTransition.play();





    }


    @FXML
    void stopAnimate(ActionEvent event) {
        translateTransition.pause();
    }

    void initPathTransition(){
        Path path = new Path();
        path.getElements().add(new MoveTo(20,20));
        path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
        path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
        pathTransition = new PathTransition();
        pathTransition.setDuration(Duration.millis(4000));
        pathTransition.setPath(path);
        pathTransition.setNode(virus);
        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
        pathTransition.setCycleCount(Timeline.INDEFINITE);
        pathTransition.setAutoReverse(true);
    }

    private TranslateTransition createTranslateTransitionFor(Group node, ImageView target){
        TranslateTransition translateTransition = new TranslateTransition();
        translateTransition.setNode(node);
        translateTransition.setDuration(Duration.millis(1000));
        translateTransition.setByX(target.getLayoutX() - node.getLayoutX());
        translateTransition.setByY(target.getLayoutY() - node.getLayoutY());

//            translateTransition.setByX(250);
//        translateTransition.play();
        return translateTransition;
    }


}

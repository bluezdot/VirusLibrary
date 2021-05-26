package sample;

import hust.soict.dsai.team3.model.virus.Virus;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Test extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        Virus hiv = new Virus(getClass().getClassLoader().getResource("virus/HIV/").getFile());
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("virus/group_virus.fxml"));
        TestController testController = new TestController(hiv);
        loader.setController(testController);
        Parent root = loader.load();
        primaryStage.setTitle("Virus Demonstration");

        Scene scene = new Scene(root);
        primaryStage.setScene(scene);


//        final Rectangle rectPath = new Rectangle (0, 0, 40, 40);
//        rectPath.setArcHeight(10);
//        rectPath.setArcWidth(10);
//        rectPath.setFill(Color.ORANGE);
//        final Image virusImage = new Image("MainScreen/envelope_virus.png");
//
//        Path path = new Path();
//        path.getElements().add(new MoveTo(20,20));
//        path.getElements().add(new CubicCurveTo(380, 0, 380, 120, 200, 120));
//        path.getElements().add(new CubicCurveTo(0, 120, 0, 240, 380, 240));
//        PathTransition pathTransition = new PathTransition();
//        pathTransition.setDuration(Duration.millis(4000));
//        pathTransition.setPath(path);
//        pathTransition.setNode(rectPath);
//        pathTransition.setOrientation(PathTransition.OrientationType.ORTHOGONAL_TO_TANGENT);
//        pathTransition.setCycleCount(Timeline.INDEFINITE);
//        pathTransition.setAutoReverse(true);
//        pathTransition.play();
//
//        Pane root = new Pane();
//        root.getChildren().add(rectPath);


//        primaryStage.setScene((scene));
        primaryStage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}

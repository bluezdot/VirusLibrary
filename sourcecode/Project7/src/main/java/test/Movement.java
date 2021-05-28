package test;

import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class Movement extends Application {

    public static final int WIDTH = 600;
    public static final int HEIGHT = 400;
    public final Image AN = new Image(getClass().getClassLoader().getResource("virus/HIV/rna.png").toString());
    public final Image CAPSID = new Image(getClass().getClassLoader().getResource("virus/HIV/ca_all.png").toString());
    public final Image ENVELOPE = new Image(getClass().getClassLoader().getResource("virus/HIV/su-all.png").toString());
    public final Image ENZIME = new Image(getClass().getClassLoader().getResource("virus/HIV/rt_all.png").toString());
//    public final Image LAYER = new Image(getClass().getClassLoader().getResource("virus/HIV/HIV_layer.png").toString());


    private Group virus;
    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) {
        ImageView an = new ImageView(AN);
        ImageView capsid = new ImageView(CAPSID);
        ImageView envelope = new ImageView(ENVELOPE);
        ImageView enzime = new ImageView(ENZIME);
//        ImageView layer = new ImageView(LAYER);

        setMiddle(an, capsid, envelope);


        virus = new Group(an, capsid, envelope, enzime);
//        virus = new Group(enzime);
//        virus.setTranslateX(200);
//        virus.setTranslateY(250);

        primaryStage.setScene(new Scene(virus, WIDTH, HEIGHT));

        primaryStage.setTitle("Test virus");

        primaryStage.show();
    }

    void setMiddle(ImageView img){
        img.setX(WIDTH / 2);
        img.setY(HEIGHT / 2);
    }

    void setMiddle(ImageView... imgs){
        for (ImageView img : imgs){
            setMiddle(img);
        }
    }
}

package hust.soict.dsai.team3.screen;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import hust.soict.dsai.team3.controller.MainScreenController;

public class MainScreen extends Application {

    Stage primaryStage;
    // Scene scene1, scene2, scene3;

    @Override
    public void start(Stage primaryStage) {

        // window = primaryStage;

        try {
            FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("/sample/MainScreen.fxml"));
            MainScreenController controller = new MainScreenController();
            fxmlloader.setController(controller);
            Parent root = fxmlloader.load();
            Scene scene = new Scene(root);

            primaryStage.setTitle("VIRUS INVESTIGATION");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }

        // Set X close confirmation
        primaryStage.setOnCloseRequest(event -> {
            JFrame frame = new JFrame();
            int n = JOptionPane.showConfirmDialog(
                    frame,
                    "Do you want to exit the program ?",
                    "Exit application",
                    JOptionPane.YES_NO_OPTION);
            if(n == 0){
                // close application when user confirm "Yes"
                System.out.println(n);
                System.exit(0);
            }
            else{
                // cancel the application exit when user click "No"
                event.consume();
            }
        });


    }

    public static void main(String[] args) {
        launch(args);
    }
}

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javafx.application.Application;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import javafx.stage.WindowEvent;
 
public class MainScreen extends Application {

	// @Override
	// public void start(Stage primaryStage) {
	// 	try {
	// 		FXMLLoader fxmlloader = new FXMLLoader(getClass().getResource("MainScreen.fxml"));
	// 		MainScreenController controller = new MainScreenController();		
	// 		fxmlloader.setController(controller);
	// 		Parent root = fxmlloader.load();
	// 		Scene scene = new Scene(root);

	// 		primaryStage.setTitle("Main Screen");
	// 		primaryStage.setScene(scene);
	// 		primaryStage.show();
	// 	} catch (Exception e) {
	// 		e.printStackTrace();
	// 	}

	// }
	private Stage stage;

    @Override
	public void start(Stage stage) throws Exception {
        this.stage = stage;
		Parent root = FXMLLoader.load(getClass().getResource("MainScreen.fxml"));

		Scene scene = new Scene(root);
		stage.setTitle("VIRUS LIBRARY");
		stage.setScene(scene);
		stage.show();

    
	// Set X close confirmation 
    stage.setOnCloseRequest(new EventHandler<WindowEvent>() {
        @Override
        public void handle(WindowEvent event) {
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
        }
    });

	}

	public static void main(String[] args) {
		launch(args);
	}
}
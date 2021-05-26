import java.net.URL;
import java.util.ResourceBundle;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;

public class MainScreenController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private MenuItem itemAim;

    @FXML
    private Button btnWithoutEnvelope;

    @FXML
    private Button btnWithEnvelope;

    @FXML
    private MenuItem itemUsage;


    // Handle Menu: usage and aim button on pressed
    
    @FXML
    void itemUsageOnPressed(ActionEvent event) {
        JFrame frame = new JFrame();
			 JOptionPane.showMessageDialog(frame, "message", "Usage", JOptionPane.INFORMATION_MESSAGE);
    }

    // @FXML
    // void itemAimOnPressed(ActionEvent event) {

    // }

    @FXML
    void initialize() {
        assert itemAim != null : "fx:id=\"itemAim\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert btnWithoutEnvelope != null : "fx:id=\"btnWithoutEnvelope\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert btnWithEnvelope != null : "fx:id=\"btnWithEnvelope\" was not injected: check your FXML file 'MainScreen.fxml'.";
        assert itemUsage != null : "fx:id=\"itemUsage\" was not injected: check your FXML file 'MainScreen.fxml'.";

    }
}

package hust.soict.dsai.team3.controller;

import hust.soict.dsai.team3.model.cell.Cell;
import hust.soict.dsai.team3.model.virus.Virus;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.geometry.Pos;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.MenuItem;
import javafx.scene.control.TextArea;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import javax.swing.*;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.ResourceBundle;

public class StructureController implements Initializable {
    protected Virus virus;
    protected Stage stage;
    protected ImageView primaryView;
    protected ImageView hoverView;
    protected Boolean presentMode = false;
    protected HashMap<String, Button> btnComponents = new HashMap<>();


    public StructureController(Virus virus) {
        this.virus = virus;
    }

    @FXML
    protected Button btnRepeatInfecting;

    @FXML
    protected Button changeCenter;

    @FXML
    protected BorderPane borderPane;

    @FXML
    protected VBox center;

    @FXML
    protected Button btnReturn;

    @FXML
    private MenuItem itemAim;

    @FXML
    private MenuItem itemProblem;

    @FXML
    private MenuItem itemUsage;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        primaryView = new ImageView(virus.getOverviewImage());
        center.getChildren().add(primaryView);
        hoverView = new ImageView();

        for (String component : virus.getComponents().keySet()){
            btnComponents.put(component, new Button(component));
            setHoverProperty(btnComponents.get(component), component);
            btnComponents.get(component).setOnAction(e -> {
                setCenterPic(e, component);
            });
        }

        GridPane left = new GridPane();
        int start = 0;
        for (Button button : btnComponents.values()){
            left.add(button, 0, start++);
        }
        left.setVgap(10);
        left.setAlignment(Pos.CENTER);
        borderPane.setLeft(left);
        BorderPane.setAlignment(left, Pos.CENTER);
    }

    public void setStage(Stage stage) {
        this.stage = stage;
    }

    @FXML
    void showInfectingProcess(ActionEvent event) throws Exception{

        if (changeCenter.getText().contains("Infecting")) {
            Cell cell = new Cell(getClass().getClassLoader().getResource("cell/Cell").getFile());
            FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/infectingOld.fxml"));
            InfectingController infectingController = new InfectingController(virus, cell);
            loader.setController(infectingController);
            Parent root = loader.load();
            borderPane.setCenter(root);
            borderPane.getLeft().setVisible(false);
            changeCenter.setText("Return to Virus Structure");
            btnRepeatInfecting.setVisible(true);
        }
        else {
            borderPane.setCenter(center);
            borderPane.getLeft().setVisible(true);
            changeCenter.setText("Show Infecting Process");
            btnRepeatInfecting.setVisible(false);
        }
    }

    // Add return to virus select action
    @FXML
    void btnReturnOnPressed(ActionEvent event) throws IOException {

        Stage primaryStage = (Stage) btnReturn.getScene().getWindow();
        FXMLLoader fxmlloader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/MainScreen.fxml"));

        MainScreenController controller = new MainScreenController();
        fxmlloader.setController(controller);
        Parent root = fxmlloader.load();
        Scene scene = new Scene(root);

        primaryStage.setTitle("VIRUS MAIN MENU");
        primaryStage.setScene(scene);
        primaryStage.show();
    }

    @FXML
    protected  void repeatInfecting(ActionEvent event) throws Exception{
        Cell cell = new Cell(getClass().getClassLoader().getResource("cell/Cell").getFile());
        FXMLLoader loader = new FXMLLoader(getClass().getClassLoader().getResource("fxml/infectingOld.fxml"));
        InfectingController infectingController = new InfectingController(virus, cell);
        loader.setController(infectingController);
        Parent root = loader.load();
        borderPane.setCenter(root);
        changeCenter.setText("Return to Virus Structure");
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

    protected void setHoverProperty(Node node, String component){
        node.hoverProperty().addListener((javafx.beans.value.ChangeListener<? super Boolean>) (observable, oldValue, newValue) -> {
            setHoverPic(newValue, component);
        });
    }

    // Handle main menu items

    @FXML
    void itemUsageOnPressed(ActionEvent event) {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,
                "Updating",
                "Usage",
                JOptionPane.INFORMATION_MESSAGE);
    }

    @FXML
    void itemAimOnPressed(ActionEvent event) {
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,
                "Investigate structure of viruses and how they infect to cell",
                "Aim",
                JOptionPane.INFORMATION_MESSAGE);
    }

    @FXML
    void itemProblemOnPressed(ActionEvent event){
        JFrame frame = new JFrame();
        JOptionPane.showMessageDialog(frame,
                "COVID-19 has been spreading all over the world and there is the need of understanding \n" +
                        "different type of viruses, as well as the way they infect in order to have the basic knowledge to \n" +
                        "prevent them",
                "Problem",
                JOptionPane.INFORMATION_MESSAGE);
    }
}

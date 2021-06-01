package hust.soict.dsai.team3.controller;

import hust.soict.dsai.team3.model.cell.Cell;
import hust.soict.dsai.team3.model.virus.Virus;
import javafx.scene.layout.StackPane;

public class NonEnvelopeInfectingController extends InfectingController{


    public NonEnvelopeInfectingController(Virus virus, Cell cell) {
        super(virus, cell);
    }

    StackPane infectCell() {
        StackPane sPane = new StackPane();
        Cell cell = new Cell(this.cell);
        cell.setComponentsSize(300, 300, 300);
        sPane.getChildren().add(cell);
        virus.attack(cell);
        int maxX = 400;
        int maxY = 300;
        int min = 0;
        sPane.setTranslateX(((Math.random() * (maxX - min)) + min));
        sPane.setTranslateY(((Math.random() * (maxY - min)) + min));
        return sPane;
    }


    @Override
    protected void attack() {
        super.attack();
        timeline.setOnFinished((actionEvent -> {
            virus.setVisible(false);
            root.getChildren().add(infectCell());
        }));
        timeline.play();
    }
}

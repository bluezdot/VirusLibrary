package hust.soict.dsai.team3.controller;

import hust.soict.dsai.team3.model.cell.Cell;
import hust.soict.dsai.team3.model.virus.Virus;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

public class EnvelopeInfectingController extends InfectingController{


    public EnvelopeInfectingController(Virus virus, Cell cell) {
        super(virus, cell);
    }

    @Override
    protected void attack() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(400),
                (evt) -> {
                    translateTransition.play();
                    if (intersects(rootVirus, cell.getLayer())) {
                        virus.attack(cell);
                    }
                    if (intersects(rootVirus, cell.getCenter())) {
                        translateTransition.pause();
//                        cell.addInfectVirus(virus);
                    }
                })
        );
        timeline.setCycleCount(20);  //Animation.INDEFINITE
        timeline.play();
    }
}

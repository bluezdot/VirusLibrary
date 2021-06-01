package hust.soict.dsai.team3.controller;

import hust.soict.dsai.team3.model.cell.Cell;
import hust.soict.dsai.team3.model.virus.Virus;

public class EnvelopeInfectingController extends InfectingController{


    public EnvelopeInfectingController(Virus virus, Cell cell) {
        super(virus, cell);
    }


    @Override
    protected void attack() {
        super.attack();
        timeline.play();
    }
}

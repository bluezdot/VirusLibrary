package hust.soict.dsai.team3.model.cell;

import hust.soict.dsai.team3.model.cell.structure.Layer;
import hust.soict.dsai.team3.model.cell.structure.Membrane;
import hust.soict.dsai.team3.model.cell.structure.Nucleus;

public class Cell {
    private Nucleus nucleus;
    private Membrane membrane;
    private Layer layer;

    public Layer getLayer() {
        return layer;
    }

    public Nucleus getNucleus() {
        return nucleus;
    }

    public Membrane getMembrane() {
        return membrane;
    }
}

package hust.soict.dsai.team3.model.cell;

import hust.soict.dsai.team3.model.cell.structure.CellComponent;
import hust.soict.dsai.team3.model.cell.structure.Layer;
import hust.soict.dsai.team3.model.cell.structure.Membrane;
import hust.soict.dsai.team3.model.cell.structure.Nucleus;
import hust.soict.dsai.team3.model.virus.EnvelopeVirus;
import hust.soict.dsai.team3.model.virus.NonEnvelopeVirus;
import hust.soict.dsai.team3.model.virus.Virus;
import javafx.scene.image.Image;
import javafx.scene.layout.StackPane;

import java.io.File;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Cell extends StackPane{
    public static final String NUCLEUS = "Nucleus";
    public static final String MEMBRANE = "Membrane";
    public static final String LAYER = "Layer";
    protected String dirPath;
    protected HashMap<String, CellComponent> cellComponentHashMap = new HashMap<>();
    protected Image overview;
    private List<Virus> infectVirus = new ArrayList<>();
    private Boolean isInfected = false;

    public Cell(String dirPath){
        this.dirPath = dirPath;
        try {
            readData(dirPath);
        } catch (Exception e){
            e.printStackTrace();
        }

        this.prefHeight(150);
        this.prefWidth(200);
        for (CellComponent component : cellComponentHashMap.values()){
            this.getChildren().add(component);
        }
        getLayer().toFront();
        getNucleus().toFront();
    }

    public Cell(Cell that){
        this(that.dirPath);
    }

    protected void readData(String dirPath) throws Exception{
        File folder = new File(dirPath);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles){
            if (file.isDirectory()){
                switch (file.getName()){
                    case NUCLEUS:
                        cellComponentHashMap.put(file.getName(), Nucleus.parse(file));
                        break;
                    case MEMBRANE:
                        cellComponentHashMap.put(file.getName(), Membrane.parse(file));
                        break;
                    case LAYER:
                        cellComponentHashMap.put(file.getName(), Layer.parse(file));
                        break;
                    default:
                        cellComponentHashMap.put(file.getName(), CellComponent.parse(file));
                }

            }
            else {
                this.overview = new Image(file.toURI().toURL().toExternalForm());
            }
        }
    }

    public Layer getLayer() {
        return (Layer) cellComponentHashMap.get(LAYER);
    }

    public Nucleus getNucleus() {
        return (Nucleus) cellComponentHashMap.get(NUCLEUS);
    }

    public Membrane getMembrane() {
        return (Membrane) cellComponentHashMap.get(MEMBRANE);
    }

    public CellComponent getCenter() { return cellComponentHashMap.get("Center");};

    public void setInfected(Boolean infected) {
        isInfected = infected;
        for (CellComponent component : cellComponentHashMap.values()){
            component.setInfected(infected);
        }
    }

    public void addInfectVirus(Virus virus){
        Virus newVirus;
        if (virus instanceof EnvelopeVirus) {
            newVirus = new EnvelopeVirus((EnvelopeVirus) virus);
        } else {
            newVirus = new NonEnvelopeVirus((NonEnvelopeVirus) virus);
        }
        newVirus.setFitWidth(34);
        newVirus.setPreserveRatio(true);
        infectVirus.add(newVirus);
        this.getChildren().add(newVirus);
        int max = 70;
        int min = -70;
        newVirus.setTranslateX(((Math.random() * (max - min)) + min));
        newVirus.setTranslateY(((Math.random() * (max - min)) + min));
    }

    public void setComponentsSize(double x1, double x2, double x3){
        this.getNucleus().setSize(x1);
        this.getLayer().setSize(x2);
        this.getMembrane().setSize(x3);
    }


}

package hust.soict.dsai.team3.model.cell.structure;

import hust.soict.dsai.team3.model.virus.structure.AcidNucleic;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

import java.io.File;

public class Nucleus extends CellComponent{
    private AcidNucleic injectAN;

    public Nucleus(String urlNormal, String urlInfected, String name){
        normal = new Image(urlNormal);
        infected = new Image(urlInfected);
        this.name = name;
        this.setImage(normal);
    }

    public static Nucleus parse(File folder) throws Exception{
        String normal = "";
        String infected = "";
        File[] files = folder.listFiles();
        for (File file : files){
            if (file.isFile())

                if (file.getName().equals("normal.png")){
                    normal = file.toURI().toURL().toExternalForm();
                }
                else if (file.getName().equals("infected.png")){
                    infected = file.toURI().toURL().toExternalForm();
                }


        }
        return new Nucleus(normal,infected, folder.getName());
    }

    public void setInjectAN(AcidNucleic injectAN) {
        Double height = this.getFitWidth();
        Double width = this.getFitWidth();
        Canvas canvas = new Canvas(width, height);
        canvas.getGraphicsContext2D().drawImage(this.getInfectedImage(), 0, 0, width, height);
        canvas.getGraphicsContext2D().drawImage(injectAN.getDetailImage(), width / 2.2, height / 2.2, width /8, height / 8 );
        SnapshotParameters params = new SnapshotParameters();
        params.setFill(Color.TRANSPARENT);
        setImage(canvas.snapshot(params, null));
        this.injectAN = injectAN;
    }
}

package hust.soict.dsai.team3.model.cell.structure;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;

public class CellComponent extends ImageView {
    protected Image normal;
    protected Image infected;
    protected String name;
    protected Boolean isInfected = false;
    public CellComponent(){}

    public CellComponent(String urlNormal, String urlInfected, String name){
        normal = new Image(urlNormal);
        infected = new Image(urlInfected);
        this.name = name;
        this.setPreserveRatio(true);
        this.setImage(normal);
    }


    public static CellComponent parse(File folder) throws Exception{
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
        return new CellComponent(normal,infected, folder.getName());
    }

    public Image getNormalImage() {
        return normal;
    }

    public Image getInfectedImage() {
        return infected;
    }

    public void setInfected(Boolean blinfected) {
        isInfected = blinfected;
        if (isInfected){
            setImage(infected);
        }else{
            setImage(normal);
        }
    }

    public void setSize(double x1){
        this.setFitWidth(x1);
        this.setPreserveRatio(true);
    }
}

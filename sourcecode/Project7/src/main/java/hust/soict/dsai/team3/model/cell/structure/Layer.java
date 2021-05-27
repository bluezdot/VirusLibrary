package hust.soict.dsai.team3.model.cell.structure;

import javafx.scene.image.Image;

import java.io.File;

public class Layer extends CellComponent{


    public Layer(String urlNormal, String urlInfected, String name){
        normal = new Image(urlNormal);
        infected = new Image(urlInfected);
        this.name = name;
        this.setImage(normal);
    }

    public static Layer parse(File folder) throws Exception{
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
        return new Layer(normal,infected, folder.getName());
    }

}

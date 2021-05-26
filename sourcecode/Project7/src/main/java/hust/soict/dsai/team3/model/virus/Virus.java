package hust.soict.dsai.team3.model.virus;

import hust.soict.dsai.team3.model.virus.structure.*;
import javafx.scene.image.Image;

import java.io.File;
import java.util.HashMap;

public class Virus {
    public static final String ACID_NUCLEIC = "AcidNucleic";
    public static final String CAPSID = "Capsid";
    public static final String ENZIME = "Enzime";
    protected String dirPath;
    protected HashMap<String, VirusComponent> virusComponentHashMap = new HashMap<>();
    protected Image overview;
    protected String name;
    public Virus(String dirPath){
        this.dirPath = dirPath;
        try {
            readData(dirPath);
        } catch (Exception e){
            e.printStackTrace();
        }
    }

    public Virus(Virus that){
        this(that.dirPath);
    }

    protected void readData(String dirPath) throws Exception{
        File folder = new File(dirPath);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles){
            if (file.isDirectory()){
                switch (file.getName()){
                    case ACID_NUCLEIC:
                        virusComponentHashMap.put(file.getName(), AcidNucleic.parse(file));
                        break;
                    case CAPSID:
                        virusComponentHashMap.put(file.getName(), Capsid.parse(file));
                        break;
                    case ENZIME:
                        virusComponentHashMap.put(file.getName(), Enzime.parse(file));
                        break;
                    default:
                        virusComponentHashMap.put(file.getName(), VirusComponent.parse(file));
                }

            }
            else {
                this.overview = new Image(file.toURI().toURL().toExternalForm());
            }
        }
    }

    public Image getOverviewImageOf(String component){
        if (virusComponentHashMap.containsKey(component)){
            return virusComponentHashMap.get(component).getOverviewImage();
        }
        else {
            return null;
        }
    }

    public Image getDetailImageOf(String component){
        if (virusComponentHashMap.containsKey(component)){
            return virusComponentHashMap.get(component).getDetailImage();
        }
        else {
            return null;
        }
    }

    public VirusComponent getComponent(String component){
        if (virusComponentHashMap.containsKey(component)){
            return virusComponentHashMap.get(component);
        }
        else {
            return null;
        }
    }

    public Image getOverviewImage() {
        return overview;
    }
}

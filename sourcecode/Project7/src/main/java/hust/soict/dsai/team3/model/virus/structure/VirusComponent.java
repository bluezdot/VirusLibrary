package hust.soict.dsai.team3.model.virus.structure;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.nio.file.Files;


public class VirusComponent extends ImageView {
    protected Image overview;
    protected Image detail;
    protected String info;
    protected String name;

    public VirusComponent(String urlOverview, String urlDetail, String info, String name){
        overview = new Image(urlOverview);
        detail = new Image(urlDetail);
        this.info = info;
        this.name = name;
        setImage(detail);
    }

    @Override
    public String toString() {
        return this.name + " :" +
                "\n\tInfo: " + this.info + "\n";
    }


    public static VirusComponent parse(File folder) throws Exception{
        String info = "";
        String overview = "";
        String detail = "";
        File[] files = folder.listFiles();
        for (File file : files){
            if (file.isFile())
                if (file.getName().equals("info.txt")){
                     info = new String(Files.readAllBytes(file.toPath()));
                }
                else if (file.getName().equals("overview.png")){
                    overview = file.toURI().toURL().toExternalForm();
                }
                else if (file.getName().equals("detail.png")){
                    detail = file.toURI().toURL().toExternalForm();
                }


        }
        return new VirusComponent(overview,detail, info, folder.getName());
    }

    public Image getDetailImage() {
        return detail;
    }

    public Image getOverviewImage() {
        return overview;
    }
}

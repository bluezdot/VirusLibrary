package hust.soict.dsai.team3.model.virus.structure;

import java.io.File;
import java.nio.file.Files;

public class Capsid extends VirusComponent{
    public Capsid(String urlOverview, String urlDetail, String info, String name){
        super(urlOverview,urlDetail, info, name);
    }

    public static Capsid parse(File folder) throws Exception{
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
        return new Capsid(overview,detail, info, folder.getName());
    }

}

package hust.soict.dsai.team3.model.virus.structure;

import hust.soict.dsai.team3.model.cell.Cell;
import hust.soict.dsai.team3.model.virus.AttackCell;

import java.io.File;
import java.nio.file.Files;

public class AcidNucleic extends VirusComponent implements AttackCell {
    public AcidNucleic(String urlOverview, String urlDetail, String info, String name){
        super(urlOverview,urlDetail, info, name);
    }

    public static AcidNucleic parse(File folder) throws Exception{
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
        return new AcidNucleic(overview,detail, info, folder.getName());
    }

    @Override
    public void attack(Cell cell) {
        cell.getNucleus().setInjectAN(this);
    }
}

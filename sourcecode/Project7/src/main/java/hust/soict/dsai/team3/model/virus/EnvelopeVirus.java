package hust.soict.dsai.team3.model.virus;

import hust.soict.dsai.team3.model.cell.Cell;
import hust.soict.dsai.team3.model.virus.structure.Envelope;

import java.io.File;

public class EnvelopeVirus extends Virus implements AttackCell {

    public static final String ENVELOPE = "Envelope";

    public EnvelopeVirus(String dirPath) {
        super(dirPath);
    }

    public EnvelopeVirus(EnvelopeVirus eVirus) {
        super(eVirus);
    }

    protected void readEnvelope(String dirPath) throws Exception {
        File folder = new File(dirPath);
        File[] listOfFiles = folder.listFiles();

        for (File file : listOfFiles) {
            if (file.isDirectory() && file.getName().equals(ENVELOPE)) {
                virusComponentHashMap.put(file.getName(), Envelope.parse(file));
                break;
            }
        }
    }

    @Override
    public void attack(Cell cell) {
        cell.setInfected(true);
//        cell.addInfectVirus(this);
    }
}

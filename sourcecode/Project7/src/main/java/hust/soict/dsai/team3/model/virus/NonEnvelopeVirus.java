package hust.soict.dsai.team3.model.virus;

import hust.soict.dsai.team3.model.cell.Cell;
import hust.soict.dsai.team3.model.virus.structure.AcidNucleic;

public class NonEnvelopeVirus extends Virus implements AttackCell {
    public NonEnvelopeVirus(String dirPath) {
        super(dirPath);
    }

    public NonEnvelopeVirus(NonEnvelopeVirus eVirus) {
        this(eVirus.dirPath);
    }

    @Override
    public void attack(Cell cell) {
        cell.setInfected(true);
        setImage(getDetailImageOf(ACID_NUCLEIC));
        this.setFitWidth(34);
        this.setPreserveRatio(true);
//        setVisible(false);
        ((AcidNucleic) virusComponentHashMap.get(ACID_NUCLEIC)).attack(cell);
    }
}

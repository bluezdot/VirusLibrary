package hust.soict.dsai.team3.model.virus;

import hust.soict.dsai.team3.model.cell.Cell;
import hust.soict.dsai.team3.model.virus.structure.AcidNucleic;

public class NonEnvelopeVirus extends Virus implements AttackCell {
    public NonEnvelopeVirus(String dirPath){
        super(dirPath);
    }

    @Override
    public void attack(Cell cell) {
        ((AcidNucleic) virusComponentHashMap.get(ACID_NUCLEIC)).attack(cell);

    }
}

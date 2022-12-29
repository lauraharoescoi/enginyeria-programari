import data.DigitalSignature;
import data.Goal;
import data.Nif;

public class CriminalRecordCertf extends PDFDocument{
    private Nif nif;
    private String name;
    private Goal goal;
    private DigitalSignature digSign;
    private CrimConvictionsColl crimConvs;

    public CriminalRecordCertf (Nif nif, String name, Goal g, DigitalSignature ds, CrimConvictionsColl crmC) {
        this.nif = nif;
        this.name = name;
        this.goal = g;
        this.digSign = ds;
        this.crimConvs = crmC;
    }


}

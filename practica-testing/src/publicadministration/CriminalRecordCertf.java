package publicadministration;

import data.DigitalSignature;
import data.DocPath;
import data.Goal;
import data.Nif;
import data.exceptions.BadPathException;
import java.sql.Date;

public class CriminalRecordCertf extends PDFDocument {
    private Nif nif;
    private String name;
    private Goal goal;
    private DigitalSignature digSign;
    private CrimConvictionsColl crimConvs;
    private CardPayment payment;

    public CriminalRecordCertf(Nif nif, String name, Goal g, DigitalSignature ds, CrimConvictionsColl crmC) throws BadPathException {
        super();
        this.nif = nif;
        this.name = name;
        this.goal = g;
        this.digSign = ds;
        this.crimConvs = crmC;
    }

    public void setDate(Date date) { this.setDate(date); }

    public void setPath(DocPath path) { this.setPath(path); }

    public void setGoal(Goal goal) { this.goal = goal; }

    public void setNif(Nif nif) { this.nif = nif; }

    public void setPayment(CardPayment payment) { this.payment = payment; }
}

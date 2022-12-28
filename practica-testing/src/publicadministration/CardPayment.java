package publicadministration;

import data.Nif;

import java.math.BigDecimal;
import java.sql.Date;

public class CardPayment {

    private final String reference; // The code of the operation
    private final Nif nif; // The nif of the user
    private final Date date; // The date of the operation
    private final BigDecimal imp; // The amount of the operation

    public CardPayment(Nif nif, BigDecimal imp, Date date, String reference) {
        this.nif = nif;
        this.imp = imp;
        this.date = date;
        this.reference = reference;

    }

    public String getReference() {
        return reference;
    }

    public Nif getNif() {
        return nif;
    }

    public Date getDate() {
        return date;
    }

    public BigDecimal getImp() {
        return imp;
    }

    @Override
    public String toString() {
        return "CardPayment{" +
                "reference='" + reference + '\'' +
                ", nif=" + nif.toString() +
                ", date=" + date.toString() +
                ", imp=" + imp.toString() +
                '}';
    } // converts to String
}

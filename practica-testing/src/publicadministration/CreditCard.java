package publicadministration;
import data.Nif;
import data.SmallCode;

import java.util.Date;


public class CreditCard {

    private final Nif nif; // The nif of the user
    private final String cardNumb; // The number of the credit card
    private final Date expirDate; // The expiration date for the credit card
    private final SmallCode svc; // The Safe Verification Code

    public CreditCard (Nif nif, String cardNum, Date expirDate, SmallCode svc) {
        this.nif = nif;
        this.cardNumb = cardNum;
        this.expirDate = expirDate;
        this.svc = svc;
    }

    public Nif getNif() {
        return nif;
    }

    public String getCardNumb() {
        return cardNumb;
    }

    public Date getExpirDate() {
        return expirDate;
    }

    public SmallCode getSvc() {
        return svc;
    }

    @Override
    public String toString() {
        return "CreditCard{" +
                "nif=" + nif.toString() +
                ", cardNumb='" + cardNumb + '\'' +
                ", expirDate=" + expirDate.toString() +
                ", svc=" + svc.toString() +
                '}';
    } // converts to String
}

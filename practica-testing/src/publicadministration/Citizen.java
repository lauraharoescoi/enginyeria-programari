package publicadministration;

import data.Nif;

import java.util.Date;

public class Citizen {

    private Nif nif;
    private Date valDate;
    private String name;
    private String address;
    private String phoneNumber;
    private CreditCard credCard;

    public Citizen(String name, String add, String mobile, Nif nif, Date expDate, CreditCard credCard){
        this.name = name;
        this.nif = nif;
        this.address = add;
        this.phoneNumber = mobile;
        this.valDate = expDate;
        this.credCard =credCard;
    }

    public Nif getNif() { return nif; }

    public Date getExpDate() { return valDate; }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getMobileNumb() {
        return phoneNumber;
    }

    public String toString () {
        return "Person{" +
                "nif=" + nif.toString() +
                ", expDate='" + valDate +
                ", name='" + name  +
                ", address='" + address  +
                ", mobileNumb='" + phoneNumber  +
                '}';

    } // converts to String

    public void setNif(Nif nif) { this.nif = nif; }

    public void setValDate(Date valDate) { this.valDate = valDate; }

    public void setCredCard(CreditCard credCard) { this.credCard = credCard; }

}

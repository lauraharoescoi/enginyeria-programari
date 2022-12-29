package publicadministration;

import data.Nif;

import java.util.Date;

public class Citizen {

    private final Nif nif;
    private final Date expDate;
    private final String name;
    private final String address;
    private final String mobileNumb;

    public Citizen(String name, String add, String mobile, Nif nif, Date expDate){
        this.name = name;
        this.nif = nif;
        this.address = add;
        this.mobileNumb = mobile;
        this.expDate = expDate;
    }

    public Nif getNif() { return nif; }

    public Date getExpDate() { return expDate; }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public String getMobileNumb() {
        return mobileNumb;
    }

    public String toString () {
        return "Person{" +
                "nif=" + nif.toString() +
                ", expDate='" + expDate +
                ", name='" + name  +
                ", address='" + address  +
                ", mobileNumb='" + mobileNumb  +
                '}';

    } // converts to String

}

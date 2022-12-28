package publicadministration;

import data.Nif;

public class Citizen {

    private final Nif nif;
    private final String name;
    private final String address;
    private final String mobileNumb;

    public Citizen (String name, String add, String mobile, Nif nif){
        this.name = name;
        this.nif = nif;
        this.address = add;
        this.mobileNumb = mobile;
    }

    public Nif getNif() {
        return nif;
    }

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
                ", name='" + name  +
                ", address='" + address  +
                ", mobileNumb='" + mobileNumb  +
                '}';

    } // converts to String

}

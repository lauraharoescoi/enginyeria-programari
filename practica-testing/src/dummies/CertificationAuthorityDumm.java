package dummies;

import data.Nif;
import data.SmallCode;
import exceptions.*;
import publicadministration.Citizen;
import services.CertificationAuthority;

import java.util.Date;

public class CertificationAuthorityDumm implements CertificationAuthority {
    Citizen citizen;

    public CertificationAuthorityDumm (Citizen citizen){
        this.citizen=citizen;
    }

    @Override
    public boolean sendPIN(Nif nif, Date date) throws NifNotRegisteredException, IncorrectValDateException, AnyMobileRegisteredException, ConnectException {
        if(citizen.getNif()!=nif) throw new NifNotRegisteredException();
        if(citizen.getExpDate()!=date) throw new IncorrectValDateException();
        if(citizen.getMobileNumb()==null) throw new AnyMobileRegisteredException();
        return true;
    }

    @Override
    public boolean checkPIN(Nif nif, SmallCode pin) throws NotValidPINException, ConnectException {
        if(pin==null) throw new NotValidPINException();
        return true;
    }
}

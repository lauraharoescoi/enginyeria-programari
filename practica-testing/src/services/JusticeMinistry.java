package services;

import data.Goal;
import publicadministration.Citizen;
import exceptions.*;
import publicadministration.CriminalRecordCertf;

public interface JusticeMinistry {

    CriminalRecordCertf getCriminalRecordCertf (Citizen persD, Goal g) throws DigitalSignatureException,ConnectException;

}


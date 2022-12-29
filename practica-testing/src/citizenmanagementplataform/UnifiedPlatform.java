package citizenmanagementplataform;

import data.*;
import exceptions.NotValidPaymentDataException;
import publicadministration.Citizen;
import publicadministration.CreditCard;
import exceptions.*;
import publicadministration.*;
import services.*;

import java.util.*;

public class UnifiedPlatform {

    //The class members
    private Byte authMethod;
    private boolean executing;
    private states currentState;


    public UnifiedPlatform (){
        currentState = states.START;
    }

    // Input events
    public void selectJusMin () throws ProceduralException {
        if(currentState != states.START) throw new ProceduralException();
        currentState = states.SELECTEDJUSTMIN;
    };

    public void selectProcedures () throws ProceduralException {
        if (currentState != states.SELECTEDJUSTMIN) throw new ProceduralException();
        currentState = states.SELECTINGPROCEDURES;
    };

    public void selectCriminalReportCertf () throws ProceduralException {
        if (currentState != states.SELECTINGPROCEDURES) throw new ProceduralException();
        currentState = states.SELECTEDCRIMINALREPORTCERTF;
    };

    public void selectAuthMethod (byte opc) {
        this.authMethod = opc;
    };

    public void enterNIFandPINobt (Nif nif, Date valDate) throws ProceduralException, NifNotRegisteredException, IncorrectValDateException, AnyMobileRegisteredException, ConnectException {
        if (!executing && authMethod != 0) throw new ProceduralException();

    }

    public void enterPIN (SmallCode pin) { . . . } throws NotValidPINException, ConnectException;

    private void enterForm (Citizen citz, Goal goal) { . . . } throws IncompleteFormException, IncorrectVerificationException, ConnectException;

    private void realizePayment () { . . . };

    private void enterCardData (CreditCard cardD) { . . . } throws IncompleteFormException, NotValidPaymentDataException, InsufficientBalanceException, ConnectException;

    private void obtainCertificate () { . . . } throws BadPathException, DigitalSignatureException, ConnectException;

    private void printDocument () { . . . } throws BadPathException, PrintingException;

    // Other internal operations (not required)
    private void registerPayment () { . . . };

    private void openDocument (DocPath path) { . . . } throws BadPathException;

    private void printDocument (DocPath path) { . . . } throws BadPathException, PrintingException;
}

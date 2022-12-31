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
    Citizen citz;
    private GPD policeDepartment;
    private Byte authMethod;
    private boolean executing;
    private states currentState;
    private CertificationAuthority certMethod;

    public UnifiedPlatform (){
        this.citz = new Citizen();
        currentState = states.START;
    }

    // Input events
    public void selectJusMin () throws ProceduralException {
        if(currentState != states.START) throw new ProceduralException();
        currentState = states.SELECTEDJUSTMIN;
        System.out.println("Es fa click en la secció Ministeri de Justicia del mosaïc inicial");
    };

    public void selectProcedures () throws ProceduralException {
        if (currentState != states.SELECTEDJUSTMIN) throw new ProceduralException();
        currentState = states.SELECTINGPROCEDURES;
        System.out.println("Es fa click en l'enllaç Tràmits dins la secció del Ministeri de Justicia");
    };

    public void selectCriminalReportCertf () throws ProceduralException {
        if (currentState != states.SELECTINGPROCEDURES) throw new ProceduralException();
        currentState = states.SELECTEDCRIMINALREPORTCERTF;
        System.out.println("Es selecciona el tramit per a obtindre el certificat d'antecedents penals");
    };

    public void selectAuthMethod (byte opc) {
        this.authMethod = opc;
    };

    public void enterNIFandPINobt (Nif nif, Date valDate) throws ProceduralException, NifNotRegisteredException, IncorrectValDateException, AnyMobileRegisteredException, ConnectException, IncorrectNifException {
        if (currentState == states.SELECTEDCRIMINALREPORTCERTF && authMethod != 0) throw new ProceduralException();
        citz.setNif(nif);  // We set the citizen nif to the one we got through parameter
        citz.setValDate(valDate);  // We set the citizen validation date to the one we got through parameter
        boolean res = certMethod.sendPIN(nif, valDate);
        if (res) {
            System.out.println("[P] S'envia el PIN a l'usuari amb DNI: " + nif.getNif());
        } else {
            throw new ConnectException();
        }
    }

    public void enterPIN (SmallCode pin) throws NotValidPINException, ConnectException, ProceduralException {
        if (currentState == states.REGISTERING && authMethod != 0) throw new ProceduralException();
        boolean res = certMethod.checkPIN(citz.getNif(), pin);
        if (res) {
            System.out.println("[P] El PIN introduït correspon al generat pel sistema per aquest ciutadà i encara està vigent");
        } else {
            System.out.println("[P] El PIN introduït no correspon al generat pel sistema per aquest ciutadà o ja no està vigent");
        }
    }

    private void enterForm (Citizen citz, Goal goal) throws IncompleteFormException, IncorrectVerificationException, ConnectException{
        policeDepartment.verifyData(citz, goal);
    }

    private void realizePayment () { . . . };

    private void enterCardData (CreditCard cardD) throws IncompleteFormException, NotValidPaymentDataException, InsufficientBalanceException, ConnectException{
        CreditCard card = new CreditCard(cardD.getNif(), cardD.getCardNumb(), cardD.getExpirDate(), cardD.getSvc());
        citz.setCredCard(card);

    }

    private void obtainCertificate () { . . . } throws BadPathException, DigitalSignatureException, ConnectException;

    private void printDocument () { . . . } throws BadPathException, PrintingException;

    // Other internal operations (not required)
    private void registerPayment () { . . . };

    private void openDocument (DocPath path) { . . . } throws BadPathException;

    private void printDocument (DocPath path) { . . . } throws BadPathException, PrintingException;
}

package citizenmanagementplataform;

import data.*;
import data.exceptions.BadPathException;
import data.exceptions.DigitalSignatureException;
import data.exceptions.IncorrectNifException;
import exceptions.NotValidPaymentDataException;
import publicadministration.Citizen;
import publicadministration.CreditCard;
import exceptions.*;
import publicadministration.*;
import services.*;

import java.io.IOException;
import java.util.*;

public class UnifiedPlatform {

    //The class members
    Citizen citz;
    private GPD policeDepartment;
    private Byte authMethod;
    private states currentState;
    private CertificationAuthority certMethod;
    private JusticeMinistry ministryMethod;

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
        currentState = states.SELECTINGAUTHMETHOD;
        System.out.println("Es selecciona el tramit per a obtindre el certificat d'antecedents penals");
    };

    public void selectAuthMethod (byte opc) throws ProceduralException {
        if (currentState != states.SELECTINGAUTHMETHOD) throw new ProceduralException();
        this.authMethod = opc;
    };

    public void enterNIFandPINobt (Nif nif, Date valDate) throws ProceduralException, NifNotRegisteredException, IncorrectValDateException, AnyMobileRegisteredException, ConnectException, IncorrectNifException {
        if (currentState == states.SELECTINGAUTHMETHOD && authMethod != 0) throw new ProceduralException();
        citz.setNif(nif);  // We set the citizen nif to the one we got through parameter
        citz.setValDate(valDate);  // We set the citizen validation date to the one we got through parameter
        boolean res = certMethod.sendPIN(nif, valDate);
        if (res) {
            System.out.println("[P] S'envia el PIN a l'usuari amb DNI: " + nif.getNif());
        } else {
            throw new ConnectException();
        }
        currentState = states.ENTERPIN;
    }

    public void enterPIN (SmallCode pin) throws NotValidPINException, ConnectException, ProceduralException {
        if (currentState == states.ENTERPIN && authMethod != 0) throw new ProceduralException();
        boolean res = certMethod.checkPIN(citz.getNif(), pin);
        if (res) {
            System.out.println("[P] El PIN introduït correspon al generat pel sistema per aquest ciutadà i encara està vigent");
        } else {
            System.out.println("[P] El PIN introduït no correspon al generat pel sistema per aquest ciutadà o ja no està vigent");
        }
        currentState = states.ENTERFORM;
    }

    private void enterForm (Citizen citz, Goal goal) throws IncompleteFormException, IncorrectVerificationException, ConnectException, ProceduralException {
        if (currentState != states.ENTERFORM) throw new ProceduralException();
        policeDepartment.verifyData(citz, goal);
        currentState = states.REALIZINGPAYMENT;
    }

    private void realizePayment () throws ProceduralException {
        if (currentState != states.REALIZINGPAYMENT) throw new ProceduralException();
        currentState = states.ENTERCARDDATA;
    };

    private void enterCardData (CreditCard cardD) throws IncompleteFormException, NotValidPaymentDataException, InsufficientBalanceException, ConnectException, ProceduralException {
        if (currentState != states.ENTERCARDDATA) throw new ProceduralException();
        CreditCard card = new CreditCard(cardD.getNif(), cardD.getCardNumb(), cardD.getExpirDate(), cardD.getSvc());
        citz.setCredCard(card);
        currentState = states.OBTAININGCERTIFICATE;
    }

    private void obtainCertificate () throws ProceduralException, IOException, BadPathException, DigitalSignatureException, ConnectException{
        if (currentState != states.OBTAININGCERTIFICATE) throw new ProceduralException();
        CriminalRecordCertf certificate = ministryMethod.getCriminalRecordCertf(citz,);
        openDocument(certificate.getPath());
        currentState = states.PRINTINGDOCUMENT;
    }

    private void printDocument () throws BadPathException, PrintingException{
        //Al pdf diu k no fa falta implementacio???
    }

    // Other internal operations (not required)
    private void registerPayment () {
        //Al pdf diu k no fa falta implementacio???
    };

    private void openDocument (DocPath path) throws BadPathException, IOException {
        PDFDocument certPDF = new PDFDocument();
        certPDF.openDoc(path);

    }

    private void printDocument (DocPath path)throws BadPathException, PrintingException {
        //Al pdf diu k no fa falta implementacio???
    }
}

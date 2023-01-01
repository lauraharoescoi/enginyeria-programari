package dummies;

import exceptions.ConnectException;
import exceptions.InsufficientBalanceException;
import exceptions.NotValidPaymentDataException;
import publicadministration.CardPayment;
import publicadministration.Citizen;
import publicadministration.CreditCard;
import services.CAS;

import java.math.BigDecimal;
import java.util.Date;

public class CASDumm  implements CAS {

    CreditCard creditCard;

    public CASDumm (  CreditCard creditCard){
        this.creditCard=creditCard;
    }


    @Override
    public boolean askForApproval(String nTrans, CreditCard cardData, Date date, BigDecimal imp) throws NotValidPaymentDataException, InsufficientBalanceException, ConnectException {
        if(creditCard.getCardNumb()!=cardData.getCardNumb()) throw new NotValidPaymentDataException();
        if(creditCard.getExpirDate()!=cardData.getExpirDate()) throw new NotValidPaymentDataException();
        if (creditCard.getSvc()!=cardData.getSvc()) throw new NotValidPaymentDataException();
        return true;
    }
}

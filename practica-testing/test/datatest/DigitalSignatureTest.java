package datatest;
import data.DigitalSignature;
import data.DocPath;
import exceptions.DigitalSignatureException;
import org.junit.jupiter.api.Test;

import java.security.Signature;

import static org.junit.jupiter.api.Assertions.*;

public class DigitalSignatureTest {

    @Test
    void testCorrectSignature() {

    }

    @Test
    void testNullThrowsDigitalSignatureException(){
        DigitalSignature signature = new DigitalSignature(null);
        Throwable exception = assertThrows(DigitalSignatureException.class, signature::getSignature);
        assertEquals("The digital signature is null", exception.getMessage());
    }

}

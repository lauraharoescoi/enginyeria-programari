package datatest;
import data.DocPath;
import data.Nif;
import exceptions.BadPathException;
import exceptions.DigitalSignatureException;
import exceptions.IncorrectNifException;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class NifTest {

    @Test
    void testCorrectNif () throws IncorrectNifException {
        Nif nif = new Nif("12345678A");
        assertEquals("12345678A", nif.getNif());
    }

    @Test
    void testShortNif (){
        Nif nif = new Nif("1234567A");
        Throwable exception = assertThrows(IncorrectNifException.class, nif::getNif);
        assertEquals("The NIF is incorrect", exception.getMessage());
    }

    @Test
    void testLongNif (){
        Nif nif = new Nif("123456789A");
        Throwable exception = assertThrows(IncorrectNifException.class, nif::getNif);
        assertEquals("The NIF is incorrect", exception.getMessage());
    }

    @Test
    void testNifWithLetters (){
        Nif nif = new Nif("1234567Aa");
        Throwable exception = assertThrows(IncorrectNifException.class, nif::getNif);
        assertEquals("The NIF is incorrect", exception.getMessage());
    }

    @Test
    void testNifWithNumbers (){
        Nif nif = new Nif("1234567A1");
        Throwable exception = assertThrows(IncorrectNifException.class, nif::getNif);
        assertEquals("The NIF is incorrect", exception.getMessage());
    }

    @Test
    void testNullNif (){
        Nif nif = new Nif(null);
        Throwable exception = assertThrows(IncorrectNifException.class, nif::getNif);
        assertEquals("The NIF is incorrect", exception.getMessage());
    }

    @Test
    void testEmptyNif (){
        Nif nif = new Nif("");
        Throwable exception = assertThrows(IncorrectNifException.class, nif::getNif);
        assertEquals("The NIF is incorrect", exception.getMessage());
    }

}

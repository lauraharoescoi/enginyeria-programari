package datatest;
import data.Nif;
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
    void testShortNif () throws IncorrectNifException {
        Nif nif = new Nif("1234567A");
        assertEquals("1234567A", nif.getNif());
    }

    @Test
    void testLongNif () throws IncorrectNifException {
        Nif nif = new Nif("123456789A");
        assertEquals("123456789A", nif.getNif());
    }

    @Test
    void testNifWithLetters () throws IncorrectNifException {
        Nif nif = new Nif("1234567Aa");
        assertEquals("1234567Aa", nif.getNif());
    }

    @Test
    void testNifWithNumbers () throws IncorrectNifException {
        Nif nif = new Nif("1234567A1");
        assertEquals("1234567A1", nif.getNif());
    }

    @Test
    void testNullNif () throws IncorrectNifException {
        Nif nif = new Nif(null);
        assertNull(nif.getNif());
    }

    @Test
    void testEmptyNif () throws IncorrectNifException {
        Nif nif = new Nif("");
        assertEquals("", nif.getNif());
    }

}

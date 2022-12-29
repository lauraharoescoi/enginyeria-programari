package datatest;
import data.DocPath;
import data.SmallCode;
import exceptions.BadPathException;
import exceptions.InvalidPassword;
import exceptions.SmallCodeException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class SmallCodeTest {

    @Test
    void testCorrectSmallCode() throws SmallCodeException {
        SmallCode smallCode = new SmallCode("123");
        assertEquals("123", smallCode.getCode());
    }

    @Test
    void testShortSmallCode(){
        SmallCode smallCode = new SmallCode("12");
        Throwable exception = assertThrows(SmallCodeException.class, smallCode::getCode);
        assertEquals("CVS code must be 3 digits", exception.getMessage());
    }

    @Test
    void testLongSmallCode(){
        SmallCode smallCode = new SmallCode("1234");
        Throwable exception = assertThrows(SmallCodeException.class, smallCode::getCode);
        assertEquals("CVS code must be 3 digits", exception.getMessage());
    }

    @Test
    void testSmallCodeWithLetters(){
        SmallCode smallCode = new SmallCode("12a");
        Throwable exception = assertThrows(SmallCodeException.class, smallCode::getCode);
        assertEquals("CVS code must be 3 digits", exception.getMessage());
    }

    @Test
    void testCodeCannotBeNull(){
        SmallCode smallCode = new SmallCode(null);
        Throwable exception = assertThrows(SmallCodeException.class, smallCode::getCode);
        assertEquals("CVS code must be 3 digits", exception.getMessage());
    }

}

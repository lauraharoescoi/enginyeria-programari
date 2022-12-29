package datatest;
import data.SmallCode;
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
    void testShortSmallCode() throws SmallCodeException {
        SmallCode smallCode = new SmallCode("12");
        assertEquals("12", smallCode.getCode());
    }

    @Test
    void testLongSmallCode() throws SmallCodeException {
        SmallCode smallCode = new SmallCode("1234");
        assertEquals("1234", smallCode.getCode());
    }

    @Test
    void testSmallCodeWithLetters() throws SmallCodeException {
        SmallCode smallCode = new SmallCode("12a");
        assertEquals("12a", smallCode.getCode());
    }

}

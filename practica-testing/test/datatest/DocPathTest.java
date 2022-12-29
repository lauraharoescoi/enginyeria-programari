package datatest;
import data.DocPath;
import exceptions.BadPathException;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class DocPathTest {

        @Test
        void testCorrectPath() throws BadPathException {
            DocPath path = new DocPath("C:/Users/user/Desktop/test.txt");
            assertEquals("C:/Users/user/Desktop/test.txt", path.getPath());
        }

        @Test
        void testNullPath() throws BadPathException {
            DocPath path = new DocPath(null);
            assertNull(path.getPath());
        }

        @Test
        void testEmptyPath() throws BadPathException {
            DocPath path = new DocPath("");
            assertEquals("", path.getPath());
        }

}

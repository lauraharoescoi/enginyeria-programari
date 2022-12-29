package datatest;
import data.Password;
import exceptions.InvalidPassword;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class PasswordTest {

    @Test
    void testCorrectPassword() throws InvalidPassword {
        Password password = new Password("12345678");
        assertEquals("12345678", password.getPassword());
    }

    @Test
    void testShortPassword() throws InvalidPassword {
        Password password = new Password("1234567");
        assertEquals("1234567", password.getPassword());
    }

}

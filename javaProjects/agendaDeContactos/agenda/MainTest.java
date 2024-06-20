package agenda;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.ByteArrayOutputStream;
import java.io.PrintStream;

import static org.junit.jupiter.api.Assertions.*;

class MainTest {
    private ContactBook contactBook;
    private ByteArrayOutputStream outContent;

    @BeforeEach
    void setUp() {
        contactBook = new ContactBook();
        // Inicializa el ByteArrayOutputStream para capturar la salida estándar
        outContent = new ByteArrayOutputStream();
        // Redirige la salida estándar a outContent
        System.setOut(new PrintStream(outContent));
    }

    @Test
    void testAddContact() {
        contactBook.addContact("John Doe", "1234567890");
        Contact contact = contactBook.findContact("John Doe");
        assertNotNull(contact);
        assertEquals("1234567890", contact.getPhoneNumber());
    }

    @Test
    void testFindContact() {
        contactBook.addContact("John Doe", "1234567890");
        Contact contact = contactBook.findContact("John Doe");
        assertNotNull(contact);
        assertEquals("1234567890", contact.getPhoneNumber());
    }

    @Test
    void testDisplayContacts() {
        contactBook.addContact("John Doe", "1234567890");
        contactBook.addContact("Jane Doe", "0987654321");
        contactBook.displayContacts();
        String output = outContent.toString();
        assertTrue(output.contains("John Doe"));
        assertTrue(output.contains("Jane Doe"));
    }
}
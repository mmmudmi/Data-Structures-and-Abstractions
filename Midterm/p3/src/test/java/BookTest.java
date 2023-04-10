import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookTest {

    @Test
    void simpleBookTest() {
        Book b0 = new Book("Book 0", "AX100", 101);
        assertEquals("Book 0", b0.getTitle());
        assertEquals("AX100", b0.getBookCode());
        assertEquals(101, b0.getPageCount());
    }
}

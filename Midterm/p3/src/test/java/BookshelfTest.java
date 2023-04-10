import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class BookshelfTest {

    @Test
    void simpleBookshelfTest() {
        Book b0 = new Book("Book 0", "AX100", 101);
        Book b1 = new Book("Book 1", "AC101", 179);
        Book b2 = new Book("Book 2", "MOBA99", 987);

        Bookshelf bs = new Bookshelf();
        for (Book b: new Book[]{b0, b1, b2}) 
            bs.add(b);

        assertEquals(3, bs.size());
        assertEquals(b1, bs.getBookByBookCode("AC101"));
        assertEquals(1267, bs.totalPageCountMatching(book -> true));
        assertEquals(280, bs.totalPageCountMatching(book -> book.getBookCode().startsWith("A")));
    }
}

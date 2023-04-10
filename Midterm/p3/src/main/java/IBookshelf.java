import java.util.function.Predicate;

public interface IBookshelf {
    // adds a Book to the shelf
    void add(Book book);

    // returns the total number of books on the shelf
    int size();

    // returns a book with bookCode. if the shelf has no matching books, return null.
    Book getBookByBookCode(String bookCode);

    // returns the sum of the page counts of all books matching the predicate
    int totalPageCountMatching(Predicate<Book> p);
}

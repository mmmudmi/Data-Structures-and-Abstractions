import java.util.*;
import java.util.function.Predicate;

public class Bookshelf implements IBookshelf {

    // Do *NOT* change the next line. This is where you will store your list of books.
    private List<Book> shelvedBooks;
    // ===============================================================================

    public Bookshelf() {shelvedBooks = new LinkedList<>();}
    @Override
    public void add(Book book) {
        shelvedBooks.add(book);
    }

    @Override
    public int size() {return shelvedBooks.size();}

    @Override
    public Book getBookByBookCode(String bookCode) {
        for (int i = 0;i<size();i++){
            if (shelvedBooks.get(i).getBookCode().equals(bookCode)){return shelvedBooks.get(i);}
        }
	return null;
    }

    @Override
    public int totalPageCountMatching(Predicate<Book> p) {
        int count = 0;
        for (int i = 0;i<size();i++){
            if(p.test(shelvedBooks.get(i))){count+= shelvedBooks.get(i).getPageCount();}
        }
	return count;
    }
}

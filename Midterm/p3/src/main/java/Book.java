public class Book {
    private String title;
    private String bookCode;
    private int pageCount;
    public Book(String title, String bookCode, int pageCount){
        this.title = title;
        this.bookCode = bookCode;
        this.pageCount = pageCount;
    }
    public String getTitle(){return this.title;}
    public String getBookCode(){return this.bookCode;}
    public int getPageCount(){return this.pageCount;}

    @Override
    public String toString() {
        return String.format("Book(title=%s, bookCode=%s, pageCount=%d)",
                getTitle(),
                getBookCode(),
                getPageCount()
        );
    }
}

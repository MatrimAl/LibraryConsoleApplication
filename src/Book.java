public class Book {
    private final String book;
    private final String author;
    public Book(String book, String author){
        this.book = book;
        this.author = author;
    }
    public String getBook(){
        return this.book;
    }
    public String getAuthor(){
        return this.author;
    }
}

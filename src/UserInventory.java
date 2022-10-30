public class UserInventory {
    public final String userBook;
    private final String userBookAuthor;
    private final String userId;

    public UserInventory( String userId, String userBook, String userBookAuthor){
        this.userBook = userBook;
        this.userBookAuthor = userBookAuthor;
        this.userId = userId;
    }
    public String getBook(){
        return this.userBook;
    }
    public String getAuthor(){
        return this.userBookAuthor;
    }
    public String getUserId(){
        return this.userId;
    }
}

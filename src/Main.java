import java.util.*;
import java.util.ArrayList;

public class Main {
    static ArrayList<Book> listBook = new ArrayList<Book>();
    static ArrayList<UserInventory> listUserBook = new ArrayList<UserInventory>();
    static Scanner input = new Scanner(System.in);
    static Login login=new Login();
    private static String loginid;

    public static void main(String[] args) {
        List();
        Login login=new Login();
        login.listLogin.add(new LoginData("admin", "123"));
        boolean loggedIn = false;
        while(!loggedIn){
            boolean check = login.choose();
            if(check == true){
                loggedIn = true;
                loginid = login.getId();
                choose();
                break;
            }
        }

    }
    public static void choose(){
        while(true) {
            System.out.println("Press A to list the books " +
                    "\nPress B to list the author's books" +
                    "\nPress C to take a book" +
                    "\nPress D to give a book for library" +
                    "\nPress E to list the your books" +
                    "\nPress F to exit your account.");
            String choose = input.nextLine();
            switch (choose) {
                case "A":
                    for (Book book : listBook) {
                        System.out.println("Book name: " + book.getBook() + "Book author name: " + book.getAuthor());
                    }
                    break;
                case "B":
                    System.out.println("Write author name.");
                    String authorName = input.nextLine();
                    for (Book book : listBook) {
                        if (book.getAuthor().equals(authorName)) {
                            System.out.println("Book name: " + book.getBook() + "Book author name: " + book.getAuthor());
                        }
                    }
                    System.out.println("There is no book in library writing by " + authorName);
                    break;
                case "C":
                    System.out.println("Write book name.");
                    String bookName = input.nextLine();
                    Book checkBook = null;
                    for (Book book : listBook) {
                        if (book.getBook().equals(bookName)) {
                            listBook.remove(book);
                            listUserBook.add(new UserInventory(loginid, book.getBook(), book.getAuthor()));
                            break;
                        }
                        System.out.println("There is no book in library like book name: " + bookName);
                        break;
                    }
                    break;
                case "D":
                    System.out.println("Write book name.");
                    String bookUserName = input.nextLine();
                    for (UserInventory book : listUserBook) {
                        if (book.getBook().equals(bookUserName)) {
                            listUserBook.remove(book);
                            listBook.add(new Book(book.getBook(), book.getAuthor()));
                            if (book.getUserId() != loginid || listUserBook.isEmpty()){
                                listUserBook.add(new UserInventory(loginid,"", ""));
                            }
                            break;
                        }
                        System.out.println("There is no book in your inventory like book name: " + bookUserName);
                        break;
                    }
                case "E":
                    if (listUserBook.isEmpty()) {
                        System.out.println("There is no book your inventory");
                    }
                    else {
                        for (UserInventory book : listUserBook) {
                            if (book.getUserId().equals(login.getId())) {
                                System.out.println("Book name: " + book.getBook() + "Book author name: " + book.getAuthor());
                            }
                        }
                        break;
                    }
                case "F":
                    login.choose();
                    break;
                default:
                    System.out.println("Incorrect request");
                    break;
            }
        }
    }
    public static void List(){

        listUserBook.add(new UserInventory("admin","Book1", "Author1"));
        listBook.add(new Book("Wheel of time", "Robert Jordan"));
        listBook.add(new Book("Frankenstein", "Mary Shelley"));
        listBook.add(new Book("Brave New World", "Aldous Huxley"));
        listBook.add(new Book("1984", "George Orwell"));
        listBook.add(new Book("Animal Farm", "George Orwell"));
    }

}
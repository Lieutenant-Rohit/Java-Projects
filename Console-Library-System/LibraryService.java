import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class LibraryService extends AbstractLibrary implements LibraryOperation{
    @Override
    public void loadData() {

        try (ObjectInputStream bookIn = new ObjectInputStream(new FileInputStream("books.dat"));
             ObjectInputStream userIn = new ObjectInputStream(new FileInputStream("users.dat"))) {

            bookMap = (Map<String, Book>) bookIn.readObject();
            userMap = (Map<String, User>) userIn.readObject();
            System.out.println("Data loaded successfully.");
        } catch (IOException | ClassNotFoundException e) {
            System.out.println("No previous data found or error loading data.");
            bookMap = new HashMap<>();
            userMap = new HashMap<>();
        }

    }

    @Override
    public void saveData() {

        try (ObjectOutputStream bookOut = new ObjectOutputStream(new FileOutputStream("books.dat"));
             ObjectOutputStream userOut = new ObjectOutputStream(new FileOutputStream("users.dat"))) {

            bookOut.writeObject(bookMap);
            userOut.writeObject(userMap);
            System.out.println("Data saved successfully.");
        } catch (IOException e) {
            System.out.println("Error saving data: " + e.getMessage());
        }

    }

    @Override
    public void addBook(Book book) {

        if(bookMap.containsKey(book.getId()))
        {
            System.out.println("Book Already Present");
        }
        else
        {
            bookMap.put(book.getId(),book);
            System.out.println("Book Successfully Added");
        }

    }

    @Override
    public void removeBook(String bookId) {
        bookMap.remove(bookId);
    }

    @Override
    public void registerUser(User user) {

        if(userMap.containsKey(user.getUserId()))
        {
            System.out.println("User Already Registered");
        }
        else{
            userMap.put(user.getUserId(),user);
            System.out.println("User Successfully Registered");
        }

    }

    @Override
    public void issueBook(String bookId, String userId) {

        Book book = bookMap.get(bookId);
        User user = userMap.get(userId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (user == null) {
            System.out.println("User not found.");
            return;
        }

        if (book.isIssued()) {
            System.out.println("Book is already issued.");
            return;
        }

        book.setIssued(true);
        book.setIssuedTo(userId);
        System.out.println("Book issued to user: " + userId);


    }

    @Override
    public void returnBook(String bookId, String userId) {
        Book book = bookMap.get(bookId);

        if (book == null) {
            System.out.println("Book not found.");
            return;
        }

        if (!book.isIssued()) {
            System.out.println("Book was not issued to this user.");
            return;
        }

        book.setIssued(false);
        book.setIssuedTo(null);
        System.out.println("Book returned successfully.");
    }
}

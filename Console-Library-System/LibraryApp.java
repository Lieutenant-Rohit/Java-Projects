import java.util.Scanner;

public class LibraryApp {
    public static void main(String[] args) {

        LibraryService library = new LibraryService();
        library.saveData();
        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("\n📚 Library Menu:");
            System.out.println("1. Add Book");
            System.out.println("2. Remove Book");
            System.out.println("3. Register User");
            System.out.println("4. Issue Book");
            System.out.println("5. Return Book");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    System.out.print("Enter Book ID: ");
                    String bookId = scanner.nextLine();
                    System.out.print("Enter Book Title: ");
                    String title = scanner.nextLine();
                    Book book = new Book();
                    book.setId(bookId);
                    book.setTitle(title);
                    library.addBook(book);
                    break;

                case 2:
                    System.out.print("Enter Book ID to remove: ");
                    String removeId = scanner.nextLine();
                    library.removeBook(removeId);
                    break;

                case 3:
                    System.out.print("Enter User ID: ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter User Name: ");
                    String name = scanner.nextLine();
                    User user = new User();
                    user.setUserId(userId);
                    user.setName(name);
                    library.registerUser(user);
                    break;

                case 4:
                    System.out.print("Enter Book ID to issue: ");
                    String issueBookId = scanner.nextLine();
                    System.out.print("Enter User ID: ");
                    String issueUserId = scanner.nextLine();
                    library.issueBook(issueBookId, issueUserId);
                    break;

                case 5:
                    System.out.print("Enter Book ID to return: ");
                    String returnBookId = scanner.nextLine();
                    System.out.print("Enter User ID: ");
                    String returnUserId = scanner.nextLine();
                    library.returnBook(returnBookId, returnUserId);
                    break;

                case 6:
                    System.out.println("Exiting Library System. Goodbye!");
                    scanner.close();
                    library.saveData();
                    return;

                default:
                    System.out.println("Invalid choice. Try again.");
            }
        }
    }

}
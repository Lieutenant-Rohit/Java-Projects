public interface LibraryOperation {

    public void addBook(Book book);
    public void removeBook(String bookId);
    public void registerUser(User user);
    public void issueBook(String bookId, String userId);
    public void returnBook(String bookId, String userId);
}

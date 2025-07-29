// User.java
public class User {
    private String userId;
    private String username;
    private String password;
    private String role; // "admin" or "customer"
    private String email;
    private String phone;

    public User(String userId, String username, String password, String role,
                String email, String phone) {
        this.userId = userId;
        this.username = username;
        this.password = password;
        this.role = role;
        this.email = email;
        this.phone = phone;
    }

    public boolean authenticate(String username, String password) {
        return this.username.equals(username) && this.password.equals(password);
    }

    public String getRole() {
        return role;
    }

    public String getUserId() {
        return userId;
    }

    public String getUsername() {
        return username;
    }

    public void displayUserInfo() {
        System.out.println("\nUser Information:");
        System.out.println("User ID: " + userId);
        System.out.println("Username: " + username);
        System.out.println("Role: " + role);
        System.out.println("Email: " + email);
        System.out.println("Phone: " + phone);
    }
}

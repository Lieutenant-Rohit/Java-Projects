// Bank.java
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Bank {
    private Map<String, Account> accounts;
    private Map<String, User> users;
    private List<Transaction> transactions;
    private Scanner scanner;
    private User currentUser;

    public Bank() {
        // Initialize data structures

        accounts = new HashMap<>();
        users = new HashMap<>();
        transactions = new ArrayList<>();
        scanner = new Scanner(System.in);

        // Initialize with some sample data
        initializeSampleData();
    }

    private void initializeSampleData() {
        // Add sample users
        users.put("admin1", new User("admin1", "admin", "admin123", "admin", "admin@bank.com", "1234567890"));
        users.put("user1", new User("user1", "customer1", "pass123", "customer", "customer1@bank.com", "9876543210"));

        // Add sample accounts
        accounts.put("SAV001", new SavingsAccount("SAV001", "John Doe", 5000, 1000, 3.5));
        accounts.put("CUR001", new CurrentAccount("CUR001", "John Doe", 10000, 5000));
    }

    public void start() {
        System.out.println("Welcome to Console Banking System");
        login();

        if (currentUser != null) {
            if (currentUser.getRole().equals("admin")) {
                showAdminMenu();
            } else {
                showCustomerMenu();
            }
        }

        scanner.close();
    }

    private void login() {
        System.out.print("Enter username: ");
        String username = scanner.nextLine();
        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        for (User user : users.values()) {
            if (user.authenticate(username, password)) {
                currentUser = user;
                System.out.println("Login successful. Welcome, " + user.getUsername() + "!");
                return;
            }
        }

        System.out.println("Invalid credentials. Please try again.");
        login();
    }

    private void showAdminMenu() {
        while (true) {
            System.out.println("\nADMIN MENU");
            System.out.println("1. View All Accounts");
            System.out.println("2. Create New Account");
            System.out.println("3. View Account Details");
            System.out.println("4. View All Transactions");
            System.out.println("5. View All Users");
            System.out.println("6. Create New User");
            System.out.println("7. Logout");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    viewAllAccounts();
                    break;
                case 2:
                    createAccount();
                    break;
                case 3:
                    viewAccountDetails();
                    break;
                case 4:
                    viewAllTransactions();
                    break;
                case 5:
                    viewAllUsers();
                    break;
                case 6:
                    createUser();
                    break;
                case 7:
                    currentUser = null;
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    private void showCustomerMenu() {
        while (true) {
            System.out.println("\nCUSTOMER MENU");
            System.out.println("1. View Account Balance");
            System.out.println("2. Deposit Money");
            System.out.println("3. Withdraw Money");
            System.out.println("4. View Transaction History");
            System.out.println("5. View Account Details");
            System.out.println("6. Logout");

            System.out.print("Enter your choice: ");
            int choice = scanner.nextInt();
            scanner.nextLine(); // consume newline

            switch (choice) {
                case 1:
                    viewBalance();
                    break;
                case 2:
                    deposit();
                    break;
                case 3:
                    withdraw();
                    break;
                case 4:
                    viewTransactionHistory();
                    break;
                case 5:
                    viewAccountDetails();
                    break;
                case 6:
                    currentUser = null;
                    System.out.println("Logged out successfully.");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }

    // Implement admin operations
    private void viewAllAccounts() {
        System.out.println("\nALL ACCOUNTS:");
        for (Account account : accounts.values()) {
            System.out.println("Account Number: " + account.getAccountNumber() +
                    ", Holder: " + account.getAccountHolder() +
                    ", Type: " + account.getAccountType() +
                    ", Balance: " + account.getBalance());
        }
    }

    private void createAccount() {
        System.out.println("\nCREATE NEW ACCOUNT");
        System.out.print("Enter account type (Savings/Current): ");
        String type = scanner.nextLine();

        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        System.out.print("Enter account holder name: ");
        String holder = scanner.nextLine();

        System.out.print("Enter initial balance: ");
        double balance = scanner.nextDouble();
        scanner.nextLine();

        if (type.equalsIgnoreCase("Savings")) {
            System.out.print("Enter minimum balance: ");
            double minBalance = scanner.nextDouble();
            scanner.nextLine();

            System.out.print("Enter interest rate: ");
            double rate = scanner.nextDouble();
            scanner.nextLine();

            accounts.put(accountNumber, new SavingsAccount(accountNumber, holder, balance, minBalance, rate));
        } else {
            System.out.print("Enter overdraft limit: ");
            double limit = scanner.nextDouble();
            scanner.nextLine();

            accounts.put(accountNumber, new CurrentAccount(accountNumber, holder, balance, limit));
        }

        System.out.println("Account created successfully.");
    }

    private void viewAccountDetails() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        Account account = accounts.get(accountNumber);
        if (account != null) {
            account.displayAccountInfo();
        } else {
            System.out.println("Account not found.");
        }
    }

    private void viewAllTransactions() {
        System.out.println("\nALL TRANSACTIONS:");
        for (Transaction t : transactions) {
            t.displayTransaction();
        }
    }

    private void viewAllUsers() {
        System.out.println("\nALL USERS:");
        for (User user : users.values()) {
            System.out.println("User ID: " + user.getUserId() +
                    ", Username: " + user.getUsername() +
                    ", Role: " + user.getRole());
        }
    }

    private void createUser() {
        System.out.println("\nCREATE NEW USER");
        System.out.print("Enter user ID: ");
        String userId = scanner.nextLine();

        System.out.print("Enter username: ");
        String username = scanner.nextLine();

        System.out.print("Enter password: ");
        String password = scanner.nextLine();

        System.out.print("Enter role (admin/customer): ");
        String role = scanner.nextLine();

        System.out.print("Enter email: ");
        String email = scanner.nextLine();

        System.out.print("Enter phone: ");
        String phone = scanner.nextLine();

        users.put(userId, new User(userId, username, password, role, email, phone));
        System.out.println("User created successfully.");
    }

    // Implement customer operations
    private void viewBalance() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.println("Current balance: " + account.getBalance());
        } else {
            System.out.println("Account not found.");
        }
    }

    private void deposit() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.print("Enter amount to deposit: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            account.deposit(amount);

            // Record transaction
            Transaction t = new Transaction("TXN" + System.currentTimeMillis(),
                    accountNumber,
                    "DEPOSIT",
                    amount,
                    java.time.LocalDate.now().toString(),
                    "Cash deposit");
            transactions.add(t);
        } else {
            System.out.println("Account not found.");
        }
    }

    private void withdraw() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        Account account = accounts.get(accountNumber);
        if (account != null) {
            System.out.print("Enter amount to withdraw: ");
            double amount = scanner.nextDouble();
            scanner.nextLine();

            account.withdraw(amount);

            // Record transaction
            Transaction t = new Transaction("TXN" + System.currentTimeMillis(),
                    accountNumber,
                    "WITHDRAWAL",
                    amount,
                    java.time.LocalDate.now().toString(),
                    "Cash withdrawal");
            transactions.add(t);
        } else {
            System.out.println("Account not found.");
        }
    }

    private void viewTransactionHistory() {
        System.out.print("Enter account number: ");
        String accountNumber = scanner.nextLine();

        System.out.println("\nTRANSACTION HISTORY FOR ACCOUNT: " + accountNumber);
        boolean found = false;

        for (Transaction t : transactions) {
            if (t.getAccountNumber().equals(accountNumber)) {
                t.displayTransaction();
                found = true;
            }
        }

        if (!found) {
            System.out.println("No transactions found for this account.");
        }
    }

    public static void main(String[] args) {
        Bank bank = new Bank();
        bank.start();
    }
}

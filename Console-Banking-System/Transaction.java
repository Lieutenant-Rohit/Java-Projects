// Transaction.java
public class Transaction {
    private String transactionId;
    private String accountNumber;
    private String transactionType;
    private double amount;
    private String date;
    private String description;

    public Transaction(String transactionId, String accountNumber, String transactionType,
                       double amount, String date, String description) {
        this.transactionId = transactionId;
        this.accountNumber = accountNumber;
        this.transactionType = transactionType;
        this.amount = amount;
        this.date = date;
        this.description = description;
    }

    // Getters
    public String getTransactionId() {
        return transactionId;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public String getTransactionType() {
        return transactionType;
    }

    public double getAmount() {
        return amount;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void displayTransaction() {
        System.out.println("\nTransaction Details:");
        System.out.println("ID: " + transactionId);
        System.out.println("Account: " + accountNumber);
        System.out.println("Type: " + transactionType);
        System.out.println("Amount: " + amount);
        System.out.println("Date: " + date);
        System.out.println("Description: " + description);
    }
}

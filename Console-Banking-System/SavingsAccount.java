// SavingsAccount.java
public class SavingsAccount extends Account {
    private double minBalance;
    private double interestRate;

    public SavingsAccount(String accountNumber, String accountHolder, double initialBalance, double minBalance, double interestRate) {
        super(accountNumber, accountHolder, initialBalance, "Savings");
        this.minBalance = minBalance;
        this.interestRate = interestRate;
    }

    @Override
    public void withdraw(double amount) {
        if (amount > 0) {
            if (balance - amount >= minBalance) {
                balance -= amount;
                System.out.println("Withdrawal successful. New balance: " + balance);
            } else {
                System.out.println("Insufficient funds. Cannot go below minimum balance.");
            }
        } else {
            System.out.println("Invalid withdrawal amount");
        }
    }


    @Override
    public void displayAccountInfo() {
        super.displayAccountInfo();
        System.out.println("Minimum Balance: " + minBalance);
        System.out.println("Interest Rate: " + interestRate + "%");
    }
}

package assignment1;

/**
 *
 * Class Account where Client's balance and number of his account are constructed
 */
public class Account {

    private double balance;
    private int accountNumber;
    public String Speciality;

    public Account(double inBalance, int inAccount) {
        this.balance = inBalance;
        this.accountNumber = inAccount;
    }
/**
 *
 * Setters and Getters for attributes are constructed
 * @param amount
 */
    public void setBalance(double amount) {
        balance = amount;
    }

    public void setAccNumber(int amount) {
        accountNumber = amount;
    }

    public double getBalance() {
        return this.balance;
    }

    public int getAccNumber() {
        return this.accountNumber;
    }
/**
 *
 * Withdraw function to allow user to withdraw from his initialed balance
 * @param amount
     * @return 
 */
    public double withdraw(double amount) {

        if (amount > balance) {
            System.out.println("You have exceeded your balance \n");
        } else {
            balance -= amount;
            System.out.println("Withdraw operation successful");
            System.out.println("Your Balance after withdraw: " + getBalance());
            
        }
        return getBalance();
    }
/**
 *
 * Deposit function to allow user to deposit from his initialed balance
 * @param amount
     * @return 
 */
    public double deposit(double amount) {
        balance += amount;
        setBalance(balance);
        System.out.println("Deposit operation successful");
        System.out.println("Your Balance after deposit: " + getBalance());
        return getBalance();
    }

    
//    public String toString() {
//        return "Account Number: ";
//
//    }

}

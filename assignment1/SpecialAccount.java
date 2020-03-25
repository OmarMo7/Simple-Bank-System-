package assignment1;
/**
 *
 * @author Mohamed Anwar 20/2/2020
 * Class Special account where an overridden function withdraw is just implemented
 */
public class SpecialAccount extends Account {
    //Empty Parametrized
    SpecialAccount(double inBalance ,int inAccount){
        super(inBalance ,inAccount);
    }

    /**
     *
     * @param amount
     * @return 
     */
    @Override
    public double withdraw(double amount){
        if (this.getBalance() != 0 && amount >  this.getBalance() && amount - this.getBalance() <= 1000){
            double s = this.getBalance() - amount;
            setBalance(s);
            System.out.println("(Over-Drafting) successful");
            System.out.println("Your Balance: " +getBalance());
        }
        else if (this.getBalance()> amount){
            double s = this.getBalance() - amount;
            setBalance(s);
            System.out.println("Operation successful");
            System.out.println("Your Balance: " + getBalance());
        }
        else if (this.getBalance() == 0 && amount <= 1000) {
            double s = this.getBalance() - amount;
            setBalance(s);
            System.out.println("(Over-Drafting) successful");                
            System.out.println("Your Balance: " + getBalance());
        }
        else if (this.getBalance() ==  amount ) {
            double s = this.getBalance() - amount;
            setBalance(s);
            System.out.println("Operation successful");                
            System.out.println("Your Balance: " + getBalance());
        }
        else {
            System.out.println("Cannot overdraft this amount.");
        }
        return getBalance();
    }
    
}

package assignment1;

import java.util.ArrayList;
import java.util.Scanner;
/**
 * 
 * @author Omar Mostafa 21/2/2020
 * @author Mohamed Metwally 21/2/2020
 * @author Mohamed Anwar 21/2/2020
 */
public class Main extends Bank {
     public ArrayList<Double> balancess = new ArrayList<>();
    Scanner input = new Scanner(System.in);
    Bank myBank = new Bank();
    double balance = 0;
    double UserAnswer5;
//    double SpecBalance = 0;
//    double norbalance = 0;
//    double Cbalance = 0;
    Main() {}
/**
 *DisplayMenu displays the available options for user to choose
 */

    public void displayMenu() {
        System.out.println("Choose the option you want: ");
        System.out.println("1- Add new normal client account with normal account");
        System.out.println("2- Add new normal client account with special account");
        System.out.println("3- Add new commercial client account with normal account ");
        System.out.println("4- Add new commercial client account with special account");
        System.out.println("5- Display accounts' details");
        System.out.println("6- Display specifec account details");
        System.out.println("7- Exit");

        String UserAnswer = input.next();
        

        switch (UserAnswer) {
/**
 * Normal client with a normal account is added
 */
            case "1":
                System.out.println("Enter you Client's name: ");
                String normalName = input.next();
                System.out.println("Enter you Client's nationalID: ");
                String nationalID = input.next();
                System.out.println("Enter you Client's address: ");
                String normalAddress = input.next();
                System.out.println("Enter you Client's phone: ");
                String normalPhone = input.next();
                System.out.println("Enter your account's balance: ");
                validatePositiveNumber();
                counter+=1;
                Account normalAcc = new Account(balance, counter);
                Client normalClient = new Client(normalName, nationalID, normalAddress, normalPhone, normalAcc);
                myBank.addClient(normalAcc, normalClient, balance);
                displayTrans(balance, counter);
                break;
/**
 * Normal client with a special account is added
 */
            case "2":
                System.out.println("Enter you Client's name: ");
                String normalSpecName = input.next();
                System.out.println("Enter you Client's nationalID: ");
                String nationalSpecID = input.next();
                System.out.println("Enter you Client's address: ");
                String normalSpecAddress = input.next();
                System.out.println("Enter you Client's phone: ");
                String normalSpecPhone = input.next();
                System.out.println("Enter your account's balance: ");
                validatePositiveNumber();
                counter+=1;
                SpecialAccount normalSpecAcc = new SpecialAccount(balance, counter);
                Client normalcomClient = new Client(normalSpecName, nationalSpecID, normalSpecAddress, normalSpecPhone, normalSpecAcc);
                myBank.addClient(normalSpecAcc, normalcomClient, balance);
                displayTrans(balance, counter);
                break;
/**
 * Commercial client with a normal account is added
 */
            case "3":
                System.out.println("Enter you Client's name: ");
                String CnorName = input.next();
                System.out.println("Enter you Client's commercialID: ");
                String commercialnorID = input.next();
                System.out.println("Enter you Client's address: ");
                String CnorAddress = input.next();
                System.out.println("Enter you Client's phone: ");
                String CnorPhone = input.next();
                System.out.println("Enter your account's balance: ");
                validatePositiveNumber();
                counter+=1;
                Account normalnorAcc = new Account(balance, counter);
                Client normalnorClient = new Client(CnorName, commercialnorID, CnorAddress, CnorPhone, normalnorAcc);
                myBank.addClient(normalnorAcc, normalnorClient, balance);
                displayTrans(balance, counter);
                break;
/**
 * Commercial client with a commercial account is added
 */
            case "4":
                System.out.println("Enter you Client's name: ");
                String CName = input.next();
                System.out.println("Enter you Client's commercialID: ");
                String commercialID = input.next();
                System.out.println("Enter you Client's address: ");
                String CAddress = input.next();
                System.out.println("Enter you Client's phone: ");
                String CPhone = input.next();
                System.out.println("Enter your account's balance: ");
                validatePositiveNumber();
                counter+=1;
                SpecialAccount specialAcc = new SpecialAccount(balance, counter);
                Client coclient = new CommercialClient(CName, commercialID, CAddress, CPhone, specialAcc);
                myBank.addClient(specialAcc, coclient, balance);
                displayTrans(balance, counter);
                break;
/**
 * Display all accounts
 */
            case "5":
                myBank.display();
                displayMenu();
                break;
/**
 * Display a specific account
 */
            case "6":
                System.out.println("Enter client's account number: ");
                int number = input.nextInt();
                myBank.displayClient(number);
                break;
/**
 * Exit
 */
            case "7":
                System.out.println("Thank You!");
                break;
/**
 * Simple handling for user inputs errors
 */
            default:
                System.out.println("Invalid Input");
                displayMenu();
                break;
        }
        
    }
/**
 * Display deposit/withdraw options for user to choose
     * @param Cbalance
     * @param CaccountNumber
 */
    public void displayTrans(double Cbalance, int CaccountNumber) {
        SpecialAccount specialAcc = new SpecialAccount(Cbalance, CaccountNumber);
        System.out.println("Which transactions do you want to make: ");
        System.out.println("1- [Deposit]");
        System.out.println("2- [Withdraw]");
        System.out.println("3- [Exit]");
        String UserAnswer3 = input.next();
        
        switch (UserAnswer3) {
            case "1":
                {
                    System.out.println("Enter a positive amount: ");
                    validateDeposit();
                    balance = specialAcc.deposit(UserAnswer5);
                    myBank.balances.add(CaccountNumber-1,balance);
                    break;
                }
            case "2":
                {
                    System.out.println("Enter amount: ");
                    validateWithdraw();
                    balance = specialAcc.withdraw(UserAnswer5);
                    myBank.balances.add(CaccountNumber-1,balance);
                    break;
                }
            case "3":
                System.out.println("Thank You");
                displayMenu();
                break;
            default:
                System.out.println("Invalid Input");
                displayTrans(Cbalance, CaccountNumber);
                break;
        }
        displayMenu();
    }

    private void validatePositiveNumber() {
        //Scanner scanner = new Scanner(System.in);

        
        do {
            System.out.print("Please enter a positive number: ");
            while (!input.hasNextInt() || !input.hasNextDouble()) {
                String inputt = input.next();
                System.out.printf("\"%s\" is not a valid number.\n", inputt);
            }
            balance = input.nextInt();
        } while (balance < 0);
    }
    private void validateDeposit() {
        Scanner scanner = new Scanner(System.in);

        
        do {
            System.out.print("Please enter a number: ");
            while (!scanner.hasNextInt() || !scanner.hasNextDouble()) {
                String inputt = scanner.next();
                System.out.printf("\"%s\" is not a valid number.\n", inputt);
            }
            UserAnswer5 = scanner.nextDouble();
        } while (UserAnswer5 < 0);
    }
    
    private void validateWithdraw() {
        Scanner scanner = new Scanner(System.in);

        
        do {
            System.out.print("Please enter a number: ");
            while ((!scanner.hasNextDouble() || !scanner.hasNextInt())) {
                String inputt = scanner.next();
                System.out.printf("\"%s\" is not a valid number.\n", inputt);
            }
            UserAnswer5 = scanner.nextDouble();
            
        } while (!scanner.hasNextLine());
    }
}






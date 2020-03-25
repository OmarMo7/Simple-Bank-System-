package assignment1;

import java.util.Scanner;
/**
 * 
 * @author Omar Mostafa 21/2/2020
 * @author Mohamed Metwally 21/2/2020
 * @author Mohamed Anwar 21/2/2020
 */
public class MainMenu extends Bank {
    Scanner input = new Scanner(System.in);
    Bank myBank = new Bank();
    boolean existance = false;
    double balance = 0;
    double UserAnswer5;
    int UserAnswerInt;
    int UserAnswerInt2;
    
//    double SpecBalance = 0;
//    double norbalance = 0;
//    double Cbalance = 0;
    MainMenu() {};
/**
 *DisplayMenu displays the available options for user to choose
 */

    public void displayMenu() {
        System.out.println("Choose the option you want: ");
        System.out.println("1- Add new normal client account with normal account");
        System.out.println("2- Add new normal client account with special account");
        System.out.println("3- Make Transactios");
        System.out.println("4- Display accounts' details");
        System.out.println("5- Display specifec account details");
        System.out.println("6- Exit");

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
                normalAcc.Speciality = "false";
                Client normalClient = new Client(normalName, nationalID, normalAddress, normalPhone, normalAcc);
                myBank.addClient(normalAcc, normalClient, balance, normalAcc.Speciality);
                //displayTrans(balance, counter);
                displayMenu();
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
                SpecialAccount acc = new SpecialAccount(balance, counter);
                acc.Speciality = "true";
                Client normalcomClient = new Client(normalSpecName, nationalSpecID, normalSpecAddress, normalSpecPhone, acc);
                myBank.addClient(acc, normalcomClient, balance,acc.Speciality);
                //displayTransNorm(balance, counter);
                displayMenu();
                break;

            
/**
 * Display all accounts
 */
            case "3":
                validateIntAnswer();
                if (UserAnswerInt > myBank.counters.size()){
                do{
                    System.out.println("Your entered account number does not exist! ");
                    System.out.println("Please try another valid one: ");
                    validateIntAnswer();
                } while(UserAnswerInt > myBank.counters.size());
                }
                existance = true;
                balance = myBank.balances.get(UserAnswerInt-1);
                
                if (myBank.specs.get(UserAnswerInt-1).equals("false")){
                    displayTransNorm(balance,UserAnswerInt);
                }
                else if (myBank.specs.get(UserAnswerInt-1).equals("true")){
                    displayTrans(balance,UserAnswerInt);
                }
                break;
            case "4":
                myBank.display();
                displayMenu();
                break;
/**
 * Display a specific account
 */
            case "5":
                System.out.println("Enter client's account number: ");
                int number = input.nextInt();
                myBank.displayClient(number);
                displayMenu();
                break;
/**
 * Exit
 */
            case "6":
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
      if(existance){
        
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
      else {validateIntAnswer();}
    }
    
    public void displayTransNorm(double Cbalance, int CaccountNumber) {
        Account acc = new Account(Cbalance, CaccountNumber);
      if(existance){
        
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
                    balance = acc.deposit(UserAnswer5);
                    myBank.balances.add(CaccountNumber-1,balance);
                    break;
                }
            case "2":
                {
                    System.out.println("Enter amount: ");
                    validateWithdraw();
                    balance = acc.withdraw(UserAnswer5);
                    myBank.balances.add(CaccountNumber-1,balance);
                    break;
                }
            case "3":
                System.out.println("Thank You");
                displayMenu();
                break;
            default:
                System.out.println("Invalid Input");
                displayTransNorm(Cbalance, CaccountNumber);
                break;
        }
        displayMenu();
    }
      else {validateIntAnswer();}
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
    private void validatePositiveNumberToChooseType() {
        //Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Please enter a positive number: ");
            while (!input.hasNextInt()) {
                String inputt = input.next();
                System.out.printf("\"%s\" is not a valid number.\n", inputt);
            }
            UserAnswerInt2 = input.nextInt();
        } while (UserAnswerInt2 < 1 || UserAnswerInt2 > 2);
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
    
    private void validateIntAnswer() {
        Scanner scanner = new Scanner(System.in);
        do {
            System.out.print("Please enter your client's account number: ");
            while (!scanner.hasNextInt()) {
                String inputt = scanner.next();
                System.out.printf("\"%s\" is not a valid number.\n", inputt);
            }
            UserAnswerInt = scanner.nextInt();
            
            
        } while (!scanner.hasNextLine());
    }
}






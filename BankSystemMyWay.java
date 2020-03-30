/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package bank.system.myway;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author EGYPT
 */
public class BankSystemMyWay {
Scanner input = new Scanner(System.in);

String nationalID;
String specialID;
String normalAddress;
String normalName;
String normalPhone;
String id;
double balance = 0;
private int counter = 0;
int limit = 10;
int count = 0;
int accN;

boolean existance;

    public ArrayList<String> names = new ArrayList<>();
    public ArrayList<String> phones = new ArrayList<>();
    public ArrayList<String> addresses = new ArrayList<>();
    public ArrayList<String> IDs = new ArrayList<>();
    public ArrayList<String> specs = new ArrayList<>();
    public ArrayList<Integer> accNumbers = new ArrayList<>();
    public ArrayList<Double> balances = new ArrayList<>();
    


    void displayMenu() {
        System.out.println("Choose the option you want: ");
        
        
        System.out.println("1- Add new client with normal account");
        System.out.println("2- Add new client with special account ");
        System.out.println("3- transactions");
        System.out.println("4- Display accounts' details");
        System.out.println("5- Display specifec account details");
        System.out.println("6- Exit");

        int UserAnswer;
        UserAnswer = validatePositiveInt(input);
        
        switch (UserAnswer) {
/**
 * Client with a normal account is added
 */
            case 1:
                System.out.println("Enter you Client's name: ");
                normalName = input.next();
                System.out.println("Enter you Client's nationalID: ");
                nationalID = input.next();
                System.out.println("Enter you Client's address: ");
                normalAddress = input.next();
                System.out.println("Enter you Client's phone: ");
                normalPhone = input.next();
                System.out.println("Enter your account's balance: ");
                balance = validateBDW(input);
                addClient(normalName,normalAddress,normalPhone,nationalID,balance,"Normal");
                displayMenu();
                break;
/**
 * Client with a special account is added
 */
            case 2:
                System.out.println("Enter you Client's name: ");
                normalName = input.next();
                System.out.println("Enter you Client's specialID: ");
                specialID = input.next();
                System.out.println("Enter you Client's address: ");
                normalAddress = input.next();
                System.out.println("Enter you Client's phone: ");
                normalPhone = input.next();
                System.out.println("Enter your account's balance: ");
                balance = validateBDW(input);
                addClient(normalName,normalAddress,normalPhone,specialID,balance,"Special");
                displayMenu();
                break;
            case 3:
                
                displayTrans();
                break;
            case 4:
                display();
                displayMenu();
                break;
            case 5:
                displayClient();
                displayMenu();
                break;
            case 6:
                System.out.println("Thank You!!!");
                return;
            default:
                System.out.println("Invalid Input");
                displayMenu();
                break;
        }
    
    
    }
    
    
    
    private int validatePositiveInt(Scanner scanner) {
        int x;
        do {
            System.out.print("Please enter a positive number: ");
            while (!scanner.hasNextInt()) {
                String inputt = scanner.next();
                System.out.printf("\"%s\" is not a valid number.\n", inputt);
            }
            x = scanner.nextInt();
        } while (x < 0);
        return x;
    }
    
    private double validateBDW(Scanner scanner) {
        double x;
        do {
            System.out.print("Please enter a number: ");
            while (!scanner.hasNextInt() || !scanner.hasNextDouble()) {
                String inputt = scanner.next();
                System.out.printf("\"%s\" is not a valid number.\n", inputt);
            }
            x = scanner.nextDouble();
        } while (x < 0);
        return x;
    }
    
    
    
    public void displayTrans() {
        existance = false;
                System.out.println("Enter you Client's account number: ");
                accN = validatePositiveInt(input);
            
            if (accNumbers.contains(accN)){existance = true;}
            else if ((!accNumbers.contains(accN)) && count == 2 ){System.out.println("****************************"); displayMenu();}
            else {
               System.out.println("Please check your inputs! :" );
               count++;
               displayTrans();
           }
            chooseTransaction(accN);
    }
    
    void chooseTransaction(int accN){
    if(existance){
        System.out.println("Which transactions do you want to make: ");
        System.out.println("1- [Deposit]");
        System.out.println("2- [Withdraw]");
        System.out.println("3- [Exit]");
        int UserAnswer3;
        double UserAnswer5;
        UserAnswer3 = validatePositiveInt(input);
        switch (UserAnswer3) {
            case 1:
                {
                    System.out.println("Enter amount: ");
                    UserAnswer5 = validateBDW(input);
                    balances.set(accN-1 , deposit(UserAnswer5)) ;
                    displayMenu();
                    break;
                }
            case 2:
                {
                    
                    System.out.println("Enter amount: ");
                    UserAnswer5 = validateBDW(input);
                    if (specs.get(accN-1).equals("Normal")){
                    balances.set(accN-1,withdraw(UserAnswer5));
                    }else{
                    balances.set(accN-1,specialWithdraw(UserAnswer5));
                    }
                    displayMenu();
                    break;
                }
            case 3:
                System.out.println("Thank You");
                displayMenu();
                break;
            default:
                System.out.println("Invalid Input");
                chooseTransaction(accN);
                break;
        }
        
       }
        existance = false;
    }
    
    public double withdraw(double amount) {

        balance = balances.get(accN-1);
        if (amount > balance) {
            System.out.println("\nYou have exceeded your balance");
            System.out.println("This amount cannot be over-drafted \n");
        }else{
            balance -= amount;
            System.out.println("Withdraw operation successful");
            System.out.println("Your Balance after withdraw: " + balance);
        }
        return balance;
    }
    /**
     *
     * @param amount
     * @return
     */
    public double specialWithdraw(double amount){
        balance = balances.get(accN-1);
        if (balance != 0 && amount >  balance && amount - balance <= 1000){
            balance -= amount;
            System.out.println("(Over-Drafting) successful");
            System.out.println("Your Balance: " +balance);
        }else if (balance> amount){
            balance -= amount;
            System.out.println("Operation successful");
            System.out.println("Your Balance: " + balance);
        }else if (balance == 0 && amount <= 1000) {
            balance -= amount;
            System.out.println("(Over-Drafting) successful");                
            System.out.println("Your Balance: " + balance);
        }else if (balance ==  amount ) {
            balance -= amount;
            System.out.println("Operation successful");                
            System.out.println("Your Balance: " + balance);
        }else {
            System.out.println("Cannot overdraft this amount.");
        }
        return balance;
    }
/**
 *
 * Deposit function to allow user to deposit from his initialed balance
 * @param amount
     * @return 
 */
    public double deposit(double amount) {
        balance = balances.get(accN-1);
        balance += amount;
        System.out.println("Deposit operation successful");
        System.out.println("Your Balance after deposit: " + balance);
        
        return balance;
    }
    
    public void displayClient() {
        int accNumber;
        System.out.println("Enter your client's account number: ");
            accNumber = validatePositiveInt(input);
        if (accNumber - 1 > accNumbers.size()) {
            System.out.println("Unavailable input");
            displayClient();
        }else if (!accNumbers.contains(accNumber)){
            System.out.println("Client not found !!");
            displayClient();
        }else {
            System.out.println("************************************");
            System.out.println("Name: "+names.get(accNumber-1));
            System.out.println("Address: "+addresses.get(accNumber-1));
            System.out.println("Phone: "+phones.get(accNumber-1));
            System.out.println("ID: "+IDs.get(accNumber-1));
            System.out.println("Client Type: "+specs.get(accNumber-1)+" client");
            System.out.println("Account Number: "+accNumbers.get(accNumber-1));
            System.out.println("Balance: " + balances.get(accNumber-1).toString());
        }
    }
    
    public void addClient( String name, String address, String phone , String ID,Double balance, String type) {
        names.add(name);
        addresses.add(address);
        phones.add(phone);
        IDs.add(ID);
        balances.add(balance);
        counter++;
        accNumbers.add(counter);
        specs.add(type);
    }
    
    public void display() {
        System.out.println("************************************");
        for (int i = 0; i < names.size(); i++) {
            System.out.println("Name: "+names.get(i));
            System.out.println("Address: "+addresses.get(i));
            System.out.println("Phone: "+phones.get(i));
            System.out.println("ID: "+IDs.get(i));
            System.out.println("Client Type: "+specs.get(i)+" client");
            System.out.println("Account Number: "+accNumbers.get(i));
            System.out.println("Balance: " + balances.get(i));
            System.out.println("************************************");
        }
        
        for(int i =0; i < balances.size(); i++){
            System.out.println("Balance): " + balances.get(i));
        }
    }
    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        // TODO code application logic here
        BankSystemMyWay b = new BankSystemMyWay();
        b.displayMenu();
    }
    
}

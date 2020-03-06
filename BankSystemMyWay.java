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
double balance;
private int counter = 0;
int count = 0;
int limit = 10;
int accN = 0;
String id =" ";


    public ArrayList<String> names = new ArrayList<>();
    public ArrayList<String> phones = new ArrayList<>();
    public ArrayList<String> addresses = new ArrayList<>();
    public ArrayList<String> IDs = new ArrayList<>();
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

        String UserAnswer = input.next();
        
        switch (UserAnswer) {
/**
 * Normal client with a normal account is added
 */
            case "1":
                System.out.println("Enter you Client's name: ");
                normalName = input.next();
                System.out.println("Enter you Client's nationalID: ");
                nationalID = input.next();
                System.out.println("Enter you Client's address: ");
                normalAddress = input.next();
                System.out.println("Enter you Client's phone: ");
                normalPhone = input.next();
                System.out.println("Enter your account's balance: ");
                balance = input.nextDouble();
                addClient(normalName,normalAddress,normalPhone,nationalID,balance);
                displayMenu();
                break;
            case "2":
                System.out.println("Enter you Client's name: ");
                normalName = input.next();
                System.out.println("Enter you Client's specialID: ");
                specialID = input.next();
                System.out.println("Enter you Client's address: ");
                normalAddress = input.next();
                System.out.println("Enter you Client's phone: ");
                normalPhone = input.next();
                System.out.println("Enter your account's balance: ");
                balance = input.nextDouble();
                addClient(normalName,normalAddress,normalPhone,specialID,balance);
                displayMenu();
                break;
            case "3":
                displayTrans(accN,id);
                break;
            case "4":
                display();
                displayMenu();
                break;
            case "5":
                displayClient(accN);
                displayMenu();
                break;
            case "6":
                System.out.println("Thank You!!! ");
                break;
             
            default:
                System.out.println("Invalid Input");
                displayMenu();
        }
    
    
    }
    void checkSpeciality(){
        
        stringLimiter(specialID ,limit);
        
//    for(int i = 0; i < string.length(); i++) {    
//            if(string.charAt(i) != ' ')    
//                count++;    
//            else if (string.charAt(i) == ' ')
//                System.out.println("You have broken the rule of space! ");
//                System.out.println("but fortunately we handled it! ");
              
//        }
    }

    String stringLimiter(String string , int limit){
            
        
                    removeAllSpaces(string);
        
                if (string.length() == limit){
                    return string;
                }
                else{
                    System.out.println("It seems like you have entered the wrong limit of chars!! \n");
                    return stringLimiter(string,limit);
                }
     
    }
    
    String removeAllSpaces(String str){
    int i=0, j;
   for( i = 0; i < str.length(); i++) {
      if (str.charAt(i) == ' ') {
         for (j = i; j < str.length(); j++){
            str.replace(str.charAt(j),str.charAt(j+1));

         }
         return removeAllSpaces(str);
      }
   }

return str;
}
    
    public void displayTrans(int accN , String id) {
        boolean existance = false;
        System.out.println("Enter you Client's account number: ");
                accN = input.nextInt();
                System.out.println("Enter you Client's nationalID: ");
                id = input.next();
      
           if (accNumbers.get(accN-1) == accN && IDs.get(accN-1).equals(id) && accN <= accNumbers.size()){existance = true;}
           else {
               System.out.println("Please check your inputs! :" );
               displayTrans(accN,id);
           }
       
       if(existance){
        System.out.println("Which transactions do you want to make: ");
        System.out.println("1- [Deposit]");
        System.out.println("2- [Withdraw]");
        System.out.println("3- [Exit]");
        String UserAnswer3 = input.next();

        switch (UserAnswer3) {
            case "1":
                {
                    System.out.println("Enter amount: ");
                    double UserAnswer5 = input.nextDouble();
                    balances.add(accN-1 , deposit(UserAnswer5)) ;
                    displayMenu();
                    break;
                }
            case "2":
                {
                    System.out.println("Enter amount: ");
                    double UserAnswer5 = input.nextDouble();
                    balances.add(accN-1 , withdraw(UserAnswer5)) ;
                    displayMenu();
                    break;
                }
            case "3":
                System.out.println("Thank You");
                displayMenu();
                break;
            default:
                System.out.println("Invalid Input");
                displayTrans(accN , id);
                break;
        }
        
       }
       else displayMenu();
    }
    
    public double withdraw(double amount) {

        if (amount > balance) {
            System.out.println("You have exceeded your balance \n");
        } else {
            balance -= amount;
            System.out.println("Withdraw operation successful");
            System.out.println("Your Balance after withdraw: " + balance);
        }
        return balance;
    }
/**
 *
 * Deposit function to allow user to deposit from his initialed balance
 * @param amount
 */
    public double deposit(double amount) {
        balance += amount;
        System.out.println("Deposit operation successful");
        System.out.println("Your Balance after deposit: " + balance);
        
        return balance;
    }
    
    public void displayClient(int accNumber) {
            accNumber = input.nextInt();
        if (accNumber - 1 > accNumbers.size()) {
            System.out.println("Unavailable input");
            displayClient(accNumber);
        } else {
            System.out.println("Name: "+names.get(accNumber-1));
            System.out.println("Address: "+addresses.get(accNumber-1));
            System.out.println("Phone: "+phones.get(accNumber-1));
            System.out.println("ID: "+IDs.get(accNumber-1));
            System.out.println("Account Number: "+accNumbers.get(accNumber-1));
            System.out.println("Balance: " + balances.get(accNumber-1).toString());
        }
    }
   
@Override
    public String toString() {
    
        return " " + balance ;
    }
    
    public void addClient( String name, String address, String phone , String ID,Double balance) {
        names.add(name);
        addresses.add(address);
        phones.add(phone);
        IDs.add(ID);
        balances.add(balance);
        counter++;
        accNumbers.add(counter);
    }
    
    public void display() {

        for (int i = 0; i < names.size(); i++) {

            System.out.println("Name: "+names.get(i));
            System.out.println("Address: "+addresses.get(i));
            System.out.println("Phone: "+phones.get(i));
            System.out.println("ID: "+IDs.get(i));
            System.out.println("Account Number: "+accNumbers.get(i));
            System.out.println("Balance: " + balances.get(i).toString());
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

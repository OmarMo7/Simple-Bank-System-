package assignment1;

import java.util.ArrayList;
import java.util.Scanner;

/**
 *
 * @author Omar Mostafa 18/2/2020
 */
public class Bank {

    private String name;
    private String phone;
    private String address;
    protected int counter = 0;
    public ArrayList<Account> accounts = new ArrayList<>();
    public ArrayList<Client> clients = new ArrayList<>();
    public ArrayList<Double> balances = new ArrayList<>();
    public ArrayList<Integer> counters = new ArrayList<>();
    public ArrayList<String> specs = new ArrayList<>();
    Scanner input = new Scanner (System.in);
    public Bank() {
        this.name = "Egypt Bank";
        this.phone = "010000000";
        this.address = "Wall Street";

    }

    public void addClient(Account account, Client client, Double balance, String spec) {
        counter++;
        accounts.add(account);
        clients.add(client);
        balances.add(balance);
        counters.add(counter);
        specs.add(spec);
    }

    /**
     * Display function displays all clients data and balances
     */
    public void display() {

        for (int i = 0; i < clients.size(); i++) {

            System.out.println(this.clients.get(i).toString());
            System.out.println("Balances: "+this.balances.get(i).toString());
            System.out.println("Account Number: "+counters.get(i)+ " \n********" +"\n********\n");
        }
        for(int i =0; i < balances.size(); i++){
            System.out.println("Balance): " + balances.get(i));
        }
    }
    
/**
* Display function here displays a specific client data and balance
*/
    public void displayClient() {
        int accNumber = input.nextInt();
        if (accNumber > clients.size() || accNumber < 1){
            System.out.println("Unavailable input");
            displayClient();
        }
        else {
            System.out.println(this.clients.get(accNumber - 1));
            System.out.println("Balance: " + balances.get(accNumber - 1));
            System.out.println("Account Number: "+counters.get(accNumber-1)+ " \n********" +"\n********\n");
        }
    }
/**
* Setters and Getters for attributes are constructed
*/
    void setName(String name) {
        this.name = name;
    }

    void setAddress(String address) {
        this.address = address;
    }

    void setPhone(String phone) {
        this.phone = phone;
    }

    String getName() {
        return this.name;
    }

    String getAddress() {
        return this.address;
    }

    String getPhone() {
        return this.phone;
    }
}

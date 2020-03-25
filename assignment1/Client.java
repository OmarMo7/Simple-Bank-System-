package assignment1;

/**
 *
 * @author Mohamed Metwally 21/2/2020
 */
public class Client {

    private String name, nationalID, address, phone;
    private Account account;
/**
* parameterized constructor
* @param name 
* @param nationalID 
* @param address
* @param phone 
* @param account
*/
    Client(String name, String nationalID, String address, String phone, Account account) {
        this.name = name;
        this.nationalID = nationalID;
        this.address = address;
        this.phone = phone;
        this.account = account;
    }
/**
* Setters and Getters for attributes are constructed
     * @param amount
*/
    public void setName(String amount) {
        name = amount;
    }

    public void setAddress(String amount) {
        address = amount;
    }

    public void setID(String amount) {
        nationalID = amount;
    }

    public void setPhone(String amount) {
        phone = amount;
    }

    public void setAccount(Account amount) {
        account = amount;
    }

    public String getName() {
        return this.name;
    }

    public String getAddress() {
        return this.address;
    }

    public String getID() {
        return this.nationalID;
    }

    public String getPhone() {
        return this.phone;
    }

    public Account getAccount() {
        return this.account;
    }

    @Override
    public String toString() {
        return "\nName: " + getName() + "\nNationalID: " + getID() + "\nAddress: " + getAddress() + "\nPhone: " + getPhone() + "\n" + "********" + "\nAccount Data: \n" + "********" ;
    }
}

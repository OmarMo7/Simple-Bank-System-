package assignment1;

/**
 *
 * @author Mohamed Metwally 21/2/2020
 */
public class CommercialClient extends Client {

    private String commercialID;
/**
* parameterized constructor
* @param name 
* @param commercialID 
* @param address
* @param phone 
* @param account
*/
    public CommercialClient(String name, String commercialID, String address, String phone, Account account) {
        super(name, "0000000000", address, phone, account);
        this.commercialID = commercialID;
    }
/**
* Setters and Getters for attributes are constructed
     * @param commercial
*/
    public void setCID(String commercial) {
        commercialID = commercial;
    }

    String getCID() {
        return commercialID;
    }

    @Override
    public String toString() {
        return "\nName: " + getName() + "\nCommericalID: " + getCID() + "\nAddress: " + getAddress() + "\n\nAccount Data: \n" + getAccount();
    }
}

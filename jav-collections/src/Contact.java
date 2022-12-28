
public class Contact implements Comparable<Contact>{
    private String socialSecurityNumber;
    private String firstName;
    private String lastName;
    private String phoneNumber;

    public Contact(String socialSecurityNumber, String firstName, 
            String lastName, String phoneNumber) {
        this.socialSecurityNumber = socialSecurityNumber;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phoneNumber = phoneNumber;
    }
    public Contact(){
        
    }

    public String getSocialSecurityNumber() {
        return socialSecurityNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }
    
    @Override
    public String toString(){
        return getSocialSecurityNumber()+" "
                +getFirstName()+" "
                +getLastName()+" "
                +getPhoneNumber()+"\n";
    }

    @Override
    public int compareTo(Contact o) {
        return 1;
    }
    
}

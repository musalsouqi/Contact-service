package Contact;

public class Contact {
    private final String contactId;
    private String firstName;
    private String lastName;
    private String phone;
    private String address;

    // Constructor
    public Contact(String contactId, String firstName, String lastName, String phone, String address) {
        if (contactId == null || contactId.length() > 10) {
            throw new IllegalArgumentException("contactId not entered or is over 10 digits long");
        }
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("firstName not entered or is over 10 digits long");
        }
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("lastName not entered or is over 10 digits long");
        }
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("number is not 10 digits");
        }
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("address not entered or is over 30 characters");
        }

        this.contactId = contactId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.phone = phone;
        this.address = address;
    }

    // Getters
    public String getContactId() {
        return contactId;
    }

    public String getFirstName() {
        return firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public String getPhone() {
        return phone;
    }

    public String getAddress() {
        return address;
    }
    
    // Setters
    public void setFirstName(String firstName) {
        if (firstName == null || firstName.length() > 10) {
            throw new IllegalArgumentException("firstName not entered or is over 10 digits long");
        }
        this.firstName = firstName;
    }

    public void setLastName(String lastName) {
        if (lastName == null || lastName.length() > 10) {
            throw new IllegalArgumentException("lastName not entered or is over 10 digits long");
        }
        this.lastName = lastName;
    }

    public void setPhone(String phone) {
        if (phone == null || phone.length() != 10) {
            throw new IllegalArgumentException("number is not 10 digits");
        }
        this.phone = phone;
    }

    public void setAddress(String address) {
        if (address == null || address.length() > 30) {
            throw new IllegalArgumentException("address not entered or is over 30 characters");
        }
        this.address = address;
    }

}
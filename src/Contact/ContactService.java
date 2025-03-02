package Contact;

import java.util.HashMap;
import java.util.Map;

public class ContactService {
    // hashmap contacts
    private Map<String, Contact> contactMap = new HashMap<>();

    // Add new contact check for dups
    public void addContact(Contact contact) {
        if (contactMap.containsKey(contact.getContactId())) {
            throw new IllegalArgumentException("ID already exists");
        }
        contactMap.put(contact.getContactId(), contact);
    }

    // Deletes a contact
    public void deleteContact(String contactId) {
        contactMap.remove(contactId);
    }
    
    // get contact by Id
    public Contact getContact(String contactId) {
        if (!contactMap.containsKey(contactId)) {
            throw new IllegalArgumentException("No contact with that id.");
        }
        return contactMap.get(contactId);
    }

    // Updates first name
    public void updateFirstName(String contactId, String firstName) {
        Contact contact = getContact(contactId);
        contact.setFirstName(firstName);
    }

    // Updates last name
    public void updateLastName(String contactId, String lastName) {
        Contact contact = getContact(contactId);
        contact.setLastName(lastName);
    }

    // Updates phone number
    public void updatePhone(String contactId, String phone) {
        Contact contact = getContact(contactId);
        contact.setPhone(phone);
    }

    // Updates address 
    public void updateAddress(String contactId, String address) {
        Contact contact = getContact(contactId);
        contact.setAddress(address);
    }
}
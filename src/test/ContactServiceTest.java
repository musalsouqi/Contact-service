package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import Contact.Contact;
import Contact.ContactService;

class ContactServiceTest {

    private ContactService contactService;
    
    @BeforeEach
    void setUp() {
        contactService = new ContactService();
    }

    //Test to add contact
    @Test
    void testAddContact() {
        Contact contact = new Contact("1234567890", "Mustafa", "Alsouqi", "0123456789", "Fake Address Road");
        contactService.addContact(contact);
        Assertions.assertEquals(contact, contactService.getContact("1234567890"));
    }

    //Test to check duplicate Id
    @Test
    void testAddDuplicateContactID() {
        Contact contact1 = new Contact("1234567890", "Mustafa", "Alsouqi", "0123456789", "Fake Address Road");
        Contact contact2 = new Contact("1234567890", "John", "Doe", "9876543210", "Another Road");
        contactService.addContact(contact1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.addContact(contact2);
        });
    }

    //Test deleteContact method
    @Test
    void testDeleteContact() {
        Contact contact = new Contact("50", "Mustafa", "Alsouqi", "0123456789", "Fake Address Road");
        contactService.addContact(contact);
        contactService.deleteContact("50");
        
        //Trying to get contact that doesnt exist
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            contactService.getContact("50");
        });
    }

    //Tests updateFirstName method
    @Test
    void testUpdateFirstName() {
        Contact contact = new Contact("1234567890", "Mustafa", "Alsouqi", "0123456789", "Fake Address Road");
        contactService.addContact(contact);
        contactService.updateFirstName("1234567890", "Tommy");
        Assertions.assertEquals("Tommy", contactService.getContact("1234567890").getFirstName());
    }

    //Tests updateLastName method
    @Test
    void testUpdateLastName() {
        Contact contact = new Contact("1234567890", "Mustafa", "Alsouqi", "0123456789", "Fake Address Road");
        contactService.addContact(contact);
        contactService.updateLastName("1234567890", "Boy");
        Assertions.assertEquals("Boy", contactService.getContact("1234567890").getLastName());
    }

    //Test updatePhone method
    @Test
    void testUpdatePhone() {
        Contact contact = new Contact("1234567890", "Mustafa", "Alsouqi", "0123456789", "Fake Address Road");
        contactService.addContact(contact);
        contactService.updatePhone("1234567890", "9876543210");
        Assertions.assertEquals("9876543210", contactService.getContact("1234567890").getPhone());
    }

    //Test updateAdress method
    @Test
    void testUpdateAddress() {
        Contact contact = new Contact("1234567890", "Mustafa", "Alsouqi", "0123456789", "Fake Address Road");
        contactService.addContact(contact);
        contactService.updateAddress("1234567890", "Real Address Road");
        Assertions.assertEquals("Real Address Road", contactService.getContact("1234567890").getAddress());
    }

}

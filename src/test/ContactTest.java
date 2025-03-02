package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import Contact.Contact;

class ContactTest {

	//test for id longer than 10
	@Test
	void testContactLongerThanTen() {
		Assertions.assertThrows(IllegalArgumentException.class, () -> {
			new Contact( "12345678910" , "mustafa" , "alsouqi" , "0123456789", "fake address road");
		}); 
		
	}
	
	//test for id to not be null
    @Test
    void testContactIDNotNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact(null, "Mustafa", "Alsouqi", "0123456789", "Fake Address Road");
        });
    }
    
    //test for firstname longer than 10
    @Test
    void testFirstNameLongerThanTen() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "MustafaAlsouqi", "Alsouqi", "0123456789", "Fake Address Road");
        });
    }
    
    //test for first name to not be null
    @Test
    void testFirstNameNotNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", null, "Alsouqi", "0123456789", "Fake Address Road");
        });
    }
    
    
    // test for lastnam to be longer than 10
    @Test
    void testLastNameLongerThanTen() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Mustafa", "AlsouqiMustafa", "0123456789", "Fake Address Road");
        });
    }

    //test for lastname to not be null
    @Test
    void testLastNameNotNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Mustafa", null, "0123456789", "Fake Address Road");
        });
    }
    
    //Test to see if phone number =! 10 digits
    @Test
    void testPhoneNotTenDigits() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Mustafa", "Alsouqi", "123456789", "Fake Address Road");
        });
    }

    // tests to check if phone number is not null
    @Test
    void testPhoneNotNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Mustafa", "Alsouqi", null, "Fake Address Road");
        });
    }

    // test to check if address is longer than 30 digits/characters
    @Test
    void testAddressLongerThanThirty() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Mustafa", "Alsouqi", "0123456789", "This address is way too long for the field");
        });
    }

    //test to see if address is not null
    @Test
    void testAddressNotNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Contact("1234567890", "Mustafa", "Alsouqi", "0123456789", null);
        });
    }

    //test to see if contact created correctly
    @Test
    void testValidContactCreation() {
        Contact contact = new Contact("1234567890", "Mustafa", "Alsouqi", "0123456789", "Fake Address Road");
        Assertions.assertEquals("1234567890", contact.getContactId());
        Assertions.assertEquals("Mustafa", contact.getFirstName());
        Assertions.assertEquals("Alsouqi", contact.getLastName());
        Assertions.assertEquals("0123456789", contact.getPhone());
        Assertions.assertEquals("Fake Address Road", contact.getAddress());
    }

}

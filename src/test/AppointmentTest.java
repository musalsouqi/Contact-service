package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import appointment.Appointment;

import java.util.Date;
import java.util.Calendar;

class AppointmentTest {

    // Test for appointmentId longer than 10 characters
    @Test
    void testAppointmentIdLongerThanTen() {
        Date futureDate = getFutureDate();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("12345678910", futureDate, "Valid description.");
        });
    }

    // Test for appointmentId not being null
    @Test
    void testAppointmentIdNotNull() {
        Date futureDate = getFutureDate();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment(null, futureDate, "Valid description.");
        });
    }

    // Test for appointment date not being null
    @Test
    void testAppointmentDateNotNull() {
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", null, "Valid description.");
        });
    }

    // Test for appointment date not being in the past
    @Test
    void testAppointmentDateNotInPast() {
        Date pastDate = getPastDate();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", pastDate, "Valid description.");
        });
    }

    // Test for description longer than 50 characters
    @Test
    void testDescriptionLongerThanFifty() {
        Date futureDate = getFutureDate();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", futureDate, "This description is way too long and exceeds the fifty-character limit.");
        });
    }

    // Test for description not being null
    @Test
    void testDescriptionNotNull() {
        Date futureDate = getFutureDate();
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            new Appointment("1234567890", futureDate, null);
        });
    }

    // Test for valid appointment creation
    @Test
    void testValidAppointmentCreation() {
        Date futureDate = getFutureDate();
        Appointment appointment = new Appointment("1234567890", futureDate, "Valid description.");
        Assertions.assertEquals("1234567890", appointment.getAppointmentId());
        Assertions.assertEquals(futureDate, appointment.getAppointmentDate());
        Assertions.assertEquals("Valid description.", appointment.getDescription());
    }

    // Helper method to get a future date
    private Date getFutureDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, 1); // Adds one day to the current date
        return calendar.getTime();
    }

    // Helper method to get a past date
    private Date getPastDate() {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, -1); // Subtracts one day from the current date
        return calendar.getTime();
    }
}
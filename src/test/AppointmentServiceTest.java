package test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import appointment.Appointment;
import appointment.AppointmentService;

import java.util.Date;
import java.util.Calendar;

class AppointmentServiceTest {

    private AppointmentService appointmentService;

    @BeforeEach
    void setUp() {
        appointmentService = new AppointmentService();
    }

    // Test to add an appointment
    @Test
    void testAddAppointment() {
        Date futureDate = getFutureDate();
        Appointment appointment = new Appointment("1234567890", futureDate, "Valid description.");
        appointmentService.addAppointment(appointment);
        Assertions.assertEquals(appointment, appointmentService.getAppointment("1234567890"));
    }

    // Test to check duplicate appointmentId
    @Test
    void testAddDuplicateAppointmentId() {
        Date futureDate = getFutureDate();
        Appointment appointment1 = new Appointment("1234567890", futureDate, "Valid description.");
        Appointment appointment2 = new Appointment("1234567890", futureDate, "Another description.");
        appointmentService.addAppointment(appointment1);
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.addAppointment(appointment2);
        });
    }

    // Test deleteAppointment method
    @Test
    void testDeleteAppointment() {
        Date futureDate = getFutureDate();
        Appointment appointment = new Appointment("50", futureDate, "Valid description.");
        appointmentService.addAppointment(appointment);
        appointmentService.deleteAppointment("50");

        // Trying to get an appointment that doesnt exist
        Assertions.assertThrows(IllegalArgumentException.class, () -> {
            appointmentService.getAppointment("50");
        });
    }

    // method to get a future date
    private Date getFutureDate() {
        Calendar calendar = Calendar.getInstance();
        // Adds one day to the current date i think -----FIXME if not working dont forget to delete print in appointment
        calendar.add(Calendar.DATE, 1); 
        return calendar.getTime();
    }
}
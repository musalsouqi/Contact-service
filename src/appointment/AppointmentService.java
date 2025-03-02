package appointment;

import java.util.HashMap;
import java.util.Map;

public class AppointmentService {
    private Map<String, Appointment> appointmentMap = new HashMap<>();

    // Adds a new appointment with a unique ID
    public void addAppointment(Appointment appointment) {
        if (appointmentMap.containsKey(appointment.getAppointmentId())) {
            throw new IllegalArgumentException("ID already exists");
        }
        appointmentMap.put(appointment.getAppointmentId(), appointment);
    }

    // Deletes an appointment
    public void deleteAppointment(String appointmentId) {
        if (!appointmentMap.containsKey(appointmentId)) {
            throw new IllegalArgumentException("No appointment with that id.");
        }
        appointmentMap.remove(appointmentId);
    }

    // Retrieves an appointment by ID
    public Appointment getAppointment(String appointmentId) {
        if (!appointmentMap.containsKey(appointmentId)) {
            throw new IllegalArgumentException("No appointment with that id.");
        }
        return appointmentMap.get(appointmentId);
    }
}
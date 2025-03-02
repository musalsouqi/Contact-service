package appointment;

import java.util.Date;

public class Appointment {
    private final String appointmentId; // Unique and cannot be changed
    private final Date appointmentDate;
    private final String description;

    // Constructor
    public Appointment(String appointmentId, Date appointmentDate, String description) {
        if (appointmentId == null || appointmentId.length() > 10) {
            throw new IllegalArgumentException("appointmentId not entered or is over 10 characters long");
        }
        if (appointmentDate == null || appointmentDate.before(new Date())) {
            throw new IllegalArgumentException("appointmentDate cannot be null or in the past");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("description not entered or is over 50 characters long");
        }

        this.appointmentId = appointmentId;
        this.appointmentDate = appointmentDate;
        this.description = description;
    }

    // Getters
    public String getAppointmentId() {
        return appointmentId;
    }

    public Date getAppointmentDate() {
        return appointmentDate;
    }

    public String getDescription() {
        return description;
    }
}
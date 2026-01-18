package entity;

import java.time.LocalDate;

public class Appointment {
    private int id;
    private int userId;
    private int serviceId;
    private int timeSlotId;
    private LocalDate appointmentDate;
    private String status;

    public Appointment() {}

    public Appointment(int id, int userId, int serviceId, int timeSlotId,
                       LocalDate appointmentDate, String status) {
        this.id = id;
        this.userId = userId;
        this.serviceId = serviceId;
        this.timeSlotId = timeSlotId;
        this.appointmentDate = appointmentDate;
        this.status = status;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }

    public int getServiceId() {
        return serviceId;
    }

    public void setServiceId(int serviceId) {
        this.serviceId = serviceId;
    }

    public int getTimeSlotId() {
        return timeSlotId;
    }

    public void setTimeSlotId(int timeSlotId) {
        this.timeSlotId = timeSlotId;
    }

    public LocalDate getAppointmentDate() {
        return appointmentDate;
    }

    public void setAppointmentDate(LocalDate appointmentDate) {
        this.appointmentDate = appointmentDate;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}

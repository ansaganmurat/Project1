package service;

import entity.Appointment;
import entity.TimeSlot;
import repository.interfaces.IAppointmentRepository;
import repository.interfaces.ITimeSlotRepository;
import java.util.List;

public class AppointmentService {

    private final IAppointmentRepository appointmentRepo;
    private final ITimeSlotRepository slotRepo;

    public AppointmentService(IAppointmentRepository appointmentRepo, ITimeSlotRepository slotRepo) {
        this.appointmentRepo = appointmentRepo;
        this.slotRepo = slotRepo;
    }

    public String book(int userId, int serviceId, int slotId) {
        List<TimeSlot> allSlots = slotRepo.getAllSlots();
        TimeSlot selectedSlot = null;

        for (TimeSlot s : allSlots) {
            if (s.getId() == slotId) {
                selectedSlot = s;
                break;
            }
        }

        if (selectedSlot == null) {
            return "Error: Slot not found!";
        }

        if (!selectedSlot.isAvailable()) {
            return "Error: Slot is already occupied!";
        }

        Appointment appointment = new Appointment(userId, serviceId, slotId);
        boolean isSaved = appointmentRepo.makeAppointment(appointment);

        if (isSaved) {
            selectedSlot.setAvailable(false);
            // Тут важно: Участник 4 должен будет вызвать метод обновления в БД,
            // либо ты можешь добавить метод updateAvailability в TimeSlotRepository.
            return "Booking successful!";
        }

        return "Database error.";
    }

    public List<TimeSlot> getAvailableSlots() {
        // Фильтруем только свободные слоты из твоего метода getAllSlots
        List<TimeSlot> allSlots = slotRepo.getAllSlots();
        allSlots.removeIf(slot -> !slot.isAvailable());
        return allSlots;
    }
}
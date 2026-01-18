package entity;

import java.time.LocalTime;

public class TimeSlot {
    private int id;
    private LocalTime slotTime;

    public TimeSlot() {}

    public TimeSlot(int id, LocalTime slotTime) {
        this.id = id;
        this.slotTime = slotTime;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public LocalTime getSlotTime() {
        return slotTime;
    }

    public void setSlotTime(LocalTime slotTime) {
        this.slotTime = slotTime;
    }
}

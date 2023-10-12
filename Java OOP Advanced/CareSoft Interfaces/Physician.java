import java.util.ArrayList;
import java.util.Date;

public class Physician extends User implements HIPAACompliantUser {
    private ArrayList<String> patientNotes;

    public Physician(Integer id) {
        super(id);
        this.patientNotes = new ArrayList<>();
    }

    @Override
    public boolean assignPin(int pin) {
        if (pin >= 1000 && pin <= 9999) {
            setPin(pin);
            return true;
        }
        return false;
    }

    @Override
    public boolean accessAuthorized(Integer confirmedAuthID) {
        return getId().equals(confirmedAuthID);
    }

    public void newPatientNotes(String notes, String patientName, Date date) {
        // Implementation of newPatientNotes method
    }

    // Getters and setters for patientNotes
}

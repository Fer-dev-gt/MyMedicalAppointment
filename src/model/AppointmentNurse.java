package model;
import java.util.Date;
public class AppointmentNurse implements ISchedulable{                                                                  // Voy a implementar mi interface "ISchedulable"
    private int id;
    private String time;
    private Date date;
    private Nurse nurse;
    private Patient patient;


    // Getters y Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Nurse getNurse() {
        return nurse;
    }
    public void setNurse(Nurse nurse) {
        this.nurse = nurse;
    }

    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }
    public void setTime(String time) {
        this.time = time;
    }

    @Override                                                                                                           // Sobreescribí e implementé un método
    public void schedule(Date date, String time) {

    }
}

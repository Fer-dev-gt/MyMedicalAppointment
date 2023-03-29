package model;
import java.util.Date;

public class AppointmentDoctor implements ISchedulable{
    private int id;
    private Patient patient;                                        // Esta clase albergará referencias de las otras clases (Patient)
    private Doctor doctor;                                          // Esta clase albergará referencias de las otras clases (Doctor)
    private Date date;
    private String time;

    // Constructores
    public AppointmentDoctor(Patient patient, Doctor doctor) {
        this.patient = patient;
        this.doctor = doctor;
    }


    // Getters y Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }

    public Patient getPatient() {
        return patient;
    }
    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public Doctor getDoctor() {
        return doctor;
    }
    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public Date getDate() {
        return date;
    }
    public void setDate(Date date) {
        this.date = date;
    }

    public String getTime() {                                                   // Le digo el formato deseado
        return time + " hrs.";
    }
    public void setTime(String time) {
        this.time = time;
    }


    @Override
    public void schedule(Date date, String time) {
        this.date = date;
        this.time = time;
    }
}

package model;
import java.util.Date;

public class AppointmentDoctor implements ISchedulable{
    private int id;
    private Date date;
    private String time;
    private Patient patient;                                                                                            // Esta clase albergará referencias de las otras clases (Patient)
    private Doctor doctor;                                                                                              // Esta clase albergará referencias de las otras clases (Doctor)

    public AppointmentDoctor(Patient patient, Doctor doctor) {                                                          // Constructor que recibo como parámetros dos objeto, un tipo Doctor y un tipo Patient
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
    public void schedule(Date date, String time) {                                                                      // Defino un "Constructor" para "schedule" que es implementado de la Interfase "ISchedulable" que recibe 2 parámetros
        this.date = date;
        this.time = time;
    }
}

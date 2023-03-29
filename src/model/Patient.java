package model;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User{
    private String  birthday;                                               // "private" se usa para que estas variables no puedan ser editadas o cambiadas desde afuera de esta Clase
    private String  blood;
    private double weight;
    private double height;

    // Voy a crear 2 lista donde queden guardadas las citas de nuestros pacientes
    private ArrayList<AppointmentDoctor> appointmentDoctors = new ArrayList<>();
    private ArrayList<AppointmentNurse> appointmentNurses = new ArrayList<>();

    public Patient(String name, String correo){
        super(name, correo);                                                // "super" representa al objeto padre "model.User" y será creada cuando cree una clase Padre
    }

    // Declaro "Setters y Getters" de mi clase Patients
    public void setWeight(double weight){                                   // Se le pone "public" para que este método sea accesible desde cualquier clase
        this.weight = weight;
    }
    public String getWeight(){          // Método getter (Aquí puede establecer las reglas o el formato con el cual voy a devolver mis datos) estas reglas no tienen que establecerse fuera de esta clase y sera un dato String
        return this.weight + " Kg.";
    }

    public String getHeight() {
        return height + " Metros";
    }
    public void setHeight(double height) {
        this.height = height;
    }

    public String getBirthday() {
        return birthday;
    }
    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBlood() {
        return blood;
    }
    public void setBlood(String blood) {
        this.blood = blood;
    }

    public ArrayList<AppointmentDoctor> getAppointmentDoctors() {
        return appointmentDoctors;
    }

    public void addAppointmentDoctors(Doctor doctor, Date date, String time) {                              // Este era el método Setter, le cambié el nombre
        AppointmentDoctor appointmentDoctor = new AppointmentDoctor(this, doctor);
        appointmentDoctor.schedule(date, time);
        appointmentDoctors.add(appointmentDoctor);
    }

    public ArrayList<AppointmentNurse> getAppointmentNurses() {
        return appointmentNurses;
    }
    public void setAppointmentNurses(ArrayList<AppointmentNurse> appointmentNurses) {
        this.appointmentNurses = appointmentNurses;
    }


    @Override                                                                                               // Sobreescribo para agregar comportamientos extras para que me retorne información extra
    public String toString() {
        return super.toString() + "\nAge: " + birthday + "\nWeight: " + weight + "\nHeight: " + height + "\nBlood: " + blood;
        /*Al imprimir cualquier objeto en la consola con System.out.println(object), en realidad, estamos ejecutando el método ".toString()" de dicho objeto,
        por lo que si sobreescribimos este método en nuestras clases, el resultado en la consola también cambiará automáticamente. */
    }

    @Override
    public void showDataUser() {
        System.out.println("Paciente");
        System.out.println("Historial completa desde nacimiento");
    }

}

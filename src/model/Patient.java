package model;

import java.util.ArrayList;
import java.util.Date;

public class Patient extends User{
    private String  birthday, blood; // Les puse "private" para que estas variables no puedan ser editadas o cambiadas desde afuera de esta Clase
    private double weight, height;                  // Les puse "private" para que estas variables no puedan ser editadas o cambiadas desde afuera de esta Clase

    // Voy a crear 2 lista donde queden guardadas las citas de nuestros pacientes
    private ArrayList<AppointmentDoctor> appointmentDoctors = new ArrayList<>();
    private ArrayList<AppointmentNurse> appointmentNurses = new ArrayList<>();

    public Patient(String name, String correo){
        super(name, correo);            // "super" representa al objeto padre "model.User" y será creada cuando cree una clase Padre
        // System.out.println(weight + " Kg.");        // Este adorno que le puse al "weight (Kg.) no lo van a poder modificar desde afuera de esta clase"
    }

    // Declaracion de mis metodos "Setters y Getters" de mi clase Patients
    // método setter, le daré valor de 54.5
    public void setWeight(double weight){       // Se le pone "public" para que este metodo sea accesible desde cualquier clase
        this.weight = weight;
    }

    // método getter   (Aqui puede establecer las reglas o el formato con el cual voy a devolver mis datos) estas reglas no tienen que establecerse fuera de esta clase
    // regresara 54.5 Kg. y sera un dato String
    public String getWeight(){
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

    public void addAppointmentDoctors(Doctor doctor, Date date, String time) {
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

    // Sobre escribo para agregar comportamientos extras para que me retorne información extra
    /*Al imprimir cualquier objeto en la consola con System.out.println(object), en realidad, estamos ejecutando el método .toString() de dicho objeto,
    por lo que si sobreescribimos este método en nuestras clases, el resultado en la consola también cambiará automáticamente.
     */
    @Override
    public String toString() {
        return super.toString() + "\nAge: " + birthday + "\nWeight: " + weight + "\nHeight: " + height + "\nBlood: " + blood;
    }

    @Override
    public void showDataUser() {
        System.out.println("Paciente");
        System.out.println("Historial completa desde nacimiento");
    }

    // Al usar la combinacion "cmd + n" el IDE me dara sugerencias para declarar mis "Getters y Setters"
}

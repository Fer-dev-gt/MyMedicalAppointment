package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class Doctor extends User{
    private String speciality;   // Estas variables globales estarán relacionadas cuando "Instanciamos un objeto" usando "this" en un constructor
    private ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();                  // Instanciamos un nuevo ArrayList
    public Doctor(String name, String correo){ // También podemos crear otro "Método Constructor" que reciba ciertos Parámetros (Sobrecarga de Constructores)
        super(name, correo);
    }

    // Colección de objetos tipo AvailableAppointment ("ArrayList")
    public void addAvailableAppointment(String date, String time){              // Creo método de la clase model.Doctor para poder agregar citas
        availableAppointments.add(new AvailableAppointment(date, time));        // Cada vez que añada una nueva cita estaré creando un nuevo objeto y lo estaré agregando a mi "ArrayList" ("Coleccion de Objetos")
        // Si instanció por "fuera" puedo usar la sintaxis: model.Doctor.AvailableAppointment(date, time)
    }

    // Voy a Sobreescribir el método toString() de la clase model.Doctor para darle el formato que deseo
    // Voy a usar el comportamiento "toString()" de la Superclase (Padre/model.User) y solo le voy a agregar datos extras
    @Override
    public String toString() {
        return super.toString() + "\nSpeciality: " + speciality + "\nAvailable: " + availableAppointments.toString();
    }

    // Estoy implementando el "Método Abstracto" de la Clase padre "User"
    @Override
    public void showDataUser() {
        System.out.println("Hospital: Cruz Roja");
        System.out.println("Departamento: Cardiología");
    }

    public String getSpeciality() {
        return speciality;
    }
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public ArrayList<AvailableAppointment> getAvailableAppointments(){
        return availableAppointments;
    } // Establezco mi Getter de mi ArrayList



    public static class AvailableAppointment{       // Aca declaro mi clase independiente, "Clase anidada static"
        //  Available Appointment
        private int id;
        private Date date;  // La clase "Date" la importe de una libreria
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");                    // Esta clase nos va a ayudar a trabajar con fechas, le puedo colocar el patrón de fecha que yo quiera

        // Establezco el constructor
        public AvailableAppointment(String date, String time) {
            try{                                          // Utilizo un try-catch para mantener el flujo del programa
                this.date = format.parse(date);           // Acá convierto un String a un Date (Es mejor parsear en la definición del método y no en la implementación)
            }catch (ParseException e){
                e.printStackTrace();
            }
            this.time = time;
        }

        // Estable<co los "Getters y Setters"
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }
        public Date getDate(String DATE) {
            return date;
        }
        // Voy a crear un método "get" para que devuelva la fecha de tipo Date a tipo String (Este recibe un parámetro)
        public String getDate(){
            return format.format(date);
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

        // Voy a Sobreescribir el método toString() de la "Clase Inner" AvailableAppointment para darle el formato que deseo
        @Override
        public String toString() {
            return "Available Appointments: \n Dato: " + date + "\nTime: " + time;
        }
    }
}

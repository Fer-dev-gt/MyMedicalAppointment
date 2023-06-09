package model;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
public class Doctor extends User{
    private String speciality;                                                                                  // Estas variables globales estarán relacionadas cuando "Instanciamos un objeto" usando "this" en un constructor
    private ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();                          // Colección de objetos tipo AvailableAppointment ("ArrayList"). Instanciamos un nuevo ArrayList
    public Doctor(String name, String correo){                                                                  // También podemos crear otro "Método Constructor" que reciba ciertos Parámetros (Sobrecarga de Constructores)
        super(name, correo);
    }

    public ArrayList<AvailableAppointment> getAvailableAppointments(){                                          // Establezco mi Getter de mi ArrayList
        return availableAppointments;
    }
    public void addAvailableAppointment(String date, String time){                                              // Creo método de la clase model.Doctor para poder agregar citas
        availableAppointments.add(new AvailableAppointment(date, time));                                        // Cada vez que añada una nueva cita estaré creando un nuevo objeto y lo estaré agregando a mi "ArrayList" ("Colección de Objetos")
    }                                                                                                           // Estoy instanciando un nuevo objeto de mi clase anidada "AvailableAppointment"

    public String getSpeciality() {
        return speciality;
    }
    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    @Override                                                                                                   // Voy a Sobreescribir el método toString() de la clase model.Doctor para darle el formato que deseo
    public String toString() {                                                                                  // Voy a usar el comportamiento "toString()" de la Superclase (Padre/model.User) y solo le voy a agregar datos extras
        return super.toString() + "\nSpeciality: " + speciality + "\nAvailable: " + availableAppointments.toString();
    }

    @Override
    public void showDataUser() {                                                                                // Estoy implementando el "Método Abstracto" de la Clase padre "User"
        System.out.println("Hospital: Cruz Roja");
        System.out.println("Departamento: Cardiología");
    }








    public static class AvailableAppointment{                                                   // Aca declaro mi clase independiente, "Clase anidada static"
        private int id;
        private Date date;                                                                      // La clase "Date" la importe de una librería
        private String time;
        SimpleDateFormat format = new SimpleDateFormat("dd/MM/yyyy");                    // Esta clase nos va a ayudar a trabajar con fechas, le puedo colocar el patrón de fecha que yo quiera

        public AvailableAppointment(String date, String time) {                                 // Establezco el constructor, que recibo dos parámetros tipo String
            try{                                                                                // Utilizo un try-catch para mantener el flujo del programa
                this.date = format.parse(date);                                                 // Acá convierto un String a un Date (Es mejor hacerlo en la definición del método y no en la implementación)
            }catch (ParseException errorParseo){
                errorParseo.printStackTrace();
            }
            this.time = time;
        }

        // Establezco los "Getters y Setters"
        public int getId() {
            return id;
        }
        public void setId(int id) {
            this.id = id;
        }

        public Date getDate(String DATE) {                                                                              // Voy a crear un método "get" para que devuelva la fecha de tipo String a tipo Date (Este recibe un parámetro)
            return date;
        }
        public String getDate(){                                                                                        // Combierto el dato tipo Date a un String
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

        @Override                                                                               // Voy a Sobreescribir el método toString() de la "Clase Inner" AvailableAppointment para darle el formato que deseo
        public String toString() {
            return "Available Appointments: \n Dato: " + date + "\nTime: " + time;
        }
    }
}

import java.util.ArrayList;
import java.util.Date;
public class Doctor extends User{
    // Atributos
    // Estas variables globales estaran relacionadas cuando "Instanciamos un objeto" usando "this" en un constructor
    //static int id = 0;                     Convertiros a "id" de una "variable de Instancia" a una "variable de Clase" usando "static" (obtiene un aspecto de cursiva)
    private String speciality;




    // Java nos define por defecto un constructor por cada clase, pero nosotros podemos definirlo por nuestra cuenta
    /*Doctor(){
        System.out.println("Construyendo el Objeto 'Doctor'");          // Acá estoy añadiendo un comportamiento extra cuando se invoca al contructor por "defecto"
    }*/


    // También podemos crear otro "Método Constructor" que reciba ciertos Parametros (Sobrecarga de Constructores)
    Doctor(String name, String correo){
        super(name, correo);
        System.out.println("El nombre del doctor es: " + name);
        //this.name = name;
        this.speciality = speciality;
    }
    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }



    /* Métodos-Comportamientos
    public void showName(){
        System.out.println(name);
    }

    public void showId(){
        System.out.println("ID Doctor: " + id);
    }*/





    // Coleccion de objetos tipo AvailableAppointment ("ArrayList")
    ArrayList<AvailableAppointment> availableAppointments = new ArrayList<>();                  // Instanciamos un nuevo ArrayList
    // Creo método de la clase Doctor para poder agregar citas
    public void addAvailableAppointme(Date date, String time){
        availableAppointments.add(new AvailableAppointment(date, time));        // Cada vez que añada una nueva cita estaré creando un nuevo objeto y lo estaré agregando a mi "ArrayList" ("Coleccion de Objetos")
        // Si instacion por "fuera" puedo usar la sintaxis: Doctor.AvailableAppointment(date, time)

    }
    // Establezco mi Getter de mi ArrayList
    public ArrayList<AvailableAppointment> getAvailableAppointments(){
        return availableAppointments;
    }





    // Aca declaro mi clase independiente, "Clase anidada static"
    public static class AvailableAppointment{
        //  Available Appointment
        private int id;
        private Date date;  // La clase "Date" la importe de una libreria
        private String time;
        // Establesco el constructor


        public AvailableAppointment(Date date, String time) {
            this.date = date;
            this.time = time;
        }
        // Establesco los "Getters y Setters"

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
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
    }
}

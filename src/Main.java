import static ui.UIMenu.*;                                                 // Estoy importantando todos los metodos y atributos de la clase "ui" usando "static"
import java.util.Date;
public class Main {
    public static void main(String[] args) {

        // Manera corta de instanciar un objeto de la clase "Doctor"
        Doctor myDoctor = new Doctor("Jeremmy Jones", "Cardiologo");             // Al darle un parametro estoy escogiendo el otro "Método Constructor" que declare
        //myDoctor.name = "Fernando Orozco";


        // Voy a agregar una nueva cita usando "Clases Anidadas"
        myDoctor.addAvailableAppointme(new Date(), "4pm");
        myDoctor.addAvailableAppointme(new Date(),"10am");
        myDoctor.addAvailableAppointme(new Date(), "1pm");

        // Ahora voy a imprimir mis citas
        System.out.println("Va a imprimar las referencias/ubicaciones de mis objetos");
        System.out.println(myDoctor.getAvailableAppointments());

        // Ahora voy a imprimir las citas que estan disponibles usando "for each"
        for (Doctor.AvailableAppointment availableAppointment: myDoctor.getAvailableAppointments()) {
            System.out.println(availableAppointment.getDate() + " " +  availableAppointment.getTime());
        }

        //myDoctor.showName();                                            // Estoy usando el metodo de la clase "Doctor" que esta en otro archivo (Modularizado)
        System.out.println("");

        // Otra forma de Inicializar un objeto de la clase "Doctor"
        Doctor anotherDoctor;
        // anotherDoctor = new Doctor();                                   // Utilicé el "Método Constructor" que Java me declara por defecto
        //anotherDoctor.name = "Juanito Perez";
        //anotherDoctor.showName();
        //anotherDoctor.showId();
        // System.out.println(Doctor.id);

        // Doctor myDoctorAlex = new Doctor();
        //myDoctorAlex.name = "Alex Contreras";
        //myDoctorAlex.showName();
        //myDoctorAlex.showId();
        // System.out.println(Doctor.id);                                  // Otra forma de imprimir la "variable de Clase"

        //Doctor.id++;                                                    // Puedo alterar la "Varible de Clases" de manera independiente

        //Doctor myDoctorLuis = new Doctor();
        //myDoctorLuis.name = "Luis Gómez";
        //myDoctorLuis.showName();
        //System.out.println(Doctor.id);

        // Intancio un objeto tipo Doctor a quien le doy 2 valores por defecto (nombre y especialidad)
        Doctor doctorProfesional = new Doctor("Sofia Ramirez", "Cirugana");
        //System.out.println(doctorProfesional.name);
        //ystem.out.println(doctorProfesional.speciality);

        // Intancio un objeto tipo Patient a quien le asigno 2 valores al inicializarlo (nombre y correo)
        Patient myPatient = new Patient("Renata Garcia", "RenataGar@gmail.com");
        Patient myPatient2 = new Patient("Anahí", "anahi@gmail.com");








        System.out.println(myPatient);          // Ahora estos dos souts nos imprimiran sus direcciones de memoria correspondientes
        System.out.println(myPatient2);
        System.out.println(myPatient.getName());
        System.out.println(myPatient2.getName());
        myPatient2 = myPatient;     // Aqui le estoy asigno la direccion de memoria de mi objeto "myPatient" a myPatient 2 (Esto se comporta de manera distinta a cuando son datos primitivos)

        // Ahora mis dos objetos tipo Patient estan apuntando a la misma dirección de memoria (a la de "myPatient")
        System.out.println(myPatient);
        System.out.println(myPatient2);
        System.out.println(myPatient.getName());
        System.out.println(myPatient2.getName());

        // Ahora si modifico un valor de cualquiera de estas variables que guardan la misma direccion de memoria de mi objeto se afectara a las dos variables
        myPatient2.setName("Manuel");
        System.out.println(myPatient);
        System.out.println(myPatient2);
        System.out.println(myPatient.getName());
        System.out.println(myPatient2.getName());

        // Estoy usando mis medotos "Getters y Setters ya declarados"
        myPatient.setWeight(54.5);
        System.out.println(myPatient.getWeight());
        // Al darle un # de telefóno con más de 8 digitos el método Getter me mostrara un mensaje que informa que el dato tiene que ser de 8 digito
        myPatient.setPhoneNumber("123456789");
        System.out.println(myPatient.getPhoneNumber()); // Al no cumplir la condicion, el valor se queda como "null"
        // Ahora mi input si cumplira con las condiciones establecidas en mi "setPhoneNumber"
        myPatient.setPhoneNumber("12345678");
        System.out.println(myPatient.getPhoneNumber()); // Al no cumplir la condicion, el valor se queda como "null"

        int i = 0;
        int b = 2;
        b = i;          // Ahora "b" es igual a 0
        // Ya no puedo modificar estos atributos ya que se encuentran protegidas al usar "Encapsulamiento y private"
        // System.out.println(myPatient.name);
        // System.out.println(myPatient.email);
        // myPatient.weight = 60.5;
        // myPatient.height = 1.65;
        // System.out.println(myPatient.weight);
        // System.out.println(myPatient.height);
        // myPatient.weight = 800.3;
        // myPatient.name = "Juan";






        //ui.UIMenu.showMenu();                                              // Estoy llamando al "Método de Clase" que contiene instrucciones para realizar un menu general y otro menu de pacientes
        //showMenu();



    }

}
import model.*;

import java.util.Date;

import static ui.UIMenu.showMenu;

public class Main {
    public static void main(String[] args) {

        // Manera corta de instanciar un objeto de la clase "model.Doctor"
        Doctor myDoctor = new Doctor("Jeremmy Jones", "Cardiologo");             // Al darle un parametro estoy escogiendo el otro "Método Constructor" que declare
        //myDoctor.name = "Fernando Orozco";

        // Voy a agregar una nueva cita usando "Clases Anidadas"
        //myDoctor.addAvailableAppointment(new Date(), "4pm");
        //myDoctor.addAvailableAppointment(new Date(),"10am");
        //myDoctor.addAvailableAppointment(new Date(), "1pm");

        // Voy a instanciar un objeto de la clase hija "Doctor" usando la "Clase Abstracta" "User" (No puedo instanciar directamente "User" ya que es una clase Abstracta)
        User userDoctor = new Doctor("Anahi", "ana@ana.com");
        userDoctor.showDataUser();    // Ahora muestro el "Método Abstracto" que redefiní en la clase Doctor

        // Ahora haré lo mismo pero con un "Patient"
        User userPatient = new Patient("Javier", "Javier@Enfermo.com");
        userPatient.showDataUser();

        // Ejemplo de como instanciar una "Clase Abstracta" usando una "Clase Anónima"
        User userOne = new User("UsuarioEspecial", "Usuario@especial.com") {
            @Override               // Ahora puedo darle el comportamiento que yo quiera y que solo será vigente para este lapso de tiempo preciso
            public void showDataUser() {
                System.out.println("Doctor\n");
                System.out.println("Hospital: Cruz Verde");
                System.out.println("Departamento: Geriatría");
            }
        };
        userOne.showDataUser();

        // Ahora haremos algo parecido pero utilizando una "Interfaz"
        ISchedulable iSchedulable = new ISchedulable() {
            @Override
            public void schedule(Date date, String time) {

            }
        };

        //ISchedulable iSchedulable1 = new AppointmentDoctor();
        //iSchedulable1.schedule();


        // Ahora voy a imprimir mis citas
        System.out.println("Va a imprimar las referencias/ubicaciones de mis objetos");
        System.out.println(myDoctor.getAvailableAppointments());

        // Ahora voy a imprimir las citas que estan disponibles usando "for each"
        for (Doctor.AvailableAppointment availableAppointment: myDoctor.getAvailableAppointments()) {
            System.out.println(availableAppointment.getDate() + " " +  availableAppointment.getTime());
        }

        // Otra forma de Inicializar un objeto de la clase "model.Doctor"
        Doctor anotherDoctor;
        // anotherDoctor = new model.Doctor();                                   // Utilicé el "Método Constructor" que Java me declara por defecto
        //anotherDoctor.name = "Juanito Perez";
        //anotherDoctor.showName();
        //anotherDoctor.showId();
        // System.out.println(model.Doctor.id);

        //  User user = new User();             // Al ser una Clase Abstracta ya no podre instanciara mas objetos de tipo User

        // model.Doctor myDoctorAlex = new model.Doctor();
        //myDoctorAlex.name = "Alex Contreras";
        //myDoctorAlex.showName();
        //myDoctorAlex.showId();
        // System.out.println(model.Doctor.id);                                  // Otra forma de imprimir la "variable de Clase"

        //model.Doctor.id++;                                                    // Puedo alterar la "Varible de Clases" de manera independiente

        //model.Doctor myDoctorLuis = new model.Doctor();
        //myDoctorLuis.name = "Luis Gómez";
        //myDoctorLuis.showName();
        //System.out.println(model.Doctor.id);

        // Intancio un objeto tipo model.Doctor a quien le doy 2 valores por defecto (nombre y especialidad)
        Doctor doctorProfesional = new Doctor("Sofia Ramirez", "Sofia@gmail.com");

        // Intancio un objeto tipo model.Patient a quien le asigno 2 valores al inicializarlo (nombre y correo)
        Patient myPatient = new Patient("Renata Garcia", "RenataGar@gmail.com");
        Patient myPatient2 = new Patient("Anahí", "anahi@gmail.com");

        // Cuando imprimo estos objetos estoy utilizando implícitamente el método "toString()" el cual ya modifiqué en sus respectivas clases
        System.out.println(myPatient);          // Ahora estos dos souts nos imprimiran sus direcciones de memoria correspondientes
        System.out.println(myPatient2);
        System.out.println(myPatient.getName());
        System.out.println(myPatient2.getName());
        myPatient2 = myPatient;     // Aqui le estoy asigno la direccion de memoria de mi objeto "myPatient" a myPatient 2 (Esto se comporta de manera distinta a cuando son datos primitivos)

        // Ahora mis dos objetos tipo model.Patient estan apuntando a la misma dirección de memoria (a la de "myPatient")
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

        showMenu();

    }
}
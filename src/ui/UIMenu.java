package ui;
import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {
    public static final String[] MONTHS = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    public static Doctor doctorLogged;                                                                                  // Variables estáticas/ Variables de entorno, pertenecen a la clase y no a una instancia de la clase, son instancias de una clase
    public static Patient patientLogged;                                                                                // Con las variables estáticas solo existirá una copia de la variable sin importar cuantos objetos existan

    public static void showMenu(){                                                                                      // Método base, muestra el menú inicial
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int responseTypeUser = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);                                                                        // Forma de capturar el input del usuario por medio del teclado
            responseTypeUser = Integer.valueOf(sc.nextLine());

            switch (responseTypeUser){
                case 1:
                    System.out.println("Doctor");
                    responseTypeUser = 0;
                    authUser(1);                                                                               // Invoco método para autenticar el usuario
                    break;
                case 2:
                    responseTypeUser = 0;
                    authUser(2);                                                                               // Invoco método para autenticar el usuario
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (responseTypeUser != 0);
    }


    private static void authUser(int userType){                                                  // Método para autenticar el tipo de usuario, ya que es una clase estática necesito que todos los métodos sean estáticos. El parámetro viene del menú principal

        ArrayList<Doctor> doctors = new ArrayList<>();                                           // Lista de Doctores, le agrego la instanciación de algunos objetos tipo Doctor
        doctors.add(new Doctor("Alejandro Martínez", "alejandro@gmail.com"));       // Voy a hacer una simulación en donde ya tengo algunos doctores y pacientes registrados en unas listas "ArrayList"
        doctors.add(new Doctor("Karen Sosa", "karen@gmail.com"));
        doctors.add(new Doctor("Rocío Gómez","rocio@gmail.com"));

        ArrayList<Patient> patients = new ArrayList<>();                                        // Lista de Patients y le agrego la instanciación de algunos objetos tipo Patient
        patients.add(new Patient("Anahí Salgado", "anahi@gmail.com"));
        patients.add(new Patient("Roberto Rodríguez", "roberto@gmail.com"));
        patients.add(new Patient("Carlos Sánchez", "carlos@gmail.com"));

        boolean correctEmail = false;                                                           // Verifico que el correo ingresado coincida con alguno de los correos ya registrados en mi lista
        do {
            System.out.println("Insert your email: [a@a.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();

            if (userType == 1){                                                                  // Verifico si es un Doctor
                for (Doctor doctor : doctors){                                                   // Forma de recorrer una lista de Objetos para encontrar el correo ingresado
                    if (doctor.getEmail().equals(email)){
                        correctEmail = true;
                        doctorLogged = doctor;                                                   // Obtengo los datos del usuario loggeado "doctor" y asignarlo a mi variable de entorno "doctorLogged"
                        UIDoctorMenu.showDoctorMenu();                                           // Utilizo el método "showDoctorMenu()" que se encuentra en otra clase
                    }
                }
            }

            if (userType == 2){                                                                 // Verifico si es un Paciente
                for (Patient patient : patients){                                               // Forma de recorrer una lista de Objetos para encontrar el correo ingresado
                    if (patient.getEmail().equals(email)){
                        correctEmail = true;
                        patientLogged = patient;                                                // Obtengo los datos del usuario loggeado "patient" y asignarlo a mi variable de entorno "patientLogged"
                        UIPatientMenu.showPatientMenu();                                        // Utilizo el método "showPatientMenu()" que se encuentra en otra clase
                    }
                }
            }
        }while (!correctEmail);
    }

}

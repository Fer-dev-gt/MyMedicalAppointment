package ui;
import model.Doctor;
import model.Patient;

import java.util.ArrayList;
import java.util.Scanner;

public class UIMenu {
    public static final String[] MONTHS = {"Enero","Febrero","Marzo","Abril","Mayo","Junio","Julio","Agosto", "Septiembre", "Octubre", "Noviembre", "Diciembre"};
    public static Doctor doctorLogged;
    public static Patient patientLogged;

    public static void showMenu(){                                                                                      // Método base, muestra el menú inicial
        System.out.println("Welcome to My Appointments");
        System.out.println("Selecciona la opción deseada");

        int response = 0;
        do {
            System.out.println("1. Doctor");
            System.out.println("2. Patient");
            System.out.println("0. Salir");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("Doctor");
                    response = 0;
                    authUser(1);
                    break;
                case 2:
                    response = 0;
                    authUser(2);
                    break;
                case 0:
                    System.out.println("Thank you for you visit");
                    break;
                default:
                    System.out.println("Please select a correct answer");
            }
        }while (response != 0);
    }

    //
    public static void authUser(int userType){                                                   // Método para autenticar el tipo de usuario, ya que es una clase estática necesito que todos los métodos sean estáticos. El parámetro nos dice que tipo será el usuario

        ArrayList<Doctor> doctors = new ArrayList<>();                                           // Lista de Doctores y le agrego la instanciación de algunos objetos tipo Doctor
        doctors.add(new Doctor("Alejandro Martínez", "alejandro@gmail.com"));       // Voy a hacer una simulación en donde ya tengo algunos doctores y pacientes registrados en unas listas "ArrayList"
        doctors.add(new Doctor("Karen Sosa", "karen@gmail.com"));
        doctors.add(new Doctor("Rocío Gómez","rocio@gmail.com"));

        ArrayList<Patient> patients = new ArrayList<>();                                         // Lista de Patients y le agrego la instanciación de algunos objetos tipo Patient
        patients.add(new Patient("Anahí Salgado", "anahi@gmail.com"));
        patients.add(new Patient("Roberto Rodríguez", "roberto@gmail.com"));
        patients.add(new Patient("Carlos Sánchez", "carlos@gmail.com"));

        boolean correctEmail = false;                                                           // Verifico que el correo ingresado coincida con alguno de los correos ya registrados en mi lista
        do {
            System.out.println("Insert your email: [a@a.com]");
            Scanner sc = new Scanner(System.in);
            String email = sc.nextLine();

            if (userType == 1){                                                                 // Verifico que tipo de usuario es y recorro mi "ArrayList" para encontrar el correo ingresado
                for (Doctor doctor: doctors){                                                   // Forma de recorrer una lista de Objetos
                    if (doctor.getEmail().equals(email)){
                        correctEmail = true;
                        doctorLogged = doctor;                                                  // Obtengo los datos del usuario loggeado (Inicializarlo al pasarle los datos al instanciarlo)
                        UIDoctorMenu.showDoctorMenu();
                    }
                }
            }

            if (userType == 2){
                for (Patient patient: patients){
                    if (patient.getEmail().equals(email)){
                        correctEmail = true;
                        patientLogged = patient;                                                // Obtengo los datos del usuario loggeado (Inicializarlo al pasarle los datos al instanciarlo)
                        UIPatientMenu.showPatientMenu();
                    }
                }
            }
        }while (!correctEmail);
    }


    static void showPatientMenu(){                                                              // Método que muestra el menú al paciente y los meses donde puede agendar una cita
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("model.Patient");
            System.out.println("1. Book an appointment");
            System.out.println("2. My appointments");
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    System.out.println("::Book an appointment");
                    for (int i = 1; i < 4; i++) {
                        System.out.println(i + ". " + MONTHS[i-1]);
                    }
                    break;
                case 2:
                    System.out.println("::My appointments");
                    break;
                case 0:
                    showMenu();
                    break;
            }
        }while (response != 0);
    }

}

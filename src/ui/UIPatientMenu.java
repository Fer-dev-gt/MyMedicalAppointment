package ui;

import model.Doctor;
import java.util.ArrayList;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class UIPatientMenu {
    public static void showPatientMenu(){                                                                               // Método para mostrar el menu inicial para pacientes
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Patient");
            System.out.println("Welcome: " + UIMenu.patientLogged.getName());                                           // Llamó a una variable estática "patientLogged" (variable de entorno) y le muestro el nombre del paciente loggeado
            System.out.println("1. Book an appointment");
            System.out.println("2. My Appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);                                                                        // Capturo el input del usuario
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showBookAppointmentMenu();                                                                          // Invoco el método para mostrar las citas que los doctores ingresaron como disponibles
                    break;
                case 2:
                    showPatientMyAppointments();                                                                        // Invoco el método para mostrar las citas que el paciente ha agendado con sus doctores
                    break;
                case 0:
                    UIMenu.showMenu();                                                                                  // Regreso al menú inicial
                    break;
            }
        }while (response != 0);
    }

    private static void showBookAppointmentMenu(){                                                                      // Método para mostrar las citas que los doctores ingresaron como disponibles
        int response = 0;
        do {
            System.out.println("::Book an appointment");
            System.out.println("::Select Date:");

            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();                                               // Voy a utilizar un "Collection/Map" que usa Clave-Valor (Colección de Objetos), Primer indíce: Numeración de la lista de fechas, utilizo un Map adentro de un Map. Segundo Indíce de la fecha seleccionada
            int k = 0;                                                                                                  // Variable auxiliar para darle formato al texto
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {                                // Ciclo for para recorrer las citas disponibles y mostrarlas
                ArrayList<Doctor.AvailableAppointment> availableAppointments =                                          // Creo un ArrayList para capturar únicamente las citas guardadas en ArrayList tipo Doctor "doctorsAvailableAppointments"
                        UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();

                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();                                              // Creo mi segunda Collection para los "doctorAppointments" usando una estructura de árbol (TreeMap)

                for (int j = 0; j < availableAppointments.size(); j++) {                                                // Ciclo for anidado para mostrar las fechas disponibles
                    k++;
                    System.out.println(k + ". " + availableAppointments.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));       // Uso método "put()" para insertar en un Map, 2 parámetros, "j" va a ser el número del index (Usando una Clase Wrapper) y la lista de "doctorsAvailableAppointments"
                    doctors.put(Integer.valueOf(k), doctorAppointments);                                                // Usamos el indíce "k" al ser el externo y el Map que acabamos de construir "doctorAppointments"
                }
            }

            Scanner sc = new Scanner(System.in);                                                                        // Capturo la fecha que quiere reservar el paciente
            int responseDateSelected = Integer.valueOf(sc.nextLine());                                                  // Lo guardo usando un "Wrapper" para volverlo de un int a un Objeto tipo Integer

            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);                           // Uso otro Map para obtener los datos del Doctor, del otro lado utilizo mi otro Map externo, no el interno
            Integer indexDate = 0;                                                                                      // Indíce de la fecha
            Doctor doctorSelected = new Doctor("", "");                                                    // Inicializo un objeto tipo Doctor para guardar el doctor seleccionado, lo lleno con datos vacío

            for (Map.Entry<Integer, Doctor> doctorEnLista : doctorAvailableSelected.entrySet()) {                       // Usando un ciclo "for-each" vamos a recorrer nuestro Map, "entry.set" los usamos para recorrer un Map
                indexDate = doctorEnLista.getKey();                                                                     // Obtengo el indíce/valor
                doctorSelected = doctorEnLista.getValue();                                                              // Obtengo el valor, los datos confirmados
            }

            System.out.println(doctorSelected.getName() +                                                               // Muestro el nombre, fecha y hora del doctor que escogió el paciente
                            ". Date: " + doctorSelected.getAvailableAppointments().get(indexDate).getDate() +
                            ". Time: " + doctorSelected.getAvailableAppointments().get(indexDate).getTime());
            System.out.println("Confirm your appointment \n1. Yes \n2. Change Data");
            response = Integer.valueOf(sc.nextLine());                                                                  // Le pregunto si quiere confirmar la cita

            if (response == 1){                                                                                         // Si dice que si entonces le agrego la cita usando el método "addAppointmentDoctors" y mandando 3 parámetros
                UIMenu.patientLogged.addAppointmentDoctors(doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime());
                showPatientMenu();                                                                                      // Le muestro el menú de paciente
            }
        }while(response != 0);
    }

    private static void showPatientMyAppointments(){                                                                    // Método para mostrar la citas agendadas por el paciente, muestra fecha, hora y nombre del doctor encargado
        int response = 0;
        do {
            System.out.println(":: My Appointments");
            if (UIMenu.patientLogged.getAppointmentDoctors().size() == 0){                                              // Le muestro un mensaje personalizado si no tiene citas agendadas
                System.out.println("Don't have appointments");
                break;                                                                                                  // Salgo del ciclo "do-while"
            }

            for (int i = 0; i < UIMenu.patientLogged.getAppointmentDoctors().size(); i++) {                             // Hago un ciclo for para mostrar las citas agendadas
                int j = i + 1;
                System.out.println(j + ". " +
                        "Date: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate() +                      // Imprimo en consola la fecha, hora y nombre del doctor encargado
                        ", Time: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getTime() +
                        "\nDoctor: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor().getName()
                        );
            }
        }while(response != 0);
    }

}

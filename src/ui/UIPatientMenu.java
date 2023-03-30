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

            Map<Integer, Map<Integer, Doctor>> doctors = new TreeMap<>();                                               // Voy a utilizar un "Collection/Map" que usa Clave-Valor (Colección de Objetos), Numeración de la lista de fechas, utilizo un Map adentro de un Map. Indíce de la fecha seleccionada
            int k = 0;                                                                                                  // Variable auxiliar para darle formato al texto
            for (int i = 0; i < UIDoctorMenu.doctorsAvailableAppointments.size(); i++) {                                // Ciclo for para recorrer las citas disponibles y mostrarlas
                ArrayList<Doctor.AvailableAppointment> availableAppointments =                                          // Creo un ArrayList para capturar únicamente las citas
                        UIDoctorMenu.doctorsAvailableAppointments.get(i).getAvailableAppointments();

                Map<Integer, Doctor> doctorAppointments = new TreeMap<>();                                              // Creo otra Collection para los "doctorAppointments"

                for (int j = 0; j < availableAppointments.size(); j++) {
                    k++;
                    System.out.println(k + ". " + availableAppointments.get(j).getDate());
                    doctorAppointments.put(Integer.valueOf(j), UIDoctorMenu.doctorsAvailableAppointments.get(i));
                    doctors.put(Integer.valueOf(k), doctorAppointments);
                }
            }

            Scanner sc = new Scanner(System.in);
            int responseDateSelected = Integer.valueOf(sc.nextLine());
            Map<Integer, Doctor> doctorAvailableSelected = doctors.get(responseDateSelected);
            Integer indexDate = 0;
            Doctor doctorSelected = new Doctor("", "");

            for (Map.Entry<Integer, Doctor> doc: doctorAvailableSelected.entrySet()) {
                indexDate = doc.getKey();
                doctorSelected = doc.getValue();
            }

            System.out.println(doctorSelected.getName() +
                            ". Date: " + doctorSelected.getAvailableAppointments().get(indexDate).getDate() +
                            ". Time: " + doctorSelected.getAvailableAppointments().get(indexDate).getTime());
            System.out.println("Confrim your appointment \n1. Yes \n2. Change Data");
            response = Integer.valueOf(sc.nextLine());

            if (response == 1){
                UIMenu.patientLogged.addAppointmentDoctors(doctorSelected,
                        doctorSelected.getAvailableAppointments().get(indexDate).getDate(null),
                        doctorSelected.getAvailableAppointments().get(indexDate).getTime());
                showPatientMenu();
            }
        }while(response != 0);
    }

    private static void showPatientMyAppointments(){
        int response = 0;
        do {
            System.out.println(":: My Appointments");
            if (UIMenu.patientLogged.getAppointmentDoctors().size() == 0){
                System.out.println("Don't have appointments");
                break;
            }

            for (int i = 0; i < UIMenu.patientLogged.getAppointmentDoctors().size(); i++) {
                int j = i + 1;
                System.out.println(j + ". " +
                        "Date: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate() +
                        " Time: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDate() +
                        "\nDoctor: " + UIMenu.patientLogged.getAppointmentDoctors().get(i).getDoctor().getName()
                        );
            }
        }while(response != 0);
    }

}

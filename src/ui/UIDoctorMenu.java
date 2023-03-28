package ui;

import java.util.ArrayList;
import java.util.Scanner;
import model.Doctor;

public class UIDoctorMenu {
    // Lista de "Objetos Doctores"de doctores que tienen disponibles su agenda
    public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<Doctor>();
    public static void showDoctorMenu(){        // Método para mostrar menu de doctores
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Welcome " + UIMenu.doctorLogged.getName()); // Llamó a una variable estática "doctorLogged" (variable de entorno)
            System.out.println("1. Add Available Appointment");
            System.out.println("2. My Scheduled Appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            switch (response){
                case 1:
                    showAvailableAppointmentsMenu();
                    break;
                case 2:
                    break;
                case 0:
                    UIMenu.showMenu();
                    break;
            }
        }while (response != 0);
    }


    // Método para mostrar las citas disponibles
    private static void showAvailableAppointmentsMenu(){
        int response = 0;
        do {
            System.out.println();
            System.out.println("::Add Available Appointment");
            System.out.println(":: Select a Month");
            // Utilizo un ciclo for para mostrar mi lista de variables finales que tienen los meses del año
            for (int i = 0; i < 3; i++){
                int j = i + 1;
                System.out.println(j + ". " + UIMenu.MONTHS[i]);
            }
            System.out.println("0. Return");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if (response > 0 && response < 4){
                //1,2,3 mes seleccionados
                int monthSelected = response;
                System.out.println(monthSelected + ". " + UIMenu.MONTHS[monthSelected - 1]);
                System.out.println("Insert the date available: [dd/mm/yyyy]");
                String date = sc.nextLine();
                System.out.println("Your date is: " + date + "\n1. Correct \n2. Change Date");
                int responseDate = Integer.valueOf(sc.nextLine());

                if (responseDate == 2){
                    continue;
                }

                int responseTime = 0;
                String time = "";
                do {
                    System.out.println("Insert the time available for date: " + date + " [16:00]");
                    time = sc.nextLine();
                    System.out.println("Your time is: " + time + "\n 1. Correct \n2. Change Time");
                    responseTime = Integer.valueOf(sc.nextLine());
                }while (responseTime == 2);
                // Acá agendamos una nueva cita
                UIMenu.doctorLogged.addAvailableAppointment(date, time);
                checkDoctorAvailableAppointments(UIMenu.doctorLogged);

            } else if (response == 0) {
                showDoctorMenu();
            }


        }while (response != 0);
    }

    // Método privado (solo lo uso en esta clase) para ver que Doctores están disponibles
    private static void checkDoctorAvailableAppointments(Doctor doctor){
        // Valido que el doctor tenga citas y si no existe previamente en el Arraylist que declare arriba
        if (doctor.getAvailableAppointments().size() > 0 && !doctorsAvailableAppointments.contains(doctor)){
            doctorsAvailableAppointments.add(doctor);
        }
    }

}



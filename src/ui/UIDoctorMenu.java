package ui;

import java.util.ArrayList;
import java.util.Scanner;
import model.Doctor;

public class UIDoctorMenu {

    public static ArrayList<Doctor> doctorsAvailableAppointments = new ArrayList<Doctor>();                             // Lista de "Objetos Doctores" de doctores que tienen disponibles su agenda
    public static void showDoctorMenu(){                                                                                // Método para mostrar menu de doctores
        int response = 0;
        do {
            System.out.println("\n\n");
            System.out.println("Doctor");
            System.out.println("Welcome " + UIMenu.doctorLogged.getName());                                             // Llamó a la variable estática "doctorLogged" (variable de entorno) e imprimo el nombre del objeto
            System.out.println("1. Add Available Appointment");
            System.out.println("2. My Scheduled Appointments");
            System.out.println("0. Logout");

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());                                                                  // Capturo el input del usuario

            switch (response){
                case 1:
                    showAvailableAppointmentsMenu();                                                                    // Muestro un menu para agendar el mes, fecha y hora de la cita
                    break;
                case 2:
                    break;
                case 0:
                    UIMenu.showMenu();                                                                                  // Regreso al menú principal
                    break;
            }
        }while (response != 0);
    }


    private static void showAvailableAppointmentsMenu(){                                                                // Método para mostrar las citas disponibles y agendar el mes, fecha y hora de la cita
        int response = 0;
        do {
            System.out.println();
            System.out.println("::Add Available Appointment");
            System.out.println(":: Select a Month");
            System.out.println("0. Return");

            for (int i = 0; i < 3; i++){                                                                                // Utilizo un ciclo for para mostrar mi lista de variables finales que tienen los meses del año
                int j = i + 1;                                                                                          // Usa una variable auxiliar par el formato del texto
                System.out.println(j + ". " + UIMenu.MONTHS[i]);                                                        // Imprimo los meses de mi lista "MONTHS" de la otra clase (hasta marzo)
            }

            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());

            if (response > 0 && response < 4){                                                                          // Verifico que la respuesta sea de los primeros 3 meses del año
                int monthSelected = response;
                System.out.println(monthSelected + ". " + UIMenu.MONTHS[monthSelected - 1]);                            // Le muestro el mes que selecciono el usuario
                System.out.println("Insert the date available: [dd/mm/yyyy]");
                String date = sc.nextLine();                                                                            // Le pido que ingrese la fecha exacta de la cita
                System.out.println("Your date is: " + date + "\n1. Correct \n2. Change Date");
                int responseDate = Integer.valueOf(sc.nextLine());                                                      // Le pregunto si la fecha es correcta

                if (responseDate == 2){                                                                                 // Si quiere cambiar la fecha uso "continue" para volver a iniciar el ciclo "do-while"
                    continue;
                }

                int responseTime = 0;
                String time = "";
                do {                                                                                                    // Creo un nuevo ciclo "do-while" anidado para pedir la hora de la cita
                    System.out.println("Insert the time available for date: " + date + " [16:00]");
                    time = sc.nextLine();
                    System.out.println("Your time is: " + time + "\n1. Correct \n2. Change Time");
                    responseTime = Integer.valueOf(sc.nextLine());                                                      // Le pregunto si quiere volver a ingresar la hora de la cita
                }while (responseTime == 2);

                UIMenu.doctorLogged.addAvailableAppointment(date, time);                                                // Agendamos una nueva cita, le mandamos como parámetros nuestras variables "date" y "time" (ambos son String) a la clase Doctor
                checkDoctorAvailableAppointments(UIMenu.doctorLogged);                                                  // Implemento el método de abajo y le mando como parámetro un objeto tipo Doctor "doctorLogged"

            } else if (response == 0) {                                                                                 // Si no es de los primeros 3 meses, le muestro de nuevo el menú
                showDoctorMenu();
            }


        }while (response != 0);
    }

    private static void checkDoctorAvailableAppointments(Doctor doctor){                                                // Método privado (solo lo uso en esta clase) para ver que Doctores están disponibles y agregar un nuevo doctor si no existe en la lista
        if (doctor.getAvailableAppointments().size() > 0 && !doctorsAvailableAppointments.contains(doctor)){            // Válido que el doctor tenga citas y si no existe previamente en el Arraylist que declare arriba
            doctorsAvailableAppointments.add(doctor);                                                                   // Agrego el objeto de doctor que recibí como parámetro y lo agrego a la lista
        }
    }

}



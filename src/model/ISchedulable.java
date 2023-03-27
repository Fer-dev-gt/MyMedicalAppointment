package model;
import java.util.Date;
public interface ISchedulable {
    // Esta interfaz va a contener un método, este método va a recibir como parámetros un objeto tipo Date y un Strint (time)
    void schedule(Date date, String time);

}

package model;

public class Patient extends User{
    private String  birthday, blood; // Les puse "private" para que estas variables no puedan ser editadas o cambiadas desde afuera de esta Clase
    private double weight, height;                  // Les puse "private" para que estas variables no puedan ser editadas o cambiadas desde afuera de esta Clase

    public Patient(String name, String correo){
        super(name, correo);            // "super" representa al objeto padre "model.User" y será creada cuando cree una clase Padre
        //this.name = name;
        //this.email = correo;
        //this.weight = 54.4;
        // System.out.println(weight + " Kg.");        // Este adorno que le puse al "weight (Kg.) no lo van a poder modificar desde afuera de esta clase"
    }

    // Declaracion de mis metodos "Setters y Getters" de mi clase Patients
    // método setter, le daré valor de 54.5
    public void setWeight(double weight){       // Se le pone "public" para que este metodo sea accesible desde cualquier clase
        this.weight = weight;
    }

    // método getter   (Aqui puede establecer las reglas o el formato con el cual voy a devolver mis datos) estas reglas no tienen que establecerse fuera de esta clase
    // regresara 54.5 Kg. y sera un dato String
    public String getWeight(){
        return this.weight + " Kg.";
    }

    public String getHeight() {
        return height + " Metros";
    }

    public void setHeight(double height) {
        this.height = height;
    }

    // Sobre escribo para agregar comportamientos extras para que me retorne información extra
    /*Al imprimir cualquier objeto en la consola con System.out.println(object), en realidad, estamos ejecutando el método .toString() de dicho objeto,
    por lo que si sobreescribimos este método en nuestras clases, el resultado en la consola también cambiará automáticamente.
     */
    @Override
    public String toString() {
        return super.toString() + "\nAge: " + birthday + "\nWeight: " + weight + "\nHeight: " + height + "\nBlood: " + blood;
    }

    @Override
    public void showDataUser() {
        System.out.println("Paciente");
        System.out.println("Historial completa desde nacimiento");
    }

    /*public String getPhoneNumber() {
        return phoneNumber;
    }

    //  Dentro de los métodos "Setters" puedo aplicar estructuras condicionales (if) para permitir un cambio de datos y su comportamiento
    public void setPhoneNumber(String phoneNumber) {
        if(phoneNumber.length() != 8){
            System.out.println("El número telefónico debe de ser de 8 dígitos");
        }else{
            this.phoneNumber = phoneNumber;
        }
    }

    // Al usar la combinacion "cmd + n" el IDE me dara sugerencias para declarar mis "Getters y Setters"


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getBirthday() {
        return birthday;
    }

    public void setBirthday(String birthday) {
        this.birthday = birthday;
    }

    public String getBlood() {
        return blood;
    }

    public void setBlood(String blood) {
        this.blood = blood;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }*/
}

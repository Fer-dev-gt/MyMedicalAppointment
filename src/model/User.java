package model;

public abstract class User {                    // Vamos a utilizar una "Clase Abstracta"
    private int id;
    private String name, email, address, phoneNumber;

        // Constructor
    public User(String name, String email) {
        this.name = name;
        this.email = email;
    }
        // Getters y Setters

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

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

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        //  Dentro de los métodos "Setters" puedo aplicar estructuras condicionales (if) para permitir un cambio de datos y su comportamiento
        if(phoneNumber.length() != 8){
            System.out.println("El número telefónico debe de ser de 8 dígitos");
        }else{
            this.phoneNumber = phoneNumber;
        }
    }

    // Estoy Sobreescribiendo un Método
    @Override                           // Con la etiqueta "@Override" yo sé que este método no es del a clase model.User
    public String toString() {
        return "model.User: " + name + ", Email: " + email +
                "\nAddress: " + address + ". Phone: "+ phoneNumber;
    }

    // Voy a crear un "Método Abstracto" que se refleje a las clases hijas
    public abstract void showDataUser(); // Al ser un "Método Abstracto" no es necesario definir su comportamiento usando llaves (Lo definiremos en las otras Clases)
}

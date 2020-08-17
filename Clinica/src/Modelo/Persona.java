
package Modelo;

public class Persona {
    private int id;
    private int edad;
    private String nombre;
    private String apellidos;
    private int telefono;
    private String correo;

    public Persona() {
    }

    public Persona(int id, int edad, String nombre, String apellidos, int telefono, String correo) {
        this.id = id;
        this.edad = edad;
        this.nombre = nombre;
        this.apellidos = apellidos;
        this.telefono = telefono;
        this.correo = correo;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellidos() {
        return apellidos;
    }

    public void setApellidos(String apellidos) {
        this.apellidos = apellidos;
    }

    public int getTelefono() {
        return telefono;
    }

    public void setTelefono(int telefono) {
        this.telefono = telefono;
    }

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    @Override
    public String toString() {
        return "Identificacion=" + id +"Nombre: " + nombre +" "+ apellidos +" "+ "Edad: " + edad + "\n  Telefono: " + telefono + "Correo:  " + correo+" \n";
    }
    
    
}

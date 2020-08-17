
package Modelo;


public class Medico extends Persona {
    private String Especializacion;

    public Medico() {
    }

    public Medico(int id, int edad, String nombre, String apellidos, int telefono, String correo,String Especializacion) {
        super(id, edad, nombre, apellidos, telefono, correo);
        this.Especializacion=Especializacion;
        
    }

    public String getEspecializacion() {
        return Especializacion;
    }

    public void setEspecializacion(String Especializacion) {
        this.Especializacion = Especializacion;
    }

    @Override
    public String toString() {
        return super.toString() + "Especializacion=" + Especializacion +"\n";
    }
   
    
}

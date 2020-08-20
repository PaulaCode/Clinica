
package Modelo;


public class Medico extends Persona {
    private String Especializacion;
    private int carnet;
    public Medico() {
    }

    public Medico(int id, int edad, String nombre, String apellidos, int telefono, String correo,String Especializacion,int carnet) {
        super(id, edad, nombre, apellidos, telefono, correo);
        this.Especializacion=Especializacion;
        this.carnet= carnet;
    }

    public String getEspecializacion() {
        return Especializacion;
    }

    public void setEspecializacion(String Especializacion) {
        this.Especializacion = Especializacion;
    }

    public int getCarnet() {
        return carnet;
    }
    
    public void setCarnet(int carnet) {
        this.carnet = carnet;
    }

    @Override
    public String toString() {
        return super.toString() +"Carnet  "+ this.carnet+ " Especializacion  " + Especializacion +"\n";
    }
    public String mensajeMedicos()
    {
        return "Carnet "+ this.carnet +" Nombre "+super.getNombre()+"\n";
    }
    
}


package Modelo;

import java.util.ArrayList;


public class Paciente extends Persona {
    private Persona acompañante;
    private ArrayList <HistoriaClinica> historiaclinica = new  ArrayList<>();
    private int Tipobeneficio=0;
    private EPS eps;
    private Cuidados tipo_cuidado;
    
    public Verificaciones verificaciones = new Verificaciones();
    
    public Paciente() {
    }

    public Paciente(int id, int edad, String nombre, String apellidos, int telefono, String correo,Persona acompañante,ArrayList <HistoriaClinica> historiaclinica,int Tipobeneficio) {
        super(id, edad, nombre, apellidos, telefono, correo);
        this.acompañante=acompañante;
        this.historiaclinica=historiaclinica;
        this.Tipobeneficio=Tipobeneficio;
    }

    public int getTipobeneficio() {
        return Tipobeneficio;
    }

    public void setTipobeneficio(int Tipobeneficio) {
        this.Tipobeneficio = Tipobeneficio;
    }

    public Persona getAcompañante() {
        return acompañante;
    }

    public void setAcompañante(Persona acompañante) {
        this.acompañante = acompañante;
    }

    public ArrayList<HistoriaClinica> getHistoriaclinica() {
        return historiaclinica;
    }

    public void setHistoriaclinica(ArrayList<HistoriaClinica> historiaclinica) {
        this.historiaclinica = historiaclinica;
    }
    public void setHistoria(HistoriaClinica historiaclinica){
        
        this.historiaclinica.add(historiaclinica);
    }
    
     public void setEps(EPS eps) {
        this.eps = eps;
    }
    public EPS getEps() {
        return eps;
    }

    public Cuidados getTipo_cuidado() {
        return tipo_cuidado;
    }

    public void setTipo_cuidado(Cuidados tipo_cuidado) {
        this.tipo_cuidado = tipo_cuidado;
    }
    
    @Override
    public String toString(){
        Proceso obj_proceso= new Proceso();
        String mensaje="";
        mensaje+= super.toString();
        if(acompañante!= null){
            mensaje+="\nAcompañante: "+acompañante.getNombre()+" \n";
        }
        for(int i=0;i<historiaclinica.size();i++){
            mensaje+=historiaclinica.toString();
         
        }
        switch (Tipobeneficio) {
            case 1:
                mensaje+="\nBeneficio de cotizante al 70%";
                break;
            case 2:
                mensaje+="\nBeneficio de beneficiaro al 50%";
                break;
            case 0:
                mensaje += "\nNo aplica para el descuento por que no tiene eps ";
                break;
            default:
                break;
        }
        return mensaje;
    }


    
}

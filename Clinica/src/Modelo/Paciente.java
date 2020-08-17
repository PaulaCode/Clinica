
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author frealgagu
 */

public class Paciente extends Persona {
    private Persona acompañante;
    private ArrayList <HistoriaClinica> historiaclinica = new  ArrayList<>();
    private int Tipobeneficio;
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
    @Override
    public String toString(){
        
        String mensaje="";
        mensaje+= super.toString();
        if(acompañante!= null){
            mensaje+="Acompañante: "+acompañante.getNombre()+" \n";
        }
        for(int i=0;i<historiaclinica.size();i++){
            mensaje+=historiaclinica.toString();
         
        }
        if(Tipobeneficio == 1 ){
            mensaje+="Beneficio de cotizante al 70%";
            
        } if(Tipobeneficio == 2 ){
            mensaje+="Beneficio de beneficiaro al 50%";
            
        }
        else{
            
            mensaje += "No aplica para el descuento por que no tiene eps ";
            
        }
        return mensaje;
    }
    
}

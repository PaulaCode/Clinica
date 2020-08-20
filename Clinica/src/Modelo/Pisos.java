
package Modelo;

import java.util.ArrayList;


public class Pisos {
    private int numpiso;
    private Cuidados Intensivos;
    private Cuidados Intermedios;
    private Cuidados Recuperacion;

    public Pisos(){
        
    }
    
    public Pisos(int numpiso, Cuidados Intensivos, Cuidados Intermedios, Cuidados Recuperacion) {
        this.numpiso = numpiso;
        this.Intensivos = Intensivos;
        this.Intermedios = Intermedios;
        this.Recuperacion = Recuperacion;
    }

    public int getNumpiso() {
        return numpiso;
    }

    public void setNumpiso(int numpiso) {
        this.numpiso = numpiso;
    }

    public Cuidados getIntensivos() {
        return Intensivos;
    }

    public void setIntensivos(Cuidados Intensivos) {
        this.Intensivos = Intensivos;
    }

    public Cuidados getIntermedios() {
        return Intermedios;
    }

    public void setIntermedios(Cuidados Intermedios) {
        this.Intermedios = Intermedios;
    }

    public Cuidados getRecuperacion() {
        return Recuperacion;
    }

    public void setRecuperacion(Cuidados Recuperacion) {
        this.Recuperacion = Recuperacion;
    }

    @Override
    public String toString() {
        String mensaje="";
        mensaje+="\nNúmero de piso: " + numpiso;
        if(Intensivos!=null){
            mensaje+="\nIntensivos: \n" + Intensivos.toString(); 
                    
        }
        if(Intermedios!=null){
            mensaje+="\nIntermedios: \n" + Intermedios.toString();
        }
        if(Recuperacion!=null){
            mensaje+="\nRecuperacion: \n" + "Numero de habitaciones: " + Recuperacion.getCantidadDecamas();
        }
          return mensaje;
    }
    
}

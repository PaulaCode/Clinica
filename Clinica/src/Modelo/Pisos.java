
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author nobody
 */
public class Pisos {
    private int numpiso;
    private Cuidados Intensivos;
    private Cuidados Intermedios;
    private Cuidados Recuperacion;

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
        mensaje+="Numero de piso: " + numpiso;
        if(Intensivos!=null){
            mensaje+="Intensivos: \n" + Intensivos.toString(); 
                    
        }
        if(Intermedios!=null){
            mensaje+="Intermedios: \n" + Intermedios.toString();
        }
        if(Recuperacion!=null){
            mensaje+="Recuperacion: \n" + "Numero de habitaciones: " + Recuperacion.getCantidadDecamas();
        }
          return mensaje;
    }
    
}

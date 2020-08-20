
package Modelo;

/**
 *
 * @author nobody
 */
public class HistoriaClinica {
   
    private String FechaHospitalizacion;
    private Medico Medicoencargado;
    private String Descripcion;

    public HistoriaClinica()
    {
        
    }
    
    public HistoriaClinica(String FechaHospitalizacion, Medico Medicoencargado, String Descripcion) {
        this.FechaHospitalizacion = FechaHospitalizacion;
        this.Medicoencargado = Medicoencargado;
        this.Descripcion = Descripcion;
    }

    public String getFechaHospitalizacion() {
        return FechaHospitalizacion;
    }

    public void setFechaHospitalizacion(String FechaHospitalizacion) {
        this.FechaHospitalizacion = FechaHospitalizacion;
    }

    public Medico getMedicoencargado() {
        return Medicoencargado;
    }

    public void setMedicoencargado(Medico Medicoencargado) {
        this.Medicoencargado = Medicoencargado;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String Descripcion) {
        this.Descripcion = Descripcion;
    }

    @Override
    public String toString() {
        return "Fecha: " + FechaHospitalizacion + "   Médico:  " + Medicoencargado.getNombre() + "\n Descripción:  \n " + Descripcion +"\n";
    }
    
    
    
}

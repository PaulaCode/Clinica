
package Modelo;

import static Modelo.Proceso.hospitalproceso;
import Vista.InOut;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;


public class Verificaciones {
    
    InOut ioData = new InOut();
    
    public boolean validarFecha(String fecha)
    {
        try
        {
             SimpleDateFormat objSDF = new SimpleDateFormat("dd-mm-yyyy"); 
             objSDF.parse(fecha); 
             return true;
        }
        catch(Exception ex)
        {
            return false;
        }
    }
   public boolean validarParentesco(String apellidopaciente,String apellidoencargado)	
    {	
        //sierra alba  lopez sierra	
            if(apellidopaciente.equalsIgnoreCase(apellidoencargado))	
            {	
                return true;	
            }	

            StringTokenizer toke = new StringTokenizer(apellidopaciente);	
            StringTokenizer toke2 = new StringTokenizer(apellidoencargado);	
            String tokeanterior = toke2.nextToken();//lopez	
            String tokeanterior2 = toke.nextToken();//sierra	
            String apellidop1 = "",apellidop2 = "";	

            while(toke.hasMoreTokens())	
            {	
                 apellidop1 = toke.nextToken();//sierra   alba	
                 apellidop2 = toke2.nextToken();//lopez   sierra    	
                if(apellidop1.equalsIgnoreCase(apellidop2)||tokeanterior.equalsIgnoreCase(apellidop1)||tokeanterior2.equalsIgnoreCase(apellidop2)||tokeanterior2.equalsIgnoreCase(tokeanterior))	
                {	
                  return true;  	
                }	
            }	
            return false;	
    }
    public boolean validarIdentificacion(int identificacion)
    {
        for(Persona objpersona : Proceso.lista_personas)
        {
            if(identificacion==objpersona.getId())
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean validarCorreo(String correo){
        
          for(Persona objpersona : hospitalproceso.getRegistro_paciente())
        {
            if(correo.equalsIgnoreCase(objpersona.getCorreo()))
            {
                return true;
            }
        }
        return false;
    }
    
    public boolean validarNombre(String nombre)
    {
        StringTokenizer toke = new StringTokenizer(nombre);
        return toke.countTokens()>2||toke.countTokens()<=0;
    }
    public boolean validarApellido(String apellido)
    {
       StringTokenizer toke = new StringTokenizer(apellido);
       return toke.countTokens()<2||toke.countTokens()>=3||toke.countTokens()<=0;
    }
    public boolean validarNull(String dato)
    {
       StringTokenizer toke = new StringTokenizer(dato);
       return toke.countTokens()<=0;
    }
    int verificarCodigo(int codigo,ArrayList<EPS> eps){
        
        for(int i=0; i<eps.size() ; i++){
            
            if(eps.get(i).getCodigo() == codigo)
                return i;
                
        }
        return -1;
    }
    public int returnNumeroPiso(Cuidados objCuidado)
    {
      for(Pisos objpiso: hospitalproceso.getPisos())
        {
            if(objpiso.getIntensivos()==objCuidado||objpiso.getIntermedios()==objCuidado||objpiso.getRecuperacion()==objCuidado)
            {
               return objpiso.getNumpiso();
            }
        }
        return -1;  
    }
    public int returnTipoCuidado(Cuidados objCuidado)
    {
        for(Pisos objpiso: hospitalproceso.getPisos())
        {
            if(objpiso.getIntensivos()==objCuidado)
            {
               return 1;
            }
            else if(objpiso.getIntermedios()==objCuidado)
            {
                return 2;
            }
            else if(objpiso.getRecuperacion()==objCuidado){
               return 3;
            }
        }
        return -1;    
    }
    public Medico returnMedico(int carnet)
    {
        for(Medico objmedico: hospitalproceso.getMedicos())
        {
            if(objmedico.getCarnet()==carnet)
            {
                return objmedico;
            }
        }
        return null;
    }
    
    public int returnCarnet(int carnet){
        
        for(int i =0;i<hospitalproceso.getMedicos().size();i++)
        {
            if(hospitalproceso.getMedicos().get(i).getCarnet()==carnet)
            {
                return i;
            }
        }
        return -1;   
        
    }
    public EPS returnEps(int codigo)
    {
        for(EPS objeps: hospitalproceso.getEps())
        {
            if(objeps.getCodigo()==codigo)
                return objeps;
        }
        return null;
    }
    public int returnPosicion(int EPS, ArrayList<EPS> eps) {
        while (true) {
            if (EPS > 0 && EPS<= eps.size()) {                                            //Si digita un número entre 0 y la cantidad de categorias, entra
                return EPS - 1;
            } else {
                EPS = ioData.solicitarEntero("\nDebe digitar un número dentro del rango [1, " + eps.size() + "] \nDigite el número de la EPS que desea eliminar: ");
            }
        }
    }
    public boolean validarNumeroPiso(int numeroPiso)
    {
        for(Pisos objpiso: hospitalproceso.getPisos())
        {
            if(objpiso.getNumpiso()==numeroPiso)
            {
                return true;
            }
        }
        return false;
    }
    public Pisos returnPiso(int numeropiso)
    {
       for(Pisos objpiso: hospitalproceso.getPisos())
        {
            if(objpiso.getNumpiso()==numeropiso)
            {
                return objpiso;
            }
        }
        return null;
    }
    public Paciente returnPaciente(int id)
    {
       for(Paciente objpaciente:hospitalproceso.getPacientes())
        {
            if(objpaciente.getId()==id)
            {
                return objpaciente;
            }
        }
        return null; 
    }
    public int returnPosPaciente(int id)
    {
       for(int i =0;i<hospitalproceso.getPacientes().size();i++)
        {
            if(hospitalproceso.getPacientes().get(i).getId()==id)
            {
                return i;
            }
        }
        return -1;     
    }
    public boolean validarPaciente(int id)
    {
        for(Paciente objpaciente:hospitalproceso.getPacientes())
        {
            if(objpaciente.getId()==id)
            {
                return true;
            }
        }
        return false;
    }
    
    public int verificarCarnetDoctor(int carnet){
        
         for(int i=0; i< hospitalproceso.getMedicos().size(); i++)
        {
            if(hospitalproceso.getMedicos().get(i).getCarnet()==carnet)
            {
                return i;
            }
        }
        return -1;
        
    }
}

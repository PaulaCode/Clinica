
package Modelo;



import Control.Main;
import Vista.InOut;
import java.util.ArrayList;


public class Proceso {
    
     InOut ioData = new InOut();
    private Hospital hospitalproceso = new Hospital();

    public void menumedico (){
        int opc;
        int claveCom;
        do{
            opc=ioData.solicitarEntero("1.Cambiar clave "+

                                   "2.Atender paciente ");

        switch(opc){
            case 1:
               claveCom=ioData.solicitarEntero("Ingrese la clave del personal de medicina nuevamente: ");
               while(Main.getClaveMedico() != claveCom){
                   claveCom=ioData.solicitarEntero("Ingrese la clave del personal de medicina correctamente: ");
               }
               claveCom = ioData.solicitarEntero("Ingrese la nueva clave del personal de medicina: ");
               Main.setClaveMedico(claveCom);
               ioData.mostrarResultado("Clave cambiada con exito");
                break;
                
            case 2:

                if (hospitalproceso.getPacientes()== null){
              
                    ioData.mostrarResultado("No hay pacientes en lista de espera.");
                }else{
                    
                    
                }
               
                
                break;
                
                
                default: ioData.mostrarResultado("OPCION NO VALIDA, DIGITE NUEVAMENTE UNA OPCION");
            } 
          
        }while(opc!=2);
    
    }
    
    public void menuAdministrador(){
         int opc;
        ArrayList<EPS> eps = hospitalproceso.getEps();
        ArrayList<Medico> medico = hospitalproceso.getMedicos();
         do{
            opc=ioData.solicitarEntero("Hospital "+Main.getNombre()+
                                       "\n1.Registrar EPS "+
                                       "\n2.Eliminar EPS "+
                                       "\n3.Registrar médicos "+
                                       "\n4.Cambiar clave"+
                                       "\n5.Salir " +
                                       "\n\nDigite la opción que desee");
        switch(opc){
            case 1:
                String nombre = ioData.solicitarNombre("Digite el nombre de la EPS");
                int codigo = ioData.solicitarEntero("Digite el código de la EPS");
               while(verificarCodigo(codigo, eps) == -1){
                   codigo = ioData.solicitarEntero("El código está repetido. \nIngrese el código de la EPS: ");
               }
               eps.add(new EPS(nombre,codigo));
               
                break;
                
            case 2:
                String acumulador;
                acumulador = mostrarEPS();
                acumulador+= ("\n\nDigite el número de la EPS que desea eliminar.");
                int numero = ioData.solicitarEntero(acumulador);
                numero = returnPosicion(numero, eps);
                eps.remove(numero);
                
                break;
            
            case 3:
                
                nombre = ioData.solicitarNombre("Digite los nombres del médico");
                String apellidos = ioData.solicitarNombre("Digite los apellidos del médico");
                int id = ioData.solicitarEntero("Digite la identificación del médico.");
                int edad = ioData.solicitarEntero("Digite la edad del médico.");
                int telefono = ioData.solicitarEntero("Digite el teléfono del médico.");
                String correo = ioData.solicitarNombre("Digite el correo del médico.");
                String especializacion = ioData.solicitarNombre("Escriba en qué se especializa el médico.");
               
               medico.add(new Medico(id,edad, nombre, apellidos, telefono, correo, especializacion));
                
                break;
                
            case 4:
                
               int claveCom=ioData.solicitarEntero("Ingrese la clave del administrador: ");
               while(Main.getClaveAdmin() != claveCom){
                   claveCom=ioData.solicitarEntero("Ingrese la clave del administrador correctamente: ");
               }
               claveCom = ioData.solicitarEntero("Ingrese la nueva clave del administrador: ");
               Main.setClaveAdmin(claveCom);
               ioData.mostrarResultado("Clave cambiada con exito");
                break;
                
             case 5: break;    
                
            default: ioData.mostrarResultado("OPCION NO VALIDA, DIGITE NUEVAMENTE UNA OPCION");
            } 
 
        }while(opc!=5);
        
        
        
    }
    
    private String mostrarEPS(){
        
        ArrayList<EPS> eps = hospitalproceso.getEps();
        String acumulador = " ";
     
        for(int i=0 ; i<eps.size(); i++){
            
            acumulador+= ("EPS número "+(i+1)+ "\n"+ eps.get(i).toString()+ ". \n");
            
        }
        return acumulador;
    }
    
    private int verificarCodigo(int codigo,ArrayList<EPS> eps){
        
        for(int i=0; i<eps.size() ; i++){
            
            if(eps.get(i).getCodigo() == codigo)
                return i;
                
        }
        return -1;
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
}
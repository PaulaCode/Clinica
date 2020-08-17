
package Modelo;



import Vista.InOut;


public class Proceso {
    
    private int clavemedico;
    InOut ioData = new InOut();
    private Hospital hospitalproceso = new Hospital();
    
    private void menumedico (){
        int opc;
        int clave;
        do{
            opc=ioData.solicitarEntero("1.Cambiar clave "+
                                   "2.Atender paciente "   );
        switch(opc){
            case 1:
               clave=ioData.solicitarEntero("Ingrese la clave del personal de medicina: ");
               while(clave != clavemedico){
                   clave=ioData.solicitarEntero("Ingrese la clave del personal de medicina correctamente: ");
               }
               clave=ioData.solicitarEntero("Ingrese la nueva clave del personal de medicina: ");
               this.clavemedico=clave;
               ioData.mostrarResultado("Clave cambiada con exito");
                break;
                
            case 2:
                
                
                
                
                break;
                
                
                default: ioData.mostrarResultado("OPCION NO VALIDA, DIGITE NUEVAMENTE UNA OPCION");
            } 
          
        }while(opc!=2);
    
}
}
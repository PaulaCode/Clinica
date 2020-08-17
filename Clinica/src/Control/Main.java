
package Control;

import Modelo.Proceso;
import Vista.InOut;


public class Main {

     static InOut inOut = new InOut();
     private static int claveAdmin,claveRec,claveMedico;
     private static String nombre = " ";
     static  Proceso proceso = new Proceso();
    public static void main(String[] args) {
        
        
        boolean bandAdmin = false, bandRec= false, bandMedico = false;
       
        
        int opc,claveCom;
        
         do{
            opc=inOut.solicitarEntero("Bienvenido al menú principal. \n "+
                                        "\n1.Menú Administrador "+
                                        "\n2.Menú Recepción "+
                                        "\n3.Menú Médico "+
                                        "\n4.Salir "+ 
                                        "\n\n.Digite la opción que desee ");
        switch(opc){
            case 1:
               if(bandAdmin == false){
                   claveCom=inOut.solicitarEntero("Ingrese la clave del administrador: ");
                   claveAdmin = claveCom;
                   String nombreH = inOut.solicitarNombre("Digite el nombre del hospital: ");
                   nombre = nombreH;
                   bandAdmin = true;
               } else {
                    claveCom=inOut.solicitarEntero("Ingrese la clave del administrador: ");
                    while(claveAdmin != claveCom){
                   claveCom=inOut.solicitarEntero("Ingrese la clave del administrador correctamente: ");
                    }
                    proceso.menuAdministrador();
               }
               
               break;
            case 2: 
                
                if(bandRec == false){
                   claveCom=inOut.solicitarEntero("Ingrese la clave de la recepción: ");
                   claveRec = claveCom;
                   bandRec = true;
               } else {
                    claveCom=inOut.solicitarEntero("Ingrese la clave de la recepción ");
                    while(claveRec != claveCom){
                   claveCom=inOut.solicitarEntero("Ingrese la clave de la recepción correctamente: ");
                    menuRepcionista();
                    }
                    
                    
               }
               
               break;
                
            case 3:
                
                if(bandMedico == false){
                   claveCom=inOut.solicitarEntero("Ingrese la clave del personal de medicina: ");
                   claveMedico = claveCom;
                   bandMedico = true;
               } else {
                    claveCom=inOut.solicitarEntero("Ingrese la clave del personal de medicina: ");
                    while(claveMedico != claveCom){
                   claveCom=inOut.solicitarEntero("Ingrese la clave del personal de medicina correctamente: ");
                    }
                    proceso.menumedico();
               }
               
               break;
                
                default: inOut.mostrarResultado("OPCION NO VALIDA, DIGITE NUEVAMENTE UNA OPCION");
            } 
          
        }while(opc!=4);
        
    }

    public static int getClaveAdmin() {
        return claveAdmin;
    }

    public static void setClaveAdmin(int claveAdmin) {
        Main.claveAdmin = claveAdmin;
    }

    public static int getClaveMedico() {
        return claveMedico;
    }

    public static void setClaveMedico(int claveMedico) {
        Main.claveMedico = claveMedico;
    }

    public static String getNombre() {
        return nombre;
    }
    
    public static void menuRepcionista()
    {
            String mensaje="Menú recepción\n";
            mensaje+="\n1. Ingreso Paciente\n"
                    +"2. Otorgar salida\n"+
                    "3. Mostrar Pacientes\n"
                    +"4. Consultar Paciente\n"
                    +"5. Salir ";
            int opcion=0;  
            do
            {
             opcion = inOut.solicitarEntero(mensaje+"\n\nDigite una opción");
                switch(opcion)
               {
                 case 1:{
                     proceso.ingresarPaciente();
                     break;
                 }
                 case 2:{
                     break;
                 }
                 case 3:{
                     proceso.mostrarPacientes();
                     break;
                 }
                 case 4:{
                     proceso.buscarPaciente();
                     break;
                 }
                 case 5:{
                     break;
                 }
                 default:{
                     inOut.mostrarResultado("Opción incorrecta");
                     break;
                 }
            }
         }
         while(opcion!=5);
       }
        


 }


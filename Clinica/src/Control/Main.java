
package Control;

import Vista.InOut;

public class Main {
    static InOut inOut = new InOut();
    String claveRecepcionista;
    public static void main(String[] args) {
        
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
              break;
          }
          case 2:{
              break;
          }
          case 3:{
              break;
          }
          case 4:{
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

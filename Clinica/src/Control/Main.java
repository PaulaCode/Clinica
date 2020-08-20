
package Control;

import Modelo.*;
import Vista.InOut;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


public class Main {

     static InOut inOut = new InOut();
     private static int claveAdmin,claveRec,claveMedico;
     private static String nombre = " ";
     static  Proceso proceso = new Proceso();
     static boolean bandAdmin = false, bandRec= false, bandMedico = false;
       
       
    public static void main(String[] args) {

        manejoarchivos.leerArchivo(Proceso.hospitalproceso);
     
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
                   Proceso.hospitalproceso.setNombre(nombre);
                   bandAdmin = true;
                   
               } else {
                    claveCom=inOut.solicitarEntero("Ingrese la clave del administrador: ");
                    while(claveAdmin != claveCom){
                   claveCom=inOut.solicitarEntero("Ingrese la clave del administrador correctamente: ");
                    }
                     
               }
              proceso.menuAdministrador();
               break;
            case 2: 
                if(!Proceso.hospitalproceso.getPisos().isEmpty()&&!Proceso.hospitalproceso.getMedicos().isEmpty()){
                if(bandRec == false){
                   claveRec=inOut.solicitarEntero("Ingrese la clave de la recepción: ");     
                   bandRec = true;
               } 
               else {

                    claveCom=inOut.solicitarEntero("Ingrese la clave de la recepción ");
                    while(claveRec != claveCom){
                   claveCom=inOut.solicitarEntero("Ingrese la clave de la recepción correctamente: ");              
                    }             
               }
                 proceso.menuRepcionista(); }
                else{
                    inOut.mostrarResultado("No hay médicos y/o pisos para poder ser atendido.");
                }
               break;
                
            case 3:
                
                if(bandMedico == false){
                   claveCom=inOut.solicitarEntero("Ingrese la clave del personal de medicina: ");
                   claveMedico = claveCom;
                   bandMedico = true;
                   proceso.menumedico();
                   
               } else {
                    claveCom=inOut.solicitarEntero("Ingrese la clave del personal de medicina: ");
                    while(claveMedico != claveCom){
                   claveCom=inOut.solicitarEntero("Ingrese la clave del personal de medicina correctamente: ");
                    }
                   
               }
                proceso.menumedico();
               break;
            case 4:
               
               manejoarchivos.crearArchivo(Proceso.hospitalproceso);
               manejoarchivos.crearHistoria(Proceso.hospitalproceso);
               
            System.exit(0);
                break;
     
                default: inOut.mostrarResultado("OPCION NO VALIDA, DIGITE NUEVAMENTE UNA OPCION");
            } 
          
        }while(opc!=6);
        
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


  
}
 


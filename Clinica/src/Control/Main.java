
package Control;

import Modelo.*;
import Vista.InOut;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
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
        
       // Proceso.hospitalproceso.setNombreEps(new EPS("coompensar",123));
       //   proceso.ingresarPaciente();
       Cuidados obj_cuidado1 = new Cuidados(20,12);
       Cuidados obj_cuidado2 = new Cuidados(10,5);      
       Cuidados obj_cuidado3 = new Cuidados(7,4);
  
      
       Pisos obj_piso = new Pisos(12,obj_cuidado1,obj_cuidado2,obj_cuidado3);
   //   Proceso.hospitalproceso.setPiso(obj_piso);
        int opc,claveCom;
        Paciente e= new Paciente();
				e.setId(1234);
				e.setEdad(23);
				e.setNombre("jose");
                                e.setApellidos("sancehz gomez");
				e.setTelefono(1234);
				e.setCorreo("josae23123");
                                Proceso.hospitalproceso.setPaciente(e);
                                Persona es= new Persona();
				es.setId(1234);
				es.setEdad(23);
				es.setNombre("jose");
                                es.setApellidos("sancehz gomez");
				es.setTelefono(1234);
				es.setCorreo("josae23123");
                               // e.setAcompañante(es);
                                
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
                   proceso.menuAdministrador();
                   
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
                   proceso.menuRepcionista();
                  
               } else {
                    claveCom=inOut.solicitarEntero("Ingrese la clave de la recepción ");
                    while(claveRec != claveCom){
                   claveCom=inOut.solicitarEntero("Ingrese la clave de la recepción correctamente: ");              
                    }
                    proceso.menuRepcionista(); 
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
                    proceso.menumedico();
               }
               
               break;
            case 4:
                crearArchivo(Proceso.hospitalproceso);
                System.exit(0);
                break;
            case 5:
                leerArchivo();
                default: inOut.mostrarResultado("OPCION NO VALIDA, DIGITE NUEVAMENTE UNA OPCION");
            } 
          
        }while(opc!=5);
        
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
    
   
        
public static void crearArchivo(Hospital objhospital) {
                ArrayList <Medico> medicos = objhospital.getMedicos();
                ArrayList <Paciente> pacientes = objhospital.getPacientes();
                ArrayList <Paciente> pacienteshistorial = objhospital.getRegistro_paciente();
                ArrayList <EPS> epshospital = objhospital.getEps();
                ArrayList <Pisos> pisoshospital = objhospital.getPisos();
                Cuidados cuidados = new Cuidados(); 
		FileWriter flwriter = null;
		try {
			//crea el flujo para escribir en el archivo
			flwriter = new FileWriter("hospital.txt",false);
			//crea un buffer o flujo intermedio antes de escribir directamente en el archivo
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
                      
                       
                        for(Paciente paciente : pacientes){
                            bfwriter.write(paciente.getId()+","+paciente.getEdad()+","+paciente.getNombre()+","+paciente.getApellidos()+","+paciente.getTelefono()+","+paciente.getCorreo()+",");
                            if(paciente.getAcompañante() == null){
                                bfwriter.write("null");
                                
                            }else{
                                
                                
                                bfwriter.write(","+paciente.getAcompañante().getNombre()+","+paciente.getAcompañante().getApellidos()+","+paciente.getAcompañante().getId()+","+paciente.getAcompañante().getTelefono());
                            
                            }
                            
                        }
                       
                          
			//cierra el buffer intermedio
			bfwriter.close();
			System.out.println("Archivo de medicos creado satisfactoriamente..");
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flwriter != null) {
				try {//cierra el flujo principal
					flwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
public static void crearArchivoRegistro(Hospital objhospital) {
              ArrayList<Paciente> pacientes =  objhospital.getPacientes();
              
		FileWriter flwriter = null;
		try {
			//crea el flujo para escribir en el archivo
			flwriter = new FileWriter("registropacientes.txt",false);
			//crea un buffer o flujo intermedio antes de escribir directamente en el archivo
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
                        bfwriter.write( "%");
                        for(Paciente paciente : pacientes){
                   
                            if(paciente.getHistoriaclinica()!= null ){
                                for(HistoriaClinica historias : paciente.getHistoriaclinica() ){
                                  
                                  bfwriter.write(paciente.getId()+","+paciente.getNombre()+","+historias.getFechaHospitalizacion()+","+historias.getDescripcion()+","+historias.getMedicoencargado());
                                }
                                
                                
                            }
                        }
                        bfwriter.write("%");
                       
			//cierra el buffer intermedio
			bfwriter.close();
 
		} catch (IOException e) {
			e.printStackTrace();
		} finally {
			if (flwriter != null) {
				try {//cierra el flujo principal
					flwriter.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}

public static void leerArchivo() {
		// crea el flujo para leer desde el archivo
		File file = new File("hospital.txt");
		ArrayList <Paciente>listadepacientes= new ArrayList<Paciente>();
		Scanner scanner;
             
		try {
			//se pasa el flujo al objeto scanner
                        
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {
				// el objeto scanner lee linea a linea desde el archivo
				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);
                               
				//se usa una expresión regular
				//que valida que antes o despues de una coma (,) exista cualquier cosa
				//parte la cadena recibida cada vez que encuentre una coma
                                  delimitar.useDelimiter("\\s*,\\s*");
                                
                                  
				Paciente e= new Paciente();
				e.setId(delimitar.nextInt());
				e.setEdad(delimitar.nextInt());
                                
				e.setNombre(delimitar.next());
                                e.setApellidos(delimitar.next());
				e.setTelefono(delimitar.nextInt());
				e.setCorreo(delimitar.next());
                                String a =(delimitar.next());
                               
                               if(a.equalsIgnoreCase("null")){
                                   System.out.println("hola");
                                   e.setAcompañante(null);
                               }else{
                                 Persona acompañante = new Persona();
                                 acompañante.setNombre(delimitar.next());
                                 acompañante.setApellidos(delimitar.next());
                                 acompañante.setId(delimitar.nextInt());
                                 acompañante.setTelefono(delimitar.nextInt());
                                        e.setAcompañante(acompañante);
                               }
				listadepacientes.add(e);
                                      
                             
                                
				
			}
			//se cierra el ojeto scanner
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace(System.out);
		}
		for(int i=0;i<listadepacientes.size();i++){
                    System.out.println(listadepacientes.get(i).toString());
                }
                        
	}

}
 



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
        
       // Proceso.hospitalproceso.setNombreEps(new EPS("coompensar",123));
       //   proceso.ingresarPaciente();
       Cuidados obj_cuidado1 = new Cuidados(20,12);
       Cuidados obj_cuidado2 = new Cuidados(10,5);      
       Cuidados obj_cuidado3 = new Cuidados(7,4);
  
      
       Pisos obj_piso = new Pisos(12,obj_cuidado1,obj_cuidado2,obj_cuidado3);
       Proceso.hospitalproceso.setPiso(obj_piso);
        int opc,claveCom;
        Paciente e= new Paciente();
				e.setId(1234);
				e.setEdad(23);
				e.setNombre("jose");
                                e.setApellidos("sancehz gomez");
				e.setTelefono(1234);
				e.setCorreo("josae23123");
                                 Persona es= new Persona();
				es.setId(1234);
				es.setEdad(23);
				es.setNombre("jose");
                                es.setApellidos("sancehz gomez");
				es.setTelefono(1234);
				es.setCorreo("josae23123");
                                e.setAcompañante(es);
                                Proceso.hospitalproceso.setPaciente(e);
                                Paciente f= new Paciente();
				f.setId(4321);
				f.setEdad(32);
				f.setNombre("oscar");
                                f.setApellidos("sanabria gomez");
				f.setTelefono(1234);
				f.setCorreo("josodsa2");
                                 Persona ex= new Persona();
				ex.setId(2323);
				ex.setEdad(23);
				ex.setNombre("tulio");
                                ex.setApellidos("carbon leche");
				ex.setTelefono(1234);
				ex.setCorreo("tuliosdao23");
                                f.setAcompañante(ex);
                                Proceso.hospitalproceso.setPaciente(f);
                               Paciente g= new Paciente();
				g.setId(2313);
				g.setEdad(34);
				g.setNombre("toni");
                                g.setApellidos("asdas saas");
				g.setTelefono(3213);
				g.setCorreo("j213df");
                                Proceso.hospitalproceso.setPaciente(g);
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
                   proceso.menuAdministrador();
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
                
                if(bandRec == false){

                   claveCom=inOut.solicitarEntero("Ingrese la clave de la recepción: ");
                   claveRec = claveCom;
                   proceso.menuRepcionista();

                   claveRec=inOut.solicitarEntero("Ingrese la clave de la recepción: ");

                   bandRec = true;
               } else {
                    claveCom=inOut.solicitarEntero("Ingrese la clave de la recepción ");
                    while(claveRec != claveCom){
                   claveCom=inOut.solicitarEntero("Ingrese la clave de la recepción correctamente: ");              
                    }
                    
                    
               }
                proceso.menuRepcionista(); 
               break;
                
            case 3:
                
                if(bandMedico == false){
                   claveCom=inOut.solicitarEntero("Ingrese la clave del personal de medicina: ");
                   claveMedico = claveCom;
                   proceso.menumedico();
                   bandMedico = true;
               } else {
                    claveCom=inOut.solicitarEntero("Ingrese la clave del personal de medicina: ");
                    while(claveMedico != claveCom){
                   claveCom=inOut.solicitarEntero("Ingrese la clave del personal de medicina correctamente: ");
                    }
                    proceso.menumedico();
               }
               
               break;
            case 4:
                crear(Proceso.hospitalproceso);
                System.exit(0);
                break;
            case 5:
                leerArchivo();
                break;
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
    
   
        


public static void crear(Hospital objhospital){
    ArrayList <Paciente> pacientes= objhospital.getPacientes();
    try{
        File f = new File("archivo.txt");
        FileWriter fw;
        BufferedWriter bw;
      
            fw = new FileWriter (f,false);
            bw = new BufferedWriter(fw);
            
            for(int i=0;i<pacientes.size();i++){
          
            bw.write(pacientes.get(i).getId()+","+pacientes.get(i).getEdad()+","+pacientes.get(i).getNombre()+","+pacientes.get(i).getCorreo());
            
           if(pacientes.get(i).getAcompañante() == null){
                                bw.write(","+"null");
                                
                            }else{
                                
                                
                                bw.write(","+pacientes.get(i).getAcompañante().getNombre()+","+pacientes.get(i).getAcompañante().getApellidos()+","+pacientes.get(i).getAcompañante().getId()+","+pacientes.get(i).getAcompañante().getTelefono());
                            
                            }
           bw.write("\n");
            }
            
        
            
            
        
 
        bw.close();
        fw.close();
    }catch(Exception e){
        System.out.println(e);
    }
}

public static void leer(){
    try{
        File f = new File("archivos.txt");
        if(f.exists()){
            FileReader fr =new FileReader(f);
            BufferedReader br = new  BufferedReader(fr);
            String linea;
            while ((linea=br.readLine())!=null){
                
                String[] contacto = linea.split(",");
                //int cedula = contacto[0].;
                
                Paciente p = new Paciente();
            }
        }else{
            System.out.println("vacio");
        }
    }catch(Exception e){
    System.out.println(e);
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
 


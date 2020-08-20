package Modelo;

import Vista.InOut;
import java.io.*;
import java.util.*;
public class manejoarchivos
{
    private InOut ioData= new InOut();
    private String id;
    private double cantidad;
    File ficherodeposito= new File ("pacientes.txt");
    
    public manejoarchivos ()//objeto para enviar los datos a esta clase
    { 
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
                      
                       
                        for(int i=0 ; i<pacientes.size(); i++){
                            if(i == pacientes.size()-1){
                                bfwriter.write(pacientes.get(i).getId()+","+pacientes.get(i).getEdad()+","+pacientes.get(i).getNombre()+","+pacientes.get(i).getApellidos()+","+pacientes.get(i).getTelefono()+","+pacientes.get(i).getCorreo()+","+pacientes.get(i).getTipobeneficio()+",");
                            if(pacientes.get(i).getAcompañante() == null){
                                bfwriter.write("null");
                                
                            }else{
                                bfwriter.write(pacientes.get(i).getAcompañante().getNombre()+","+pacientes.get(i).getAcompañante().getApellidos()+","+pacientes.get(i).getAcompañante().getId()+","+pacientes.get(i).getAcompañante().getTelefono());
                            }
                                
                            } else{
                            bfwriter.write(pacientes.get(i).getId()+","+pacientes.get(i).getEdad()+","+pacientes.get(i).getNombre()+","+pacientes.get(i).getApellidos()+","+pacientes.get(i).getTelefono()+","+pacientes.get(i).getCorreo()+","+pacientes.get(i).getTipobeneficio()+",");
                            if(pacientes.get(i).getAcompañante() == null){
                                bfwriter.write("null\n");
                                
                            }else{
                                
                                bfwriter.write(pacientes.get(i).getAcompañante().getNombre()+","+pacientes.get(i).getAcompañante().getApellidos()+","+pacientes.get(i).getAcompañante().getId()+","+pacientes.get(i).getAcompañante().getTelefono()+"\n");
                            
                            }
                            }
                        }
                       
                          
			//cierra el buffer intermedio
			bfwriter.close();
			System.out.println("Archivo creado satisfactoriamente..");
 
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
    
    public static void leerArchivo(Hospital objhospital) {
		// crea el flujo para leer desde el archivo
		File file = new File("hospital.txt");
		
		Scanner scanner;
             
		try {
			//se pasa el flujo al objeto scanner
                        
			scanner = new Scanner(file);
			while (scanner.hasNextLine()) {

				// el objeto scanner lee linea a linea desde el archivo

				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);

                                delimitar.useDelimiter("\\s*,\\s*");
                                
        
				Paciente e= new Paciente();
				e.setId(delimitar.nextInt());
				e.setEdad(delimitar.nextInt());              
				e.setNombre(delimitar.next());
                                e.setApellidos(delimitar.next());
				e.setTelefono(delimitar.nextInt());
				e.setCorreo(delimitar.next());
                                e.setTipobeneficio(delimitar.nextInt());
                                String a = (delimitar.next());
                               
                               if(a.equalsIgnoreCase("null")){

                                   e.setAcompañante(null);
                               }else{
                           
                                 Persona acompañante = new Persona();
                           
                                 acompañante.setNombre(a);               
                                 acompañante.setApellidos(delimitar.next());
                                 acompañante.setId(delimitar.nextInt());
                                 acompañante.setTelefono(delimitar.nextInt());
                                 e.setAcompañante(acompañante);
                               }

				objhospital.getPacientes().add(e);
                               System.out.println(e.toString());;

			}
			//se cierra el ojeto scanner
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace(System.out);
		}
		     
	}

}
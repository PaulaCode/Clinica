
package Control;

import Modelo.Cuidados;
import Modelo.EPS;
import Modelo.Hospital;
import Modelo.Medico;
import Modelo.Paciente;
import Modelo.Pisos;
import Modelo.Proceso;
import Vista.InOut;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;


public class Main {

     static InOut inOut = new InOut();
     private static int claveAdmin,claveRec,claveMedico;
     private static String nombre = " ";
     static  Proceso proceso = new Proceso();
     static boolean bandAdmin = false, bandRec= false, bandMedico = false;
       
       
    public static void main(String[] args) {
        
       // Proceso.hospitalproceso.setNombreEps(new EPS("coompensar",123));
       //   proceso.ingresarPaciente();
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
                crearArchivo(Proceso.hospitalproceso);
                System.exit(0);
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
                           bfwriter.write( "%");
			for ( Medico medico : medicos ) {
				//escribe los datos en el archivo
				bfwriter.write(medico.getId() + "," + medico.getEdad() + "," + medico.getNombre()
						+ "," + medico.getApellidos() + "," + medico.getTelefono()+ "," 
                                                 + medico.getCorreo()+   ","+ medico.getEspecializacion()+ "," +medico.getCarnet()+   "\n");
                                
			}
                        bfwriter.write("%");
                        for(Paciente paciente : pacientes){
                            bfwriter.write(paciente.getId()+","+paciente.getEdad()+","+paciente.getNombre()+","+paciente.getApellidos()+","+paciente.getTelefono()+","+paciente.getCorreo()+","+paciente.getAcompañante());
                            
                        }
                        bfwriter.write("%");
                          for(Pisos pisos : pisoshospital ){
                            bfwriter.write(pisos.getNumpiso()+",");
                            if(pisos.getIntensivos()== null){
                                 bfwriter.write("null"+",");
                            }else{
                                
                                bfwriter.write(pisos.getIntensivos().getCantidadDecamas()+","+pisos.getIntensivos().getOcupacion());
                            }
                            if(pisos.getIntermedios()== null){
                                 bfwriter.write("null"+",");
                            }else{
                                
                                bfwriter.write(pisos.getIntermedios().getCantidadDecamas()+","+pisos.getIntermedios().getOcupacion());
                            }
                             if(pisos.getRecuperacion()== null){
                                 bfwriter.write("null"+",");
                            }else{
                                
                                bfwriter.write(pisos.getRecuperacion().getCantidadDecamas()+","+pisos.getIntermedios().getOcupacion());
                            }
                            
                        }
                          for(EPS eps : epshospital){
                              bfwriter.write(eps.getNombre()+","+eps.getCodigo());
                              
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


}
 


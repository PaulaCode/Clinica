package Modelo;

import Vista.InOut;
import java.io.*;
import java.util.*;
public class manejoarchivos
{
    private InOut ioData= new InOut();

    
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
                                bfwriter.write(pacientes.get(i).getId()+","+pacientes.get(i).getEdad()+","+pacientes.get(i).getNombre()+","+pacientes.get(i).getApellidos()+","+pacientes.get(i).getTelefono()+","+pacientes.get(i).getCorreo()+","+pacientes.get(i).getTipobeneficio()+","
                                +pacientes.get(i).getTipo_cuidado().getCantidadDecamas()+","+pacientes.get(i).getTipo_cuidado().getOcupacion()+",");
                            if(pacientes.get(i).getAcompañante() == null){
                                bfwriter.write("null");
                                
                            }else{
                                bfwriter.write(pacientes.get(i).getAcompañante().getNombre()+","+pacientes.get(i).getAcompañante().getApellidos()+","+pacientes.get(i).getAcompañante().getId()+","+pacientes.get(i).getAcompañante().getTelefono());
                            }
                                
                            } else{
                            bfwriter.write(pacientes.get(i).getId()+","+pacientes.get(i).getEdad()+","+pacientes.get(i).getNombre()+","+pacientes.get(i).getApellidos()+","+pacientes.get(i).getTelefono()+","+pacientes.get(i).getCorreo()+","+pacientes.get(i).getTipobeneficio()+","
                            +pacientes.get(i).getTipo_cuidado().getCantidadDecamas()+","+pacientes.get(i).getTipo_cuidado().getOcupacion()+",");
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
                                Cuidados obj_cuidado = new Cuidados();
				e.setId(delimitar.nextInt());
				e.setEdad(delimitar.nextInt());              
				e.setNombre(delimitar.next());
                                e.setApellidos(delimitar.next());
				e.setTelefono(delimitar.nextInt());
				e.setCorreo(delimitar.next());
                                e.setTipobeneficio(delimitar.nextInt());
                                obj_cuidado.setCantidadDecamas(delimitar.nextInt());
                                obj_cuidado.setOcupacion(delimitar.nextInt());
                                e.setTipo_cuidado(obj_cuidado);
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
        
			}
			//se cierra el ojeto scanner
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace(System.out);
		}
		     
	}
    
    public static void crearHistoria(Hospital objhospital) {
                
                ArrayList <Paciente> pacientes = objhospital.getRegistro_paciente();
                ArrayList <HistoriaClinica> historias= new ArrayList<>();
               File f = new File("historias.txt");
		FileWriter flwriter = null;
		try {
			//crea el flujo para escribir en el archivo
			flwriter = new FileWriter(f,false);
			//crea un buffer o flujo intermedio antes de escribir directamente en el archivo
			BufferedWriter bfwriter = new BufferedWriter(flwriter);
                       
                   for(int i=0;i<pacientes.size();i++){               
                        historias = pacientes.get(i).getHistoriaclinica();
                    
                    for(int j=0;j<historias.size();j++){
                         bfwriter.write(pacientes.get(i).getId()+","+pacientes.get(i).getNombre()+","+pacientes.get(i).getApellidos()+",");
                        if(i==pacientes.size()-1){
                            if(j==historias.size()-1){
                          
                                 bfwriter.write(historias.get(j).getFechaHospitalizacion()+","+historias.get(j).getMedicoencargado().getNombre()+","+historias.get(j).getMedicoencargado().getApellidos()+","+historias.get(j).getDescripcion());
                           
                            }else{
                              bfwriter.write(historias.get(j).getFechaHospitalizacion()+","+historias.get(j).getMedicoencargado().getNombre()+","+historias.get(j).getMedicoencargado().getApellidos()+","+historias.get(j).getDescripcion()+"\n");
                        } 
                        }else{
                            bfwriter.write(historias.get(j).getFechaHospitalizacion()+","+historias.get(j).getMedicoencargado().getNombre()+","+historias.get(j).getMedicoencargado().getApellidos()+","+historias.get(j).getDescripcion()+"\n");
                        }
                }
                      
                   }   
			//cierra el buffer intermedio
			bfwriter.close();
			System.out.println("Archivo creado satisfactoriamente..");
 
		} catch (IOException e) {
			e.printStackTrace(System.out);
		} finally {
			if (flwriter != null) {
				try {//cierra el flujo principal
					flwriter.close();
				} catch (IOException e) {
					e.printStackTrace(System.out);
				}
			}
		}
	}
        
        public static void leerArchivoHistorias(Hospital objhospital) {
		// crea el flujo para leer desde el archivo
		File file = new File("historias.txt");
		
		Scanner scanner;
             
		try {
			//se pasa el flujo al objeto scanner
                        boolean si = false ;
			scanner = new Scanner(file);
                        int cedulaAnt;
			while (scanner.hasNextLine()) {
                                si = false;
				// el objeto scanner lee linea a linea desde el archivo

				String linea = scanner.nextLine();
				Scanner delimitar = new Scanner(linea);

                                delimitar.useDelimiter("\\s*,\\s*");
                                
                                int cedula;
				Paciente e= new Paciente();
                                
                                HistoriaClinica historia = new HistoriaClinica();
                                Medico medico = new Medico();
                                        
                                cedula = delimitar.nextInt();
                                e.setId(cedula);              
				e.setNombre(delimitar.next());
                                e.setApellidos(delimitar.next());
                                historia.setFechaHospitalizacion(delimitar.next());
                                medico.setNombre(delimitar.next());
                                medico.setApellidos(delimitar.next());
                                historia.setMedicoencargado(medico);
                                historia.setDescripcion(delimitar.next());
                               
                                if(!objhospital.getRegistro_paciente().isEmpty()){
                                for(int i=0; i<objhospital.getRegistro_paciente().size(); i++){
                                    if(cedula == objhospital.getRegistro_paciente().get(i).getId()){
                                        System.out.println("WHY");
                                        objhospital.getRegistro_paciente().get(i).setHistoria(historia);
                                        si = true;
                                    }
                                }
                                }
                                if(si==false)
                                {
                                    System.out.println("Why 2 :8");
                                e.setHistoria(historia);
                                objhospital.getRegistro_paciente().add(e);
                                }
                            
			}
			//se cierra el ojeto scanner
			scanner.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace(System.out);
		}
		     
	}
	
        public static void almacenarPisos(ArrayList<Pisos> lista_pisos)
        {
            File f = new File("Pisos.txt");
            try{
                FileWriter fw = new FileWriter(f,false);
               BufferedWriter bfwriter = new BufferedWriter(fw);
               for(Pisos obpiso:lista_pisos)
               {
                   bfwriter.write(obpiso.getNumpiso()+"");
                   if(obpiso.getIntensivos()!=null)
                   {
                       bfwriter.write(",1,"+obpiso.getIntensivos().getCantidadDecamas()+","+obpiso.getIntensivos().getOcupacion());
                   }
                   else
                   {
                       bfwriter.write(",-1,0,-1");
                   }
                   if(obpiso.getIntermedios()!=null)
                   {
                      bfwriter.write(",2,"+obpiso.getIntermedios().getCantidadDecamas()+","+obpiso.getIntermedios().getOcupacion());
                   }
                   else
                   {
                       bfwriter.write(",-1,0,-1");
                   }
                   if(obpiso.getRecuperacion()!=null)
                   {
                      bfwriter.write(",3,"+obpiso.getRecuperacion().getCantidadDecamas()+","+obpiso.getRecuperacion().getOcupacion());
                   }
                   else
                   {
                       bfwriter.write(",-1,0,-1");
                   }
                   bfwriter.write("\n");
               }
               bfwriter.close();
                System.out.println("Archivo pisos creado con éxito!");
            }
            catch(IOException e)
            {
                e.printStackTrace(System.out);
            }
        }
        public static void leerPisos(Hospital obj_hospital)
        {
            File file = new File("Pisos.txt");
            try{
                Scanner scanner = new Scanner(file);

                while(scanner.hasNextLine())
                {   
                    String linea = scanner.nextLine();
                    Scanner delimitar = new Scanner(linea);
                    delimitar.useDelimiter("\\s*,\\s*"); 
                    
                    Pisos obj_piso = new Pisos();
                    obj_piso.setNumpiso(delimitar.nextInt());
                    for(int i =0;i<3;i++)
                    {
                        int tipo = delimitar.nextInt();
                        if(tipo!=-1)
                        {
                             Cuidados obj_cuidados = new Cuidados();
                             obj_cuidados.setCantidadDecamas(delimitar.nextInt());
                             obj_cuidados.setOcupacion(delimitar.nextInt());
                            if(tipo==1)
                            {
                              obj_piso.setIntensivos(obj_cuidados);
                            }
                            if(tipo==2)
                            {
                              obj_piso.setIntermedios(obj_cuidados); 
                            }
                            if(tipo==3)
                            {
                              obj_piso.setRecuperacion(obj_cuidados);
                            }    
                     
                       }
                        else{
                        int x= delimitar.nextInt();
                        int y= delimitar.nextInt();
                        }
                    }
                    obj_hospital.setPisos(obj_piso);
                    
                }
                scanner.close();
            }
            catch(IOException e)
            {
                e.printStackTrace(System.out);
            }
        }

    
}
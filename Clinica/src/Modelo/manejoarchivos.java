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

    public void existearchivo()//metodo para hacer la base de datos
    {
        try
        {
            if (ficherodeposito.exists())//saber si existe el archivo de texto
            {
                ioData.mostrarResultado("la base de datos ya existe");
            }
            else
            {
                ficherodeposito.createNewFile();
                ioData.mostrarResultado("base de datos creada");
            }
        }
        catch(Exception ex)
        {
           ioData.mostrarResultado(ex.getMessage());
        }
    }

    public void asignardatos(String id2,double saldo2)
    {
        id = id2;               
        cantidad=saldo2;           
        try
        {
            BufferedWriter Fescribe=new BufferedWriter(new OutputStreamWriter(new FileOutputStream(ficherodeposito,true)));//no se para que sirve
            Fescribe.write(id+"    "+cantidad+"    "); //guarda en la base de datos los archivos                            //utf8 es un tipo de formato
            Fescribe.write("\n");//para el salto de linea    
            ioData.mostrarResultado("El producto ha sido insertado en la base de datos");
            Fescribe.close();//cerrar el fichero y que los datos se queden escritos
        }
        catch(Exception ex)
        {
            ioData.mostrarResultado(ex.getMessage());
        }
    }

    public void mostrararchivos()
    {
        try
        {
            FileReader fr=new FileReader("pacientes.txt");
            BufferedReader br=new BufferedReader(fr);
            String cadena;
            while((cadena=br.readLine())!= null) //cuando el la siguiente linea leida no halla nada significa que termino de ller los datos del archivo
            {
                ioData.mostrarResultado(""+cadena); 
            }
        }
        catch(Exception ex)
        {
            ioData.mostrarResultado(ex.getMessage());
        }
    }

    public void buscarregistro(String id2)
    {
        String usuario=id2;
        try
        {
            BufferedReader leer=new BufferedReader(new FileReader ("pacientes.txt"));
            String linea="";
            while((linea=leer.readLine())!=null)
            {
                if (linea.indexOf(usuario)!=-1)
                {
                   ioData.mostrarResultado("se encontro el registro: "+linea);
                }
            }
        }
        catch(Exception ex)
        {
            ioData.mostrarResultado(ex.getMessage());
        }
    }
    /*public void saldoderegistro(String id2)//para buscar un saldo 
    {
        String usuario=id2;
        try
        {
            //declare hasta arriba private scanner entrada
           // ioData = new InOut( new File( "pacientes.txt") );//va a ller datos dentro de deposito
            BufferedReader leer=new BufferedReader(new FileReader ("pacientes.txt"));
            String linea="";
            while((linea=leer.readLine())!=null)
            {
                if (linea.indexOf(usuario)!=-1)//al encontrar el dato buscado 
                {   //arturo  100 
                    System.out.print("se encontro el registro: "+usuario);
                    String id=ioData.solicitarNombre("id");//primero hay que obtener los datos antes para poder llegar al saldo
                    double saldo=ioData.solicitarDoubles("saldo");
                    if (saldo<0)
                    {
                        System.out.println(" su saldo es deudor, "+saldo);
                    }
                    else
                    {
                        System.out.println(" su saldo es acreedor, "+saldo);
                    }
                }
            }

        }
        catch(Exception ex)
        {
            System.out.println(ex.getMessage());
        }
    }*/
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
                            bfwriter.newLine();
                            
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
}
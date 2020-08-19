
package Modelo;

import Control.Main;
import Vista.InOut;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Proceso {
    
     InOut ioData = new InOut();
    public static Hospital hospitalproceso = new Hospital();
    private ArrayList<Persona> lista_personas = new ArrayList<>();
    public Verificaciones verificaciones = new Verificaciones();
    
    public void menumedico (){
        int opc;
        int claveCom;
        do{
            opc=ioData.solicitarEntero("1.Cambiar clave "+

                                   "\n2.Atender paciente ");

        switch(opc){
            case 1:
               claveCom=ioData.solicitarEntero("Ingrese la clave del personal de medicina nuevamente: ");
               while(Main.getClaveMedico() != claveCom){
                   claveCom=ioData.solicitarEntero("Ingrese la clave del personal de medicina correctamente: ");
               }
               claveCom = ioData.solicitarEntero("Ingrese la nueva clave del personal de medicina: ");
               Main.setClaveMedico(claveCom);
               ioData.mostrarResultado("Clave cambiada con exito");
                break;
                
            case 2:

                if (hospitalproceso.getPacientes()== null){
              
                    ioData.mostrarResultado("No hay pacientes en lista de espera.");
                }else{
                    
                    
                }
               
                
                break;
                
                
                default: ioData.mostrarResultado("OPCION NO VALIDA, DIGITE NUEVAMENTE UNA OPCION");
            } 
          
        }while(opc!=2);
    
    }
    
    public void menuAdministrador(){
         int opc;
        ArrayList<EPS> eps = hospitalproceso.getEps();
        ArrayList<Medico> medico = hospitalproceso.getMedicos();
         do{
            opc=ioData.solicitarEntero("Hospital "+Main.getNombre()+
                                       "\n1.Registrar EPS "+
                                       "\n2.Eliminar EPS "+
                                       "\n3.Registrar médicos "+
                                       "\n4.Cambiar clave"+
                                       "\n5.Salir " +
                                       "\n\nDigite la opción que desee");
        switch(opc){
            case 1:
                String nombre = ioData.solicitarNombre("Digite el nombre de la EPS");
                int codigo = ioData.solicitarEntero("Digite el código de la EPS");
               while(verificaciones.verificarCodigo(codigo, eps) != -1){
                   codigo = ioData.solicitarEntero("El código está repetido. \nIngrese el código de la EPS: ");
               }
               hospitalproceso.setNombreEps(new EPS(nombre,codigo));
               
                break;
              
            case 2:
                String acumulador;
                acumulador = mostrarEPS();
                acumulador+= ("\n\nDigite el número de la EPS que desea eliminar.");
                int numero = ioData.solicitarEntero(acumulador);
                numero = verificaciones.returnPosicion(numero, eps);
                hospitalproceso.getEps().remove(numero);
                
                break;
            
            case 3:
                
                nombre = ioData.solicitarNombre("Digite los nombres del médico");
                String apellidos = ioData.solicitarNombre("Digite los apellidos del médico");
                int id = ioData.solicitarEntero("Digite la identificación del médico.");
                while(verificaciones.validarIdentificacion(id) == true ||verificaciones.validarIdentificacionMedico(id) == true ){
                    id = ioData.solicitarEntero("\nLa identificación está repetida. \nDigite la identificación del médico.");
                }
                int edad = ioData.solicitarEntero("Digite la edad del médico.");
                int telefono = ioData.solicitarEntero("Digite el teléfono del médico.");
                String correo = ioData.solicitarNombre("Digite el correo del médico.");
                while(verificaciones.validarCorreo(correo) == true || verificaciones.validarIdentificacionMedico(telefono) == true){
                    correo = ioData.solicitarNombre("\nEl correo está repetido. \nDigite el correo del médico.");
                }
                String especializacion = ioData.solicitarNombre("Escriba en qué se especializa el médico.");
                int carnet = ioData.solicitarEntero("Digite el carnet");
               hospitalproceso.getMedicos().add(new Medico(id,edad, nombre, apellidos, telefono, correo, especializacion,carnet));
                
                break;
                
            case 4:
                
               int claveCom=ioData.solicitarEntero("Ingrese la clave del administrador: ");
               while(Main.getClaveAdmin() != claveCom){
                   claveCom=ioData.solicitarEntero("Ingrese la clave del administrador correctamente: ");
               }
               claveCom = ioData.solicitarEntero("Ingrese la nueva clave del administrador: ");
               Main.setClaveAdmin(claveCom);
               ioData.mostrarResultado("Clave cambiada con exito");
                break;
                
             case 5: break;    
                
            default: ioData.mostrarResultado("OPCION NO VALIDA, DIGITE NUEVAMENTE UNA OPCION");
            } 
 
        }while(opc!=5);
        
    }
  
    public void ingresarPaciente()
    {
        Persona persona_encargada = new Persona();
        Paciente obj_paciente = new Paciente();
        HistoriaClinica obj_historia = new HistoriaClinica();
        insertarPersona(obj_paciente);
        if(obj_paciente.getEdad()<18||obj_paciente.getEdad()>=70)
        {
           asignarAdulto(persona_encargada,obj_paciente);   
        }
        insertarHistoria(obj_paciente);
        int codigo_eps  = (ioData.solicitarEntero(hospitalproceso.getEps()+"\n0.Ninguna"));
        if(codigo_eps!=0)
        {
           obj_paciente.setEps(verificaciones.returnEps(codigo_eps));
           while(obj_paciente.getEps()==null)
           {
              if(codigo_eps!=0)
              codigo_eps  = (ioData.solicitarEntero(hospitalproceso.getEps()+"\n0.Ninguna")); 
              obj_paciente.setEps(verificaciones.returnEps(codigo_eps));
           }
            obj_paciente.setTipobeneficio(ioData.solicitarEntero("TIPO AFILIADO\n  1.Cotizante\n2.Beneficiario\n\nDigite el tipo de afiliado"));
            while(obj_paciente.getTipobeneficio()!=1||obj_paciente.getTipobeneficio()!=2)
            {
               obj_paciente.setTipobeneficio(ioData.solicitarEntero("TIPO AFILIADO\n  1.Cotizante\n2.Beneficiario\n\nOpción no encontrada\nDigite el tipo de afiliado"));
            }
        }
        asignarCama(obj_paciente);
        hospitalproceso.setPaciente(obj_paciente);
        lista_personas.add(obj_paciente);
    }
    
    public void asignarAdulto(Persona obj_persona,Paciente paciente)
    {
        obj_persona.setId(ioData.solicitarEntero("Digite la identificación de la persona"));
        while(verificaciones.validarIdentificacion(obj_persona.getId()))
        {
          obj_persona.setId(ioData.solicitarEntero("Identificación ya registrada\nDigite la identificación de la persona"));   
        }
        obj_persona.setNombre(ioData.solicitarNombre("Digite el nombre de la persona"));
        while(verificaciones.validarNombre(obj_persona.getNombre()))
        {
           obj_persona.setNombre(ioData.solicitarNombre("Máximo 2 nombres\nDigite el nombre de la persona")); 
        }
        obj_persona.setApellidos(ioData.solicitarNombre("Digite el apellido de la persona"));
        while(verificaciones.validarApellido(obj_persona.getApellidos())||!verificaciones.validarParentesco(paciente.getApellidos(),obj_persona.getApellidos()))
        {
            if(verificaciones.validarApellido(obj_persona.getApellidos()))
            obj_persona.setApellidos(ioData.solicitarNombre("Debe digitar 2 Apellidos\nDigite el apellido de la persona"));
            else
            obj_persona.setApellidos(ioData.solicitarNombre("Deben ser familiares \nDigite el apellido de la persona"));
    
        }
        obj_persona.setEdad(ioData.solicitarEntero("Digite la edad de la persona"));
        while(obj_persona.getEdad()<=0||obj_persona.getEdad()>=130)
        {
            obj_persona.setEdad(ioData.solicitarEntero("Digite la edad de la persona"));  
        }
        obj_persona.setTelefono(ioData.solicitarEntero("Digite el número telefónico"));
        while(obj_persona.getTelefono()<=0)
        {
         obj_persona.setTelefono(ioData.solicitarEntero("Formato incorrecto\nDigite el número telefónico"));
        }
        obj_persona.setCorreo(ioData.solicitarNombre("Digite el correo electrónico"));
       paciente.setAcompañante(obj_persona);
        lista_personas.add(obj_persona); 
        
    }
    public void insertarPersona(Persona obj_persona)
    {
        obj_persona.setId(ioData.solicitarEntero("Digite la identificación de la persona"));
        while(verificaciones.validarIdentificacion(obj_persona.getId()))
        {
          obj_persona.setId(ioData.solicitarEntero("Identificación ya registrada\nDigite la identificación de la persona"));   
        }
        obj_persona.setNombre(ioData.solicitarNombre("Digite el nombre de la persona"));
        while(verificaciones.validarNombre(obj_persona.getNombre()))
        {
           obj_persona.setNombre(ioData.solicitarNombre("Máximo 2 nombres\nDigite el nombre de la persona")); 
        }
        obj_persona.setApellidos(ioData.solicitarNombre("Digite el apellido de la persona"));
        while(verificaciones.validarApellido(obj_persona.getApellidos()))
        {
            obj_persona.setApellidos(ioData.solicitarNombre("Debe digitar 2 Apellidos\nDigite el apellido de la persona"));
        }
        obj_persona.setEdad(ioData.solicitarEntero("Digite la edad de la persona"));
        while(obj_persona.getEdad()<=0||obj_persona.getEdad()>=130)
        {
            obj_persona.setEdad(ioData.solicitarEntero("Digite la edad de la persona"));  
        }
        obj_persona.setTelefono(ioData.solicitarEntero("Digite el número telefónico"));
        while(obj_persona.getTelefono()<=0)
        {
         obj_persona.setTelefono(ioData.solicitarEntero("Formato incorrecto\nDigite el número telefónico"));
        }
        obj_persona.setCorreo(ioData.solicitarNombre("Digite el correo electrónico"));
        while(verificaciones.validarCorreo( obj_persona.getCorreo())){
                    obj_persona.setCorreo(ioData.solicitarNombre("\nEl correo está repetido. \nDigite el correo del médico."));
        }
        lista_personas.add(obj_persona);
    }
    public void insertarHistoria(Paciente obj_persona)
    {
        HistoriaClinica obj_historia = new HistoriaClinica();
        obj_historia.setFechaHospitalizacion("Digite la fecha de hospitalización en formato dd-mm-yyyy");
        while(!verificaciones.validarFecha(obj_historia.getFechaHospitalizacion()))
        {
         obj_historia.setFechaHospitalizacion("ERROR!\nDigite la fecha de hospitalización en formato dd-mm-yyyy");  
        }
        int carnet = ioData.solicitarEntero(hospitalproceso.mostrarMedicosE()+"\n\n Digite el carnet del médico");
        while(verificaciones.returnMedico(carnet)==null)
        {
          carnet = ioData.solicitarEntero("El médico ingresado no se encuentra\n"+hospitalproceso.mostrarMedicosE()+"\n\n Digite el carnet del médico");
        }
        obj_historia.setMedicoencargado(verificaciones.returnMedico(carnet));
        obj_historia.setDescripcion("Digite la causa por la que el paciente fue hospitalizado");
        while(verificaciones.validarNombre(obj_historia.getDescripcion()))
        {
          obj_historia.setDescripcion("Digite la causa por la que el paciente fue hospitalizado");
        }
        obj_persona.setHistoria(obj_historia);
    }
    public void asignarCama(Paciente obj_paciente)
    {
        int piso = ioData.solicitarEntero(hospitalproceso.mostrarPisos()+"\n\nDigite el número del piso");
        while(!verificaciones.validarNumeroPiso(piso))
        {
            piso = ioData.solicitarEntero(hospitalproceso.mostrarPisos()+"\n\nDato no encontrado\nDigite el número del piso");
        }
        int tipo = ioData.solicitarEntero("TIPO CUIDADO\n1. Intensivo \n2.Intermedio \n3.Recuperacion\n\nDigite a qué tipo de cuidado entrará el paciente ");
        while(tipo<=0||tipo>3)
        {
            tipo =  ioData.solicitarEntero("TIPO CUIDADO\n1. Intensivo \n2.Intermedio \n3.Recuperacion\n\nDigite a qué tipo de cuidado entrará el paciente ");
        }
        Pisos obj_piso = verificaciones.returnPiso(piso);
         switch (tipo) {
             case 1:
                 obj_paciente.setTipo_cuidado(obj_piso.getIntensivos());
                 obj_piso.getIntensivos().setOcupacion((obj_piso.getIntensivos().getOcupacion()+1));
                 break;
             case 2:
                 obj_paciente.setTipo_cuidado(obj_piso.getIntermedios());
                 obj_piso.getIntermedios().setOcupacion(obj_piso.getIntermedios().getOcupacion()+1);
                 break;
             case 3:
                 obj_paciente.setTipo_cuidado(obj_piso.getRecuperacion());
                 obj_piso.getRecuperacion().setOcupacion(obj_piso.getRecuperacion().getOcupacion()+1);
                 break;
         }
    }
    public void otorgarSalida()
    {
        int id = ioData.solicitarEntero("Digite la identificación del paciente");
        if(verificaciones.validarPaciente(id))
        {
          Paciente objpaciente = verificaciones.returnPaciente(id);
          int numpiso = verificaciones.returnNumeroPiso(objpaciente.getTipo_cuidado());
          Pisos obj_piso = verificaciones.returnPiso(numpiso);
          int tipo = verificaciones.returnTipoCuidado(objpaciente.getTipo_cuidado());
             switch (tipo) {
             case 1:
                 obj_piso.getIntensivos().setOcupacion((obj_piso.getIntensivos().getOcupacion()-1));
                 break;
             case 2:

                 obj_piso.getIntermedios().setOcupacion(obj_piso.getIntermedios().getOcupacion()-1);
                 break;
             case 3:
                 obj_piso.getRecuperacion().setOcupacion(obj_piso.getRecuperacion().getOcupacion()-1);
                 break;
            }
           hospitalproceso.getPacientes().remove(verificaciones.returnPosPaciente(id));
        }
        else
        {
            ioData.mostrarResultado("Paciente no encontrado");
        }
    }
    public void mostrarPacientes()
    {
        ioData.mostrarResultado(hospitalproceso.mostrarPacientes());
    }
    public void buscarPaciente()
    {
        int id = ioData.solicitarEntero("Digite la identificación del paciente");
        if(verificaciones.validarPaciente(id))
        {
            ioData.mostrarResultado(verificaciones.returnPaciente(id).toString());
        }
        else
        {
            ioData.mostrarResultado("Paciente no encontrado");
        }
    }
    public String mostrarEPS(){
        
        ArrayList<EPS> eps = hospitalproceso.getEps();
        String acumulador = " ";
     
        for(int i=0 ; i<eps.size(); i++){
            
            acumulador+= ("EPS número "+(i+1)+ "\n"+ eps.get(i).toString()+ ". \n");
            
        }
        return acumulador;
    }
    
    
}
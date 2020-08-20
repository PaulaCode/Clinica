package Modelo;

import Control.Main;
import Vista.InOut;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Scanner;
import java.util.StringTokenizer;

public class Proceso {

    InOut ioData = new InOut();
    public static Hospital hospitalproceso = new Hospital();
    public static ArrayList<Persona> lista_personas = new ArrayList<>();
    public Verificaciones verificaciones = new Verificaciones();
    int numeroPiso = 1;

    public void menumedico() {
        int opc;
        int claveCom;
        do {
            opc = ioData.solicitarEntero("1.Cambiar clave "
                    + "\n2.Atender paciente "
                    + "\n3.Salir ");

            switch (opc) {
                case 1:
                    claveCom = ioData.solicitarEntero("Ingrese la clave del personal de medicina nuevamente: ");
                    while (Main.getClaveMedico() != claveCom) {
                        claveCom = ioData.solicitarEntero("Ingrese la clave del personal de medicina correctamente: ");
                    }
                    claveCom = ioData.solicitarEntero("Ingrese la nueva clave del personal de medicina: ");
                    Main.setClaveMedico(claveCom);
                    ioData.mostrarResultado("Clave cambiada con exito");
                    break;

                case 2:

                    if (hospitalproceso.getPacientes() == null) {

                        ioData.mostrarResultado("No hay pacientes en lista de espera.");
                    } else {

                    }

                    break;
                case 3: break;
                default:
                    ioData.mostrarResultado("OPCION NO VALIDA, DIGITE NUEVAMENTE UNA OPCION");
            }

        } while (opc != 3);

    }

    public void menuAdministrador() {
        int opc;
        ArrayList<EPS> eps = hospitalproceso.getEps();
        ArrayList<Medico> medico = hospitalproceso.getMedicos();

        do {
            opc = ioData.solicitarEntero("Hospital " + Main.getNombre()
                    + "\n1.Registrar EPS "
                    + "\n2.Eliminar EPS "
                    + "\n3.Registrar médicos "
                    + "\n4.Cambiar clave"
                    + "\n5.Crear piso."
                    + "\n6.Mostrar pisos "
                    + "\n7.Salir "
                    + "\n\nDigite la opción que desee");
            switch (opc) {
                case 1:
                    String nombre = ioData.solicitarNombre("Digite el nombre de la EPS");
                    int codigo = ioData.solicitarEntero("Digite el código de la EPS");
                    while (verificaciones.verificarCodigo(codigo, eps) != -1) {
                        codigo = ioData.solicitarEntero("El código está repetido. \nIngrese el código de la EPS: ");
                    }
                    hospitalproceso.setNombreEps(new EPS(nombre, codigo));

                    break;

                case 2:
                    String acumulador;
                    acumulador = mostrarEPS();
                    acumulador += ("\n\nDigite el número de la EPS que desea eliminar.");
                    int numero = ioData.solicitarEntero(acumulador);
                    numero = verificaciones.returnPosicion(numero, eps);
                    hospitalproceso.getEps().remove(numero);

                    break;

                case 3:

                    ingresarMedico();

                    break;

                case 4:

                    int claveCom = ioData.solicitarEntero("Ingrese la clave del administrador: ");
                    while (Main.getClaveAdmin() != claveCom) {
                        claveCom = ioData.solicitarEntero("Ingrese la clave del administrador correctamente: ");
                    }
                    claveCom = ioData.solicitarEntero("Ingrese la nueva clave del administrador: ");
                    Main.setClaveAdmin(claveCom);
                    ioData.mostrarResultado("Clave cambiada con exito");
                    break;

                case 5:
                    int opc1;
                    Pisos pisos= new Pisos();
                    pisos.setNumpiso(numeroPiso);
                    do {
                        opc1 = ioData.solicitarEntero("Opción pisos: "
                                + "\n1.Cuidados intensivos "
                                + "\n2.Cuidados intermedios "
                                + "\n3.Recuperación"
                                + "\n4.Salir. "
                                + "\n\nDigite para qué tipo de cuidados quiere que tenga el piso");
                        switch (opc1) {
                            case 1:
                                    
                                if(pisos.getIntensivos() != null ){
                                    ioData.mostrarResultado("El piso ya tiene este tipo de cuidados.");
                                } else{
                                    int cantidadCamas = ioData.solicitarEntero("Digite la cantidad de camas de este cuidado.");
                                    pisos.setIntensivos(new Cuidados(cantidadCamas,0));
                                }
                                
                                break;

                            case 2:
                                
                                if(pisos.getIntermedios() != null ){
                                    ioData.mostrarResultado("El piso ya tiene este tipo de cuidados.");
                                } else{
                                    int cantidadCamas = ioData.solicitarEntero("Digite la cantidad de camas de este cuidado.");
                                    pisos.setIntermedios(new Cuidados(cantidadCamas,0));
                                }
                                
                                break;

                            case 3:

                                if(pisos.getRecuperacion() != null ){
                                    ioData.mostrarResultado("El piso ya tiene este tipo de cuidados.");
                                } else{
                                    int cantidadCamas = ioData.solicitarEntero("Digite la cantidad de camas de este cuidado.");
                                    pisos.setRecuperacion(new Cuidados(cantidadCamas,0));
                                }
                                break;
                            case 4: 
                                hospitalproceso.setPisos(pisos);
                                numeroPiso++;
                                break;

                        }
                    }while (opc1 != 4);
                            
                        break;
                case 6:ioData.mostrarResultado(hospitalproceso.mostrarPisos()); break;
                      case 7: break;    
                 }
            }
            while (opc != 7);
              
        }
    
    
   public  void menuRepcionista()
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
             opcion = ioData.solicitarEntero(mensaje+"\n\nDigite una opción");
                switch(opcion)
               {
                 case 1:{
                     ingresarPaciente();
                     break;
                 }
                 case 2:{
                     if(!Proceso.hospitalproceso.getPacientes().isEmpty()){
                     otorgarSalida();}
                     break;
                 }
                 case 3:{
                     mostrarPacientes();
                     break;
                 }
                 case 4:{
                     buscarPaciente();
                     break;
                 }
                 case 5:{
                     break;
                 }
                 default:{
                     ioData.mostrarResultado("Opción incorrecta");
                     break;
                 }
            }
         }
         while(opcion!=5);
       }
   
   public void ingresarMedico(){
       
       Medico obj_Medico = new Medico();
       insertarPersona(obj_Medico);
       
       String especializacion = ioData.solicitarNombre("Escriba en qué se especializa el médico.");
       int carnet = ioData.solicitarEntero("Digite el carnet");
       while(verificaciones.returnCarnet(carnet)!= -1){
           carnet = ioData.solicitarEntero("El carnet está repetido. \nDigite el carnet");
       }
       obj_Medico.setCarnet(carnet);
       obj_Medico.setEspecializacion(especializacion);
       hospitalproceso.setMedico(obj_Medico);

        lista_personas.add(obj_Medico);
    }

    public void ingresarPaciente() {
        Persona persona_encargada = new Persona();
        Paciente obj_paciente = new Paciente();
        HistoriaClinica obj_historia = new HistoriaClinica();
        insertarPersona(obj_paciente);
        if (obj_paciente.getEdad() < 18 || obj_paciente.getEdad() >= 70) {
            asignarAdulto(persona_encargada, obj_paciente);
        }
        insertarHistoria(obj_paciente);
        int codigo_eps = (ioData.solicitarEntero(hospitalproceso.mostrarEps() + "\n0.Ninguna \n\nDigite el código de la EPS"));
        if (codigo_eps != 0) {
            obj_paciente.setEps(verificaciones.returnEps(codigo_eps));
            while (obj_paciente.getEps() == null) {
                if (codigo_eps != 0) {
                    codigo_eps = (ioData.solicitarEntero(hospitalproceso.mostrarEps() + "\n0.Ninguna \n\nDigite el código de la EPS"));
                }
                obj_paciente.setEps(verificaciones.returnEps(codigo_eps));
            }
            obj_paciente.setTipobeneficio(ioData.solicitarEntero("TIPO AFILIADO\n  1.Cotizante\n2.Beneficiario\n\nDigite el tipo de afiliado"));
            while (obj_paciente.getTipobeneficio() <= 0 || obj_paciente.getTipobeneficio() > 2) {
                obj_paciente.setTipobeneficio(ioData.solicitarEntero("TIPO AFILIADO\n  1.Cotizante\n2.Beneficiario\n\nOpción no encontrada\nDigite el tipo de afiliado"));
            }

        }
        asignarCama(obj_paciente);
        while(obj_paciente.getTipo_cuidado()==null)
        {
            ioData.mostrarResultado("ERROR!\n INGRESE NUEVAMENTE LOS DATOS");
              asignarCama(obj_paciente);
        }
        hospitalproceso.setPaciente(obj_paciente);
        lista_personas.add(obj_paciente);
    }

    public void asignarAdulto(Persona obj_persona, Paciente paciente) {
        obj_persona.setId(ioData.solicitarEntero("Digite la identificación de la persona"));
        while (verificaciones.validarIdentificacion(obj_persona.getId())) {
            obj_persona.setId(ioData.solicitarEntero("Identificación ya registrada\nDigite la identificación de la persona"));
        }
        obj_persona.setNombre(ioData.solicitarNombre("Digite el nombre de la persona"));
        while (verificaciones.validarNombre(obj_persona.getNombre())) {
            obj_persona.setNombre(ioData.solicitarNombre("Máximo 2 nombres\nDigite el nombre de la persona"));
        }
        obj_persona.setApellidos(ioData.solicitarNombre("Digite el apellido de la persona"));
        while (verificaciones.validarApellido(obj_persona.getApellidos()) || !verificaciones.validarParentesco(paciente.getApellidos(), obj_persona.getApellidos())) {
            if (verificaciones.validarApellido(obj_persona.getApellidos())) {
                obj_persona.setApellidos(ioData.solicitarNombre("Debe digitar 2 Apellidos\nDigite el apellido de la persona"));
            } else {
                obj_persona.setApellidos(ioData.solicitarNombre("Deben ser familiares \nDigite el apellido de la persona"));
            }

        }
        obj_persona.setEdad(ioData.solicitarEntero("Digite la edad de la persona"));
        while (obj_persona.getEdad() <= 0 || obj_persona.getEdad() >= 130 || obj_persona.getEdad() < 18 || obj_persona.getEdad() >= 70) {
            obj_persona.setEdad(ioData.solicitarEntero("Digite la edad de la persona"));
        }
        obj_persona.setTelefono(ioData.solicitarEntero("Digite el número telefónico"));
        while (obj_persona.getTelefono() <= 0) {
            obj_persona.setTelefono(ioData.solicitarEntero("Formato incorrecto\nDigite el número telefónico"));
        }
        obj_persona.setCorreo(ioData.solicitarNombre("Digite el correo electrónico"));
        paciente.setAcompañante(obj_persona);

    }

    public void insertarPersona(Persona obj_persona) {
        obj_persona.setId(ioData.solicitarEntero("Digite la identificación de la persona"));
        while (verificaciones.validarIdentificacion(obj_persona.getId())) {
            obj_persona.setId(ioData.solicitarEntero("Identificación ya registrada\nDigite la identificación de la persona"));
        }
        obj_persona.setNombre(ioData.solicitarNombre("Digite el nombre de la persona"));
        while (verificaciones.validarNombre(obj_persona.getNombre())) {
            obj_persona.setNombre(ioData.solicitarNombre("Máximo 2 nombres\nDigite el nombre de la persona"));
        }
        obj_persona.setApellidos(ioData.solicitarNombre("Digite el apellido de la persona"));
        while (verificaciones.validarApellido(obj_persona.getApellidos())) {
            obj_persona.setApellidos(ioData.solicitarNombre("Debe digitar 2 Apellidos\nDigite el apellido de la persona"));
        }
        obj_persona.setEdad(ioData.solicitarEntero("Digite la edad de la persona"));
        while (obj_persona.getEdad() <= 0 || obj_persona.getEdad() >= 130) {
            obj_persona.setEdad(ioData.solicitarEntero("Digite la edad de la persona"));
        }
        obj_persona.setTelefono(ioData.solicitarEntero("Digite el número telefónico"));
        while (obj_persona.getTelefono() <= 0) {
            obj_persona.setTelefono(ioData.solicitarEntero("Formato incorrecto\nDigite el número telefónico"));
        }
        obj_persona.setCorreo(ioData.solicitarNombre("Digite el correo electrónico"));
        while (verificaciones.validarCorreo(obj_persona.getCorreo())) {
            obj_persona.setCorreo(ioData.solicitarNombre("\nEl correo está repetido. \nDigite el correo del médico."));
        }
        lista_personas.add(obj_persona);
    }


    public void insertarHistoria(Paciente obj_persona) {
        HistoriaClinica obj_historia = new HistoriaClinica();

        obj_historia.setFechaHospitalizacion(ioData.solicitarNombre("Digite la fecha de hospitalización en formato dd-mm-yyyy"));
        while (!verificaciones.validarFecha(obj_historia.getFechaHospitalizacion())) {
            obj_historia.setFechaHospitalizacion(ioData.solicitarNombre("ERROR!\nDigite la fecha de hospitalización en formato dd-mm-yyyy"));
        }
        int carnet = ioData.solicitarEntero(hospitalproceso.mostrarMedicosE() + "\n\n Digite el carnet del médico");
        while (verificaciones.returnMedico(carnet) == null) {
            carnet = ioData.solicitarEntero("El médico ingresado no se encuentra\n" + hospitalproceso.mostrarMedicosE() + "\n\n Digite el carnet del médico");
        }

        obj_historia.setMedicoencargado(verificaciones.returnMedico(carnet));

        obj_historia.setDescripcion(ioData.solicitarNombre("Digite la causa por la que el paciente fue hospitalizado"));
        while (verificaciones.validarNombre(obj_historia.getDescripcion())) {
            obj_historia.setDescripcion(ioData.solicitarNombre("Digite la causa por la que el paciente fue hospitalizado"));
        }
        obj_persona.setHistoria(obj_historia);
    }

    public void asignarCama(Paciente obj_paciente) {
        int piso = ioData.solicitarEntero(hospitalproceso.mostrarPisos() + "\n\nDigite el número del piso");
        while (!verificaciones.validarNumeroPiso(piso)) {
            piso = ioData.solicitarEntero(hospitalproceso.mostrarPisos() + "\n\nDato no encontrado\nDigite el número del piso");
        }
        Pisos obj_piso = verificaciones.returnPiso(piso);
        int tipo = ioData.solicitarEntero("TIPO CUIDADO\n1. Intensivo \n2.Intermedio \n3.Recuperacion\n\nDigite a qué tipo de cuidado entrará el paciente ");
        while (tipo <= 0 || tipo > 3) {
            tipo = ioData.solicitarEntero("TIPO CUIDADO\n1. Intensivo \n2.Intermedio \n3.Recuperacion\n\nDigite a qué tipo de cuidado entrará el paciente ");
        }
         switch (tipo) {
             case 1:     
                 if(obj_piso.getIntensivos()!=null&&obj_piso.getIntensivos().getCantidadDecamas()-obj_piso.getIntensivos().getOcupacion()!=0){
                 obj_piso.getIntensivos().setOcupacion((obj_piso.getIntensivos().getOcupacion()+1));
                 obj_paciente.setTipo_cuidado(obj_piso.getIntensivos());}
                 break;
             case 2:
                
                if(obj_piso.getIntermedios()!=null&&obj_piso.getIntermedios().getCantidadDecamas()-obj_piso.getIntermedios().getOcupacion()!=0){
                  obj_paciente.setTipo_cuidado(obj_piso.getIntermedios());
                 obj_piso.getIntermedios().setOcupacion(obj_piso.getIntermedios().getOcupacion()+1);}
                 break;
             case 3:
                if(obj_piso.getRecuperacion()!=null&&obj_piso.getRecuperacion().getCantidadDecamas()-obj_piso.getRecuperacion().getOcupacion()!=0){
                 obj_paciente.setTipo_cuidado(obj_piso.getRecuperacion());
                 obj_piso.getRecuperacion().setOcupacion(obj_piso.getRecuperacion().getOcupacion()+1);}
                 break;
         }
    }

    public void otorgarSalida() {
        int id = ioData.solicitarEntero("Digite la identificación del paciente");
        
        if (verificaciones.validarPaciente(id)) {
            Paciente objpaciente = verificaciones.returnPaciente(id);
            int numpiso = verificaciones.returnNumeroPiso(objpaciente.getTipo_cuidado());
            Pisos obj_piso = verificaciones.returnPiso(numpiso);
            int tipo = verificaciones.returnTipoCuidado(objpaciente.getTipo_cuidado());
            switch (tipo) {
                case 1:
                    obj_piso.getIntensivos().setOcupacion((obj_piso.getIntensivos().getOcupacion() - 1));
                    break;
                case 2:

                    obj_piso.getIntermedios().setOcupacion(obj_piso.getIntermedios().getOcupacion() - 1);
                    break;
                case 3:
                    obj_piso.getRecuperacion().setOcupacion(obj_piso.getRecuperacion().getOcupacion() - 1);
                    break;
            }
            int cantidad_dias = ioData.solicitarEntero("Digite la cantidad de días que el paciente permaneció hospitalizado");
            while(cantidad_dias<=0)
            {
             cantidad_dias = ioData.solicitarEntero("Digite la cantidad de días que el paciente permaneció hospitalizado");   
            }
            double valor_dia = ioData.solicitarEntero("Digite el costo por día");
            while(valor_dia<=0)
            {
              valor_dia = ioData.solicitarEntero("Digite el costo por día");  
            }
            double total = valor_dia*cantidad_dias;
            double descuento =0;
           
                if(objpaciente.getTipobeneficio()==1){
                    descuento = total*0.70;
                    total-=descuento;
                    ioData.mostrarResultado("Descuento del 70% \ntotal $"+total);
                   
                }
                else if(objpaciente.getTipobeneficio()==2)
                {
                    descuento = total*0.50;
                    total-=descuento;
                    ioData.mostrarResultado("Descuento del 50% \ntotal $"+total);
                }
                else if (objpaciente.getTipobeneficio()==0){
                    ioData.mostrarResultado("Sin descuento \ntotal $"+total); 
                    
                }
            
             hospitalproceso.getPacientes().remove(verificaciones.returnPosPaciente(id));
            
        } else {
            ioData.mostrarResultado("Paciente no encontrado");
        }
    }

    public void mostrarPacientes() {
        ioData.mostrarResultado(hospitalproceso.mostrarPacientes());
    }

    public void buscarPaciente() {
        int id = ioData.solicitarEntero("Digite la identificación del paciente");
        if (verificaciones.validarPaciente(id)) {
            ioData.mostrarResultado(verificaciones.returnPaciente(id).toString());
        } else {
            ioData.mostrarResultado("Paciente no encontrado");
        }
    }

    public String mostrarEPS() {

        ArrayList<EPS> eps = hospitalproceso.getEps();
        String acumulador = " ";

        for (int i = 0; i < eps.size(); i++) {

            acumulador += ("EPS número " + (i + 1) + "\n" + eps.get(i).toString() + ". \n");

        }
        return acumulador;
    }


}




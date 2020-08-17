
package Modelo;

import java.util.ArrayList;

public class Hospital {
    private ArrayList <Medico> Medicos = new ArrayList<>();
    private ArrayList <Paciente> registro_paciente = new ArrayList<>();
    private ArrayList <Paciente> pacientes = new ArrayList<>();
    private ArrayList <Pisos> pisos = new ArrayList <>();
    private ArrayList <EPS> eps = new ArrayList <>();
    private String Nombre;

    public Hospital() {
    }

    public Hospital(ArrayList <Medico> Medicos,ArrayList <Paciente> pacientes,ArrayList <Pisos> pisos,ArrayList <EPS> eps ,String Nombre) {
        this.Medicos = Medicos;
        this.pacientes = pacientes;
        this.pisos = pisos;
        this.eps = eps;
        this.Nombre = Nombre;
    }

    public ArrayList<Medico> getMedicos() {
        return Medicos;
    }

    public void setMedicos(ArrayList<Medico> Medicos) {
        this.Medicos = Medicos;
    }
    public void setMedico(Medico datosMedico)
    {
        this.Medicos.add(datosMedico);
    }
    public ArrayList<Paciente> getPacientes() {
        return pacientes;
    }

    public void setPacientes(ArrayList<Paciente> pacientes) {
        this.pacientes = pacientes;
    }
    public void setPaciente(Paciente datospacientes) {
        this.pacientes.add(datospacientes);
    }


    public ArrayList<Pisos> getPisos() {
        return pisos;
    }

    public void setPisos(ArrayList<Pisos> pisos) {
        this.pisos = pisos;
    }

    public ArrayList<EPS> getEps() {
        return eps;
    }

    public void setEps(ArrayList<EPS> eps) {
        this.eps = eps;
    }
    public void setNombreEps(EPS nombreEps)
    {
        this.eps.add(nombreEps);
    }

    public ArrayList<Paciente> getRegistro_paciente() {
        return registro_paciente;
    }

    public void setRegistro_paciente(ArrayList<Paciente> registro_paciente) {
        this.registro_paciente = registro_paciente;
    }
    public void setRegistro(Paciente registrar)
    {
        this.registro_paciente.add(registrar);
    }
    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String Nombre) {
        this.Nombre = Nombre;
    }

    @Override
    public String toString() {
        String mensaje="Hospital "+Nombre+"\n";
        return mensaje;
    }
    public String mostrarMedicos()
    {
        String mensaje="";
        if(!Medicos.isEmpty())
        {
          for(Medico obj_medico: Medicos)
            {
           mensaje+= obj_medico.toString();
            }   
        }
        else
            mensaje+= " No hay médicos registrados";
        return mensaje;
    }
    public String mostrarPacientes()
    {
        String mensaje =   "";
        if(!pacientes.isEmpty())
        {
            for(Paciente pacientesd : pacientes)
            {
            mensaje += pacientesd.toString();
             }
        }
        else
        {
            mensaje+=" No hay pacientes registrados ";
        }
        return mensaje;
    }
    public String mostrarHistorial()
    {
        String mensaje = "";
        if(!registro_paciente.isEmpty())
        {
            for(Paciente paciente: registro_paciente)
            {
                mensaje+= paciente.toString();
            }
        }
        return mensaje;
    }
   
    
}

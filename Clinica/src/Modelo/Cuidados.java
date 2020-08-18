
package Modelo;


public class Cuidados {
    private int CantidadDecamas;
    private int ocupacion;
    public Cuidados() {
    }

    public Cuidados(int CantidadDecamas,int ocupacion) {
        this.CantidadDecamas = CantidadDecamas;
        this.ocupacion = ocupacion;
    }

    public int getCantidadDecamas() {
        return CantidadDecamas;
    }

    public void setCantidadDecamas(int CantidadDecamas) {
        this.CantidadDecamas = CantidadDecamas;
    }

    public int getOcupacion() {
        return ocupacion;
    }

    public void setOcupacion(int ocupacion) {
        this.ocupacion = ocupacion;
    }

    @Override
    public String toString() {
        return  "Cantidad De camas: " + CantidadDecamas +" Ocupación : "+ocupacion+" Disponibles: "+ (CantidadDecamas-ocupacion)+"\n";
    }
    
    
}


package Modelo;

/**
 *
 * @author nobody
 */
public class Cuidados {
    private int CantidadDecamas;

    public Cuidados() {
    }

    public Cuidados(int CantidadDecamas) {
        this.CantidadDecamas = CantidadDecamas;
    }

    public int getCantidadDecamas() {
        return CantidadDecamas;
    }

    public void setCantidadDecamas(int CantidadDecamas) {
        this.CantidadDecamas = CantidadDecamas;
    }

    @Override
    public String toString() {
        return  "Cantidad De camas: " + CantidadDecamas;
    }
    
    
}

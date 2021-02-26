import java.util.HashMap;
import java.util.Map;

public class Calle {
    private String nombre;
    private Interseccion origen;
    private Interseccion fin;
    private int tiempo;
    private boolean estadoSemaforo;
    private Map<Coche, Integer> coches;

    Calle(Interseccion origen, Interseccion dest, String nombre, int tiempo) {
        this.nombre = nombre;
        this.origen = origen;
        this.fin = dest;
        this.tiempo = tiempo;
        this.estadoSemaforo = false;
        this.coches = new HashMap<>();
    }

    public void pasarPor(Coche c) {
        this.coches.put(c, 0); // no guardamos el momento
    }

    public int numCochesPorCalle() {
        return coches.size();
    }

    /**
     * @return the fin
     */
    public Interseccion getFin() {
        return fin;
    }
    /**
     * @return the nombre
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * @return the origen
     */
    public Interseccion getOrigen() {
        return origen;
    }
    /**
     * @return the tiempo
     */
    public int getTiempo() {
        return tiempo;
    }
    /**
     * @return the tiempo
     */
    public boolean getEstadoSemaforo() {
        return estadoSemaforo;
    }
}

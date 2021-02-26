import java.util.HashSet;
import java.util.Set;

public class Interseccion {
    private int id;

    private Set<Calle> callesEntrada;
    private Set<Calle> callesSalida;

    public Interseccion(int id) {
        this.id = id;
        this.callesEntrada = new HashSet<>();
        this.callesSalida = new HashSet<>();
    }

    public void anadirCalleEntrada(Calle c) {
        this.callesEntrada.add(c);
    }

    public void anadirCalleSalida(Calle c) {
        this.callesSalida.add(c);
    }
    
    public Set<Calle> getCallesEntrada() {
        return callesEntrada;
    }
    
    /**
     * @return the id
     */
    public int getId() {
        return id;
    }

    public void avanzarTick() {

    }
}

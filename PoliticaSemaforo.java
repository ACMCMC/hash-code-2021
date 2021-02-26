import java.util.List;
import java.util.stream.Collectors;

public class PoliticaSemaforo {
    private Interseccion i;
    private List<Temporizacion> listas;

    public PoliticaSemaforo(Interseccion i, List<Temporizacion> listas) {
        this.i = i;
        this.listas = listas;
    }
    
    /**
     * @return the i
     */
    public Interseccion getI() {
        return i;
    }

    /**
     * @return the listas
     */
    public List<Temporizacion> getListas() {
        return listas;
    }

    public int getNumSemaforos() {
        return (int) this.getListaFiltrada().size();
    }

    public List<Temporizacion> getListaFiltrada() {
        return listas.stream().filter(t -> t.getTiempo() > 0).collect(Collectors.toList());
    }
}

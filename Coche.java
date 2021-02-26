import java.util.List;

public class Coche {
    int id;
    private List<Calle> calles;

    Coche(int id, List<Calle> calles) {
        this.id = id;
        this.calles = calles;
        
        calles.forEach(c -> c.pasarPor(this));
        /* Equiv to:
        for (Calle c : calles) {
            c.pasarPor(this);
        }
        */
    }
}

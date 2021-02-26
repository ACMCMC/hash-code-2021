public class Temporizacion {
    private int tiempo;
    private Calle calle;
    Temporizacion(int t, Calle calle) {
        this.tiempo = t;
        this.calle = calle;
    }

    public int getTiempo() {
        return tiempo;
    }

    public Calle getCalle() {
        return calle;
    }
}

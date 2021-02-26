import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class PoliticaSemaforoBuilder {
    public static PoliticaSemaforo buildFromInterseccion(Interseccion i, int tiempoTotal) {
        PriorityQueue<Calle> colaP = new PriorityQueue<>(new Comparator<Calle>(){

            @Override
            public int compare(Calle o1, Calle o2) {
                if (o1.numCochesPorCalle() > o2.numCochesPorCalle()) {
                    return 1;
                } else if (o1.numCochesPorCalle() < o2.numCochesPorCalle()) {
                    return -1;
                }
                return 0;
            }
            
        });

        colaP.addAll(i.getCallesEntrada());

        int numTotalCochesInterseccion = i.getCallesEntrada().stream().reduce(0, (a, c) -> c.numCochesPorCalle()+a, Integer::sum);

        List<Temporizacion> tiempos = new ArrayList<>();

        if (numTotalCochesInterseccion==0) {
            tiempos.add(new Temporizacion(1, colaP.poll()));
        }

        int tiempoRestante = tiempoTotal;
        while (!colaP.isEmpty()) {
            Calle c = colaP.poll();
            // calcular tiempo
            //int tiempo = (int) Math.ceil(((double)tiempoRestante) / 8.0);
            double porcentaje = (((double) c.numCochesPorCalle()) / ((double) numTotalCochesInterseccion));
            int tiempo = (int) Math.ceil((double)((((double)numTotalCochesInterseccion)/31.0)*porcentaje));
            tiempoRestante = tiempoRestante - tiempo;
            tiempos.add(new Temporizacion(tiempo, c));
        }

        return new PoliticaSemaforo(i, tiempos);
    }
}

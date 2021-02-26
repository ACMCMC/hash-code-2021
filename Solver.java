import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.Set;
import java.util.stream.Collectors;

public class Solver {
    private int numSegundos;
    private int numIntersecciones;
    private int numCalles;
    private int numCoches;
    private int bonus;
    private Map<String, Calle> calles;
    private List<Coche> coches;
    List<PoliticaSemaforo> politicas;

    List<Interseccion> intersecciones;

    Solver(Scanner in) {
        this.numSegundos = in.nextInt();
        this.numIntersecciones = in.nextInt();
        this.numCalles = in.nextInt();
        this.numCoches = in.nextInt();
        this.bonus = in.nextInt();

        calles = new HashMap<>();
        intersecciones = new ArrayList<>();
        coches = new ArrayList<>();

        for (int i = 0; i < numIntersecciones; i++) {
            this.intersecciones.add(new Interseccion(i));
        }

        for (int i = 0; i < numCalles; i++) {
            int idInicio = in.nextInt();
            int idFin = in.nextInt();
            String nombre = in.next();
            int tiempo = in.nextInt();
            Calle calle = new Calle(intersecciones.get(idInicio), intersecciones.get(idFin), nombre, tiempo);
            calles.put(nombre, calle);
            intersecciones.get(idInicio).anadirCalleSalida(calle);
            intersecciones.get(idFin).anadirCalleEntrada(calle);
        }

        for (int numCocheAct = 0; numCocheAct < numCoches; numCocheAct++) {
            List<Calle> callesCocheAct = new ArrayList<>();
            int numCallesCocheAct = in.nextInt();
            for (int numCalleAct = 0; numCalleAct < numCallesCocheAct; numCalleAct++) {
                callesCocheAct.add(calles.get(in.next()));
            }
            Coche cocheAct = new Coche(numCocheAct, callesCocheAct);
            coches.add(cocheAct);
        }
    }

    private void avanzarTick() {
        intersecciones.forEach(Interseccion::avanzarTick);
    }

    private void calcularSolucion() {
        this.politicas = intersecciones.stream().map(i -> PoliticaSemaforoBuilder.buildFromInterseccion(i, numSegundos))
                .collect(Collectors.toList());
    }

    public void imprimirSolucion(File out) {
        if (politicas == null) {
            calcularSolucion();
        }
        try {
            BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(out));
            bufferedWriter.write(Integer.toString(politicas.size()));
            bufferedWriter.newLine();
            for (PoliticaSemaforo p : politicas) {
                bufferedWriter.write(Integer.toString(p.getI().getId()));
                bufferedWriter.newLine();
                bufferedWriter.write(Integer.toString(p.getNumSemaforos()));
                bufferedWriter.newLine();
                for (Temporizacion t : p.getListaFiltrada()) {
                    bufferedWriter.write(t.getCalle().getNombre());
                    bufferedWriter.write(" ");
                    bufferedWriter.write(Integer.toString(t.getTiempo()));
                    bufferedWriter.newLine();
                }
            }
            bufferedWriter.close();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

}

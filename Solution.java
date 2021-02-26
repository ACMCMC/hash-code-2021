import java.util.*;
import java.io.*;

public class Solution {
    public static void main(String[] args) {
        Scanner in;
        String letras[] = {"a","b","c", "d", "e", "f"};
        try {
            for (String letra : letras) {
                File arch_input = new File(letra + ".txt");
                in = new Scanner(new BufferedReader(new FileReader(arch_input)));
                Solver s = new Solver(in);
                s.imprimirSolucion(new File("sol_"+arch_input.getName()));
            }
        } catch (FileNotFoundException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
            return;
        }
    }
}
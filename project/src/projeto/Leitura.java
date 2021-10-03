package projeto;

import java.util.ArrayList;
import java.util.Scanner;

public class Leitura {
    public static ArrayList<Double> leitura() {
        ArrayList<Double> list = new ArrayList<>();
        Scanner keyb = new Scanner(CalculadoraEsp.class.getResourceAsStream("dadosbrutos.txt"));
        int i = 0;
        while (keyb.hasNextLine()) {
            list.add(i, Double.parseDouble(keyb.nextLine()));
            i++;
        }
        return list;
    }
}

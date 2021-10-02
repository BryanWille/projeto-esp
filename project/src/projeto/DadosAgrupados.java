package projeto;

import java.util.ArrayList;
import java.util.Scanner;

public class DadosAgrupados {
    public static ArrayList<Double> lista;

    public static Double distriContinua(ArrayList<Double> v){
        double amplitudeTotal, raizAmostra;
        amplitudeTotal = v.get(v.size()-1) - v.get(0);
        raizAmostra = Math.sqrt(v.size()-1);
        return amplitudeTotal/raizAmostra;
    }

}

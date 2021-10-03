package projeto;

import java.util.ArrayList;
import java.util.Scanner;

public class DadosAgrupados {
    public static ArrayList<Double> lista;

    public static Double distriContinua(ArrayList<Double> v) {
        double amplitudeTotal, raizAmostra, aRound;
        amplitudeTotal = v.get(v.size() - 1) - v.get(0);
        raizAmostra = Math.sqrt(v.size());
        aRound = Math.round((amplitudeTotal / raizAmostra) * 100.0) / 100.0;
        return aRound;
    }

    public static void tabela(ArrayList<Double> v, Double distriContinua) {
        int i = 0, frequencia;
        double limiteSuperior = v.get(0), limiteInferior;
        System.out.println(v);
        while (limiteSuperior < v.get(v.size() - 1)) {
            limiteInferior = limiteSuperior;
            limiteSuperior += distriContinua;
            frequencia = 0;
            while (v.get(i) < limiteSuperior) {
                frequencia++;
                if(i+1 < v.size()-1) {
                    i++;
                } else {
                    break;
                }
            }
            System.out.println(limiteInferior + "|--" + limiteSuperior + "|" + frequencia);
        }

    }

}

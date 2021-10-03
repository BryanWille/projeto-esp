package projeto;

import java.util.ArrayList;
import java.util.Scanner;

public class    DadosAgrupados {
    public static ArrayList<Double> lista;

    public static Double distriContinua(ArrayList<Double> v){
        double amplitudeTotal, raizAmostra, aRound;
        amplitudeTotal = v.get(v.size()-1) - v.get(0);
        raizAmostra = Math.sqrt(v.size()-1);
        aRound = Math.round( (amplitudeTotal/raizAmostra) * 100.0 ) / 100.0;
        return aRound;
    }

    public static void tabela (ArrayList<Double> v, Double distriContinua){
        int cont = 0,frequencia = 0;
        double limiteSuperior = v.get(0), limiteInferior = 0, limiteSuperiorRound, limiteInferiorRound;
        System.out.println(distriContinua);
        while(limiteSuperior < v.get(v.size() - 1)){
            limiteInferior = limiteSuperior;
            limiteSuperior += distriContinua;
            frequencia = 0;
            while(v.get(cont) < limiteSuperior && (cont + 1) < v.size() - 1) {
                frequencia += 1;
                cont += 1;
                if((cont + 1) == v.size() - 1){
                    cont += 1;
                    frequencia += 2;
                    break;
                }
            }
            limiteSuperiorRound = Math.round( limiteSuperior * 100.0) / 100.0;
            limiteInferiorRound = Math.round( limiteInferior * 100.0 ) / 100.0;
            System.out.println(limiteInferiorRound + "|--" + limiteSuperiorRound + "|" + frequencia);
        }

    }

}

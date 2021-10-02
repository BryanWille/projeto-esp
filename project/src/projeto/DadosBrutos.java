package projeto;
import java.util.*;

public class DadosBrutos {

    public static Double media(ArrayList<Double> v) {
        double media, somaTotal = 0.0;
        for (int i = 0; i < v.size(); i++) {
            somaTotal += v.get(i);
        }
        media = somaTotal / v.size();
        return media;
    }

    public static Double mediana(ArrayList<Double> v) {
        Double mediana;
        if (v.size() % 2 != 0) {
            mediana = v.get(v.size() / 2);
        } else {
            mediana = v.get((v.size() - 1) / 2) + ((v.get((v.size() - 1) / 2) + 1) / 2);
        }
        return mediana;
    }

    public static ArrayList<Double> moda(ArrayList<Double> v) {
        ArrayList<Double> list = new ArrayList<>();
        Double maiorScore = 0.0, score;
        for (int i = 0; i < v.size() - 1; i++) {                                        //Loop por até o penúltimo elemnto
            if (v.get(i).equals(v.get(i + 1))) {                                        //Checa se o elemento i é igual a i + 1
                score = 1.0;
                Double num = v.get(i);
                while (v.get(i).equals(v.get(i + 1)) && (i + 1) < v.size() - 1) {       //Loop enquanto for igual e menor que o último
                    i += 1;
                    score += 1;

                    if ((i + 1) == (v.size() - 1) && v.get(i).equals(v.get(i + 1))) {   //Se for o último elemento e for igual ao penultimo
                        score += 1;
                        break;                                                          //Quebra o Loop para não repetir
                    }
                }
                if (score >= maiorScore) {                                              //Checagem do Maior Score
                    if (!score.equals(maiorScore)) {                                    //Se o score for diferente (então vai ser maior)
                        list.clear();                                                   //Resetamos a lista (pra retirar o elemento)
                    }
                    list.add(num);                                                      //Adiciona o novo elemento (ou o outro elemento que é igual maior)
                    maiorScore = score;                                                 //Adiciona o maior Score
                }
            }
        }
        list.add(maiorScore);                                                           //O último elemento da lista é quantidade de vezes que repete a moda
        return list;
    }

    public static Double variancia(ArrayList<Double> v) {
        double variancia = 0, fator;
        for (int i = 0; i < v.size(); i++) {
            fator = v.get(i) - media(v);
            variancia += Math.pow(fator, 2);
            variancia = variancia / v.size();
        }
        return variancia;
    }

    public static Double desvioPadrao(double variancia) {
        return Math.sqrt(variancia);
    }

    public static Double coeficienteVariacao(double desvioPadrao, double media) {
        return (desvioPadrao / media) * 100;
    }
}
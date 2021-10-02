package projeto;

import java.lang.reflect.Array;
import java.util.*;

public class MetodosCalcEsp {

    public static ArrayList<Double> list;

    public static ArrayList<Double> leitura(){
        list = new ArrayList<>();
        Scanner keyb = new Scanner(CalculadoraEsp.class.getResourceAsStream("dadosbrutos3.txt"));
        int i = 0;
        while(keyb.hasNextLine()){
            list.add(i, Double.parseDouble(keyb.nextLine()));
            i ++;
        }
        return list;
    }

    public static Double media(ArrayList<Double> v){
        Double media, somaTotal = 0.0;
        for(int i = 0; i < v.size(); i++){
            somaTotal += v.get(i);
        }
        media = somaTotal / v.size();
        return media;
    }

    public static Double mediana(ArrayList<Double> v){
        Double mediana;
        if(v.size() % 2 != 0){
            mediana = v.get(v.size()/2);
        } else {
            mediana = v.get((v.size() - 1)/2) + ((v.get((v.size() - 1)/2) + 1)/2);
        }
        return mediana;
    }

    public static ArrayList<Double> moda(ArrayList<Double> v){
        list = new ArrayList<>();
        Double maiorScore = 0.0, score;
        for(int i = 0; i < v.size()-1; i++){
            if(v.get(i).equals(v.get(i+1))){
                score = 1.0;
                Double num = v.get(i);
                while(v.get(i).equals(v.get(i + 1)) && (i + 1) < v.size() - 1){
                    i += 1;
                    score += 1;

                    if((i + 1) == (v.size() - 1) && v.get(i).equals(v.get(i + 1)) ){
                        score += 1;
                        break;
                    }
                }
                if(score >= maiorScore){ 
                    if(!score.equals(maiorScore)){
                        list.clear();
                    }
                    list.add(num);
                    maiorScore = score;
                }
            }
        }
        list.add(maiorScore);
        System.out.println(list);
        return list;
    }

    public static Double variancia(ArrayList<Double> v){
        double variancia = 0,fator ;
        for (int i = 0; i < v.size(); i++) {
            fator = v.get(i) - media(v);
            variancia += Math.pow(fator, 2);
            variancia = variancia / v.size();
        }
        return variancia;
    }

    public static Double desvioPadrao(double variancia){
        return Math.sqrt(variancia);
    }

    public static Double coeficienteVariacao(double desvioPadrao, double media){
        return (desvioPadrao/media) * 100;
    }
    //Vou criar outra classe pra não bagunçar, pra tabela, e os dados da tabela
    // ok, deu erro de array outofbounds na moda agora
}

package projeto;

import java.util.*;

public class CalculadoraEsp {

/*
* Programa Criado Por
* Bryan Wille
* Pedro Gabriel
* */

    public static void main(String[] args){
        ArrayList<Double> moda;
        Collections.sort(MetodosCalcEsp.leitura());
        System.out.println(MetodosCalcEsp.list);

        double media, mediana, variancia, desvioPadrao, coeficienteVariacao;
        media = MetodosCalcEsp.media(MetodosCalcEsp.leitura());
        mediana = MetodosCalcEsp.mediana(MetodosCalcEsp.leitura());
        moda = MetodosCalcEsp.moda(MetodosCalcEsp.leitura());
        variancia = MetodosCalcEsp.variancia(MetodosCalcEsp.leitura());
        desvioPadrao = MetodosCalcEsp.desvioPadrao(variancia);
        coeficienteVariacao = MetodosCalcEsp.coeficienteVariacao(desvioPadrao, media);

        System.out.println("Media: " + media);
        System.out.println("Mediana: " + mediana);
        System.out.println("Moda: " +moda);
        System.out.println("Variancia: " + variancia);
        System.out.println("Desvio Padrão: " +desvioPadrao);
        System.out.println("Coeficiente de Variação: " +coeficienteVariacao);

    }
}

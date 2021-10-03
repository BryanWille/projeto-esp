package projeto;

import java.util.*;

public class CalculadoraEsp {

/*
* Programa Criado Por
* Bryan Wille
* Pedro Gabriel
* */

    public static void main(String[] args){
        DadosAgrupados t = new DadosAgrupados();
        ArrayList<Double> moda;
        Collections.sort(Leitura.leitura());

        double media, mediana, variancia, desvioPadrao, coeficienteVariacao, tabela;
        media = DadosBrutos.media(Leitura.leitura());
        mediana = DadosBrutos.mediana(Leitura.leitura());
        moda = DadosBrutos.moda(Leitura.leitura());
        variancia = DadosBrutos.variancia(Leitura.leitura());
        desvioPadrao = DadosBrutos.desvioPadrao(variancia);
        coeficienteVariacao = DadosBrutos.coeficienteVariacao(desvioPadrao, media);
        t.tabela(Leitura.leitura(),DadosAgrupados.distriContinua(Leitura.leitura()));

        System.out.println("Media: " + media);
        System.out.println("Mediana: " + mediana);
        System.out.println("Moda: " +moda);
        System.out.println("Variancia: " + variancia);
        System.out.println("Desvio Padrão: " +desvioPadrao);
        System.out.println("Coeficiente de Variação: " +coeficienteVariacao);
        System.out.println();

    }
}

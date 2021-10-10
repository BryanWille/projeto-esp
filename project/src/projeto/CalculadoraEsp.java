/*
 *
 * Programa Criado Por
 * Bryan Wille
 * Pedro Gabriel
 *
 * */
package projeto;

import java.util.*;

//Dados brutos 7: https://docs.google.com/spreadsheets/d/1V1dZQeqVkHgVYMnJPkQeJC6_9kjSwSF8fNRz9giMglg/edit?usp=sharing

public class CalculadoraEsp {
    private DadosAgrupados ab;

    public static void main(String[] args) {
        DadosBrutos b = new DadosBrutos();
        DadosAgrupados a = new DadosAgrupados(3.6);

        System.out.println("// ----------------------------- CLASSE BRUTA ----------------------------- //");

        System.out.println("Media: " + b.getMedia());
        System.out.println("Mediana: " + b.getMediana());
        System.out.println("Moda: " + b.getModa());
        System.out.println("Variancia: " + b.getVariancia());
        System.out.println("Desvio Padrão: " + b.getDesvioPadrao());
        System.out.println("Coeficiente de Variação: " + b.getCoeficienteVariacao());

        System.out.println("// ----------------------------- CLASSE AGRUPADA ----------------------------- //");

        System.out.println("Amplitude de classe: " + a.getAmplitudeClasse());
        System.out.println("Tabela: \n" + a.getTabela());
        System.out.println("\nFrequência Agrupada: \n" +a.getFrequenciaAgrupada());
        System.out.println("Media Agrupada: " + a.getMedia());
        System.out.println("Mediana Agrupada: " + a.getMediana());
        System.out.println("Moda Agrupada: " + a.getModa());
        System.out.println("Variancia Agrupada: " + a.getVariancia());
        System.out.println("Desvio Padrão Agrupado: " + a.getDesvioPadrao());
        System.out.println("Coeficiente de Variação Agrupado: " + a.getCoeficienteVariacao());
        System.out.println("Quartis 2: " +a.getQuartis());

    }
}

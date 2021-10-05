/*
 *
 * Programa Criado Por
 * Bryan Wille
 * Pedro Gabriel
 *
 * */
package projeto;

import java.util.*;

public class CalculadoraEsp {

    public static void main(String[] args) {
        DadosBrutos b = new DadosBrutos();
        DadosAgrupados a = new DadosAgrupados();

        System.out.println("Media: " + b.getMedia());
        System.out.println("Mediana: " + b.getMediana());
        System.out.println("Moda: " + b.getModa());
        System.out.println("Variancia: " + b.getVariancia());
        System.out.println("Desvio Padrão: " + b.getDesvioPadrao());
        System.out.println("Coeficiente de Variação: " + b.getCoeficienteVariacao());
        System.out.println("--------------------------");
        System.out.println("CLASSE AGRUPADA");
        System.out.println("Amplitude de classe: " + a.getAmplitudeClasse());
        System.out.println("Tabela: \n" + a.getTabela());
        System.out.println("Media Agrupada: " + a.getMedia());
        System.out.println("Mediana Agrupada: " + a.getMediana());
    }
}

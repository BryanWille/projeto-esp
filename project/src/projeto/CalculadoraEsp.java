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
    private static ParteGrafica pg;

    public static void main(String[] args) {
        DadosBrutos b = new DadosBrutos();
        DadosAgrupados a = new DadosAgrupados();


        pg = new ParteGrafica();
        pg.criarTabela();
        System.out.println("// ----------------------------- CLASSE BRUTA ----------------------------- //");

        System.out.println("Media: " + b.getMedia());
        System.out.println("Mediana: " + b.getMediana());
        System.out.println("Moda: " + b.getModa());
        System.out.println("Variancia: " + b.getVariancia());
        System.out.println("Desvio Padrao: " + b.getDesvioPadrao());
        System.out.println("Coeficiente de Variacao: " + b.getCoeficienteVariacao());

        System.out.println("// ----------------------------- CLASSE AGRUPADA ----------------------------- //");

        System.out.println("Amplitude de classe: " + a.getAmplitudeClasse());
        System.out.println("Tabela: \n" + a.getTabela());
        System.out.println("\nFrequencia Agrupada: \n" +a.getTabela().get(3)); //Fica bugado pq nao da pra pegar so o item 3 de todas as tabelas
        System.out.println("Media Agrupada: " + a.getMedia());
        System.out.println("Mediana Agrupada: " + a.getMediana());
        System.out.println("Moda Agrupada: " + a.getModa());
        System.out.println("Variancia Agrupada: " + a.getVariancia());
        System.out.println("Desvio Padrao Agrupado: " + a.getDesvioPadrao());
        System.out.println("Coeficiente de Variacao Agrupado: " + a.getCoeficienteVariacao());
        System.out.println("Separatriz: " +a.getSeparatriz());

    }
}

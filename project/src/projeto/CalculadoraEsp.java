package projeto;

import java.util.*;

public class CalculadoraEsp {

    /*
     * Programa Criado Por
     * Bryan Wille
     * Pedro Gabriel
     * */

    public static void main(String[] args) {
        DadosBrutos b = new DadosBrutos();

        System.out.println("Media: " + b.getMedia());
        System.out.println("Mediana: " + b.getMediana());
        System.out.println("Moda: " + b.getModa());
        System.out.println("Variancia: " + b.getVariancia());
        System.out.println("Desvio Padrão: " + b.getDesvioPadrao());
        System.out.println("Coeficiente de Variação: " + b.getCoeficienteVariacao());
        System.out.println();

    }
}

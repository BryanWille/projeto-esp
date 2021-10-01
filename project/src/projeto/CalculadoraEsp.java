package projeto;

import java.util.*;

public class CalculadoraEsp {
    public static ArrayList<float> list;
/*
* Programa Criado Por
* Bryan Wille
* Pedro Gabriel
* */

    public static void main(String[] args){
        MetodosCalcEsp t = new MetodosCalcEsp();
        Collections.sort(t.leitura());
        System.out.println(t.leitura());
        System.out.println("Desordenado:" +t.leitura());
        System.out.println("Ordenado: \n");
        System.out.println("Media: " + t.media(t.leitura()));
        System.out.println("Mediana: " + t.mediana(t.leitura()));
        System.out.println("Moda: " + t.moda((t.leitura())));
    }


}

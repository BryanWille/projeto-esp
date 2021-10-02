package projeto;

import java.util.*;

public class CalculadoraEsp {

/*
* Programa Criado Por
* Bryan Wille
* Pedro Gabriel
* */

    public static void main(String[] args){
        MetodosCalcEsp t = new MetodosCalcEsp();
        Collections.sort(t.leitura());
        System.out.println(t.list);
        //System.out.println("Media: " + t.media(t.leitura()));
        //System.out.println("Mediana: " + t.mediana(t.leitura()));
        System.out.println("Moda Antiga: " +t.moda(t.leitura()));
        //System.out.println("Variancia: " + t.variancia(t.leitura()));
    }


}

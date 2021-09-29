package projeto;

import java.util.Scanner;
import java.util.ArrayList;

public class CalculadoraEsp {
    public static ArrayList<Integer> list;
/*
* Programa Criado Por
* Bryan Wille
* Pedro Gabriel
* */

    public static void main(String[] args){
        System.out.println(leitura());
        System.out.println("Desordenado:" +exibirVetor(leitura()));
        System.out.println("Ordenado: \n" +exibirVetor(colocarRol(leitura())));
        System.out.println("Media: " + media(leitura()));
        System.out.println("Mediana: " + mediana(colocarRol(leitura())));
        System.out.println("Moda: " +moda(colocarRol(leitura())));
    }

    public static Integer[] leitura(){
        list = new ArrayList<Integer>();
        Scanner keyb = new Scanner(CalculadoraEsp.class.getResourceAsStream("dadosbrutos3.txt"));
        int i = 0;
        while(keyb.hasNextLine()){
            list.add(i, Integer.parseInt(keyb.nextLine()));
            i ++;
        }
        Integer[] vetor = new Integer[list.size()];
        vetor = list.toArray(vetor);

        return vetor;
    }


    public static Integer[] colocarRol(Integer[] v) {
        int chave, j;
        for(int i = 1; i < v.length; i++) {
            chave = v[i];
            j = i - 1;
            while(j >= 0 && v[j] > chave) {
                v[j+1] = v[j];
                j -= 1;
            }
            v[j+1] = chave;
        }
        return v;
    }

    public static String exibirVetor(Integer[] vetor){
        String exibir = "";
        for(int i = 0; i < vetor.length; i++ ){
            exibir += "[" +i +"]" + vetor[i] +"\n";
        }
        return exibir;
    }

    public static float media(Integer[] vetor){
        float media, somaTotal = 0;
        for(int i = 0; i < vetor.length; i++){
            somaTotal += vetor[i];
        }
        media = somaTotal / vetor.length;
        return media;
    }

    public static float mediana(Integer[] vetor){
        float mediana;
        if(vetor.length % 2 != 0){
            mediana = vetor[(vetor.length) / 2];
        } else {
            mediana = (vetor[(vetor.length - 1)/2] + vetor[((vetor.length-1)/2) + 1])/2;
        }
        return mediana;
    }

    public static ArrayList<Integer> moda(Integer[] t){
            list = new ArrayList<Integer>();
            int j, maiorModa = 0;
            float maiorElemento = 0;
            String moda = "";
            for(int i = 0; i < t.length-1; i++){
                if(t[i].equals(t[i+1])){
                    j = i;
                    int maiorModaTemp = 0;

                    while(t[j].equals(t[j+1])){
                        j++;
                        maiorModaTemp ++;
                        if((j+1 == t.length-1) && t[j].equals(t[j+1])) {
                            maiorModaTemp++;
                            break;
                        }
                    }

                    if(maiorModaTemp >= maiorModa) {
                        if(maiorModaTemp != maiorModa && list != null){
                            list.clear();
                        }
                        list.add(t[i]);
                        maiorModa = maiorModaTemp;
                        maiorElemento = t[i];
                    }
                    i = j;
                }
            }
        System.out.println(maiorElemento);
            return list;
        }
}

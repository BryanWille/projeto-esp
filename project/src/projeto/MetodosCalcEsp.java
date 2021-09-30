package projeto;

import java.lang.reflect.Array;
import java.util.*;

public class MetodosCalcEsp {

    public static ArrayList<Integer> list;

    public static ArrayList<Integer> leitura(){
        list = new ArrayList<Integer>();
        Scanner keyb = new Scanner(CalculadoraEsp.class.getResourceAsStream("dadosbrutos3.txt"));
        int i = 0;
        while(keyb.hasNextLine()){
            list.add(i, Integer.parseInt(keyb.nextLine()));
            i ++;
        }
        return list;
    }

    public static float media(ArrayList<Integer> v){
        float media, somaTotal = 0;
        for(int i = 0; i < v.size(); i++){
            somaTotal += v.get(i);
        }
        media = somaTotal / v.size();
        return media;
    }

    public static float mediana(ArrayList<Integer> v){
        float mediana;
        if(v.size() % 2 != 0){
            mediana = v.get(v.size()/2);
        } else {
            mediana = v.get(v.size() - 1/2) + ((v.get(v.size() - 1/2) + 1)/2);
        }
        return mediana;
    }

    public static ArrayList<Integer> moda(ArrayList<Integer> v){
        list = new ArrayList<Integer>();
        int j, maiorModa = 0;
        float maiorElemento = 0;
        String moda = "";
        for(int i = 0; i < v.size()-1; i++){
            if(v.get(i).equals(v.get(i + 1))){
                j = i;
                int maiorModaTemp = 0;

                while(v.get(j).equals(v.get(j+1))){
                    j++;
                    maiorModaTemp ++;
                    if((j+1 == v.size()-1) && v.get(j).equals(v.get(j + 1))) {
                        maiorModaTemp++;
                        break;
                    }
                }

                if(maiorModaTemp >= maiorModa) {
                    if(maiorModaTemp != maiorModa && list != null){
                        list.clear();
                    }
                    list.add(v.get(i));
                    maiorModa = maiorModaTemp;
                    maiorElemento = v.get(i);
                }
                list.add(maiorModa + 1); // qt de vezes que repete
                i = j;
            }
        }
        return list;
    }
}

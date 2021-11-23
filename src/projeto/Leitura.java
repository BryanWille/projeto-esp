package projeto;

import java.util.ArrayList;
import java.util.Scanner;

public class Leitura {

    // ----------------------------- ATRIBUTOS ----------------------------- //

    private static ArrayList<Double> lista;
    public static Scanner keyb;

    // ----------------------------- CONSTRUTOR ----------------------------- //

    public Leitura() {
        this.criarLista();
    }

    public Leitura(ArrayList<Double> lista){
        this.lista = lista;
        this.criarLista();
    }

    // ----------------------------- METODOS DE LEITURA
    // ----------------------------- //

    public void criarLista() {
        ArrayList<Double> v = new ArrayList<>();
        if(!lista.isEmpty()){
            v = this.lista;
        }
        int i = 0;
        if(keyb != null){
            while (keyb.hasNextLine()) {
                v.add(i, Double.parseDouble(keyb.nextLine()));
                i++;
            }
        }
        double aux;
        for (i = 0; i < v.size() - 1; i++) {
            for (int j = 0; j < v.size() - 1 - i; j++) {
                if (v.get(j) > v.get(j + 1)) {
                    aux = v.get(j);
                    v.set(j, v.get(j + 1));
                    v.set(j + 1, aux);
                }
            }
        }
        this.lista = (v);
    }

    // ----------------------------- METODOS GETTERS -----------------------------
    // //

    public static ArrayList<Double> getLista() {
        return lista;
    }
}

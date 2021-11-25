package projeto;

import java.util.ArrayList;
import java.util.Scanner;

public class Leitura {

    // ----------------------------- ATRIBUTOS ----------------------------- //

    private static ArrayList<Double> lista;

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

    public static void criarLista() {
        ArrayList<Double> v = new ArrayList<>();
        if(!lista.isEmpty()){
            v = lista;
        }
        int i = 0;
        double aux;
        for (i = 0; i < v.size(); i++) {
            for (int j = 0; j < v.size() - 1; j++) {
                if (v.get(j) > v.get(j + 1)) {
                    aux = v.get(j);
                    v.set(j, v.get(j + 1));
                    v.set(j + 1, aux);
                }
            }
        }
        lista = (v);
    }

    // ----------------------------- METODOS GETTERS -----------------------------
    // //

    public static ArrayList<Double> getLista() {
        return lista;
    }
}

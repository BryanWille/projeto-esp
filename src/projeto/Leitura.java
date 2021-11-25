package projeto;

import java.util.ArrayList;
import java.util.Collections;

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
        Collections.sort(lista);
    }

    // ----------------------------- METODOS GETTERS -----------------------------
    // //

    public static ArrayList<Double> getLista() {
        return lista;
    }
}

package projeto;

import java.util.ArrayList;
import java.util.Scanner;

public class Leitura {
    private ArrayList<Double> lista;

    public Leitura(){
        this.criarLista();
    }
    public void criarLista(){
        ArrayList<Double> v = new ArrayList<>();
        Scanner keyb = new Scanner(CalculadoraEsp.class.getResourceAsStream("dadosbrutos3.txt"));
        int i = 0;
        while (keyb.hasNextLine()) {
            v.add(i, Double.parseDouble(keyb.nextLine()));
            i++;
        }
        double aux;
        for(i = 0; i < v.size() - 1; i++) {
            for(int j = 0; j < v.size() - 1 - i; j++) {
                if(v.get(j) > v.get(j+1)) {
                    aux = v.get(j);
                    v.set(j,v.get(j+1));
                    v.set(j + 1,aux);
                }
            }
        }
        this.setLista(v);
        keyb.close();
    }
    public ArrayList<Double> getLista() {
        return this.lista;
    }
    public void setLista(ArrayList<Double> v) {
        this.lista = v;
    }
}

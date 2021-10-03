package projeto;

import java.util.ArrayList;
import java.util.Scanner;

public class DadosAgrupados extends Leitura{
    public Double amplitudeClasse;

    public DadosAgrupados(){
        this.criarLista();
        this.fazerAmplitudeClasse(getLista());
        this.tabela(getLista(), this.getAmplitudeClasse());
    }

    public void fazerAmplitudeClasse(ArrayList<Double> v) {
        double amplitudeTotal, raizAmostra, a;
        amplitudeTotal = v.get(v.size() - 1) - v.get(0);
        raizAmostra = Math.sqrt(v.size());
        a = Math.round((amplitudeTotal / raizAmostra) * 100.0) / 100.0;
        this.setAmplitudeClasse(a);
    }

    public void tabela(ArrayList<Double> v, Double distriContinua) {
        int i = 0, frequencia;
        double limiteSuperior = v.get(0), limiteInferior;
        System.out.println(v);
        while (limiteSuperior < v.get(v.size() - 1)) {
            limiteInferior = limiteSuperior;
            limiteSuperior += distriContinua;
            frequencia = 0;
            while (v.get(i) < limiteSuperior) {
                frequencia++;
                if(i+1 < v.size()-1) {
                    i++;
                } else {
                    break;
                }
            }
            System.out.println(limiteInferior + "|--" + limiteSuperior + "|" + frequencia);
        }

    }

    public Double getAmplitudeClasse() {
        return amplitudeClasse;
    }

    public void setAmplitudeClasse(Double amplitudeClasse) {
        this.amplitudeClasse = amplitudeClasse;
    }
}

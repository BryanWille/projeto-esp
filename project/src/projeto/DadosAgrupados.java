package projeto;

import java.util.ArrayList;
import java.util.Scanner;

public class DadosAgrupados extends Leitura{
    private Double amplitudeClasse;
    private Double pontoMedio;
    private Double media;
    private ArrayList<Double> pontoMedioClasse;
    private ArrayList<ArrayList<Double>> tabela;


    public DadosAgrupados(){
        this.criarLista();
        this.fazerAmplitudeClasse(getLista());
        this.fazerTabela(getLista(), this.getAmplitudeClasse());
        this.fazerPontoMedioClasse(this.getTabela());
        this.fazerMedia(this.getTabela(), this.getPontoMedioClasse());
        this.setPontoMedio(this.getAmplitudeClasse());
    }

    public void fazerAmplitudeClasse(ArrayList<Double> v) {
        double amplitudeTotal, raizAmostra, a;
        amplitudeTotal = v.get(v.size() - 1) - v.get(0);
        raizAmostra = Math.sqrt(v.size());
        a = Math.round((amplitudeTotal / raizAmostra) * 100.0) / 100.0;
        this.setAmplitudeClasse(a);
    }

    public void fazerMedia(ArrayList<ArrayList<Double>> v, ArrayList<Double> a){
        Double somaFrequencia = 0.0, somatorio = 0.0;
        for (int i = 0; i < v.size(); i++){
            somaFrequencia += v.get(i).get(2);
            somatorio +=  a.get(i) * v.get(i).get(2);
        }
        System.out.println("Soma frequência " +somaFrequencia);
        Double media = somatorio/somaFrequencia;
        this.setMedia(media);
    }

    public void fazerPontoMedioClasse(ArrayList<ArrayList<Double>> v){
        ArrayList<Double> pontoMedioClasse = new ArrayList<>();
        Double media;

        for(int i = 0; i < v.size(); i++){
            media = (v.get(i).get(0) + v.get(i).get(1))/2;
            pontoMedioClasse.add(media);
        }
        this.setPontoMedioClasse(pontoMedioClasse);
    }

    public void fazerTabela(ArrayList<Double> v, Double distriContinua) {
        ArrayList<ArrayList<Double>> tabela = new ArrayList<>();
        int i = 0, frequencia, j = 0;
        double limiteSuperior = v.get(0), limiteInferior;
        System.out.println(v);
        while (limiteSuperior < v.get(v.size() - 1)) {
            tabela.add(new ArrayList());
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
            tabela.get(j).add(limiteInferior);
            tabela.get(j).add(limiteSuperior);
            tabela.get(j).add((double) frequencia);
            j++;
        }
        this.setTabela(tabela);
    }

    public Double getAmplitudeClasse() {
        return amplitudeClasse;
    }
    public void setAmplitudeClasse(Double amplitudeClasse) {
        this.amplitudeClasse = amplitudeClasse;
    }

    public ArrayList<Double> getPontoMedioClasse() {
        return pontoMedioClasse;
    }
    public void setPontoMedioClasse(ArrayList<Double> pontoMedioClasse) {
        this.pontoMedioClasse = pontoMedioClasse;
    }

    public Double getPontoMedio(){
        return this.pontoMedio;
    }
    public void setPontoMedio(Double amplitudeClasse ){
        this.pontoMedio = amplitudeClasse/2;
    }

    public ArrayList<ArrayList<Double>> getTabela() {
        return tabela;
    }
    public void setTabela(ArrayList<ArrayList<Double>> tabela) {
        this.tabela = tabela;
    }

    public Double getMedia() {
        return media;
    }
    public void setMedia(Double media) {
        this.media = media;
    }
}

package projeto;

import java.util.ArrayList;
import java.util.Scanner;

public class DadosAgrupados extends Leitura{
    private Double amplitudeClasse;
    private Double media;
    private Double mediana;
    private Double moda;
    private Double variancia;
    private Double desvioPadrao;
    private Double coeficienteVariacao;
    private ArrayList<Double> pontoMedioClasse;
    private ArrayList<ArrayList<Double>> tabela;

    public DadosAgrupados(Double escolherAmplitude){
        this.criarLista();
        this.setAmplitudeClasse(escolherAmplitude);
        //this.fazerAmplitudeClasse(getLista());
        this.fazerTabela(getLista(), this.getAmplitudeClasse());
        this.fazerPontoMedioClasse(this.getTabela());
        this.fazerMedia(this.getTabela(), this.getPontoMedioClasse());
        this.fazerMediana(this.getTabela());
        this.fazerModa(this.getTabela());
        this.fazerVariancia(this.getPontoMedioClasse(), this.getMedia());
        this.fazerDesvioPadrao(this.getVariancia());
        this.fazerCoeficienteVariacao(this.getDesvioPadrao(),this.getMedia());
    }

    private void fazerAmplitudeClasse(ArrayList<Double> v) {
        double amplitudeTotal, raizAmostra, a;
        amplitudeTotal = v.get(v.size() - 1) - v.get(0);
        raizAmostra = Math.sqrt(v.size());
        a = Math.round((amplitudeTotal / raizAmostra) * 100.0) / 100.0;
        this.setAmplitudeClasse(a);
    }

    private void fazerMedia(ArrayList<ArrayList<Double>> v, ArrayList<Double> a){
        Double somaFrequencia = 0.0, somatorio = 0.0;
        for (int i = 0; i < v.size(); i++){
            somaFrequencia += v.get(i).get(2);
            somatorio +=  a.get(i) * v.get(i).get(2);
        }
        Double media = somatorio/somaFrequencia;
        this.setMedia(media);
    }

    private void fazerMediana(ArrayList<ArrayList<Double>> v) {
        Double mediana = 0.0, frequenciaClasseAnterior = 0.0;
        int classeMediana = (int) Math.floor(v.size() / 2) - 1;
        for (int i = 0; i < classeMediana; i ++){
            frequenciaClasseAnterior += v.get(i).get(2);
        }
        mediana = v.get(classeMediana).get(0) + ((getLista().size()/2 - frequenciaClasseAnterior)/v.get(classeMediana).get(2)) * this.getAmplitudeClasse();
        this.setMediana(mediana);
    }

    private void fazerModa (ArrayList<ArrayList<Double>> v){
        Double moda = 0.0, freqMaior = 0.0, limInfModa = 0.0, difFreq1 = 0.0, difFreq2 = 0.0;

        for(int i = 0; i < v.size(); i++){
            if(v.get(i).get(2) > freqMaior) {
                freqMaior = v.get(i).get(2);
                limInfModa = v.get(i).get(0);
                if (i+1 < v.size()-1 && i-1 > 0) {
                    difFreq1 = v.get(i - 1).get(2);
                    difFreq2 = v.get(i + 1).get(2);
                } else if (i+1 > v.size()-1){
                    difFreq2 = 0.0;
                } else if (i - 1 < 0) {
                    difFreq1 = 0.0;
                }
            }
        }

        moda = limInfModa + (difFreq1 / (difFreq1 + difFreq2)) * this.getAmplitudeClasse();
        this.setModa(moda);
    }

    private void fazerVariancia(ArrayList<Double> pontoMedioClasse, Double media){
        Double somatorio = 0.0;
        for(int i = 0; i < pontoMedioClasse.size(); i++){
            somatorio += Math.pow((pontoMedioClasse.get(i) - media), 2);
        }
        Double variancia = somatorio / pontoMedioClasse.size() - 1;
        this.setVariancia(variancia);
    }

    private void fazerDesvioPadrao(Double variancia){
        this.setDesvioPadrao(Math.sqrt(variancia));
    }

    private void fazerCoeficienteVariacao (Double desvioPadrao, Double media){
        this.setCoeficienteVariacao((desvioPadrao / media) * 100);
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

    public double getMediana(){
        return mediana;
    }
    public void setMediana(Double newMediana){
        mediana = newMediana;
    }

    public double getModa(){
        return moda;
    }
    public void setModa(Double newModa){
        moda = newModa;
    }

    public double getVariancia(){
        return variancia;
    }
    public void setVariancia(Double newVariancia) {
        variancia = newVariancia;
    }

    public double getDesvioPadrao(){
        return desvioPadrao;
    }
    public void setDesvioPadrao(Double newDesvioPadrao){
        desvioPadrao = newDesvioPadrao;
    }

    public double getCoeficienteVariacao(){
        return coeficienteVariacao;
    }
    public void setCoeficienteVariacao(Double newCoeficienteVariacao){
        coeficienteVariacao = newCoeficienteVariacao;
    }
}

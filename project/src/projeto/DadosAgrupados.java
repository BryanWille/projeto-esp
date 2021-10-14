package projeto;

import java.util.ArrayList;
import java.util.Scanner;

public class DadosAgrupados extends Leitura {


    // ----------------------------- ATRIBUTOS ----------------------------- //


    private Double amplitudeClasse;
    private Double media;
    private Double mediana;
    private Double moda;
    private Double variancia;
    private Double desvioPadrao;
    private Double coeficienteVariacao;
    private Double separatriz;
    private Double frequenciaTotal;
    private ArrayList<Double> pontoMedioClasse;
    private ArrayList<Double> frequenciaAgrupada;
    private ArrayList<ArrayList<Double>> tabela;


    // ----------------------------- CONSTRUTOR ----------------------------- //


    public DadosAgrupados(double escolherAmplitude) {
        this.criarLista();
        this.setAmplitudeClasse(escolherAmplitude);
        //this.fazerAmplitudeClasse(getLista());
        this.fazerTabela(getLista(), this.getAmplitudeClasse());


        this.fazerFrequenciaAgrupada(this.getTabela());
        this.calcularPontoMedioClasse(this.getTabela());
        this.calcularFrequenciaTotal(this.getFrequenciaAgrupada());

        this.calcularMedia(this.getTabela(), this.getPontoMedioClasse());
        this.calcularMediana(this.getTabela());
        this.calcularModa(this.getTabela());

        this.calcularVariancia(this.getPontoMedioClasse(), this.getMedia());
        this.calcularDesvioPadrao(this.getVariancia());
        this.calcularCoeficienteVariacao(this.getDesvioPadrao(), this.getMedia());

        this.calcularSeparatriz(this.getTabela(), this.getFrequenciaAgrupada(), this.getFrequenciaTotal(), 100, 1);
    }


    // ----------------------------- MÉTODOS CALCULADORA ----------------------------- //


    private void fazerAmplitudeClasse(ArrayList<Double> lista) {
        double amplitudeTotal, raizAmostra, a;
        amplitudeTotal = lista.get(lista.size() - 1) - lista.get(0);
        raizAmostra = Math.sqrt(lista.size());
        a = Math.round((amplitudeTotal / raizAmostra) * 100.0) / 100.0;
        this.setAmplitudeClasse(a);
    }

    private void fazerTabela(ArrayList<Double> lista, Double distriContinua) {
        ArrayList<ArrayList<Double>> tabela = new ArrayList<>();
        int i = 0, frequencia, j = 0;
        double limiteSuperior = lista.get(0), limiteInferior;
        System.out.println(lista);
        while (limiteSuperior < lista.get(lista.size() - 1)) {
            tabela.add(new ArrayList());
            limiteInferior = limiteSuperior;
            limiteSuperior += distriContinua;
            frequencia = 0;
            while (lista.get(i) < limiteSuperior) {
                frequencia++;
                if (i + 1 < lista.size() - 1) {
                    i++;
                } else {
                    frequencia ++;
                    break;
                }
            }
            limiteInferior = (double) Math.round((limiteInferior * 1000.00)) / 1000;
            limiteSuperior = (double) Math.round((limiteSuperior * 1000.00)) / 1000;
            tabela.get(j).add(limiteInferior);
            tabela.get(j).add(limiteSuperior);
            tabela.get(j).add((double) frequencia);
            j++;
        }

        this.tabela = tabela;
    }

    private void fazerFrequenciaAgrupada(ArrayList<ArrayList<Double>> tabela) {
        ArrayList<Double> frequenciaAgrupada = new ArrayList<>();
        double somatorioFrequencia = tabela.get(0).get(2);
        frequenciaAgrupada.add(tabela.get(0).get(2));
        for (int i = 1; i < tabela.size(); i++) {
            somatorioFrequencia += tabela.get(i).get(2);
            frequenciaAgrupada.add(somatorioFrequencia);
        }
        this.frequenciaAgrupada = frequenciaAgrupada;
    }

    private void calcularMedia(ArrayList<ArrayList<Double>> tabela, ArrayList<Double> mediaClasse) {
        Double somaFrequencia = 0.0, somatorio = 0.0;
        for (int i = 0; i < tabela.size(); i++) {
            somaFrequencia += tabela.get(i).get(2);
            somatorio += mediaClasse.get(i) * tabela.get(i).get(2);
        }
        Double media = somatorio / somaFrequencia;
        this.media = (double) Math.round((media) * 100) / 100;
    }

    private void calcularMediana(ArrayList<ArrayList<Double>> tabela) {
        Double mediana = 0.0, frequenciaClasseAnterior = 0.0;
        int classeMediana = (int) Math.floor(tabela.size() / 2) - 1;
        for (int i = 0; i < classeMediana; i++) {
            frequenciaClasseAnterior += tabela.get(i).get(2);
        }
        mediana = tabela.get(classeMediana).get(0) + ((getLista().size() / 2 - frequenciaClasseAnterior) / tabela.get(classeMediana).get(2)) * this.getAmplitudeClasse();
        this.mediana = (double) Math.round((mediana) * 100) / 100;
    }

    private void calcularModa(ArrayList<ArrayList<Double>> tabela) {
        Double moda, freqMaior = 0.0, limInfModa = 0.0, difFreq1 = 0.0, difFreq2 = 0.0;

        for (int i = 0; i < tabela.size(); i++) {
            if (tabela.get(i).get(2) > freqMaior) {
                freqMaior = tabela.get(i).get(2);
                limInfModa = tabela.get(i).get(0);
                if (i + 1 < tabela.size() - 1 && i - 1 > 0) {
                    difFreq1 = tabela.get(i - 1).get(2);
                    difFreq2 = tabela.get(i + 1).get(2);
                }
            }
        }

        moda = limInfModa + (difFreq1 / (difFreq1 + difFreq2)) * this.getAmplitudeClasse();
        this.moda = (double) Math.round(moda * 100) / 100;
    }

    private void calcularVariancia(ArrayList<Double> pontoMedioClasse, Double media) {
        Double somatorio = 0.0;
        for (int i = 0; i < pontoMedioClasse.size(); i++) {
            somatorio += Math.pow((pontoMedioClasse.get(i) - media), 2);
        }
        Double variancia = somatorio / pontoMedioClasse.size() - 1;
        this.variancia = (double) Math.round((variancia) * 100) / 100;
    }

    private void calcularDesvioPadrao(Double variancia) {
        this.desvioPadrao = (double) Math.round((Math.sqrt(variancia) * 100)) / 100;
    }

    private void calcularCoeficienteVariacao(Double desvioPadrao, Double media) {
        double coefVar = 0.0;
        coefVar = (desvioPadrao / media) * 100;
        this.coeficienteVariacao = (double) Math.round(coefVar * 100) / 100;
    }

    private void calcularPontoMedioClasse(ArrayList<ArrayList<Double>> tabela) {
        ArrayList<Double> pontoMedioClasse = new ArrayList<>();
        Double media;

        for (int i = 0; i < tabela.size(); i++) {
            media = (tabela.get(i).get(0) + tabela.get(i).get(1)) / 2;
            pontoMedioClasse.add(media);
        }
        this.pontoMedioClasse = (pontoMedioClasse);
    }

    private void calcularSeparatriz(ArrayList<ArrayList<Double>> tabela, ArrayList<Double> frequenciaAgrupada,
                                 Double frequenciaTotal, int separatriz, int index ) {
        if(separatriz == 10 || separatriz == 100 || separatriz == 4 ) {
            double sep, amplitude, limiteInferior = 0, frequenciaAnterior = 0, frequenciaAtual = 0;
            Double acharClasse = (index * frequenciaTotal) / separatriz;
            amplitude = tabela.get(0).get(1) - tabela.get(0).get(0);
            for (int i = 0; i < frequenciaAgrupada.size(); i++) {
                if (i == 0) {
                    limiteInferior = tabela.get(i).get(0);
                    frequenciaAnterior = 0;
                    frequenciaAtual = tabela.get(i).get(2);
                } else {
                    if (acharClasse >= frequenciaAgrupada.get(i - 1) && acharClasse <= frequenciaAgrupada.get(i)) {
                        limiteInferior = tabela.get(i).get(0);
                        frequenciaAnterior = frequenciaAgrupada.get(i - 1);
                        frequenciaAtual = tabela.get(i).get(2);
                    }
                }
            }
            System.out.println("Dividendo = " +(acharClasse - frequenciaAnterior) +" / " +frequenciaAtual +" * " +amplitude);
            sep = limiteInferior + (acharClasse - frequenciaAnterior) / frequenciaAtual * amplitude;
            this.separatriz = (double) Math.round(sep * 100) / 100;
        } else {
            System.out.println("Erro: Separatriz Selecionada é Inválida!");
        }
    }


    private void calcularFrequenciaTotal(ArrayList<Double> frequenciaAgrupada) {
        this.frequenciaTotal = frequenciaAgrupada.get(frequenciaAgrupada.size() - 1);
    }

    // ----------------------------- MÉTODOS GETTERS ----------------------------- //


    public Double getAmplitudeClasse() {
        return amplitudeClasse;
    }

    public void setAmplitudeClasse(Double amplitudeClasse) {
        this.amplitudeClasse = amplitudeClasse;
    }

    public ArrayList<Double> getPontoMedioClasse() {
        return pontoMedioClasse;
    }

    public ArrayList<ArrayList<Double>> getTabela() {
        return tabela;
    }

    public Double getMedia() {
        return media;
    }

    public double getMediana() {
        return mediana;
    }

    public double getModa() {
        return moda;
    }

    public double getVariancia() {
        return variancia;
    }

    public double getDesvioPadrao() {
        return desvioPadrao;
    }

    public double getCoeficienteVariacao() {
        return coeficienteVariacao;
    }

    public double getSeparatriz() {
        return this.separatriz;
    }

    public ArrayList<Double> getFrequenciaAgrupada() {
        return this.frequenciaAgrupada;
    }

    public double getFrequenciaTotal() {
        return this.frequenciaTotal;
    }

}

package projeto;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Scanner;

public class DadosAgrupados extends Configuracoes {


    // ----------------------------- ATRIBUTOS ----------------------------- //

    private Leitura leitor = new Leitura();
    private Double amplitudeClasse;
    private Double media;
    private Double mediana;
    private Double moda;
    private Double variancia;
    private Double desvioPadrao;
    private Double coeficienteVariacao;
    private Double separatriz;
    private Double frequenciaTotal;
    private ArrayList<ArrayList<Double>> tabela;


    // ----------------------------- CONSTRUTOR ----------------------------- //



    public DadosAgrupados() {
        super();

        leitor.criarLista();
        this.fazerAmplitudeClasse(leitor.getLista());
        this.fazerTabela(leitor.getLista(), this.getAmplitudeClasse());


        this.calcularFrequenciaTotal(this.getTabela());

        this.calcularMedia(this.getTabela());
        this.calcularMediana(this.getTabela());
        this.calcularModa(this.getTabela());

        this.calcularVariancia(this.getTabela(), this.getMedia());
        this.calcularDesvioPadrao(this.getVariancia());
        this.calcularCoeficienteVariacao(this.getDesvioPadrao(), this.getMedia());

        this.calcularSeparatriz(this.getTabela(), this.getFrequenciaTotal(), 100, 90);
    }



    // ----------------------------- MÉTODOS CÁLCULOS ----------------------------- //

    private void calcularMedia(ArrayList<ArrayList<Double>> tabela) {
        Double somaFrequencia = 0.0, somatorio = 0.0;
        for (int i = 0; i < tabela.size(); i++) {
            somaFrequencia += tabela.get(i).get(2);
            somatorio += tabela.get(i).get(4) * tabela.get(i).get(2);
        }
        Double media = somatorio / somaFrequencia;
        this.media = this.arredondar(media);
    }

    private void calcularMediana(ArrayList<ArrayList<Double>> tabela) {
        Double mediana = 0.0, frequenciaClasseAnterior = 0.0;
        int classeMediana = (int) Math.floor(tabela.size() / 2) - 1;
        for (int i = 0; i < classeMediana; i++) {
            frequenciaClasseAnterior += tabela.get(i).get(2);
        }
        mediana = tabela.get(classeMediana).get(0) + ((leitor.getLista().size() / 2 - frequenciaClasseAnterior) / tabela.get(classeMediana).get(2)) * this.getAmplitudeClasse();
        this.mediana = this.arredondar(mediana);
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
        this.moda = this.arredondar(moda);
    }

    private void calcularVariancia(ArrayList<ArrayList<Double>> tabela, Double media) {
        Double somatorio = 0.0;
        for (int i = 0; i < tabela.size(); i++) {
            somatorio += Math.pow((tabela.get(i).get(4) - media), 2) * getTabela().get(i).get(2);
        }
        Double variancia = somatorio / leitor.getLista().size();
        this.variancia = this.arredondar(variancia);
    }

    private void calcularDesvioPadrao(Double variancia) {
        this.desvioPadrao = this.arredondar(Math.sqrt(variancia));
    }

    private void calcularCoeficienteVariacao(Double desvioPadrao, Double media) {
        double coefVar = 0.0;
        coefVar = (desvioPadrao / media) * 100;
        this.coeficienteVariacao = this.arredondar(coefVar);
    }

    private void calcularSeparatriz(ArrayList<ArrayList<Double>> tabela, Double frequenciaTotal, int separatriz, int index ) {
        if(separatriz == 10 || separatriz == 100 || separatriz == 4 ) {
            double sep, amplitude, limiteInferior = 0, frequenciaAnterior = 0, frequenciaAtual = 0;
            Double acharClasse = (index * frequenciaTotal) / separatriz;
            amplitude = tabela.get(0).get(1) - tabela.get(0).get(0);
            for (int i = 0; i < tabela.size(); i++) {
                if (i == 0) {
                    limiteInferior = tabela.get(i).get(0);
                    frequenciaAnterior = 0;
                    frequenciaAtual = tabela.get(i).get(2);
                } else {
                    if (acharClasse >= tabela.get(i - 1).get(3) && acharClasse <= tabela.get(i).get(3)) {
                        limiteInferior = tabela.get(i).get(0);
                        frequenciaAnterior = tabela.get(i - 1).get(3);
                        frequenciaAtual = tabela.get(i).get(2);
                    }
                }
            }
            sep = limiteInferior + (acharClasse - frequenciaAnterior) / frequenciaAtual * amplitude;
            this.separatriz = this.arredondar(sep);
        } else {
            System.out.println("Erro: Separatriz Selecionada é Inválida!");
        }
    }

    private void calcularFrequenciaTotal(ArrayList<ArrayList<Double>> tabela) {
        this.frequenciaTotal = tabela.get(tabela.size()-1).get(3);
    }



    // ----------------------------- MÉTODOS TABELA ----------------------------- //

    public Object[][] converterLista(ArrayList<ArrayList<Double>> tabela){
        Object[][] matriz = new Object[tabela.size()][4];
        for(int i = 0; i < tabela.size(); i++){
            for(int j = 0; j < 1; j++){
                Object distribuição = arredondamentoClasse(tabela.get(i).get(j)) +" |-- "
                        + arredondamentoClasse(tabela.get(i).get(j+1));
                matriz[i][j] = distribuição;                                     //Distribuição De Frequência
                matriz[i][1] = tabela.get(i).get(2);                             //Frequência
            }
            matriz[i][2] = tabela.get(i).get(3);                                 //Frequência Agrupada
            matriz[i][3] = tabela.get(i).get(4);                                 //Ponto Médio
        }
        return matriz;
    }

    private void fazerAmplitudeClasse(ArrayList<Double> lista) {
        int maiorCasaDecimal = 0;
        for(int i = 0; i < lista.size(); i++){
            if(Math.round(lista.get(i)) != lista.get(i)) {
                String converter = String.valueOf(lista.get(i));
                int index = converter.indexOf('.');
                int casaDecimal = (converter.length()-1) - index;
                if (casaDecimal > maiorCasaDecimal) {
                    maiorCasaDecimal = casaDecimal;
                }
            }
        }
        this.setArredondamentoClasse(maiorCasaDecimal);
        double amplitudeTotal, raizAmostra, a;
        amplitudeTotal = lista.get(lista.size() - 1) - lista.get(0);
        raizAmostra = Math.sqrt(lista.size());
        a = this.arredondamentoClasse(amplitudeTotal / raizAmostra);
        this.setAmplitudeClasse(a);
    }

    private void fazerTabela(ArrayList<Double> lista, Double distriContinua) {
        ArrayList<ArrayList<Double>> tabela = new ArrayList<>();
        int i = 0, frequencia, j = 0;
        double limiteSuperior = lista.get(0), limiteInferior, frequenciaAgrupada = 0;;
        while (limiteSuperior < lista.get(lista.size() - 1)) {
            tabela.add(new ArrayList());
            limiteInferior = limiteSuperior;
            limiteSuperior += distriContinua;
            frequencia = 0;
            while (lista.get(i) < limiteSuperior) {
                frequencia++;
                if (i + 1 < lista.size()) {
                    i++;
                } else {
                    break;
                }
            }
            limiteInferior = this.arredondamentoClasse(limiteInferior);
            limiteSuperior = this.arredondamentoClasse(limiteSuperior);
            double pontoMedio = this.arredondar((limiteInferior + limiteSuperior)/2);
            tabela.get(j).add(limiteInferior);              // Index: 0 Limite Inferior
            tabela.get(j).add(limiteSuperior);              // Index: 1 Limite Superior
            tabela.get(j).add((double) frequencia);         // Index: 2 Frequência
            frequenciaAgrupada += tabela.get(j).get(2);
            tabela.get(j).add(frequenciaAgrupada);          // Index: 3 Frequência Agrupada
            tabela.get(j).add(pontoMedio);                  // Index: 4 Ponto Médio
            j++;
        }

        this.tabela = tabela;
    }



    // ----------------------------- MÉTODOS GETTERS ----------------------------- //

    public Double getAmplitudeClasse() {
        return amplitudeClasse;
    }
    public void setAmplitudeClasse(Double amplitudeClasse) {
        this.amplitudeClasse = amplitudeClasse;
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

    public double getFrequenciaTotal() {
        return this.frequenciaTotal;
    }

}

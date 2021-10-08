package projeto;

import java.util.ArrayList;

public class DadosBrutos extends Leitura {
    private double media;
    private double mediana;
    private double variancia;
    private double coeficienteVariacao;
    private double desvioPadrao;
    private ArrayList<Double> moda;

    public DadosBrutos() {
        this.criarLista();
        this.fazerMedia(getLista());
        this.fazerMediana(getLista());
        this.fazerModa(getLista());
        this.fazerVariancia(getLista());
        this.fazerDesvioPadrao(this.getVariancia());
        this.fazerCoeficienteVariacao(getDesvioPadrao(), getMedia());
    }

    private void fazerMedia(ArrayList<Double> lista) {
        double somaTotal = 0.0D;

        for (int i = 0; i < lista.size(); ++i) {
            somaTotal = somaTotal + lista.get(i);
        }
        this.setMedia(somaTotal / (double) lista.size());
    }


    public double getMedia() {
        return this.media;
    }
    public void setMedia(double newMedia) {
        this.media = newMedia;
    }


    private void fazerMediana(ArrayList<Double> lista) {
        Double mediana;
        if (lista.size() % 2 != 0) {
            mediana = lista.get(lista.size() / 2);
        } else {
            mediana = lista.get((lista.size() - 1) / 2) + (lista.get((lista.size() - 1) / 2) + 1.0D) / 2.0D;
        }

        this.setMediana(mediana);
    }

    private void fazerModa(ArrayList<Double> lista) {
        ArrayList moda = new ArrayList();
        Double maiorScore = 0.0D;

        for (int i = 0; i < lista.size() - 1; ++i) {
            if (lista.get(i).equals(lista.get(i + 1))) {
                Double score = 1.0D;
                Double num = lista.get(i);

                while (lista.get(i).equals(lista.get(i + 1)) && i + 1 < lista.size() - 1) {
                    ++i;
                    score = score + 1.0D;
                    if (i + 1 == lista.size() - 1 && lista.get(i).equals(lista.get(i + 1))) {
                        score = score + 1.0D;
                        break;
                    }
                }

                if (score >= maiorScore) {
                    if (!score.equals(maiorScore)) {
                        moda.clear();
                    }

                    moda.add(num);
                    maiorScore = score;
                }
            }
        }

        moda.add(maiorScore);
        this.setModa(moda);
    }

    private void fazerVariancia(ArrayList<Double> lista) {
        double variancia = 0.0D;

        for (int i = 0; i < lista.size(); ++i) {
            double fator = lista.get(i) - this.media;
            variancia += Math.pow(fator, 2.0D);
        }
        variancia /= lista.size();
        this.setVariancia(variancia);
    }

    private void fazerDesvioPadrao(double variancia) {
        this.setDesvioPadrao(Math.sqrt(variancia));
    }

    private void fazerCoeficienteVariacao(double desvioPadrao, double media) {
        this.setCoeficienteVariacao(desvioPadrao / media * 100.0D);
    }

    /*
    -------------------------------------------------------------------------------------------------
     */

    public double getMediana() {
        return this.mediana;
    }

    public void setMediana(double newMediana) {
        this.mediana = newMediana;
    }

    public ArrayList<Double> getModa() {
        return this.moda;
    }

    public void setModa(ArrayList<Double> newModa) {
        this.moda = newModa;
    }

    public double getVariancia() {
        return this.variancia;
    }

    public void setVariancia(double newVariancia) {
        this.variancia = newVariancia;
    }

    public double getDesvioPadrao() {
        return this.desvioPadrao;
    }

    public void setDesvioPadrao(double newDesvioPadrao) {
        this.desvioPadrao = newDesvioPadrao;
    }

    public double getCoeficienteVariacao() {
        return this.coeficienteVariacao;
    }

    public void setCoeficienteVariacao(double newCoeficienteVariacao) {
        this.coeficienteVariacao = newCoeficienteVariacao;
    }

}

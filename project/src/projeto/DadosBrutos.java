package projeto;

import java.util.ArrayList;

public class DadosBrutos extends Leitura{
    private double media;
    private double mediana;
    private double variancia;
    private double coeficienteVariacao;
    private double desvioPadrao;
    ArrayList<Double> moda;

    public DadosBrutos() {
        this.criarLista();
        this.fazerMedia(getLista());
        this.fazerMediana(getLista());
        this.fazerModa(getLista());
        this.fazerVariancia(getLista());
        this.fazerDesvioPadrao(getVariancia());
        this.fazerCoeficienteVariacao(getDesvioPadrao(), getMedia());
    }

    private void fazerMedia(ArrayList<Double> v){
        double somaTotal = 0.0D;

        for(int i = 0; i < v.size(); ++i) {
            somaTotal = somaTotal + v.get(i);
        }
        this.setMedia(somaTotal / (double)v.size());
    }

    private void fazerMediana(ArrayList<Double> v) {
        Double mediana;
        if (v.size() % 2 != 0) {
            mediana = v.get(v.size() / 2);
        } else {
            mediana = v.get((v.size() - 1) / 2) + (v.get((v.size() - 1) / 2) + 1.0D) / 2.0D;
        }

        this.setMediana(mediana);
    }

    private void fazerModa(ArrayList<Double> v) {
        ArrayList list = new ArrayList();
        Double maiorScore = 0.0D;

        for(int i = 0; i < v.size() - 1; ++i) {
            if (v.get(i).equals(v.get(i + 1))) {
                Double score = 1.0D;
                Double num = v.get(i);

                while(v.get(i).equals(v.get(i + 1)) && i + 1 < v.size() - 1) {
                    ++i;
                    score = score + 1.0D;
                    if (i + 1 == v.size() - 1 && v.get(i).equals(v.get(i + 1))) {
                        score = score + 1.0D;
                        break;
                    }
                }

                if (score >= maiorScore) {
                    if (!score.equals(maiorScore)) {
                        list.clear();
                    }

                    list.add(num);
                    maiorScore = score;
                }
            }
        }

        list.add(maiorScore);
        this.setModa(list);
    }

    private void fazerVariancia(ArrayList<Double> v){
        double variancia = 0.0D;

        for(int i = 0; i < v.size(); ++i) {
            double fator = v.get(i) - this.media;
            variancia += Math.pow(fator, 2.0D);
            variancia /= v.size();
        }

        this.setVariancia(variancia);
    }

    private void fazerDesvioPadrao(double variancia){
        this.setVariancia(Math.sqrt(variancia));
    }

    private void fazerCoeficienteVariacao(double desvioPadrao, double media){
        this.setCoeficienteVariacao(desvioPadrao / media * 100.0D);
    }

    /*
    -------------------------------------------------------------------------------------------------
     */

    public double getMedia(){
        return this.media;
    }
    public void setMedia(double newMedia){
        this.media = newMedia;
    }
    public double getMediana() {
        return this.mediana;
    }
    public void setMediana(double newMediana){
        this.mediana = newMediana;
    }
    public ArrayList<Double> getModa() {
        return this.moda;
    }
    public void setModa(ArrayList<Double> newModa){
        this.moda = newModa;
    }
    public double getVariancia(){
        return this.variancia;
    }
    public void setVariancia(double newVariancia){
        this.variancia = newVariancia;
    }
    public double getDesvioPadrao(){
        return this.desvioPadrao;
    }
    public void setDesvioPadrao(double newDesvioPadrao){
        this.desvioPadrao = newDesvioPadrao;
    }
    public double getCoeficienteVariacao(){
        return this.coeficienteVariacao;
    }
    public void setCoeficienteVariacao(double newCoeficienteVariacao){
        this.coeficienteVariacao = newCoeficienteVariacao;
    }

}

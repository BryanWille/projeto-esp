package projeto;

import java.util.ArrayList;

public class DadosBrutos extends Configuracoes{


    // ----------------------------- ATRIBUTOS ----------------------------- //

    private Leitura leitor = new Leitura();
    private double media;
    private double mediana;
    private double variancia;
    private double coeficienteVariacao;
    private double desvioPadrao;
    private ArrayList<Double> moda;


    // ----------------------------- CONSTRUTOR ----------------------------- //


    public DadosBrutos() {
        super();

        leitor.criarLista();
        this.calcularMedia(leitor.getLista());
        this.calcularMediana(leitor.getLista());
        this.calcularModa(leitor.getLista());
        this.calcularVariancia(leitor.getLista());
        this.calcularDesvioPadrao(this.getVariancia());
        this.calcularCoeficienteVariacao(this.getDesvioPadrao(), this.getMedia());
    }


    // ----------------------------- METODOS CALCULADORA ----------------------------- //


    private void calcularMedia(ArrayList<Double> lista) {
        double somaTotal = 0.0D;

        for (int i = 0; i < lista.size(); ++i) {
            somaTotal = somaTotal + lista.get(i);
        }
        double media = (somaTotal / (double) lista.size());
        this.media = this.arredondar(media);
    }

    private void calcularMediana(ArrayList<Double> lista) {
        Double mediana;
        if (lista.size() % 2 != 0) {
            mediana = lista.get(lista.size() / 2);
        } else {
            mediana = lista.get((lista.size() - 1) / 2) + (lista.get((lista.size() - 1) / 2) + 1.0D) / 2.0D;
        }

        this.mediana = this.arredondar(mediana);
    }

    private void calcularModa(ArrayList<Double> lista) {
        ArrayList<Double> moda = new ArrayList<Double>();
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
        this.moda = (moda);
    }

    private void calcularVariancia(ArrayList<Double> lista) {
        double variancia = 0.0D;

        for (int i = 0; i < lista.size(); ++i) {
            double fator = lista.get(i) - this.media;
            variancia += Math.pow(fator, 2.0D);
        }
        variancia /= lista.size() - 1;
        this.variancia = this.arredondar(variancia);
    }

    private void calcularDesvioPadrao(double variancia) {
        this.desvioPadrao = this.arredondar(Math.sqrt(variancia));
    }

    private void calcularCoeficienteVariacao(double desvioPadrao, double media) {
        this.coeficienteVariacao = this.arredondar(desvioPadrao / media * 100.0D);
    }



    // ----------------------------- METODOS GETTERS ----------------------------- //


    public double getMedia() {
        return this.media;
    }

    public double getMediana() {
        return this.mediana;
    }

    public ArrayList<Double> getModa() {
        return this.moda;
    }

    public double getVariancia() {
        return this.variancia;
    }

    public double getDesvioPadrao() {
        return this.desvioPadrao;
    }

    public double getCoeficienteVariacao() {
        return this.coeficienteVariacao;
    }


}

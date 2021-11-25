package projeto;

import java.util.ArrayList;

public class DadosAgrupados {

    // ----------------------------- ATRIBUTOS ----------------------------- //

    private static int indexRoundClasse;
    private static int indexRound;
    private Leitura leitor = new Leitura();
    private Double K;
    private Double amplitude;
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

    public DadosAgrupados(){
        this(2);
    }

    public DadosAgrupados(int arredondamento) {

        leitor.criarLista();
        this.setIndexRound(arredondamento);
        this.fazerAmplitudeClasse(leitor.getLista());
        this.fazerTabela(leitor.getLista(), this.getAmplitudeClasse());

        this.calcularFrequenciaTotal(this.getTabela());

        this.calcularMedia(this.getTabela());
        this.calcularMediana(this.getTabela());
        this.calcularModa(this.getTabela());

        this.calcularVariancia(this.getTabela(), this.getMedia());
        this.calcularDesvioPadrao(this.getVariancia());
        this.calcularCoeficienteVariacao(this.getDesvioPadrao(), this.getMedia());

        this.calcularSeparatriz(100, 90);
    }

    public DadosAgrupados(int arredondamento, int arredondamentoClasse) {

        leitor.criarLista();
        this.setIndexRound(arredondamento);
        this.setIndexRoundClasse(arredondamentoClasse);
        this.fazerAmplitudeClasse(leitor.getLista());
        this.fazerTabela(leitor.getLista(), this.getAmplitudeClasse());

        this.calcularFrequenciaTotal(this.getTabela());

        this.calcularMedia(this.getTabela());
        this.calcularMediana(this.getTabela());
        this.calcularModa(this.getTabela());

        this.calcularVariancia(this.getTabela(), this.getMedia());
        this.calcularDesvioPadrao(this.getVariancia());
        this.calcularCoeficienteVariacao(this.getDesvioPadrao(), this.getMedia());

        this.calcularSeparatriz(100, 90);
    }

    // ----------------------------- METODOS CALCULOS -----------------------------
    // //
    public Object calcularSeparatriz(int separatriz, int index) {
        Object sep;
        if (separatriz == 10 || separatriz == 100 || separatriz == 4) {
            if (separatriz == 4 && (index < 1 || index > 4)) {
                sep = "Quartil invalido!";
            } else if (separatriz == 100 && (index < 1 || index > 100)) {
                sep = "Percentil invalido!";
            } else if (separatriz == 10 && (index < 1 || index > 10)) {
                sep = "Decil invalido!";
            } else {
                double amplitude, limiteInferior = 0, frequenciaAnterior = 0, frequenciaAtual = 0;
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
                double resultado = this.arredondar((limiteInferior + ((acharClasse - frequenciaAnterior) / frequenciaAtual) * amplitude));
                this.separatriz = resultado;
                sep = resultado;
            }
        } else {
            sep = "Erro: Separatriz Selecionada e Invalida!";
        }
        return sep;
    }

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
        double mediana = 0, fAgrClaAnt = 0, freqMediana = tabela.get(0).get(2), limiteInferior = tabela.get(0).get(0);
        double freqMeioDouble = this.getFrequenciaTotal()/2;
        int frequenciaMeio = (int) Math.floor(this.getFrequenciaTotal() / 2);
        for(int i = 1; i < tabela.size(); i++) {
            if (frequenciaMeio > tabela.get(i-1).get(3) && frequenciaMeio < tabela.get(i).get(3)) {
                freqMediana = tabela.get(i).get(2);
                fAgrClaAnt = tabela.get(i - 1).get(3);;
                limiteInferior = tabela.get(i).get(0);
            }
        }
        mediana = limiteInferior + ( ( freqMeioDouble - fAgrClaAnt) / freqMediana ) * this.getAmplitudeClasse();
        this.mediana = this.arredondar(mediana);
    }

    private void calcularModa(ArrayList<ArrayList<Double>> tabela) {
        Double moda, freqMaior = 0.0, limInfModa = 0.0, difFreq1 = 0.0, difFreq2 = 0.0;

        for (int i = 0; i < tabela.size(); i++) {
            if (tabela.get(i).get(2) > freqMaior) { //Vai procurar a classe modal (a que tem maior frequencia)
                freqMaior = tabela.get(i).get(2);
                limInfModa = tabela.get(i).get(0);
                if (i + 1 < tabela.size() - 1 && i - 1 > 0) { //se i+1 for menor que a tabela
                    difFreq1 = tabela.get(i).get(2);
                    difFreq2 = tabela.get(i).get(2);
                } else if (i == 0){
                    difFreq1 = tabela.get(i).get(2);
                    difFreq2 = tabela.get(i).get(2) - tabela.get(i+1).get(2);
                } else if (i+1 == tabela.size()){
                    difFreq1 = tabela.get(i).get(2) - tabela.get(i-1).get(2);
                    difFreq2 = tabela.get(i).get(2);
                }
            }
        }

        moda = limInfModa + ( (difFreq1 / (difFreq1 + difFreq2)) * this.getAmplitudeClasse() );
        this.moda = this.arredondar(moda);
    }

    private void calcularVariancia(ArrayList<ArrayList<Double>> tabela, Double media) {
        Double somatorio = 0.0;
        for (int i = 0; i < tabela.size(); i++) {
            somatorio += Math.pow((tabela.get(i).get(4) - media), 2) * getTabela().get(i).get(2);
        }
        Double variancia = somatorio / (leitor.getLista().size() - 1);
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


    private void calcularFrequenciaTotal(ArrayList<ArrayList<Double>> tabela) {
        this.frequenciaTotal = tabela.get(tabela.size() - 1).get(3);
    }

    // ----------------------------- METODOS TABELA ----------------------------- //

    public Object[][] converterLista(ArrayList<ArrayList<Double>> tabela) {
        Object[][] matriz = new Object[tabela.size()][5];
        for (int i = 0; i < tabela.size(); i++) {
            matriz[i][0] = i+1;
            for (int j = 0; j < 1; j++) {
                Object distribuicao = arredondamentoClasse(tabela.get(i).get(j)) + " |-- "
                        + arredondamentoClasse(tabela.get(i).get(j + 1));
                matriz[i][1] = distribuicao; // Distribuicao De Frequencia
                matriz[i][2] = tabela.get(i).get(2); // Frequencia
            }
            matriz[i][3] = tabela.get(i).get(3); // Frequencia Agrupada
            matriz[i][4] = tabela.get(i).get(4); // Ponto Medio
        }
        return matriz;
    }

    private void fazerAmplitudeClasse(ArrayList<Double> lista) {
        int maiorCasaDecimal = 0;
        for (int i = 0; i < lista.size(); i++) {
                String converter = String.valueOf(lista.get(i));
                int index = converter.indexOf('.');
                int casaDecimal = (converter.length() - 1) - index;
                if (casaDecimal > maiorCasaDecimal) {
                    maiorCasaDecimal = casaDecimal;
                }
        }
        this.setIndexRoundClasse(maiorCasaDecimal);
        double amplitudeTotal, raizAmostra, a;
        amplitudeTotal = lista.get(lista.size() - 1) - lista.get(0);
        raizAmostra = Math.sqrt(lista.size());
        this.setK(raizAmostra);
        this.setAmplitude(amplitudeTotal);
        a = this.arredondamentoClasse(amplitudeTotal / raizAmostra);
        this.setAmplitudeClasse(a);
    }

    private void fazerTabela(ArrayList<Double> lista, Double distriContinua) {
        ArrayList<ArrayList<Double>> tabela = new ArrayList<>();
        int i = 0, frequencia, j = 0;
        double limiteSuperior = lista.get(0), limiteInferior, frequenciaAgrupada = 0;
        ;
        while (limiteSuperior < lista.get(lista.size() - 1)) {
            tabela.add(new ArrayList<Double>());
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
            double pontoMedio = this.arredondar((limiteInferior + limiteSuperior) / 2);
            tabela.get(j).add(limiteInferior); // Index: 0 Limite Inferior
            tabela.get(j).add(limiteSuperior); // Index: 1 Limite Superior
            tabela.get(j).add((double) frequencia); // Index: 2 Frequencia
            frequenciaAgrupada += tabela.get(j).get(2);
            tabela.get(j).add(frequenciaAgrupada); // Index: 3 Frequencia Agrupada
            tabela.get(j).add(pontoMedio); // Index: 4 Ponto Medio
            j++;
        }
        this.frequenciaTotal = frequenciaAgrupada;

        this.tabela = tabela;
    }

    // ----------------------------- METODOS GETTERS ---------------------------- //

    public double arredondamentoClasse(double numero){
        double decimal = Math.pow(10, this.getIndexRoundClasse());
        return Math.round(numero * decimal) / decimal;
    }

    public double arredondar(double numero){
        double decimal = Math.pow(10, this.getIndexRound());
        return Math.round(numero * decimal) / decimal;
    }

    public static int getIndexRoundClasse() {
        return indexRoundClasse;
    }

    public static void setIndexRoundClasse(int newIndexRoundClasse) {
        indexRoundClasse = newIndexRoundClasse;
    }

    public static int getIndexRound() {
        return indexRound;
    }

    public static void setIndexRound(int newIndexRound) {
        indexRound = newIndexRound;
    }

    public Double getAmplitudeClasse() {
        return amplitudeClasse;
    }

    public void setAmplitudeClasse(Double amplitudeClasse) {
        this.amplitudeClasse = amplitudeClasse;
    }

    public ArrayList<ArrayList<Double>> getTabela() {
        return tabela;
    }


    public Double getK() {
        return K;
    }

    public void setK(Double k) {
        K = this.arredondar(k);
    }

    public Double getAmplitude() {
        return amplitude;
    }

    public void setAmplitude(Double amplitude) {
        this.amplitude = this.arredondar(amplitude);
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

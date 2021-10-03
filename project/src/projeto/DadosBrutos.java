package projeto;

import java.util.*;

public class DadosBrutos extends Leitura{
    private Double media;
    private Double mediana;
    private Double variancia;
    private Double coeficienteVariacao;
    private Double desvioPadrao;
    ArrayList<Double> moda;

    public DadosBrutos(){
        this.setLista();
        this.setMedia(this.getLista());
        this.setMediana(this.getLista());
        this.setModa(this.getLista());
        this.setVariancia(this.getLista());
        this.setDesvioPadrao(this.getVariancia());
        this.setCoeficienteVariacao(this.getDesvioPadrao(), this.getMedia());
    }

    public Double getMedia(){
        return this.media;
    }
    public void setMedia(ArrayList<Double> v) {
        Double somaTotal = 0.0;
        for (int i = 0; i < v.size(); i++) {
            somaTotal += v.get(i);
        }
        this.media = somaTotal / v.size();
    }


    public Double getMediana(){return this.mediana;}
    public void setMediana(ArrayList<Double> v) {
        Double mediana;
        if (v.size() % 2 != 0) {
            mediana = v.get(v.size() / 2);
        } else {
            mediana = v.get((v.size() - 1) / 2) + ((v.get((v.size() - 1) / 2) + 1) / 2);
        }
        this.mediana = mediana;
    }


    public ArrayList<Double> getModa(){
        return this.moda;
    }
    public void setModa(ArrayList<Double> v) {
        ArrayList<Double> list = new ArrayList<>();
        Double maiorScore = 0.0, score;
        for (int i = 0; i < v.size() - 1; i++) {                                        //Loop por até o penúltimo elemnto
            if (v.get(i).equals(v.get(i + 1))) {                                        //Checa se o elemento i é igual a i + 1
                score = 1.0;
                Double num = v.get(i);
                while (v.get(i).equals(v.get(i + 1)) && (i + 1) < v.size() - 1) {       //Loop enquanto for igual e menor que o último
                    i += 1;
                    score += 1;

                    if ((i + 1) == (v.size() - 1) && v.get(i).equals(v.get(i + 1))) {   //Se for o último elemento e for igual ao penultimo
                        score += 1;
                        break;                                                          //Quebra o Loop para não repetir
                    }
                }
                if (score >= maiorScore) {                                              //Checagem do Maior Score
                    if (!score.equals(maiorScore)) {                                    //Se o score for diferente (então vai ser maior)
                        list.clear();                                                   //Resetamos a lista (pra retirar o elemento)
                    }
                    list.add(num);                                                      //Adiciona o novo elemento (ou o outro elemento que é igual maior)
                    maiorScore = score;                                                 //Adiciona o maior Score
                }
            }
        }
        list.add(maiorScore);                                                           //O último elemento da lista é quantidade de vezes que repete a moda
        this.moda = list;
    }

    public Double getVariancia(){
        return this.variancia;
    }
    public void setVariancia(ArrayList<Double> v) {
        double variancia = 0, fator;
        for (int i = 0; i < v.size(); i++) {
            fator = v.get(i) - media;
            variancia += Math.pow(fator, 2);
            variancia = variancia / v.size();
        }
        this.variancia = variancia;
    }


    public Double getDesvioPadrao(){
        return this.desvioPadrao;
    }
    public void setDesvioPadrao(double variancia) {
        this.desvioPadrao = Math.sqrt(variancia);
    }

    public Double getCoeficienteVariacao(){
        return this.coeficienteVariacao;
    }
    public void setCoeficienteVariacao(double desvioPadrao, double media) {
        this.coeficienteVariacao = (desvioPadrao / media) * 100;
    }
}
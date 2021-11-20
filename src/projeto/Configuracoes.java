package projeto;

public class Configuracoes {
    private int arredondamento;
    private int arredondamentoClasse;

    public Configuracoes(){
        this(2);
    }

    public Configuracoes(int arredondamento){
        this.setArredondamento(arredondamento);
        this.setArredondamentoClasse(arredondamento);
    }

    public double arredondar(double numero){
        double decimal = Math.pow(10, this.getArredondamento());
        return Math.round(numero * decimal) / decimal;
    }

    public double arredondamentoClasse(double numero){
        double decimal = Math.pow(10, this.getArredondamentoClasse());
        return Math.round(numero * decimal) / decimal;
    }


    public int getArredondamentoClasse() {
        return arredondamentoClasse;
    }
    public void setArredondamentoClasse(int arredondamentoClasse) {
        this.arredondamentoClasse = arredondamentoClasse;
    }

    public int getArredondamento(){return this.arredondamento;}
    public void setArredondamento(int arredondamento){
        this.arredondamento = arredondamento;
    }
}

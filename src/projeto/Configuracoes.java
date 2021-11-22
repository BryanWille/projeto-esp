package projeto;

public class Configuracoes {
    private static int arredondamento;
    private static int arredondamentoClasse;

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
    public static void setArredondamentoClasse(int newArredondamentoClasse) {
        arredondamentoClasse = newArredondamentoClasse;
    }

    public int getArredondamento(){return this.arredondamento;}
    public static void setArredondamento(int newArredondamento){
        arredondamento = newArredondamento;
    }
}
